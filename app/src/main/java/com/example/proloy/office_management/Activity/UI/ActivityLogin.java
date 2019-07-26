package com.example.proloy.office_management.Activity.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proloy.office_management.Activity.Model.Notice;
import com.example.proloy.office_management.Activity.util.LoginResponse;
import com.example.proloy.office_management.R;

/**
 * Created by Proloy on 4/11/2017.
 */
public class ActivityLogin extends AppCompatActivity implements LoginResponse{

    private EditText etUsername ;
    private EditText etPassword ;
    private Button btnSignUp ;
    LoginResponse loginResponse = this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration.Builder config = new Configuration.Builder(this);
        config.addModelClasses(Notice.class);
        ActiveAndroid.initialize(config.create());
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.et_login_name);
        etPassword = (EditText)findViewById(R.id.et_login_password);
    //    btnSignUp = (Button)findViewById(R.id.btn_sign_up);

        findViewById(R.id.btn_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNotEmpty(etUsername)&& isNotEmpty(etPassword))
                {
                    loginRequest(etUsername.getText().toString(),
                            etPassword.getText().toString());
                }
                else
                {
                    Toast.makeText(ActivityLogin.this,"Please Provide The Full Information",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void loginRequest(String userName , String password)
    {
        String url = "http://rabbitshat.com/apto/api/UserAuthorizationsAPI?aid=" + userName + "&" + "code=" + password;
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("An error has occurred.")){
                            loginResponse.onFailure(response);
                        }
                        else {
                            loginResponse.onSuccess(response);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loginResponse.onFailure(error.toString());
            }
        });

        RequestQueue rq = Volley.newRequestQueue(ActivityLogin.this);
        rq.add(sr);
    }

    private boolean isNotEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }

    @Override
    public void onSuccess(String response) {


        Toast.makeText(ActivityLogin.this, "Successfully login as " + response, Toast.LENGTH_SHORT).show();

        // save login stat
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        //  successfulDialog();
        finish();

    }

    @Override
    public void onFailure(String response) {

        Toast.makeText(ActivityLogin.this, response, Toast.LENGTH_SHORT).show();
    }
}
