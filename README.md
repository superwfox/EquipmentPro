# EquipmentPro

基于 Paper 1.21.5 的 Minecraft 头饰系统插件，使用 BlockDisplay 实体实现 3D 头饰效果。

## 技术亮点

### 1. BlockDisplay 实体渲染系统
- 利用 Minecraft 1.19.4+ 的 BlockDisplay 实体 API 实现像素级 3D 模型
- 通过 `Transformation` 矩阵控制每个方块的位置、旋转和缩放
- 支持动态缩放倍率，预览模式下自动放大 2 倍展示细节

### 2. 数据驱动的头饰定义
```java
// 统一的变换方法：位置(x,y,z) + 尺寸(sx,sy,sz) + 缩放系数
public static Transformation asl(float x, float y, float z, float sx, float sy, float sz, float scale) {
    return new Transformation(
        new Vector3f(x * scale, y * scale, z * scale),
        new Quaternionf(),
        new Vector3f(sx * scale, sy * scale, sz * scale),
        new Quaternionf()
    );
}
```
- 16 种预设头饰模板，包含简单装饰（皇冠、鹿角）到复杂模型（龙、虎）
- 单个复杂头饰可包含 100+ 个 BlockDisplay 组件

### 3. 实时位置同步
- 监听 `PlayerMoveEvent`，头饰实体跟随玩家头部位置实时更新
- 使用 `setTeleportDuration(1)` 实现平滑移动插值
- 跨世界传送时自动处理实体重定位

### 4. 玩家可见性控制
- 基于 Paper API 的 `showEntity/hideEntity` 实现个人可见性
- 头饰默认对佩戴者隐藏，可手动切换显示状态
- 其他玩家始终可见佩戴者的头饰

### 5. JSON 持久化存储
```java
public static class PlayerData {
    public Set<String> owned = new HashSet<>();  // 已拥有的头饰
    public String equipped = null;                // 当前装备
}
```
- 使用 Gson 序列化玩家数据
- 支持多头饰收藏系统

## 项目结构

```
src/main/java/sudark2/Sudark/equipmentPro/
├── EquipmentPro.java          # 插件主类，生命周期管理
├── Command/
│   └── CommandHander.java     # 命令处理
├── EffectBasic/
│   ├── Effect.java            # 头饰组件数据类
│   └── EquipmentDisplay.java  # 头饰模板定义（700+ 行像素数据）
├── File/
│   └── FileManager.java       # JSON 数据持久化
├── Listener/
│   ├── DisplayListener.java   # 玩家移动/登录/退出事件
│   └── MenuListener.java      # GUI 交互逻辑
├── Menu/
│   └── Menu.java              # 菜单 UI 构建
└── Utils/
    ├── EffectUtils.java       # 头饰生成/加载/卸载
    ├── ItemNameUtil.java      # 物品元数据工具
    └── TitleUtil.java         # 打字机效果 Title 动画
```

## 核心功能

| 功能 | 实现方式 |
|------|----------|
| 头饰渲染 | BlockDisplay + Transformation 矩阵 |
| 位置同步 | PlayerMoveEvent 监听 + 实体传送 |
| 预览系统 | 2 倍缩放 + 30 秒自动清理 |
| 数据存储 | Gson JSON 序列化 |
| GUI 交互 | Bukkit Inventory API |
| 视觉反馈 | 打字机效果 Title 动画 |

## 使用方式

```
/ep menu  - 打开头饰菜单
```

## 技术栈

- Java 21
- Paper API 1.21.5
- Gson 2.10.1
- Maven

## 设计思路

1. **职责分离**：按功能模块拆分类，避免单文件过长
2. **静态方法协作**：减少对象实例化，直接调用工具类方法
3. **数据与逻辑分离**：头饰模板数据集中在 `EquipmentDisplay`，渲染逻辑在 `EffectUtils`
