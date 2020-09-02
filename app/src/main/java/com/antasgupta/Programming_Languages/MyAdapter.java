package com.antasgupta.Programming_Languages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.InnerClass> implements Filterable { //Here we are defining a constructor

    String text[]; //we have defined Global Variables text and image
   // String text1[];
    int image[];
//    List<String> finalresult;

    List<String> namelist;

    public MyAdapter(List<String> namelist) {
        this.namelist = namelist;
    }

    public MyAdapter(String text[], int image[]){
        this.image = image;
        this.text = text;

    }

    @NonNull
    @Override
    public InnerClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerClass((LayoutInflater.from(parent.getContext())).inflate(R.layout.recycler_view_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerClass holder, int position) {
        holder.imageView.setImageResource(image[position]);
        holder.textView.setText(text[position]);

    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    @Override
    public Filter getFilter() {

        return filter;
    }

    Filter filter = new Filter() {

        // this runs in the background

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> filteredList = new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filteredList.addAll(namelist);
            }
            else {
                for (String text: namelist){
                    if (text.toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(text);
                    }
                }
            }

            FilterResults filter = new FilterResults();
            filter.values = filteredList;
            return filter;
        }
        // this runs on a UI Thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults filter) {
            namelist.clear();
            namelist.addAll((Collection<? extends String>) filter.values);
            notifyDataSetChanged();
        }
    };


    public class InnerClass extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public InnerClass(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);

        }
    }
}
