package sis.pitt.isd_final_mytry;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;


public class startPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(startPage.this,loginPage.class));
                finish();
            }
        }, 3000);//这里停留时间为1000=1s。
    }
}
