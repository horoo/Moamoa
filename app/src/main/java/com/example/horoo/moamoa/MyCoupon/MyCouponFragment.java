package com.example.horoo.moamoa.MyCoupon;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.horoo.moamoa.MainActivity;
import com.example.horoo.moamoa.R;

/**
 * Created by 이광호 on 2017-07-03.
 */

public class MyCouponFragment extends Fragment {
    public Context parentContext;
    public View view;
    private ViewPager myCouponView;
    private Context mContext;
    private MyCouponViewPagerAdapter myCouponViewPagerAdapter;
    public MyCouponFragment() {
        // Required empty public construct
        //mContext = MainActivity.mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = inflater.getContext();
        final View innerview = inflater.inflate(R.layout.fragment_mycoupon, container, false);
        init_mainViewPager(innerview,inflater);
        // 갤러리 내부에 들어갈 그리드뷰의 생성을 돕는 어댑터 YearlyGridViewAdapter 클래스를 생성한다.
        return innerview;
    }

    private void init_mainViewPager(View view,LayoutInflater inflater){
        myCouponView = (ViewPager)view.findViewById(R.id.main_coupon_viewpager);
        myCouponViewPagerAdapter = new MyCouponViewPagerAdapter(inflater,mContext);
        myCouponView.setAdapter(myCouponViewPagerAdapter);
        myCouponView.setOffscreenPageLimit(3);
        myCouponView.setCurrentItem(1); // position 1 is center Cam UI
        myCouponView.setOnPageChangeListener(MainMenuPagerChangeListener());
    }

    /**
     * MainMenuPagerChangeListener
     *
     * */
    public static int current_main_menu_pos = 1;
    ViewPager.OnPageChangeListener MainMenuPagerChangeListener(){
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {}
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(mContext,"Page " + position,Toast.LENGTH_SHORT).show();
                switch(position){
                    case 0:{
                        current_main_menu_pos = 0;
                        break;
                    }
                    case 1:{
                        current_main_menu_pos = 1;
                        break;
                    }
                    case 2:{
                        current_main_menu_pos = 2;
                        break;
                    }
                }
            }


        };
    }
}
