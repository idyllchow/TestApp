package com.sponia.idyll.testapp.cache;

import android.graphics.Bitmap;

/**
 * @author shibo
 * @packageName com.sponia.idyll.testapp.cache
 * @description
 * @date 15/12/25
 */
public class DoubleCache implements ImageCache {

    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDiskCache = new DiskCache();


    @Override
    public Bitmap get(String url) {
        //先从内存中获取图片,如果没有,再从SD卡中获取
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
                return bitmap;
    }

    @Override
    public void put(String url, Bitmap bmp) {
    //将图片换存到内存和sd卡中
        mMemoryCache.put(url, bmp);
        mDiskCache.put(url, bmp);

    }
}
