
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanson
 */
public class test {
    public static void main(String args[]) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.SECOND));
        
    }   
}
