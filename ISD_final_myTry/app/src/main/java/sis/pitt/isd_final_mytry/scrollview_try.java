package sis.pitt.isd_final_mytry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class scrollview_try extends Activity {
    LinearLayout linearLayout;
    LinearLayout linearLinframe;
    TextView textView, textView2;
    LayoutParams textViewLp,textView2Lp, frameLayoutLp,linearInFrameLp;

    Button button;
    FrameLayout frameLayout;
    LayoutParams lp;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_try);

        ImageButton goHome = (ImageButton)findViewById(R.id.goHome_scrol);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scrollview_try.this, loginPage.class);                // 启动Intent
                startActivity(intent);
            }
        });
        ImageButton goUser = (ImageButton)findViewById(R.id.goUSer_scrol);
        goUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scrollview_try.this, userPageTabs.class);                // 启动Intent
                startActivity(intent);
            }
        });
        linearLayout = (LinearLayout) findViewById(R.id.linear_in_scroll);

        for (int i = 0; i < 22; i++) {
            //  通过资源文件来获得指定一个Drawable对象
            /*
            Drawable drawable = getResources().getDrawable(R.drawable.adapt2_logo);
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(drawable);
            layout.addView(imageView);*/
////////////////////////////
            frameLayout = new FrameLayout(this);
            linearLinframe = new LinearLayout(this);
            linearLinframe.setOrientation(LinearLayout.VERTICAL);

            textView = new TextView(this);
            textView.setText("Section" + i);
            textView.setGravity(Gravity.CENTER);




            textView2 = new TextView(this);
            textView2.setText("0%");
            textView2.setPadding(0,0,0,0);
            textView2.setGravity(Gravity.CENTER_HORIZONTAL);
            textView2.setGravity(Gravity.BOTTOM);

            //LayoutParams textView2Lp = textView.getLayoutParams();

            linearLinframe.addView(textView);
            linearLinframe.addView(textView2);

            textViewLp = textView.getLayoutParams();

            textViewLp.width = LayoutParams.MATCH_PARENT;
            textViewLp.height = LayoutParams.WRAP_CONTENT;

            textView2Lp = textView2.getLayoutParams();
            textView2Lp.width=LayoutParams.MATCH_PARENT;
            textView2Lp.height = LayoutParams.WRAP_CONTENT;


            frameLayout.addView(linearLinframe);
            linearInFrameLp = linearLinframe.getLayoutParams();
            linearInFrameLp.width = LayoutParams.MATCH_PARENT;
            linearInFrameLp.height = LayoutParams.MATCH_PARENT;
//////////////////////////////////

            button = new Button(this);
            button.setTag(i);
            // button.setText(i+"");
            button.setBackgroundColor(0x30000000);
            button.setId(i);
            button.setOnClickListener(new sectionBtnListioner(i));
            frameLayout.addView(button);
            //button.getLayoutParams();
            lp = button.getLayoutParams();
            lp.height = LayoutParams.MATCH_PARENT;
            lp.width = LayoutParams.WRAP_CONTENT;


            linearLayout.addView(frameLayout);

            frameLayoutLp = frameLayout.getLayoutParams();
            frameLayoutLp.height = LayoutParams.MATCH_PARENT;
            frameLayoutLp.width = LayoutParams.MATCH_PARENT;

        }
    }

    public class sectionBtnListioner implements View.OnClickListener {
        int sectionNo;

        sectionBtnListioner(int sectionNo) {
            this.sectionNo = sectionNo;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(scrollview_try.this, sub_manu.class);
            // 在Intent中传递数据
            intent.putExtra("secNo", sectionNo);
            // 启动Intent
            startActivity(intent);
        }
    }

}