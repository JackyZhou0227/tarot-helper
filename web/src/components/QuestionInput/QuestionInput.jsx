import React from 'react';
import { motion } from 'framer-motion';
import { Sparkles } from 'lucide-react';
import './QuestionInput.css';

const QuestionInput = ({ question, setQuestion, onDrawCards, isLoading }) => {
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
        <textarea
          className="question-textarea"
          rows="4"
          placeholder="例如：我在感情方面的发展如何？我的事业前景怎样？..."
          value={question}
          onChange={(e) => setQuestion(e.target.value)}
        />
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