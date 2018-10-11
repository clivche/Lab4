package com.example.d.lab4;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Button findSensors;
    TextView display;
    SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findSensors = (Button) findViewById(R.id.button);
        display = (TextView) findViewById(R.id.textView);
        display.setMovementMethod(new ScrollingMovementMethod());
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        findSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findAvailableSensors();
            }
        });




    }
/*

    private void initialisePaging() {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Tab1Fragment.class.getName()));
        fragments.add(Fragment.instantiate(this, Tab2Fragment.class.getName()));
        fragments.add(Fragment.instantiate(this, Tab3Fragment.class.getName()));
        this.mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return false;
            }
        };
    }

*/
    private void findAvailableSensors() {
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensorList.size(); i++) {
            int j = i + 1;
            display.append(j + ". Name: " + sensorList.get(i).getName() + "\n    Type: " +
                    sensorList.get(i).getType() + "\n    Vendor: " +
                    sensorList.get(i).getVendor() + "\n    Version: " +
                    sensorList.get(i).getVersion() + "\n    Max Range: " +
                    sensorList.get(i).getMaximumRange() + "\n    Min Delay: " +
                    sensorList.get(i).getMinDelay()+ "\n"
            );
        }
    }
}
