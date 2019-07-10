package dream.api.dmf.cn.dreaming.activity.mineactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dream.api.dmf.cn.dreaming.R;

public class ShareActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView mTitle;
    @BindView(R.id.iv_back)
    ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        ButterKnife.bind(this);
        mTitle.setText("客服中心");
        mTitle.setTextSize(18);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
