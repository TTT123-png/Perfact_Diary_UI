package com.example.tang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PagerFragment extends Fragment {
    public static PagerFragment newInstance(String number) {

        Bundle bundle = new Bundle();
        bundle.putString("position", number);
        PagerFragment fragment = new PagerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        TextView tv = new TextView(getActivity());
        if (bundle != null) {
            String number = bundle.getString("position");
            tv.setText(number);
        }
        return tv;
    }
}

