/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import myWindow.myWindow;
import myWindow.rootWindow;
import data.Data;
import java.io.IOException;
import java.util.Stack;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Hanson
 */
public class QueueSystem extends Application {
    
    public myWindow rootWindow;
    public Stack<Stage> stages;
    public Stack<Scene> scenes;
    
    public QueueSystem() {
        
    }
    @Override
    public void start(Stage stage) throws Exception {
        rootWindow = new myWindow(stage);
        rootWindow.setTitle("行政執行署-台南分署：叫號系統");
        rootWindow.init("/System/rootMenu.fxml");
        rootWindow.open();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
