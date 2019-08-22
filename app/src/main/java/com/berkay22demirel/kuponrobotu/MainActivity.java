package com.berkay22demirel.kuponrobotu;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_guess:
                    mTextMessage.setText(R.string.navigation_bottom_guess);
                    return true;
                case R.id.navigation_coupon:
                    mTextMessage.setText(R.string.navigation_bottom_coupon);
                    return true;
                case R.id.navigation_results:
                    mTextMessage.setText(R.string.navigation_bottom_results);
                    return true;
                case R.id.navigation_analysis:
                    mTextMessage.setText(R.string.navigation_bottom_analysis);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
