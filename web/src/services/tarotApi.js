// 塔罗牌API服务
const API_BASE_URL = 'http://localhost:8888/api/tarot';

/**
 * 获取基础塔罗牌数据
 * @returns {Promise<Array>} 塔罗牌数组
 */
export const getBasicCards = async () => {
  try {
    const response = await fetch(`${API_BASE_URL}/cards/basic3`);
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    return await response.json();
  } catch (error) {
    console.error('获取塔罗牌数据失败:', error);
    throw error;
  }
};

/**
 * 进行塔罗牌占卜
 * @param {string} question - 占卜问题
 * @param {Array} cards - 抽取的卡牌
 * @param {Function} onData - 流式数据回调函数
 * @returns {Promise<string>} 完整的占卜结果
 */
export const performDivination = async (question, cards, onData) => {
  try {
    const response = await fetch(`${API_BASE_URL}/basic`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'text/plain'
      },
      body: JSON.stringify({
        question: question,
        cards: cards
      })
    });

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const reader = response.body.getReader();
    const decoder = new TextDecoder();
    let result = '';

    while (true) {
      const { done, value } = await reader.read();
      if (done) break;
      
      const chunk = decoder.decode(value, { stream: true });
      result += chunk;
      
      // 调用回调函数处理流式数据
      if (onData) {
        onData(result);
      }
    }

    return result;
  } catch (error) {
    console.error('占卜请求失败:', error);
    throw error;
  }
};