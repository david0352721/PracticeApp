package com.example.practicetestapp.tools;

import com.example.practicetestapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BannerData {

    public Integer imageRes;
    public String imageUrl;
    public String title;
    public int viewType;

    public BannerData(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public static @NotNull List<BannerData> getBannerData() {
        List<BannerData> list = new ArrayList<>();
        list.add(new BannerData(R.drawable.home_banner1, "banner1", 1));
        list.add(new BannerData(R.drawable.home_banner2, "banner2", 3));
        list.add(new BannerData(R.drawable.home_banner3, "banner3", 3));
        list.add(new BannerData(R.drawable.home_banner4, "banner4", 1));
        list.add(new BannerData(R.drawable.home_banner5, "banner5", 1));
        return list;
    }

    public static @NotNull List<String> getColors(int size) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            list.add(getRandColor());
        }
        return list;
    }

    public static @NotNull String getRandColor() {
        String R, G, B;
        Random random = new Random();
        R = Integer.toHexString(random.nextInt(256)).toUpperCase();
        G = Integer.toHexString(random.nextInt(256)).toUpperCase();
        B = Integer.toHexString(random.nextInt(256)).toUpperCase();

        R = R.length() == 1 ? "0" + R : R;
        G = G.length() == 1 ? "0" + G : G;
        B = B.length() == 1 ? "0" + B : B;

        return "#" + R + G + B;
    }

}
