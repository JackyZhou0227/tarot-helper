package com.example.bean;

import lombok.Getter;

@Getter
public enum Tarot {
    // 大阿尔卡纳（0-21）
    THE_FOOL(0, "愚人"),
    THE_MAGICIAN(1, "魔术师"),
    THE_HIGH_PRIESTESS(2, "女祭司"),
    THE_EMPRESS(3, "皇后"),
    THE_EMPEROR(4, "皇帝"),
    THE_HIEROPHANT(5, "教皇"),
    THE_LOVERS(6, "恋人"),
    THE_CHARIOT(7, "战车"),
    STRENGTH(8, "力量"),
    THE_HERMIT(9, "隐者"),
    THE_WHEEL_OF_FORTUNE(10, "命运之轮"),
    JUSTICE(11, "正义"),
    THE_HANGED_MAN(12, "倒吊人"),
    DEATH(13, "死神"),
    THE_TEMPERANCE(14, "节制"),
    THE_DEVIL(15, "恶魔"),
    THE_TOWER(16, "高塔"),
    THE_STAR(17, "星星"),
    THE_MOON(18, "月亮"),
    THE_SUN(19, "太阳"),
    THE_JUDGEMENT(20, "审判"),
    THE_WORLD(21, "世界"),

    // 权杖花色（Wands 22-35）
    WANDS_ACE(22, "权杖王牌"), WANDS_TWO(23, "权杖二"),
    WANDS_THREE(24, "权杖三"), WANDS_FOUR(25, "权杖四"),
    WANDS_FIVE(26, "权杖五"), WANDS_SIX(27, "权杖六"),
    WANDS_SEVEN(28, "权杖七"), WANDS_EIGHT(29, "权杖八"),
    WANDS_NINE(30, "权杖九"), WANDS_TEN(31, "权杖十"),
    WANDS_PAGE(32, "权杖侍从"), WANDS_KNIGHT(33, "权杖骑士"),
    WANDS_QUEEN(34, "权杖王后"), WANDS_KING(35, "权杖国王"),

    // 圣杯花色（Cups 36-49）
    CUPS_ACE(36, "圣杯王牌"), CUPS_TWO(37, "圣杯二"),
    CUPS_THREE(38, "圣杯三"), CUPS_FOUR(39, "圣杯四"),
    CUPS_FIVE(40, "圣杯五"), CUPS_SIX(41, "圣杯六"),
    CUPS_SEVEN(42, "圣杯七"), CUPS_EIGHT(43, "圣杯八"),
    CUPS_NINE(44, "圣杯九"), CUPS_TEN(45, "圣杯十"),
    CUPS_PAGE(46, "圣杯侍从"), CUPS_KNIGHT(47, "圣杯骑士"),
    CUPS_QUEEN(48, "圣杯王后"), CUPS_KING(49, "圣杯国王"),

    // 宝剑花色（Swords 50-63）
    SWORDS_ACE(50, "宝剑王牌"), SWORDS_TWO(51, "宝剑二"),
    SWORDS_THREE(52, "宝剑三"), SWORDS_FOUR(53, "宝剑四"),
    SWORDS_FIVE(54, "宝剑五"), SWORDS_SIX(55, "宝剑六"),
    SWORDS_SEVEN(56, "宝剑七"), SWORDS_EIGHT(57, "宝剑八"),
    SWORDS_NINE(58, "宝剑九"), SWORDS_TEN(59, "宝剑十"),
    SWORDS_PAGE(60, "宝剑侍从"), SWORDS_KNIGHT(61, "宝剑骑士"),
    SWORDS_QUEEN(62, "宝剑王后"), SWORDS_KING(63, "宝剑国王"),

    // 星币花色（Pentacles 64-77）
    PENTACLES_ACE(64, "星币王牌"), PENTACLES_TWO(65, "星币二"),
    PENTACLES_THREE(66, "星币三"), PENTACLES_FOUR(67, "星币四"),
    PENTACLES_FIVE(68, "星币五"), PENTACLES_SIX(69, "星币六"),
    PENTACLES_SEVEN(70, "星币七"), PENTACLES_EIGHT(71, "星币八"),
    PENTACLES_NINE(72, "星币九"), PENTACLES_TEN(73, "星币十"),
    PENTACLES_PAGE(74, "星币侍从"), PENTACLES_KNIGHT(75, "星币骑士"),
    PENTACLES_QUEEN(76, "星币王后"), PENTACLES_KING(77, "星币国王");

    private final int id;

    private final String name;

    Tarot(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Tarot getTarot(int id) {
        return Tarot.values()[id];
    }

    @Override
    public String toString() {
        return name;
    }
}
