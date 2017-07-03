package com.example.horoo.moamoa.MyCoupon;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.horoo.moamoa.R;

/**
 * Created by 이광호 on 2017-07-03.
 */

public class MyCouponViewPagerAdapter extends PagerAdapter {
    LayoutInflater inflater;
    private SampleData sampleData;
    private Context context;
    public MyCouponViewPagerAdapter(LayoutInflater inflater,Context context) {
        // TODO Auto-generated constructor stub
        this.inflater=inflater;
        this.context = context;
        sampleData = new SampleData();
    }

    //PagerAdapter가 가지고 잇는 View의 개수를 리턴
    //보통 보여줘야하는 이미지 배열 데이터의 길이를 리턴
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 10; //이미지 개수 리턴(그림이 10개라서 10을 리턴)
    }


    //ViewPager가 현재 보여질 Item(View객체)를 생성할 필요가 있는 때 자동으로 호출
    //쉽게 말해, 스크롤을 통해 현재 보여져야 하는 View를 만들어냄.
    //첫번째 파라미터 : ViewPager
    //두번째 파라미터 : ViewPager가 보여줄 View의 위치(가장 처음부터 0,1,2,3...)
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        View view = null;
        //ViewPager에 만들어 낸 View 추가
        view = inflater.inflate(R.layout.coupon_page,null);
        TextView title = (TextView)view.findViewById(R.id.cp_main_title);
        TextView discript = (TextView)view.findViewById(R.id.cp_main_discript);
        ImageView imageView = (ImageView)view.findViewById(R.id.cp_main_image);
        title.setText(sampleData.getImageTitle(position));
        discript.setText(sampleData.getImageDiscrpt(position));
        imageView.setImageResource(sampleData.getImageRes(position));

        // Stamp


        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        container.removeView((View)object);

    }

    //instantiateItem() 메소드에서 리턴된 Ojbect가 View가  맞는지 확인하는 메소드
    @Override
    public boolean isViewFromObject(View v, Object obj) {
        // TODO Auto-generated method stub
        return v==obj;

    }

    private class StampGridAdapter extends BaseAdapter {
        Context context;
        int layout;
        int img[] = {R.drawable.moamoa_stamp_example,R.drawable.moamoa_stamp_example2};
        LayoutInflater inf;

        public StampGridAdapter(Context context, int layout) {
            this.context = context;
            this.layout = layout;
            inf = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return img[position % img.length];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null)
                convertView = inf.inflate(layout, null);
            ImageView iv = (ImageView)convertView.findViewById(R.id.stamp_image);
            iv.setImageResource(img[position % img.length]);

            return convertView;
        }
    }

}
