package com.mitpark.tvremotemaster;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.marcoscg.dialogsheet.DialogSheet;
import com.mitpark.tvremotemaster.ads.AdsCommon;

public class RemoteActivity extends AppCompatActivity {
    LinearLayout eight;
    RelativeLayout eighteen;
    RelativeLayout eleven;
    ImageView fifteen;
    String finalremoteName;
    LinearLayout five;
    LinearLayout four;
    ImageView fourteen;
    LinearLayout keypad;
    DialogSheet keypadBottomDialog;
    LinearLayout nine;
    RelativeLayout nineteen;
    LinearLayout one;
    TextView remote_name;
    LinearLayout seven;
    LinearLayout seventeen;
    LinearLayout six;
    ImageView sixteen;
    RelativeLayout ten;
    ImageView thirteen;
    LinearLayout three;
    RelativeLayout twelve;
    RelativeLayout twenty;
    RelativeLayout twenty_one;
    RelativeLayout twenty_three;
    RelativeLayout twenty_two;
    LinearLayout two;
    Vibrator vibrator;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_remote);

        if (bundle == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                this.finalremoteName = null;
            } else {
                this.finalremoteName = extras.getString("remote_name");
            }
        } else {
            this.finalremoteName = (String) bundle.getSerializable("remote_name");
        }
        findViewById(R.id.backpress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteActivity.this.onBackPressed();
            }
        });
        this.vibrator = (Vibrator) getSystemService("vibrator");
        DialogSheet dialogSheet = new DialogSheet(this);
        this.keypadBottomDialog = dialogSheet;
        dialogSheet.setView((int) R.layout.keypad_bottom_dialog);
        View inflatedView = this.keypadBottomDialog.getInflatedView();
        this.remote_name = (TextView) findViewById(R.id.remote_name);
        inflatedView.findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        inflatedView.findViewById(R.id.hash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        RemoteControls();
    }

    private void RemoteControls() {
        this.keypad = (LinearLayout) findViewById(R.id.keypad);
        this.one = (LinearLayout) findViewById(R.id.btn_one);
        this.two = (LinearLayout) findViewById(R.id.btn_two);
        this.three = (LinearLayout) findViewById(R.id.btn_three);
        this.four = (LinearLayout) findViewById(R.id.btn_four);
        this.five = (LinearLayout) findViewById(R.id.btn_five);
        this.six = (LinearLayout) findViewById(R.id.btn_six);
        this.seven = (LinearLayout) findViewById(R.id.btn_seven);
        this.eight = (LinearLayout) findViewById(R.id.btn_eight);
        this.nine = (LinearLayout) findViewById(R.id.btn_nine);
        this.ten = (RelativeLayout) findViewById(R.id.btn_ten);
        this.eleven = (RelativeLayout) findViewById(R.id.btn_eleven);
        this.twelve = (RelativeLayout) findViewById(R.id.btn_twelve);
        this.thirteen = (ImageView) findViewById(R.id.btn_thirteen);
        this.fourteen = (ImageView) findViewById(R.id.btn_fourteen);
        this.fifteen = (ImageView) findViewById(R.id.btn_fifteen);
        this.sixteen = (ImageView) findViewById(R.id.btn_sixteen);
        this.seventeen = (LinearLayout) findViewById(R.id.btn_seventeen);
        this.eighteen = (RelativeLayout) findViewById(R.id.btn_eighteen);
        this.nineteen = (RelativeLayout) findViewById(R.id.btn_ninteen);
        this.twenty = (RelativeLayout) findViewById(R.id.btn_twenty);
        this.twenty_one = (RelativeLayout) findViewById(R.id.btn_twenty_one);
        this.twenty_two = (RelativeLayout) findViewById(R.id.btn_twenty_two);
        this.twenty_three = (RelativeLayout) findViewById(R.id.btn_twenty_three);
        this.keypad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteActivity.this.keypadBottomDialog.show();
            }
        });
        this.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.thirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.fourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.sixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.seventeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.eighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.nineteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.twenty_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.twenty_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
        this.twenty_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    RemoteActivity.this.vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
                } else {
                    RemoteActivity.this.vibrator.vibrate(500);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        this.keypadBottomDialog.dismiss();
        super.onBackPressed();
        AdsCommon.InterstitialAdBackClick(this);
    }

}
