package com.idee.wordoffaithcovenantassemblyapplication.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.idee.wordoffaithcovenantassemblyapplication.R;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ListView listView = findViewById(R.id.eventidlist);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                {
                    Intent intent = new Intent(EventActivity.this,EventDetailsActivity.class);
                    startActivity(intent);
                }

                if (i == 1)
                {
                    Intent intent = new Intent(EventActivity.this,EventDetailsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
        }

