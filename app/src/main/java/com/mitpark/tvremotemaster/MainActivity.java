package com.mitpark.tvremotemaster;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.NativeAdLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mitpark.tvremotemaster.AdsFlowWise.Const;
import com.mitpark.tvremotemaster.ads.AdsCommon;
import com.mitpark.tvremotemaster.ads.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
    public static List<remoteData> studentDataList = new ArrayList();
    ImageView add_remote;
    RelativeLayout drawer_handle;
    String myList;
    ImageView open_drawer;
    private RecyclerView recyclerView;
    RelativeLayout remote_add;
    private RemoteAdapter studentAdapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);


        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer);


        //Reguler Native Ads
        FrameLayout admob_native_frame = (FrameLayout) findViewById(R.id.Admob_Native_Frame);
        NativeAdLayout nativeAdLayout = (NativeAdLayout) findViewById(R.id.native_ad_container);
        FrameLayout maxNative = (FrameLayout) findViewById(R.id.max_native_ad_layout);
        AdsCommon.RegulerBigNative(this, admob_native_frame, nativeAdLayout, maxNative);



        if (Const.cf.matches("true")) {
            Dialog dialog = new Dialog(this, R.style.Theme_Dialog);
            dialog.setContentView(R.layout.dig_rd);
            dialog.setCancelable(false);
            dialog.findViewById(R.id.btnPlus).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(Const.curl));
                    MainActivity.this.startActivity(intent);
                }
            });
            dialog.show();
        } else {

        }
        loadData();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.drawer_handle);
        this.drawer_handle = relativeLayout;
        relativeLayout.setVisibility(8);
        this.recyclerView = (RecyclerView) findViewById(R.id.remote_list);
        this.studentAdapter = new RemoteAdapter(studentDataList, this);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.studentAdapter);
        this.add_remote = (ImageView) findViewById(R.id.add_remote);
        this.remote_add = (RelativeLayout) findViewById(R.id.remote_add);
        this.open_drawer = (ImageView) findViewById(R.id.open_drawer);
        this.add_remote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mix Interstitial Ads Call
                Intent intent = new Intent(MainActivity.this, SelectTVActivity.class);
                AdsCommon.InterstitialAd(MainActivity.this, intent);
            }
        });
        this.remote_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mix Interstitial Ads Call
                Intent intent = new Intent(MainActivity.this, SelectTVActivity.class);
                AdsCommon.InterstitialAd(MainActivity.this, intent);
            }
        });
        this.open_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.drawer_handle.setVisibility(View.VISIBLE);
                MainActivity.this.drawer_handle.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_side));
            }
        });
        this.drawer_handle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.drawer_handle.setVisibility(View.GONE);
                MainActivity.this.drawer_handle.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_side));
            }
        });
        findViewById(R.id.rate_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.drawer_handle.setVisibility(View.GONE);

                final String rateapp = getPackageName();
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + rateapp));
                startActivity(intent1);

            }
        });
        findViewById(R.id.share_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.drawer_handle.setVisibility(View.GONE);

                String appName = getResources().getString(R.string.app_name);
                final String appPackageName = getPackageName();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, appName + " \n : https://play.google.com/store/apps/details?id=" + appPackageName);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });
        findViewById(R.id.more_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.drawer_handle.setVisibility(View.GONE);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=" + MyApplication.MoreApps));
                startActivity(intent);

            }
        });
    }

    private void loadData() {
        List<remoteData> list = (List) new Gson().fromJson(getSharedPreferences("sharedPrefIncomeCategoryList", 0).getString("incomeCategoryList", (String) null), new TypeToken<ArrayList<remoteData>>() {
        }.getType());
        studentDataList = list;
        if (list == null) {
            studentDataList = new ArrayList();
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onResume() {
        super.onResume();
        if (studentDataList.size() == 0) {
            this.remote_add.setVisibility(0);
            this.add_remote.setVisibility(8);
        } else if (studentDataList.size() >= 1) {
            this.remote_add.setVisibility(8);
            this.add_remote.setVisibility(0);
        }
        this.drawer_handle.setVisibility(8);
        studentDataList.size();
        this.myList = String.valueOf(studentDataList);
        this.studentAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            AdsCommon.InterstitialAdBackClick(this);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
