package dream.api.dmf.cn.dreaming.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dream.api.dmf.cn.dreaming.R;
import dream.api.dmf.cn.dreaming.api.UserApi;

public class MoneyFragment extends Fragment {

    private RadioGroup mGroup;
    private RadioButton mButton1,mButton2;
    private ViewPager mPage;
    private ArrayList<Fragment> list;
    private List mHytlist;
    private Button mUpMoney;

    public static Fragment newInstance() {
        MoneyFragment fragment = new MoneyFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.fragment_money,null);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(UserApi.SP, Context.MODE_PRIVATE);
        TextView mYesDay = view.findViewById(R.id.yesteday);
        TextView mToDay = view.findViewById(R.id.today);
        mUpMoney = view.findViewById(R.id.updatemoney);
        String name = sharedPreferences.getString(UserApi.dmf_day_price, "");
        //sharedPreferences.getString("")
        // String yedprice = sharedPreferences.getString(UserApi.dmf_day_price, "");
        //String dmfprice = sharedPreferences.getString("name");
       // Log.i("aaaaaaaa",dmfprice);

        String dmfday = sharedPreferences.getString(UserApi.dmf_day_Today, "");
        Log.i("aaaaaaaa",dmfday);
        String updatep = sharedPreferences.getString(UserApi.updatemoney, "");
        Log.i("aaaaaaaa",updatep);
       /* sharedPreferences.edit().putString(UserApi.dmf_day_price, isLoginBean.dmf_day_price.yestoday);
        sharedPreferences.edit().putString(UserApi.dmf_day_Today, isLoginBean.dmf_day_price.today);
        sharedPreferences.edit().putString(UserApi.updatemoney, isLoginBean.dmf_day_price.updatemoney);*/
        mYesDay.setText(name);
        mToDay.setText(dmfday);
        mUpMoney.setText(updatep);
        //sharedPreferences.getString(UserApi.)
        // String mHyt = sharedPreferences.getString(UserApi.HYT_PRICE, "");
        //double v = Double.parseDouble(mHyt);
        //mYesDay.setText();
        //double mHt = Double.parseDouble(mHyt);
        //double mHt = Double.parseDouble(mHyt);
       // String mHTyt = sharedPreferences.getString(UserApi.HYTT_PRICE, "");
        //Log.i("aaaaaaa",mHTyt);
     /*   if (mHyt!=""){
            Gson gson=new Gson();
            mHytlist = gson.fromJson(mHyt, new TypeToken<List<IsLoginBean.HytDayPriceBean>>() {
            }.getType());
            Toast.makeText(getActivity(),mHytlist.toString(),Toast.LENGTH_SHORT).show();*/

           // mToDay.setText(mHTyt);
           // mUpMoney.setText(((IsLoginBean.HytDayPriceBean) mHytlist).updatemoney);
           /* if (mHytlist instanceof IsLoginBean.HytDayPriceBean){

            }*/

        //String Mdmf = sharedPreferences.getString(UserApi.DMF_PRICE, "");
        mGroup = view.findViewById(R.id.tGroup);
        mButton1 = view.findViewById(R.id.m_button1);
        mButton2 = view.findViewById(R.id.m_button2);
        mPage = view.findViewById(R.id.m_pager);
        initdata();
        //String myeday = sharedPreferences.getString(, "");
       // mYesDay.setText(myeday);
        return view;
    }
    protected void initdata() {
        list = new ArrayList<>();
        SellFragment frag_01=new SellFragment();
        BuyFragment frag_02=new BuyFragment();
        list.add(frag_01);
        list.add(frag_02);
        mPage.setAdapter(new FragmentPagerAdapter(this.getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mGroup.check(mGroup.getChildAt(0).getId());
        mPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mGroup.check(mGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.m_button1:
                        mPage.setCurrentItem(0);
                        break;
                    case R.id.m_button2:
                        mPage.setCurrentItem(1);
                        break;

                }
            }
        });

    }
}
