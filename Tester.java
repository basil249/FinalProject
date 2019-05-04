 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import java.awt.Frame;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JFrame;


   

/**
 *
 * @author ben
 */
public class Tester extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        BracketPane root = new BracketPane();
        Scene scene = new Scene(root);
        primaryStage.setMaximized(true);

        primaryStage.setTitle("March Madness Bracket Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setWidth(1100);
        primaryStage.setHeight(700);
        primaryStage.setResizable(true);
        
        root.addTeam("test1");
        root.addTeam("test2");
        root.addTeam("test3");
        root.addTeam("test4");
        root.addTeam("test5");
        root.addTeam("test6");
        root.addTeam("test7");
        root.addTeam("test8");
        root.addTeam("test9");
        root.addTeam("test10");
        root.addTeam("test11");
        root.addTeam("test12");
        root.addTeam("test13");
        root.addTeam("test14");
        root.addTeam("test15");
        root.addTeam("test16");
        root.addTeam("test17");
        root.addTeam("test18");
        root.addTeam("test19");
        root.addTeam("test20");
        root.addTeam("test21");
        root.addTeam("test22");
        root.addTeam("test23");
        root.addTeam("test24");
        root.addTeam("test25");
        root.addTeam("test26");
        root.addTeam("test27");
        root.addTeam("test28");
        root.addTeam("test29");
        root.addTeam("test30");
        root.addTeam("test31");
        root.addTeam("test32");
        root.addTeam("test33");
        root.addTeam("test34");
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

