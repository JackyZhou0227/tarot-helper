import React from 'react';
import { motion } from 'framer-motion';
import { tarotNameMap } from '../../constants/tarotCards';
import { getTarotImagePath } from '../../utils/tarotImages';
import './TarotCard.css';

// 塔罗牌组件
const TarotCard = ({ card, isRevealed, onClick, position }) => {
  const cardName = tarotNameMap[card.tarot] || card.tarot;
  const positionText = card.isUpright ? '正位' : '逆位';

  return (
    <motion.div
      className="tarot-card-container"
      onClick={onClick}
      initial={{ opacity: 0, y: 50 }}
      animate={{ 
        opacity: 1, 
        y: 0
      }}
      transition={{ duration: 0.6, delay: position * 0.2 }}
    >
      {/* 卡牌图片区域 */}
      <motion.div
        className="tarot-card"
        whileHover={{ scale: 1.05, y: -5 }}
        whileTap={{ scale: 0.95 }}
        // 简化翻牌动画逻辑
        animate={{ 
          rotateY: isRevealed ? 180 : 0,
          // 翻转完成后添加上下浮动动画
          y: isRevealed ? [0, -8, 0] : 0
        }}
        transition={{
          rotateY: { duration: 0.8, ease: "easeInOut" },
          y: isRevealed ? {
            duration: 3,
            repeat: Infinity,
            ease: "easeInOut"
          } : { duration: 0.8, ease: "easeInOut" }
        }}
        style={{ 
          transformStyle: "preserve-3d"
        }}
      >
        {/* 卡背 */}
        <motion.div 
          className="card-face card-back"
          style={{ 
            backfaceVisibility: "hidden"
          }}
        >
          <div className="mystical-pattern">
            <div className="pattern-circle">
              <div className="inner-circle">
                <div className="center-star">✦</div>
              </div>
            </div>
          </div>
        </motion.div>
        
        {/* 卡牌正面 */}
        <motion.div 
          className="card-face card-front"
          style={{ 
            backfaceVisibility: "hidden"
          }}
        >
          <div className="card-image-container">
            <img 
              src={getTarotImagePath(card.tarot)} 
              alt={cardName}
              className={`tarot-card-image ${!card.isUpright ? 'reversed' : ''}`}
              onError={(e) => {
                // 如果图片加载失败，显示备用符号
                e.target.style.display = 'none';
                e.target.nextSibling.style.display = 'flex';
              }}
            />
            <div className="tarot-symbol-fallback" style={{display: 'none'}}>
              {card.isUpright ? '🔮' : '🌙'}
            </div>
          </div>
        </motion.div>
      </motion.div>
      
      {/* 卡牌名称区域 */}
      {isRevealed && (
        <motion.div
          className="tarot-card-info"
          initial={{ opacity: 0, y: 10 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.5, delay: 0.8 }}
        >
          <div className="card-name">{cardName}</div>
          <div className="card-position">{positionText}</div>
        </motion.div>
      )}
    </motion.div>
  );
};

export default TarotCard;