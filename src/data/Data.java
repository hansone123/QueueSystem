/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hanson
 * 
 * 
 * Data slot :
 * slot 0: textfield0
 */


public class Data {
    
    private List<Integer> waitSlot;
    
    public Data(int slotNum) {
        waitSlot = new ArrayList();
        for (int i=0; i<slotNum; i++) {
            int number = 0;
            this.waitSlot.add(number);
        }
    }
    public int get(int slot) {
        return this.getValidData(slot);
    }
    private int getValidData(int slot) {
        try{
            return this.waitSlot.get(slot);
        }catch(Exception e) {
            return -1;
        }
    }
    public void set(int slot, int number) {
        this.setValidData(slot, number);
    }
    private void setValidData(int slot, int number) {
        try{
            this.waitSlot.set(slot, number);
        }catch(Exception e) {
        }
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i=0; i<this.waitSlot.size(); i++) {
            str += "slot:\r" + i +"\rnumber:\r" + this.waitSlot.get(i) + "\n";
        }
        
        return str;
    } 
    
    public static void main(String args[]) {
        Data data = new Data(10);
     
        System.out.println(data.toString());
    }
}
