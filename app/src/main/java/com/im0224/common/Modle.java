package com.im0224.common;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者：田学伟 on 2017/7/1 14:08
 * QQ：93226539
 * 作用：
 */

public class Modle {

    private Modle() {
    }

    private Context context;
    private static Modle modle = new Modle();

    public static Modle getInstance() {
        return modle;
    }

    public void init(Context context) {
        this.context = context;
    }

    private ExecutorService service = Executors.newCachedThreadPool();

    public ExecutorService getGlobalThread() {
        return service;
    }
}
