package com.sponia.idyll.testapp.cache;

import android.graphics.Bitmap;

import com.sponia.idyll.testapp.utils.CloseUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author shibo
 * @packageName com.sponia.idyll.testapp.cache
 * @description
 * @date 15/12/25
 */
public class DiskCache implements ImageCache {

    static String cacheDir = "";

    @Override
    public Bitmap get(String url) {
        //从本地文件中获取图片
        return null;
    }

    @Override
    public void put(String url, Bitmap bmp) {
        //将bitmap写入文件中
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.closeQuietly(fileOutputStream);
        }

    }
}
