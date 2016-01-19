package com.sponia.idyll.testapp.cache;

import android.graphics.Bitmap;

/**
 * @author shibo
 * @packageName com.sponia.idyll.testapp.cacah
 * @description
 * @date 15/12/25
 */
public interface ImageCache {

    public Bitmap get(String url);
    public void put(String url, Bitmap bmp);

}
