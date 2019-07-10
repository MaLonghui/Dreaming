package dream.api.dmf.cn.dreaming.api;

public class UserApi
{
    public static final String BASE_URL="http://api.xg360.cc/";
    //登陆接口
    public static final String getLogin = "index.php?mod=mobile&act=login";
    //注册
    public static final String getRegst="http://api.xg360.cc/index.php?mod=member&act=register";
    //忘记
    public static final String getForget="http://api.xg360.cc/index.php?mod=member&act=forgot";
    //商城接口
    public static final String getShopList="https://shop.xg360.cc/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=news.login&mobile=";
    //钱包
    public static final String getMoney =BASE_URL+"index.php?mod=mobile&act=chart";
    //islogin
    public static final String getIsLogin=BASE_URL+"index.php?mod=mobile&act=islogin";
    //额度买入
    public static final String getMRBUG="index.php?mod=mobile&act=trade_sell";
    //额度卖出
    public static final String getMCSell="index.php?mod=mobile&act=trade_buy";
    //完善收款信息
    public static final String getSKNew="index.php?mod=mobile&act=profile";
    //交易大厅
    public static final String getBigShow="index.php?mod=mobile&act=gettradebox";
    //交易大厅卖出
    public static final String  getBIGSell="index.php?mod=mobile&act=sell_dmf_trade2";
    //交易大厅买入
    public static final String getBIGBug="index.php?mod=mobile&act=buy_stock_trade2";
    //卖出HYTB
    public static final String getBigHSell="index.php?mod=mobile&act=trade_buy2";
    //买入HYTB
    public static final String getBIGHBug="index.php?mod=mobile&act=trade_sell2";
    //判断是否
    //购物车
    public static final String getShop="https://shop.xg360.cc/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.cart";
    //收货地址
    public static final String getADDRESS="https://shop.xg360.cc/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.address";
    //网络图谱
    public static final String getPU="https://shop.xg360.cc/addons/ewei_shopv2/template/mobile/default/notice/member-info.html";
    public static final String SP = "SP";
    public static final String TrueName = "TrueName";
    public static final String Groupname_cn = "Groupname_cn";
    public static final String UserName = "UserName";
    public static final String Shell = "Shell";
    public static final String Uid = "Uid";
    public static final String _UUID = "_UUID";
    public static final String IDCard = "IDCard";
    public static final String dmf_day_price = "dmf_day_price";
    public static final String dmf_day_Today="today";
    public static final String updatemoney="updatemoney";
    public static final String DMFED="dmfed";
    public static final String HYTT_PRICE = "HYTT_PRICE";
    public static final String DMF_PRICE = "DMF_PRICE";
    public static final String PhoneCode = "PhoneCode";
    public static final String DmfNUm="dmf_num";
    public static final String tdmf_num="tdmf_num";
    public static final String STock_mdf="stock_mdf";
    public static final String INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result";
    public static final int REQ_QR_CODE = 11002; // // 打开扫描界面请求码
    public static final int REQ_PERM_CAMERA = 11003; // 打开摄像头
    public static final int REQ_PERM_EXTERNAL_STORAGE = 11004; // 读写文件
    public static final int REQUEST_CODE_SCAN_GALLERY = 1; // 读写文件
    public static final int DMF=1;
    public static final int HYT=2;

}
