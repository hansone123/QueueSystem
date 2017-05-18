/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hanson
 */
public class CreateScene extends Command {

    String fxml;
    Stage stage;
    public CreateScene(String fxml, Stage stage) {
        this.fxml = fxml;
        this.stage = stage;
    }
    @Override
    public void execute() {
       try{
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            Controller contr = fxmlLoader.getController();
            contr.init(scene, stage);
            this.stage.setScene(scene);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
       
    }
    
}
