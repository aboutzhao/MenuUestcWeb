package com.example.menuuestcweb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private WebView webView; 
    private TextView textView;
   
//    public static final int UPDATE_COLLEAGE01=1;
//    private Handler handler=new Handler(){
//    	public void handleMessager(Message msg){
//    		switch(msg.what){
//    		case UPDATE_COLLEAGE01:
//    			textView.setText("电工");
//    			break;
//    			default:
//    				break;
//    		}
//    	}
//    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        webView=(WebView)findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
        	public boolean shoulderOverrideUrlLoading(WebView view,String url){
        		view.loadUrl(url);
        		return true;
        	}
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       switch(item.getItemId()){
       case R.id.tong_yuan:
    	   webView.loadUrl("http://www.scie.uestc.edu.cn/");
    	   textView.setText("通院");
    	   break;
       case R.id.dian_gong:
//    	   new Thread(new Runnable(){
//    		   @Override
//    		   public void run(){
//    		    Message message=new Message();
//    		    message.what=UPDATE_COLLEAGE01;
//    		    handler.sendMessage(message);
//    		   webView.loadUrl("http://www.ee.uestc.edu.cn/");   
//    	   }
//    	   }).start();
    	   textView.setText("电工");
    	   webView.loadUrl("http://www.ee.uestc.edu.cn/"); 
    	   break;
       case R.id.wei_gu:
    	   textView.setText("微固");
    	   webView.loadUrl("http://www.me.uestc.edu.cn/");
    	   break;
       case R.id.guang_dian:
    	   textView.setText("光电");

    	   webView.loadUrl("http://www.soei.uestc.edu.cn/");
    	   
    	   break;
       case R.id.bai_du:
    	   webView.loadUrl("http://www.baidu.com");
    	   textView.setText("baidu");
    	   break;
       }
       return true;
       }
}
