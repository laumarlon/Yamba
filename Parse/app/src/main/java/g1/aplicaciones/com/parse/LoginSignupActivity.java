package g1.aplicaciones.com.parse;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LoginSignupActivity extends ActionBarActivity {

    Button loginButton;

    Button signupButton;

    String usernametxt;

    String passwordtxt;

    EditText password;

    EditText username;

    @Override

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        loginButton=(Button)findViewById(R.id.login);
        signupButton=(Button)findViewById(R.id.signup);
        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
            usernametxt=username.getText().toString();
            passwordtxt=password.getText().toString();
            ParseUser.logInInBackground(usernametxt, passwordtxt,
            new LogInCallback(){
            @Override
            public void done(ParseUser user,ParseException e) {
                if (user != null) {
                    Intent intent = new Intent(LoginSignupActivity.this, Welcome.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Thisuserdoesn'texist.Pleasesignup", Toast.LENGTH_SHORT).show();
                }
            }
            });
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
        usernametxt=username.getText().toString();
        passwordtxt=password.getText().toString();
        if(usernametxt.equals("")&&passwordtxt.equals("")){
        Toast.makeText(getApplicationContext(),"Pleasecompletethesignupform",Toast.LENGTH_SHORT).show();
        }else{
        ParseUser user=new ParseUser();
        user.setUsername(usernametxt);
        user.setPassword(passwordtxt);
        user.signUpInBackground(new SignUpCallback(){

        @Override
        public void done(ParseException e) {
            if (e == null) {
                Toast.makeText(getApplicationContext(), "SuccessfullySignedup!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Signuperror", Toast.LENGTH_SHORT).show();
            }
        }
        });
        }
        }
        });
        }
    }
