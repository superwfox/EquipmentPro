# EquipmentPro

A Minecraft cosmetic hat system plugin for Paper 1.21.5, implementing 3D hat effects using BlockDisplay entities.

## Technical Highlights

### 1. BlockDisplay Entity Rendering System
- Utilizes Minecraft 1.19.4+ BlockDisplay entity API for pixel-level 3D models
- Controls position, rotation, and scale of each block via `Transformation` matrix
- Supports dynamic scale multiplier - preview mode automatically scales up 2x for detail

### 2. Data-Driven Hat Definitions
```java
// Unified transformation method: position(x,y,z) + size(sx,sy,sz) + scale factor
public static Transformation asl(float x, float y, float z, float sx, float sy, float sz, float scale) {
    return new Transformation(
        new Vector3f(x * scale, y * scale, z * scale),
        new Quaternionf(),
        new Vector3f(sx * scale, sy * scale, sz * scale),
        new Quaternionf()
    );
}
```
- 16 preset hat templates, from simple decorations (crowns, antlers) to complex models (dragon, tiger)
- Single complex hat can contain 100+ BlockDisplay components

### 3. Real-time Position Synchronization
- Listens to `PlayerMoveEvent`, hat entities follow player head position in real-time
- Uses `setTeleportDuration(1)` for smooth movement interpolation
- Automatic entity relocation on cross-world teleportation

### 4. Player Visibility Control
- Per-player visibility using Paper API's `showEntity/hideEntity`
- Hats hidden from wearer by default, toggleable via menu
- Other players always see the wearer's hat

### 5. JSON Persistent Storage
```java
public static class PlayerData {
    public Set<String> owned = new HashSet<>();  // Owned hats
    public String equipped = null;                // Currently equipped
}
```
- Gson serialization for player data
- Multi-hat collection system support

## Project Structure

```
src/main/java/sudark2/Sudark/equipmentPro/
├── EquipmentPro.java          # Main plugin class, lifecycle management
├── Command/
│   └── CommandHander.java     # Command handling
├── EffectBasic/
│   ├── Effect.java            # Hat component data class
│   └── EquipmentDisplay.java  # Hat template definitions (700+ lines of pixel data)
├── File/
│   └── FileManager.java       # JSON data persistence
├── Listener/
│   ├── DisplayListener.java   # Player move/join/quit events
│   └── MenuListener.java      # GUI interaction logic
├── Menu/
│   └── Menu.java              # Menu UI construction
└── Utils/
    ├── EffectUtils.java       # Hat spawn/load/unload utilities
    ├── ItemNameUtil.java      # Item metadata utilities
    └── TitleUtil.java         # Typewriter effect title animation
```

## Core Features

| Feature | Implementation |
|---------|----------------|
| Hat Rendering | BlockDisplay + Transformation matrix |
| Position Sync | PlayerMoveEvent listener + entity teleport |
| Preview System | 2x scale + 30s auto-cleanup |
| Data Storage | Gson JSON serialization |
| GUI Interaction | Bukkit Inventory API |
| Visual Feedback | Typewriter effect title animation |

## Usage

```
/ep menu  - Open hat menu
```

## Tech Stack

- Java 21
- Paper API 1.21.5
- Gson 2.10.1
- Maven

## Design Principles

1. **Separation of Concerns**: Classes split by functional modules, avoiding oversized files
2. **Static Method Collaboration**: Minimize object instantiation, direct utility class calls
3. **Data-Logic Separation**: Hat template data centralized in `EquipmentDisplay`, rendering logic in `EffectUtils`
