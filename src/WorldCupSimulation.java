/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import javafx.scene.text.TextFlow;

import java.util.ArrayList;

public class WorldCupSimulation extends Application {
    
    Scene scene1;
    Scene scene2;
    Scene scene3;

    ArrayList<Team> concacaf;

    @Override
    public void start(Stage primaryStage) {
        FileInitializer fz = new FileInitializer();
        concacaf = fz.getRegionTeams("CONCACAF");
        ArrayList<Team> afc = fz.getRegionTeams("AFC");
        ArrayList<Team> uefa = fz.getRegionTeams("UEFA");
        ArrayList<Team> caf = fz.getRegionTeams("CAF");
        ArrayList<Team> ofc = fz.getRegionTeams("OFC");
        ArrayList<Team> conmebol = fz.getRegionTeams("CONMEBOL");

        HBox main = new HBox();

        TabPane tabs = new TabPane();
        Tab concacafTab = new Tab("CONCACAF");
        concacafTab.setClosable(false);
        TableColumn<Team, String> concacafNameColumn = new TableColumn<>("Name");
        concacafNameColumn.setMinWidth(200);
        concacafNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<Team> concacafTable = new TableView<>();
        concacafTable.setItems(getTeams("concacaf"));
        concacafTable.getColumns().addAll(concacafNameColumn);

        concacafTab.setContent(concacafTable);





        Tab conmebolTab = new Tab("CONMEBOL");
        conmebolTab.setClosable(false);

        Tab eufaTab = new Tab("EUFA");
        eufaTab.setClosable(false);

        Tab cafTab = new Tab("CAF");
        cafTab.setClosable(false);

        Tab afcTab = new Tab("AFC");
        afcTab.setClosable(false);

        Tab ofcTab = new Tab("OFC");
        ofcTab.setClosable(false);

        tabs.getTabs().addAll(concacafTab, conmebolTab, eufaTab, cafTab, afcTab, ofcTab);


        InfoBox iq = new InfoBox();
        //iq.instructions();
        BracketPane bp = new BracketPane();
//        bp.display();
        Button start = new Button();
        start.setText("Start Simulation");
        Button info = new Button();
        info.setText("Information");
        info.setOnAction(e -> iq.instructions());
        Button instructions = new Button();
        instructions.setText("Instructions");
        ToolBar startBar = new ToolBar(start, info, instructions);
        startBar.setOrientation(Orientation.VERTICAL);
        BorderPane startPage = new BorderPane();
//        startPage.setCenter(startBar);
        
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


        main.getChildren().addAll(startBar, tabs);


        
        Scene scene = new Scene(main, 800, 600);
       // scene1 = new Scene(root);
        //instructions.setOnAction(e -> primaryStage.setScene(scene1));
        primaryStage.setTitle("The World Cup");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        
        primaryStage.show();
    }

    public ObservableList<Team> getTeams(String region) {
        if (region.equals("concacaf")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            concacaf.forEach(concacaf -> teams.add(concacaf));
            return teams;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}



