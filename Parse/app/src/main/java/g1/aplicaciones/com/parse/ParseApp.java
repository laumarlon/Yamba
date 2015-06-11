package g1.aplicaciones.com.parse;


import android.app.Application;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by PINEDA on 10/06/2015.
 */
public class ParseApp extends Application {

@Override
public void onCreate(){
       super.onCreate();
        Parse.initialize(this,"kxIzF0P1IyzgmH7TE5nB8IR8y8L3W0U2hI38GD46","vpgz9b9WSe1VPFYDU7ts8AkIEBIJ69okXbjpaCcO");
        ParseUser.enableAutomaticUser();
        ParseACL defauAcl=new ParseACL();
        defauAcl.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defauAcl,true);
        }
   }

