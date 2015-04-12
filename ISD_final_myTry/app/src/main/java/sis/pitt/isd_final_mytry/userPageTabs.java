package sis.pitt.isd_final_mytry;

import android.os.Bundle;
import android.app.TabActivity;
import android.widget.TabHost;
import android.widget.TabHost.*;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.graphics.drawable.*;


public class userPageTabs extends TabActivity {
    Button Tab1Button,Tab2Button,Tab3Button;
    public static String Tab="";
    TabHost tabHost;
    Drawable d1,d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpagetabs);

        ImageButton goHome_userpage = (ImageButton)findViewById(R.id.goHome_userpage);

        goHome_userpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userPageTabs.this,loginPage.class));
                finish();
            }
        });

         d1 = getResources().getDrawable(R.drawable.border_shape);
         d2 = getResources().getDrawable(R.drawable.no_border_shape);

        tabHost = getTabHost();

        Tab1Button=(Button)findViewById(R.id.Tab1Button);
        Tab2Button=(Button)findViewById(R.id.Tab2Button);
        Tab3Button=(Button)findViewById(R.id.Tab3Button);
/*
        Tab1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Tab1Button.setBackgroundDrawable(d1);
                Tab2Button.setBackgroundDrawable(d2);
                Tab3Button.setBackgroundDrawable(d2);
                  //layoutParams = (LayoutParams)Tab1Button.getLayoutParams();
            }
        });
        Tab2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tab1Button.setBackgroundDrawable(d2);
                Tab2Button.setBackgroundDrawable(d1);
                Tab3Button.setBackgroundDrawable(d2);
                //layoutParams = (LayoutParams)Tab1Button.getLayoutParams();
            }
        });
        Tab3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tab1Button.setBackgroundDrawable(d2);
                Tab2Button.setBackgroundDrawable(d2);
                Tab3Button.setBackgroundDrawable(d1);
                //layoutParams = (LayoutParams)Tab1Button.getLayoutParams();
            }
        });
        */
/*
        // Tab for tab1
        TabSpec spec1 = tabHost.newTabSpec("Tab1");
        // setting Title and Icon for the Tab
        spec1.setIndicator("Tab1");
        Intent Intent1 = new Intent(this, Activity1.class);
        spec1.setContent(Intent1);
*/

        //getTabWidget().setOrientation(LinearLayout.VERTICAL);

        // Tab for basic
        TabSpec basicSpec = tabHost.newTabSpec("basic");
        // setting Title and Icon for the Tab
        basicSpec.setIndicator("basic");
        Intent basicIntent = new Intent(this, basic_tab1.class);
        basicSpec.setContent(basicIntent);

        // Tab for account
        TabSpec accountSpec = tabHost.newTabSpec("account");
        accountSpec.setIndicator("account");
        Intent accountIntent = new Intent(this, account_tab2.class);
        accountSpec.setContent(accountIntent);

        // Tab for static
        TabSpec staticsSpec = tabHost.newTabSpec("statics");
        staticsSpec.setIndicator("statics");
        Intent staticsIntent = new Intent(this, statics_tab3.class);
        staticsSpec.setContent(staticsIntent);



        // Adding all TabSpec to TabHost
        tabHost.addTab(basicSpec); // Adding photos tab
        tabHost.addTab(accountSpec); // Adding songs tab
        tabHost.addTab(staticsSpec); // Adding videos tab

    }

    //======================= click Handling for the tab layout buttons=============
    public void tabHandler(View target) {
        if (target.getId() == R.id.Tab1Button) {
            Tab1Button.setBackgroundDrawable(d1);
            Tab2Button.setBackgroundDrawable(d2);
            Tab3Button.setBackgroundDrawable(d2);
            Tab="this is Tab 1";
            tabHost.setCurrentTab(0);

        } else if (target.getId() == R.id.Tab2Button) {
            Tab="this is Tab 2";
            Tab1Button.setBackgroundDrawable(d2);
            Tab2Button.setBackgroundDrawable(d1);
            Tab3Button.setBackgroundDrawable(d2);
            tabHost.setCurrentTab(1);

        } else if (target.getId() == R.id.Tab3Button) {
            Tab = "this is Tab 3";
            Tab1Button.setBackgroundDrawable(d2);
            Tab2Button.setBackgroundDrawable(d2);
            Tab3Button.setBackgroundDrawable(d1);
            tabHost.setCurrentTab(2);
        }
    }
}
