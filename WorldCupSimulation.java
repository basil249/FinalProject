/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldcup;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import javafx.scene.text.TextFlow;

public class WorldCupSimulation extends Application {
    
    Scene scene1;
    Scene scene2;
    Scene scene3;
    @Override
    public void start(Stage primaryStage) {
        InfoBox iq = new InfoBox();
        //iq.instructions();
        
        Button start = new Button();
        start.setText("Start Simulation");
        Button info = new Button();
        info.setText("Information");
        info.setOnAction(e -> iq.instructions());
        Button instructions = new Button();
        instructions.setText("Instructions");
        ToolBar startBar = new ToolBar(start, info, instructions);
        BorderPane startPage = new BorderPane();
        startPage.setCenter(startBar);
        
        Label label2 = new Label("This is where the instructions go");
        Label label3 = new Label("This is where more info goes");
        
        
      
        BorderPane instructionPane = new BorderPane();
        instructionPane.setTop(instructions);
        
        BorderPane root = new BorderPane();
        Tab i = new Tab();
        i.setText("Navigation");
        
        i.setContent(instructionPane);
        
        Tab in = new Tab();
        in.setText("Information");
        in.setContent(label3);
        TabPane instructions2 = new TabPane(i, in);
        
        root.setCenter(instructions2);
        
        Scene scene = new Scene(startPage, 800, 600);
       // scene1 = new Scene(root);
        //instructions.setOnAction(e -> primaryStage.setScene(scene1));
        primaryStage.setTitle("The World Cup");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}



