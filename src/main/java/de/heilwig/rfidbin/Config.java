/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.heilwig.rfidbin;

/**
 *
 * @author Moritz
 */
public class Config {
   private static  String masterPass = "Your masterpassword"; 
   public static Boolean checkMasterPass(String pass){
       if(pass.equals(masterPass)) return true;
       return false;
   }
}
