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

        // Used as the main number throughout the calculations (input as whole number or results in error).
        // Can make a while statement if you would like
        System.out.println("Enter your income salary (to the whole number, if not, reults in an error):");
        int c = in.nextInt(); 
        System.out.println();
        
        printCPP(a,b,c);
        printEI(c,d);
        printFIT(c,e);
        printPIT(c,f);
        printTYD(a,b,c,d);
    }
    // Finds the useres CPP (Canada Pension Plan) based on their income salary and Ontario's deduction numbers (rounded to the whole number).
    public static void printCPP(int a, double b, int c){
        System.out.println("Calculating Canada Pension Plan");
        System.out.println("$" + c + " - " + a + " = " + Integer.sum(a, c));  
        System.out.println(Integer.sum(a,c) + " x " + b);
        System.out.println("Total CPP: $" + calculateCPP(a,b,c));
        System.out.println();
    }
     // Finds the EI (Employment Insurance) based on their income salary and Ontario's given percentage (rounded to the whole number).
    public static void printEI(int c, double d){
        System.out.println("Calculating Employmemt Insurance");
        System.out.println("$" + c + " x " + d);
        System.out.println("Total EI: $" + calculateEI(c,d));
        System.out.println();
    }
    // Finds the Federal Income Tax based on the gross income (rounded to the whole number).
    public static void printFIT(int c, double e){
        // Finds the Federal Income Tax based on the gross income.
        System.out.println("Calculating Federal Income Tax");
        System.out.println("$" + c + " x " + e);
        System.out.println("Total Federal Income Tax: $" + calculateFIT(c,e));
        System.out.println();
    }
    // Finds the Pronvicial Income Tax based on the gross income (rounded to the whole number).
    public static void printPIT(int c, double f){
        System.out.println("Calculating Provinvial Income Tax");
        System.out.println("$" + c + " x " + f);
        System.out.println("Total Provincial Income Tax: $" + calculatePIT (c,f));
        System.out.println();
    }
    // Calculating Total Yearly Deductions based off of the calulations above (rounded to the whole number).
    public static void printTYD(int a, double b, int c, double d){
        System.out.println("Calculating Total Yearly Deductions");
        System.out.println("$" + (Math.round(Integer.sum(a,c) * b)*100)/100 + " + $" + (Math.round(c * d)*100)/100);
        System.out.println("Total Yearly Deductions: $" + calculateTYD(a,b,c,d));
        System.out.println();
    }
    // Function calls used for table. 
    public static double calculateCPP(int a, double b, int c){
        return (Math.round(Integer.sum(a,c) * b)*100)/100;
    }
    public static double calculateEI(int c, double d){
        return (Math.round(c * d)*100)/100;
    }
    public static double calculateFIT(int c, double e){
        return (Math.round(c * e)*100)/100;
    }
    public static double calculatePIT(int c, double f){
        return (Math.round(c * f)*100)/100;
    }
    public static double calculateTYD(int a, double b, int c, double d){
        return (Math.round(Integer.sum(a,c) * b + c * d)*100)/100;
    }
    
}
