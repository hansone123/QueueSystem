/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import SharedData.SharedData;
import System.PaymentType;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author hanson
 */
public class ProduceQueueNumber extends Command{
    PaymentType paymentType;
    public ProduceQueueNumber(PaymentType paymentType) {
            this.paymentType = paymentType;
    }
    
    public void PrintNumberPlate() {
        //TODO
    }
    @Override
    public void execute() {
        SharedData data = SharedData.getInstance();
        int queueNumber = data.getQueueNumber(this.paymentType);
        data.setQueueNumber(this.paymentType, queueNumber+1);
        PrintNumberPlate();
    }

    @Override
    public void undo() {   
        
    }
    
}
