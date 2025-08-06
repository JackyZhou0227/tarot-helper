import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { Moon, Star, Gem } from 'lucide-react';
import './StarField.css';

// 星星背景组件
const StarField = () => {
  const [stars, setStars] = useState([]);
  const [meteors, setMeteors] = useState([]);
  const [mysticSymbols, setMysticSymbols] = useState([]);

  useEffect(() => {
    const generateStars = () => {
      const newStars = [];
      for (let i = 0; i < 200; i++) {
        newStars.push({
          id: i,
          x: Math.random() * 100,
          y: Math.random() * 100,
          size: Math.random() * 3 + 1,
          opacity: Math.random() * 0.8 + 0.2,
          twinkleDelay: Math.random() * 5
        });
      }
      setStars(newStars);
    };

    const generateMeteors = () => {
      const newMeteors = [];
      for (let i = 0; i < 3; i++) {
        newMeteors.push({
          id: i,
          startX: Math.random() * 100,
          startY: Math.random() * 50,
          endX: Math.random() * 100,
          endY: Math.random() * 50 + 50,
          duration: Math.random() * 3 + 2,
          delay: Math.random() * 10
        });
      }
      setMeteors(newMeteors);
    };

    const generateMysticSymbols = () => {
      const symbols = [Moon, Star, Gem];
      const newSymbols = [];
      for (let i = 0; i < 8; i++) {
        newSymbols.push({
          id: i,
          Component: symbols[Math.floor(Math.random() * symbols.length)],
          x: Math.random() * 100,
          y: Math.random() * 100,
          duration: Math.random() * 4 + 3,
          delay: Math.random() * 8
        });
      }
      setMysticSymbols(newSymbols);
    };

    generateStars();
    generateMeteors();
    generateMysticSymbols();
  }, []);

  return (
    <div className="mystical-background">
      {/* 星星 */}
      <div className="stars">
        {stars.map(star => (
          <motion.div
            key={star.id}
            className="star"
            style={{
              left: `${star.x}%`,
              top: `${star.y}%`,
              width: `${star.size}px`,
              height: `${star.size}px`,
            }}
            animate={{
              opacity: [star.opacity, star.opacity * 0.3, star.opacity],
            }}
            transition={{
              duration: 2,
              delay: star.twinkleDelay,
              repeat: Infinity,
              ease: "easeInOut"
            }}
          />
        ))}
      </div>

      {/* 流星 */}
      <div className="meteors">
        {meteors.map(meteor => (
          <motion.div
            key={meteor.id}
            className="meteor"
            initial={{
              x: `${meteor.startX}vw`,
              y: `${meteor.startY}vh`,
              opacity: 0
            }}
            animate={{
              x: `${meteor.endX}vw`,
              y: `${meteor.endY}vh`,
              opacity: [0, 1, 0]
            }}
            transition={{
              duration: meteor.duration,
              delay: meteor.delay,
              repeat: Infinity,
              repeatDelay: 15,
              ease: "easeOut"
            }}
          />
        ))}
      </div>

      {/* 神秘符号 */}
      <div className="mystic-symbols">
        {mysticSymbols.map(symbol => {
          const IconComponent = symbol.Component;
          return (
            <motion.div
              key={symbol.id}
              className="mystic-symbol"
              style={{
                left: `${symbol.x}%`,
                top: `${symbol.y}%`,
              }}
              animate={{
                opacity: [0, 0.6, 0],
                rotate: [0, 360],
                scale: [0.8, 1.2, 0.8]
              }}
              transition={{
                duration: symbol.duration,
                delay: symbol.delay,
                repeat: Infinity,
                ease: "easeInOut"
              }}
            >
              <IconComponent size={16} />
            </motion.div>
          );
        })}
      </div>
    </div>
  );
};

export default StarField;