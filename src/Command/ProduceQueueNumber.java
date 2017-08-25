/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DocxProcess.DocxTemplateReplacer;
import Printer.PrintJobWatcher;
import SharedData.SharedData;
import System.PaymentType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;


/**
 *
 * @author hanson
 */
public class ProduceQueueNumber extends Command{
    
    PaymentType paymentType;
    public ProduceQueueNumber(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    
    private void produceNumberPlate() {
        SharedData data = SharedData.getInstance();
        String template = data.getTemplatePath();
        
        try{
            editingTemplate(template);
            printOutNumberPlate(data.getNumberPlatePath());
        }catch(FileNotFoundException ex) {
            System.err.println("Failed to load template.");
        }
        //TODO
    }
    private void editingTemplate(String templatePath) throws FileNotFoundException {
        
        DocxTemplateReplacer template = new DocxTemplateReplacer(new FileInputStream(templatePath));
        SharedData data = SharedData.getInstance();
        Map<String, String> patterns = loadPatterns();
        String path = data.getNumberPlatePath();
        template.replace(patterns);
        template.writeOutDocx(path);
    }
    private Map<String, String> loadPatterns() {
        
        String queueNum = String.format("%02d", SharedData.getInstance().getQueueNumber(this.paymentType));
        String deskNum = String.valueOf(this.paymentType.getValue()+1);
        Map<String, String> patterns = new TreeMap();
        SharedData data = SharedData.getInstance();
        
        patterns.put("n1", queueNum);
        patterns.put("n2", deskNum);
        patterns.put("n3", this.paymentType.getName());
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        patterns.put("y", String.valueOf(year));
        patterns.put("m", String.valueOf(month));
        patterns.put("d", String.valueOf(day));
        DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );        
        patterns.put("t", String.valueOf(timeFormat.format( System.currentTimeMillis() )));
        
        return patterns;
    }
    private void printOutNumberPlate(String filePath) {
        String winCmd = "cmd /c start /min winword " +  filePath + " /q /n /mFilePrintDefault /mFileCloseOrExit";
//        String winCmd = "start /min winword " +  filePath + "/q /n /mFilePrint /mFileExit ";
//        System.out.println(winCmd);
        try{
            Runtime.getRuntime().exec(winCmd);
        }catch(IOException e) {
            System.err.println("print failed.");
        }
    }
//    private void printOutNumberPlate(String filePath) {
//            
//            InputStream is = null;
//            PrintService service = null;
//            Doc doc = null;
//            try {
//                is = new FileInputStream(filePath);
//                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
//                service = PrintServiceLookup.lookupDefaultPrintService();
//                doc = new SimpleDoc(is, flavor, null);
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            } 
//            
//            try{
//                DocPrintJob job = service.createPrintJob();
//                PrintJobWatcher pjw = new PrintJobWatcher(job);
//                PrintRequestAttributeSet  pras = new HashPrintRequestAttributeSet();
//                pras.add(new Copies(1));
//                job.print(doc, pras);
//                pjw.waitForDone();
//                is.close();
//            } catch (PrintException ex) {
//                ex.printStackTrace();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            } catch (NullPointerException ex) {
//                System.err.println("No printer found.");
//            }
//        
//    }
    @Override
    public void execute() {
        
        SharedData data = SharedData.getInstance();
        int queueNumber = data.getQueueNumber(this.paymentType);
        data.setQueueNumber(this.paymentType, queueNumber+1);
        produceNumberPlate();
    }

    @Override
    public void undo() {   
        
    }
    
}
