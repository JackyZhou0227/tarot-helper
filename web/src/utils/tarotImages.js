// 塔罗牌图片工具函数

/**
 * 获取塔罗牌图片路径
 * @param {string} tarotName - 塔罗牌英文名称
 * @returns {string} 图片路径
 */
export const getTarotImagePath = (tarotName) => {
  // 将塔罗牌名称转换为文件名格式
  const fileName = tarotName.replace(/\s+/g, '_').toUpperCase();
  return `/assets/images/tarot-skins/1/${fileName}.jpg`;
};

/**
 * 预加载塔罗牌图片
 * @param {string} tarotName - 塔罗牌英文名称
 * @returns {Promise} 图片加载Promise
 */
export const preloadTarotImage = (tarotName) => {
  return new Promise((resolve, reject) => {
    const img = new Image();
    img.onload = () => resolve(img);
    img.onerror = reject;
    img.src = getTarotImagePath(tarotName);
  });
};

/**
 * 批量预加载塔罗牌图片
 * @param {Array} tarotNames - 塔罗牌英文名称数组
 * @returns {Promise} 所有图片加载Promise
 */
export const preloadTarotImages = (tarotNames) => {
  const promises = tarotNames.map(name => preloadTarotImage(name));
  return Promise.allSettled(promises);
};