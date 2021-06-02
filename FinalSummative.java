/*
 * Date: May 20, 2021
 * Name: Ryan, Tisha, Andrew, Saad
 * Teacher: Mr.Ho
 * Description: Creating a NET pay calculator that displays data on a graph and csv file based on the income salary the user enters.
 * */

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color; 
import java.io.*;

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
        
        // Greeting them about our NET pay calculator and what it does, then asking if they would like to proceed or not
        System.out.println("Welcome to our NET pay calculator where we calculate your NET, then put it in a table, a graph, and generate it in a CSV file\n");
        System.out.println("Would you like to use our NET pay calculator (type 'yes' to proceed or 'no' to quit)? ");
        String choice = in.nextLine();

        do {
            // While the choice doesn't equal to either 'yes' or 'no', re-enter (case doesn't matter, e.g. Yes or yes)
            while (!(choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("No"))){
                System.out.println("Invalid, Type 'yes' to proceed or 'no' to quit");
                choice = in.nextLine();
            }
            // They quit out of program
            if (choice.equalsIgnoreCase("No")){
                System.out.println("You have exited");
            }
            // They proceed through the program
            else if (choice.equalsIgnoreCase("Yes")){
                
                // Asks the user questions to know more about them.
                System.out.println("What is your first and last name");
                String name = in.nextLine();
        
                System.out.println("What is your occupation?");
                String occupation = in.nextLine();

                // Used as the main number throughout the calculations (input as whole number or results in error).
                System.out.println("Enter your income salary (to the whole number, if not, reults in an error):");
                int c = in.nextInt(); 
                System.out.println();
        
                printCPP(a,b,c);
                printEI(c,d);
                printFIT(c,e);
                printPIT(c,f);
                printTYD(a,b,c,d);
        
                tableGUI(a, b, c, d, e, f, name, occupation);
        
                // Rounds to nearest whole, re-intialized to call method below
                double CPP = (Math.round(Integer.sum(a, c)*b)*100)/100;
                double EI = (Math.round(c*d)*100)/100;
                double FIT = (Math.round(c*e)*100)/100;
                double PIT = (Math.round(c*f)*100)/100;
                double TYD = (Math.round(Integer.sum(a,c)* b + (c*d))*100)/100;

                resultsFile(name, occupation, c, CPP, EI, FIT, PIT, TYD);
                    
                // Ask again if they want to calculate another score
                System.out.println("Would you like to calculate another NET pay and erase the previous one (type 'yes' to continue or 'no' to quit)");
                choice = in.nextLine();
                                
                // Again if what they typed doesn't match 'yes' or 'no' (case doesn't matter, yes or Yes) (these lines below are for the repeation of the program if they continue)
                while (!(choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("No"))){
                    System.out.println("Invalid, Type 'yes' to continue or 'no' to quit");
                    choice = in.nextLine();
                }
            } 
        } while (!choice.equalsIgnoreCase("No")); // Repeats whole process and calculating another NET pay
        // Close Scanner and a Exit Statement
        in.close();
        System.out.println("You have exited");
    }
    // Finds the useres CPP (Canada Pension Plan) based on their income salary and Ontario's deduction numbers (rounded to the whole number).
    public static void printCPP(int a, double b, int c){
        System.out.println("Calculating Canada Pension Plan");
        System.out.println("$" + c + " " + a + " = $" + Integer.sum(a, c));  
        System.out.println("$" + Integer.sum(a,c) + " x " + b);
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
        double CPP = (Math.round(Integer.sum(a,c) * b)*100)/100;
        return CPP;
    }
    public static double calculateEI(int c, double d){
        double EI = (Math.round(c * d)*100)/100;
        return EI;
    }
    public static double calculateFIT(int c, double e){
        double FIT = (Math.round(c * e)*100)/100;
        return FIT;
    }
    public static double calculatePIT(int c, double f){
        double PIT = (Math.round(c * f)*100)/100;
        return PIT;
    }
    public static double calculateTYD(int a, double b, int c, double d){
        double TYD = (Math.round(Integer.sum(a,c) * b + c * d)*100)/100;
        return TYD;
    }
    // Creates the table in a GUI window, included with all the values for the user(s)
    public static void tableGUI(int a, double b, int c, double d, double e, double f, String name, String occupation) {
        // Collect the variables from the calculations in previouis methods
        double CPP = calculateCPP(a, b ,c);
        double EI = calculateEI(c, d);
        double FIT = calculateFIT(c, e);
        double PIT = calculatePIT(c, f);
        double TYD = calculateTYD(a, b, c, d);

        // Convert all the variables to strings
        String income = Integer.toString(c);
        String pensionPlan = Double.toString(CPP);
        String empInsurance = Double.toString(EI);
        String federalTax = Double.toString(FIT);
        String provincialTax = Double.toString(PIT);
        String yearlyDeduct = Double.toString(TYD);

        // Declare Variables
        JFrame tableFrame;
        JTable tableTable;

        // Create a new JFrame and set the title
        tableFrame = new JFrame();
        tableFrame.setTitle("NET Pay Calculator - " + name);

        // Add data values going to be added for rows
        String[][] data = {
            {name, occupation, "$" + income, "$" + pensionPlan, "$" + empInsurance, "$" + federalTax, "$" + provincialTax, "$" + yearlyDeduct}
        };

        // Add the column names
        String[] columnNames = {"Name", "Occupation", "Income", "Canada Pension Plan", "Employment Insurance", "Federal Income Tax", "Provincial Income Tax", "Total Yearly Deductions"};

        // Create a new table and set bounds
        tableTable = new JTable(data,columnNames);
        tableTable.setBounds(30,40,200,300);
        
        // Add colour to the user's values, making it more user friendly
        Color ivory = new Color(255,255,208);
        tableTable.setOpaque(false);
        tableTable.setBackground(ivory);

        // Create a new scroll pane and set size and make it visible
        JScrollPane sp = new JScrollPane(tableTable);
        tableFrame.add(sp);
        tableFrame.setSize(1500,150);
        tableFrame.setVisible(true);
    }
    public static void resultsFile(String name, String occupation, int c, double CPP, double EI, double FIT, double PIT, double TYD) {
        // Convert all the variables to strings
        String income = Integer.toString(c);
        String pensionPlan = Double.toString(CPP);
        String empInsurance = Double.toString(EI);
        String federalTax = Double.toString(FIT);
        String provincialTax = Double.toString(PIT);
        String yearlyDeduct = Double.toString(TYD);
    
        // Initializing Scanner (can't close scanner)
        Scanner reader = new Scanner(System.in);
        
        // Asks Where They Want The New Result File Stored (File Name)
        System.out.println("What file name would you like to store it in (e.g. calculate)?");
        String fileLocation = reader.nextLine(); // where user inputs file name
        File newFile = new File(fileLocation + ".csv");
        
        // Creates new file if not already (created within the folder you are in)
        try {
            newFile.createNewFile();
        }
        catch (IOException e){ // catches any exception
            e.printStackTrace();
        }
        
        try{
            // Initalize packages
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Prints desired information into file
            bw.write("Your name is " + name);
            bw.newLine();
            bw.write("Occupation: " + occupation);
            bw.newLine();
            bw.write("Income: " + income);
            bw.newLine();
            bw.write("Pension Plan: " + pensionPlan);
            bw.newLine();
            bw.write("Employment Insurance: " + empInsurance);
            bw.newLine();
            bw.write("Federal Tax: " + federalTax);
            bw.newLine();
            bw.write("Provincial Tax: " + provincialTax);
            bw.newLine();
            bw.write("Yearly Deductions: " + yearlyDeduct);
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            // Saying it is generated in the CSV file
            System.out.println("Your results has been generated");
        }
        System.out.println();
    }
}
