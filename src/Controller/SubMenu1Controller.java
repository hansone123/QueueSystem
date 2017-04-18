/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import myWindow.myWindow;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hanson
 */
public class SubMenu1Controller extends Controller {

    /**
     * Initializes the controller class.
     */
    @FXML Button home;
    
   
    @FXML 
    public void handleButtonAction(ActionEvent event) {
        String fxid = ((Control)event.getSource()).getId();
        
        switch(fxid) {
            case "back":
                
                break;
            case "home":
                createScene("/System/rootMenu.fxml");
                break;
            default:
                break;
        }
    }
    public void closeWindow() {
        Stage stage = (Stage)home.getScene().getWindow();
        stage.close();
    }

    @Override
    public void loadData() {
        
    }
}
