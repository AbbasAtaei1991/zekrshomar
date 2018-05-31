package com.ataei.abbas.zekrshomar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ZekrActivity extends AppCompatActivity {

    int numberOfZekr;
    TextView days, tedad;
    Button btn;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findview();
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/yaqut.ttf");
        tedad.setTypeface(tf);

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        String weekDay = "";
        switch (day) {
            case Calendar.SUNDAY: weekDay = getString(R.string.yekshanbe); break;
            case Calendar.MONDAY: weekDay = getString(R.string.doshanbe); break;
            case Calendar.TUESDAY: weekDay = getString(R.string.seshanbe); break;
            case Calendar.WEDNESDAY: weekDay = getString(R.string.charshanbe); break;
            case Calendar.THURSDAY: weekDay = getString(R.string.panjshanbe); break;
            case Calendar.FRIDAY: weekDay = getString(R.string.jome); break;
            case Calendar.SATURDAY: weekDay = getString(R.string.shanbe); break;
        }
        days.setText(weekDay);

    }
    public void increment(View view) {
        numberOfZekr += 1;
        if (numberOfZekr == 100) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(200);
        }
        tedad.setText("" + numberOfZekr);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }



    public boolean itemSelected(MenuItem menu) {
        numberOfZekr = 0;
        tedad.setText("" + numberOfZekr);
        return true;
    }
    public void findview() {
        days = findViewById(R.id.textView);
        btn = findViewById(R.id.tab);
        tedad = findViewById(R.id.numberOfZekr);
    }
    public boolean openDialog(MenuItem menu) {
        final CharSequence[] items = {
                "اللهم صل علی محمد و آل محمد و عجل فرجهم",
                "سبحان الله و الحمد لله و لا اله الا الله و الله اکبر", "سبحان الله"

                ,"الحمد الله", "لا اله الا الله", "لا حول و لا قوة  الا بالله العلی العظیم"
                ,"استغفر الله ربی و اتوب الیه"
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(ZekrActivity.this);
        builder.setTitle(R.string.entekhab);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                        findview();
                        days.setText(items[item]);

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
        return true;
    }
}


