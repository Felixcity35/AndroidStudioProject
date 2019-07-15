package app.interlocking.gi.giinterlocking;

import android.content.Intent;
import android.support.v4.view.ScrollingView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.q42.android.scrollingimageview.ScrollingImageView;

public class SliderActivity extends AppCompatActivity {

    ScrollingImageView scrollthird, scrollnext ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);


        Button registerbtn = findViewById(R.id.register);
        Button loginbtn = findViewById(R.id.login);
        Button Next = findViewById(R.id.next);

         scrollthird = findViewById(R.id.scrolling_third);
         scrollnext = findViewById(R.id.scrolling_sec);



        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollthird.stop();
                scrollnext.start();
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcomeIntent = new Intent(SliderActivity.this,RegisterActivity.class);
                startActivity(welcomeIntent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcomeIntent = new Intent(SliderActivity.this,LoginActivity.class);
                startActivity(welcomeIntent);
            }
        });




    }
}
