package minor.com.homeautomation.homeautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button ON1,ON2,ON3,ON4;
    private Button OFF1,OFF2,OFF3,OFF4;

    private static final String baseUrl = "http://192.168.43.21/LED=";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setClickListeners();
    }

    private void initViews(){
        ON1 = findViewById(R.id.ON1);
        ON2 = findViewById(R.id.ON2);
        ON3 = findViewById(R.id.ON3);
        ON4 = findViewById(R.id.ON4);
        OFF1 = findViewById(R.id.OFF1);
        OFF2 = findViewById(R.id.OFF2);
        OFF3 = findViewById(R.id.OFF3);
        OFF4 = findViewById(R.id.OFF4);
    }

    private void makeRequest(String input){
        Log.i(TAG,"Input is "+baseUrl+input);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, baseUrl + input, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG,response.toString()+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,error.toString()+"");
            }
        });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    private void setClickListeners(){
        ON1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest("ON1");
            }
        });
        ON2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest("ON2");
            }
        });
        ON3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest("ON3");
            }
        });
        ON4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest("ON4");
            }
        });

        OFF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest("OFF1");
            }
        });
        OFF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest("OFF2");
            }
        });
        OFF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest("OFF3");
            }
        });
        OFF4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest("OFF4");
            }
        });

    }

}
