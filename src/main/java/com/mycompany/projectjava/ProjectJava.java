/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projectjava;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Abdal Maged
 */
public class ProjectJava {

    public static void main(String[] args) throws IOException {
        // to add new data
//        System.out.println("Hello Dr");
//        System.out.println("Please enter the data of the pharamcy");
//        Adding drug1 = new Adding();
        
        PlaceAnOrder drug2 = new PlaceAnOrder();
        int choose = 0;
        while(choose != 5){
            System.out.println("");
            System.out.println("-Please Choose Your Action");
            System.out.println("\t2 = if you want to remove drug");
            System.out.println("\t3 = if you want to make an order");
            System.out.println("\t4 = if you want to get the total money of the pharmacy today");
            System.out.println("\t5 = if you want to exit");
            
            Scanner myObj = new Scanner(System.in); 
            choose = myObj.nextInt();
            

            switch(choose) {
                case 2 -> {
                    Deleterecordjava drug3 = new Deleterecordjava();
                    System.out.println("Please enter the id of the drug to remove it: ");
                    int remeovedId = myObj.nextInt();
                    drug3.removeRecoed("Drugs.txt",remeovedId);
                }
                case 3 -> {
                    drug2.checkDrugeAvaliability();
                    drug2.theTypeOfDrug();
                    drug2.thequantityOfDrug();
                    drug2.getUnitPrice();
                }
                case 4 -> {
                    System.out.println("----------------------------------------");
                    drug2.getTotalMoneyToday();
                    System.out.println("----------------------------------------");
                }
                case 5 -> {
                }
                default -> {
                    System.out.println("Wrong choose!");
                    System.out.println("Please enter valid number");
                }
            }
        }
    }
}