package com.example.horoo.moamoa.MyCoupon;

import com.example.horoo.moamoa.R;

import java.util.ArrayList;

/**
 * Created by 이광호 on 2017-07-03.
 */

public class SampleData {
        private ArrayList<Integer> sampleImages = new ArrayList<>();
        private ArrayList<String> sampleTitles = new ArrayList<>();
        private ArrayList<String> sampleDiscript = new ArrayList<>();
        private final int count = 4;
        public SampleData(){
            sampleImages.add(R.drawable.bakery_sample_image);
            sampleTitles.add("PusanNationalUniv. Bakery Shop");
            sampleDiscript.add("Open 07:00AM ~ 07:00PM, Buy our fresh breads and sandwiches!!");

            sampleImages.add(R.drawable.book_store_sample_image);
            sampleTitles.add("PNU Original Book Store");
            sampleDiscript.add("Open 08:30AM ~ 07:00PM, We sells official education books and discount event now launching.");

            sampleImages.add(R.drawable.cafe_sample_image);
            sampleTitles.add("PNU - Un Jook Jung");
            sampleDiscript.add("Open 09:00AM ~ 06:00PM. Our store hides behind the CSE building.");

            sampleImages.add(R.drawable.cloth_store_sample_image);
            sampleTitles.add("NC department - Cloth Store");
            sampleDiscript.add("Open 10:00AM ~ 09:00PM , We are in 3 floor.");
        }

        public int getImageRes(int index){return sampleImages.get(index % count);}
        public String getImageTitle(int index){return sampleTitles.get(index% count);}
        public String getImageDiscrpt(int index){return sampleDiscript.get(index% count);}

   }

