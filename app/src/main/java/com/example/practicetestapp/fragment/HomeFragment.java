package com.example.practicetestapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.practicetestapp.R;
import com.example.practicetestapp.tools.BannerData;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    Banner home_banner;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View home_view = inflater.inflate(R.layout.fragment_home, container, false);

        home_banner = home_view.findViewById(R.id.home_banner);
        home_banner.setAdapter(new BannerImageAdapter<BannerData>(BannerData.getBannerData()) {
            @Override
            public void onBindView(BannerImageHolder holder, BannerData data, int position, int size) {
                Glide.with(holder.itemView)
                        .load(data.imageRes)
                        .into(holder.imageView);
            }
        }).addBannerLifecycleObserver(this).setIndicator(new CircleIndicator(getContext()));
        home_banner.setOnBannerListener((data, position) ->
            Toast.makeText(getContext(), "Click" + position + "item", Toast.LENGTH_LONG).show());

        return home_view;
    }

}