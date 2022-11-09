package com.example.whatsbuy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsbuy.Model.Product;
import com.example.whatsbuy.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View productView = inflater.inflate(R.layout.item_product, parent, false);

        ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {

        Product product = mProducts.get(position);

        TextView textView = holder.nameTextView;
        textView.setText(product.getName());
        EditText qtd = holder.qtdText;
        qtd.setText(0);
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView;
        public EditText qtdText;

        public ViewHolder(View itemView){
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.product_name);
            qtdText = (EditText) qtdText.findViewById(R.id.et_qtd);
        }

    }

    private List<Product> mProducts;

    public ProductAdapter(List<Product> products){
        mProducts = products;
    }
}
