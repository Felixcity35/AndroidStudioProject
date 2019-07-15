package com.idee.wordoffaithcovenantassemblyapplication.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idee.wordoffaithcovenantassemblyapplication.R;
import com.idee.wordoffaithcovenantassemblyapplication.data.PastorMessageModel;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class MessgeMainActivity extends AppCompatActivity {

    PastorMessageModel messageModel  ;
    Context mContext ;
    DatabaseReference reference ;

    ImageView image,image1 ;
    TextView topic,message,timestamp,topic1,message1,timestamp1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messge_main);

//        ProgressBar progressBar = findViewById(R.id.myProgressBar);

       //   progressBar.setVisibility(View.VISIBLE);

        ProgressDialog progressDialog = new ProgressDialog(this);

         image = findViewById(R.id.image);
      //   image1 = findViewById(R.id.image1);

         progressDialog.setMessage("wait...");
         progressDialog.show();
        Picasso.with(MessgeMainActivity.this).load("http://covenantcity.org/wp-content/uploads/2018/04/100.jpg").into(image);
      //  Picasso.with(MessgeMainActivity.this).load("http://covenantcity.org/wp-content/uploads/2018/04/PRO-IN-THE-OFFICE-copy-Copy.jpg").into(image1);
      //  progressBar.setVisibility(View.INVISIBLE);
        // image.setImageResource(messageModel.getImage());
       // Picasso.with(mContext).load(messageModel.getImage()).into(image);

        progressDialog.dismiss();

        final TextView topic = findViewById(R.id.topic);
      //  topic.setText(messageModel.getTopic());

         message = findViewById(R.id.message);
     //  message.setText(messageModel.getMessage());

         timestamp = findViewById(R.id.timestamp);
     //  timestamp.setText(messageModel.getTimestamp());

        reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kingidee-word-of-faith-covenan.firebaseio.com/PastorMessages");


        reference.child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    Map<String, Object> objectMap = (HashMap<String, Object>) dataSnapshot.getValue();
                  //  String imagesnap = (String) objectMap.get( "image" );
                    String topicsnap = (String) objectMap.get( "topic" );
                    String messagesnap = (String) objectMap.get( "message" );
                    String timestampsnap = (String) objectMap.get( "timestamp" );

                    Log.d("message", "Value is: " + messagesnap);
                  //  Picasso.with(mContext).load(imagesnap).into(image);
                    topic.setText(topicsnap);
                    message.setText(messagesnap);
                    timestamp.setText(timestampsnap);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


//        reference.child("4").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                if(dataSnapshot.exists()){
//                    Map<String, Object> objectMap = (HashMap<String, Object>) dataSnapshot.getValue();
//                    //  String imagesnap = (String) objectMap.get( "image" );
//                    String topicsnap = (String) objectMap.get( "topic" );
//                    String messagesnap = (String) objectMap.get( "message" );
//                    String timestampsnap = (String) objectMap.get( "timestamp" );
//
//                    Log.d("message", "Value is: " + messagesnap);
//                    //  Picasso.with(mContext).load(imagesnap).into(image);
//                    topic1.setText(topicsnap);
//                    message1.setText(messagesnap);
//                    timestamp1.setText(timestampsnap);
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//



    }
}
