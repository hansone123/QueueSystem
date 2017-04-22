/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hanson
 */
public abstract  class Controller implements Initializable{
 
    Scene nScene;
    Stage nStage;
    
    public void Controller() {
        
    }
    public void createScene(String fxml) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            Controller contr = fxmlLoader.getController();
            contr.init(scene, nStage);
            this.nStage.setScene(scene);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public void init(Scene scene, Stage stage) {
        this.nScene = scene;
        this.nStage = stage;
        loadData();
    }
    abstract public void loadData();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
