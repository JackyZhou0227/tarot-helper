# TarotHelper - AI塔罗牌占卜助手

## 项目介绍

在现实生活中，人们会遇到各种各样给人民带来困扰的问题，有些问题例如情感、运势等并非理性思维能够有效解决，而塔罗牌作为一种古老的占卜工具，拥有丰富的文化内涵，且易于上手，因此是一个非常好的选择。

然而无论是新手小白，还是有足够经验的占卜师，塔罗牌共78张并且包含正位和逆位，含义非常丰富，这对记忆力是一个不小的挑战，本人正是每次抽完卡都需要不少时间去查阅一些不熟悉的塔罗牌的含义和关键词，随后才能开始结合问题分析；而将这些塔罗牌组织语言从而分析、解决问题，也是一个不小的挑战。

**TarotHelper** 是一个用于塔罗牌占卜的工具，它利用AI大语言模型强大的能力，旨在帮助用户快速查阅每一张牌的含义和关键词，并通过其强大的语义理解能力进行占卜，用户可以将AI的占卜结果作为参考，进而更加专注于分析解决问题，从而节约时间。

## ✨ 核心功能设计

### 🎴 塔罗牌抽取系统
- **🎲 随机抽牌**：智能随机抽取塔罗牌，自动标注正位和逆位状态
- **🎯 手动选牌**：支持用户指定特定的塔罗牌进行个性化占卜
- **🔮 多样牌阵**：提供丰富的牌阵选择，每个位置都有独特的含义解读

### 🤖 AI智能分析
- **🧠 深度解读**：将抽牌结果发送给大语言模型进行专业分析
- **💡 智能建议**：基于牌面组合提供个性化的人生指导
- **📊 多维度解析**：从情感、事业、健康等多个角度进行全面解读

### 🎨 用户体验
- **✨ 精美界面**：现代化设计风格，流畅的动画效果
- **📱 响应式布局**：完美适配手机、平板、电脑等各种设备
- **🎭 多种皮肤**：提供多样化的视觉主题，满足不同用户喜好

### 🔧 技术特色
- **🏗️ 可扩展架构**：模块化设计，方便添加新牌阵或功能（持续开发中）
- **🔒 隐私保护**：本地AI处理，保护用户隐私数据
- **⚡ 高性能**：快速响应，流畅的用户交互体验

## 技术栈

### 后端
- **Spring Boot 3.x** - 现代化Java企业级应用框架
- **Spring AI** - AI大语言模型集成框架
- **Ollama** - 本地大语言模型服务
- **Gradle** - 项目构建和依赖管理工具
- **RESTful API** - 标准化的API接口设计

### 前端
- **React 18** - 现代化前端框架
- **Vite** - 高性能前端构建工具
- **CSS3** - 现代化样式设计和动画效果
- **JavaScript ES6+** - 现代JavaScript语法
- **响应式设计** - 支持多种设备和屏幕尺寸

## 快速开始

### 环境要求
- Java 17+
- Node.js 16+
- Ollama（用于本地AI模型）

### 安装步骤

1. **克隆项目**
   ```bash
   git clone <repository-url>
   cd tarot-helper
   ```

2. **启动后端服务**
   ```bash
   cd service
   ./gradlew bootRun
   ```
   后端服务将在 `http://localhost:8080` 启动

3. **启动前端服务**
   ```bash
   cd web
   npm install
   npm run dev
   ```
   前端服务将在 `http://localhost:5173` 启动

4. **配置Ollama**
   ```bash
   # 安装并启动Ollama
   ollama serve
   # 下载推荐模型
   ollama pull llama2
   ```

### 访问应用
打开浏览器访问 `http://localhost:5173` 即可使用塔罗牌占卜工具

## 项目结构

```
tarot-helper/
├── README.md
├── service/             # Spring Boot后端
│   ├── src/main/java/
│   ├── src/main/resources/
│   ├── build.gradle
│   └── gradlew
└── web/                 # React前端
    ├── src/
    ├── public/
    ├── package.json
    └── vite.config.js
```

## 技术介绍

### Ollama

Ollama是一个简化大型语言模型本地部署的工具，支持macOS、Windows、Linux和Docker，有着丰富的模型库，包括Meta llama、Google Gemma、阿里千问大模型等各种主流大模型，可以快速将模型部署到对应系统，不再需要为token付费。

Spring AI集成了Ollama，可以让Java开发者在Spring Boot项目中也能快速使用Ollama。

可在yml进行配置，指定Ollama的地址或指定模型

```yaml
spring:
    ai:
        ollama:
            # Ollama的默认端口号是11434
            base-url: http://localhost:11434
            # 指定要使用的模型名称
            chat:
                model: your_model_name
```

## 贡献

欢迎贡献代码！请遵循以下步骤：

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

## 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 作者

- **姓名**：Jacky Zhou
- **邮箱**：jackyzhou0227@foxmail.com
- **GitHub**：[JackyZhou0227 (Jacky Zhou)](https://github.com/JackyZhou0227)

---

**注意**：本工具仅供娱乐和参考，请理性对待占卜结果。
