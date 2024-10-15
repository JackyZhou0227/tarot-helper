package com.example.bean;

import lombok.Data;

import java.util.Random;

@Data
public class Card {
    /**
     * 塔罗牌
     */
    private Tarot tarot;

    /**
     * 是否正位
     */
    private boolean isUpright;

    public Card() {
    }

    public Card(Tarot tarot){
        this.tarot = tarot;
        this.isUpright = new Random().nextBoolean();
    }

    public Card(Tarot tarot, boolean isUpright) {
        this.tarot = tarot;
        this.isUpright = isUpright;
    }

}
