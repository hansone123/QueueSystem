/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Controller;
import SharedData.SharedData;
import System.MarqueePane;
import System.PaymentType;
import com.sun.javafx.tk.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hanson
 */
public class QueueStateController extends Controller implements Initializable {

    @FXML Label label_BUREAU_OF_TRANSPORTATION_NUM;
    @FXML Label label_LOCAL_TAX_NUM;
    @FXML Label label_MOTOR_VEHICLES_OFFICE_NUM;
    @FXML Label label_NATIONAL_TAX_NUM;
    @FXML Label label_SERVICE_WINDOW_NUM;
    @FXML Label label_HEALTH_INSURANCE_NUM;
    @FXML Label label_BUREAU_OF_LABOR_NUM;
    @FXML Text Text_MARQUEE;
    @FXML Pane Pane_MARQUEE;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void updatesInfo() {
        SharedData data = SharedData.getInstance();
        label_BUREAU_OF_TRANSPORTATION_NUM.setText(String.valueOf(data.getQueueNumber(PaymentType.BUREAU_OF_TRANSPORTATION)));
        label_LOCAL_TAX_NUM.setText(String.valueOf(data.getQueueNumber(PaymentType.LOCAL_TAX)));
        label_MOTOR_VEHICLES_OFFICE_NUM.setText(String.valueOf(data.getQueueNumber(PaymentType.MOTOR_VEHICLES_OFFICE)));
        label_NATIONAL_TAX_NUM.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.NATIONAL_TAX))));
        label_SERVICE_WINDOW_NUM.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.SERVICE_WINDOW))));
        label_HEALTH_INSURANCE_NUM.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.HEALTH_INSURANCE))));
        label_BUREAU_OF_LABOR_NUM.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.BUREAU_OF_LABOR))));
    }
    @Override
    public void loadData() {
        
        keepUpdatesScreen();
//        runMarquee();
        
    }
    private void keepUpdatesScreen() {
        final Timeline timeline = new Timeline(
            new KeyFrame(
                Duration.millis( 500 ),
                event -> {
                    updatesInfo();
                    
                    }
            )
        );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play();
    }
}
