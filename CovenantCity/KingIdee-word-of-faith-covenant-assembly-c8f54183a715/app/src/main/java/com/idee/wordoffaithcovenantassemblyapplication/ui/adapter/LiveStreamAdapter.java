package com.idee.wordoffaithcovenantassemblyapplication.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.idee.wordoffaithcovenantassemblyapplication.R;
import com.idee.wordoffaithcovenantassemblyapplication.data.Model;

import java.util.ArrayList;

/**
 * Created by idee on 6/10/17.
 */

public class LiveStreamAdapter extends RecyclerView.Adapter<LiveStreamAdapter.ViewHolder> {

    private Context context;
    //private ArrayList<Model> arrayList = new ArrayList<>();

    public LiveStreamAdapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        //this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_download,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



        if (position==0){
            holder.textView.setText("Books");
            holder.imageView.setImageResource(R.drawable.books);

        } else if (position==1){

            holder.textView.setText("Audio");
            holder.imageView.setImageResource(R.drawable.audio);

        } else if (position==2){

            holder.textView.setText("Videos");
            holder.imageView.setImageResource(R.drawable.video);

        }




    }

    @Override
    public int getItemCount() {
        //Log.d("TAG", String.valueOf(arrayList.size()));
        return 3;

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_src);
            textView = (TextView) itemView.findViewById(R.id.tv_src);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }

}