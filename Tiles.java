/**
 * @version date (2019-08-30)
 * @author Amadaya Michael
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Tiles extends Application{
    private Board board = new Board();
    private int indexCurrent = -1;
    private int indexSelected = -1;
    private static Tile currentTile;
    private static Tile nullTile = new Tile(-100, -99, -100, -99);

    public static void main(String[] args){
        System.out.println("Welcome to Tiles");
        currentTile = nullTile;
        launch(args);
    }

    public void start(Stage primaryStage){
        //sets the title
        primaryStage.setTitle("Tiles: The Game");
        //the basis for the grid and the score
        BorderPane base = new BorderPane();
        /*
        GridPane that holds the rectangles
        that represent the tile objects
         */
        GridPane boardDisp = new GridPane();

        /*
        Creates 24 tiles, three rectangles per
        tile. Paints based on the colors set in
        the tile object
         */
        int tilesCreated = 0;
        while(tilesCreated < 24){
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 4; j++){
                    Rectangle r = new Rectangle();
                    Rectangle rSmaller = new Rectangle();
                    Rectangle rSmallest = new Rectangle();
                    //will need to check these
                    int xC = 120 * i;
                    int yC = 120 * j;
                    r.setX(xC);
                    r.setY(yC);
                    rSmaller.setX(xC);
                    rSmaller.setY(yC);
                    rSmallest.setX(xC);
                    rSmallest.setY(yC);

                    r.setWidth(120);
                    r.setHeight(120);
                    rSmaller.setWidth(80);
                    rSmaller.setHeight(80);
                    rSmallest.setWidth(40);
                    rSmallest.setHeight(40);

                    r.setArcWidth(5);
                    r.setArcHeight(5);
                    rSmaller.setArcWidth(5);
                    rSmaller.setArcHeight(5);
                    rSmallest.setArcHeight(5);
                    rSmallest.setArcWidth(5);

                    Color fill = board.tileSet.get(tilesCreated).getOuterColor();
                    r.setFill(fill);
                    fill = board.tileSet.get(tilesCreated).getMidColor();
                    rSmaller.setFill(fill);
                    fill = board.tileSet.get(tilesCreated).getInnerColor();
                    rSmallest.setFill(fill);

                    boardDisp.add(r, i, j);
                    boardDisp.add(rSmaller, i, j);
                    boardDisp.add(rSmallest, i, j);

                    tilesCreated++;
                }
            }
        }

        /*
        scoreBoard displays the current and longest streaks.
        This information is retrieved from the board.
         */
        Pane scoreBoard = new Pane();
        int score = board.getCurrStreak();
        int highscore = board.getLongestStreak();
        Text scoreDisp = new Text("Current streak: " + score);
        Text highDisp = new Text("Longest streak: " + highscore);
        scoreBoard.getChildren().add(scoreDisp);
        scoreBoard.getChildren().add(highDisp);

        //Tiles and score are added to the base pane
        base.setLeft(boardDisp);
        base.setRight(scoreBoard);
        base.centerProperty();

        Scene scene = new Scene(base, 800, 480);
        //Handles the player click and gives coordinates to handleClick method
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse click recognized!!");
                double xCoord = event.getX();
                double yCoord = event.getY();
                System.out.println(xCoord + "," + yCoord);
                handleClick(xCoord, yCoord);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Checks for a valid click by the player. Does nothing if
     * clicked outside of the bounds. Sets the current tile if
     * first move by player or if the previous move was invalid.
     * Compares the selected tile against the current tile.
     * Removes any sections that share a color, ie. if the tile
     * has the same colors in all three sections, the entire tile
     * is removed.
     * @param xCoord x position of the player click
     * @param yCoord y position of the player click
     */
    private void handleClick(double xCoord, double yCoord){
        /*
        Loop performs if first move by player or if invalid
        click was recently performed. Checks for valid click
        by player and saves tile if valid. Index is stored
        for changing colors if necessary.
         */
        if(currentTile.equals(nullTile)){
            for(int i = 0; i < 24; i++){
                boolean current = board.tileSet.get(i).checkRange(xCoord, yCoord);
                if(current){
                    currentTile = board.tileSet.get(i);
                    System.out.println("Valid tile found");
                    indexCurrent = i;
                    i = 25;
                }
            }
            //for debugging, prints if invalid click is performed
            if(currentTile.equals(nullTile)) System.out.println("Valid tile not found");
        }
        else{
            /*
            Sets the selected tile to null for loop. Checks the click against
            the coordinates of the tiles. If a valid tile is found, then it
            is stored in the selected tile variable. Index is stored for
            changing colors if necessary.
             */
            Tile selected = nullTile;
            for(int i = 0; i < 24; i++){
                boolean current = board.tileSet.get(i).checkRange(xCoord, yCoord);
                if(current){
                    selected = board.tileSet.get(i);
                    System.out.println("Valid tile found");
                    indexSelected = i;
                    i = 25;
                }
            }

            //for debugging, prints if invalid click is performed.
            if(selected.equals(nullTile)){
                System.out.println("Valid tile not found");
            }
            else{
                //the colors of the sections of the current tile
                Color innerCurr = currentTile.getInnerColor();
                Color midCurr = currentTile.getMidColor();
                Color outerCurr = currentTile.getOuterColor();

                //the colors of the sections of the selected tile
                Color innerSelect = selected.getInnerColor();
                Color midSelect = selected.getMidColor();
                Color outerSelect = selected.getOuterColor();

                //check for valid move detected
                boolean one = false;
                /*
                Next three checks for same color in each of the three
                sections. If they pass, then the colors of each tile are
                changed to white, the streak is updated, and the check
                is changed to true.
                 */
                if(innerCurr.equals(innerSelect)){
                    //need to use set method
                    board.tileSet.get(indexCurrent).setInnerColor(Color.WHITE);
                    board.tileSet.get(indexSelected).setInnerColor(Color.WHITE);
                    board.updateStreak();
                    one = true;
                }
                if(midCurr.equals(midSelect)){
                    //need to use set method
                    board.tileSet.get(indexCurrent).setMidColor(Color.WHITE);
                    board.tileSet.get(indexSelected).setMidColor(Color.WHITE);
                    board.updateStreak();
                    one = true;
                }
                if(outerCurr.equals(outerSelect)){
                    //need to use set method
                    board.tileSet.get(indexCurrent).setOuterColor(Color.WHITE);
                    board.tileSet.get(indexSelected).setOuterColor(Color.WHITE);
                    board.updateStreak();
                    one = true;
                }

                //uses boolean to switch tile and print message for debugging
                if(one){
                    System.out.println("Valid move!!");
                    currentTile = selected;
                    indexCurrent = indexSelected;
                }
                else{
                    System.out.println("Invalid selection!!");
                    currentTile = nullTile;
                    board.clearStreak();
                }
            }
        }
    }
}