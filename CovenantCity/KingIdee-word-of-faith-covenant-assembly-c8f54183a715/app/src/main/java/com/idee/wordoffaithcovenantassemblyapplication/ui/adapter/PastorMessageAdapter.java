package com.idee.wordoffaithcovenantassemblyapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.idee.wordoffaithcovenantassemblyapplication.R;
import com.idee.wordoffaithcovenantassemblyapplication.data.PastorMessageModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PastorMessageAdapter extends ArrayAdapter<PastorMessageModel>
{
    private Context mContext ;
    private ArrayList<PastorMessageModel>  mPastorMessage  ;


    public PastorMessageAdapter(@NonNull Context context, int resource, ArrayList<PastorMessageModel>  mPastorMessage ) {
        super(context,resource,mPastorMessage);

        this.mContext = context ;
        this.mPastorMessage = mPastorMessage ;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View pstMessages = convertView ;

        if (pstMessages == null )
        {
            pstMessages  = LayoutInflater.from(mContext).inflate(R.layout.pstmessagelist,parent,false);

            PastorMessageModel messageModel = mPastorMessage.get(position);

            ImageView image = pstMessages.findViewById(R.id.image);
           // image.setImageResource(messageModel.getImage());
            Picasso.with(mContext).load(messageModel.getImage()).into(image);

            TextView topic = pstMessages.findViewById(R.id.topic);
            topic.setText(messageModel.getTopic());

            TextView message = pstMessages.findViewById(R.id.message);
            message.setText(messageModel.getMessage());

            TextView timestamp = pstMessages.findViewById(R.id.timestamp);
            timestamp.setText(messageModel.getTimestamp());

        }



        return pstMessages  ;



    }
}
