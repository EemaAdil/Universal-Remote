package com.mitpark.tvremotemaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.mitpark.tvremotemaster.ads.AdsCommon;


public class RemoteSelectActivity extends AppCompatActivity {
    LinearLayout bathroom_tv;
    LinearLayout bedroom_tv;
    LinearLayout default_tv;
    LinearLayout living_tv;
    LinearLayout office_tv;
    String remoteCom;
    String remoteName;
    String remoteNameSelect;
    String remoteType;
    EditText remote_edit;
    RelativeLayout remote_save;
    LinearLayout theater_tv;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_remote_select);


        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer);


        if (bundle == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                this.remoteNameSelect = null;
            } else {
                this.remoteNameSelect = extras.getString("remote_name");
            }
        } else {
            this.remoteNameSelect = (String) bundle.getSerializable("remote_name");
        }
        EditText editText = (EditText) findViewById(R.id.remote_edit);
        this.remote_edit = editText;
        editText.setText(this.remoteNameSelect + " TV ");
        findViewById(R.id.backpress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteSelectActivity.this.onBackPressed();
            }
        });
        init();
    }

    private void init() {
        this.default_tv = (LinearLayout) findViewById(R.id.default_tv);
        this.bedroom_tv = (LinearLayout) findViewById(R.id.bedroom_tv);
        this.living_tv = (LinearLayout) findViewById(R.id.living_tv);
        this.bathroom_tv = (LinearLayout) findViewById(R.id.bathroom_tv);
        this.theater_tv = (LinearLayout) findViewById(R.id.theater_tv);
        this.office_tv = (LinearLayout) findViewById(R.id.office_tv);
        this.remote_save = (RelativeLayout) findViewById(R.id.remote_save);
        this.default_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = RemoteSelectActivity.this.remote_edit;
                editText.setText(RemoteSelectActivity.this.remoteNameSelect + " TV ");
                RemoteSelectActivity remoteSelectActivity = RemoteSelectActivity.this;
                remoteSelectActivity.remoteName = RemoteSelectActivity.this.remoteNameSelect + " TV ";
                RemoteSelectActivity.this.remoteType = " TV Remote";
            }
        });
        this.bedroom_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = RemoteSelectActivity.this.remote_edit;
                editText.setText(RemoteSelectActivity.this.remoteNameSelect + " TV Bedroom");
                RemoteSelectActivity remoteSelectActivity = RemoteSelectActivity.this;
                remoteSelectActivity.remoteName = RemoteSelectActivity.this.remoteNameSelect + " TV Bedroom";
                RemoteSelectActivity.this.remoteType = " Bedroom TV Remote";
            }
        });
        this.living_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = RemoteSelectActivity.this.remote_edit;
                editText.setText(RemoteSelectActivity.this.remoteNameSelect + " TV Living Room");
                RemoteSelectActivity remoteSelectActivity = RemoteSelectActivity.this;
                remoteSelectActivity.remoteName = RemoteSelectActivity.this.remoteNameSelect + " TV Living Room";
                RemoteSelectActivity.this.remoteType = " Living Room TV Remote";
            }
        });
        this.bathroom_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = RemoteSelectActivity.this.remote_edit;
                editText.setText(RemoteSelectActivity.this.remoteNameSelect + " TV Bathroom");
                RemoteSelectActivity remoteSelectActivity = RemoteSelectActivity.this;
                remoteSelectActivity.remoteName = RemoteSelectActivity.this.remoteNameSelect + " TV Bathroom";
                RemoteSelectActivity.this.remoteType = " Bathroom TV Remote";
            }
        });
        this.theater_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = RemoteSelectActivity.this.remote_edit;
                editText.setText(RemoteSelectActivity.this.remoteNameSelect + " TV Home Theater");
                RemoteSelectActivity remoteSelectActivity = RemoteSelectActivity.this;
                remoteSelectActivity.remoteName = RemoteSelectActivity.this.remoteNameSelect + " TV Home Theater";
                RemoteSelectActivity.this.remoteType = " Home Theater TV Remote";
            }
        });
        this.office_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = RemoteSelectActivity.this.remote_edit;
                editText.setText(RemoteSelectActivity.this.remoteNameSelect + " TV Office");
                RemoteSelectActivity remoteSelectActivity = RemoteSelectActivity.this;
                remoteSelectActivity.remoteName = RemoteSelectActivity.this.remoteNameSelect + " TV Office";
                RemoteSelectActivity.this.remoteType = " Office TV Remote";
            }
        });
        this.remote_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteSelectActivity remoteSelectActivity = RemoteSelectActivity.this;
                remoteSelectActivity.remoteCom = RemoteSelectActivity.this.remoteNameSelect + " TV";
                MainActivity.studentDataList.add(MainActivity.studentDataList.size(), new remoteData(RemoteSelectActivity.this.remoteType, RemoteSelectActivity.this.remoteCom));
                SharedPreferences.Editor edit = RemoteSelectActivity.this.getSharedPreferences("sharedPrefIncomeCategoryList", 0).edit();
                edit.putString("incomeCategoryList", new Gson().toJson((Object) MainActivity.studentDataList));
                edit.apply();
                Intent intent = new Intent(RemoteSelectActivity.this, RemoteActivity.class);
                intent.putExtra("remote_name", RemoteSelectActivity.this.remoteName);
                //RemoteSelectActivity.this.startActivity(intent);
                AdsCommon.InterstitialAd(RemoteSelectActivity.this, intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AdsCommon.InterstitialAdBackClick(this);
    }

}
