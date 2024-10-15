package com.example.utils;

import com.example.bean.Card;
import com.example.bean.Tarot;

import java.util.ArrayList;
import java.util.List;

public class TarotUtils {

    //0-78随机取三个不同的数
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
}
