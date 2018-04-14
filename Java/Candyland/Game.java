package hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages the overall Candyland game
 * @author Dell
 */
class Game {

    Board board = new Board();
    List<Player> players = new ArrayList<>();
    int nextCard = 0;
    private final int MIN_PLAYERS = 2;
    private final int MAX_PLAYERS = 6;
    // Name that user can enter to indicate no more players
    private final String DONE_NAME = "done";
 
    /**
     * display description of game
     */
    void printIntro() {
        System.out.println("This is a crude version of Candyland\n");
    }

    /**
     * Get the next card to play
     * @return the next card drawn. Returns null
     * if there are no more cards
     */
    Card draw() {
        Card testCards[] = {
            new Card(Face.PLUMPY, false),
            new Card(Face.YELLOW, true),
            new Card(Face.RED,  false),
            new Card(Face.YELLOW, true),
            new Card(Face.GREEN, false),
            new Card(Face.MR_MINT, false),
            new Card(Face.JOLLY, false),
            new Card(Face.RED, false),
            new Card(Face.GREEN, false),
            new Card(Face.ORANGE, true),
            new Card(Face.GREEN, false),
            new Card(Face.YELLOW, false),
            new Card(Face.RED, false)
            };

        if (nextCard >= testCards.length) {
            return null;
        }
        return testCards[nextCard];
    }

    /**
     * plays the game
     */
    void playGame() {
        // Use nextPlayer to switch among the players
        int nextPlayer = 0;
        boolean done = false;

        printIntro();
        addPlayers();
        Player player = players.get(nextPlayer);

        while (!done) {
            Card card = draw();
            this.nextCard++;

            if (null != card) {
                System.out.println(player.getName() + " draws a "
                   + card);
                player.setPosition(board.move(player.getPosition(), card));

                System.out.println("Player " + player.getName() + " is at position "
                        + player.getPosition());
                if (isWinner(player))
                    break;
                nextPlayer = (nextPlayer + 1) % players.size();
                player = players.get(nextPlayer);
            } else {
                done = true;
            }
        }
        if (isWinner(player)) {
             System.out.println(player.getName() + " wins!");
        } else {
             System.out.println("No winner");
        }
    }

    /**
     * add players to the game
     */
    private void addPlayers() {
        System.out.println("Enter the names of the players (" + MIN_PLAYERS
                + " to " + MAX_PLAYERS + "), ending with '"
                + DONE_NAME + "':");
        Scanner stdin = new Scanner(System.in);
        String name = "not done";
        while (!name.equals(DONE_NAME) && players.size() < MAX_PLAYERS){
            name = stdin.next();
            players.add(new Player(name));
        }
        if (players.size() < MIN_PLAYERS)
            throw new Error("Not enough players -- ending the game");
    }

    /**
     * Check if the player is a winner
     * @param player    player to check
     * @return true if the player has won, false if not
     */
    private boolean isWinner(Player player) {
        return player.getPosition() >= board.winningPosition();
    }

}
