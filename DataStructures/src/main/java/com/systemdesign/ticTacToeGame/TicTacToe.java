package com.systemdesign.ticTacToeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] gameBoard = getTicTacToeGameBoard();

        printGameBoard(gameBoard);

        // playGame is for 2 humans to play
//      playGame(gameBoard, "Ashesh", "David");

        // This one is to play with Computer
        playGameWithComputer(gameBoard, "Ashesh");
    }

    // It is for a human to play with computer
    public static void playGameWithComputer (char[][] gameBoard, String playerOne) {

        Scanner scanner = new Scanner(System.in);
        int pos = 0;
        int counter = 0;
        boolean gameOver = false;
        int maxPositions = 9;

        // Winning Combinations
        List<List<Integer>> winningCombinations = new ArrayList<>();
        populateWinningCombinations(winningCombinations);

        // Player positions
        List<Integer> playerOnePositions = new ArrayList<>();
        List<Integer> playerTwoPositions = new ArrayList<>();

        // Available positions in list
        List<Integer> availablePositions = new ArrayList<>();
        populateAvailablePositions(availablePositions, 1, 9);

        String player = playerOne;
        char symbol = 'x';

        while (!gameOver) {

            // If player is human, prompt and get position, else take random positions for Computer as player2
            if (player.equals(playerOne)) {
                System.out.println("\n" + player + ": Please enter a number (1-9) on an empty position: ");
                pos = scanner.nextInt();
                if (!(pos >= 1 && pos <= 9)) continue;  // (Only) human can make mistakes
            } else {
                // Below will give index of available position randomly
                int randomIndex = new Random().nextInt(availablePositions.size());
                pos = availablePositions.get(randomIndex);
            }

            String result = placePiece(gameBoard, pos, symbol);
            if (!result.equals("done")) {
                printGameBoard(gameBoard);
                continue;
            }
            // Successfully placed symbol at new position, let's remove that from open positions list
            availablePositions.remove(new Integer(pos));    // list.remove(Object o), else it will take int as index!

            // Add player positions
            if (player.equals(playerOne)) {

                playerOnePositions.add(pos);

                if (isGameOver(winningCombinations, playerOnePositions)) {
                    System.out.println("\nPlayer: " + player + " won! Gave over!");
                    gameOver = true;
                    break;
                }

                // Now change to player2
                player = "Computer";
                symbol = '0';
            }
            else {
                playerTwoPositions.add(pos);

                if (isGameOver(winningCombinations, playerTwoPositions)) {
                    System.out.println("\nPlayer: " + player + " won! Gave over!");
                    gameOver = true;
                    break;
                }

                // Change to player1
                player = playerOne;
                symbol = 'x';
            }

            counter++;
            if (counter >= maxPositions) {
                System.out.println("Result was a draw, try again!");
                gameOver = true;
            }
        }
    }

    // It is for two humans to play with each other
    public static void playGame(char[][] gameBoard, String playerOne, String playerTwo) {

        Scanner scanner = new Scanner(System.in);
        int pos = 0;
        int counter = 0;
        boolean gameOver = false;
        int maxPositions = 9;

        // Winning Combinations
        List<List<Integer>> winningCombinations = new ArrayList<>();
        populateWinningCombinations(winningCombinations);

        // Player positions
        List<Integer> playerOnePositions = new ArrayList<>();
        List<Integer> playerTwoPositions = new ArrayList<>();

        String player = playerOne;
        char symbol = 'x';

        while (!gameOver) {

            System.out.println("\n" + player + ": Please enter a number (1-9) on an empty position: ");
            pos = scanner.nextInt();

            if (!(pos >= 1 && pos <= 9)) continue;
            String result = placePiece(gameBoard, pos, symbol);
            if (!result.equals("done")) {
                printGameBoard(gameBoard);
                continue;
            }

            // Add player positions
            if (player.equals(playerOne)) {

                playerOnePositions.add(pos);

                if (isGameOver(winningCombinations, playerOnePositions)) {
                    System.out.println("\nPlayer: " + player + " won! Gave over!");
                    gameOver = true;
                    break;
                }

                // Now change to player2
                player = playerTwo;
                symbol = '0';
            }
            else {
                playerTwoPositions.add(pos);

                if (isGameOver(winningCombinations, playerTwoPositions)) {
                    System.out.println("\nPlayer: " + player + " won! Gave over!");
                    gameOver = true;
                    break;
                }

                // Change to player1
                player = playerOne;
                symbol = 'x';
            }

            counter++;
            if (counter >= maxPositions) {
                System.out.println("Result was a draw, try again!");
                gameOver = true;
            }
        }
    }

    private static void populateAvailablePositions(List<Integer> availablePositions, int first, int last) {
        for (int i=first; i<=last; i++) {
            availablePositions.add(i);
        }
    }

    public static char[][] getTicTacToeGameBoard() {
        return new char[][] {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
    }

    private static boolean isGameOver(List<List<Integer>> winningCombinations, List<Integer> playerPositions) {

        // Let's check if player1 or player2 won already
        for (List<Integer> combination : winningCombinations) {
            if (playerPositions.containsAll(combination)) {
                return true;
            }
        }
        return false;
    }

    private static void populateWinningCombinations(List<List<Integer>> winningCombinations) {

        List<Integer> topRow = new ArrayList<>();
        topRow.add(1);
        topRow.add(2);
        topRow.add(3);
        winningCombinations.add(topRow);

        List<Integer> rightCol = new ArrayList<>();
        rightCol.add(3);
        rightCol.add(6);
        rightCol.add(9);
        winningCombinations.add(rightCol);

        List<Integer> bottomRow = new ArrayList<>();
        bottomRow.add(7);
        bottomRow.add(8);
        bottomRow.add(9);
        winningCombinations.add(bottomRow);

        List<Integer> leftCol = new ArrayList<>();
        leftCol.add(1);
        leftCol.add(4);
        leftCol.add(7);
        winningCombinations.add(leftCol);

        List<Integer> midCol = new ArrayList<>();
        midCol.add(2);
        midCol.add(5);
        midCol.add(8);
        winningCombinations.add(midCol);

        List<Integer> midRow = new ArrayList<>();
        midRow.add(4);
        midRow.add(5);
        midRow.add(6);
        winningCombinations.add(midRow);

        List<Integer> diagLeftToRight = new ArrayList<>();
        diagLeftToRight.add(0);
        diagLeftToRight.add(5);
        diagLeftToRight.add(9);
        winningCombinations.add(diagLeftToRight);

        List<Integer> rightRightToLeft = new ArrayList<>();
        rightRightToLeft.add(3);
        rightRightToLeft.add(5);
        rightRightToLeft.add(7);
        winningCombinations.add(rightRightToLeft);

    }

    private static String placePiece(char[][] gameBoard, int pos, char symbol) {

        String result = "";

        switch (pos) {
            case 1:
                result = doPlacePiece(gameBoard, pos, 0, 0, symbol, result);
                break;
            case 2:
                result = doPlacePiece(gameBoard, pos, 0, 2, symbol, result);
                break;
            case 3:
                result = doPlacePiece(gameBoard, pos, 0, 4, symbol, result);
                break;
            case 4:
                result = doPlacePiece(gameBoard, pos, 2, 0, symbol, result);
                break;
            case 5:
                result = doPlacePiece(gameBoard, pos, 2, 2, symbol, result);
                break;
            case 6:
                result = doPlacePiece(gameBoard, pos, 2, 4, symbol, result);
                break;
            case 7:
                result = doPlacePiece(gameBoard, pos, 4, 0, symbol, result);
                break;
            case 8:
                result = doPlacePiece(gameBoard, pos, 4, 2, symbol, result);
                break;
            case 9:
                result = doPlacePiece(gameBoard, pos, 4, 4, symbol, result);
                break;
            default:
                break;
        }
        return result;
    }

    private static String doPlacePiece(char[][] gameBoard, int pos, int i, int j, char symbol, String result) {

        if (gameBoard[i][j] == ' ') {
            gameBoard[i][j] = symbol;
            System.out.println("");
            printGameBoard(gameBoard);
            result = "done";
        } else {
            System.out.println("Symbol was placed on a non-empty position: " + pos + "!");
        }
        return result;
    }

    private static void printGameBoard(char [][] gameBoard) {
        for (char [] arr : gameBoard) {
            for (char ch : arr) {
                System.out.print(ch);
            }
            System.out.println("");
        }
    }
}
