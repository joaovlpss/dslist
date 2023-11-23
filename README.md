## Introduction
This backend serves a web-based game library, facilitating game and game list management. Built with Java and Spring Boot, it offers a suite of RESTful APIs for game-related operations.

## Project Structure

### Main Application
- **DslistApplication.java**: Initializes and runs the Spring Boot application.

### Configuration
- **WebConfig.java**: Configures CORS and other web-centric settings.

### Controllers
- **GameController.java**: Manages requests for game-related operations.
- **GameListController.java**: Handles requests for game list operations.

### Data Transfer Objects (DTOs)
- **GameDTO.java**: Transfers detailed game data.
- **GameListDTO.java**: Transfers detailed game list data.
- **GameMinDTO.java**: Transfers minimal game data.
- **ReplacementDTO.java**: Transfers data for reordering games in a list.

### Entities
- **Game.java**: Represents the game entity.
- **GameList.java**: Represents the game list entity.
- **Belonging.java**: Represents the relationship between games and lists.
- **BelongingPK.java**: Primary key for the 'Belonging' entity.

### Projections
- **GameMinProjection.java**: Minimal projection of game data.

### Repositories
- **GameRepository.java**: Interface for game data operations.
- **GameListRepository.java**: Interface for game list data operations.

### Services
- **GameService.java**: Business logic for game operations.
- **GameListService.java**: Business logic for game list operations.

## API Endpoints

### GET
1. **Get Games by List**: `/lists/{listId}/games` - Retrieves games in a specific list.
2. **Get Game Lists**: `/lists` - Retrieves all game lists.
3. **Get Games**: `/games` - Retrieves all games.
4. **Get Game by ID**: `/games/{gameId}` - Retrieves a specific game by its ID.

### POST
1. **Change Game Order in List**: `/lists/{listId}/replacement` - Changes the order of games in a list.
   - Body:
     ```json
     {
         "sourceIndex": X,
         "destinationIndex": Y
     }
     ```