package dream.api.dmf.cn.dreaming.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dream.api.dmf.cn.dreaming.R;
import dream.api.dmf.cn.dreaming.activity.MoneyActivity;
import dream.api.dmf.cn.dreaming.api.UserApi;
import dream.api.dmf.cn.dreaming.base.BaseMvpFragment;
import dream.api.dmf.cn.dreaming.base.mvp.Contract;
import dream.api.dmf.cn.dreaming.base.mvp.presenter.presenter;
import dream.api.dmf.cn.dreaming.bean.IsLoginBean;
import dream.api.dmf.cn.dreaming.bean.TradingBean;
import dream.api.dmf.cn.dreaming.utils.LogUtils;
import dream.api.dmf.cn.dreaming.view.ChartView;

public class TradingFragment extends BaseMvpFragment<presenter> implements Contract.Iview {
    @BindView(R.id.r_butn)
    Button mButn;
    @BindView(R.id.r_butn2)
    Button mButn2;
    Unbinder unbinder;
    @BindView(R.id.r_oname)
    TextView mOname;
    @BindView(R.id.r_tname)
    TextView mTname;
    @BindView(R.id.spinner)
    AppCompatSpinner spinner;
    @BindView(R.id.ttt)
    TextView ttt;
    @BindView(R.id.t_newprice)
    TextView mNewprice;
    @BindView(R.id.t_addprice)
    TextView mAddprice;
    @BindView(R.id.h_newprice)
    TextView mhNewprice;
    @BindView(R.id.t_haddprice)
    TextView mHaddprice;
    private List<String> xValue = new ArrayList<>();
    //y轴坐标对应的数据
    private List<Integer> yValue = new ArrayList<>();
    //折线对应的数据
    private Map<String, Integer> value = new HashMap<>();
    private ChartView chartView;
    private TradingBean bean;
    private String ids = "1";
    private RecyclerView mRecy;
    private String tex;
    private String te;
    private IsLoginBean isLoginBean;
    private SharedPreferences sharedPreferences;
    private String teup;
    @Override
    protected presenter createPresenter() {
        return new presenter();
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_trading;
    }

    @Override
    protected void initView(View view) {
        chartView = view.findViewById(R.id.chartview);

        view.findViewById(R.id.ttt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MoneyActivity.class));
            }
        });
    }

    @Override
    protected void getData() {
        //getDa(ids);
        initData();
        HashMap<String, Object> headmap = new HashMap<>();
        HashMap<String, Object> map = new HashMap<>();
        sharedPreferences = mContext.getSharedPreferences(UserApi.SP, Context.MODE_PRIVATE);
        String mUid = sharedPreferences.getString(UserApi.Uid, "");
        String mShell = sharedPreferences.getString(UserApi.Shell, "");
        map.put("uid", mUid);
        map.put("shell", mShell);
        map.put("type", ids);
        mPresenter.postData(UserApi.getMoney, headmap, map, TradingBean.class);
        HashMap<String, Object> headm = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("uid", mUid);
        map2.put("shell", mShell);
        mPresenter.postData(UserApi.getIsLogin, headm, map2, IsLoginBean.class);

    }

    @Override
    public void getData(Object object) {
        LogUtils.v(object.toString());
        if (object instanceof TradingBean) {
            bean = (TradingBean) object;
            //Toast.makeText(mContext,bean.data.toString(),Toast.LENGTH_SHORT).show();
            // Toast.makeText(getActivity(), bean.data.toString(), Toast.LENGTH_SHORT).show();
        }
        if (object instanceof IsLoginBean) {
            isLoginBean = (IsLoginBean) object;
            mNewprice.setText(isLoginBean.dmf_day_price.today);
            mAddprice.setText(isLoginBean.dmf_day_price.updatemoney);
            mhNewprice.setText(isLoginBean.hyt_day_price.today);
            mHaddprice.setText(isLoginBean.hyt_day_price.updatemoney);
            // Gson gson=new Gson();
            //String jsonStr = gson.toJson(isLoginBean.hyt_day_price);
            tex=isLoginBean.dmf_day_price.yestoday;
            te=isLoginBean.dmf_day_price.today;
            teup= isLoginBean.dmf_day_price.updatemoney;
           sharedPreferences.edit().putString(UserApi.dmf_day_price, tex).commit();
           sharedPreferences.edit().putString(UserApi.dmf_day_Today, te).commit();
            sharedPreferences.edit().putString(UserApi.updatemoney,teup).commit();
            sharedPreferences.edit().putString(UserApi.DmfNUm, String.valueOf(isLoginBean.dmf_num)).commit();
            //sharedPreferences.edit().putString()
            //sharedPreferences.edit().putString(UserApi.dmf_day_price, tex);
            sharedPreferences.edit().putString(UserApi.dmf_day_Today, isLoginBean.dmf_day_price.today).commit();
            sharedPreferences.edit().putString(UserApi.updatemoney, isLoginBean.dmf_day_price.updatemoney).commit();
            sharedPreferences.edit().putString(UserApi.HYTT_PRICE, isLoginBean.hyt_day_price.today).commit();
            sharedPreferences.edit().putString(UserApi.DMFED, String.valueOf(isLoginBean.dmfed)).commit();
            sharedPreferences.edit().putString(UserApi.tdmf_num, String.valueOf(isLoginBean.tdmf_num)).commit();
            sharedPreferences.edit().putString(UserApi.STock_mdf,isLoginBean.balance_dmf).commit();
            //String Dmf= gson.toJson(isLoginBean.dmf_day_price);
            // sharedPreferences.edit().putString(UserApi.DMF_PRICE,Dmf);


        }
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

    @OnClick({R.id.r_butn, R.id.r_butn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.r_butn:
                mOname.setText("DMF");
                mOname.setTextSize(16);

                Intent intent = new Intent(getActivity(), MoneyActivity.class);
                intent.putExtra("name",tex);
                intent.putExtra("today",te);
                intent.putExtra("update",teup);
                intent.putExtra("uname", "1");
                startActivity(intent);
                break;
            case R.id.r_butn2:
                Intent intent2 = new Intent(getActivity(), MoneyActivity.class);
                intent2.putExtra("uname", "2");
                startActivity(intent2);
                break;
        }
    }

    public void initData() {
        //x轴坐标对应的数据


        for (int i = 0; i < 7; i++) {
            xValue.add((i + 1) + "天");
            value.put((i + 1) + "天", (int) (Math.random() * 181 + 60));//60--240
        }

        for (int i = 0; i < 6; i++) {
            yValue.add(i * 60);
        }

        chartView.setValue(value, xValue, yValue);
    }
    /*   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_trading, container, false);
        getData(view);
        initData();
        return view;
    }*/

/*

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_trading;
    }

    @Override
    protected void initView(View view) {
        mRecy = view.findViewById(R.id.t_recy);
        view.findViewById(R.id.ttt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MoneyActivity.class));
            }
        });
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecy.setLayoutManager(linearLayoutManager);
     */
/*   view.findViewById(R.id.spinner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MoneyActivity.class));
            }
        });*//*


     */
    /*   voidgetData(ids);*//*

     */
/*    HashMap<String,Object>headmap=new HashMap<>();
        HashMap<String,Object> map=new HashMap<>();
        ids="1";
        map.put("type",ids);
        mPresenter.postData(UserApi.getMoney,headmap,map,TradingBean.class);
        initData();
        String[] ctype = new String[]{"DMF七日折线图" ,"HYT七日折线图"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner = view.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        if ( ctype[0].equals("DMF七日折线图")){

            Toast.makeText(getActivity(),ids,Toast.LENGTH_SHORT).show();
            //getMoney(String ids)
            //mPresenter.postData(UserApi.getMoney,headmap,map,TradingBean.class);
            return;
        }else if (ctype[1].equals("HYT七日折线图")){
          *//*
     */
/*  HashMap<String,Object>headmap=new HashMap<>();
            HashMap<String,Object> map=new HashMap<>();*//*
     */
/*
            ids="2";
            map.put("type",ids);
            //mPresenter.postData(UserApi.getMoney,headmap,map,TradingBean.class);
        }*//*

    }
    @Override
    protected presenter createPresenter() {
        return new presenter();
    }


    @Override
    protected void getData() {
        voidgetData(ids);
    }
    @Override
    public void getData(Object object) {
        if (object instanceof TradingBean){
            TradingBean bean= (TradingBean) object;
            Toast.makeText(getActivity(),bean.toString(),Toast.LENGTH_SHORT).show();
        }

    }

   */
/* private void getMoney(String ids){
        RequestParams params=new RequestParams(UserApi.getMoney);
        params.addBodyParameter("type",ids);

    }
*//*

//    @Override
//    protected presenter createPresenter() {
//        return new presenter();
//    }

 */
/*   @Override
    protected int getFragmentView() {
        return R.layout.fragment_trading;
    }*//*

     */
/*
    @Override
    protected void initView(View view) {

       *//*
     */
/* chartView = view.findViewById(R.id.chartview);
        view.findViewById(R.id.ttt)
                .setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            //startActivity(new Intent(getActivity(), MoneyActivity.class));
                                        }
                                    }
                );*//*
     */
    /*

     *//*
     */
/*  if ( ctype[0].equals("DMF七日折线图")){
            ctype[0]="1";
        }else if (ctype[1].equals("HYT七日折线图")){
            ctype[1]="2";
        }*//*
     */
/*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner = view.findViewById(R.id.spinner);
       *//*
     */
/* spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), (int) id,Toast.LENGTH_SHORT).show();
            }
        });*//*
     */
/*

        spinner.setAdapter(adapter);
          if ( ctype[0].equals("DMF七日折线图")){
              HashMap<String,Object>headmap=new HashMap<>();
              HashMap<String,Object> map=new HashMap<>();
             ids="1";
             map.put("type",ids);
             Toast.makeText(mContext,ids,Toast.LENGTH_SHORT).show();
            mPresenter.postData(UserApi.getMoney,headmap,map,TradingBean.class);
            return;
        }else if (ctype[1].equals("HYT七日折线图")){
              HashMap<String,Object>headmap=new HashMap<>();
              HashMap<String,Object> map=new HashMap<>();
              ids="2";
              map.put("type",ids);
              mPresenter.postData(UserApi.getMoney,headmap,map,TradingBean.class);
        }

    }

    @Override
    protected void getData() {
        initData();


    }

 *//*
     */
/*   @Override
    public void getData(Object object) {
        if (object instanceof TradingBean){
            TradingBean bean= (TradingBean) object;
            if (bean.error.equals("0")){
                Toast.makeText(mContext,"成功",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(mContext,bean.error,Toast.LENGTH_SHORT).show();
            }

        }
    }*//*

 private void  voidgetData(String ids){
     RequestParams params = new RequestParams(UserApi.getMoney);
     params.addBodyParameter("type",ids);
     LogUtils.v(ids);
     x.http().post(params, new org.xutils.common.Callback.CacheCallback<String>() {

         @Override
         public void onSuccess(String result) {
             Gson gson=new Gson();
             bean = gson.fromJson(result, TradingBean.class);
             Toast.makeText(getActivity(), bean.data.toString(),Toast.LENGTH_SHORT).show();
         }
        */
/* private void parseResult(String result) {


         }*//*


         @Override
         public void onError(Throwable ex, boolean isOnCallback) {
             Toast.makeText(getActivity(), bean.data.toString(),Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onCancelled(CancelledException cex) {

         }

         @Override
         public void onFinished() {

         }

         @Override
         public boolean onCache(String result) {
             return false;
         }
     });
 }


*/


}
