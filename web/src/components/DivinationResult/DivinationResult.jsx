import React from 'react';
import { motion } from 'framer-motion';
import ReactMarkdown from 'react-markdown';
import './DivinationResult.css';

const DivinationResult = ({ isLoading, isStreaming, result, streamingResult }) => {
  if (!isLoading && !isStreaming && !result) {
    return null;
  }

  return (
    <motion.div
      className="divination-result-card"
      initial={{ opacity: 0, y: 50 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.8 }}
    >
      <div className="result-header">
        <h2 className="result-title">
          占卜结果
        </h2>
      </div>
      
      {isLoading && !isStreaming && (
        <div className="loading-container">
          <p className="loading-text">AI正在为您解读塔罗牌...</p>
        </div>
      )}
      
      {(isStreaming || result) && (
        <div className="result-content">
          <ReactMarkdown>{isStreaming ? streamingResult : result}</ReactMarkdown>
        </div>
      )}
    </motion.div>
  );
};

export default DivinationResult;