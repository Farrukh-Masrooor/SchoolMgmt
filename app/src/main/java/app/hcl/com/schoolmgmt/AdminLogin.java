package app.hcl.com.schoolmgmt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AdminLogin extends Fragment implements View.OnClickListener{

    EditText adminId,adminPAssword;
    Button loginbutton;
    private SharedPreferences settings;
    String weburl= "https://192.168.225.38/connection/adminLogin.php";;
    private String mail="";
    private String pass="";
    String regex ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.admin_login,container,false);
        adminId=view.findViewById(R.id.adminId);
        adminPAssword=view.findViewById(R.id.adminPassword);
        loginbutton=view.findViewById(R.id.adminLoginButton);
        loginbutton.setOnClickListener(this);
        settings = getContext().getSharedPreferences("MyPrefsFile", 0);
        return view;
    }


    public void getData()
    {


        mail=adminId.getText().toString();


        pass=adminPAssword.getText().toString();


        if ( pass.equals("") || mail.equals("") ) {
            Toast.makeText(getContext(), "Fields are Empty", Toast.LENGTH_SHORT).show();
        }
        else if (!mail.trim().matches(regex))
        {
            Toast.makeText(getContext(),"invalid email format",Toast.LENGTH_SHORT).show();
            adminId.setText("");

        }
        else
            // new Connect().execute();
            callVolley();


    }

    public void callVolley()
    {

        RequestQueue queue = Volley.newRequestQueue(getContext());

        Log.d("My_log","inside volley");
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST,weburl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the response string.
                        Log.d("My_log",response);
                        if (response.trim().equals("1"))
                        {
                            launchnewActivity();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("My_log","err  "+error);
            }
        }) {
            //adding parameters to the request
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("admin_mail", mail);
                params.put("admin_password", pass);
                return params;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        InputMethodManager inputManager = (InputMethodManager)
                getActivity(). getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(adminId.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        ConnectivityManager cm =
                (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected==true)
            getData();
        else
            Toast.makeText(getActivity(),"no internet",Toast.LENGTH_SHORT).show();
    }

    public void launchnewActivity()
    {

        settings.edit().putBoolean("my_login", true).commit();
        Intent intent = new Intent(getContext(), WelcomeActivity.class);
        //intent.putExtra("user_id",key);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
        getActivity().finish();
    }
}
