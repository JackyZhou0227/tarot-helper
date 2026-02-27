package com.example.bean;

import lombok.Getter;

@Getter
public enum Tarot {
    // 大阿尔卡纳（0-21）
    THE_FOOL(0, "愚人", "风"),
    THE_MAGICIAN(1, "魔术师", "风"),
    THE_HIGH_PRIESTESS(2, "女祭司", "水"),
    THE_EMPRESS(3, "皇后", "土"),
    THE_EMPEROR(4, "皇帝", "火"),
    THE_HIEROPHANT(5, "教皇", "土"),
    THE_LOVERS(6, "恋人", "风"),
    THE_CHARIOT(7, "战车", "水"),
    STRENGTH(8, "力量", "火"),
    THE_HERMIT(9, "隐者", "土"),
    THE_WHEEL_OF_FORTUNE(10, "命运之轮", "火"),
    JUSTICE(11, "正义", "风"),
    THE_HANGED_MAN(12, "倒吊人", "水"),
    DEATH(13, "死神", "水"),
    THE_TEMPERANCE(14, "节制", "火"),
    THE_DEVIL(15, "恶魔", "土"),
    THE_TOWER(16, "高塔", "火"),
    THE_STAR(17, "星星", "风"),
    THE_MOON(18, "月亮", "水"),
    THE_SUN(19, "太阳", "火"),
    THE_JUDGEMENT(20, "审判", "火"),
    THE_WORLD(21, "世界", "土"),

    // 权杖花色（Wands 22-35）- 火元素
    WANDS_ACE(22, "权杖王牌", "火"),
    WANDS_TWO(23, "权杖二", "火"),
    WANDS_THREE(24, "权杖三", "火"),
    WANDS_FOUR(25, "权杖四", "火"),
    WANDS_FIVE(26, "权杖五", "火"),
    WANDS_SIX(27, "权杖六", "火"),
    WANDS_SEVEN(28, "权杖七", "火"),
    WANDS_EIGHT(29, "权杖八", "火"),
    WANDS_NINE(30, "权杖九", "火"),
    WANDS_TEN(31, "权杖十", "火"),
    WANDS_PAGE(32, "权杖侍从", "火"),
    WANDS_KNIGHT(33, "权杖骑士", "火"),
    WANDS_QUEEN(34, "权杖王后", "火"),
    WANDS_KING(35, "权杖国王", "火"),

    // 圣杯花色（Cups 36-49）- 水元素
    CUPS_ACE(36, "圣杯王牌", "水"),
    CUPS_TWO(37, "圣杯二", "水"),
    CUPS_THREE(38, "圣杯三", "水"),
    CUPS_FOUR(39, "圣杯四", "水"),
    CUPS_FIVE(40, "圣杯五", "水"),
    CUPS_SIX(41, "圣杯六", "水"),
    CUPS_SEVEN(42, "圣杯七", "水"),
    CUPS_EIGHT(43, "圣杯八", "水"),
    CUPS_NINE(44, "圣杯九", "水"),
    CUPS_TEN(45, "圣杯十", "水"),
    CUPS_PAGE(46, "圣杯侍从", "水"),
    CUPS_KNIGHT(47, "圣杯骑士", "水"),
    CUPS_QUEEN(48, "圣杯王后", "水"),
    CUPS_KING(49, "圣杯国王", "水"),

    // 宝剑花色（Swords 50-63）- 风元素
    SWORDS_ACE(50, "宝剑王牌", "风"),
    SWORDS_TWO(51, "宝剑二", "风"),
    SWORDS_THREE(52, "宝剑三", "风"),
    SWORDS_FOUR(53, "宝剑四", "风"),
    SWORDS_FIVE(54, "宝剑五", "风"),
    SWORDS_SIX(55, "宝剑六", "风"),
    SWORDS_SEVEN(56, "宝剑七", "风"),
    SWORDS_EIGHT(57, "宝剑八", "风"),
    SWORDS_NINE(58, "宝剑九", "风"),
    SWORDS_TEN(59, "宝剑十", "风"),
    SWORDS_PAGE(60, "宝剑侍从", "风"),
    SWORDS_KNIGHT(61, "宝剑骑士", "风"),
    SWORDS_QUEEN(62, "宝剑王后", "风"),
    SWORDS_KING(63, "宝剑国王", "风"),

    // 星币花色（Pentacles 64-77）- 土元素
    PENTACLES_ACE(64, "星币王牌", "土"),
    PENTACLES_TWO(65, "星币二", "土"),
    PENTACLES_THREE(66, "星币三", "土"),
    PENTACLES_FOUR(67, "星币四", "土"),
    PENTACLES_FIVE(68, "星币五", "土"),
    PENTACLES_SIX(69, "星币六", "土"),
    PENTACLES_SEVEN(70, "星币七", "土"),
    PENTACLES_EIGHT(71, "星币八", "土"),
    PENTACLES_NINE(72, "星币九", "土"),
    PENTACLES_TEN(73, "星币十", "土"),
    PENTACLES_PAGE(74, "星币侍从", "土"),
    PENTACLES_KNIGHT(75, "星币骑士", "土"),
    PENTACLES_QUEEN(76, "星币王后", "土"),
    PENTACLES_KING(77, "星币国王", "土");

    private final int id;
    private final String name;
    private final String element;

    Tarot(int id, String name, String element) {
        this.id = id;
        this.name = name;
        this.element = element;
    }

    public static Tarot getTarot(int id) {
        return Tarot.values()[id];
    }

    @Override
    public String toString() {
        return name;
    }
}
