/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenciak;

import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author prywa
 */
public class Projekt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Step1 step1 = new Step1();
        step1.setVisible(true);
        step1.runLoading(); 
    }
    
}
