package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventory {
    //Class Scanner
    public void Scanner() {
        Scanner scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        //Create try and catch, File Reader, Buffered Reader and int first line
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String csv;
            int firstLine = 0;

            //Create new File Writer and Buffered Writer
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv", true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            //Setting while loop to read inventory while not is null
            while ((csv = bufReader.readLine()) != null)
            {
                //ArrayList
                ArrayList<Products> productList = new ArrayList<Products>();
                System.out.println("We carry the following inventory: ");
                //for loop for listing inventory to user
                for (Products p : productList) {
                    System.out.printf("\n ID: %d| Name: %s| Price: $%.2f".formatted(p.getId(), p.getName(), p.getPrice()));
                }

                //Split the csv at "|" into ID, Name, Price
                String[] inventory = csv.split("\\|");
                int id = Integer.parseInt(inventory[0]);
                String name = inventory[1];
                float price = Float.parseFloat(inventory[2]);
                Products newProduct = new Products(id, name, price);
                productList.add(newProduct);

                //Printing first line to new files
                if (firstLine < 1) {
                    bufWriter.write("ID|Name|Price \n");
                    bufWriter.write("");
                    firstLine++;
                }
                fileReader.close();
                fileWriter.close();
                bufWriter.close();
                bufReader.close();
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
