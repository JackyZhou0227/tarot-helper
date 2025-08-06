/**
 * 塔罗牌相关工具函数
 */

/**
 * 从数组中随机选择指定数量的元素
 * @param {Array} array - 源数组
 * @param {number} count - 选择数量
 * @returns {Array} 随机选择的元素数组
 */
export const getRandomCards = (array, count) => {
  const shuffled = [...array].sort(() => 0.5 - Math.random());
  return shuffled.slice(0, count);
};

/**
 * 延迟执行函数
 * @param {number} ms - 延迟毫秒数
 * @returns {Promise} Promise对象
 */
export const delay = (ms) => {
  return new Promise(resolve => setTimeout(resolve, ms));
};

/**
 * 格式化卡牌名称（移除数字前缀）
 * @param {string} name - 原始卡牌名称
 * @returns {string} 格式化后的名称
 */
export const formatCardName = (name) => {
  if (!name) return '';
  return name.replace(/^\d+\.\s*/, '');
};

/**
 * 检查是否为有效的卡牌对象
 * @param {Object} card - 卡牌对象
 * @returns {boolean} 是否有效
 */
export const isValidCard = (card) => {
  return card && 
         typeof card === 'object' && 
         typeof card.name === 'string' && 
         typeof card.meaning === 'string';
};

/**
 * 生成卡牌的唯一标识
 * @param {Object} card - 卡牌对象
 * @param {number} index - 索引
 * @returns {string} 唯一标识
 */
export const generateCardId = (card, index) => {
  if (!card || !card.name) {
    return `card-${index}-${Date.now()}`;
  }
  return `${card.name.replace(/\s+/g, '-').toLowerCase()}-${index}`;
};

/**
 * 验证问题输入
 * @param {string} question - 问题文本
 * @returns {Object} 验证结果 { isValid: boolean, message: string }
 */
export const validateQuestion = (question) => {
  if (!question || typeof question !== 'string') {
    return {
      isValid: false,
      message: '请输入有效的问题'
    };
  }
  
  const trimmedQuestion = question.trim();
  
  if (trimmedQuestion.length === 0) {
    return {
      isValid: false,
      message: '问题不能为空'
    };
  }
  
  if (trimmedQuestion.length < 5) {
    return {
      isValid: false,
      message: '问题太短，请输入更详细的问题'
    };
  }
  
  if (trimmedQuestion.length > 500) {
    return {
      isValid: false,
      message: '问题太长，请控制在500字以内'
    };
  }
  
  return {
    isValid: true,
    message: ''
  };
};