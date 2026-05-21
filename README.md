<div align="center">

<!-- Replace with your actual banner/logo image -->
<img src="src/main/resources/images/ui/menu/title2.png" alt="Duck Dash Logo" width="480"/>

# 🦆 Duck Dash

**A 2D Side-Scrolling Runner Game built with Java & JavaFX**

[![Build Check](https://img.shields.io/github/actions/workflow/status/<your-username>/DuckDash/build.yml?branch=main&label=Build&style=flat-square&logo=githubactions&logoColor=white)](https://github.com/<your-username>/DuckDash/actions/workflows/build.yml)
[![Release](https://img.shields.io/github/v/release/<your-username>/DuckDash?style=flat-square&logo=github&logoColor=white&label=Release)](https://github.com/<your-username>/DuckDash/releases/latest)
[![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/21/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21-blue?style=flat-square&logo=java&logoColor=white)](https://openjfx.io/)
[![Maven](https://img.shields.io/badge/Build-Maven-red?style=flat-square&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue?style=flat-square&logo=gnu&logoColor=white)](LICENSE.txt)
[![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20Linux-lightgrey?style=flat-square&logo=windows&logoColor=white)]()
[![University](https://img.shields.io/badge/University-BAUET-green?style=flat-square)]()

*Help the Duck make it to class — on time — without falling asleep!*

---

[Download](#-download--installation) · [Features](#-features) · [Gameplay](#-gameplay) · [Controls](#-controls) · [Build from Source](#-build-from-source) · [CI / CD Pipeline](#-ci-/-cd-pipeline) · [Project Structure](#-project-structure) · [Team](#-team) · [License](#-license)

</div>

---

## 📖 About The Project

**Duck Dash** is a fast-paced, 2D side-scrolling runner game where you control a sleepy duck trying to navigate through three increasingly challenging environments — a university hall corridor, a busy street, and the academic building itself. Dodge enemies, leap over obstacles, collect food to restore energy, and whatever you do… **don't fall asleep**.

Developed as a course project for the **Java Programming Laboratory** at **Bangladesh Army University of Engineering & Technology (BAUET)**, Duck Dash is a fully-featured game complete with a story mode, an endless survival mode, animated menus, cutscenes, sound design, and a persistent high-score system — all built from scratch in pure Java and JavaFX with zero game-engine dependencies.

---

## 📥 Download & Installation

> **No Java installation required.** The release packages are fully self-contained native installers bundled with their own JVM runtime via `jlink` + `jpackage`.

### Windows

1. Go to the [**Latest Release**](https://github.com/<your-username>/DuckDash/releases/latest) page.
2. Download **`DuckDash-windows.exe`**.
3. Run the installer — it installs the game to `C:\Program Files\DuckDash\`.
4. Launch the game from the Start Menu, desktop shortcut, or directly:

```
C:\Program Files\DuckDash\DuckDash.exe
```

> **Note:** Windows SmartScreen may show a warning on first run. Click **"More info" → "Run anyway"** — this is expected for unsigned installers.

### Linux (Debian / Ubuntu)

1. Go to the [**Latest Release**](https://github.com/<your-username>/DuckDash/releases/latest) page.
2. Download **`DuckDash-linux.deb`**.
3. Install the package:

```bash
sudo dpkg -i DuckDash-linux.deb
```

4. Launch the game from your application menu or from the terminal:

```bash
/opt/duckdash/bin/DuckDash
```

> The `.desktop` entry is registered automatically, so DuckDash will appear in your applications menu under the **Games** category.

---

## ✨ Features

| Category | Details |
|---|---|
| 🎮 **Game Modes** | Story Mode (3 levels) + Endless Survival Mode (per level) |
| 🌍 **Levels** | Hall Corridor · The Street · Academic Building |
| 🦆 **Player Mechanics** | Jump, Buffered Jump, Crouch, Eat animation, Sleepy state |
| 👾 **Enemies** | Cat (Brown & Black) · Eagle · Dog · Boy (lethal — one hit) |
| 🍞 **Food Items** | Bread · Worm · Cockroach (restore health & reset sleep bar) |
| 🪑 **Obstacles** | Bottle · Black Chair · White Chair · Indoor Plant · Outdoor Plant |
| ❤️ **HUD** | Health bar (3 hearts) · Sleep bar (3 segments) · Timer · Level progress bar |
| 🎬 **Cutscenes** | Animated opening story video · Ending cutscene before credits |
| 🎵 **Audio** | Per-level background music (intro + looping) · Sound effects · Credits music |
| 🏆 **High Scores** | Persistent best times (Story) & best survival times (Endless) |
| ⏸️ **Pause System** | In-game pause menu · Settings · Restart · Exit to Menu |
| 🎨 **Animated Menu** | Live menu with scrolling clouds, wandering duck, and building backdrop |
| 📜 **Credits** | Full scrolling credits scene with skip support |
| 🖥️ **Native Installers** | `.exe` for Windows · `.deb` for Linux — no Java needed |

---

## 🎮 Gameplay

### Story Mode

Navigate through **3 levels** of increasing difficulty. Each level has a distinct background, enemy set, and obstacle roster. The duck must survive until the level progress bar fills, then run off-screen to complete it.

| Level | Environment | Speed | Enemies | Food | Obstacles |
|---|---|---|---|---|---|
| **Level 1** | Hall Corridor | Relaxed | Black Cat | Cockroach | Bottle, Black Chair |
| **Level 2** | The Street | Moderate | Dog, Eagle | Worm | Outdoor Plant |
| **Level 3** | Academic Building | Fast | Boy *(lethal)*, Brown Cat | Bread | Bottle, Indoor Plant, White Chair |

Complete all three levels to unlock the **ending cutscene** and **credits**.

### Endless Mode

Survive as long as possible on any level. The world speed **escalates every 20 seconds**, pushing your reflexes to the limit. Your best survival time is saved and tracked on the High Score board.

### The Sleep Bar

Every food item you collect fills a segment of the duck's **sleep bar**. A full sleep bar means instant game over — the duck falls asleep. Getting hit clears a segment. Balance food collection with hazard avoidance.

### The Boy — Lethal Enemy

The **Boy** (Level 3) is a one-hit kill. He's tall enough that the duck cannot jump over him — you **must crouch**. One collision drains all health instantly.

### Hitbox System

All entities use **precise, per-entity configurable hitboxes** with independent shrink ratios for X, top-Y, and bottom-Y. The Chair obstacles are specifically tuned so the duck can crouch underneath the seat but cannot pass through the legs — genuine strategic depth.

---

## 🎯 Controls

| Action | Key(s) |
|---|---|
| **Jump** | `Space` · `W` · `↑` |
| **Crouch** | `S` · `↓` |
| **Buffered Jump** *(press while airborne)* | `Space` — queued, fires on landing |
| **Cancel Queued Jump** | Release `Space` / `W` / `↑` |
| **Pause / Resume** | `Esc` |
| **Skip Cutscene / Credits** | `Space` |
| **Developer: Skip to Level End** | `E` → `N` → `D` *(key sequence)* |

> **Input Buffering:** Pressing jump while airborne queues exactly one extra jump, which fires the instant the duck lands. Releasing the key before landing cancels the queue — holding the button down never causes unintended continuous jumping.

---

## 🔧 Build from Source

If you want to build Duck Dash yourself or contribute to development, follow the steps below.

### Prerequisites

| Tool | Version | Notes |
|---|---|---|
| **JDK** | 21+ | OpenJDK 21.0.10 recommended |
| **Apache Maven** | 3.8+ | Build & dependency management |
| **Git** | Any | Clone the repository |

> JavaFX 21 is declared as a Maven dependency and resolved automatically — no separate SDK download needed for building.

### Steps

**1. Clone the repository**

```bash
git clone https://github.com/<your-username>/DuckDash.git
cd DuckDash
```

**2. Compile & verify**

```bash
mvn clean verify
```

**3. Run directly via Maven**

```bash
mvn javafx:run
```

**4. Package a JAR**

```bash
mvn clean package -DskipTests
```

The shaded/fat JAR will be at `target/duckrun-<version>.jar`.

### Building a Native Installer Locally

The CI pipeline uses `jlink` + `jpackage` to create self-contained installers. To replicate locally you need JDK 21 with `jpackage` support and the platform-specific packaging tools (`fakeroot`/`dpkg` on Linux, WiX on Windows).

```bash
# 1. Build the JAR
mvn clean package -DskipTests

# 2. Create a minimal runtime image
jlink \
  --module-path "$JAVA_HOME/jmods:target/deps:target/duckrun-*.jar" \
  --add-modules edu.bauet.java.cse.duckrun \
  --output target/runtime \
  --strip-debug --no-header-files --no-man-pages --compress=2

# 3. Create the installer (Linux example)
jpackage \
  --type deb \
  --name DuckDash \
  --app-version 1.0.0 \
  --input target/app \
  --main-jar duckrun-*.jar \
  --main-class edu.bauet.java.cse.duckrun.MainApp \
  --runtime-image target/runtime \
  --resource-dir src/packaging/linux \
  --dest target
```

---

## ⚙️ CI / CD Pipeline

Duck Dash uses **GitHub Actions** for automated building and releasing.

### Build Check (`build.yml`)

Runs on every push and pull request to `main`.

- **Matrix:** `ubuntu-latest` × `windows-latest`
- **Steps:** Checkout → Setup JDK 21 (Temurin) → `mvn clean verify -DskipTests`
- **Purpose:** Catches compilation errors and module/dependency issues on both platforms before merging.

```
Push to main / PR → ubuntu build ✓
                  → windows build ✓
```

### Release Pipeline (`release.yml`)

Triggered automatically when a **version tag** is pushed.

```bash
git tag v1.0.0
git push --tags
```

| Stage | What happens |
|---|---|
| **Build (Linux)** | Compiles → `jlink` runtime → `jpackage` → `DuckDash.deb` |
| **Build (Windows)** | Compiles → `jlink` runtime → `jpackage` → `DuckDash.exe` |
| **Release** | Downloads both artifacts → Creates a GitHub Release with auto-generated notes and attaches both installers |

The release job requires `contents: write` permission and uses [`softprops/action-gh-release`](https://github.com/softprops/action-gh-release) to publish.

---

## 🏗️ Project Structure

```
DuckDash/
├── .github/
│   └── workflows/
│       ├── build.yml               # CI: compile check on push/PR
│       └── release.yml             # CD: native installers on version tag
├── .mvn/
│   ├── jvm.config                  # --add-opens for JavaFX internals
│   └── maven.config                # -Dmaven.compiler.release=21
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── edu/bauet/java/cse/duckrun/
│   │   │       ├── MainApp.java              # Application entry point
│   │   │       ├── core/
│   │   │       │   ├── Constants.java
│   │   │       │   ├── GameLoop.java
│   │   │       │   ├── GameState.java
│   │   │       │   └── SpawnManager.java     # Entity spawn control
│   │   │       ├── entities/
│   │   │       │   ├── Duck.java             # Player entity (jump, crouch, animate)
│   │   │       │   ├── Enemy.java            # Abstract base for all enemies
│   │   │       │   ├── Food.java             # Abstract base for collectibles
│   │   │       │   ├── Obstacle.java         # Abstract base for static obstacles
│   │   │       │   ├── CatBrown.java         # Level 3 enemy
│   │   │       │   ├── CatBlack.java         # Level 1 enemy
│   │   │       │   ├── Dog.java              # Level 2 ground enemy
│   │   │       │   ├── Eagle.java            # Level 2 aerial enemy
│   │   │       │   ├── Boy.java              # Level 3 lethal enemy
│   │   │       │   ├── Bread.java            # Level 3 food
│   │   │       │   ├── Worm.java             # Level 2 food
│   │   │       │   ├── Cockroach.java        # Level 1 food
│   │   │       │   ├── Bottle.java           # Jump-over obstacle
│   │   │       │   ├── ChairB.java           # Jump/crouch obstacle
│   │   │       │   ├── ChairW.java           # Jump/crouch obstacle
│   │   │       │   ├── Treein.java           # Indoor plant obstacle
│   │   │       │   └── Treeout.java          # Outdoor plant obstacle
│   │   │       ├── levels/
│   │   │       │   ├── Level.java            # Abstract level contract
│   │   │       │   ├── Level1.java           # Hall Corridor
│   │   │       │   ├── Level2.java           # The Street
│   │   │       │   └── Level3.java           # Academic Building
│   │   │       ├── scenes/
│   │   │       │   ├── LogoScene.java        # Team logo intro
│   │   │       │   ├── StoryScene.java       # Opening cutscene
│   │   │       │   ├── MenuScene.java        # Animated main menu
│   │   │       │   ├── GameScene.java        # Story mode game loop
│   │   │       │   ├── EndlessGameScene.java # Endless survival mode
│   │   │       │   ├── EndingScene.java      # Post-Level-3 cutscene
│   │   │       │   ├── CreditsScene.java     # Scrolling credits
│   │   │       │   └── GameOverScene.java
│   │   │       ├── ui/
│   │   │       │   ├── HealthBar.java        # Heart-based HP display
│   │   │       │   ├── SleepBar.java         # Sleep segment display
│   │   │       │   ├── LevelProgressBar.java # Canvas-drawn progress bar
│   │   │       │   ├── PauseMenu.java        # In-game pause overlay
│   │   │       │   ├── SettingsMenu.java     # Music toggle, reset, credits
│   │   │       │   ├── LevelMenu.java        # Level select menu
│   │   │       │   ├── EndlessLevelMenu.java # Endless level select
│   │   │       │   ├── HighScoreMenu.java    # Story + Endless high scores
│   │   │       │   ├── MenuBackground.java   # Animated cloud + building bg
│   │   │       │   └── MenuDuck.java         # Wandering duck on main menu
│   │   │       └── utils/
│   │   │           ├── AssetLoader.java      # Image/audio/video cache
│   │   │           ├── CollisionUtil.java    # AABB collision check
│   │   │           ├── HighScoreManager.java # Java Preferences persistence
│   │   │           ├── MusicManager.java     # Singleton audio controller
│   │   │           └── TimeUtil.java         # JavaFX Timeline-based timer
│   │   └── resources/
│   │       ├── audio/
│   │       │   ├── music/                    # BGM tracks (intro + loop pairs)
│   │       │   └── sound_effect/             # Hit, step, SFX
│   │       ├── fonts/
│   │       │   └── PressStart2P-Regular.ttf  # Pixel font
│   │       ├── images/
│   │       │   ├── backgrounds/              # Level backgrounds + transitions
│   │       │   ├── duck/                     # Player sprite variants
│   │       │   ├── enemies/                  # Enemy + food sprites
│   │       │   ├── game_over/                # Death screen images
│   │       │   ├── indicator/                # Health & sleep bar sprites
│   │       │   ├── obstacles/                # Obstacle sprites
│   │       │   ├── pause_menu/               # UI button & frame assets
│   │       │   ├── shadow/                   # Duck shadow sprites
│   │       │   └── ui/                       # Menu UI assets
│   │       ├── Story/                        # Cutscene videos + fallback image
│   │       └── styles/                       # JavaFX CSS stylesheets
│   └── packaging/
│       ├── linux/
│       │   └── DuckDash.desktop              # Linux .desktop entry (app menu)
│       └── windows/
│           └── DuckDash.ico                  # Windows installer icon
├── LICENSE.txt                               # GNU GPL v3
├── pom.xml                                   # Maven build configuration
└── README.md
```

---

## 🧑‍💻 Technical Highlights

- **Pure JavaFX, zero game engine** — all game logic, the animation loop, and UI are built on `AnimationTimer`, `javafx.scene`, and Canvas 2D rendering.
- **Abstract entity hierarchy** — `Enemy`, `Food`, and `Obstacle` share abstract base classes with overridable hitbox-shrink methods, letting each subclass tune its collision zone independently without touching shared physics logic.
- **Per-level speed architecture** — `Level` defines `getWorldSpeed()`, `getDuckJumpSpeed()`, and `getDuckFallSpeed()`. Endless mode escalates all three dynamically every 20 seconds via configurable increments.
- **Input buffering** — The jump system queues exactly one buffered jump while airborne; releasing the key cancels it, eliminating the double-jump-on-hold bug entirely.
- **Asset caching pipeline** — `AssetLoader` caches images, music `Media` objects, and video URIs at startup. Videos are extracted to temp files on disk to avoid JavaFX `MediaPlayer` JAR-streaming limitations, with retry logic and watchdog timers.
- **Persistent high scores** — Uses the standard Java `Preferences` API — no files, no database, zero external dependencies — for per-user score persistence across sessions.
- **Canvas-rendered HUD** — `LevelProgressBar` renders entirely onto a transparent `Canvas` overlay, fully decoupled from the JavaFX scene graph of game-world entities.
- **Self-contained native distribution** — `jlink` produces a trimmed JVM runtime containing only the required modules; `jpackage` wraps it into a platform-native installer (`.deb` / `.exe`) that requires no pre-installed Java on the end user's machine.
- **Automated CI/CD** — GitHub Actions runs a two-platform build matrix on every commit, and a release pipeline automatically publishes signed native installers to GitHub Releases on every version tag.

---

## 👥 Team

### Team Duck Dash

| Member | Contributions |
|---|---|
| **[Tawfik Rahman Shabab](https://github.com/Shabab47)** | Story & Concept · Game Logic · Sound & Music |
| **[Muhammad Rasek Biswas](https://github.com/MdRasB)** | Project Management · Game Logic · CI/CD Pipeline & Automation |
| **[Abdullah Hil Kafi](https://github.com/aa-jim)** | UI & Scene Design · Entity & Level Design · Sound & Music |

---

## 🛠️ Built With

| Category | Technology |
|---|---|
| **Language** | Java 21 (JDK 21.0.10) |
| **UI Framework** | JavaFX 21 |
| **Build Tool** | Apache Maven 3.8+ |
| **Native Packaging** | jlink · jpackage (JDK 21) |
| **CI / CD** | GitHub Actions |
| **Version Control** | Git · GitHub |
| **IDE** | IntelliJ IDEA · VS Code |
| **Design** | Figma · ibisPaint |
| **Audio / Video Editing** | CapCut · BeepBox |
| **Music Generation** | Suno AI |
| **Diagrams & Docs** | Markdown · Mermaid.js · Shell scripting |
| **AI Development Assistance** | Anthropic Claude · Google Gemini · OpenAI ChatGPT |

---

## 📄 License

Distributed under the **GNU General Public License v3.0 or later**.  
See [`LICENSE.txt`](LICENSE.txt) for the full license text.

```
    Duck Dash - simple runner game Copyright (C) 2026-present Duck Dash Team

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
```

---

<div align="center">

Made with late nights and bad ideas — but we shipped it. 🦆

**By Team Duck Dash**

</div>
