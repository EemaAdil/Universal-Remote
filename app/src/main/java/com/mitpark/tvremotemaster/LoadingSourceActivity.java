package com.mitpark.tvremotemaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.app.adprogressbarlib.AdCircleProgress;
import com.facebook.ads.NativeAdLayout;
import com.marcoscg.dialogsheet.DialogSheet;
import com.mitpark.tvremotemaster.ads.AdsCommon;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingSourceActivity extends AppCompatActivity {

    AdCircleProgress adCircleProgress;
    ImageView bottom_close;
    ImageView bottom_done;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    LinearLayout files_layout;
    int i = 0;
    LinearLayout layout_mute;
    LinearLayout layout_start;
    LinearLayout layout_volume;
    LinearLayout loader_layout;
    String remoteName;
    DialogSheet sourceBottomDialog;
    ImageView source_mute;
    TextView source_mute_counter;
    ImageView source_mute_left;
    ImageView source_mute_right;
    ImageView source_start;
    TextView source_start_counter;
    ImageView source_start_left;
    ImageView source_start_right;
    ImageView source_volume;
    TextView source_volume_counter;
    ImageView source_volume_left;
    ImageView source_volume_right;

    @SuppressLint("WrongConstant")
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_loading_source);


        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer);


        //Reguler Native Ads
        FrameLayout admob_native_frame = (FrameLayout) findViewById(R.id.Admob_Native_Frame);
        NativeAdLayout nativeAdLayout = (NativeAdLayout) findViewById(R.id.native_ad_container);
        FrameLayout maxNative = (FrameLayout) findViewById(R.id.max_native_ad_layout);
        AdsCommon.RegulerBigNative(this, admob_native_frame, nativeAdLayout, maxNative);


        if (bundle == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                this.remoteName = null;
            } else {
                this.remoteName = extras.getString("remote_name");
            }
        } else {
            this.remoteName = (String) bundle.getSerializable("remote_name");
        }
        findViewById(R.id.backpress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingSourceActivity.this.onBackPressed();
            }
        });
        RemoteMakingModule();
        this.adCircleProgress = (AdCircleProgress) findViewById(R.id.adCircleProgress);
        this.loader_layout = (LinearLayout) findViewById(R.id.loader_layout);
        this.files_layout = (LinearLayout) findViewById(R.id.files_layout);
        this.loader_layout.setVisibility(0);
        this.files_layout.setVisibility(8);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LoadingSourceActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LoadingSourceActivity.this.adCircleProgress.setAdProgress(LoadingSourceActivity.this.i);
                        LoadingSourceActivity.this.i++;
                        LoadingSourceActivity.this.adCircleProgress.setMax(100);
                        if (LoadingSourceActivity.this.i == 100) {
                            LoadingSourceActivity.this.loader_layout.setVisibility(8);
                            LoadingSourceActivity.this.files_layout.setVisibility(0);
                        }
                    }
                });
            }
        }, 0, 70);
    }

    @SuppressLint("WrongConstant")
    private void RemoteMakingModule() {
        DialogSheet dialogSheet = new DialogSheet(LoadingSourceActivity.this);
        this.sourceBottomDialog = dialogSheet;
        dialogSheet.setView((int) R.layout.source_bottom_dialog);
        View inflatedView = this.sourceBottomDialog.getInflatedView();
        this.layout_start = (LinearLayout) findViewById(R.id.layout_start);
        this.layout_volume = (LinearLayout) findViewById(R.id.layout_volume);
        this.layout_mute = (LinearLayout) findViewById(R.id.layout_mute);
        this.source_start = (ImageView) findViewById(R.id.source_start);
        this.source_volume = (ImageView) findViewById(R.id.source_volume);
        this.source_mute = (ImageView) findViewById(R.id.source_mute);
        this.source_start_left = (ImageView) findViewById(R.id.source_start_left);
        this.source_start_right = (ImageView) findViewById(R.id.source_start_right);
        this.source_volume_left = (ImageView) findViewById(R.id.source_volume_left);
        this.source_volume_right = (ImageView) findViewById(R.id.source_volume_right);
        this.source_mute_left = (ImageView) findViewById(R.id.source_mute_left);
        this.source_mute_right = (ImageView) findViewById(R.id.source_mute_right);
        this.source_start_counter = (TextView) findViewById(R.id.source_start_counter);
        this.source_volume_counter = (TextView) findViewById(R.id.source_volume_counter);
        this.source_mute_counter = (TextView) findViewById(R.id.source_mute_counter);
        this.source_start_counter.setText(String.valueOf(this.count1));
        this.source_volume_counter.setText(String.valueOf(this.count2));
        this.source_mute_counter.setText(String.valueOf(this.count3));
        this.bottom_done = (ImageView) inflatedView.findViewById(R.id.bottom_done);
        this.bottom_close = (ImageView) inflatedView.findViewById(R.id.bottom_close);
        this.layout_start.setVisibility(0);
        this.layout_volume.setVisibility(8);
        this.layout_mute.setVisibility(8);
        this.source_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingSourceActivity.this.sourceBottomDialog.show();
            }
        });
        this.source_volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingSourceActivity.this.sourceBottomDialog.show();
            }
        });
        this.source_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingSourceActivity.this.sourceBottomDialog.show();
            }
        });
        this.bottom_done.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (LoadingSourceActivity.this.layout_start.getVisibility() == 0) {
                    LoadingSourceActivity.this.layout_start.setVisibility(8);
                    LoadingSourceActivity.this.layout_volume.setVisibility(0);
                    LoadingSourceActivity.this.layout_mute.setVisibility(8);
                    LoadingSourceActivity.this.sourceBottomDialog.dismiss();
                } else if (LoadingSourceActivity.this.layout_volume.getVisibility() == 0) {
                    LoadingSourceActivity.this.layout_start.setVisibility(8);
                    LoadingSourceActivity.this.layout_volume.setVisibility(8);
                    LoadingSourceActivity.this.layout_mute.setVisibility(0);
                    LoadingSourceActivity.this.sourceBottomDialog.dismiss();
                } else if (LoadingSourceActivity.this.layout_mute.getVisibility() == 0) {
                    LoadingSourceActivity.this.sourceBottomDialog.dismiss();
                    Intent intent = new Intent(LoadingSourceActivity.this, RemoteSelectActivity.class);
                    intent.putExtra("remote_name", LoadingSourceActivity.this.remoteName);
                    //LoadingSourceActivity.this.startActivity(intent);
                    AdsCommon.InterstitialAd(LoadingSourceActivity.this, intent);
                }
            }
        });
        this.bottom_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingSourceActivity.this.sourceBottomDialog.dismiss();
            }
        });
        this.source_start_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LoadingSourceActivity.this.count1 == 0) {
                    LoadingSourceActivity.this.source_start_counter.setText(String.valueOf(LoadingSourceActivity.this.count1));
                    return;
                }
                LoadingSourceActivity loadingSourceActivity = LoadingSourceActivity.this;
                loadingSourceActivity.count1--;
                LoadingSourceActivity.this.source_start_counter.setText(String.valueOf(LoadingSourceActivity.this.count1));
            }
        });
        this.source_start_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LoadingSourceActivity.this.count1 == 10) {
                    LoadingSourceActivity.this.source_start_counter.setText(String.valueOf(LoadingSourceActivity.this.count1));
                    return;
                }
                LoadingSourceActivity.this.count1++;
                LoadingSourceActivity.this.source_start_counter.setText(String.valueOf(LoadingSourceActivity.this.count1));
            }
        });
        this.source_volume_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LoadingSourceActivity.this.count2 == 0) {
                    LoadingSourceActivity.this.source_volume_counter.setText(String.valueOf(LoadingSourceActivity.this.count2));
                    return;
                }
                LoadingSourceActivity loadingSourceActivity = LoadingSourceActivity.this;
                loadingSourceActivity.count2--;
                LoadingSourceActivity.this.source_volume_counter.setText(String.valueOf(LoadingSourceActivity.this.count2));
            }
        });
        this.source_volume_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LoadingSourceActivity.this.count2 == 10) {
                    LoadingSourceActivity.this.source_volume_counter.setText(String.valueOf(LoadingSourceActivity.this.count2));
                    return;
                }
                LoadingSourceActivity.this.count2++;
                LoadingSourceActivity.this.source_volume_counter.setText(String.valueOf(LoadingSourceActivity.this.count2));
            }
        });
        this.source_mute_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LoadingSourceActivity.this.count3 == 0) {
                    LoadingSourceActivity.this.source_mute_counter.setText(String.valueOf(LoadingSourceActivity.this.count3));
                    return;
                }
                LoadingSourceActivity loadingSourceActivity = LoadingSourceActivity.this;
                loadingSourceActivity.count3--;
                LoadingSourceActivity.this.source_mute_counter.setText(String.valueOf(LoadingSourceActivity.this.count3));
            }
        });
        this.source_mute_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LoadingSourceActivity.this.count3 == 10) {
                    LoadingSourceActivity.this.source_mute_counter.setText(String.valueOf(LoadingSourceActivity.this.count3));
                    return;
                }
                LoadingSourceActivity.this.count3++;
                LoadingSourceActivity.this.source_mute_counter.setText(String.valueOf(LoadingSourceActivity.this.count3));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AdsCommon.InterstitialAdBackClick(this);
    }

}
