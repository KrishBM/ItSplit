package com.itish.itsplit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itish.itsplit.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ForgetPassword extends AppCompatActivity {

    TextInputEditText FGemail;
    MaterialButton sendForgetEmail,submitOTP,otp_resend;
    TextView emailView;
    Button change_email;
    LinearLayout FG_linearLayout,FG_otp;
    EditText otp_t1,otp_t2,otp_t3,otp_t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        FGemail=findViewById(R.id.FGemail);
        otp_t1=findViewById(R.id.otp_t1);
        otp_t2=findViewById(R.id.otp_t2);
        otp_t3=findViewById(R.id.otp_t3);
        otp_t4=findViewById(R.id.otp_t4);
        sendForgetEmail=findViewById(R.id.sendForgetEmail);
        submitOTP=findViewById(R.id.submitOTP);
        otp_resend=findViewById(R.id.otp_resend);
        emailView=findViewById(R.id.emailView);
        change_email=findViewById(R.id.change_email);
        FG_linearLayout=findViewById(R.id.FG_linearLayout);
        FG_otp=findViewById(R.id.FG_otp);

        FG_linearLayout.setVisibility(View.VISIBLE);
        FG_otp.setVisibility(View.GONE);

        setupOTPInputs();

        FGemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(Patterns.EMAIL_ADDRESS.matcher(FGemail.getText().toString()).matches()){
                    sendForgetEmail.setEnabled(true);
                }
                else{
                    sendForgetEmail.setEnabled(false);
                    FGemail.setError("Invalid EmailAddress");
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        sendForgetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FGemail.getText().toString().trim().isEmpty()){
                    FGemail.setError("Empty EmailAddress");
                }
                if(!FGemail.getText().toString().trim().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(FGemail.getText().toString()).matches()){
                    FG_linearLayout.setVisibility(View.GONE);
                    FG_otp.setVisibility(View.VISIBLE);
                    emailView.setText(FGemail.getText());
                    otp_t1.requestFocus();
                }
            }
        });

        change_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FG_linearLayout.setVisibility(View.VISIBLE);
                FG_otp.setVisibility(View.GONE);
                FGemail.setText(emailView.getText());
                FGemail.requestFocus();
            }
        });

        otp_t1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                otp_t1.setBackgroundResource(R.drawable.otp_yellow);
                if(!otp_t1.hasFocus()){
                    otp_t1.setBackgroundResource(R.drawable.otp_white);
                }
            }
        });
        otp_t2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                otp_t2.setBackgroundResource(R.drawable.otp_yellow);
                if(!otp_t2.hasFocus()){
                    otp_t2.setBackgroundResource(R.drawable.otp_white);
                }
            }
        });
        otp_t3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                otp_t3.setBackgroundResource(R.drawable.otp_yellow);
                if(!otp_t3.hasFocus()){
                    otp_t3.setBackgroundResource(R.drawable.otp_white);
                }
            }
        });
        otp_t4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                otp_t4.setBackgroundResource(R.drawable.otp_yellow);
                if(!otp_t4.hasFocus()){
                    otp_t4.setBackgroundResource(R.drawable.otp_white);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        if(FG_otp.getVisibility()==View.VISIBLE){
                FG_linearLayout.setVisibility(View.VISIBLE);
                FG_otp.setVisibility(View.GONE);
        }
        else{
            super.onBackPressed();
        }
    }
    private void setupOTPInputs(){
        otp_t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    otp_t2.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        otp_t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    otp_t3.requestFocus();
                }else{
                    otp_t1.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        otp_t3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    otp_t4.requestFocus();
                }
                else{
                    otp_t2.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        otp_t4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().isEmpty()){
                    otp_t3.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
