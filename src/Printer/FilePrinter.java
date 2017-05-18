/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Printer;

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
public class FilePrinter
{
    
    public PrintService printer;
    
    public FilePrinter(String printerName) {
        
        this.printer = this.findPrintService(printerName);
    }
    public void initial() {
        
    }
    public PrintService findPrintService(String printname){
        
        PrintService printService = null;
        PrintService services[] = PrintServiceLookup.lookupPrintServices(null, null);
        
        for (PrintService service:services) {
            if(printname.equalsIgnoreCase(service.getName())){
                printService = service;
            }
        }
        return printService;
    }
  
}
