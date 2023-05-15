# DodgeUp Game
DodgeUp is a simple game where the player controls a character at the bottom of the screen and tries to avoid vertically falling blocks. The objective is to survive for as long as possible without colliding with any blocks.

### Game Mechanics
- The player character can only move horizontally along the bottom of the screen.
- Blocks fall vertically from the top of the screen towards the player character.
- The player must navigate the character to avoid colliding with the falling blocks.

- The game ends when the player character collides with a block.

- The number of blocks is limited and controlled to prevent the entire screen from being filled with blocks.
- Optionally, a line can be placed slightly below the player character, and blocks disappear when they cross that line.

### Implementation Guidelines

To implement the game, follow these steps:

Create two classes: Block and Human, defining the variables and access levels required for each.

Create a class named Main that serves as the entry point of the game and instantiates objects from the other classes.

Implement an interface named interface with a method showObject that will be implemented by the Human and Block classes. This method is responsible for displaying the objects.

Use your creativity to enhance the game's visual aspects, such as adding a cool background, increasing block speed, displaying and tracking scores, providing multiple chances for the player, designing a CLI or game menu, and showing the game result at the end.

To earn extra points, utilize base data, create a visually appealing interface, implement additional classes, and provide various ways to earn extra points within the game.

Note: The game's specific details, such as the appearance of blocks and additional items, are open to your own interpretation and design choices.

Have fun implementing the DodgeUp game!




