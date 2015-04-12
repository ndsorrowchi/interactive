package sis.pitt.isd_final_mytry;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class gamePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        Intent intent = getIntent();
        int questionNo = intent.getIntExtra("questionNo", 0);

        Button return_gamePage=(Button)findViewById(R.id.return_gamePage);
        return_gamePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gamePage.this, scrollview_try.class);
                startActivity(intent);
            }
        });
        WebView gameWebView=(WebView)findViewById(R.id.question);
        //gameWebView.loadUrl("http://www.baidu.com");
        WebSettings webSettings = gameWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // 更强的打开链接控制：自己覆写一个WebViewClient类：除了指定链接从WebView打开，其他的链接默认打开
        gameWebView.setWebViewClient(new MyWebViewClient());

        gameWebView.loadUrl("http://adapt2.sis.pitt.edu/quizjet/quiz1.jsp?rdfID=jSimpleVariableTest&act=Variables&sub=jSimpleVariableTest&svc=progvis&svc=masterygrids");

    }
    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }


}
