package com.idee.wordoffaithcovenantassemblyapplication.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.idee.wordoffaithcovenantassemblyapplication.R;
import com.idee.wordoffaithcovenantassemblyapplication.ui.adapter.LiveStreamAdapter;
import com.idee.wordoffaithcovenantassemblyapplication.data.Model;

import java.util.ArrayList;

public class Download extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> arrayList = new ArrayList<>();
    LiveStreamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
       // getSupportActionBar().setTitle("Downloads");

        recyclerView = (RecyclerView) findViewById(R.id.rv_download);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new LiveStreamAdapter(this,arrayList);

        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

}
