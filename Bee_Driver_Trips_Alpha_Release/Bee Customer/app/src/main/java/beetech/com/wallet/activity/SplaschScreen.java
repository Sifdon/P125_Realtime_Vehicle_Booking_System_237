package beetech.com.wallet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import beetech.com.wallet.CustomerMapActivity;
import beetech.com.wallet.R;
import beetech.com.wallet.ubersplash.MainActivity_App;

/**
 * Created by chichikolon on 07.12.2017.
 */

public class SplaschScreen extends AppCompatActivity{
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splaschscreen);



        handler =  new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplaschScreen.this, CustomerMapActivity.class);
                startActivity(intent);
                finish();

            }
        },6000);


        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
