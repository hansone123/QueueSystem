/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedData;

import DocxProcess.DocxTemplateReplacer;
import System.ConnectDatabase;
import System.PaymentType;
import static System.PaymentType.BUREAU_OF_LABOR;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javafx.animation.Timeline;

/**
 *
 * @author hanson
 */
public class SharedData {
    
    public ConnectDatabase db;
    public String tableName;
    public int [] queueNumber;
    public int [] servingNumber;
    public String fxmlDir = "/fxml/";
    public String numberTemplatePath;
    public String numberPlatePath;
    public String year;
    public String month;
    public String day;
    public String date;
    
    private static SharedData instance = new SharedData(); 
    
    private SharedData() {
        queueNumber = new int[7];
        Arrays.fill(queueNumber, 0);
        numberTemplatePath = System.getProperty("user.dir") + "/" + "/Template-Number.docx";
        numberPlatePath = System.getProperty("user.dir") + "/" + "/NumberPlate.docx";
        tableName = "QueueSystem";
        this.fillDate();
        db = new ConnectDatabase("QueueSystem.db");
        db.prepared();
        List<String> datas = db.getTodayData();
        for (int i=0; i<7; i++) {
            this.queueNumber[i] = Integer.valueOf(datas.get(i+1));
        }
    } 
    public static SharedData getInstance() { 
        return instance; 
    } 
    
    public void setServingNumber(PaymentType type, int iNum) {
        this.servingNumber[type.getValue()] = iNum;
    }
    public int getServingNumber(PaymentType type) {
        return this.servingNumber[type.getValue()];
    }
    public String getTemplatePath() {
        return this.numberTemplatePath;
    }
    public String getNumberPlatePath() {
        return this.numberPlatePath;
    }
    public void setQueueNumber(PaymentType type, int iNum) {
        
        this.queueNumber[type.getValue()] = iNum;
        String atr = String.valueOf(type);
        String value = String.valueOf(iNum);
        db.setData(atr, value);
        
    }
    public int getQueueNumber(PaymentType type) {
        
        return this.queueNumber[type.getValue()];
    }
    private void fillDate() {
        Calendar calendar = Calendar.getInstance();
        year = String.valueOf(calendar.get(Calendar.YEAR));
        month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        date = year + "y" + month+ "m" +day + "d";
    }
    public static void main(String args[]) {
        SharedData data = SharedData.getInstance();
        data.setQueueNumber(BUREAU_OF_LABOR, 10);
        System.out.println(data.getQueueNumber(BUREAU_OF_LABOR));
        System.out.println(data.year+data.month+data.day);
    }

}
