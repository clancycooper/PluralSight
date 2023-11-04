package com.pluralsight;

public class Products {
        private final String sku;
        private final String name;
        private final float price;
        private final String department;
        public Products(String sku, String name, float price, String department) {
            this.sku = sku;
            this.name = name;
            this.price = price;
            this.department = department;

        }
        public String getSku() {
            return this.sku;
        }
        public String getName() {
            return this.name;
        }
        public float getPrice() {
            return this.price;
        }
        public String getDepartment() {
            return this.department;
        }
}
