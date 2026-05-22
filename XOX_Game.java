import java.util.Scanner;

public class XOX_Game {
	static int gameMode = -1;
	static int difficulty = -1;
	static int scoreP1 = 0;
	static int scoreP2 = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) { 
		
		String playAgain = ""; 
		
		gameModeSelector();
		
		do {
		
			boolean isFinished = false; 
			String[] table = new String[9]; 
			for (int i = 0; i < 9; i++) {
				table[i] = "";
			}
			int count = 0; 
			String player1 = ""; 
			String player2 = "";
			String currentXO = "X";
		
			player1 = XOSelector();
			player2 = XorO(player1);
			
			while (count < 9) {
				if (currentXO.equals(player1)) {
					humanMove(table, player1, 1);
				}
				else {
					if (gameMode == 1) {
						humanMove(table, player2, 2);
					}
					else if (gameMode == 2){
						computerMove(table, player2);
					}
				}
				print(table);
				count++;

				if(currentXO.equals("X")){
					currentXO = "O";
				}
				else {
					currentXO = "X";
				}
				if (checker(table, player1, player2)) {
					isFinished = true;
					break;
				}
			}
			if (count == 9 && isFinished == false) {
				System.out.println("Draw!");
			}
			playAgain = playAgain();
			
		} while (playAgain.toUpperCase().equals("Y"));
		System.out.println("Thanks for playing!");
	}
	public static void gameModeSelector() {
		while (true) {
			System.out.println("Choose gamemode: \n2 Players: (1)\nComputer: (2)");
			gameMode = sc.nextInt();
			sc.nextLine();
			if (gameMode == 1 || gameMode == 2) {
				if (gameMode == 2) {
					difficulty();
				}
				break;
			}
			else {
				System.out.println("Please enter a valid number.");
				continue;
			}
		}
	}
	public static void difficulty() {
		while (true) {
			System.out.println("Choose difficulty: \nEasy: (1)\nHard: (2)\nImpossible: (3)");
			difficulty = sc.nextInt();
			sc.nextLine();
			if (difficulty == 1 || difficulty == 2 || difficulty == 3) {
				break;
			}
			else {
				System.out.println("Please enter a valid number.");
				continue;
			}
		}
	}
	public static String XOSelector() {
		String player1 = "";
		while (true) {
			System.out.println("Choose X or O: ");
			player1 = sc.nextLine().toUpperCase();
			if (player1.toUpperCase().equals("X") || player1.toUpperCase().equals("O")) {
				return player1;
			}
			else {
				System.out.println("Please choose only X or O:");
				continue;
				}
		}
	}
	public static void humanMove(String[] table, String player, int whosTurn) {
		while (true) {
			if (gameMode == 1) {
				System.out.println("Player " + whosTurn + "s turn: ");
			}
			else {
				System.out.println("Enter a square: ");
			}
			int square = sc.nextInt();
			sc.nextLine();
			if ((1 <= square && square <= 9) && table[square - 1].equals("")) {
				table[square - 1] = player;
				break;
			}
			else {
				System.out.println("Please choose an empty one or enter a number between 1 and 9 include:");
				continue;
			}
		}
	}
	public static void computerMove(String[] table, String player) {
		if (difficulty == 1) {
			easyComputerMove(table, player);
		}
		else if (difficulty == 2){
			hardComputerMove(table, player);
		}
		else {
			impossibleComputerMove(table, player);
		}
	}
	public static void easyComputerMove(String[] table, String player) {
		while (true) {
			int random = (int)(Math.random() * 9);
			if (table[random].equals("")) {
				table[random] = player;
				break;
			}
		}
	}
	public static void hardComputerMove(String[] table, String player) {
		String humanXO = XorO(player);
		
		int[][] possibilities = {
				{2, 4, 6},
				{0, 4, 8},
				{0, 3, 6},
				{1, 4, 7},
				{2, 5, 8},
				{0, 1, 2},
				{3, 4, 5},
				{6, 7, 8}
		};
		for (int[] pos : possibilities) {
			int computerXOAmount = 0;
			int spaceAmount = 0;
			int indexOfSpace = -1;
			for (int i = 0; i < 3; i++) {
				if (table[pos[i]].equals(player)) {
					computerXOAmount++;
				}
				else if (table[pos[i]].equals("")) {
					spaceAmount++;
					indexOfSpace = pos[i];
				}
			}
			if (computerXOAmount == 2 && spaceAmount == 1) {
				table[indexOfSpace] = player;
				return;
			}
		}
		for (int[] pos : possibilities) {
			int humanXOAmount = 0;
			int spaceAmount = 0;
			int indexOfSpace = -1;
			for (int i = 0; i < 3; i++) {
				if (table[pos[i]].equals(humanXO)) {
					humanXOAmount++;
				}
				else if (table[pos[i]].equals("")) {
					spaceAmount++;
					indexOfSpace = pos[i];
				}
			}
			if (humanXOAmount == 2 && spaceAmount == 1) {
				table[indexOfSpace] = player;
				return;
			}
		}
		while (true) {
			int random = (int)(Math.random() * 9);
			if (table[random].equals("")) {
				table[random] = player;
				return;
			}
		}
	}
	public static void impossibleComputerMove(String[] table, String player) {
		String humanXO = XorO(player);
		
		int[][] possibilities = {				
				{2, 4, 6},
				{0, 4, 8},
				{0, 3, 6},
				{1, 4, 7},
				{2, 5, 8},
				{0, 1, 2},
				{3, 4, 5},
				{6, 7, 8}
		};
		for (int[] pos : possibilities) {
			int computerXOAmount = 0;
			int spaceAmount = 0;
			int indexOfSpace = -1;
			for (int i = 0; i < 3; i++) {
				if (table[pos[i]].equals(player)) {
					computerXOAmount++;
				}
				else if (table[pos[i]].equals("")) {
					spaceAmount++;
					indexOfSpace = pos[i];
				}
			}
			if (computerXOAmount == 2 && spaceAmount == 1) {
				table[indexOfSpace] = player;
				return;
			}
		}
		for (int[] pos : possibilities) {
			int humanXOAmount = 0;
			int spaceAmount = 0;
			int indexOfSpace = -1;
			for (int i = 0; i < 3; i++) {
				if (table[pos[i]].equals(humanXO)) {
					humanXOAmount++;
				}
				else if (table[pos[i]].equals("")) {
					spaceAmount++;
					indexOfSpace = pos[i];
				}
			}
			if (humanXOAmount == 2 && spaceAmount == 1) {
				table[indexOfSpace] = player;
				return;
			}
		}
		
		if (table[4].equals("")) {
			table[4] = player;
			return;
		}
		
		boolean cornerTrap1 = table[0].equals(humanXO) && table[8].equals(humanXO);
		boolean cornerTrap2 = table[2].equals(humanXO) && table[6].equals(humanXO);

		if (cornerTrap1 || cornerTrap2) {
		    int[] safeEdges = {1, 3, 5, 7};
		    for (int edge : safeEdges) {
		        if (table[edge].equals("")) {
		            table[edge] = player;
		            return;
		        }
		    }
		}
		
		int[] corners = {0, 2, 6, 8};

		for (int corner : corners) {
		    if (table[corner].equals("")) {
		        boolean threatHorz = false; 
		        boolean threatVert = false;
		        
		        if (corner == 0) {
		            threatHorz = table[1].equals(humanXO) || table[2].equals(humanXO);
		            threatVert = table[3].equals(humanXO) || table[6].equals(humanXO);
		        }
		        else if (corner == 2) {
		            threatHorz = table[0].equals(humanXO) || table[1].equals(humanXO);
		            threatVert = table[5].equals(humanXO) || table[8].equals(humanXO);
		        }
		        else if (corner == 6) {
		            threatHorz = table[7].equals(humanXO) || table[8].equals(humanXO);
		            threatVert = table[0].equals(humanXO) || table[3].equals(humanXO);
		        }
		        else if (corner == 8) {
		            threatHorz = table[6].equals(humanXO) || table[7].equals(humanXO);
		            threatVert = table[2].equals(humanXO) || table[5].equals(humanXO);
		        }
		        if (threatHorz && threatVert) {
		            table[corner] = player;
		            return;
		        }
		    }
		}
		
		for (int[] pos : possibilities) {
			
			int computerXOAmount = 0;
			int spaceAmount = 0;
			int indexOfSpace = -1;
			
			for (int i = 0; i < 3; i++) {
				if (table[pos[i]].equals(player)) {
					computerXOAmount++;
				}
				else if (table[pos[i]].equals("")) {
					spaceAmount++;
					if (pos[i] == 0 || pos[i] == 2 || pos[i] == 6 || pos[i] == 8) {
						indexOfSpace = pos[i];
					}
					else if (indexOfSpace < 0) {
						indexOfSpace = pos[i];
					}
				}
			}
			if (computerXOAmount == 1 && spaceAmount == 2) {
				table[indexOfSpace] = player;
				return;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (table[corners[i]].equals("")) {
				table[corners[i]] = player;
				return;
			}
		}
		
		while (true) {
			int random = (int)(Math.random() * 9);
			if (table[random].equals("")) {
				table[random] = player;
				return;
			}
		}
	}
	public static String playAgain() {
		String playAgain = "";
		System.out.println("Do you want to continue? Y / N");
		while (true) {
			playAgain = sc.nextLine();
			if (playAgain.toUpperCase().equals("Y") || playAgain.toUpperCase().equals("N")) {
				if(playAgain.toUpperCase().equals("Y")) {
					return "Y";
				}
				else {
					return "N";
				}
			}
			else {
				System.out.println("Please enter Y or N.");
				continue;
			}
		}
	}
	public static boolean checker(String[] table, String player1, String player2) {
		int[][] possibilities = {
				{2, 4, 6},
				{0, 4, 8},
				{0, 3, 6},
				{1, 4, 7},
				{2, 5, 8},
				{0, 1, 2},
				{3, 4, 5},
				{6, 7, 8}
		};
		for (int[] pos : possibilities) {
			String s1 = table[pos[0]];
			String s2 = table[pos[1]];
			String s3 = table[pos[2]];
			
			if (!s1.equals("")) {
				if (s1.equals(s2) && s2.equals(s3)) {
					if (s1.equals(player1)) {
						print(table);
						if (gameMode == 1) {
							System.out.println("Player 1 won!");
							scoreP1 += 10;
						}
						else {
							System.out.println("Player won!");
							if (difficulty == 1) {
								scoreP1 += 10;
							}
							else {
								scoreP1 += 5;
							}
						}
					}
					else if (s1.equals(player2)){
						print(table);
						if (gameMode == 1) {
							System.out.println("Player 2 won!");
							scoreP2 += 10;
						}
						else {
							System.out.println("Computer won!");
							if (difficulty == 1) {
								scoreP2 += 10;
							}
							else {
								scoreP2 += 5;
							}
						}
					}
					if (gameMode == 1) {
						System.out.println("Player 1's Score: " + scoreP1 + "\nPlayer 2's Score: " + scoreP2);
					}
					else {
						System.out.println("Player's Score: " + scoreP1 + "\nComputer's Score: " + scoreP2);
					}
					return true;
				}
			}
		}
		return false;
	}
	public static void print(String[] table) {
		for (int i = 0; i < 9 ; i++) {
			if (table[i].equals("X")) {
				if (i % 3 == 2) {
					System.out.print("X" + "\n");
				}
				else {
					System.out.print("X" + " | ");
				}
			}
			else if (table[i].equals("O")){
				if (i % 3 == 2) {
					System.out.print("O" + "\n");
				}
				else {
					System.out.print("O" + " | ");
				}
			}
			else {
				if (i % 3 == 2) {
					System.out.print(" " + "\n");
				}
				else {
					System.out.print(" " + " | ");
				}
			}
			if (i == 2 || i == 5) {
				System.out.println("---------");
			}
		}
	}

	public static String XorO(String player1) {
		if (player1.equals("X"))
			return "O";
		else 
			return "X";
	}
}