// 塔罗牌皮肤配置
export const tarotSkins = {
  1: {
    id: 1,
    nameEn: 'classic',
    nameZh: '经典风格',
    description: '传统的塔罗牌设计风格',
    path: '/assets/images/tarot-skins/1',
    preview: '/assets/images/tarot-skins/1/preview.jpg',
    cardBack: '/assets/images/card-backs/1-back.jpg'
  },
  2: {
    id: 2,
    nameEn: 'modern',
    nameZh: '现代风格',
    description: '简约现代的塔罗牌设计',
    path: '/assets/images/tarot-skins/2',
    preview: '/assets/images/tarot-skins/2/preview.jpg',
    cardBack: '/assets/images/card-backs/2-back.jpg'
  },
  3: {
    id: 3,
    nameEn: 'mystical',
    nameZh: '神秘风格',
    description: '充满神秘色彩的塔罗牌设计',
    path: '/assets/images/tarot-skins/3',
    preview: '/assets/images/tarot-skins/3/preview.jpg',
    cardBack: '/assets/images/card-backs/3-back.jpg'
  }
};

// 默认皮肤
export const DEFAULT_SKIN = 1;

// 获取皮肤配置
export const getSkinConfig = (skinId = DEFAULT_SKIN) => {
  return tarotSkins[skinId] || tarotSkins[DEFAULT_SKIN];
};

/**
 * 获取卡牌图片路径
 * @param {string} cardKey - 卡牌名称（英文，大写，下划线分隔，与枚举保持一致）
 * @param {number} skinId - 皮肤ID
 * @returns {string} 图片路径
 */
export const getCardImagePath = (cardKey, skinId = DEFAULT_SKIN) => {
  const skin = getSkinConfig(skinId);
  if (!skin) return null;
  return `${skin.path}/${cardKey}.jpg`;
};

// 获取卡牌背面图片路径
export const getCardBackPath = (skinId = DEFAULT_SKIN) => {
  const skin = getSkinConfig(skinId);
  return skin.cardBack;
};

// 获取所有可用皮肤
export const getAvailableSkins = () => {
  return Object.values(tarotSkins);
};