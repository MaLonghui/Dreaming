package dream.api.dmf.cn.dreaming.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dream.api.dmf.cn.dreaming.R;
import dream.api.dmf.cn.dreaming.api.UserApi;
import dream.api.dmf.cn.dreaming.base.BaseMvpFragment;
import dream.api.dmf.cn.dreaming.base.mvp.Contract;
import dream.api.dmf.cn.dreaming.base.mvp.presenter.presenter;
import dream.api.dmf.cn.dreaming.utils.BankDialog;
import dream.api.dmf.cn.dreaming.utils.BuyNumDialog;

public class SellFragment extends BaseMvpFragment<presenter> implements Contract.Iview {

    Unbinder unbinder;
    @BindView(R.id.s_edsell)
    TextView sEdsell;
    @BindView(R.id.s_price)
    TextView sPrice;
    @BindView(R.id.ss_num)
    TextView ssNum;
    @BindView(R.id.s_nump)
    TextView sNump;
    @BindView(R.id.s_banck)
    TextView sBanck;
    @BindView(R.id.s_num)
    TextView sNum;
    @BindView(R.id.s_rpass)
    EditText sRpass;
    @BindView(R.id.login_exe)
    CheckBox loginExe;
    @BindView(R.id.s_butn)
    Button sButn;
    Unbinder unbinder1;
    /*   TextView sNums;*/
    private String dmfday;
    private String nums;
    private List<String> numList;
    private List list;
    private String mEd;
    private String mUid;
    private String mShell;
    private String mEdx;
    private TextView mPrice;
    HashMap<String, Object> headmap = new HashMap<>();
    HashMap<String, Object> map = new HashMap<>();
    private TextView sNums;

    @Override
    protected presenter createPresenter() {
        return new presenter();
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_sell;
    }

    @Override
    protected void initView(View view) {
        mPrice = view.findViewById(R.id.s_price);
     /*   sNums = view.findViewById(R.id.ss_num);*/

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(UserApi.SP, Context.MODE_PRIVATE);
        dmfday = sharedPreferences.getString(UserApi.dmf_day_Today, "");
        mUid = sharedPreferences.getString(UserApi.Uid, "");
        mShell = sharedPreferences.getString(UserApi.Shell, "");
        mEd = sharedPreferences.getString(UserApi.DMFED, "");
        nums = sharedPreferences.getString(UserApi.DmfNUm, "");
        String[] splitNums = nums.substring(1, nums.length() - 1).replace("\"", "").split(",");
        numList = Arrays.asList(splitNums);
        list = Arrays.asList(getResources().getStringArray(R.array.bank));
    }

    @Override
    protected void getData() {
        mPrice.setText(dmfday);

        ssNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               // new BuyNumDialog(mContext, numList, sNums);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Toast.makeText(mContext, "111111111", Toast.LENGTH_SHORT).show();
                 //String mNum = ssNum.getText().toString();
               // sNump.setText(Double.parseDouble(mEd) * Double.parseDouble(String.valueOf(ssNum)) + "");
               // sNum.setText((Double.parseDouble(mNum) * Double.parseDouble(dmfday) + (Double.parseDouble(mEd) * Double.parseDouble(String.valueOf(mNum))) + ""));*/
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //sEdsell.setText(mEdx);
    }

    @Override
    public void getData(Object object) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        //unbinder = ButterKnife.bind(this, rootView);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
        unbinder1.unbind();
    }

    @OnClick({ R.id.ss_num, R.id.s_nump, R.id.s_banck, R.id.s_num, R.id.s_rpass, R.id.login_exe, R.id.s_edsell, R.id.s_butn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ss_num:
                new BuyNumDialog(mContext, numList, ssNum);
                //Toast.makeText(mContext, "111111111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.s_nump:
                break;
            case R.id.s_banck:
                new BankDialog(mContext, list, sBanck);
                break;
            case R.id.s_num:
                break;
            case R.id.s_rpass:
                break;
            case R.id.login_exe:
                break;
            case R.id.s_edsell:
                break;
            case R.id.s_butn:
                break;
        }
    }

  /*  @OnClick({R.id.ss_num, R.id.s_banck, R.id.s_num, R.id.login_exe, R.id.s_butn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ss_num:


                break;
            case R.id.s_banck:
                //new BankDialog(mContext, list, sBanck);
                break;
            //收款
            case R.id.s_num:

                break;
            //小眼睛
            case R.id.login_exe:

                break;
            //卖出
            case R.id.s_butn:

             *//*   String mNum = sNums.getText().toString();
                sNump.setText(Double.parseDouble(mEd) * Double.parseDouble(mNum) + "");
                sNum.setText((Double.parseDouble(mNum) * Double.parseDouble(dmfday) + (Double.parseDouble(mEd) * Double.parseDouble(mNum)) + ""));*//*
               // String mPhone = sRpass.getText().toString().trim();
                map.put("uid", mUid);
                map.put("shell", mShell);
                *//*  map.put("   ")*//*
     *//*  mPresenter.postData(UserApi.getMCSell,);*//*
                break;
        }
    }*/
}
