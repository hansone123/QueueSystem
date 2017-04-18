/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import myWindow.SubWindow;
import myWindow.myWindow;
import data.Data;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Hanson
 */
public class RootMenuController extends Controller {
  
    @FXML Button PaymentA;
    @FXML Button PaymentB;
    @FXML Button PaymentC;
    @FXML Button PaymentD;
    @FXML Button Introduction;
    public void handleButtonAction(ActionEvent event) {
        
        String fxid = ((Control)event.getSource()).getId();
        switch(fxid) {
            case "button_PaymentA":
                break;
            case "button_PaymentB":
                break;
            case "button_PaymentC":
                break;
            case "button_PaymentD":
                break;
            case "Introduction":
                createScene("/System/subMenu1.fxml");
                break;
            default:
                break;
        }
    }

    @Override
    public void loadData() {
       
    }
    
 
}
