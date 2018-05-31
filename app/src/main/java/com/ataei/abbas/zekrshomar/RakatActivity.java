package com.ataei.abbas.zekrshomar;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RakatActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private SensorManager mSensorManager;
    private Sensor mProximity;
    private static final int SENSOR_SENSITIVITY = 4;
    int step = 0;
    TextView rtv, stv, tvs, tvr, endtv;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rakat);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        reset = findViewById(R.id.resetbtn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endtv.setText("");
                tvr.setText(getResources().getString(R.string.rokat));
                tvs.setText(getResources().getString(R.string.sajde));
                rtv.setText("");
                stv.setText("");
                step = 0;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] >= -SENSOR_SENSITIVITY && event.values[0] <= SENSOR_SENSITIVITY) {
                //near
                step += 1;
            }
        }

        rtv = findViewById(R.id.rakatNumberTv);
        stv = findViewById(R.id.sajdeNumberTv);
        tvs = findViewById(R.id.sajdeTv);
        tvr = findViewById(R.id.rakatTv);
        endtv = findViewById(R.id.endtv);

        switch (step) {
            case 1 : rtv.setText(getResources().getStringArray(R.array.tedad)[0]);
                stv.setText(getResources().getStringArray(R.array.tedad)[0]); break;
            case 2 : rtv.setText(getResources().getStringArray(R.array.tedad)[0]);
                stv.setText(getResources().getStringArray(R.array.tedad)[1]); break;
            case 3 : rtv.setText(getResources().getStringArray(R.array.tedad)[1]);
                stv.setText(getResources().getStringArray(R.array.tedad)[0]); break;
            case 4 : rtv.setText(getResources().getStringArray(R.array.tedad)[1]);
                stv.setText(getResources().getStringArray(R.array.tedad)[1]); break;
            case 5 : rtv.setText(getResources().getStringArray(R.array.tedad)[2]);
                stv.setText(getResources().getStringArray(R.array.tedad)[0]); break;
            case 6 : rtv.setText(getResources().getStringArray(R.array.tedad)[2]);
                stv.setText(getResources().getStringArray(R.array.tedad)[1]); break;
            case 7 : rtv.setText(getResources().getStringArray(R.array.tedad)[3]);
                stv.setText(getResources().getStringArray(R.array.tedad)[0]); break;
            case 8 : rtv.setText(getResources().getStringArray(R.array.tedad)[3]);
                stv.setText(getResources().getStringArray(R.array.tedad)[1]); break;
            case 9 : rtv.setText(""); stv.setText(""); tvr.setText(""); tvs.setText("");
                endtv.setText(getResources().getString(R.string.payan)); break;
            default: endtv.setText("");
                tvr.setText(getResources().getString(R.string.rokat));
                tvs.setText(getResources().getString(R.string.sajde)); break;


        }

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rakat, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        new MaterialDialog.Builder(this)
                .title(R.string.rahnamaa)
                .titleGravity(GravityEnum.CENTER)
                .titleColorRes(R.color.black)
                .content(R.string.matn)
                .contentGravity(GravityEnum.CENTER)
                .contentColorRes(R.color.myColor)
                .positiveText("بازگشت")
                .positiveColorRes(R.color.colorPrimaryDark)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();

//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setMessage(getResources().getString(R.string.matn));
//            builder.show();

        return super.onOptionsItemSelected(item);
    }
}
