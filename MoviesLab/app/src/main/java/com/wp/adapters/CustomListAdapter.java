package com.wp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wp.R;
import com.wp.holders.CustomListViewHolder;
import com.wp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends RecyclerView.Adapter {
    List<Movie> dataset;
    View.OnClickListener listener;

    public CustomListAdapter(View.OnClickListener listener) {
        this.dataset = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);

        return new CustomListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //TODO Dovrsi setText!
        ((CustomListViewHolder)holder).setText(dataset.get(position).title, listener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public void updateDataset(List<Movie> newDataset) {
        this.dataset = newDataset;
        notifyDataSetChanged();
    }

    public Long getClickedItemId(CustomListViewHolder holder) {
        int adapterPosition = holder.getAdapterPosition();
        return dataset.get(adapterPosition).Id;
    }

}