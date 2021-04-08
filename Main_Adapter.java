package com.example.tang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tang.Ui.DiscoverFragment;
import com.example.tang.Ui.DynamicFragment;
import com.example.tang.Ui.HotFragment;
import com.example.tang.Ui.MessageFragment;

public class Main_Adapter extends FragmentStatePagerAdapter {

    private String[] title = {"热门", "发现", "动态", "消息"};

    public Main_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HotFragment();
            case 1:
                return new DiscoverFragment();
            case 2:
                return new DynamicFragment();
            case 3:
                return new MessageFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       return title[position];
    }

}
