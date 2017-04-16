/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import data.Data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Hanson
 */
public class MainMenuController implements Initializable {
    
    @FXML private TextField textfield_A;
    private Data data;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String fxid = ((Control)event.getSource()).getId();
        switch(fxid) {
            case "button_A":
            case "button_B":
            case "button_C":
                this.increaseWaitingNumber(0);
                this.updatesScreen("textfield_A");
            case "button_D":
                break;
            default:
                break;
        }
    }
    private void increaseWaitingNumber(int slot) {
        int number = this.data.get(slot);
        number++;
        if (number > 999) {
            this.data.set(slot, 0);
        }
        this.data.set(slot, number);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void init(Data data) {
        this.data = data;
        this.initAllInfo();
    }
    public void initAllInfo(){
        this.updatesScreen("textfield_A");
    }
    public void updatesScreen(String fxid) {
        switch(fxid) {
            case "textfield_A":
                textfield_A.setText(String.format("%03d", this.data.get(0)));
                break;
            default:
                break;
        }
    }
}
