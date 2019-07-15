package codingwithmitch.com.firebasedirectmessage.utility;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import codingwithmitch.com.firebasedirectmessage.Notifications.Client;
import codingwithmitch.com.firebasedirectmessage.Notifications.Data;
import codingwithmitch.com.firebasedirectmessage.Notifications.MyResponse;
import codingwithmitch.com.firebasedirectmessage.Notifications.Sender;
import codingwithmitch.com.firebasedirectmessage.Notifications.Token;
import codingwithmitch.com.firebasedirectmessage.R;
import codingwithmitch.com.firebasedirectmessage.RegisterActivity;
import codingwithmitch.com.firebasedirectmessage.UserListActivity;
import codingwithmitch.com.firebasedirectmessage.models.Message;
import codingwithmitch.com.firebasedirectmessage.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 11/11/2017.
 */

public class MessageDialog extends DialogFragment {

    private static final String TAG = "MessageDialog";

    //create a new bundle and set the arguments to avoid a null pointer
    public MessageDialog(){
        super();
        setArguments(new Bundle());
    }


    //widgets
    EditText mMessage;

    //vars
    private String mUserId;

    FirebaseUser firebaseUser ;

    Boolean notify = false ;

    APIService apiService ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started.");
        mUserId = getArguments().getString(getString(R.string.intent_user_id));
        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService.class);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_message, container, false);
        mMessage = (EditText) view.findViewById(R.id.message);


        Button send = (Button) view.findViewById(R.id.send);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: sending a new message");

              //  DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                     notify = true;
                      String msg = mMessage.getText().toString();

                if(!msg.equals("")){

                    SendMessage(firebaseUser.getUid(),mUserId,msg);

                    getDialog().dismiss();            //REMOVE THE GETDILOG AND TAKE IT DOWNWARD...
                    Toast.makeText(getActivity(), "message sent", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "message cant be empty..", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }

    private void SendMessage(String uid, final String mUserId, String msg)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        //create the new message
        Message message = new Message();
        message.setUser_id(uid);
        message.setMessage(msg);
        message.setTimestamp(getTimestamp());

        //insert the new message
        reference
                .child(getString(R.string.dbnode_messages))
                .child(mUserId)
                .child(reference.push().getKey())
                .setValue(message);

        final String MessagePara = msg ;

        reference = FirebaseDatabase.getInstance().getReference("User").child(firebaseUser.getUid());
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User users = dataSnapshot.getValue(User.class);
//                    String username = users.getName();
                  //  String username = "okon";
                    if (notify) {
                        sendNotification(mUserId, users.getUser_id(), MessagePara ) ;
                    }
                    notify = false ;
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

    }

    private void sendNotification(final String mUserId, final String username, final String message)
    {

        DatabaseReference tokens = FirebaseDatabase.getInstance().getReference("Tokens");
        Query query = tokens.orderByKey().equalTo(mUserId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot :dataSnapshot.getChildren())
                {
                    Token token = snapshot.getValue(Token.class);
                    Data data = new Data(firebaseUser.getUid(),R.mipmap.ic_launcher,username+": "+message,"New Message",mUserId);

                    Sender sender = new Sender(data,token.getToken());

                    apiService.sendNotification(sender)
                            .enqueue(new Callback<MyResponse>() {
                                @Override
                                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                                    if (response.code() == 200 ){
                                        if (response.body().success != 1)
                                        {
                                            getExitTransition();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<MyResponse> call, Throwable t) {

                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("Canada/Pacific"));
        return sdf.format(new Date());
    }


}












