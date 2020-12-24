/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localedemo;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author LIONS
 */
public class LocaleDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String lang = "en";
        String country = "us";

        Locale l = new Locale(lang, country);

        ResourceBundle rb = ResourceBundle.getBundle("localedemo/Bundle", l);
        // Here the data is coming from the properties file 
        
        String str = rb.getString("wish");
        System.out.println(str);
    }

}
