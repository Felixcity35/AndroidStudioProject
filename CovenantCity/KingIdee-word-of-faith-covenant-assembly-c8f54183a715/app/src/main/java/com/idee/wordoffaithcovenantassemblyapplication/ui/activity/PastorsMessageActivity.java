package com.idee.wordoffaithcovenantassemblyapplication.ui.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idee.wordoffaithcovenantassemblyapplication.R;
import com.idee.wordoffaithcovenantassemblyapplication.data.PastorMessageModel;
import com.idee.wordoffaithcovenantassemblyapplication.ui.adapter.PastorMessageAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PastorsMessageActivity extends AppCompatActivity {

    private static final String TAG ="PastormessageActivity" ;
    PastorMessageAdapter messageAdapter ;
    ArrayList<PastorMessageModel>  messageModels ;

    DatabaseReference pstmesssagereference  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastors_message);

        final ProgressBar progressBar = findViewById(R.id.myProgressBar);

        final ListView listViewpstmess = findViewById(R.id.pstmessagelistview);

        messageModels = new ArrayList<>();

        pstmesssagereference  = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kingidee-word-of-faith-covenan.firebaseio.com/PastorMessages");

      //  messageAdapter = new PastorMessageAdapter(this,0,messageModels);


        HashMap<String,Object> hashMap = new HashMap<>();

        hashMap.put("image","http://covenantcity.org/wp-content/uploads/2018/04/100.jpg");
        hashMap.put("topic","new man");
        hashMap.put("message","if a man be in christ he is a new creature behold old things hav past away and all has become new...");
        hashMap.put("timestamp","2019-13-07");

      //  reference.child("Chats").push().setValue(hashMap);


        pstmesssagereference.child("3").setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                 if (task.isSuccessful())
                 {
                     Toast.makeText(PastorsMessageActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(PastorsMessageActivity.this, "Unable to add", Toast.LENGTH_SHORT).show();
                 }
            }
        });


        pstmesssagereference.child("3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              // messageModels.clear();

                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                {

                for (DataSnapshot messagelist : dataSnapshot.getChildren()) {
                    Log.d(TAG, "onChildChanged:" + dataSnapshot.toString());

                    PastorMessageModel pastorMessageModel = messagelist.getValue(PastorMessageModel.class);

                    messageModels.add(pastorMessageModel);

                }


                    messageAdapter = new PastorMessageAdapter(PastorsMessageActivity.this,0,messageModels);
                    listViewpstmess.setAdapter(messageAdapter);

                   // progressBar.setVisibility(View.GONE);

                }
                else {
                    Toast.makeText(PastorsMessageActivity.this, "unable to access db", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





//
//        progressBar.setVisibility(View.VISIBLE);
//
//        messageModels.add(new PastorMessageModel(R.drawable.word_of_faith,"Basic Christian Life","to know your stand as a believer you must..","15 May 219,2:08pm"));
//        messageModels.add(new PastorMessageModel(R.drawable.word_of_faith,"Basic Christian Life","to know your stand as a believer you must..","15 May 219,2:08pm"));
//        messageModels.add(new PastorMessageModel(R.drawable.word_of_faith,"Basic Christian Life","to know your stand as a believer you must..","15 May 219,2:08pm"));
//        messageModels.add(new PastorMessageModel(R.drawable.word_of_faith,"Basic Christian Life","to know your stand as a believer you must..","15 May 219,2:08pm"));
//        messageModels.add(new PastorMessageModel(R.drawable.word_of_faith,"Basic Christian Life","to know your stand as a believer you must..","15 May 219,2:08pm"));
//        messageModels.add(new PastorMessageModel(R.drawable.listimagemodel,"Basic Christian Life","to know your stand as a believer you must..","15 May 219,2:08pm"));
//        messageModels.add(new PastorMessageModel(R.drawable.listimagemodel,"Basic Christian Life","to know your stand as a believer you must..","15 May 219,2:08pm"));
//
//
//
//        messageAdapter = new PastorMessageAdapter(this,0,messageModels);
//
//        listViewpstmess.setAdapter(messageAdapter);
//
//        progressBar.setVisibility(View.GONE);

    }
}
