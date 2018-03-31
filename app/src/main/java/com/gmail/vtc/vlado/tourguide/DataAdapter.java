package com.gmail.vtc.vlado.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 26.3.2018..
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private List<Data> dataList;

    public DataAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_picture)
        ImageView imageView;
        @BindView(R.id.tv_name)
        TextView textView;
        @BindView(R.id.tv_description)
        TextView textView1;
        @BindView(R.id.btn_wiki)
        Button btnWiki;
        @BindView(R.id.btn_location)
        Button btnLocation;

        public MyViewHolder(View itemView) {

            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final DataAdapter.MyViewHolder holder, int position) {

        final Data data = dataList.get(position);

        holder.imageView.setImageResource(data.getImage());
        holder.textView.setText(data.getName());
        holder.textView1.setText(data.getDescription());

        holder.btnWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentWiki = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getWiki()));
                v.getContext().startActivity(intentWiki);

            }
        });

        holder.btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentWiki = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + data.getLocation() + "&z=17"));
                v.getContext().startActivity(intentWiki);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }
}
















