/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DocxProcess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author hanson
 */
public class ReadWordDocx {
    
    public static void main(String args[]) throws IOException {
        ReadWordDocx test = new ReadWordDocx();
        test.showDocx(System.getProperty("user.dir") + "/Template-Number"
                + ".docx");
    }
    public void showDocx(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        XWPFDocument doc = new XWPFDocument(is);
        this.ReadByDocx(doc);
        this.close(is);
    } 
    public void ReadByDocx(XWPFDocument doc) throws IOException {
        
        List<XWPFParagraph> paras = doc.getParagraphs();
        System.out.println("使用Paragraph讀出文本內容：");
        for (XWPFParagraph para:paras) {
            System.out.println(para.getText());
        }
        
        List<XWPFTable> tables = doc.getTables();
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        System.out.println("使用TableCell讀出文本內容：");
        for (XWPFTable table:tables) {
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                System.out.println("列內容：");
                cells= row.getTableCells();
                for (XWPFTableCell cell:cells) {
                    System.out.print(cell.getText());
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        
    }
    
    public void close(InputStream is) {
        if ( is !=null ) {
            try{
                is.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
