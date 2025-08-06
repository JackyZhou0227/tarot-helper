# 塔罗牌图片资源组织结构

## 目录结构

```
images/
├── tarot-skins/           # 塔罗牌皮肤目录
│   ├── 1/                 # 皮肤1：经典风格
│   ├── 2/                 # 皮肤2：现代风格
│   └── 3/                 # 皮肤3：神秘风格
└── card-backs/            # 卡牌背面图片
```

## 图片命名规范

### 塔罗牌正面图片

所有塔罗牌图片应使用英文名称，**大写字母**，单词间用下划线分隔，文件扩展名为 `.jpg`。
**注意：使用大写命名是为了与项目中的前后端枚举保持一致，便于直接映射。**

#### 大阿尔卡纳（Major Arcana）
- `THE_FOOL.jpg` - 愚者
- `THE_MAGICIAN.jpg` - 魔术师
- `THE_HIGH_PRIESTESS.jpg` - 女祭司
- `THE_EMPRESS.jpg` - 皇后
- `THE_EMPEROR.jpg` - 皇帝
- `THE_HIEROPHANT.jpg` - 教皇
- `THE_LOVERS.jpg` - 恋人
- `THE_CHARIOT.jpg` - 战车
- `STRENGTH.jpg` - 力量
- `THE_HERMIT.jpg` - 隐者
- `THE_WHEEL_OF_FORTUNE.jpg` - 命运之轮
- `JUSTICE.jpg` - 正义
- `THE_HANGED_MAN.jpg` - 倒吊人
- `DEATH.jpg` - 死神
- `THE_TEMPERANCE.jpg` - 节制
- `THE_DEVIL.jpg` - 恶魔
- `THE_TOWER.jpg` - 塔
- `THE_STAR.jpg` - 星星
- `THE_MOON.jpg` - 月亮
- `THE_SUN.jpg` - 太阳
- `THE_JUDGEMENT.jpg` - 审判
- `THE_WORLD.jpg` - 世界

#### 小阿尔卡纳（Minor Arcana）

**权杖牌组（Wands）**
- `WANDS_ACE.jpg` - 权杖王牌
- `WANDS_TWO.jpg` - 权杖二
- `WANDS_THREE.jpg` - 权杖三
- `WANDS_FOUR.jpg` - 权杖四
- `WANDS_FIVE.jpg` - 权杖五
- `WANDS_SIX.jpg` - 权杖六
- `WANDS_SEVEN.jpg` - 权杖七
- `WANDS_EIGHT.jpg` - 权杖八
- `WANDS_NINE.jpg` - 权杖九
- `WANDS_TEN.jpg` - 权杖十
- `WANDS_PAGE.jpg` - 权杖侍从
- `WANDS_KNIGHT.jpg` - 权杖骑士
- `WANDS_QUEEN.jpg` - 权杖王后
- `WANDS_KING.jpg` - 权杖国王

**圣杯牌组（Cups）**
- `CUPS_ACE.jpg` - 圣杯王牌
- `CUPS_TWO.jpg` - 圣杯二
- `CUPS_THREE.jpg` - 圣杯三
- `CUPS_FOUR.jpg` - 圣杯四
- `CUPS_FIVE.jpg` - 圣杯五
- `CUPS_SIX.jpg` - 圣杯六
- `CUPS_SEVEN.jpg` - 圣杯七
- `CUPS_EIGHT.jpg` - 圣杯八
- `CUPS_NINE.jpg` - 圣杯九
- `CUPS_TEN.jpg` - 圣杯十
- `CUPS_PAGE.jpg` - 圣杯侍从
- `CUPS_KNIGHT.jpg` - 圣杯骑士
- `CUPS_QUEEN.jpg` - 圣杯王后
- `CUPS_KING.jpg` - 圣杯国王

**宝剑牌组（Swords）**
- `SWORDS_ACE.jpg` - 宝剑王牌
- `SWORDS_TWO.jpg` - 宝剑二
- `SWORDS_THREE.jpg` - 宝剑三
- `SWORDS_FOUR.jpg` - 宝剑四
- `SWORDS_FIVE.jpg` - 宝剑五
- `SWORDS_SIX.jpg` - 宝剑六
- `SWORDS_SEVEN.jpg` - 宝剑七
- `SWORDS_EIGHT.jpg` - 宝剑八
- `SWORDS_NINE.jpg` - 宝剑九
- `SWORDS_TEN.jpg` - 宝剑十
- `SWORDS_PAGE.jpg` - 宝剑侍从
- `SWORDS_KNIGHT.jpg` - 宝剑骑士
- `SWORDS_QUEEN.jpg` - 宝剑王后
- `SWORDS_KING.jpg` - 宝剑国王

**星币牌组（Pentacles）**
- `PENTACLES_ACE.jpg` - 星币王牌
- `PENTACLES_TWO.jpg` - 星币二
- `PENTACLES_THREE.jpg` - 星币三
- `PENTACLES_FOUR.jpg` - 星币四
- `PENTACLES_FIVE.jpg` - 星币五
- `PENTACLES_SIX.jpg` - 星币六
- `PENTACLES_SEVEN.jpg` - 星币七
- `PENTACLES_EIGHT.jpg` - 星币八
- `PENTACLES_NINE.jpg` - 星币九
- `PENTACLES_TEN.jpg` - 星币十
- `PENTACLES_PAGE.jpg` - 星币侍从
- `PENTACLES_KNIGHT.jpg` - 星币骑士
- `PENTACLES_QUEEN.jpg` - 星币王后
- `PENTACLES_KING.jpg` - 星币国王

### 卡牌背面图片
在 `card-backs/` 目录下：
- `1-back.jpg` - 皮肤1（经典风格）卡牌背面
- `2-back.jpg` - 皮肤2（现代风格）卡牌背面
- `3-back.jpg` - 皮肤3（神秘风格）卡牌背面

### 皮肤预览图
每个皮肤目录下应包含：
- `preview.jpg` - 皮肤预览图（用于皮肤选择界面）

### 皮肤配置说明

皮肤配置文件位于 `tarotSkins.js`，使用数字ID进行管理：
- 皮肤1：经典风格 (classic)
- 皮肤2：现代风格 (modern) 
- 皮肤3：神秘风格 (mystical)

每个皮肤包含中英文名称，便于国际化和本地化。

## 图片规格建议

- **塔罗牌图片**：建议尺寸 300x500px，比例 3:5
- **卡牌背面**：建议尺寸 300x500px，比例 3:5
- **预览图**：建议尺寸 150x250px，比例 3:5
- **格式**：JPG 或 PNG
- **文件大小**：单张图片建议不超过 200KB

## 使用说明

1. 将图片按照上述命名规范放入对应的皮肤目录
2. 确保每个皮肤目录包含完整的78张塔罗牌图片
3. 在 `tarotSkins.js` 中配置皮肤信息
4. 默认使用皮肤1（`classic`），可在配置中修改