package sis.pitt.isd_final_mytry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class manu_lang extends Activity {

    private ViewPager mViewPager;
    List<View> viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manu_lang_main);

        LayoutInflater mInflater = getLayoutInflater().from(this);

        View v1 = mInflater.inflate(R.layout.activity_manupage1, null);
        View v2 = mInflater.inflate(R.layout.activity_manupage2, null);
        View v3 = mInflater.inflate(R.layout.activity_manupage3, null);

        //添加页面数据
        viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        //实例化适配器
        mViewPager = (ViewPager) findViewById(R.id.vpPager);
        mViewPager.setAdapter(new MyViewPagerAdapter(viewList));
        mViewPager.setCurrentItem(0); //设置默认当前页


        ImageButton imageButton = (ImageButton) v1.findViewById(R.id.imageButton);

        /*

        LinearLayout mLinearLayout = (LinearLayout) mInflater.inflate(R.layout.activity_manupage1,
                container, false);

        // note that we're looking for a button with id="@+id/myButton" in your inflated layout
        // Naturally, this can be any View; it doesn't have to be a button
        Button mButton = (Button) mLinearLayout.findViewById(R.id.myButton);

        ImageButton imageButton=(ImageButton)findViewById(R.id.imageButton);*/
        imageButton.setOnClickListener(new sectionBtnListioner(1));



    }

    public class sectionBtnListioner implements View.OnClickListener {
        int sectionNo;

        sectionBtnListioner(int sectionNo) {
            this.sectionNo = sectionNo;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(manu_lang.this, sub_manu.class);
            // 在Intent中传递数据
            intent.putExtra("secNo", sectionNo);
            // 启动Intent
            startActivity(intent);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter{
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)   {
            container.removeView(mListViews.get(position));//删除页卡
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {  //这个方法用来实例化页卡
            container.addView(mListViews.get(position), 0);//添加页卡
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;//官方提示这样写
        }
    }

}