package com.example.menuuestcweb;


import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class AppStart extends Activity {
	
    private MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = View.inflate(this, R.layout.start, null);
        setContentView(view);
        
        //渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.3f,1.0f);
        aa.setDuration(2000);
        view.startAnimation(aa);
        
        
        mediaPlayer.create(this, R.raw.psp).start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
        aa.setAnimationListener(new AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation arg0) {
                redirectTo();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationStart(Animation animation) {}
             
        });
         
//        //兼容低版本cookie（1.5版本以下，包括1.5.0,1.5.1）
//        AppContext appContext = (AppContext)getApplication();
//        String cookie = appContext.getProperty("cookie");
//        if(StringUtils.isEmpty(cookie)) {
//            String cookie_name = appContext.getProperty("cookie_name");
//            String cookie_value = appContext.getProperty("cookie_value");
//            if(!StringUtils.isEmpty(cookie_name) && !StringUtils.isEmpty(cookie_value)) {
//                cookie = cookie_name + "=" + cookie_value;
//                appContext.setProperty("cookie", cookie);
//                appContext.removeProperty("cookie_domain","cookie_name","cookie_value","cookie_version","cookie_path");
//            }
//        }
    }
//    private void music() {
////    	this.context=context;
//  
//    		mediaPlayer.create(this, R.raw.psp);
////    		mediaPlayer.prepare();
//    		mediaPlayer.start();
//    }
    /**
     * 跳转到...
     */
    private void redirectTo(){   

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
