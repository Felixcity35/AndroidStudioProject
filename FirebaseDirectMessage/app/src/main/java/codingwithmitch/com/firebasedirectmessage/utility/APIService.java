package codingwithmitch.com.firebasedirectmessage.utility;

import codingwithmitch.com.firebasedirectmessage.Notifications.MyResponse;
import codingwithmitch.com.firebasedirectmessage.Notifications.Sender;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(

            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAoYyZOMM:APA91bHP2V-Uz9cNCc_L_r6JkcdQ_yT5rJB8DwoENfnmgPeXrJfqpOlDEKxQP0YE3bkO-759pc10URokaBiyGzzJDNeSQfxenO7O61riGrJR-QVWVHw89oYDgnxD7LRFW4lj_1-Pqlww"
            }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
