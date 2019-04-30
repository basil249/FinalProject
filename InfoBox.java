/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldcup;

import java.io.BufferedReader;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.stage.Window;
import java.io.FileReader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Me
 */
public class InfoBox {
    TableView<Team> table;//or league maybe? will we even use this

    
    
    public static void display(String title, String message){
        Stage window = new Stage();
        
        window.setTitle(title);
        window.setMinWidth(250);
        
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());
        
        
        VBox layout = new VBox(500);
        layout.setMinWidth(500);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    
    }
    //no idea if we'll even use this tho???? 
    public void matchInfo(){

        table = new TableView<>();
        //team name column
        TableColumn<Team,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //team score column
        TableColumn<Team,int> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory( new PropertyValueFactory<>("score"));
        //team rank column
        TableColumn<Team,int> rankColumn = new TableColumn<>("Rank");
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank");

    }
