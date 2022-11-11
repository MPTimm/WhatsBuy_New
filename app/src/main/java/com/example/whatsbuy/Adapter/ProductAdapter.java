package com.example.whatsbuy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsbuy.Model.Product;
import com.example.whatsbuy.R;

import java.util.LinkedList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private List<Product> mProducts;
    private LayoutInflater mInflater;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.item_product,parent,false);
        return new ViewHolder(mItemView, this);
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
        final ProductAdapter mAdapter;

        public ViewHolder(View itemView, ProductAdapter adapter){
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.product_name);
            qtdText = (EditText) qtdText.findViewById(R.id.et_qtd);

            this.mAdapter = adapter;
        }


    }

    public ProductAdapter(Context context, List<Product> productList){
        mInflater = LayoutInflater.from(context);
        this.mProducts = productList;
    }


}
