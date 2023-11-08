package com.pluralsight;

import java.util.ArrayList;

public class AssetManager {
    public static void main(String[] args) {
        ArrayList<Asset> myAssets = new ArrayList<>();

        myAssets.add(new House("11/07/2023", "Clancy's House", 350000, "42 Clancy Boulevard", 1, 2000, 217800));
        myAssets.add(new House("11/07/2023", "Clancy's Mountain Home", 650000, "69 Bear Tree Way", 1, 4000, 87120));
        myAssets.add(new Vehicle("11/07/2023", "Clancy's Car", 6500, "Toyota Prius", 2008, 130000));
        myAssets.add(new Vehicle("11/07/2023", "Scout's Car", 10000, "Mazda Miata NA", 1995, 120000));
        myAssets.add(new Cash("11/07/2023", "Clancy's Cash Stash", 1000));

        for(int i = 0; i < myAssets.size(); i++) {
            System.out.println("Description: " + myAssets.get(i).getDescription() + " | Date Acquired: " + myAssets.get(i).getDateAcquired() + " | Purchase Price: " + myAssets.get(i).originalCost + " | Value: " + myAssets.get(i).getValue());
            if(myAssets.get(i) instanceof House) {
                House house = (House) myAssets.get(i);
                System.out.println("My house at " + house.getAddress());
            }
            else if(myAssets.get(i) instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) myAssets.get(i);
                System.out.println("Vehicle: " + vehicle.getMakeModel() + " " + vehicle.getYear());

            } else if (myAssets.get(i) instanceof Cash) {
                Cash cash = (Cash) myAssets.get(i);
                System.out.println("Clancy's Cash Stash: " + cash.getValue());
            }
        }
    }
}
