package com.example.firsthitmonday;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    ArrayList<DataModel> dataset;
    Dialog myDialog;
    public CustomeAdapter(ArrayList<DataModel> dataSet) {
        this.dataset = dataSet;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;

        public MyViewHolder (View itemView){
            super(itemView);

            textViewName = itemView.findViewById(R.id.textView);
            textViewVersion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout , parent , false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        myDialog = new Dialog(view.getContext());
        myDialog.setContentView(R.layout.popup_character);


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_name = (TextView) myDialog.findViewById(R.id.dialog_name_id);
                ImageView dialog_image = (ImageView) myDialog.findViewById(R.id.dialog_imageview_id);
                dialog_name.setText(dataset.get(myViewHolder.getAdapterPosition()).getName());
                dialog_image.setImageResource(dataset.get(myViewHolder.getAdapterPosition()).getImage());
                myDialog.show();

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageView;

        textViewName.setText(dataset.get(position).getName());
        textViewVersion.setText((dataset.get(position).getVersion()));
        imageView.setImageResource(dataset.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
