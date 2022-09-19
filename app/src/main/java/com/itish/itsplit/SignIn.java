package com.itish.itsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.itish.itsplit.R;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class SignIn extends AppCompatActivity {

    private static int RC_SIGN_IN=100;
    GoogleSignInClient mGoogleSignInClient;
    TextInputEditText SIemail, SIpassword;
    CheckBox SIremember_me;
    MaterialButton signInBtn,signUpGo,signInWithGoogle;
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

        signInBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),DashBoard.class)));
        forget_password.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),ForgetPassword.class)));
        signUpGo.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),SignUp.class)));
        signInWithGoogle.setOnClickListener(view -> Toast.makeText(getApplicationContext(),"sign in with google",Toast.LENGTH_SHORT).show());

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);
        signInWithGoogle.setOnClickListener(view -> signIn());
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            ArrayList<String> W_data=new ArrayList<String>();
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

                W_data.add(personName);
                W_data.add(personGivenName);
                W_data.add(personFamilyName);
                W_data.add(personEmail);
                W_data.add(String.valueOf(personPhoto));
                W_data.add(personId);
                startActivity(new Intent(getApplicationContext(),DashBoard.class).putStringArrayListExtra("W_data", W_data));
            }
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("error","signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }
    }
}