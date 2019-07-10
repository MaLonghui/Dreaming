package dream.api.dmf.cn.dreaming.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dream.api.dmf.cn.dreaming.R;

public class RewardTiActivity extends AppCompatActivity {
    private TextView mTitle;
    private ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_ti);
        getInit();
    }
    //初始化控件
    private  void getInit(){
        mTitle =    findViewById(R.id.tv_title);
        mTitle.setText("积分提现");
        mTitle.setTextSize(18);
        mImage = findViewById(R.id.iv_back);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
