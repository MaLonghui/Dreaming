package dream.api.dmf.cn.dreaming.activity.mineactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dream.api.dmf.cn.dreaming.R;
import dream.api.dmf.cn.dreaming.api.UserApi;
import dream.api.dmf.cn.dreaming.app.MyApp;

public class SetActivity extends AppCompatActivity {

    private TextView mtitle;
    private ImageView mBack;
    private TextView mBa;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        mtitle = findViewById(R.id.tv_title);
        mtitle.setText("设置");
        mtitle.setTextSize(18);
        sharedPreferences = getSharedPreferences(UserApi.SP, MODE_PRIVATE);
        mBack = findViewById(R.id.iv_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBa = findViewById(R.id.tv_exit);
        mBa.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          sharedPreferences.edit().clear().commit();
                                          MyApp.getInstance().exit();
                                      }
                                  }
        );
    }
}
