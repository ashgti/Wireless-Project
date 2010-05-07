package edu.auburn.csse.comp3710;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AuburnTriviaSplash extends Activity {
	protected boolean _active = true;
	protected int _splashTime = 5000; // time to display the splash screen in ms
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
                
        // thread for displaying the SplashScreen
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
            		finish();
                }
            }
        };
        splashTread.start();
    }
	
	public void clicked(View theView) {
	    _active = false;
	}
}
