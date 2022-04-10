import javafx.scene.paint.Color;

public class Tile{

    //the colors for each of the tile sections
    private Color innerColor;
    private Color midColor;
    private Color outerColor;

    /* these are for checking against the mouse click
        x coord min and max, and y coord min and max
    */
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;

    /**
     * Constructor for the Tile object. Initializes the color of
     * each section to black for checks during randomization and
     * debugging. Sets range of coordinates to check against
     * player click location.
     * @param xMin double representing the minimum x value
     * @param xMax double representing the maximum x value
     * @param yMin double representing the minimum y value
     * @param yMax double representing the maximum y value
     */
    public Tile(double xMin, double xMax, double yMin, double yMax){
        innerColor = Color.BLACK;
        midColor = Color.BLACK;
        outerColor = Color.BLACK;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    /**
    * Used by Board to set the color of the tile
    * @param innerColor the color of the smallest square
    */
    public void setInnerColor(Color innerColor) {
        this.innerColor = innerColor;
    }

    /**
    * Used by Board to set the color of the tile
    * @param midColor the color of the middle square
    */
    public void setMidColor(Color midColor) {
        this.midColor = midColor;
    }

    /**
    * Used by Board to set the color of the tile
    * @param outerColor the color of the outer square
    */
    public void setOuterColor(Color outerColor) {
        this.outerColor = outerColor;
    }

    /**
    * Retrieves the inner color of the tile
    * for checking against other tiles
    * @return innerColor the color of the innermost section
    */
    public Color getInnerColor() {
        return innerColor;
    }

    /**
    * Retrieves the middle color of the tile
    * for checking against other tiles
    * @return midColor the color of the middle section
    */
    public Color getMidColor() {
        return midColor;
    }

    /**
    * Retrieves the outer color of the tile
    * for checking against other tiles
    * @return outerColor the color of the outermost section
    */
    public Color getOuterColor() {
        return outerColor;
    }

    /**
    * Takes the location of the player click and checks
    * against the limits of the tile before continuing
    * to the color check. Returns true if the click is
    * within the bounds
    * @param xClick the x coord of the player click
    * @param yClick the y coord of the player click
    * @return boolean value representing whether the click
    * is within the limits of the tile
    */
    public boolean checkRange(double xClick, double yClick){
        //is the click within the confines of this tile?
        boolean xFit = false;
        boolean yFit = false;
        if((xClick >= xMin) && (xClick < xMax)){
            xFit = true;
        }
        if((yClick >= yMin) && (yClick < yMax)){
            yFit = true;
        }
        //i do this to avoid nested loops
        if(xFit && yFit){
            return true;
        }
        else return false;
    }
}