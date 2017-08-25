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
import System.PaymentType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author Hanson
 */
public class QueueGUIController extends Controller {
            
    @FXML Button button_BUREAU_OF_TRANSPORTATION;
    @FXML Button button_LOCAL_TAX;
    @FXML Button button_MOTOR_VEHICLES_OFFICE;
    @FXML Button button_NATIONAL_TAX;
    @FXML Button button_SERVICE_WINDOW;
    @FXML Button button_HEALTH_INSURANCE;
    @FXML Button button_BUREAU_OF_LABOR;
    @FXML Label label_BUREAU_OF_TRANSPORTATION;
    @FXML Label label_LOCAL_TAX;
    @FXML Label label_MOTOR_VEHICLES_OFFICE;
    @FXML Label label_NATIONAL_TAX;
    @FXML Label label_SERVICE_WINDOW;
    @FXML Label label_HEALTH_INSURANCE;
    @FXML Label label_BUREAU_OF_LABOR;
    @FXML Label label_CALENDAR;
    @FXML Label label_CLOCK;
    
    public void handleButtonAction(ActionEvent event) {
        
        String fxid = ((Control)event.getSource()).getId();
        Command cmd = null;
        switch(fxid) {
            
            case "button_BUREAU_OF_TRANSPORTATION":
                cmd = new ProduceQueueNumber(PaymentType.BUREAU_OF_TRANSPORTATION);
                break;
            case "button_LOCAL_TAX":
                cmd = new ProduceQueueNumber(PaymentType.LOCAL_TAX);
                break;
            case "button_SERVICE_WINDOW":
                cmd = new ProduceQueueNumber(PaymentType.SERVICE_WINDOW);
                break;
            case "button_HEALTH_INSURANCE":
                cmd = new ProduceQueueNumber(PaymentType.HEALTH_INSURANCE);
                break;
            case "button_BUREAU_OF_LABOR":
                cmd = new ProduceQueueNumber(PaymentType.BUREAU_OF_LABOR);
                break;
            case "button_NATIONAL_TAX":
                cmd = new ProduceQueueNumber(PaymentType.NATIONAL_TAX);
                break;
            case "button_MOTOR_VEHICLES_OFFICE":
                cmd = new ProduceQueueNumber(PaymentType.MOTOR_VEHICLES_OFFICE);
                break;
            case "button_Introduction":
                cmd = new CreateScene( SharedData.getInstance().fxmlDir + "subMenu1.fxml", nStage);
                break;
        }
        if (cmd != null) {
            cmd.execute();
        }
        updatesInfo();
    }
    public void updatesInfo() {
        
        SharedData data = SharedData.getInstance();
        label_BUREAU_OF_TRANSPORTATION.setText(String.valueOf(data.getQueueNumber(PaymentType.BUREAU_OF_TRANSPORTATION)));
        label_LOCAL_TAX.setText(String.valueOf(data.getQueueNumber(PaymentType.LOCAL_TAX)));
        label_MOTOR_VEHICLES_OFFICE.setText(String.valueOf(data.getQueueNumber(PaymentType.MOTOR_VEHICLES_OFFICE)));
        label_NATIONAL_TAX.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.NATIONAL_TAX))));
        label_SERVICE_WINDOW.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.SERVICE_WINDOW))));
        label_HEALTH_INSURANCE.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.HEALTH_INSURANCE))));
        label_BUREAU_OF_LABOR.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.BUREAU_OF_LABOR))));
    }
    
    public void initCalendar() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = year +"年 " + month + "月 " + day + "日";
        label_CALENDAR.setText(date);
    }
    public void initClock() {
        
        DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
        final Timeline timeline = new Timeline(
            new KeyFrame(
                Duration.millis( 500 ),
                event -> {
                        this.label_CLOCK.setText( timeFormat.format( System.currentTimeMillis() ) );
                    }
            )
        );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play();
    }
    @Override
    public void loadData() {
        initCalendar();
        initClock();
        updatesInfo();
    }
}
