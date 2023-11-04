package com.pluralsight;

public class CartItem {
    static int quantity = 0;
    Products product;

    CartItem(int quantity, Products product){
        this.quantity = quantity;
        this.product = product;
    }

    public static int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        CartItem.quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

}
