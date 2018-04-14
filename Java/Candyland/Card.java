package hw2;

/**
 * Represents cards in the Candyland game
 * @author Dell
 */
public class Card {
    private final Face face;        // of card
    private final boolean doubled;    // colors can appear twice

    /**
     * Initialize fields
     * No default constructor because no useful default values
     * @param _face  face value of card
     * @param _doubled  if the value is displayed twice on the card
     */
    public Card(Face _face, boolean _doubled) {
        face = _face;
        doubled = _doubled;
    }
    
    /**
     * @return face of card
     */
    public Face getFace() {
        return face;
    }
    
    /**
     * @return whether card's color is doubled
     */
    public boolean isDoubled() {
        return doubled;
    }
    
    /**
     * @return a basic string representation of the card 
     */
    @Override
    public String toString() {
        if (doubled)
            return "double " + face;
        return face.toString();
    }
}
