/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author hanson
 */
public class ConnectDatabase {
    Connection connection;
    String tableName;
    private String year;
    private String month;
    private String day;
    private String date;
    
    public ConnectDatabase(String dbName) {
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            tableName = "QueueSystem";
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void setData(String atr, String value) {
        
        String table = this.tableName;
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            String sql = "UPDATE " + table + " SET "+ atr + " = " + value + " WHERE DATE =\""
                    + this.date +"\";";
            System.out.println(sql);
            stm.execute(sql);
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void dropTodayData() {
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            String sql = "delete from " + this.tableName + " where DATE=\'" + this.date +"\';";
            System.out.println(sql);
            stm.execute(sql);
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void dropAllData() {
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            String sql = "drop table '" + this.tableName + "';";
            System.out.println(sql);
            stm.execute(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void prepared() {
        
        Calendar calendar = Calendar.getInstance();
        year = String.valueOf(calendar.get(Calendar.YEAR));
        month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        date = year + "y" + month+ "m" +day + "d";
        this.createTableIfNotExst();
        this.createRecord(date);
    }
    private void createTableIfNotExst() {
        
        String sql=null;
        String table = this.tableName;
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            sql =   "create table if not exists "+ table +"( " +
                    "DATE string primary key," +
                    "BUREAU_OF_TRANSPORTATION integer," +          
                    "LOCAL_TAX integer," +          
                    "MOTOR_VEHICLES_OFFICE integer," +
                    "NATIONAL_TAX integer," +
                    "SERVICE_WINDOW integer," +
                    "HEALTH_INSURANCE integer," + 
                    "BUREAU_OF_LABOR integer)";
            stm.execute(sql);
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    private void updateData(String table , String pk, String atr, String data) {
        
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    private void createRecord(String primarykey) {
        String table = this.tableName;
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            String sql = "INSERT INTO " + table + "(" +
                    "DATE, BUREAU_OF_TRANSPORTATION, LOCAL_TAX, "
                    + "MOTOR_VEHICLES_OFFICE, NATIONAL_TAX, SERVICE_WINDOW,"
                    + "HEALTH_INSURANCE, BUREAU_OF_LABOR) "
                    + "VALUES (\"" + primarykey +"\",0,0,0,0,0,0,0);";
            System.out.println(sql);
            stm.execute(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public String getTodayData(String paymentType) {
        String result=null;
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            String sql = "SELECT "+ paymentType +" FROM " + this.tableName +" WHERE DATE=\'" + this.date + "\';";
            ResultSet rs = stm.executeQuery(sql);
            System.out.println(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()) {
                for (int i=1; i<=metaData.getColumnCount(); i++) {
                   result = rs.getString(i);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<String> getTodayData() {
        List<String> result=null;
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            String sql = "SELECT * FROM " + this.tableName +" WHERE DATE=\'" + this.date + "\';";
            ResultSet rs = stm.executeQuery(sql);
            System.out.println(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            result = new ArrayList();
            while(rs.next()) {
                for (int i=1; i<=metaData.getColumnCount(); i++) {
                    result.add(rs.getString(i));
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    } 
    public void showSelectALL(String table) {
        try{
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(1);
            String sql = "SELECT * FROM " + table +";";
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()) {
                for (int i=1; i<=metaData.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        ConnectDatabase db = new ConnectDatabase("QueueSystem.db");
        db.prepared();
        db.setData("BUREAU_OF_TRANSPORTATION", String.valueOf(10));
        List<String> data = db.getTodayData();
        for (String s:data) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("BUREAU_OF_TRANSPORTATION:" + db.getTodayData("BUREAU_OF_TRANSPORTATION"));
        db.dropTodayData();
        db.dropAllData();
        
    }
}
