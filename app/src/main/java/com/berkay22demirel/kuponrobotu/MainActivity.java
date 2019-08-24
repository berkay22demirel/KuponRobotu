package com.berkay22demirel.kuponrobotu;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.berkay22demirel.kuponrobotu.adapter.FragmentAdapter;
import com.berkay22demirel.kuponrobotu.fragments.AnalysisFragment;
import com.berkay22demirel.kuponrobotu.fragments.GuessFragment;
import com.berkay22demirel.kuponrobotu.fragments.MyCouponFragment;
import com.berkay22demirel.kuponrobotu.fragments.ResultsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_guess:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_coupon:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_results:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_analysis:
                    mViewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mNavigationView.setSelectedItemId(R.id.navigation_guess);
                    break;
                case 1:
                    mNavigationView.setSelectedItemId(R.id.navigation_coupon);
                    break;
                case 2:
                    mNavigationView.setSelectedItemId(R.id.navigation_results);
                    break;
                case 3:
                    mNavigationView.setSelectedItemId(R.id.navigation_analysis);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mViewPager = findViewById(R.id.main_activity_view_pager);
        mNavigationView = findViewById(R.id.main_activity_bottom_navigation_view);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager.setAdapter(getFragmentAdapter());
        mViewPager.setCurrentItem(0);
    }

    private FragmentAdapter getFragmentAdapter() {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.add(new GuessFragment(), getString(R.string.guess));
        adapter.add(new MyCouponFragment(), getString(R.string.my_coupon));
        adapter.add(new ResultsFragment(), getString(R.string.results));
        adapter.add(new AnalysisFragment(), getString(R.string.analysis));
        return adapter;
    }


}
