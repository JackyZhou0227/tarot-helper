package com.example.bean;

import lombok.Data;

@Data
public class CardInSpread {

    /**
     *位置编号
     */
    private int id;

    /**
     * 卡牌信息，包含正逆位
     */
    private Card card;

    /**
     * 位置描述
     */
    private String description;

    public CardInSpread() {
    }

    public CardInSpread(int id, Card card, String description) {
        this.id = id;
        this.card = card;
        this.description = description;
    }
}
