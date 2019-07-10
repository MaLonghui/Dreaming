package dream.api.dmf.cn.dreaming.fragment.bigfragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

import dream.api.dmf.cn.dreaming.R;
import dream.api.dmf.cn.dreaming.adapter.BigSellAdapter;
import dream.api.dmf.cn.dreaming.api.UserApi;
import dream.api.dmf.cn.dreaming.base.BaseMvpFragment;
import dream.api.dmf.cn.dreaming.base.mvp.Contract;
import dream.api.dmf.cn.dreaming.base.mvp.presenter.presenter;
import dream.api.dmf.cn.dreaming.bean.BigBean;

public class BigSellFragment extends BaseMvpFragment<presenter> implements Contract.Iview {

    private RecyclerView mRecy;
    private RecyclerView mRecyt;
    private String mUid;
    private String mShell;
    private BigBean bigBean;
    private String  t="0";
    private String type="1";
    private List<BigBean.DataBean> data;
    private RecyclerView mRecy1;

    public static Fragment newInstance() {
        BigSellFragment fragment = new BigSellFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_big_sell, container, false);
        mRecy1 = view.findViewById(R.id.recyo);
        mRecyt = view.findViewById(R.id.recyt);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(UserApi.SP, Context.MODE_PRIVATE);
        mUid = sharedPreferences.getString(UserApi.Uid, "");
        mShell = sharedPreferences.getString(UserApi.Shell, "");
       return view;
    }

    @Override
    protected presenter createPresenter() {
        return new presenter();
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_big_sell;
    }

    @Override
    protected void initView(View view) {


        LinearLayoutManager manager=new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecy1.setLayoutManager(manager);
        mRecyt.setLayoutManager(manager);


    }

    @Override
    protected void getData() {
        HashMap<String,Object> headmap=new HashMap<>();
        HashMap<String,Object> map=new HashMap<>();
        map.put("t",t);
        map.put("type",type);
        map.put("uid",mUid);
        map.put("shell",mShell);
        mPresenter.postData(UserApi.getBigShow,headmap,map,BigBean.class);
        BigSellAdapter bigSellAdapter=new BigSellAdapter(mContext,data);
        mRecy1.setAdapter(bigSellAdapter);
        //mPresenter.postData(UserApi.getBigShow,headmap,map,BigBean.class);

    }

    @Override
    public void getData(Object object) {
        //LogUtils.v(object+"");
        if (object instanceof BigBean){
           BigBean bigBean = (BigBean) object;
            data = bigBean.data;
            //Toast.makeText(mContext,bigBean.getId(),Toast.LENGTH_SHORT).show();


        }
    }
}
