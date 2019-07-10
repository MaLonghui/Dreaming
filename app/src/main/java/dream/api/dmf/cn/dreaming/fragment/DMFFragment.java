package dream.api.dmf.cn.dreaming.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dream.api.dmf.cn.dreaming.R;
import dream.api.dmf.cn.dreaming.activity.moneyactivity.MoneyHCActivity;
import dream.api.dmf.cn.dreaming.activity.moneyactivity.MoneyHRActivity;
import dream.api.dmf.cn.dreaming.activity.moneyactivity.MoneyMLActivity;
import dream.api.dmf.cn.dreaming.activity.moneyactivity.MoneyQActivity;
import dream.api.dmf.cn.dreaming.activity.moneyactivity.MoneyZActivity;
import dream.api.dmf.cn.dreaming.activity.moneyactivity.MoneyluActivity;
import dream.api.dmf.cn.dreaming.api.UserApi;
import dream.api.dmf.cn.dreaming.base.BaseMvpFragment;
import dream.api.dmf.cn.dreaming.base.mvp.Contract;
import dream.api.dmf.cn.dreaming.base.mvp.presenter.presenter;


public class DMFFragment extends BaseMvpFragment<presenter> implements Contract.Iview {

    @BindView(R.id.m_money_zz)
    LinearLayout mMoneyZz;
    @BindView(R.id.m_money_lu)
    LinearLayout mMoneyLu;
    @BindView(R.id.m_money_qq)
    LinearLayout mMoneyQq;
    @BindView(R.id.m_money_r)
    LinearLayout mMoneyR;
    @BindView(R.id.m_money_c)
    LinearLayout mMoneyC;
    @BindView(R.id.m_money_q)
    LinearLayout mMoneyQ;
    Unbinder unbinder;
    Context context;
    public static Fragment newInstance() {
        DMFFragment fragment = new DMFFragment();
        if (DMFFragment.newInstance().equals("1")){
            //Toast.makeText(context,"dianwogansah",Toast.LENGTH_SHORT).show();
        }
        return fragment;
    }

 /*   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dmf, container, false);
        // Inflate the layout for this fragment

        return view;
    }*/
    @Override
    protected presenter createPresenter() {
        return new presenter();
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_dmf;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void getData() {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(UserApi.SP, Context.MODE_PRIVATE);
        String mDmf = sharedPreferences.getString(String.valueOf(UserApi.DMF), "");
        String mHyt = sharedPreferences.getString(String.valueOf(UserApi.HYT), "");

    }

    @Override
    public void getData(Object object) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.m_money_zz, R.id.m_money_lu, R.id.m_money_qq, R.id.m_money_r, R.id.m_money_c, R.id.m_money_q})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //转账
            case R.id.m_money_zz:
                startActivity(new Intent(getActivity(),MoneyZActivity.class));
                break;
            //交易记录
            case R.id.m_money_lu:
                startActivity(new Intent(getActivity(),MoneyluActivity.class));
                break;
            //钱包
            case R.id.m_money_qq:
                startActivity(new Intent(getActivity(),MoneyMLActivity.class));
                break;
             //HYT转入
            case R.id.m_money_r:
                startActivity(new Intent(getActivity(),MoneyHRActivity.class));
                break;
             //HYT转出
            case R.id.m_money_c:
                startActivity(new Intent(getActivity(),MoneyHCActivity.class));
                break;
            //金元转换
            case R.id.m_money_q:
                startActivity(new Intent(getActivity(),MoneyQActivity.class));
                break;
        }
    }
}
