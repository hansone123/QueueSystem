/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.util.Calendar;
import java.util.TimerTask;
import javafx.scene.control.Label;

/**
 *
 * @author hanson
 */
public class UpdatesClockTask extends TimerTask{
    public Label label;
    public UpdatesClockTask(Label label) {
        this.label = label;
    }
    
    @Override
    public void run() {
        Calendar cal = Calendar.getInstance();
        String nowTime = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" +cal.get(Calendar.SECOND);
//        this.label.setText(nowTime);
    System.out.println("123");
    }
    
    
}
