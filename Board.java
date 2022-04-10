import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Board{

    /* Represents current streak. 
    will reset to zero if player performs invalid move */
    private int currStreak;
    //represents the longest streak
    private int longestStreak;
    //holds the tiles
    public ArrayList<Tile> tileSet;

    /**
     * Constructor for the Board object
     * Sets the current and longest streaks to zero,
     * creates an array list to store tiles in,
     * and calls the method to create the tiles
     */
    public Board(){
        /*
        This is where we create the new tile set
         */
        currStreak = 0;
        longestStreak = 0;
        tileSet = new ArrayList<>(24);
        //may need to change method calls, review this
        createTiles();
    }

    /**
    * Creates a new set of Tile objects that form the game board
    * Each has a set range for identification
    * Colors are initially set to BLACK
    */
    private void createTiles(){
        //manually setting the tiles, named rownumColnum
        //may need to change the tile boundaries after setting up GridPane
        Tile oneOne = new Tile(0, 120, 0, 120);
        tileSet.add(oneOne);
        Tile oneTwo = new Tile(120,240,0,120);
        tileSet.add(oneTwo);
        Tile oneThree = new Tile(240, 360, 0, 120);
        tileSet.add(oneThree);
        Tile oneFour = new Tile(360,480,0,120);
        tileSet.add(oneFour);
        Tile oneFive = new Tile(480, 600, 0, 120);
        tileSet.add(oneFive);
        Tile oneSix = new Tile(600, 720, 0, 120);
        tileSet.add(oneSix);

        Tile twoOne = new Tile(0, 120, 120, 240);
        tileSet.add(twoOne);
        Tile twoTwo = new Tile(120, 240, 120, 240);
        tileSet.add(twoTwo);
        Tile twoThree = new Tile(240, 360, 120, 240);
        tileSet.add(twoThree);
        Tile twoFour = new Tile(360, 480, 120, 240);
        tileSet.add(twoFour);
        Tile twoFive = new Tile(480, 600, 120, 240);
        tileSet.add(twoFive);
        Tile twoSix = new Tile(600, 720, 120, 240);
        tileSet.add(twoSix);

        Tile threeOne = new Tile(0, 120, 240, 360);
        tileSet.add(threeOne);
        Tile threeTwo = new Tile(120, 240, 240, 360);
        tileSet.add(threeTwo);
        Tile threeThree = new Tile(240, 360, 240, 360);
        tileSet.add(threeThree);
        Tile threeFour = new Tile(360, 3480, 240, 360);
        tileSet.add(threeFour);
        Tile threeFive = new Tile(480, 600, 240, 360);
        tileSet.add(threeFive);
        Tile threeSix = new Tile(600, 720, 240, 360);
        tileSet.add(threeSix);

        Tile fourOne = new Tile(0, 120, 360, 480);
        tileSet.add(fourOne);
        Tile fourTwo = new Tile(120, 240, 360, 480);
        tileSet.add(fourTwo);
        Tile fourThree = new Tile(240, 360, 360, 480);
        tileSet.add(fourThree);
        Tile fourFour = new Tile(360, 480, 360, 480);
        tileSet.add(fourFour);
        Tile fourFive = new Tile(480, 600, 360, 480);
        tileSet.add(fourFive);
        Tile fourSix = new Tile(600, 720, 360, 480);
        tileSet.add(fourSix);

        randomizeTilesInner();
        randomizeTilesMid();
        randomizeTilesOuter();
    }

    /**
     * Randomizes the colors of the inner section of the
     * tiles. Colors are set in pairs to allow for a
     * winnable game. Tile colors are checked against
     * Color.BLACK, as that is the initial color.
     */
    private void randomizeTilesInner(){
        /*
        The set vars represent the number of pairs set
        for each of my chosen colors. This way I can make sure
        there is a tile with a corresponding color
         */
        int yellowSet = 3;
        int lGreenSet = 3;
        int orangeSet = 3;
        int redSet = 3;
        int random1;
        int random2;

        while(yellowSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getInnerColor();
            Color check2 = tileSet.get(random2).getInnerColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getInnerColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getInnerColor();
            }

            tileSet.get(random1).setInnerColor(Color.GOLD);
            tileSet.get(random2).setInnerColor(Color.GOLD);
            yellowSet -= 1;
        }

        while(lGreenSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getInnerColor();
            Color check2 = tileSet.get(random2).getInnerColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getInnerColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getInnerColor();
            }

            tileSet.get(random1).setInnerColor(Color.LIME);
            tileSet.get(random2).setInnerColor(Color.LIME);
            lGreenSet -= 1;
        }

        while(orangeSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getInnerColor();
            Color check2 = tileSet.get(random2).getInnerColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getInnerColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getInnerColor();
            }

            tileSet.get(random1).setInnerColor(Color.ORANGE);
            tileSet.get(random2).setInnerColor(Color.ORANGE);
            orangeSet -= 1;
        }

        while(redSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getInnerColor();
            Color check2 = tileSet.get(random2).getInnerColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getInnerColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getInnerColor();
            }

            tileSet.get(random1).setInnerColor(Color.RED);
            tileSet.get(random2).setInnerColor(Color.RED);
            redSet -= 1;
        }
    }

    /**
     * Randomizes the color for the middle section of
     * each of the tiles. Set in pairs to allow for a
     * winnable game. Tile colors are checked against
     * Color.BLACK because this is the initial color.
     */
    private void randomizeTilesMid(){
        /*
        The set vars represent the number of pairs set
        for each of my chosen colors. This way I can make sure
        there is a tile with a corresponding color
         */
        int blueSet = 3;
        int purpleSet = 3;
        int dGreenSet = 3;
        int pinkSet = 3;
        int random1;
        int random2;

        while(blueSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getMidColor();
            Color check2 = tileSet.get(random2).getMidColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getMidColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getMidColor();
            }

            tileSet.get(random1).setMidColor(Color.ROYALBLUE);
            tileSet.get(random2).setMidColor(Color.ROYALBLUE);
            blueSet -= 1;
        }

        while(purpleSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getMidColor();
            Color check2 = tileSet.get(random2).getMidColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getMidColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getMidColor();
            }

            tileSet.get(random1).setMidColor(Color.ORCHID);
            tileSet.get(random2).setMidColor(Color.ORCHID);
            purpleSet -= 1;
        }

        while(dGreenSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getMidColor();
            Color check2 = tileSet.get(random2).getMidColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getMidColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getMidColor();
            }

            tileSet.get(random1).setMidColor(Color.MEDIUMSEAGREEN);
            tileSet.get(random2).setMidColor(Color.MEDIUMSEAGREEN);
            dGreenSet -= 1;
        }

        while(pinkSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getMidColor();
            Color check2 = tileSet.get(random2).getMidColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getMidColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getMidColor();
            }

            tileSet.get(random1).setMidColor(Color.LIGHTPINK);
            tileSet.get(random2).setMidColor(Color.LIGHTPINK);
            pinkSet -= 1;
        }
    }

    /**
     * Randomizes the color of the outer section of each
     * tile. Tiles are colored in pairs to allow for a winnable game.
     * Tile colors are checked against Color.BLACK because this is
     * the initial color of each tile.
     */
    private void randomizeTilesOuter(){
        /*
        The set vars represent the number of pairs set
        for each of my chosen colors. This way I can make sure
        there is a tile with a corresponding color
         */
        int yellowSet = 3;
        int lGreenSet = 3;
        int orangeSet = 3;
        int redSet = 3;
        int random1;
        int random2;

        while(yellowSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getOuterColor();
            Color check2 = tileSet.get(random2).getOuterColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getOuterColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getOuterColor();
            }

            tileSet.get(random1).setOuterColor(Color.DARKGOLDENROD);
            tileSet.get(random2).setOuterColor(Color.DARKGOLDENROD);
            yellowSet -= 1;
        }

        while(lGreenSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getOuterColor();
            Color check2 = tileSet.get(random2).getOuterColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getOuterColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getOuterColor();
            }

            tileSet.get(random1).setOuterColor(Color.LIGHTGREEN);
            tileSet.get(random2).setOuterColor(Color.LIGHTGREEN);
            lGreenSet -= 1;
        }

        while(orangeSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getOuterColor();
            Color check2 = tileSet.get(random2).getOuterColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getOuterColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getOuterColor();
            }

            tileSet.get(random1).setOuterColor(Color.LIGHTSALMON);
            tileSet.get(random2).setOuterColor(Color.LIGHTSALMON);
            orangeSet -= 1;
        }

        while(redSet > 0){
            random1 = (int)(Math.random() * 23);
            random2 = (int)(Math.random() * 23);
            Color check1 = tileSet.get(random1).getOuterColor();
            Color check2 = tileSet.get(random2).getOuterColor();
            while(!check1.equals(Color.BLACK)){
                random1 = (int)(Math.random() * 23);
                check1 = tileSet.get(random1).getOuterColor();
            }
            while(!check2.equals(Color.BLACK)){
                random2 = (int)(Math.random() * 23);
                check2 = tileSet.get(random2).getOuterColor();
            }

            tileSet.get(random1).setOuterColor(Color.FIREBRICK);
            tileSet.get(random2).setOuterColor(Color.FIREBRICK);
            redSet -= 1;
        }
    }

    /**
     * Used to increment the streak value when the player
     * performs a valid move. Current streak is increased
     * by a value of 1. If the current streak is greater
     * than the longest streak, then the value is updated.
     */
    public void updateStreak(){
        currStreak += 1;
        if(longestStreak < currStreak){
            longestStreak = currStreak;
        }
    }

    /**
     * Resets the current streak to zero when
     * the player makes an invalid move
     */
    public void clearStreak(){
        currStreak = 0;
    }

    /**
    * This method retrieves the current streak value.
    * Would be used by the board to update the GUI after a click
    * @return int value representing the current streak
    */
    public int getCurrStreak() {
        return currStreak;
    }

    /**
    * This method retrieves the longest streak value.
    * Would be used by the board to update the GUI after a click
    * No visible update so long as longest > current
    * @return int representing the longest streak
    */
    public int getLongestStreak() {
        return longestStreak;
    }
}
