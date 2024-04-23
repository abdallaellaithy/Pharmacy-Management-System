/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Abdal Maged
 */
public class PlaceAnOrder extends MainPharmacy {
    boolean drugAvaliblityCheck = false;
    
        public PlaceAnOrder() throws FileNotFoundException {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Please enter Your Name: ");
            String userName = myObj.nextLine();
            System.out.println("Hello special customer ** " + userName + " **");
            System.out.println("----------------------------------------");
        }
        
        public void checkDrugeAvaliability() throws FileNotFoundException{  // Method to check the name of drug and if it avaliable will return the yes and the id of this drug
            // search about the drug that user will enter
            Scanner myObj = new Scanner(System.in);
            // user will enter the drug name
            System.out.println("Enter drug name to search:");
            searchedDrug = myObj.nextLine();

            //enter the drugs file to check
            File fs = new File("Drugs.txt");
            Scanner sc = new Scanner(fs);

            // check if the drug avalible or not
            while (sc.hasNextLine()) {
                searchingDrug = sc.nextLine();
                // if the drug is avaliable in the pharmarcy will print yes we have this drug
                if(searchingDrug.substring(2).equals(searchedDrug)){
                    System.out.println("yes we have this drug");
                    // will store the id in this var(idOfOrder)
                    idOfOrder = searchingDrug.substring(0,1);
                    drugAvaliblityCheck = true; // if he find the drug
                }
            }
            if(drugAvaliblityCheck == false){// if he didn't find the drug
                System.out.println("sorry we didn't have this drug");
            }
            sc.close();
        }
        
        public void theTypeOfDrug() throws FileNotFoundException{ // Method to check the type of drug to use in price (cosmetics or other)
            if(drugAvaliblityCheck == true){
                File cat = new File("categorys.txt");
                Scanner sc = new Scanner(cat);

                // loop to print the price of drug
                while (sc.hasNextLine()){
                    theCategory = sc.nextLine();
                    // check the id of drug category
                    if(theCategory.substring(0,1).equals(idOfOrder)){
                        // if the category of the drug is cosmetics will change the chekPriceIncrease to true
                        if("cosmetics".equals(theCategory.substring(2)) == true){
                            chekPriceIncrease = true;
                        }
                    }
                }
            }
        }
    
            public void thequantityOfDrug() throws FileNotFoundException, IOException{ // method to check the quantity in pahrmacy
                if(drugAvaliblityCheck == true){
                    Uquantity = 0;
                    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter the quntity that you want: ");
                    Uquantity = myObj.nextInt();

                    File quant = new File("avaliableQuantity.txt");
                    Scanner sc = new Scanner(quant);

                    // loop to print the price of drug
                    while (sc.hasNextLine()){
                        quantityOfDrug = sc.nextLine();
                        // check the id of drug quantity
                        if(quantityOfDrug.substring(0,1).equals(idOfOrder)){
                            //check if we have avaliable quantity of this drug or not?
                            if(Float.parseFloat(quantityOfDrug.substring(2)) > 0 ){
                                newQuantity = Integer.parseInt(quantityOfDrug.substring(2)) - Uquantity;
                                // change the quantity of the pharmacy depend on the order
                                Path path = Paths.get("avaliableQuantity.txt");
                                Charset charset = StandardCharsets.UTF_8;

                                String content = new String(Files.readAllBytes(path), charset);
                                content = content.replaceAll(quantityOfDrug.substring(2), Integer.toString((int) newQuantity)); // value which will changed
                                Files.write(path, content.getBytes(charset));
                            }else{
                                System.out.println("Sorry, out of stock! ");
                            }
                        }
                    }
                }
            }
            
        public void getUnitPrice() throws FileNotFoundException, IOException{ // Method return the unite price of the drug
            if(drugAvaliblityCheck == true){
                File pr = new File("Prices.txt");
                Scanner sc = new Scanner(pr);

                // return and print the price of drug
                while (sc.hasNextLine()){
                    unitePrice = sc.nextLine();
                    // catch the price of the drug price
                    if(unitePrice.substring(0,1).equals(idOfOrder)){
                        if (chekPriceIncrease == true){ 
                           // if it cosmetics category will pay for 1.2 of the regular price
                            priceIncrease = Double.parseDouble(unitePrice.substring(2)) + (Double.parseDouble(unitePrice.substring(2)) * 0.2);
                            double totalPriceIncrease = (Double.parseDouble(unitePrice.substring(2)) + (Double.parseDouble(unitePrice.substring(2)) * 0.2))* Uquantity;

                            System.out.println("the price of this drug is: "+priceIncrease);
                            System.out.println("Total Price is : " + totalPriceIncrease);

                           // Change the total price of today 
                            File total = new File("TotalPricesToday.txt");
                            Scanner tot = new Scanner(total);
                            while (tot.hasNextLine()){
                                String TotalPrice = tot.nextLine();

                                int certainPrice = Integer.parseInt(TotalPrice.substring(27)); // Catch the number (0) in the first turn
                                System.out.println((priceIncrease + certainPrice) * Uquantity);
                                Path path = Paths.get("TotalPricesToday.txt");
                                Charset charset = StandardCharsets.UTF_8;

                                String content = new String(Files.readAllBytes(path), charset);
                                content = content.replaceAll(Integer.toString(certainPrice), Integer.toString(((int) priceIncrease + certainPrice) * Uquantity)); // value which will changed
                                Files.write(path, content.getBytes(charset));
                            }


                        }else{
                            double priceIncrease2 = Double.parseDouble(unitePrice.substring(2));
                            System.out.println("the price of this drug is: " + priceIncrease2); // regular price
                            System.out.println("Total Price is : " + priceIncrease2 * Uquantity);

                            // Change the total price of today 
                            File total = new File("TotalPricesToday.txt");
                            Scanner tota = new Scanner(total);
                            while (tota.hasNextLine()){
                                String TotalPrice = tota.nextLine();

                                int newPrice = Integer.parseInt(TotalPrice.substring(27)); // Catch the number (0) in the first turn
                                Path path = Paths.get("TotalPricesToday.txt");
                                Charset charset = StandardCharsets.UTF_8;
                                String content = new String(Files.readAllBytes(path), charset);
                                content = content.replaceAll(Integer.toString(newPrice), Integer.toString(((int)priceIncrease2 + newPrice) * Uquantity)); // value which will changed
                                Files.write(path, content.getBytes(charset));
                            }
                        }
                    }
                }
            }
        }
        
        public void getTotalMoneyToday() throws FileNotFoundException{
            try{
                File fr = new File("TotalPricesToday.txt");
                Scanner sc = new Scanner(fr);
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine() + "$");
                }
                sc.close();
            }
            catch(FileNotFoundException e){
               System.out.println(e);
            }
        }
}
