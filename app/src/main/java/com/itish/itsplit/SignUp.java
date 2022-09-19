package com.itish.itsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.itish.itsplit.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {

    private PrefManager prefManager;
    TextInputEditText SUname, SUemail, SUpassword;
    CheckBox SUremember_me;
    MaterialButton signUpWithGoogle,signUpBtn,signInGo;
    ImageButton password_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SUname =findViewById(R.id.SUname);
        SUemail =findViewById(R.id.SUemail);
        SUpassword =findViewById(R.id.SUpassword);
        SUremember_me =findViewById(R.id.SUremember_me);
        signInGo=findViewById(R.id.signInGo);
        signUpBtn=findViewById(R.id.signUpBtn);
        signUpWithGoogle =findViewById(R.id.signUpWithGoogle);
        password_info=findViewById(R.id.password_info);

        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            prefManager.setFirstTimeLaunch(false);
        }

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashBoard.class));
            }
        });
        password_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"password info",Toast.LENGTH_SHORT).show();
            }
        });
        signInGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignIn.class));
            }
        });
        signUpWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"sign in with google",Toast.LENGTH_SHORT).show();
            }
        });
    }
}