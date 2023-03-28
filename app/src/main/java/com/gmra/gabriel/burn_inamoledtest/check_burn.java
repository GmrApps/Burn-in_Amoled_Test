package com.gmra.gabriel.burn_inamoledtest;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class check_burn extends AppCompatActivity {




    Button button;

    int color=1;

    String TAG;
    InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        MobileAds.initialize(this, initializationStatus -> {});

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-3246150512157335/9700017541", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.i(TAG, "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.i(TAG, loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_check_burn);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = 1.0f;
        getWindow().setAttributes(params);






        button = findViewById(R.id.next);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch(color)
                {
                    case 1:
                        button.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                        color=2;
                        button.setText("9");
                        textViewCounter();


                        break;
                    case 2:
                        button.setBackgroundColor(getResources().getColor(R.color.blue));
                        color=3;
                        button.setText("8");
                        textViewCounter();
                        break;
                    case 3:
                        button.setText("7");
                        textViewCounter();
                        button.setBackgroundColor(getResources().getColor(R.color.green));
                        color=4;
                        break;

                    case 4:
                        button.setText("6");
                        textViewCounter();
                        button.setBackgroundColor(getResources().getColor(R.color.teal_700));
                        color=5;
                        break;

                    case 5:
                        button.setText("5");
                        textViewCounter();
                        button.setBackgroundColor(getResources().getColor(R.color.yellow));
                        color=6;
                        break;

                    case 6:
                        button.setText("4");
                        textViewCounter();
                        button.setBackgroundColor(getResources().getColor(R.color.orange));
                        color=7;
                        break;
                    case 7:
                        button.setText("3");
                        textViewCounter();
                        button.setBackgroundColor(getResources().getColor(R.color.purple));
                        color=8;
                        break;
                    case 8:
                        button.setText("2");
                        textViewCounter();
                        button.setBackgroundColor(getResources().getColor(R.color.gray));
                        color=9;
                        break;

                    case 9:
                        button.setText("1");
                        textViewCounter();
                        button.setBackgroundColor(getResources().getColor(R.color.pink));

                        color=10;
                        break;

                    case 10:

                        Toast.makeText(check_burn.this, "Test Completed", Toast.LENGTH_SHORT).show();
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(check_burn.this);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        }

                        finish();
                        break;

                }

            }
        });
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }else{
            showSystemUI();
        }
    }

    @SuppressLint("InlinedApi")
    private void hideSystemUI() {

        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }


    private void textViewCounter(){
        new Handler().postDelayed(() -> button.setText(""), 500);
    }

}

