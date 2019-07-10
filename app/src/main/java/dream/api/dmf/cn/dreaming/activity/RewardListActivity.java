package dream.api.dmf.cn.dreaming.activity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dream.api.dmf.cn.dreaming.R;

public class RewardListActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.r_left)
    TextView mLeft;
    @BindView(R.id.r_left_time)
    TextView mLeftTime;
    @BindView(R.id.r_right_time)
    TextView mRightTime;
    @BindView(R.id.r_right)
    TextView mRight;
    private TextView mTitle, mNew;
    private ImageView mBack;
    private Button mNButn;
    private TimePickerView pvTime,mTime;
    private  boolean m= true;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_list);
        ButterKnife.bind(this);
        initView();
        initTimePicker();
        initTime();
        getWindow().setEnterTransition(new Fade().setDuration(2000));
        mTitle.setText("奖励列表");
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

   /* @Override
    public int getLayoutResId() {
        return R.layout.activity_reward_list;
    }*/

    //初始化控件
    public void initView() {
        mTitle = findViewById(R.id.tv_title);
        mBack = findViewById(R.id.iv_back);
        mNew = findViewById(R.id.r_listnew);
        mNButn = findViewById(R.id.r_lin_butn);
        mNButn.setOnClickListener(this);
        Calendar selectedDate = Calendar.getInstance();//用来设置默认选中的日期
        Calendar startDate = Calendar.getInstance();
        startDate.set(2013,1,1);//用来设置起始日期

        Calendar endDate = Calendar.getInstance();
        endDate.set(2020,1,1);//用来设置终止日期

    }

 /*   @Override
    public void initData() {

    }
*/
  /*  @Override
    public void initListener() {

    }
*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.r_lin_butn:
                if (pvTime != null) {
                    pvTime.show(v);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                }
                break;
        }
    }

    private void initTimePicker() {//Dialog 模式下，在底部弹出

        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                mNew.setText(getTime(date));

                Log.i("pvTime", "onTimeSelect");

            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                }).setType(new boolean[]{true, true, false, false, false, false}) //年月日时分秒 的显示与否，不设置则默认全部显示
                .setLabel("年", "月", "", "", "", "")//默认设置为年月日时分秒

                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .build();

        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
            }
        }
    }

    private void initTime() {//Dialog 模式下，在底部弹出

        mTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                if (m==true){
                    mLeftTime.setText(getTime(date));
                }else{
                    mRightTime.setText(getTime(date));
                }

                Log.i("pvTime", "onTimeSelect");

            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                }).setType(new boolean[]{true, true, false, false, false, false}) //年月日时分秒 的显示与否，不设置则默认全部显示
                .setLabel("年", "月", "", "", "", "")//默认设置为年月日时分秒
                // .setRangDate(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .build();

        Dialog mDialog = mTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            mTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
            }
        }
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }
    private String getTime2(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    @OnClick({R.id.r_left, R.id.r_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.r_left:
                m=true;
                if (mTime != null) {
                    mTime.show(view);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                }
                break;
            case R.id.r_right:
                m=false;
                if (mTime != null) {
                    mTime.show(view);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                }
                break;
        }
    }

}
