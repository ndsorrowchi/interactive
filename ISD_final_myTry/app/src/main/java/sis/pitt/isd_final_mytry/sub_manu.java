package sis.pitt.isd_final_mytry;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class sub_manu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_manu);

        Intent intent = getIntent();
        int secNo = intent.getIntExtra("secNo", 0);

        Button goInGame1 = (Button)findViewById(R.id.button1_sub_s);
        goInGame1.setOnClickListener(new qusetionBtnListioner(1));
        goInGame1.setText(secNo+"");

        Button return_subManu=(Button)findViewById(R.id.button12_sub_s);
        return_subManu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sub_manu.this, scrollview_try.class);
                startActivity(intent);
            }
        });
    }
    public class qusetionBtnListioner implements View.OnClickListener{
        int questionNo;
        qusetionBtnListioner(int sectionNo){
            this.questionNo=sectionNo;
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(sub_manu.this, gamePage.class);
            // 在Intent中传递数据
            intent.putExtra("questionNo", questionNo);
            // 启动Intent
            startActivity(intent);
        }
    }


}
