package com.example.cyber23.makanyuk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutinflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.search_icon,
            R.drawable.hand_icon,
            R.drawable.notify_icon,
            R.drawable.share_icon
    };


    public String[] slide_headings = {
            "CARI DAN TEMUKAN!",
            "BANTU!",
            "BERITAHU!",
            "BAGIKAN!"
    };

    public String[] slide_caption = {
            "Fitur peta untuk melihat letak makanan yang tersedia untuk diberikan kepada orang yang membutuhkan.",
            "Masukkan informasi mengenai makanan yang kamu punya untuk membantu orang yang membutuhkan di sekitarmu.",
            "Masukkan informasi mengenai orang yang membutuhkan makanan untuk membantu mereka.",
            "Bagikan pengalamanmu tentang berbagi kepada sesama di linimasa teman-temanmu."
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutinflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutinflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideCaption = (TextView) view.findViewById(R.id.slide_caption);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideCaption.setText(slide_caption[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
