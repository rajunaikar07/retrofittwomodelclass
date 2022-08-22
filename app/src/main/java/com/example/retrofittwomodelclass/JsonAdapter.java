package com.example.retrofittwomodelclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.MyHolder> {

    Context context;
    List<Countrymodel> countrymodelList=new ArrayList<>();

    public JsonAdapter(Context context, List<Countrymodel> countrymodelList) {
        this.context = context;
        this.countrymodelList = countrymodelList;
    }

    @NonNull
    @Override
    public JsonAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  root= LayoutInflater.from(parent.getContext()).inflate(R.layout.coustom,parent,false);

        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonAdapter.MyHolder holder, int position) {

        holder.countrynameTxt.setText(" "+countrymodelList.get(position).getCountryName());
     //   holder.url.setText(" "+countrymodelList.get(position).getUrltoimage());
        holder.capital.setText(" "+countrymodelList.get(position).getCapital());
        holder.priministor.setText(" "+countrymodelList.get(position).getDetailsModel().getPrimeMinister());
        holder.population.setText(" "+countrymodelList.get(position).getDetailsModel().getPopulation());


        Glide.with(context).load(countrymodelList.get(position).getUrl())
                .centerCrop().placeholder(R.mipmap.ic_launcher).into(holder.imageDisplay);

    }

    @Override
    public int getItemCount() {
        return countrymodelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView countrynameTxt,capital,priministor,population;
        ImageView imageDisplay;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            countrynameTxt = itemView.findViewById(R.id.name);
        //    url = itemView.findViewById(R.id.urlid);
            capital = itemView.findViewById(R.id.capital);
            priministor=itemView.findViewById(R.id.priministor);
            population=itemView.findViewById(R.id.population);


            imageDisplay = itemView.findViewById(R.id.image);
        }
    }
}