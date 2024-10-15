package com.example;

import com.example.bean.Card;
import com.example.bean.CardInSpread;
import com.example.bean.Tarot;
import com.example.utils.TarotUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        withoutSpread();
    }

    private static void withSpread(){
        List<CardInSpread> spread = new ArrayList<>();
        String question = "我是女生，我想了解一些关于我未来恋人的事情。";
        spread.add(new CardInSpread(1, new Card(Tarot.WANDS_PAGE, false), "Ta是什么类型"));
        spread.add(new CardInSpread(2, new Card(Tarot.THE_CHARIOT, false), "Ta已经出现了吗"));
        spread.add(new CardInSpread(3, new Card(Tarot.CUPS_TEN, false), "遇到的阻力"));
        spread.add(new CardInSpread(4, new Card(Tarot.CUPS_KING, true), "相处模式"));
        spread.add(new CardInSpread(5, new Card(Tarot.WANDS_QUEEN, true), "怎样才能遇到Ta"));
        spread.add(new CardInSpread(6, new Card(Tarot.THE_FOOL, true), "指引牌"));
        String prompt = TarotUtils.createSpreadPrompt(spread, question);
        System.out.println(prompt);
    }

    private static void withoutSpread(){
        List<Card> cards = TarotUtils.getRandomCards(3);
        String question = "我是女生，我想了解一些关于我未来恋人的事情。";
        String prompt = TarotUtils.createSimplePrompt(cards, question);
        System.out.println(prompt);
    }
}
