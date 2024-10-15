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
     * 生成一个包含塔罗牌占卜信息prompt，用于发给AI
     *
     * @param spread   塔罗牌在牌阵中的位置和含义信息列表
     * @param question 用户提出的问题
     * @return 一个包含问题、牌阵信息和占卜提示的字符串
     */
    public static String createSpreadPrompt(List<CardInSpread> spread, String question) {
        String text1 = "你是一名塔罗牌占卜师，根据我给你的塔罗牌，给我一个占卜的结果。\n";
        String text2 = "我的问题是：" + question + "\n";
        String text3 = "我已设置好了牌阵并抽取了牌，以下是我的牌阵：\n";
        StringBuilder text4 = new StringBuilder();
        for (CardInSpread cardInSpread : spread) {
            text4.append("位置").append(cardInSpread.getId()).append(":").append(cardInSpread.getCard().getTarot().toString())
                    .append(cardInSpread.getCard().isUpright() ? "(正位)" : "(逆位)")
                    .append("，该位置的含义是：").append(cardInSpread.getDescription()).append("；\n");
        }
        String text5 = "请根据我的牌阵，首先分析每一张牌的关键词和含义，然后根据我的问题，给出一个占卜的结果。";
        return text1 + text2 + text3 + text4 + text5;
    }

    /**
     * 生成一个无牌阵的塔罗牌占卜信息prompt，用于发给AI
     *
     * @param cards    抽到的塔罗牌列表，每张牌包含其正位或逆位的信息
     * @param question 用户提出的问题
     * @return 返回一个格式化的字符串，包含占卜的上下文信息、问题、牌阵以及占卜结果的提示
     */
    public static String createSimplePrompt(List<Card> cards, String question) {
        String text1 = "你是一名塔罗牌占卜师，根据我给你的塔罗牌，给我一个占卜的结果。\n";
        String text2 = "我的问题是：" + question + "\n";
        String text3 = "我我已经抽好了牌，以下是我的牌阵：\n";
        StringBuilder text4 = new StringBuilder();
        for (Card card : cards) {
            text4.append(card.getTarot().toString()).append(card.isUpright() ? "(正位)" : "(逆位)").append("；\n");
        }
        String text5 = "请根据我的牌，首先分析每一张牌的关键词和含义，然后根据我的问题，给出一个占卜的结果。";
        return text1 + text2 + text3 + text4 + text5;
    }
}
