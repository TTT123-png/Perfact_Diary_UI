package com.example.tang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    ViewPager main_viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Main_Adapter main_adapter = new Main_Adapter(getSupportFragmentManager());

        main_viewpager = findViewById(R.id.main_viewpager);
        main_viewpager.setAdapter(main_adapter);
    }

    //OptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }
}