package com.idee.wordoffaithcovenantassemblyapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.idee.wordoffaithcovenantassemblyapplication.R;

import java.util.ArrayList;

/**
 * Created by idee on 6/10/17.
 */

public class CustomListAdapter extends BaseAdapter {

    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> integer = new ArrayList<>();
    Context context;

    public CustomListAdapter(Context context, ArrayList<String> text, ArrayList<Integer> integer) {
        this.text = text;
        this.integer = integer;
        this.context = context;
    }

    @Override
    public int getCount() {
        return text.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView!=null)
            LayoutInflater.from(context).inflate(R.layout.item_row_livestream,null);

        View view = LayoutInflater.from(context).inflate(R.layout.item_row_livestream,null);

        TextView textView = (TextView) view.findViewById(R.id.tv_src);
        textView.setText(text.get(position));

        //ImageView imageView = (ImageView) view.findViewById(R.id.iv_src);
        //imageView.setImageResource(integer.get(position));

        return view;
    }

}
