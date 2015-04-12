package sis.pitt.isd_final_mytry;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class loginPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Button playWithoutLogin = (Button)findViewById(R.id.playwithoutlogin);
        ImageButton goUserPage = (ImageButton)findViewById(R.id.goHome_login);
        Button LoginBtn=(Button)findViewById(R.id.loginbutton);

        playWithoutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this,manu_lang.class));
                finish();
            }
        });
        goUserPage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this,userPageTabs.class));
                finish();
            }
        });
        LoginBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this,scrollview_try.class));
                finish();
            }
        });
    }


}
