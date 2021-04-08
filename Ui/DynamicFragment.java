package com.example.tang.Ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.tang.HotAdapter;
import com.example.tang.R;

public class DynamicFragment extends Fragment {

    private RecyclerView dynamic_rec;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dynamic_fragment, null);
        dynamic_rec=view.findViewById(R.id.dynamic_rec);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        dynamic_rec.setLayoutManager(staggeredGridLayoutManager);
        HotAdapter hotAdapter = new HotAdapter(getContext());
        dynamic_rec.setAdapter(hotAdapter);


        return view;
    }
}
