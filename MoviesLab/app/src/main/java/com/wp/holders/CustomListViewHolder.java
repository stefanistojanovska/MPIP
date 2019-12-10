package com.wp.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wp.R;

public class CustomListViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textViewName;
    private TextView textViewYear;

    public CustomListViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.img);
        textViewName=itemView.findViewById(R.id.title);
        textViewYear = itemView.findViewById(R.id.year);

        itemView.setTag(this);
    }

    public void setText(String text, View.OnClickListener listener) {
        //textView.setText(text);
        //imageView.setImageResource(R.drawable.dpng);
        itemView.setOnClickListener(listener);
    }

}