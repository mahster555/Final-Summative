/*
 * Date: May 20, 2021
 * Name: Ryan, Tisha, Andrew, Saad
 * Teacher: Mr.Ho
 * Description: Creating a NET pay calculator that displays data on a graph and csv file based on the income salary the user enters.
 * */

import java.util.Scanner;

class FinalSummative {
    public static void main(String[] args) {
        
        // Created so the user can be able to eneter their name, occupation and income salary.
        Scanner in = new Scanner(System.in);
        
        // Amount and Perentages used throughout the calculations.
        int a = -3167;
        double b = 0.05;
        double d = 0.016;
        double e = 0.15;
        double f = 0.0505;
        
        // Asks the user questions to know more about them.
        System.out.println("What is your first and last name");
        in.nextLine();
        
        System.out.println("What is your occupation?");
        in.nextLine();

        // Used as the main number throughout the calculations.
        System.out.println("Enter your income salary:");
        int c = in.nextInt();

        // Used to space out the calculations (delete if you like)
        System.out.println("");

        // Finds the useres CPP (Canada Pension Plan) based on their income salary and Ontario's deduction numbers.
        System.out.println("Calculating Canada Pension Plan");
        System.out.println(c + " - " + a + " = " + Integer.sum(a, c));  
        System.out.println(Integer.sum(a,c) + " x " + b);
        System.out.println(("Total CPP: ") + (Math.round(Integer.sum(a,c) * b)*10.0)/10.0);

        // Used to space out the calculations (delete if you like)
        System.out.println("");

        // Finds the EI (Employment Insurance) based on their income salary and Ontario's given percentage.
        System.out.println("Calculating Employmemt Insurance");
        System.out.println(c + " x " + d);
        System.out.println("Total EI: " + (Math.round(c * d)*10.0)/10.0);

        // Used to space out the calculations (delete if you like)
        System.out.println("");

        // Finds the Federal Income Tax based on the gross income.
        System.out.println("Calculating Federal Income Tax");
        System.out.println(c + " x " + e);
        System.out.println("Total Federal Income Tax: " + (Math.round(c * e)*10.0)/10.0);

        // Used to space out the calculations (delete if you like)    
        System.out.println("");

        // Finds the Pronvicial Income Tax based on the gross income.
        System.out.println("Calculating Provinvial Income Tax");
        System.out.println(c + " x " + f);
        System.out.println("Total Provincial Income Tax: " + (Math.round(c * f)*10.0)/10.0);

        // Used to space out the calculations (delete if you like)    
        System.out.println("");

        // Calculating Total Yearly Deductions.
        System.out.println("Calculating Total Yearly Deductions");
        System.out.println((Math.round(Integer.sum(a,c) * b)*10.0)/10.0 + " + " + (Math.round(c * d)*10.0)/10.0);
        System.out.println("Total Yearly Deductions: " + (Math.round(Integer.sum(a,c) * b + c * d)*10.0)/10.0);


    }
}
