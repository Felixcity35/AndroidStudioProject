package com.idee.wordoffaithcovenantassemblyapplication.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.idee.wordoffaithcovenantassemblyapplication.R;
import com.idee.wordoffaithcovenantassemblyapplication.ui.adapter.CustomListAdapter;

import java.util.ArrayList;

public class LiveStream extends AppCompatActivity {

    private ListView listView;
    CustomListAdapter adapter;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> integer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestream);
     //  getSupportActionBar().setTitle("Livestream");
      //  getSupportActionBar().setDisplayShowHomeEnabled(true);

      //  text.add("Facebook");
     //   text.add("Youtube");
     //   text.add("Livestream.com");

   //     integer.add(R.drawable.fb);
    //    integer.add(R.drawable.fb);
     //   integer.add(R.drawable.fb);

    //    listView = (ListView) findViewById(R.id.lv_livestream);
      //  adapter = new CustomListAdapter(this, text, integer);
   //     adapter.notifyDataSetChanged();

    //    listView.setAdapter(adapter);

    }

}
