/*
 * Date: May 20, 2021
 * Name: Ryan, Tisha, Andrew, Saad
 * Teacher: Mr.Ho
 * Description: Creating a NET pay calculator that displays data on a graph and csv file based on the income salary the user enters.
 * */

// Packages used throughout the code (especially for the Input/Output CSV Files)
import java.util.Scanner;
import java.io.*;

// Packages used to generate the GUI table
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color; 

// Packages used to generate the bar graph
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

class FinalSummative {
    public static void main(String[] args) {
        
        // Created so the user can be able to eneter their name, occupation and income salary.
        Scanner in = new Scanner(System.in);

    /** 
     * @tisha
     */
        // Amount and Perentages used throughout the calculations.
        int a = -3167;
        double b = 0.05;
        double d = 0.016;
        double e = 0.15;
        double f = 0.0505;
        
        // Greeting them about our NET pay calculator and what it does, then asking if they would like to proceed or not
        System.out.println("Welcome to our NET pay calculator.\nWhere we calculate your NET pay, then either put it in a table, generate in CSV file, or a graph.\nThen, finally tell you if your NET is less/above the average Canadian\n");
        
        // Giving them heads up/disclaimer on what the user has to do in order to generate the graph
        System.out.println("**In order to generate a Bar Graph, Get the Jar File include in the folder and go to");
        System.out.println("VS Code - Explorer - Java Projects - Referenced Libraries - Add Library and add the jar file**\n");
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
                // Glitch
                in.nextLine();
                System.out.println();
        
                printCPP(a,b,c);
                printEI(c,d);
                printFIT(c,e);
                printPIT(c,f);
                printTYD(a,b,c,d);
        
                // Rounds to nearest whole, re-intialized to call methods below
                double CPP = (Math.round(Integer.sum(a, c)*b)*100)/100;
                double EI = (Math.round(c*d)*100)/100;
                double FIT = (Math.round(c*e)*100)/100;
                double PIT = (Math.round(c*f)*100)/100;
                double TYD = (Math.round(Integer.sum(a,c)* b + (c*d))*100)/100;
                
                System.out.println("Which one of these would you like to generate?");
                System.out.println("Table with your NET (type 'T'), CSV file with your NET (type 'C'), a Bar Graph with your NET (type 'B'), or even all of them (type 'A') ?");
                choice = in.nextLine();

                while (!(choice.equalsIgnoreCase("T") || choice.equalsIgnoreCase("C") || choice.equalsIgnoreCase("B") || choice.equalsIgnoreCase("A"))){
                    System.out.println("Invalid. Type 'T' for table, 'C' for CSV File, or 'B' for bar graph");
                    choice = in.nextLine();
                }
                if (choice.equalsIgnoreCase("T")){
                    tableGUI(c, name, occupation, CPP, EI, FIT, PIT, TYD);
                    inputFile(c, CPP, EI, FIT, PIT);
                }
                else if (choice.equalsIgnoreCase("C")){
                    resultsFile(name, occupation, c, CPP, EI, FIT, PIT, TYD); 
                    inputFile(c, CPP, EI, FIT, PIT);
                }
                else if (choice.equalsIgnoreCase("B")){
                    generateGraph(name, CPP, EI, FIT, PIT, TYD); 
                    inputFile(c, CPP, EI, FIT, PIT);
                }
                else {
                    tableGUI(c, name, occupation, CPP, EI, FIT, PIT, TYD);
                    resultsFile(name, occupation, c, CPP, EI, FIT, PIT, TYD);
                    generateGraph(name, CPP, EI, FIT, PIT, TYD);
                    inputFile(c, CPP, EI, FIT, PIT);
                }          
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
    /** 
     * @tisha
     */
    /**
     * Finds the useres CPP (Canada Pension Plan) based on their income salary and Ontario's deduction numbers (rounded to the whole number).
     * 
     * @param a step 1 to find CPP (subtracts from the income salary)
     * @param b step 2 to find CPP (multiplies with the answer from step 1)
     * @param c the income salary
     */
    public static void printCPP(int a, double b, int c){
        System.out.println("Calculating Canada Pension Plan");
        System.out.println("$" + c + " " + a + " = $" + Integer.sum(a, c));  
        System.out.println("$" + Integer.sum(a,c) + " x " + b);
        System.out.println("Total CPP: $" + calculateCPP(a,b,c));
        System.out.println();
    }
    /**
     * Finds the EI (Employment Insurance) based on their income salary and Ontario's given percentage (rounded to the whole number).
     * 
     * @param c the income salary
     * @param d to find the EI you multiply 1.6%
     */
    public static void printEI(int c, double d){
        System.out.println("Calculating Employmemt Insurance");
        System.out.println("$" + c + " x " + d);
        System.out.println("Total EI: $" + calculateEI(c,d));
        System.out.println();
    }
    /**
     * Finds the Federal Income Tax based on the gross income (rounded to the whole number).
     * 
     * @param c the income salary
     * @param e the percentage that multiplies to find FIT (15%)
     */
    public static void printFIT(int c, double e){
        // Finds the Federal Income Tax based on the gross income.
        System.out.println("Calculating Federal Income Tax");
        System.out.println("$" + c + " x " + e);
        System.out.println("Total Federal Income Tax: $" + calculateFIT(c,e));
        System.out.println();
    }
    /**
     * Finds the Pronvicial Income Tax based on the gross income (rounded to the whole number).
     * 
     * @param c the income salary
     * @param f the percentage that multiplies to find PIT (5.0505%)
     */
    public static void printPIT(int c, double f){
        System.out.println("Calculating Provinvial Income Tax");
        System.out.println("$" + c + " x " + f);
        System.out.println("Total Provincial Income Tax: $" + calculatePIT (c,f));
        System.out.println();
    }
    /**
     * Calculating Total Yearly Deductions based off of the calulations above (rounded to the whole number).
     * 
     * @param a number used to find the CPP (3167)
     * @param b number used to to find CPP after subtracting (0.05)
     * @param c the income salary
     * @param d used to find the EI (0.016)
     */
    public static void printTYD(int a, double b, int c, double d){
        System.out.println("Calculating Total Yearly Deductions");
        System.out.println("$" + (Math.round(Integer.sum(a,c) * b)*100)/100 + " + $" + (Math.round(c * d)*100)/100);
        System.out.println("Total Yearly Deductions: $" + calculateTYD(a,b,c,d));
        System.out.println();
    }
    /**
     * @tisha
     */
    // Function calls used for table. 
    /**
     * @param a step 1 to find CPP (subtracts from the income salary)
     * @param b step 2 to find CPP (multiplies with the answer from step 1)
     * @param c the income salary
     * @return
     */

    public static double calculateCPP(int a, double b, int c){
        double CPP = (Math.round(Integer.sum(a,c) * b)*100)/100;
        return CPP;
    }
    /**
     * @param c the income salary
     * @param d used to find the EI (0.016)
     * @return
     */
    public static double calculateEI(int c, double d){
        double EI = (Math.round(c * d)*100)/100;
        return EI;
    }
    /**
     * @param c the income salary
     * @param e used to find FIT (0.15)
     * @return
     */
    public static double calculateFIT(int c, double e){
        double FIT = (Math.round(c * e)*100)/100;
        return FIT;
    }
    /**
     * @param c the income salary
     * @param f used ti find PIT (0.0505)
     * @return
     */
    public static double calculatePIT(int c, double f){
        double PIT = (Math.round(c * f)*100)/100;
        return PIT;
    }
    /**
     * @param a subtracts from CPP (3167)
     * @param b multiplies (0.05)
     * @param c income salary
     * @param d used to find EI (0.016)
     * @return
     */
    public static double calculateTYD(int a, double b, int c, double d){
        double TYD = (Math.round(Integer.sum(a,c) * b + c * d)*100)/100;
        return TYD;
    }
    /**
     * Creates the table in a GUI window, included with all the values for the user(s)
     * 
     * @param c
     * @param name
     * @param occupation
     * @param CPP
     * @param EI
     * @param FIT
     * @param PIT
     * @param TYD
     */
    public static void tableGUI(int c, String name, String occupation, double CPP, double EI, double FIT, double PIT, double TYD) {
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
        
        // Tells user table is generated
        System.out.println("Table has been Generated\n");
    }
    /**
     * Generates CSV file with all calculations of NET pay 
     * 
     * @param name
     * @param occupation
     * @param c
     * @param CPP
     * @param EI
     * @param FIT
     * @param PIT
     * @param TYD
     */
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
            
            // Prints desired information into file (rounded to whole number)
            bw.write("Your name is " + name);
            bw.newLine();
            bw.write("Occupation: " + occupation);
            bw.newLine();
            bw.write("Income: $" + income);
            bw.newLine();
            bw.write("Pension Plan: $" + pensionPlan);
            bw.newLine();
            bw.write("Employment Insurance: $" + empInsurance);
            bw.newLine();
            bw.write("Federal Tax: $" + federalTax);
            bw.newLine();
            bw.write("Provincial Tax: $" + provincialTax);
            bw.newLine();
            bw.write("Yearly Deductions: $" + yearlyDeduct);
            bw.flush();
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            // Saying it is generated in the CSV file
            System.out.println("Your results has been generated");
        }
        System.out.println();
    }
    /**
     * Creates a bar graph of all the calculations. Gives the user a visual to refer to, especially those who prefer visuals
     * 
     * @param name
     * @param EI
     * @param CPP
     * @param FIT
     * @param PIT
     * @param TYD
     */
    public static void generateGraph(String name, double EI, double CPP, double FIT, double PIT, double TYD) {
        // Intialize Scanner
        Scanner reader = new Scanner(System.in);

        // Declare Variables
        String yTitle = "Amount ($)";
        String xTitle = "Calculations";

        // Adds dataset to input the values of the amounts for each calculation
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Values of all the calculations are inputted onto the chart
        dataset.addValue(EI, yTitle, "EI");
        dataset.addValue(CPP, yTitle, "CPP");
        dataset.addValue(FIT, yTitle, "FIT");
        dataset.addValue(PIT, yTitle, "PIT");
        dataset.addValue(TYD, yTitle, "TYD");

        // Creates the bar chart 
        JFreeChart barChart = ChartFactory.createBarChart(
            "NET Pay Calculator - " + name,
            xTitle,
            yTitle,
            dataset, PlotOrientation.VERTICAL,
            true, true, false
        );
        
        // Size of the bar chart is declared 
        int width = 640;
        int height = 480;

        // Asks user what they would like to name their file, making it user friendly
        System.out.println("Next, What would you like to name the file of your graph? ");
        String fileName = reader.nextLine();
        System.out.println("Your graph has been generated\n");

        // File name
        File BarChart = new File(fileName + ".jpeg");

        // Saves the chart as a JPEG file into the folder used
        // If unable to, let's user know 'error' occurred
        try {
            ChartUtils.saveChartAsJPEG(BarChart, barChart, width, height);
        }
        catch (IOException e) {
            System.out.println("Error. Unable to generate bar graph");
        }
    }
    /**
     * Tells the user whether the NET pay is above or below the Canadian averages by the use of the avergae file 
     * 
     * @param c
     * @param CPP
     * @param EI
     * @param FIT
     * @param PIT
     */
    public static void inputFile(int c, double CPP, double EI, double FIT, double PIT) {
        // Initialize scanner (can't close, error)
        Scanner files = new Scanner(System.in);
        // Convert file path into string 
        System.out.println("Type in your file Name and Location of your average file (e.g. \\Users\\Name\\Desktop\\FolderName\\average) ");
        String fileNameLocation = files.nextLine();
        String file = (fileNameLocation + ".csv");
        System.out.println();
        String line = "";
 
        try {
             
             // Use package to read CSV file 
             BufferedReader br= new BufferedReader(new FileReader(file));
 
             while((line = br.readLine()) != null){
                 // In order to store all the data sepereated by sections or in this case commas
                 String [] values = line.split(",");
                 
                // Convert string to int
                int ACIncome = Integer.parseInt(values[1]);
                int ACPensionPlan = Integer.parseInt(values[3]);
                int ACEmployeeInsurance = Integer.parseInt(values[5]);
                int ACFederalTax = Integer.parseInt(values[7]);
                int ACProvincialTax = Integer.parseInt(values[9]);

                // the values from the csv file compared to user data by using if statement
                System.out.println("Average Canadian income is $" + values[1]);
                
                if (ACIncome >= c) {
                    System.out.println("You earn $" + (ACIncome  - c) + " more than the average Canadian\n");
                }
                if (ACIncome <= c) {
                    System.out.println("You earn $" + (c - ACIncome) + " less than the average Canadian\n");
                }

                System.out.println("Average Canadian deduction for pension plan is $" + values[3]);
                
                if (ACPensionPlan >= CPP) {
                    System.out.println("You deduct $" + (ACPensionPlan  - CPP) + " more for your pension plan than the average Canadian\n");
                }
                if (ACPensionPlan <= CPP) {
                    System.out.println("You deduct $" + (CPP - ACPensionPlan) + " less for your pension plan than the average Canadian\n");
                }

                System.out.println("Average Canadian deduction for employee insurance is $" + values[5]);
                
                if (ACEmployeeInsurance >= EI) {
                    System.out.println("You deduct $" + (ACEmployeeInsurance  - EI) + " more for your employee insurance than the average Canadian\n");
                }
                if (ACEmployeeInsurance <= EI) {
                    System.out.println("You deduct $" + (EI - ACEmployeeInsurance) + " less for your employee insurance than the average Canadian\n");
                }

                System.out.println("Average Canadian federal tax is $" + values[7]);
                
                if (ACFederalTax >= FIT) {
                    System.out.println("You deduct $" + (ACFederalTax  - FIT) + " more federal tax than the average Canadian\n");
                }
                if (ACFederalTax <= FIT) {
                    System.out.println("You deduct $" + (FIT - ACFederalTax) + " less federal tax than the average Canadian\n");
                }

                System.out.println("Average Canadian provincial tax is $" + values[9]);
                
                if (ACProvincialTax >= PIT) {
                    System.out.println("You deduct $" + (ACProvincialTax  - PIT) + " more provincial tax than the average Canadian\n");
                }
                if (ACProvincialTax <= PIT) {
                    System.out.println("You deduct $" + (PIT -ACProvincialTax) + " less provincial tax than the average Canadian\n");
                }           
            }    
        } 
        // catch block in case file is not found
        catch (FileNotFoundException e){
            e.printStackTrace();
        } 
        catch (IOException  e){
            e.printStackTrace();
        } 
    }
}
