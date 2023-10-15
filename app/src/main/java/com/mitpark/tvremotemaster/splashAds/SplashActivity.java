package com.mitpark.tvremotemaster.splashAds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

import com.mitpark.tvremotemaster.R;
import com.mitpark.tvremotemaster.RemoteSelectActivity;
import com.mitpark.tvremotemaster.ads.MyApplication;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    String var;
    VideoView videoView;

    private AppOpenAd.AppOpenAdLoadCallback loadCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // FOR VIDEO ADD (JONI)

// Previous implementation
     /*   videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {

            }
        });

        videoView.start();*/

        Button btn = findViewById(R.id.btnStart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goNext();
            }
        });

        // New implementation





        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.black));
        }


        MyApplication.setuser_balance(0);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                OpenAppAds();
            }
        }, 5000);


    }


    public void OpenAppAds() {
        try {

            if (MyApplication.getuser_balance() == 0) {

                String app_open_ads_id = MyApplication.App_Open;

                loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                        super.onAdLoaded(appOpenAd);

                        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                               // goNext();
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                             //   goNext();
                            }
                        };
                        appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        appOpenAd.show(SplashActivity.this);

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                       // goNext();
                    }
                };

                AppOpenAd.load((Context) this, app_open_ads_id, new AdRequest.Builder().build(), 1, this.loadCallback);

            } else {

               // goNext();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goNext() {
        loadOpenApp();
    }

    private void loadOpenApp() {
        if (MyApplication.getuser_onetime() == 0) {
            Intent i = new Intent(SplashActivity.this, PrivacyTermsActivity.class);
            startActivity(i);
        }else {
            Intent i = new Intent(SplashActivity.this, FirstPageMainActivity.class);
           // Intent i = new Intent(SplashActivity.this, RemoteSelectActivity.class);
            startActivity(i);
        }
    }


}
