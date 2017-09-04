/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Controller.Controller;
import SharedData.SharedData;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myWindow.MyWindow;

/**
 *
 * @author hanson
 */
public class CreateTimeLimitStage extends Command{
    
    public String fxml;
    public Stage stage;
    public long time;
    
    public CreateTimeLimitStage(String fxml, String title, long time) {
        
        this.fxml = fxml;
        this.stage = new Stage();  
        this.time = time;
        stage.setAlwaysOnTop(true);  
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
       
        
    }
    

    public void setTimeConfig() {
        
        Thread thread = new Thread(() -> {  
            try {  
                Thread.sleep(time);  
                
                if (stage.isShowing()) {  
                    Platform.runLater(() -> stage.close());  
                }  
            } catch (Exception exp) {  
                exp.printStackTrace();  
            }  
        });  
        thread.setDaemon(true);  
        thread.start();  
    }
    public void execute() {
        
        try{
            
            MyWindow window = new MyWindow(stage);
            window.init(fxml);
            window.open();
            setTimeConfig();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
       
    }
    
}
