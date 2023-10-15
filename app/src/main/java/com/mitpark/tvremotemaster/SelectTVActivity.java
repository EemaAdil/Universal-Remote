package com.mitpark.tvremotemaster;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.mitpark.tvremotemaster.ads.AdsCommon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SelectTVActivity extends AppCompatActivity {
    List<String> FamousTVList = new ArrayList();
    List<String> TVList = new ArrayList();

    EditText ed_search;
    FamousBrandListAdapter famousBrandListAdapter;
    RecyclerView famousTVBrand;
    String[] famousnames = {"Samsung", "Sharp", "LG", "Videocon", "Panasonic", "ONIDA", "Toshiba", "Phillips", "Sansui", "Sony"};
    public int flag = 0;
    ImageView id_cross;
    RecyclerView listviewTVBrand;
    MyRemoteListAdapter myListAdapter;
    String[] names = {"Acer", "Admiral", "Aiwa", "Akai", "Aoc", "Apex", "Audiovox", "Bahun", "Bose", "Bush", "CCE", "Changhong", "Coby", "Colby", "Condor", "Daewoo", "Zenith", "Dura Brand", "Dynex", "Elekta", "Element", "Emerson", "Funai", "Gold Star", "Grundig", "Haier", "Hisense", "Hitachi", "Hyundai", "Insignia", "Jensen", "JVC", "Kenwood", "Kogan", "Kolin", "Konkal", "LG", "Loewe", "Logik", "Magnavox", "Mascom", "Medion", "Micromax", "Mitsai", "Mitsubishi", "Mystery", "NEC", "Nexus", "Nikai", "Niko", "Noblex", "OKI", "Olevia", "Onida", "Orion", "Others1", "Others2", "Palsonic", "Panasonic", "Philco", "Philips", "Pioneer", "Polaroid", "Polytron", "Prima", "Promac", "Proscan", "Proton", "RCA", "Rubin", "Saba", "Samsung", "Samsung Smart", "Sansui", "Sanyo", "Scott", "SEG", "Seiki", "Sharp", "Shivaki", "Singer", "Sinotec", "Skyworth", "Sony", "Supra", "Swisstec", "Sylvania", "Symphonic", "TCL", "Teac", "Technical", "Telefunken", "Thomson", "Tokai", "Toshiba", "TurboX", "TV M1", "Upstar", "Venturer", "Veon", "Videocon", "Viore", "Vizio", "Voxson", "Wansa", "WD Live", "Westinghouse", "DVB"};
    ArrayList<String> temp = new ArrayList<>();
    ArrayList<String> temp1 = new ArrayList<>();
    List<String> temp2 = new ArrayList();
    List<String> temp3 = new ArrayList();

    public SelectTVActivity() {
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_select_tv);


        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) findViewById(R.id.Admob_Banner_Frame);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        AdsCommon.RegulerBanner(this, admob_banner, adContainer);


        rattingDialog();
        findViewById(R.id.backpress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectTVActivity.this.onBackPressed();
            }
        });

        this.ed_search = (EditText) findViewById(R.id.ed_search);
        this.id_cross = (ImageView) findViewById(R.id.id_cross);
        this.ed_search.setCursorVisible(false);
        this.ed_search.setOnClickListener(new C23322());
        this.ed_search.setOnClickListener(new C23222());
        this.ed_search.addTextChangedListener(new C23333());
        this.ed_search.addTextChangedListener(new C22333());
        Arrays.sort(this.names, new C23311());
        Collections.addAll(this.temp2, this.names);
        Collections.addAll(this.temp3, this.famousnames);
        for (int i = 0; i < this.temp2.size(); i++) {
            String replace = this.temp2.get(i).replace("_", " ");
            this.TVList.add(replace);
            this.temp.add(replace);
        }
        for (int i2 = 0; i2 < this.temp3.size(); i2++) {
            String replace2 = this.temp3.get(i2).replace("_", " ");
            this.FamousTVList.add(replace2);
            this.temp1.add(replace2);
        }
        this.listviewTVBrand = (RecyclerView) findViewById(R.id.listviewTVBrand);
        this.myListAdapter = new MyRemoteListAdapter(this.TVList);
        this.listviewTVBrand.setHasFixedSize(true);
        this.listviewTVBrand.setLayoutManager(new LinearLayoutManager(this));
        this.listviewTVBrand.setAdapter(this.myListAdapter);


        this.famousTVBrand = (RecyclerView) findViewById(R.id.famousTVBrand);
        this.famousBrandListAdapter = new FamousBrandListAdapter(this.FamousTVList);
        this.famousTVBrand.setHasFixedSize(true);
        this.famousTVBrand.setLayoutManager(new GridLayoutManager(this, 3));
        this.famousTVBrand.setAdapter(this.famousBrandListAdapter);
        this.listviewTVBrand.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(SelectTVActivity.this, LoadingSourceActivity.class);
                intent.putExtra("remote_name", SelectTVActivity.this.TVList.get(i));
                AdsCommon.InterstitialAd(SelectTVActivity.this, intent);
            }
        }));
        this.famousTVBrand.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(SelectTVActivity.this, LoadingSourceActivity.class);
                intent.putExtra("remote_name", SelectTVActivity.this.FamousTVList.get(i));
                AdsCommon.InterstitialAd(SelectTVActivity.this, intent);
            }
        }));
        this.id_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectTVActivity.this.ed_search.setText("");
            }
        });
    }

    private void rattingDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.rate_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.findViewById(R.id.ratting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.no_rate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    class C23311 implements Comparator<String> {
        C23311() {
        }

        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    class C23322 implements View.OnClickListener {
        C23322() {
        }

        public void onClick(View view) {
            SelectTVActivity.this.ed_search.setCursorVisible(true);
            ((InputMethodManager) SelectTVActivity.this.getSystemService("input_method")).showSoftInput(SelectTVActivity.this.ed_search, 1);
        }
    }

    class C23333 implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C23333() {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SelectTVActivity.this.myListAdapter.filter(charSequence.toString());
            if (SelectTVActivity.this.ed_search.getText().toString().equalsIgnoreCase("")) {
                SelectTVActivity.this.id_cross.setVisibility(8);
            } else {
                SelectTVActivity.this.id_cross.setVisibility(0);
            }
            if (SelectTVActivity.this.TVList.size() == 0) {
                SelectTVActivity.this.listviewTVBrand.setVisibility(8);
            } else {
                SelectTVActivity.this.listviewTVBrand.setVisibility(0);
            }
        }
    }

    class C23111 implements Comparator<String> {
        C23111() {
        }

        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    class C23222 implements View.OnClickListener {
        C23222() {
        }

        public void onClick(View view) {
            SelectTVActivity.this.ed_search.setCursorVisible(true);
            ((InputMethodManager) SelectTVActivity.this.getSystemService("input_method")).showSoftInput(SelectTVActivity.this.ed_search, 1);
        }
    }

    class C22333 implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C22333() {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SelectTVActivity.this.famousBrandListAdapter.filter(charSequence.toString());
            if (SelectTVActivity.this.ed_search.getText().toString().equalsIgnoreCase("")) {
                SelectTVActivity.this.id_cross.setVisibility(8);
            } else {
                SelectTVActivity.this.id_cross.setVisibility(0);
            }
            if (SelectTVActivity.this.FamousTVList.size() == 0) {
                SelectTVActivity.this.famousTVBrand.setVisibility(8);
            } else {
                SelectTVActivity.this.famousTVBrand.setVisibility(0);
            }
        }
    }

    public class MyRemoteListAdapter extends RecyclerView.Adapter<MyRemoteListAdapter.ViewHolder> {
        private List<String> listdata;

        public MyRemoteListAdapter(List<String> list) {
            this.listdata = list;
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_list_item, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(this.listdata.get(i));
        }

        public int getItemCount() {
            return this.listdata.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;

            public ViewHolder(View view) {
                super(view);
                this.textView = (TextView) view.findViewById(R.id.textView);
            }
        }

        public void filter(String str) {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            SelectTVActivity.this.TVList.clear();
            if (lowerCase.length() == 0) {
                SelectTVActivity.this.TVList.addAll(SelectTVActivity.this.temp);
            } else {
                for (String str2 : SelectTVActivity.this.names) {
                    if (str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                        SelectTVActivity.this.TVList.add(str2);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public class FamousBrandListAdapter extends RecyclerView.Adapter<FamousBrandListAdapter.ViewHolder> {
        private List<String> brandlistdata;

        public FamousBrandListAdapter(List<String> list) {
            this.brandlistdata = list;
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.famous_list_item, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(this.brandlistdata.get(i));
        }

        public int getItemCount() {
            return this.brandlistdata.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;

            public ViewHolder(View view) {
                super(view);
                this.textView = (TextView) view.findViewById(R.id.textView);
            }
        }

        public void filter(String str) {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            SelectTVActivity.this.FamousTVList.clear();
            if (lowerCase.length() == 0) {
                SelectTVActivity.this.FamousTVList.addAll(SelectTVActivity.this.temp1);
            } else {
                for (String str2 : SelectTVActivity.this.famousnames) {
                    if (str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                        SelectTVActivity.this.FamousTVList.add(str2);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AdsCommon.InterstitialAdBackClick(this);
    }

}
