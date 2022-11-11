package com.example.whatsbuy.Model;

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


}
