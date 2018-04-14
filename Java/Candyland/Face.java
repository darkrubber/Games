package hw2;

/**
 * Domain of possible values for a square on
 * the Candyland board
 *
 * @author Dell
 */
public enum Face {
    // colors
    RED(false), ORANGE(false), YELLOW(false),
    GREEN(false), BLUE(false), PURPLE(false),
    // characters
    PLUMPY(true), MR_MINT(true), JOLLY(true);
    
    boolean isCharacter;

    /**
     * Initialize fields of the Face
     * @param _isCharacter true if the face is a character instead of a color
     */
    Face(boolean _isCharacter) {
        isCharacter = _isCharacter;
    }
    
    /**
     * @return true if the face is a character
     */
    public boolean is_character() {
        return isCharacter;
    }
}
