/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;






public class Deleterecordjava {
    public static void removeRecoed (String filepath,int deleteLine)
    {
        String tempFile = "temp.txt";
        File oldFile = new File (filepath);
        File newFile = new File (tempFile);

        int line =0;
        String currentLine ;

        try{
        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter (fw);
        PrintWriter pw = new PrintWriter (bw);

        FileReader fr = new FileReader (filepath);
        BufferedReader br = new BufferedReader (fr);

        while ((currentLine = br.readLine()) != null)
        {
            line++;

         if (deleteLine != line ){
             pw.println(currentLine);
         }
        }

        pw.flush();
        pw.close();
        fr.close();
        br.close();
        bw.close();
        fw.close();

        oldFile.delete();
        File dump = new File(filepath);
        newFile.renameTo(dump);
            System.out.println("Done!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
   
    
    
    
    
    
}

