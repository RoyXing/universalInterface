package com.xingzy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewpager);
        fragments.add(Fragment1.getInstance());
        fragments.add(Fragment2.getInstance());
        fragments.add(Fragment3.getInstance());
        fragments.add(Fragment4.getInstance());
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setPageMargin(50);

        FunctionManager.getInstance().registerMethod(new Function1("function1") {
            @Override
            public void function() {
                Log.e("===>MainActivity", "function1接受成功");
            }
        });

    }
}
