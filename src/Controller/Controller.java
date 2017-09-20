/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import SharedData.SharedData;
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

    public Scene nScene;
    public Stage nStage;
    

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
