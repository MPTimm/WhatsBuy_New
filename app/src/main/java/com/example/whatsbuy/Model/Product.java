package com.example.whatsbuy.Model;

import java.util.ArrayList;

public class Product {

    private String mName;
    private int qtdProduct;

    public Product(String name, int qtd){
        this.mName = name;
        this.qtdProduct = qtd;
    }

    public String getName() {
        return mName;
    }

    private static int lastProductId = 0;

    public static ArrayList<Product> createProductsList(int numProducts, String nameProduct){
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(nameProduct, numProducts));

        return products;
    }
}
