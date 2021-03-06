/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.Command;
import Command.CreateScene;
import Command.CreateTimeLimitStage;
import Command.ProduceQueueNumber;
import SharedData.SharedData;
import System.MarqueePane;
import System.PaymentType;
import com.sun.javafx.tk.Toolkit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
    @FXML Text Text_MARQUEE;
    @FXML VBox VBox_MARQUEE;
    @FXML Pane Pane_MARQUEE;
    @FXML AnchorPane Pane_ROOT;
            
    
    public void handleButtonAction(ActionEvent event) {
        
        String fxid = ((Control)event.getSource()).getId();
        List<Command> cmds = new ArrayList();
        
        switch(fxid) {
            
            case "button_BUREAU_OF_TRANSPORTATION":
                cmds.add(new CreateTimeLimitStage(SharedData.getInstance().fxmlDir + "waiting.fxml", "請取單" ,2000));
                cmds.add(new ProduceQueueNumber(PaymentType.BUREAU_OF_TRANSPORTATION));
                break;
            case "button_LOCAL_TAX":
                cmds.add(new CreateTimeLimitStage(SharedData.getInstance().fxmlDir + "waiting.fxml", "請取單" ,2000));
                cmds.add(new ProduceQueueNumber(PaymentType.LOCAL_TAX));
                break;
            case "button_SERVICE_WINDOW":
                cmds.add(new CreateTimeLimitStage(SharedData.getInstance().fxmlDir + "waiting.fxml", "請取單" ,2000));
                cmds.add(new ProduceQueueNumber(PaymentType.SERVICE_WINDOW));
                break;
            case "button_HEALTH_INSURANCE":
                cmds.add(new CreateTimeLimitStage(SharedData.getInstance().fxmlDir + "waiting.fxml", "請取單" ,2000));
                cmds.add(new ProduceQueueNumber(PaymentType.HEALTH_INSURANCE));
                break;
            case "button_BUREAU_OF_LABOR":
                cmds.add(new CreateTimeLimitStage(SharedData.getInstance().fxmlDir + "waiting.fxml", "請取單" ,2000));
                cmds.add(new ProduceQueueNumber(PaymentType.BUREAU_OF_LABOR));
                break;
            case "button_NATIONAL_TAX":
                cmds.add(new CreateTimeLimitStage(SharedData.getInstance().fxmlDir + "waiting.fxml", "請取單" ,2000));
                cmds.add(new ProduceQueueNumber(PaymentType.NATIONAL_TAX));
                break;
            case "button_MOTOR_VEHICLES_OFFICE":
                cmds.add(new CreateTimeLimitStage(SharedData.getInstance().fxmlDir + "waiting.fxml", "請取單" ,2000));
                cmds.add(new ProduceQueueNumber(PaymentType.MOTOR_VEHICLES_OFFICE));
                break;
            case "button_Introduction":
                cmds.add(new CreateScene( SharedData.getInstance().fxmlDir + "subMenu1.fxml", nStage));
                break;
        }
        
        if (!cmds.isEmpty()) {
            for (Command cmd:cmds) {
                cmd.execute();
            }
        }
//        updatesInfo();
    }
//    public void updatesInfo() {
//        
//        SharedData data = SharedData.getInstance();
//        label_BUREAU_OF_TRANSPORTATION.setText(String.valueOf(data.getQueueNumber(PaymentType.BUREAU_OF_TRANSPORTATION)));
//        label_LOCAL_TAX.setText(String.valueOf(data.getQueueNumber(PaymentType.LOCAL_TAX)));
//        label_MOTOR_VEHICLES_OFFICE.setText(String.valueOf(data.getQueueNumber(PaymentType.MOTOR_VEHICLES_OFFICE)));
//        label_NATIONAL_TAX.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.NATIONAL_TAX))));
//        label_SERVICE_WINDOW.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.SERVICE_WINDOW))));
//        label_HEALTH_INSURANCE.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.HEALTH_INSURANCE))));
//        label_BUREAU_OF_LABOR.setText(String.valueOf(String.valueOf(data.getQueueNumber(PaymentType.BUREAU_OF_LABOR))));
//    }
    
    public void initCalendar() {
        
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date current = new Date();
        String date = sdFormat.format(current);
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
    public void runMarquee() {
        
        String text = "";

        try{
            String temp;
            BufferedReader br = new BufferedReader(new FileReader("主畫面跑馬燈.txt")); 
            while ((temp=br.readLine()) != null) {
                text += temp;
            }
            br.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
//        System.out.println("主畫面跑馬燈長度：" + text.length());
        MarqueePane pane = new MarqueePane(this.Pane_MARQUEE, this.Text_MARQUEE);
        pane.init(720, 113, text, 400*text.length());
//        System.out.println("Pane_MARQUEE:(w)" +this.Pane_MARQUEE.getWidth() +" Pane_MARQUEE:(h)"+this.Pane_MARQUEE.getWidth());
        pane.play();
    }
    @Override
    public void loadData() {
        initCalendar();
        initClock();
//        updatesInfo();
        runMarquee();
        
    }
}
