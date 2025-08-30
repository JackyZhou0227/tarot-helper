import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { tarotNameMap } from '../../constants/tarotCards';
import { getCardImagePath, DEFAULT_SKIN } from '../../constants/tarotSkins';
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
  
  const cardName = tarotNameMap[card.tarot] || card.tarot;
  const positionText = card.upright ? '正位' : '逆位';
  
  return (
    <div className="tarot-card-name-container">
      {showName && (
        <motion.div
          className="tarot-card-info-below"
          initial={{ opacity: 0, y: 10 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.5 }}
        >
          <div className="card-name-below">{cardName}</div>
          <div className="card-position-below">{positionText}</div>
        </motion.div>
      )}
    </div>
  );
};

// 塔罗牌组件
const TarotCard = ({ card, isRevealed, onClick, position }) => {
  return (
    <div className="tarot-card-container">
      <motion.div
        className="tarot-card-simple"
        onClick={onClick}
        whileTap={{ scale: 0.95 }}
        initial={{ opacity: 0, y: 50 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6, delay: position * 0.2 }}
        style={{
          animationDelay: `${position * -1.5}s` // 为不同位置的卡牌设置不同的浮动动画延迟
        }}
      >
        <motion.div
          className="card-flip-container"
          animate={{ rotateY: isRevealed ? 180 : 0 }}
          transition={{ duration: 0.6, ease: "easeInOut" }}
        >
          {/* 卡牌背面 */}
          <div className="card-side card-back-simple">
            <div className="mystical-pattern">
              <div className="pattern-circle">
                <div className="inner-circle">
                  <div className="center-star">✦</div>
                </div>
              </div>
            </div>
          </div>
          
          {/* 卡牌正面 - 直接显示图片 */}
          <div className="card-side card-front-simple">
            <img 
              src={getCardImagePath(card.tarot, DEFAULT_SKIN)}
              alt={tarotNameMap[card.tarot] || card.tarot}
              className={`tarot-card-image ${!card.upright ? 'reversed' : ''}`}
              onError={(e) => {
                // 如果图片加载失败，显示备用符号
                e.target.style.display = 'none';
                e.target.nextSibling.style.display = 'flex';
              }}
            />
            <div className="tarot-symbol-fallback" style={{display: 'none'}}>
              {card.upright ? '🔮' : '🌙'}
            </div>
          </div>
        </motion.div>
      </motion.div>
      
      {/* 卡牌名称 */}
      <TarotCardName card={card} isRevealed={isRevealed} position={position} />
    </div>
  );
};

export default TarotCard;