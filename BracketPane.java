
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package worldcup;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *  @author ben
 *  This class is used to create a bracketpane of all the teams.
 */
public class BracketPane extends GridPane {
    //Variables used throughout the class, these should be set to private.
    ArrayList<BracketNode> teams;
    
   
    int counter;
    int counter2;
    int x;
    int y;
    
    GridPane title;
    GridPane leftTopBracket;
    GridPane leftBottomBracket;
    GridPane winnersBracket;
    GridPane rightTopBracket;
    GridPane rightBottomBracket;
    GridPane loosersBracket;
    
    
    
    //Default constructor 
    public BracketPane(){
        
        teams = new ArrayList<BracketNode>();
        //title = new Label("Fefa");
        counter = 0;
        counter2= 0;
        x=0;
        y=0;
        this.setupBracket();
        this.setMinSize(700, 1100);
        this.setMaxSize(700, 1100);
        title = new GridPane(); //Main gridpane that stores the other 6 gridpanes, also used to store a label in the top center of scene.
        leftTopBracket = new GridPane();
        leftBottomBracket = new GridPane();
        winnersBracket = new GridPane();
        rightTopBracket = new GridPane();
        rightBottomBracket = new GridPane();
        loosersBracket = new GridPane();
        
       
        
        this.setUpGrids();
    }
    
    public void setUpGrids(){
        leftTopBracket.setMinSize(400,250);
        leftBottomBracket.setMinSize(400, 250);
        winnersBracket.setMinSize(400, 100);
        rightTopBracket.setMinSize(400, 250);
        rightBottomBracket.setMinSize(400,250);
        loosersBracket.setMinSize(400, 100);
        title.setMinSize(200, 100);
        title.add(new Label("Fifa"), 0, 0, 1, 1);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){ //adds each Gridpane to the titleGridpane and in where it is should go to
                if(i==1 && j==0){
                    this.add(title, i, j);
                }else if(i==0 && j==1){
                    this.add(leftTopBracket, i, j);
                }else if(i==0 && j==2){
                    this.add(leftBottomBracket, i, j);
                }else if(i==1 && j==1){
                    this.add(winnersBracket, i, j);
                }else if(i==1 && j==2){
                    this.add(loosersBracket,i,j);
                }else if(i==2 && j==1){
                    this.add(rightTopBracket, i, j);
                }else if(i==2 && j==2){
                    this.add(rightBottomBracket, i, j);
                }else if(i==0 && j==0){
                    this.add(this.emptySpace(200,100), i, j, 3, 3); // creates a 200,100 gridpane inside of title gridpane 3 3
                }else{
                    this.add(this.emptySpace(200,100),i,j); //creates a anothe 200,100 gridpane inside of title gridpane at 
                }
            }
        }
        leftTopBracket.add(this.emptySpace(60,30), 0, 0, 5, 8); //adds smaller gridpanes to gridpane at location 5,8 of lefttopBracket, same is done for all of the gridpanes
        leftBottomBracket.add(this.emptySpace(60,30), 0, 0, 5, 8);
        rightTopBracket.add(this.emptySpace(60,30), 0, 0, 5, 8);
        rightBottomBracket.add(this.emptySpace(60,30), 0, 0, 5, 8);
        winnersBracket.add(this.emptySpace(60, 30), 0, 0,5,5);
        loosersBracket.add(this.emptySpace(60, 30), 0, 0, 5, 5);
        
        for(x=0;x<5;x++){ //This is used to store the teams at certain locations on the gridpane
            for(y=1;y<9;y++){
                switch (x) { //A loop that goes through each case one at a time, a total of 5 times
                    case 0:
                        if((y%2)==0){ // if y is even then it adds a team based on location 0,0
                            leftTopBracket.add(teams.get(counter2),x,y);
                            leftBottomBracket.add(teams.get(counter2+4),x,y);
                            rightTopBracket.add(teams.get(counter2+8),x+4,y);
                            rightBottomBracket.add(teams.get(counter2+12),x+4,y);
                            counter2++;
                        }else{ //if it is odd then it adds a new bracketnode of size 60,30 at location 0,1
                            leftTopBracket.add(new BracketNode("     ",60,30),x,y);
                            leftBottomBracket.add(new BracketNode("     ",60,30),x,y);
                            rightTopBracket.add(new BracketNode("      ",60,30),x+4,y);
                            rightBottomBracket.add(new BracketNode("     ",60,30),x+4,y);
                        }   
                        switch (y) { //A loop that goes through each case one at a time, a total of 9 times 
                            case 2: //Adds a team at 0,2
                                winnersBracket.add(teams.get(28), x, y);
                                loosersBracket.add(teams.get(31), x, y);
                                break;
                            case 4: //Adds a team a 0,4
                                winnersBracket.add(teams.get(29), x, y);
                                loosersBracket.add(teams.get(32), x, y);
                                break;
                            default:
                                if(y<5){
                                    winnersBracket.add(new BracketNode("      ",60,30),x,y);
                                    loosersBracket.add(new BracketNode("     ",60,30),x,y);
                                }
                                break;
                        }
                        break;
                        
                    case 1:
                        leftTopBracket.add(new BracketNode("     ",60,30),x,y);
                        leftBottomBracket.add(new BracketNode("     ",60,30),x,y);
                        rightTopBracket.add(new BracketNode("      ",60,30),x,y);
                        rightBottomBracket.add(new BracketNode("     ",60,30),x,y);
                        if(y==3){
                            winnersBracket.add(teams.get(30), x, y);
                            loosersBracket.add(teams.get(33), x, y);
                        }else if(y<5){
                            winnersBracket.add(new BracketNode("      ",60,30),x,y);
                            loosersBracket.add(new BracketNode("     ",60,30),x,y);
                        }
                        break;
                        
                    case 2:
                        switch (y) {
                            case 3:
                                leftTopBracket.add(teams.get(16),x,y);
                                leftBottomBracket.add(teams.get(18),x,y);
                                rightTopBracket.add(teams.get(20),x,y);
                                rightBottomBracket.add(teams.get(22),x,y);
                                winnersBracket.add(new BracketNode("      ",60,30),x,y);
                                loosersBracket.add(new BracketNode("     ",60,30),x,y);
                                break;
                            case 7:
                                leftTopBracket.add(teams.get(17),x,y);
                                leftBottomBracket.add(teams.get(19),x,y);
                                rightTopBracket.add(teams.get(21),x,y);
                                rightBottomBracket.add(teams.get(23),x,y);
                                break;
                            default:
                                leftTopBracket.add(new BracketNode("     ",60,30),x,y);
                                leftBottomBracket.add(new BracketNode("     ",60,30),x,y);
                                rightTopBracket.add(new BracketNode("      ",60,30),x,y);
                                rightBottomBracket.add(new BracketNode("     ",60,30),x,y);
                                if(y<5){
                                    winnersBracket.add(new BracketNode("      ",60,30),x,y);
                                    loosersBracket.add(new BracketNode("     ",60,30),x,y);
                                }
                                break;
                        }
                        break;
                    case 4:
                        if(y==5){
                            leftTopBracket.add(teams.get(24),x,y);
                            leftBottomBracket.add(teams.get(25),x,y);
                            rightTopBracket.add(teams.get(26),x-4,y);
                            rightBottomBracket.add(teams.get(27),x-4,y);
                            
                        }else{
                            leftTopBracket.add(new BracketNode("     ",60,30),x,y);
                            leftBottomBracket.add(new BracketNode("     ",60,30),x,y);
                            rightTopBracket.add(new BracketNode("      ",60,30),x-4,y);
                            rightBottomBracket.add(new BracketNode("     ",60,30),x-4,y);
                            if(y<5){
                                    winnersBracket.add(new BracketNode("      ",60,30),x,y);
                                    loosersBracket.add(new BracketNode("     ",60,30),x,y);
                                }
                        }   break;
                    default:
                        leftTopBracket.add(new BracketNode("     ",60,30),x,y);
                        leftBottomBracket.add(new BracketNode("     ",60,30),x,y);
                        rightTopBracket.add(new BracketNode("      ",60,30),x,y);
                        rightBottomBracket.add(new BracketNode("     ",60,30),x,y);
                        if(y<5){
                            winnersBracket.add(new BracketNode("      ",60,30),x,y);
                            loosersBracket.add(new BracketNode("     ",60,30),x,y);
                        }
                        break;
                }
            } 
        } 
    }
    //sets the size of a gridpane and returns it
    public GridPane emptySpace(int i, int j){
        GridPane g = new GridPane();
        
        g.setMinSize(i, j);
        return g;
    }
    //Adds teams to a new bracket node called n
    public void setupBracket(){
        String teamName = "";
        for(int i=0;i<34;i++){
            BracketNode n = new BracketNode(teamName, 60, 30);
            teams.add(n);
        }
    }
    
    //sets the name of a team each time it is called it adds one to name another team in arraylist
    public void addTeam(String n){
        teams.get(counter).setName(n);
        counter++;
        
    }
    

        /**
         * The BracketNode model for the Graphical display of the "Bracket"
         */
        private class BracketNode extends Pane {
                private String teamName;
                private Rectangle rect;
                private Label name;

                /**
                 * Creates a BracketNode with,
                 *
                 * @param teamName The name if any
                 * @param x        The starting x location
                 * @param y        The starting y location
                 * @param rX       The width of the rectangle to fill pane
                 * @param rY       The height of the rectangle
                 */
                public BracketNode(String teamName, int rX, int rY) {
                        this.setMaxSize(rX, rY);
                        this.teamName = teamName;
                        rect = new Rectangle(rX, rY);
                        rect.setFill(Color.TRANSPARENT);
                        name = new Label(teamName);
                        
                            
                        
                        // setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                        name.setTranslateX(5);
                        getChildren().addAll(name, rect);
                }

                /**
                 * @return teamName The teams name.
                 */
                public String getName() {
                        return teamName;
                }

                /**
                 * @param teamName The name to assign to the node.
                 */
                public void setName(String teamName) {
                        name.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
                        rect.setFill(Color.TRANSPARENT);
                        this.teamName = " "+teamName+" ";
                        name.setText(teamName);
                }
                
               
        }
}