package dream.api.dmf.cn.dreaming.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.text.SimpleDateFormat;
import java.util.Date;

import dream.api.dmf.cn.dreaming.R;
import dream.api.dmf.cn.dreaming.api.UserApi;
import dream.api.dmf.cn.dreaming.utils.MD5Utils;

/**
 * 商城
 */
public class CenterFragment extends Fragment {

    private WebView webView;
    private String username;
    private String mTime;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.fragment_center,null);
        webView = view.findViewById(R.id.c_web);
        getDate();
        return view;

    }
    private void getDate(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(UserApi.SP, Context.MODE_PRIVATE);
        username = sharedPreferences.getString(UserApi.UserName, "");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        //mTime = formatter.format(curDate);
        long timeStamp = System.currentTimeMillis();
        //String mTime = stampToDate(timeStamp);
        String token = MD5Utils.MD5(UserApi.UserName+"a85GhBeA73J3"+timeStamp);

        webView.loadUrl("https://shop.xg360.cc/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=news.login&mobile=" + username + "&tokent=" + token + "&time=" + timeStamp);
    }
    /* private WebView webView;
    private String mUid;
    private String mShell;
    private String username;
    private Dialog loadingDialog;
    private String mTime;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.fragment_center,null);
        webView = view.findViewById(R.id.c_web);
        return view;
    }
    *//* @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        return super.onCreateView(name, context, attrs);

    }*//*


  *//*  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_center, container, false);
        return view;
    }*//*

   *//* @Override
    protected presenter createPresenter() {
        return new presenter();
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_center;
    }

    @Override
    protected void initView(View view) {
        webView = view.findViewById(R.id.c_web);
    }


        *//**//**
         * https://shop.xg360.cc/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=news.login&mobile=username&token=token&time=str
         *//**//*

        *//**//**
         * let token = (Login.username + "a85GhBeA73J3" + "\(timeStamp)").MD5
         *         let url = "https://shop.xg360.cc/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=news.login&mobile=" + Login.username + "&token=" + token + "&time=" + "\(timeStamp)"
         *//**//*

      *//**//*  if (username !=""){
            Map<String,String> map=new HashMap<>();
            map.put("mobile",username);
            map.put("shell",mShell);



            //let token =;
        }
*//**//*
      *//**//*  mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });
         String url =
          "https://shop.xg360.cc/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=news.login&mobile=" + Login.username + "&token=" + token + "&time=" + "\(timeStamp)"
        mTitle.setText("注册");
        mTitle.setTextSize(18);*//**//*
    }

    @Override
    public void getData(Object object) {

    }*//*

    protected void getData() {


        //webView.loadUrl(UserApi.getShopList);
        //所有的请求在本地webview打开
        //String token = (UserApi.username + "a85GhBeA73J3" + "\(timeStamp)").MD5\;
       *//* webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);

                // view.loadUrl(url);
                //return true;
                //请求连接
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //开始加载连接
                // dialog.show();
                loadingDialog = WeiboDialogUtils.createLoadingDialog(CenterFragment.this, "正在努力加载中……");

                *//**//* let token = (Login.username + "a85GhBeA73J3" + "\(timeStamp)").MD5
                                let url = "https://shop.xg360.cc/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=news.login&mobile=" + Login.username + "&token=" + token + "&time=" + "\(timeStamp)"


                //showProgressLayer("", "");*//**//*


            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null); //禁止硬件加速
                //加载结束
                loadingDialog.dismiss();
                // mProgressDialog.dismiss();

            }*//*

     *//*   });*//*

    }
//    public String stampToDate(long timeMillis){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date(timeMillis);
//        return simpleDateFormat.format(date);
//    }
*/
}
