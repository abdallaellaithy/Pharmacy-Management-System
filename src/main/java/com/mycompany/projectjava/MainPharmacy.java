/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectjava;




/**
 *
 * @author Abdal Maged
 */
public class MainPharmacy {
    public int quantityOfDrugs = 10;
    public float totalPriceToday = 0;
    public String drugName;
    public static int id ; // = Integer.parseInt(String.format("%03d" , 1));
    public float price;
    public String category;
    public int avaliableQuantity;
    public String searchedDrug;
    //Place An Order Class
    public String idOfOrder; // id of the order after searching
    public String searchingDrug; // name of the drug that user looking for
    public String unitePrice; // the price of the drug
    public String theCategory; // the category of the drug
    public boolean chekPriceIncrease = false; // check if the price will increase 1.2 or will be regular
    public double priceIncrease; // the price after increasin if it happen
    public String quantityOfDrug; // find the quantity of the drug
    public float newQuantity;
    public int Uquantity;
}