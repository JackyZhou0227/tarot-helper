import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { tarotNameMap } from '../../constants/tarotCards';
import './TarotCard.css';

// 塔罗牌名称组件
const TarotCardName = ({ card, isRevealed, position }) => {
  const [showName, setShowName] = useState(false);
  
  // 当卡牌翻转后，延迟显示名称
  useEffect(() => {
    if (isRevealed) {
      const timer = setTimeout(() => {
        setShowName(true);
      }, 600); // 翻牌动画结束后再显示名称
      
      return () => clearTimeout(timer);
    } else {
      setShowName(false);
    }
  }, [isRevealed]);
  
  if (!showName) return null;
  
  const cardName = tarotNameMap[card.tarot] || card.tarot;
  const positionText = card.upright ? '正位' : '逆位';
  
  return (
    <motion.div
      className="tarot-card-name"
      initial={{ opacity: 0, y: 10 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.5 }}
    >
      <div className="card-name">{cardName}</div>
      <div className="card-position">{positionText}</div>
    </motion.div>
  );
};

// 塔罗牌组件
const TarotCard = ({ card, isRevealed, onClick, position }) => {
  return (
    <motion.div
      className="tarot-card"
      onClick={onClick}
      whileHover={{ scale: 1.05, y: -10 }}
      whileTap={{ scale: 0.95 }}
      initial={{ opacity: 0, y: 50 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.6, delay: position * 0.2 }}
    >
      <motion.div
        className="card-inner"
        animate={{ rotateY: isRevealed ? 180 : 0 }}
        transition={{ duration: 0.6, ease: "easeInOut" }}
      >
        {/* 卡牌背面 */}
        <div className="card-face card-back">
          <div className="card-back-content">
            <div className="mystical-pattern">
              <div className="pattern-circle">
                <div className="inner-circle">
                  <div className="center-star">✦</div>
                </div>
              </div>
            </div>
            <div className="card-border"></div>
          </div>
        </div>
        
        {/* 卡牌正面 */}
        <div className="card-face card-front">
          <div className="card-content">
            <div className="card-header">
              <h3 className="card-title">
                {tarotNameMap[card.tarot] || card.tarot}
              </h3>
            </div>
            <div className="card-image">
              <div className="tarot-symbol">
                {card.upright ? '🔮' : '🌙'}
              </div>
            </div>
            <div className="card-footer">
              <span className={`position-indicator ${card.upright ? 'upright' : 'reversed'}`}>
                {card.upright ? '正位' : '逆位'}
              </span>
            </div>
          </div>
        </div>
      </motion.div>
      
      {/* 卡牌名称 */}
      <TarotCardName card={card} isRevealed={isRevealed} position={position} />
    </motion.div>
  );
};

export default TarotCard;