/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedData;

import System.PaymentType;
import static System.PaymentType.BUREAU_OF_LABOR;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import javafx.animation.Timeline;

/**
 *
 * @author hanson
 */
public class SharedData {
    
    public Connection db;
    public int [] queueNumber;
    public int [] servingNumber;
    public Calendar calendar;
    
    private static SharedData instance = new SharedData(); 
    private SharedData() {
        queueNumber = new int[10];
        calendar = Calendar.getInstance();
        initData();
    } 
    private void initData() {
        Arrays.fill(queueNumber, 0);
    }
    public static SharedData getInstance() { 
        return instance; 
    } 
    public void CreateSystemTable() throws SQLException {
        
        db = DriverManager.getConnection("jdbc:sqlite:QueueSystem.db");
        Statement statement = db.createStatement();
        statement.executeUpdate("create table QueueSystem(date )");
    }
    public void setServingNumber(PaymentType type, int iNum) {
        this.servingNumber[type.getValue()] = iNum;
    }
    public int getServingNumber(PaymentType type) {
        return this.servingNumber[type.getValue()];
    }
    public void setQueueNumber(PaymentType type, int iNum) {
        
        this.queueNumber[type.getValue()] = iNum;
    }
    public int getQueueNumber(PaymentType type) {
        
        return this.queueNumber[type.getValue()];
    }
    
    public static void main(String args[]) {
        SharedData data = SharedData.getInstance();
        data.setQueueNumber(PaymentType.BUREAU_OF_LABOR, 10);
        System.out.println(data.getQueueNumber(BUREAU_OF_LABOR));
    }

}
