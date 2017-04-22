/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedData;

import System.PaymentType;
import static System.PaymentType.TAX_PAYMENT;
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
    public void setServingNumber(PaymentType type, int input) {
        switch(type) {
            case TAX_PAYMENT:
                servingNumber[0] = input;
                break;
            case HEALTH_INSURANCE_PAYMENT:
                servingNumber[1] = input;
                break;
            case FINE_PAYMENT:
                servingNumber[2] = input;
                break;
            case OTHER_COST_PAYMENT:
                servingNumber[3] = input;
                break;
            default:
                break;
        }
    }
    public int getServingNumber(PaymentType type) {
        int QueueNumber = 0;
        switch(type) {
            case TAX_PAYMENT:
                QueueNumber = servingNumber[0];
                break;
            case HEALTH_INSURANCE_PAYMENT:
                QueueNumber = servingNumber[1];
                break;
            case FINE_PAYMENT:
                QueueNumber = servingNumber[2];
                break;
            case OTHER_COST_PAYMENT:
                QueueNumber = servingNumber[3];
                break;
            default:
                break;
        }
        return QueueNumber;
    }
    public void setQueueNumber(PaymentType type, int input) {
        switch(type) {
            case TAX_PAYMENT:
                queueNumber[0] = input;
                break;
            case HEALTH_INSURANCE_PAYMENT:
                queueNumber[1] = input;
                break;
            case FINE_PAYMENT:
                queueNumber[2] = input;
                break;
            case OTHER_COST_PAYMENT:
                queueNumber[3] = input;
                break;
            default:
                break;
        }
    }
    public int getQueueNumber(PaymentType type) {
        int QueueNumber = 0;
        switch(type) {
            case TAX_PAYMENT:
                QueueNumber = queueNumber[0];
                break;
            case HEALTH_INSURANCE_PAYMENT:
                QueueNumber = queueNumber[1];
                break;
            case FINE_PAYMENT:
                QueueNumber = queueNumber[2];
                break;
            case OTHER_COST_PAYMENT:
                QueueNumber = queueNumber[3];
                break;
            default:
                break;
        }
        return QueueNumber;
    }
    
    public static void main(String args[]) {
        SharedData data = SharedData.getInstance();
        data.setQueueNumber(TAX_PAYMENT, 10);
        System.out.println(data.getQueueNumber(TAX_PAYMENT));
    }

}
