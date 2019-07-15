package app.example.voting.voting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText email,password,repass ;
    private Button registerbtn ;

    ProgressDialog progressBar ;

   // public static  String SharedPref = "Users" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repass = findViewById(R.id.repassword);
        registerbtn = findViewById(R.id.registerbtn);

        Button loginedit = findViewById(R.id.logineditbtn);


       progressBar = new ProgressDialog(this);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String emai = email.getText().toString() ;
                String pass = password.getText().toString() ;
                String repassword = repass.getText().toString() ;

              //  Validate(emai,pass,repassword) ;
                Register(emai,pass,repassword);
            }
        });


        loginedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterActivity.this,Login.class);
                startActivity(intent);
            }
        });

    }

    private void Validate(String emai, String pass, String repassword)
    {
        if (TextUtils.isEmpty(emai) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repassword) )
        {
            Toast.makeText(this, "Text Can't be Empty", Toast.LENGTH_SHORT).show();

        }

         if ( ! pass.equals(repassword))
        {
            Toast.makeText(this, "Password dont match", Toast.LENGTH_SHORT).show();
        }
        else {
            Register(emai,pass,repassword) ;
        }
    }

    private void Register(String emai, String pass,String repass)
    {

        Validate(emai,pass,repass);

        progressBar.setMessage("Please wait..");
        progressBar.show();

        SharedPreferences sharedPreferences = getSharedPreferences("Users",MODE_PRIVATE) ;
         SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putString("Email",emai);
          editor.putString("Password",pass);
          editor.putString("CONFIRMPASSORD",repass);

          editor.commit() ;
//
//        Bundle bundle = new Bundle();
//        bundle.putString("Email",emai);
//        bundle.putString("Password",pass);

        Intent intent = new Intent(getApplicationContext(),Login.class);
       //  intent.putExtras(bundle) ;
        startActivity(intent);



    }
}
