package com.itish.itsplit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.itish.itsplit.R;

import java.net.URI;
import java.util.ArrayList;

public class DashBoard extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    TextView email,name,id;
    ImageView pic;
    Button signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        email=findViewById(R.id.email);
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        signout=findViewById(R.id.signout);
        pic=findViewById(R.id.pic);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });


        if (getIntent().hasExtra("W_data")) {
            ArrayList<String> W_data = getIntent().getExtras().getStringArrayList("W_data");
            name.setText( W_data.get(0));
            email.setText(W_data.get(3));
            Log.d("9999",W_data.get(4));
            pic.setImageURI(Uri.parse(W_data.get(4)));
            Glide.with(this).load(W_data.get(4)).into(pic);
//            Log.d("6969696969",W_id);
        }

        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null){
//            String d_name=account.getDisplayName();
//            String d_gname=account.getGivenName();
//            String d_fname=account.getFamilyName();
//            String d_email=account.getEmail();
//            String d_id=account.getId();
//            Uri photo=account.getPhotoUrl();
//            pic.setImageURI(photo);
//            name.setText(d_name);
//            email.setText(d_email);
//            id.setText(d_id);
//            Glide.with(this).load(String.valueOf(photo)).into(pic);
        }


    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                        Toast.makeText(getApplicationContext(),"signout",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
}