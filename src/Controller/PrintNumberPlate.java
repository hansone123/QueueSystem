/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.Command;
import SharedData.SharedData;
import System.PaymentType;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author hanson
 */
public class PrintNumberPlate extends Command
{
    public PaymentType type;
    public SharedData data;
    public PrintService printer;
    
    public PrintNumberPlate(PaymentType type, String printerName) {
        this.type = type;
        this.data = SharedData.getInstance();
        this.printer = this.findPrintServiceWithName(printerName);
    }
    private PrintService findPrintServiceWithName(String printname){
        
        PrintService printService = null;
        PrintService services[] = this.findPrintServices(null, null);
        
        for (PrintService service:services) {
            if(printname.equalsIgnoreCase(service.getName())){
                printService = service;
            }
        }
        return printService;
    }
     public PrintService[] findPrintServices(DocFlavor docflavor, PrintRequestAttributeSet pras){
         
        PrintService[] services = PrintServiceLookup.lookupPrintServices(docflavor, pras);
        return services;
    }
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
