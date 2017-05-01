/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.Command;
import SharedData.SharedData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import myWindow.MyWindow;

/**
 * FXML Controller class
 *
 * @author hanson
 */
public class RootController extends Controller implements Initializable {
    
    
    @FXML Button button_QueueSystem;
    @FXML Button button_ShowState;
    
    SharedData data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handleButtonAction(ActionEvent event) {
        
        String fxid = ((Control)event.getSource()).getId();
        switch(fxid) {
            case "button_QueueSystem":
                Stage stage = new Stage();
                MyWindow QueueInterface = new MyWindow(stage);
                QueueInterface.setTitle("行政執行署-台南分署：叫號介面");
                QueueInterface.init("/System/rootMenu.fxml");
                QueueInterface.open();
                break;
            case "button_ShowState":
                Stage stage2 = new Stage();
                MyWindow StateWindow = new MyWindow(stage2);
                StateWindow.setTitle("行政執行署-台南分署：叫號狀態");
                StateWindow.init("/System/StateMenu.fxml");
                StateWindow.open();
                break;
        }
    }

    @Override
    public void loadData() {
        data = SharedData.getInstance();
    }
}
