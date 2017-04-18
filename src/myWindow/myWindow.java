/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWindow;

import Controller.Controller;
import java.io.IOException;
import java.util.Stack;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author hanson
 */
public class myWindow {
    Stage stage;
    Scene scene;
    
   
    public myWindow(Stage stage) {
        this.stage = stage;
        
    }
    public void init(String fxml) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml)); 
            this.scene = new Scene(fxmlLoader.load());
            Controller contr = fxmlLoader.getController();
            contr.init(scene, stage);
            this.stage.setScene(this.scene);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void setTitle(String title) {
        stage.setTitle(title);
    }
    public void open() {
        try{
            stage.show();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void close() {
        stage.close();
    }
}
