package com.example.utils;

import com.example.bean.Card;
import com.example.bean.CardInSpread;

import java.util.List;

public class AIUtils {

    /**
     * 生成一个包含塔罗牌占卜信息的提示字符串
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

    public static String createSimplePrompt(List<Card> cards, String question) {
        String text1 = "你是一名塔罗牌占卜师，根据我给你的塔罗牌，给我一个占卜的结果。\n";
        String text2 = "我的问题是：" + question + "\n";
        String text3 = "我我已经抽好了牌，以下是我的牌阵：\n";
        StringBuilder text4 = new StringBuilder();
        for (Card card : cards) {
            text4.append(card.getTarot().toString()).append(card.isUpright()? "(正位)" : "(逆位)").append("；\n");
        }
        String text5 = "请根据我的牌，首先分析每一张牌的关键词和含义，然后根据我的问题，给出一个占卜的结果。";
        return text1 + text2 + text3 + text4 + text5;
    }
}
