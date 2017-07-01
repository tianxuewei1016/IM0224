package com.im0224.controller.activity;

import android.content.Intent;
import android.os.CountDownTimer;

import com.hyphenate.chat.EMClient;
import com.im0224.R;
import com.im0224.base.BaseActivity;

public class SplashActivity extends BaseActivity {


    private CountDownTimer countDownTimer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        //第一个参数是倒计时的总时长,倒计时时间的间隔
        countDownTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                //倒计时结束
                selectChageActivity();
            }
        }.start();
    }

    /**
     * 选择进入哪个界面
     */
    private void selectChageActivity() {
        new Thread(){
            public void run(){
                //是否登录过环信服务器
                boolean loggedInBefore = EMClient.getInstance().isLoggedInBefore();
                if(loggedInBefore) {
                    //登陆过
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }else{
                    //没有登陆过
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                }
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //取消倒计时
        countDownTimer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //执行耗时操作,因为第二个页面启动后才条用此方法
    }
}
