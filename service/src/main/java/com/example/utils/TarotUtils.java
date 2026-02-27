package com.example.utils;

import com.example.bean.Card;
import com.example.bean.CardInSpread;
import com.example.bean.Tarot;

import java.util.ArrayList;
import java.util.List;

public class TarotUtils {

    /**
     * 获取随机卡牌集合
     * 该方法用于从指定数量的卡牌中随机抽取三个不同的卡牌编号，并创建对应的卡牌对象集合
     *
     * @param cardNum 卡牌总数，用于指定卡牌池的大小
     * @return 返回一个包含三个随机且不重复卡牌的列表
     */
    public static List<Card> getRandomCards(int cardNum) {
        int[] tarotIds = randomCommon(cardNum);
        List<Card> cards = new ArrayList<>();
        for (int tarotId : tarotIds) {
            cards.add(new Card(Tarot.getTarot(tarotId)));
        }
        return cards;
    }

    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     *
     * @param n 随机数个数
     */
    public static int[] randomCommon(int n) {
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * 77);
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    /**
     * 系统提示词，定义AI的角色和输出规范
     */
    public static final String SYSTEM_PROMPT = """
            # Role
            你是一位资深的塔罗牌占卜大师，精通韦特塔罗体系（Rider-Waite Tarot）。你拥有深厚的神秘学背景，擅长结合**元素论**（火/水/风/土）、**数字学**、**占星学**以及牌面**图像象征**进行深度解读。

            # Objective
            根据用户提供的【占卜问题】和【卡牌信息】，进行专业、深入的解读，并生成一份结构化的占卜报告。

            # Context
            - **元素分析**：观察牌阵中元素的分布（如火元素过多可能代表行动力过强或冲动，水元素过多可能代表情绪化）。
            - **正逆位解读**：正位代表能量顺畅发挥；逆位代表能量受阻、过度、不足或内化。
            - **牌面关联**：寻找牌与牌之间的联系（如重复出现的数字、花色或象征符号）。

            # Style & Tone
            - 风格：专业、神秘、富有洞察力。
            - 语气：共情、客观、鼓励性，避免恐吓或给出绝对化的医疗/法律建议。

            # Constraints
            - 必须使用 Markdown 格式输出。
            - 严禁输出任何违法违规、封建迷信的内容。
            - 保持回答的逻辑性和条理性。

            # Response Structure
            请务必严格按照以下模板进行输出：

            ## 🔮 牌面解析
            逐一分析每张牌。对于每张牌，请结合其【元素属性】以及在当前位置的含义进行解读。

            ## ⚖️ 元素与能量分析
            简要分析整体牌阵的元素平衡情况（如缺火、土重等）及其对问题的影响。

            ## 📝 综合解读
            结合所有牌面，针对用户的问题进行整体性的深度解析，揭示事物背后的逻辑或潜在发展。

            ## 💡 导师指引
            基于占卜结果，给出 2-3 条具体、可操作的建议。

            ## 💌 最终回答
            用最通俗易懂的大白话（避免任何塔罗术语），直接回答用户的问题，并给出最核心的建议。就像朋友之间的交谈一样自然、温暖。
            """;

    /**
     * 生成一个包含塔罗牌占卜信息prompt，用于发给AI
     *
     * @param spread   塔罗牌在牌阵中的位置和含义信息列表
     * @param question 用户提出的问题
     * @return 一个包含问题、牌阵信息和占卜提示的字符串
     */
    public static String createSpreadPrompt(List<CardInSpread> spread, String question) {
        StringBuilder cardInfo = new StringBuilder();
        for (CardInSpread cardInSpread : spread) {
            Tarot tarot = cardInSpread.getCard().getTarot();
            boolean isUpright = cardInSpread.getCard().isUpright();

            cardInfo.append(String.format("""
                    - 位置 %d (%s):
                      * 牌名: %s %s
                      * 元素: %s
                    """,
                    cardInSpread.getId(),
                    cardInSpread.getDescription(),
                    tarot.toString(),
                    isUpright ? "(正位)" : "(逆位)",
                    tarot.getElement()));
        }

        return String.format("""
                <Context>
                - 用户问题: %s
                - 抽取的牌阵信息:
                %s
                </Context>

                请开始你的占卜解读：
                """, question, cardInfo);
    }

    /**
     * 生成一个无牌阵的塔罗牌占卜信息prompt，用于发给AI
     *
     * @param cards    抽到的塔罗牌列表，每张牌包含其正位或逆位的信息
     * @param question 用户提出的问题
     * @return 返回一个格式化的字符串，包含占卜的上下文信息、问题、牌阵以及占卜结果的提示
     */
    public static String createSimplePrompt(List<Card> cards, String question) {
        StringBuilder cardInfo = new StringBuilder();
        for (Card card : cards) {
            Tarot tarot = card.getTarot();
            boolean isUpright = card.isUpright();

            cardInfo.append(String.format("""
                    - 牌名: %s %s
                      * 元素: %s
                    """,
                    tarot.toString(),
                    isUpright ? "(正位)" : "(逆位)",
                    tarot.getElement()));
        }

        return String.format("""
                <Context>
                - 用户问题: %s
                - 抽取的卡牌:
                %s
                </Context>

                请开始你的占卜解读：
                """, question, cardInfo);
    }
}
