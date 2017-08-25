/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

/**
 *
 * @author hanson
 */
public enum PaymentType {
    BUREAU_OF_TRANSPORTATION(0),
    LOCAL_TAX(1), 
    MOTOR_VEHICLES_OFFICE(2),
    NATIONAL_TAX(3),
    SERVICE_WINDOW(4),
    HEALTH_INSURANCE(5), 
    BUREAU_OF_LABOR(6);
    
    private int value;
    
    private PaymentType(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    public String getName() {
        
        switch(this.value) {
            case 0:
                return "交通局";
            case 1:
                return "市稅";
            case 2:
                return "監理站";
            case 3:
                return "國稅";
            case 4:
                return "單一窗口";
            case 5:
                return "健保";
            case 6:
                return "勞保";
        }
        return "\"錯誤\"";
    }
}
