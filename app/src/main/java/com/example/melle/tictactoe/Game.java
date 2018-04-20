package com.example.melle.tictactoe;


import java.io.Serializable;

// maakt class Game
public class Game implements Serializable {

    // initialiseert bordgrootte
    final private int BOARD_SIZE = 3;
    // maakt tiles
    private Tile[][] board;

    // kijken of het de player 1 z'n beurt is
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    // kijken hoeveel zetten gespeeld
    private int movesPlayed=0;
    // boolean maken voor gamover
    private Boolean gameOver;

    // maak een functie game
    public Game() {
        // initialiseer bord
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        // zet alle tiles naar blank
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        // player 1 is aan de beurt
        playerOneTurn = true;
        // het spel is nog niet over
        gameOver = false;
        // aantal zetten is nul
        movesPlayed = 0;
    }

    // functie tile ontvangt rij en kolom
    public Tile draw(int row, int column){

        // als de tile niet blank is, is er een invalid move
        if (board[row][column] != Tile.BLANK) {
            return Tile.INVALID;
        }

        // als speler 1 aan de beurt
        else if (playerOneTurn){
            // speler 1 niet meer aan de beurt
            playerOneTurn = false;
            // zet tile naar CROSS
            board[row][column] = Tile.CROSS;
            // aantal zetten gespeeld +1
            movesPlayed += 1;
            return Tile.CROSS;
        }

        // als speler 2 aan de beurt
        else {
            // speler 2 niet meer aan de beurt
            playerOneTurn = true;
            // zet tile naar CIRCLE
            board[row][column] = Tile.CIRCLE;
            // aantal zetten gespeeld +1
            movesPlayed += 1;
            return Tile.CIRCLE;
        }

    }

    // checken of het spel klaar is
    public GameState check() {
        // als aantal zetten =9  is er remise
        if (movesPlayed == 9) {
            return GameState.DRAW;
        }

        // checken voor een volle rij
        for(int i=0; i<BOARD_SIZE; i++){
                if (board[i][0] == Tile.CROSS && board[i][1] == Tile.CROSS && board[i][2] == Tile.CROSS) {
                    return GameState.PLAYER_ONE;
                }
                else if (board[0][i] == Tile.CROSS && board[1][i] == Tile.CROSS && board[2][i] == Tile.CROSS) {
                    return GameState.PLAYER_ONE;
                }

                else if (board[i][0] == Tile.CIRCLE && board[i][1] == Tile.CIRCLE && board[i][2] == Tile.CIRCLE) {
                    return GameState.PLAYER_ONE;
                }
                else if (board[0][i] == Tile.CIRCLE && board[1][i] == Tile.CIRCLE && board[2][i] == Tile.CIRCLE) {
                    return GameState.PLAYER_ONE;
                }
        }

        // checken voor een schuine rij
        if (board[0][0] == Tile.CROSS && board[1][1] == Tile.CROSS && board[2][2] == Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }
        else if (board[0][2] == Tile.CROSS && board[1][1] == Tile.CROSS && board[2][0] == Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }

        else if (board[0][0] == Tile.CIRCLE && board[1][1] == Tile.CIRCLE && board[2][2] == Tile.CIRCLE) {
            return GameState.PLAYER_ONE;
        }
        else if (board[0][2] == Tile.CIRCLE && board[1][1] == Tile.CIRCLE && board[2][2] == Tile.CIRCLE) {
            return GameState.PLAYER_ONE;
        }

        // als dat allemaal niet het geval is, is de game nog steeds bezig
        else{
            return GameState.IN_PROGRESS;
        }
    }

    // functie om advies te vragen van de computer
    public int advise() {
        // index wordt op 0 gezet
        int index = 0;
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                // eerste tile die niet leeg is wordt geadviseerd aan de speler
                if (board[i][j] == Tile.BLANK){
                    index = (3*i+j+1);
                    return index;
                }
        return index;
    }
}
