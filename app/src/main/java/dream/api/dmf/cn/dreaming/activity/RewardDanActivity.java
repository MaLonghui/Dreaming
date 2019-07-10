package dream.api.dmf.cn.dreaming.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.Unbinder;
import dream.api.dmf.cn.dreaming.R;

public class RewardDanActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView mTitle;
    @BindView(R.id.iv_back)
    ImageView mBack;
    Unbinder unbinder;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        View view = View.inflate(this, R.layout.activity_reward_dan, null);
        mTitle.setText("推荐清单");
        mTitle.setTextSize(18);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        return view;
    }


}
