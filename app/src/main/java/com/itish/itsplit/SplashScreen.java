package com.itish.itsplit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.itish.itsplit.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.
        setContentView(R.layout.activity_splash_screen);
        PrefManager prefManager = new PrefManager(getApplicationContext());




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(prefManager.isFirstTimeLaunch()){
                    prefManager.setFirstTimeLaunch(false);
                    startActivity(new Intent(SplashScreen.this,IntroductorySrn.class));
                    finish();
                }
                else{
                    startActivity(new Intent(SplashScreen.this,SignUp.class));
                    finish();
                }
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}