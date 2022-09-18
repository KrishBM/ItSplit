package com.example.itsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.itsplit.R;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignIn extends AppCompatActivity {

    TextInputEditText SIemail, SIpassword;
    CheckBox SIremember_me;
    MaterialButton signInWithGoogle,signInBtn,signUpGo;
    Button forget_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        SIemail =findViewById(R.id.SIemail);
        SIpassword =findViewById(R.id.SIpassword);
        SIremember_me =findViewById(R.id.SIremember_me);
        signUpGo=findViewById(R.id.signUpGo);
        signInBtn=findViewById(R.id.signInBtn);
        signInWithGoogle =findViewById(R.id.signInWithGoogle);
        forget_password=findViewById(R.id.forget_password);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashBoard.class));
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ForgetPassword.class));
            }
        });
        signUpGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });
        signInWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"sign in with google",Toast.LENGTH_SHORT).show();
            }
        });
    }
}