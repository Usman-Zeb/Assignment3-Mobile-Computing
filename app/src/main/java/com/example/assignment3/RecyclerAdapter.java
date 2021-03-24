package com.example.assignment3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment3.models.Result;
import com.example.assignment3.models.Results;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Result> users;
    private String Img_url;
    private OnListener monListener;

    public RecyclerAdapter (List<Result> users, OnListener onListener) {

        this.users = users;
        this.monListener = onListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_view_item,parent,false);
        return new ViewHolder(view, monListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result user = users.get(position);
        Img_url = users.get(position).getPicture().getLarge();
        //String name = user.getName().getFirst();
        holder.textView.setText(user.getName().getFirst());

        Picasso.get().load(Img_url).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        OnListener onListener;
        public ViewHolder(@NonNull View itemView, OnListener onListener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ImgIcon);
            textView = itemView.findViewById(R.id.TextTitle);
            this.onListener = onListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListener.onClick(getAdapterPosition());
        }
    }

    public interface OnListener{
        void onClick(int position);
    }
}
