package app.hcl.com.schoolmgmt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView imageView;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView=findViewById(R.id.student_regid);

    }

    public void launchRegForm(View view)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.welcome_linerlayout,new PersonalDetailsStudent());
        transaction.addToBackStack("fragment");
        transaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.option1)
        {
            preferences= getSharedPreferences("MyPrefsFile",0);
            Boolean b=preferences.getBoolean("my_login",true);
            Log.d("My_log",""+b.toString());
            preferences.edit().putBoolean("my_login",false).commit();

            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();

        }
        return  true;
    }
}
