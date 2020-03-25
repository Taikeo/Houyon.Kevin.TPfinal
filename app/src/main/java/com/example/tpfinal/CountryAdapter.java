package com.example.tpfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Product> products=null;

    public CountryAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.products = products;
    }

    @Override
    public int getCount(){
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { View myView;
        if(view == null){
            myView = inflater.inflate(R.layout.activity_main, viewGroup, false);
        }else{
            myView = view;
        }
        TextView mCountryName = myView.findViewById(R.id.nom); TextView mContinent = myView.findViewById(R.id.continent); TextView mSubContinent = myView.findViewById(R.id.subcontinent);ImageView mCountryFlag = myView.findViewById(R.id.flag);
         Product product = (Product) this.getItem(i);
        mCountryName.setText(product.getNom()); mContinent.setText(product.getContinent()); mSubContinent.setText(product.getSubcontinent());mCountryFlag.setImageResource(product.getImage());
        return myView; }


}
