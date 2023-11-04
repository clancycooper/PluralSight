package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        //Create scanner for User Input
        Scanner scanner = new Scanner(System.in);

        //Create variables for storing User Input, Read current file, Write to new file
        String fileName;
        String createFile;
        System.out.println("Enter the name of the employee file you wish to process: ");
        fileName = scanner.nextLine();
        System.out.println("Enter the name of the payroll file you wish to create: ");
        createFile = scanner.nextLine();

        //Not allowing to save over the employees file
        if (createFile.equals("employees.csv")) {
            System.out.println("The file you are trying to create already exists.\n Enter the name of the payroll file you wish to create: ");
            createFile = scanner.nextLine();
        }



        //Declaring try, file reader, buffer reader. String csv and int firstLine
        try {
            FileReader fileReader = new FileReader("src/main/resources/" + fileName);
            BufferedReader bufReader = new BufferedReader(fileReader);
            String csv;
            int firstLine = 0;

            //Declare new file writer and buffered writer
            FileWriter fileWriter = new FileWriter("src/main/resources/" + createFile);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            //Setting while loop to read employees while not null
            while((csv = bufReader.readLine()) != null) {

                //Splitting the csv at "|" into ID, Name, Hours Worked and Pay Rate
                String[] employee = csv.split("\\|");
                int id = Integer.parseInt(employee[0]);
                String name = employee[1];
                double hoursWorked = Double.parseDouble(employee[2]);
                double payRate = Double.parseDouble(employee[3]);

                //Setting new instance of Employee class to use getters for displaying data
                Employee employees = new Employee(id, name, hoursWorked, payRate);
                System.out.printf("Employee ID: %d | Name: %s | Gross Pay: $%.2f%n", id , name, employees.getGrossPay());

                //Printing first line to new files
                if(firstLine < 1) {
                    bufWriter.write("id|name|hours-worked|pay-rate \n");
                    bufWriter.write("111|Cameron Tay|3277.65" + "\n222|James Tee|2150.00\n");
                    firstLine++;
                }

                //Allowing for input with fileWriter and bufWriter
                bufWriter.write(id + "|" + name + "|" + employees.getGrossPay());
                bufWriter.newLine();
            }

            //Close both Reader and Writer
            bufReader.close();
            bufWriter.close();
        }

        //Ending try with catch exception
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
