import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { Sparkles } from 'lucide-react';
import './QuestionInput.css';

const QuestionInput = ({ question, setQuestion, onDrawCards, isLoading }) => {
  // 提示词数组，可以随时添加或删除
  const placeholderQuestions = [
    "我在感情方面的发展如何？",
    "我的事业前景怎样？",
    "我今天的运势怎么样？"
  ];
  
  const [currentPlaceholderIndex, setCurrentPlaceholderIndex] = useState(0);
  const [displayedText, setDisplayedText] = useState('');
  const [isTyping, setIsTyping] = useState(true);
  
  useEffect(() => {
    const currentQuestion = placeholderQuestions[currentPlaceholderIndex];
    let charIndex = 0;
    setDisplayedText('');
    setIsTyping(true);
    
    const typeInterval = setInterval(() => {
      if (charIndex < currentQuestion.length) {
        setDisplayedText(currentQuestion.slice(0, charIndex + 1));
        charIndex++;
      } else {
        clearInterval(typeInterval);
        setIsTyping(false);
        
        // 显示完成后等待3.5秒再切换到下一个问题
        setTimeout(() => {
          setCurrentPlaceholderIndex((prevIndex) => 
            (prevIndex + 1) % placeholderQuestions.length
          );
        }, 3500);
      }
    }, 80); // 每个字符间隔80ms，适中的打字速度
    
    return () => clearInterval(typeInterval);
  }, [currentPlaceholderIndex]); // 移除placeholderQuestions依赖，避免无限循环

  const handleKeyDown = (e) => {
    if (e.key === 'Enter' && !e.shiftKey) {
      e.preventDefault();
      if (question.trim() && !isLoading) {
        onDrawCards();
      }
    }
  };

  return (
    <motion.div
      className="question-input-container"
      initial={{ opacity: 0, y: 50 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.8 }}
    >
      <div className="question-form">
        <label className="question-label">
          请输入您想要占卜的问题：
        </label>
        <div className="textarea-container">
           <textarea
             className="question-textarea"
             rows="4"
             placeholder=" " // 空占位符，使用自定义显示
             value={question}
             onChange={(e) => setQuestion(e.target.value)}
             onKeyDown={handleKeyDown}
           />
           {!question && (
             <div className="typing-placeholder">
               {displayedText}
             </div>
           )}
         </div>
      </div>
      
      <div className="action-container">
        <motion.button
          className="divination-button"
          onClick={onDrawCards}
          whileHover={{ scale: 1.05 }}
          whileTap={{ scale: 0.95 }}
          disabled={isLoading}
        >
          <Sparkles className="button-icon left" size={20} />
          开始占卜
          <Sparkles className="button-icon right" size={20} />
        </motion.button>
      </div>
    </motion.div>
  );
};

export default QuestionInput;