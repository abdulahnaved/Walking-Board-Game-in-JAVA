# Walking Board Game Simulation

This project is a Java-based simulation of a dynamic board game where players navigate a grid, interact with tiles of specific values, and earn points. The simulation includes standard player types as well as a unique player with custom movement mechanics. It is designed to demonstrate object-oriented programming concepts and game mechanics.

## Features

### Board and Tile Mechanics

- **Flexible Board Initialization**:
  - Create a uniform `size x size` board or initialize the board with custom dimensions and values.
  - Supports boards with variable row lengths, allowing an adaptable tile layout.

- **Tile Value and Position Management**:
  - `getPosition`: Retrieves the current position of a player on the board.
  - `getTile`: Fetches the value of a specified tile; invalid positions return an error.
  - `getTiles`: Provides a copy of all tile values to prevent direct access to internal board data.

- **Movement and Tile Interaction**:
  - Players can move across tiles, with boundary restrictions.
  - `moveAndSet` and `setAndMove` functions enable value updates on tiles before or after movement.

### Player Mechanics

- **Multiple Player Types**:
  - Supports standard player types and a unique **MadlyRotatingBuccaneer** with variable movement patterns based on turn count.

- **Turn-Based Movements and Scoring**:
  - Players alternate turns, with scores based on the values of tiles they visit.
  - The **MadlyRotatingBuccaneer** changes direction based on the number of moves taken, adding variety to gameplay.

### Testing

JUnit 5 is used to verify functionality, including tile value retrieval, player movements, scoring, and custom player behaviors.

## Project Structure

- **WalkingBoard.java**: Core game board logic, including tile and movement management.
- **Player.java**: Defines player properties, movements, and scoring.
- **MadlyRotatingBuccaneer.java**: Implements the special player type with custom movement.
- **Test Suites**: Comprehensive tests for board initialization, tile interactions, and player movements.
