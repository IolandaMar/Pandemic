# Pandemic Game

Digital implementation of the popular board game **Pandemic**, where players collaborate as a team of disease-fighting specialists to save humanity from global outbreaks.

## About the Game

In Pandemic, players work together to treat infections around the world while gathering resources for cures. As skilled members of a disease-fighting team, you must keep four deadly diseases at bay while discovering their cures. You and your teammates will travel across the globe, treating infections while finding resources for cures. You must work as a team to succeed - the fate of humanity is in your hands!

## Tech Stack

- **Backend**: Java with Swing GUI (Game logic and user interface)
- **Database**: Oracle Database (Game progress and player statistics)
- **Development Environment**: Eclipse IDE
- **Database Connectivity**: JDBC (ojdbc8.jar)

## Features

### Core Gameplay
- **Cooperative Strategy**: Work as a team to prevent global pandemic
- **Disease Management**: Treat infections and prevent outbreaks
- **Cure Discovery**: Research and develop cures for four diseases
- **Global Travel**: Move between cities to manage worldwide threats

### Technical Features
- **Java Swing Interface**: Desktop application with intuitive GUI
- **Oracle Database Integration**: Persistent data storage with JDBC connectivity
- **Save/Load System**: Game state persistence through PartidaGuardada.txt
- **Statistics Tracking**: Player performance and game history in Oracle DB
- **Eclipse Project**: Professional IDE setup with proper project structure

### Game Modes
- **Classic Mode**: Standard Pandemic experience following official rules
- **Challenge Scenarios**: Additional difficulty modes for experienced players
- **Custom Games**: Adjustable difficulty settings

## Game Components

### Roles Available
- **Medic**: Treats all cubes of one color in a city
- **Scientist**: Needs only 4 cards to cure a disease
- **Researcher**: Can give any card to another player
- **Operations Expert**: Can build research stations efficiently
- **Dispatcher**: Can move other players' pawns

### Victory Conditions
- Discover cures for all four diseases
- Work together before time runs out
- Prevent global collapse from outbreaks

## Installation & Setup

### Prerequisites
- **Java Development Kit (JDK)** 8 or higher
- **Oracle Database** (local or remote instance)
- **Eclipse IDE** (recommended) or any Java IDE

### Setup Instructions

```bash
# Clone the repository
git clone https://github.com/yourusername/pandemic-game.git

# Navigate to project directory
cd Pandemic-main

# Import into Eclipse
# File -> Import -> Existing Projects into Workspace
# Select the Pandemic-main folder

# Database Setup
# 1. Ensure Oracle Database is running
# 2. The ojdbc8.jar driver is already included in the project
# 3. Configure database connection in the Java source files

# Run the application
# Right-click on main class in Eclipse -> Run As -> Java Application
```

## Database Integration

The game uses **Oracle Database** to manage:
- **Game Sessions**: Save and load game states
- **Player Statistics**: Win/loss ratios, performance metrics
- **Game History**: Previous matches and outcomes
- **Persistent Data**: Long-term game progression tracking

**Connection**: Uses JDBC with ojdbc8.jar driver for Oracle connectivity

## Project Structure

```
Pandemic-main/
├── .classpath                    # Eclipse project configuration
├── .project                     # Eclipse project settings
├── .gitattributes               # Git configuration
├── README.md                    # Project documentation
├── PartidaGuardada.txt          # Game save file
├── ojdbc8.jar                   # Oracle JDBC driver
├── .settings/                   # Eclipse IDE preferences
│   ├── org.eclipse.core.resources.prefs
│   └── org.eclipse.jdt.core.prefs
├── bin/                         # Compiled Java classes
│   ├── img/                     # Game images and assets
│   ├── Instrucciones.class      # Game instructions class
│   ├── Interfaz.class           # Main interface class
│   ├── Marco.class              # Game frame class
│   ├── PanelPrincipal.class     # Main panel class
│   └── PantallaCargarPartida*.class # Load game screens
├── doc/                         # Project documentation
└── src/                         # Java source code
    ├── Instrucciones.java       # Game instructions implementation
    ├── Interfaz.java            # User interface management
    ├── Marco.java               # Application window framework
    ├── PanelPrincipal.java      # Main game panel
    └── PantallaCargarPartida.java # Game loading functionality
```

## Key Components

### Main Classes
- **Marco.java**: Application window and main framework
- **Interfaz.java**: User interface management and event handling
- **PanelPrincipal.java**: Core game panel with main gameplay
- **Instrucciones.java**: Game instructions and help system
- **PantallaCargarPartida.java**: Save/load game functionality

### Features
- **Save System**: Game state persistence via PartidaGuardada.txt
- **Visual Interface**: Swing-based GUI with custom panels
- **Database Integration**: Oracle DB connectivity for statistics
- **Eclipse Integration**: Professional development environment setup

## Screenshots

*[Add screenshots of your game interface here]*

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for:
- Bug fixes
- New features
- UI improvements
- Additional game modes

## Future Enhancements

- [ ] Multiplayer online support
- [ ] Mobile-responsive design
- [ ] Sound effects and animations
- [ ] Additional expansion content
- [ ] AI opponents for solo play

## Technologies Used

![Java](https://img.shields.io/badge/-Java-007396?style=flat-square&logo=java&logoColor=white)
![Oracle](https://img.shields.io/badge/-Oracle-F80000?style=flat-square&logo=oracle&logoColor=white)
![Eclipse](https://img.shields.io/badge/-Eclipse-2C2255?style=flat-square&logo=eclipse&logoColor=white)
![Swing](https://img.shields.io/badge/-Swing-007396?style=flat-square&logo=java&logoColor=white)

## License

This project is for educational purposes. Pandemic is a trademark of Z-Man Games.

## Contact

**Iolanda Martínez Santolaria**
- Email: iolandamartinez20@gmail.com
- LinkedIn: [iolanda-m-749b71311](https://www.linkedin.com/in/iolanda-m-749b71311/)

---

*Can you save humanity? The world is counting on you!*
