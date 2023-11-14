package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Portfolio implements Valuable{
    protected String name, owner;
    public List<Valuable> assets = new ArrayList<>();

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void add(Valuable asset) {
        assets.add(asset);
    }

    @Override
    public double getValue() {
        double totalValue = 0.0;
        for(Valuable asset : assets) {
            totalValue += asset.getValue();
        }
        return totalValue;
    }

    public Valuable getMostValuable() {
    if(assets.isEmpty()) {
        return null;
    }
    return Collections.max(assets);
    }

    public Valuable getLeastValuable() {
    if(assets.isEmpty()) {
        return null;
    }
    return Collections.min(assets);
    }

    @Override
    public int compareTo(Valuable o) {
        return 0;
    }
}
