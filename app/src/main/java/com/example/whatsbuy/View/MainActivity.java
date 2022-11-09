package com.example.whatsbuy.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.whatsbuy.Adapter.ProductAdapter;
import com.example.whatsbuy.Model.Product;
import com.example.whatsbuy.R;


import java.util.ArrayList;

public class MainActivity extends  AppCompatActivity{

    ArrayList<Product> products;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvProducts = (RecyclerView) findViewById(R.id.rvProducts);

        products = Product.createProductsList(10, "Banana");
        ProductAdapter adapter = new ProductAdapter(products);

        rvProducts.setAdapter(adapter);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
    }

}