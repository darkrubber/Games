package hw2;

/**
 * Board (partial) for Candyland game
 *
 * @author Dell
 */
class Board {

// A partial board for Candyland
// based on the picture at: http://www.lscheffer.com/CandyLand-big.jpg
    private static final Face[] board = {Face.RED, Face.PURPLE,
        Face.YELLOW, Face.BLUE, Face.ORANGE, Face.GREEN,
        Face.RED, Face.PURPLE, Face.PLUMPY, Face.YELLOW,
        Face.BLUE, Face.ORANGE, Face.GREEN, Face.RED,
        Face.PURPLE, Face.YELLOW, Face.BLUE, Face.MR_MINT,
        Face.ORANGE, Face.GREEN, Face.RED, Face.PURPLE,
        Face.YELLOW, Face.BLUE, Face.ORANGE, Face.GREEN,
        Face.RED, Face.PURPLE, Face.YELLOW, Face.BLUE,
        Face.ORANGE, Face.GREEN, Face.RED, Face.PURPLE,
        Face.YELLOW, Face.BLUE, Face.ORANGE, Face.GREEN,
        Face.RED, Face.PURPLE,
        Face.YELLOW, Face.BLUE, Face.JOLLY, Face.ORANGE,
        Face.GREEN, Face.RED, Face.PURPLE,
        Face.YELLOW, Face.BLUE, Face.ORANGE
    };

    // constants

    static final int FINAL_POSITION = board.length;

    /**
     * Description: Find next place with this particular color/character
     * @param startPos  current position
     * @param  face face of card
     * @return index of next space of chosen color or of character
     *
     */
    int findFace(int startPos, Face face) {
        int pos = startPos + 1;
        // Character position may be behind player's current position
        if (face.is_character())
            pos = 0;
        for (; pos < FINAL_POSITION; pos++) {
            if (board[pos].equals(face)) {
                return pos;
            }
        }
        return FINAL_POSITION;
    }

    /**
     * Description: Compute next position
     * @param startPos  current position
     * @param card  card that was drawn
     * @return next position based on card
     */
    int move(int startPos, Card card) {
        int nextPos;

        nextPos = findFace(startPos, card.getFace());
        if (card.isDoubled()) {
            nextPos = findFace(nextPos, card.getFace());
        }
        return nextPos;
    }

    /**
     * @return the index of the winning position
     */
    int winningPosition() {
        return FINAL_POSITION;
    }
}
