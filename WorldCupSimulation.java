//package worldcup;

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
    
    //Variables used to create new scenes currently not being used
    Scene scene1;
    Scene scene2;
    Scene scene3;
    
    //Arraylist of each team region
    ArrayList<Team> concacaf;
    ArrayList<Team> afc;
    ArrayList<Team> uefa;
    ArrayList<Team> caf;
    ArrayList<Team> ofc;
    ArrayList<Team> conmebol;

    @Override
    public void start(Stage primaryStage) {
        //Reads from the teamInfo.txt and stores each regions information into respected Arraylist of that region
        FileInitializer fz = new FileInitializer();
        concacaf = fz.getRegionTeams("CONCACAF");
        afc = fz.getRegionTeams("AFC");
        uefa = fz.getRegionTeams("UEFA");
        caf = fz.getRegionTeams("CAF");
        ofc = fz.getRegionTeams("OFC");
        conmebol = fz.getRegionTeams("CONMEBOL");

        HBox main = new HBox();
        TabPane tabs = new TabPane();

        //CONCACAF TAB
        Tab concacafTab = new Tab("CONCACAF");
        concacafTab.setClosable(false);

        TableColumn<Team, String> concacafNameColumn = new TableColumn<>("Name");
        concacafNameColumn.setMinWidth(200);
        concacafNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Team, String> concacafRankColumn = new TableColumn<>("Rank");
        concacafRankColumn.setMinWidth(50);
        concacafRankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));

        TableColumn<Team, String> concacafPointsColumn = new TableColumn<>("Points");
        concacafPointsColumn.setMinWidth(50);
        concacafPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        TableView<Team> concacafTable = new TableView<>();
        concacafTable.setItems(getTeams("concacaf"));
        concacafTable.getColumns().addAll(concacafNameColumn, concacafRankColumn, concacafPointsColumn);

        concacafTab.setContent(concacafTable);

        //CONMEBOL TAB
        Tab conmebolTab = new Tab("CONMEBOL");
        conmebolTab.setClosable(false);

        TableColumn<Team, String> conmebolNameColumn = new TableColumn<>("Name");
        conmebolNameColumn.setMinWidth(200);
        conmebolNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<Team> conmebolTable = new TableView<>();
        conmebolTable.setItems(getTeams("conmebol"));
        conmebolTable.getColumns().addAll(conmebolNameColumn);

        conmebolTab.setContent(conmebolTable);

        //UEFA TAB
        Tab uefaTab = new Tab("UEFA");
        uefaTab.setClosable(false);

        TableColumn<Team, String> uefaNameColumn = new TableColumn<>("Name");
        uefaNameColumn.setMinWidth(200);
        uefaNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<Team> uefaTable = new TableView<>();
        uefaTable.setItems(getTeams("uefa"));
        uefaTable.getColumns().addAll(uefaNameColumn);

        uefaTab.setContent(uefaTable);

        //CAF TAB
        Tab cafTab = new Tab("CAF");
        cafTab.setClosable(false);

        TableColumn<Team, String> cafNameColumn = new TableColumn<>("Name");
        cafNameColumn.setMinWidth(200);
        cafNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<Team> cafTable = new TableView<>();
        cafTable.setItems(getTeams("caf"));
        cafTable.getColumns().addAll(cafNameColumn);

        cafTab.setContent(cafTable);

        //AFC TAB
        Tab afcTab = new Tab("AFC");
        afcTab.setClosable(false);

        TableColumn<Team, String> afcNameColumn = new TableColumn<>("Name");
        afcNameColumn.setMinWidth(200);
        afcNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<Team> afcTable = new TableView<>();
        afcTable.setItems(getTeams("afc"));
        afcTable.getColumns().addAll(afcNameColumn);

        afcTab.setContent(afcTable);

        //OFC TAB
        Tab ofcTab = new Tab("OFC");
        ofcTab.setClosable(false);

        TableColumn<Team, String> ofcNameColumn = new TableColumn<>("Name");
        ofcNameColumn.setMinWidth(200);
        ofcNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<Team> ofcTable = new TableView<>();
        ofcTable.setItems(getTeams("ofc"));
        ofcTable.getColumns().addAll(ofcNameColumn);

        ofcTab.setContent(ofcTable);

        //ADD ALL TABS
        tabs.getTabs().addAll(concacafTab, conmebolTab, uefaTab, cafTab, afcTab, ofcTab);


        
        

BracketPane bp = new BracketPane();
        
        bp.addTeam("test1");
        bp.addTeam("test2");
        bp.addTeam("test3");
        bp.addTeam("test4");
        bp.addTeam("test5");
        bp.addTeam("test6");
        bp.addTeam("test7");
        bp.addTeam("test8");
        bp.addTeam("test9");
        bp.addTeam("test10");
        bp.addTeam("test11");
        bp.addTeam("test12");
        bp.addTeam("test13");
        bp.addTeam("test14");
        bp.addTeam("test15");
        bp.addTeam("test16");
        bp.addTeam("test17");
        bp.addTeam("test18");
        bp.addTeam("test19");
        bp.addTeam("test20");
        bp.addTeam("test21");
        bp.addTeam("test22");
        bp.addTeam("test23");
        bp.addTeam("test24");
        bp.addTeam("test25");
        bp.addTeam("test26");
        bp.addTeam("test27");
        bp.addTeam("test28");
        bp.addTeam("test29");
        bp.addTeam("test30");
        bp.addTeam("test31");
        bp.addTeam("test32");
        bp.addTeam("test33");
        bp.addTeam("test34");
//        bp.display();
        Button start = new Button();
        start.setText("Start Simulation");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { //Creates a new scene with the bracketPane of a team
                primaryStage.setScene(new Scene(bp, 700, 1100));
                primaryStage.setMaximized(true);
            }
        });
                InfoBox iq = new InfoBox();
        //iq.instructions();
        //Information Button
        Button info = new Button("Information");
        info.setOnAction(e -> iq.instructions()); // When button is pressed it runs the instructions method which generates a new scene with a window displaying the String from iq
        Button instructions = new Button();
        instructions.setText("Instructions");
        ToolBar startBar = new ToolBar(start, info, instructions);
        startBar.setOrientation(Orientation.VERTICAL);
        BorderPane startPage = new BorderPane();
//        startPage.setCenter(startBar);
        
        Label label2 = new Label("This is where the instructions go");
        Label label3 = new Label("This is where more info goes");
        
        
      // This code is not implemented into the scene, but it seems like it has a borderpane that has a tab pane with border panes. This might not be able to run in its current state.
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
        // end of code that is not implemented

        
        Scene scene = new Scene(main, 800, 600);

       // scene1 = new Scene(root);
        //instructions.setOnAction(e -> primaryStage.setScene(scene1));
        primaryStage.setTitle("The World Cup");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        
        primaryStage.show();
    }
    
    //Method used to show list of a team from a region.
    public ObservableList<Team> getTeams(String region) {
        if (region.equals("concacaf")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(concacaf);
            return teams;
        } else if (region.equals("conmebol")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(conmebol);
            return teams;
        } else if (region.equals("uefa")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(uefa);
            return teams;
        } else if (region.equals("caf")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(caf);
            return teams;
        } else if (region.equals("afc")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(afc);
            return teams;
        } else if (region.equals("ofc")) {
            ObservableList<Team> teams = FXCollections.observableArrayList();
            teams.addAll(ofc);
            return teams;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}


