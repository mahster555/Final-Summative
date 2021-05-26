/*
 * Date: 
 * Name: Ryan, Tisha, Andrew, Saad
 * Teacher: Mr.Ho
 * Description: Creating a NET pay calculator that displays data on a graph and csv file.
 * */

import java.util.Scanner;

class FinalSummative {
    public static void main(String[] args) {
        
        // Created so the user can be able to eneter thier name, occupation and income salary.
        Scanner in = new Scanner(System.in);
        
        // Amount and Perentages used throughout the calculations.
        int a = -3167;
        double b = 0.05;
        double d = 0.016;
        double e = 0.15;
        double f = 0.0505;
        
        // Asks the user questions to know more about them.
        System.out.println("What is your name?");
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
        System.out.println(("Total CPP: ") + Integer.sum(a,c) * b);

        // Used to space out the calculations (delete if you like)
        System.out.println("");

        // Finds the EI (Employment Insurance) based on their income salary and Ontario's given percentage.
        System.out.println("Calculating Employmemt Insurance");
        System.out.println(c + " x " + d);
        System.out.println("Total EI: " + c * d);

        // Used to space out the calculations (delete if you like)
        System.out.println("");

        // Finds the Federal Income Tax based on the gross income.
        System.out.println("Calculating Federal Income Tax");
        System.out.println(c + " x " + e);
        System.out.println("Total Federal Income Tax: " + c * e);

        // Used to space out the calculations (delete if you like)    
        System.out.println("");

        // Finds the Pronvicial Income Tax based on the gross income.
        System.out.println("Calculating Provinvial Income Tax");
        System.out.println(c + " x " + f);
        System.out.println("Total Provincial Income Tax: " + c * f);

        // Used to space out the calculations (delete if you like)    
        System.out.println("");

        // Calculating Total Yearly Deductions.
        System.out.println("Calculating Total Yearly Deductions");
        System.out.println(Integer.sum(a,c) * b + " + " + c * d);
        System.out.println("Total Yearly Deductions: " + (Integer.sum(a,c) * b + c * d));


    }
}
