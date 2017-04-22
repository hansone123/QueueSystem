/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.Command;
import Command.CreateScene;
import Command.ProduceQueueNumber;
import SharedData.SharedData;
import static System.PaymentType.*;
import java.util.Calendar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;

/**
 *
 * @author Hanson
 */
public class RootMenuController extends Controller {
  
    @FXML Button Button_TAX_PAYMENT;
    @FXML Button Button_HEALTH_INSURANCE_PAYMENT;
    @FXML Button Button_FINE_PAYMENT;
    @FXML Button Button_OTHER_COST;
    @FXML Button Button_Introduction;
    @FXML Label label_TAX_PAYMENT;
    @FXML Label label_HEALTH_INSURANCE_PAYMENT;
    @FXML Label label_FINE_PAYMENT;
    @FXML Label label_OTHER_COST_PAYMENT;
    @FXML Label label_CLOCK;
    
    SharedData data;
    public void handleButtonAction(ActionEvent event) {
        
        String fxid = ((Control)event.getSource()).getId();
        Command cmd = null;
        switch(fxid) {
            case "button_TAX_PAYMENT":
                cmd = new ProduceQueueNumber(TAX_PAYMENT);
                break;
            case "button_HEALTH_INSURANCE_PAYMENT":
                cmd = new ProduceQueueNumber(HEALTH_INSURANCE_PAYMENT);
                break;
            case "button_FINE_PAYMENT":
                cmd = new ProduceQueueNumber(FINE_PAYMENT);
                break;
            case "button_OTHER_COST":
                cmd = new ProduceQueueNumber(OTHER_COST_PAYMENT);
                break;
            case "button_Introduction":
                cmd = new CreateScene("/System/subMenu1.fxml", nStage);
                break;
        }
        if (cmd != null) {
            cmd.execute();
        }
        updatesInfo();
    }
    public void updatesInfo() {
        
        Calendar calendar = this.data.calendar;
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = year +"年 " + month + "月 " + day + "日";
        
        label_CLOCK.setText(date);
        label_TAX_PAYMENT.setText(String.valueOf(data.getQueueNumber(TAX_PAYMENT)));
        label_HEALTH_INSURANCE_PAYMENT.setText(String.valueOf(data.getQueueNumber(HEALTH_INSURANCE_PAYMENT)));
        label_FINE_PAYMENT.setText(String.valueOf(data.getQueueNumber(FINE_PAYMENT)));
        label_OTHER_COST_PAYMENT.setText(String.valueOf(data.getQueueNumber(OTHER_COST_PAYMENT)));
    }
    
    @Override
    public void loadData() {
        data = SharedData.getInstance();
        updatesInfo();
    }
}
