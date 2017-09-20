/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import SharedData.SharedData;
import myWindow.MyWindow;
import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hanson
 */
public class QueueSystem extends Application {
    
    public MyWindow rootWindow;
    public Stack<Stage> stages;
    public Stack<Scene> scenes;
    
    public QueueSystem() {
        
    }
    @Override
    public void start(Stage stage) throws Exception {
        SharedData data = SharedData.getInstance();
        rootWindow = new MyWindow(stage);
        rootWindow.setTitle("行政執行署-台南分署：叫號系統");
        rootWindow.init(SharedData.getInstance().fxmlDir + "Root.fxml");
        rootWindow.open();
        
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
