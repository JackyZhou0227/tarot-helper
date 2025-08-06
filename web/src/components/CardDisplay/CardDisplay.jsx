import React from 'react';
import { motion } from 'framer-motion';
import TarotCard from '../TarotCard/TarotCard';
import './CardDisplay.css';

const CardDisplay = ({ drawnCards, revealedCards, question }) => {
  if (!drawnCards.length) {
    return null;
  }

  return (
    <div className="card-display-container">
      {/* 显示抽取的卡牌 */}
      <motion.div
        className="cards-section"
        initial={{ opacity: 0, y: 50 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.8 }}
      >
        <h2 className="cards-title">
          您的塔罗牌阵
        </h2>
        
        <div className="cards-grid">
          {drawnCards.map((card, index) => (
            <div key={index} className="card-wrapper">
              <TarotCard
                card={card}
                isRevealed={revealedCards.includes(index)}
                position={index}
              />
            </div>
          ))}
        </div>
        
        <div className="question-display">
          问题：{question}
        </div>
      </motion.div>
      

    </div>
  );
};

export default CardDisplay;