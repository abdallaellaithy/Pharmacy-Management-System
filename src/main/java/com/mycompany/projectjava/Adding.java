/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Abdal Maged
 */
public class Adding extends MainPharmacy {

    public Adding() throws IOException {
        while(quantityOfDrugs > 0 ){

            // ask User 
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter drug Name:");
            this.drugName = myObj.nextLine();

            System.out.println("Enter category:");
            this.category = myObj.nextLine();
            
            System.out.println("Enter drug avaliableQuantity:");
            this.avaliableQuantity = myObj.nextInt();

            System.out.println("Enter price:");
            this.price = myObj.nextFloat();
            
        try{
            File drugFile = new File("Drugs.txt");
            PrintWriter dr = new PrintWriter(new FileWriter(drugFile,true));
            dr.println(id + ":" + drugName);
            dr.close();
            
            File priceFile = new File("Prices.txt");
            PrintWriter pr = new PrintWriter(new FileWriter(priceFile,true));
            pr.println(id + ":" + price);
            pr.close();

            File categoryFile = new File("categorys.txt");
            PrintWriter cat = new PrintWriter(new FileWriter(categoryFile,true));
            cat.println(id + ":" + category);
            cat.close();
            
            File avaliableQuantityFile = new File("avaliableQuantity.txt");
            PrintWriter av = new PrintWriter(new FileWriter(avaliableQuantityFile,true));
            av.println(id + ":" + avaliableQuantity);
            av.close();
            
            File TotalPriceFile = new File("TotalPricesToday.txt");
            PrintWriter pri = new PrintWriter(TotalPriceFile);
            pri.println("The Total Price Today is : " + 0);
            pri.close();
            
            id+=1;
            System.out.println("DONE!");
            
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        quantityOfDrugs -=1;
        
        }
        if(quantityOfDrugs == 0){
        System.out.println("The quantity is Full !");
        System.out.println("and can't add more");
        }
    }
    
    
    
    
}
