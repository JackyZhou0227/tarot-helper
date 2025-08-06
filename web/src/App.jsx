import React, { useState } from 'react';
import { motion } from 'framer-motion';
import { Moon, Star } from 'lucide-react';
import './App.css';

// 导入组件
import StarField from './components/StarField/StarField';
import QuestionInput from './components/QuestionInput/QuestionInput';
import CardDisplay from './components/CardDisplay/CardDisplay';
import DivinationResult from './components/DivinationResult/DivinationResult';

// 导入服务和工具
import { getBasicCards, performDivination } from './services/tarotApi';
import { delay, validateQuestion } from './utils/cardUtils';





function App() {
  const [question, setQuestion] = useState('');
  const [drawnCards, setDrawnCards] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [result, setResult] = useState('');
  const [showCards, setShowCards] = useState(false);
  const [revealedCards, setRevealedCards] = useState([]);
  const [isStreaming, setIsStreaming] = useState(false);
  const [streamingResult, setStreamingResult] = useState('');

  // 抽取塔罗牌
  const drawCards = async () => {
    // 验证问题输入
    const validation = validateQuestion(question);
    if (!validation.isValid) {
      alert(validation.message);
      return;
    }

    setIsLoading(true);
    setResult('');
    setShowCards(true);
    setRevealedCards([]);
    setStreamingResult('');

    try {
      // 调用API获取卡牌
      const backendCards = await getBasicCards();
      
      // 将后端返回的卡牌转换为前端显示格式
      const selectedCards = backendCards.map(card => ({
        tarot: card.tarot,
        upright: card.upright
      }));
      
      setDrawnCards(selectedCards);
      
      // 逐个翻开卡牌
      selectedCards.forEach((_, index) => {
        setTimeout(() => {
          setRevealedCards(prev => [...prev, index]);
        }, 1000 + index * 800);
      });
      
      // 等待所有卡牌翻转完成后调用占卜API
      setTimeout(async () => {
        try {
          // 保持loading状态，显示等待提示
          // setIsLoading(true); // 已经在开始时设置了
          
          // 短暂延迟后开始流式输出
          setTimeout(() => {
            setIsStreaming(true);
            setIsLoading(false); // 开始流式输出时取消loading状态
          }, 1000);
          
          const result = await performDivination(
            question,
            backendCards,
            (streamData) => {
              setStreamingResult(streamData);
            }
          );
          
          setResult(result);
          setIsStreaming(false);
        } catch (error) {
          console.error('占卜失败:', error);
          setResult('占卜过程中出现了问题，请稍后再试。');
          setIsStreaming(false);
          setIsLoading(false);
        }
      }, 4000);
      
    } catch (error) {
      console.error('抽卡失败:', error);
      setResult('抽卡过程中出现了问题，请稍后再试。');
      setIsLoading(false);
      setShowCards(false);
    }
  };

  // 重新开始
  const resetDivination = () => {
    setQuestion('');
    setDrawnCards([]);
    setResult('');
    setShowCards(false);
    setRevealedCards([]);
    setIsLoading(false);
    setIsStreaming(false);
    setStreamingResult('');
  };

  return (
    <div className="App">
      <StarField />
      
      <motion.div
        initial={{ opacity: 0, y: -50 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 1 }}
      >
        <h1 className="mystical-title">
          <Moon className="inline mr-4" size={48} />
          AI塔罗占卜
          <Star className="inline ml-4" size={48} />
        </h1>
      </motion.div>

      <motion.div
        className="container mx-auto px-4 max-w-4xl"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 1, delay: 0.5 }}
      >
        {!showCards ? (
          <QuestionInput
            question={question}
            setQuestion={setQuestion}
            onDrawCards={drawCards}
            isLoading={isLoading}
          />
        ) : (
          <div>
            <CardDisplay
              drawnCards={drawnCards}
              revealedCards={revealedCards}
              question={question}
            />
            
            <DivinationResult
              isLoading={isLoading}
              isStreaming={isStreaming}
              result={result}
              streamingResult={streamingResult}
            />
            
            {result && !isLoading && !isStreaming && (
              <motion.div
                className="reset-container"
                initial={{ opacity: 0, y: 20 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ duration: 0.5, delay: 0.3 }}
              >
                <motion.button
                  className="reset-button"
                  onClick={resetDivination}
                  whileHover={{ scale: 1.05 }}
                  whileTap={{ scale: 0.95 }}
                >
                  重新开始
                </motion.button>
              </motion.div>
            )}
          </div>
        )}
      </motion.div>
    </div>
  );
}

export default App;
