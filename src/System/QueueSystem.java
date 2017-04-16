/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import data.Data;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hanson
 */
public class QueueSystem extends Application {
    
    public FXMLLoader mainMenuLoader;
    public Stage mainStage;
    public Data data;
    
    @Override
    public void start(Stage stage) throws Exception {
        init(stage);
        paintMainMenu();
        
    }
    public void init(Stage stage) throws IOException {
        this.mainStage = stage;
        initData();
        initMainMenu();
    }
    public void initData() {
        this.data = new Data(10);
    }
    public void initMainMenu() throws IOException{
        
       this.mainMenuLoader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        this.mainStage.setScene(new Scene(mainMenuLoader.load()));
        MainMenuController controller = mainMenuLoader.getController();
        controller.init(this.data);
    }
    public void paintMainMenu() throws IOException {
        this.mainStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
