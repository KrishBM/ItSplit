package com.itish.itsplit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.itish.itsplit.R;
import com.google.android.material.button.MaterialButton;

public class IntroductorySrn extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    MaterialButton introButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory_srn);

//        PrefManager prefManager = new PrefManager(getApplicationContext());
//        if(!prefManager.isFirstTimeLaunch()){
//            startActivity(new Intent(getApplicationContext(), SignUp.class));  //TODO:after completion this line comment out
//        }
        introButton=findViewById(R.id.introButton);
        viewPager = findViewById(R.id.viewpager);

        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new IntroFragment1(), "Page 1");
        viewPagerAdapter.add(new IntroFragment2(), "Page 2");
        viewPagerAdapter.add(new IntroFragment3(), "Page 3");

        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
//        tabLayout = findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);

        introButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()==0){
                    viewPager.setCurrentItem(1);
                    introButton.setText("Next");
                }else if (viewPager.getCurrentItem()==1){
                    introButton.setText("Get Started");
                    viewPager.setCurrentItem(2);
                }else {
                    startActivity(new Intent(IntroductorySrn.this, SignUp.class));
                    finish();
                }
//                startActivity(new Intent(IntroScreen1.this, IntroScreen2.class));
//                overridePendingTransition(R.anim.right_side_in,R.anim.left_side_out);
            }
        });
    }
}