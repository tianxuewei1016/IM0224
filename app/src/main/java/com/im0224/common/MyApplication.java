package com.im0224.common;

import android.app.Application;

import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;

/**
 * 作者：田学伟 on 2017/7/1 11:18
 * QQ：93226539
 * 作用：
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化环信
        initHXSdk();

        //初始化Modle类
        Modle.getInstance().getGlobalThread();
    }

    private void initHXSdk() {
        //配置文件
        EMOptions options = new EMOptions();
        //总是接受邀请
        options.setAcceptInvitationAlways(false);
        //自动接受群邀请
        options.setAutoAcceptGroupInvitation(false);
        //初始化SDK
        EaseUI.getInstance().init(this, options);

        
    }
}
