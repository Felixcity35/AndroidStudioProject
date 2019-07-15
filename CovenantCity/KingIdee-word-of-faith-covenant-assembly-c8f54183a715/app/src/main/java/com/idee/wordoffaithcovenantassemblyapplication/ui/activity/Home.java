package com.idee.wordoffaithcovenantassemblyapplication.ui.activity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.idee.wordoffaithcovenantassemblyapplication.R;
import com.idee.wordoffaithcovenantassemblyapplication.ui.adapter.ImageSliderAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.image, R.drawable.image, R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    ListView listViewHomeItems;

    BottomNavigationView navigation ;

    DatabaseReference reference ;
    TextView pstmessdetils,pstmessage ;
    TextView event ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



         pstmessage = findViewById(R.id.pstmessage);
        pstmessdetils = findViewById(R.id.pstmessagedetails);
        event = findViewById(R.id.eventid);


        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,EventActivity.class);
                startActivity(intent);
            }
        });


        pstmessdetils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,MessgeMainActivity.class);
                startActivity(intent);
            }
        });


        pstmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,MessgeMainActivity.class);
                startActivity(intent);
            }
        });

        reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kingidee-word-of-faith-covenan.firebaseio.com/PastorMessages");


        reference.child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    Map<String, Object> objectMap = (HashMap<String, Object>) dataSnapshot.getValue();
                    String topicsnap = (String) objectMap.get( "topic" );
                    String messagesnap = (String) objectMap.get( "message" );


                    Log.d("message", "Value is: " + messagesnap);

                    pstmessage.setText(topicsnap);
                    pstmessdetils.setText(messagesnap);


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        String[] items = {
                "Messages",
                "Livestream",
                "Downloads",
                "Find Us",
        };




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //init();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.downloadbottom:
                 //   mTextMessage.setText(R.string.title_home);
                    Intent intent = new Intent(Home.this,Download.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_dashboard:
                 //   mTextMessage.setText(R.string.title_dashboard);
                    Intent intent1 = new Intent(Home.this,LiveStream.class);
                    startActivity(intent1);
                    break;

                 //   return true;
                case R.id.navigation_notifications:
                   // mTextMessage.setText(R.string.title_notifications);
                    Intent intent2 = new Intent(Home.this,Notification.class);
                    startActivity(intent2);

                    return true;
            }
            return false;
        }
    };


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_livestream) {
            startActivity(new Intent(Home.this, LiveStream.class));
            // Handle the camera action
        } else if (id == R.id.nav_download) {
            startActivity(new Intent(Home.this, Download.class));
        } else if (id == R.id.nav_find_us) {
            startActivity(new Intent(Home.this, FindUs.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        //mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new ImageSliderAdapter(this, XMENArray));
        //CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        /*<android.support.v4.view.ViewPager
        android:layout_marginTop="20dp"
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="200dp" />

    <me.relex.circleindicator.CircleIndicator
        android:id="@+id/indicator"
        app:ci_drawable_unselected="@android:color/holo_red_dark"
        app:ci_drawable="@android:color/holo_blue_bright"
        android:layout_width="match_parent"
        android:layout_height="48dp"/>*/


        //indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5500, 5500);
    }

}
