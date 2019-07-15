package app.example.voting.voting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.example.voting.voting.Model.Users;

public class Login extends AppCompatActivity {


    ProgressDialog dialog ;

    ArrayList<Users> listUsers ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dialog = new ProgressDialog(this);

        ListView listView = findViewById(R.id.list_item);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       //   getSupportActionBar().setTitle("login");

        listUsers = new ArrayList<Users>();

        listUsers.add(new Users(R.mipmap.ic_launcher_round,"08178199999","FelixArchibong@gmail.com") );
        listUsers.add(new Users(R.mipmap.ic_launcher_round,"08178199999","FelixArchibong@gmail.com") );
        listUsers.add(new Users(R.mipmap.ic_launcher_round,"08178199999","FelixArchibong@gmail.com") );
        listUsers.add(new Users(R.mipmap.ic_launcher_round,"08178199999","FelixArchibong@gmail.com") );
        listUsers.add(new Users(R.mipmap.ic_launcher,"08178199999","FelixArchibong@gmail.com") );
        listUsers.add(new Users(R.mipmap.ic_launcher_round,"08178199999","FelixArchibong@gmail.com") );
        listUsers.add(new Users(R.mipmap.ic_launcher_round,"08178199999","FelixArchibong@gmail.com") );
        listUsers.add(new Users(R.mipmap.ic_launcher,"08178199999","FelixArchibong@gmail.com") );


        addUserAdapter userAdapter = new addUserAdapter(this,0,listUsers);
        listView.setAdapter(userAdapter);

    }

    public class addUserAdapter  extends ArrayAdapter<Users> {

        private Context mContext ;
        private ArrayList<Users> mUsers = new ArrayList<>();    // don't define it and test.

        public addUserAdapter(@NonNull Context context, int resource,ArrayList<Users> users) {
            super(context, resource,users);

            this.mContext = context ;
            this.mUsers = users ;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            View userList = convertView ;

            if (userList == null)
            {
                userList = LayoutInflater.from(mContext).inflate(R.layout.listlayout,parent,false);   // change to true.

                Users currentUsers = mUsers.get(position) ;

                ImageView myImage = userList.findViewById(R.id.image);

                myImage.setImageResource(currentUsers.getImage());

                TextView myEmail = userList.findViewById(R.id.email);

                myEmail.setText(currentUsers.getEmail());


                TextView myPass = userList.findViewById(R.id.phoneNum);
                myPass.setText(currentUsers.getPhone());

            }


            return  userList ;

        }
    }
}
