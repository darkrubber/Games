package hw2;

/**
 * Represents a player in the Candyland game
 *
 * @author Dell
 */
class Player {

    private String name;    // of the player
    private int position;   // on the board

    static final int INITIAL_POSITION = -1;

    /**
     * Initialize name and position of the player
     *
     * @param _name name of the player
     */
    Player(String _name) {
        name = _name;
        position = INITIAL_POSITION;
    }

    /**
     *
     * @return name of the player
     */
    String getName() {
        return name;
    }

    /**
     *
     * @return position of the player on the board
     */
    int getPosition() {
        return position;
    }

    /**
     * Update position of the player
     *
     * @param newPosition where the player has moved
     */
    void setPosition(int newPosition) {
        position = newPosition;
    }

}
