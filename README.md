# XOX_Game
A fully featured, console-based Tic-Tac-Toe game written in Java. It includes a continuous scoring system and allows you to play multiple rounds without restarting the application.

**Key Features:**
* **Two Game Modes:** Play locally against a friend (Player vs. Player) or challenge the computer (Player vs. Computer).
* **Three AI Difficulties:** Choose between Easy, Hard, and Impossible levels.
* **Unbeatable AI Algorithm:** The 'Impossible' difficulty uses a custom algorithm designed to control the center, block player traps, and secure winning forks, making the computer practically impossible to defeat.

## Example Output
```text
Choose gamemode: 
2 Players: (1)
Computer: (2)
2
Choose difficulty: 
Easy: (1)
Hard: (2)
Impossible: (3)
3
Choose X or O: 
X
Enter a square: 
5
  |   |  
---------
  | X |  
---------
O |   |  
Enter a square: 
9
O |   |  
---------
  | X |  
---------
  |   | X
Enter a square: 
3
O | O | X
---------
  | X |  
---------
  |   | X
Enter a square: 
4
O | O | X
---------
X | X | O
---------
  |   | X
Enter a square: 
7
O | O | X
---------
X | X | O
---------
X | O | X
Draw!
Do you want to continue? Y / N
N
Thanks for playing!
