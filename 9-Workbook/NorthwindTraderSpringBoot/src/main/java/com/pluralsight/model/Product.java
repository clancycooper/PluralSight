package com.pluralsight.model;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Objects;

@Component
public class Product {
        private int productID;
        private String name, category;
        private BigDecimal price;

        public Product() {
        }

    public Product(int productID, String name, String category, BigDecimal price) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductID() == product.getProductID() &&
                getPrice().compareTo(product.getPrice()) == 0 && // Use compareTo for BigDecimal comparison
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getCategory(), product.getCategory());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getProductID(), getName(), getCategory(), getPrice());
    }

    @Override
    public String toString() {
        return
                "Product ID: " + productID +
                "\nProduct:  " + name +
                "\nCategory: " + category +
                "\nPrice:    " + price +
                "\n -------- ";
    }
}
