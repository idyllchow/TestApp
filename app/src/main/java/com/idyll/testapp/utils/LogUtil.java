package com.idyll.testapp.utils;

import android.os.Environment;
import android.util.Log;


public class LogUtil {
    private static final boolean DEBUG = true;

    /**
     * 默认tag
     */
    private static String defaultTag = "Sponia";
    /**
     * 是否需要将日志输出至文件中存储
     */
    private static boolean isLogRecord = true;

    /**
     * 日志信息存储路径
     */
    private static String logPath = Environment.getExternalStorageDirectory()+ "/OpenPlay/stats/log/log.txt";

    public static String getDefaultTag() {
        return defaultTag;
    }

    public static void setDefaultTag(String defaultTag) {
        LogUtil.defaultTag = defaultTag;
    }

    public static boolean isLogRecord() {
        return isLogRecord;
    }

    public static void setIsLogRecord(boolean isLogRecord) {
        LogUtil.isLogRecord = isLogRecord;
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    /**
     * 使用Sponia作为Tag输出日志
     * @param msg
     */
    public static final void defaultLog(String msg) {
        if (DEBUG) {
            Log.d(getDefaultTag(), msg);
        }
    }




}
