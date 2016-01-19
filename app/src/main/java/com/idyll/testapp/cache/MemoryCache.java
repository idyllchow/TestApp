package com.idyll.testapp.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * @author shibo
 * @packageName com.idyll.testapp.cacah
 * @description
 * @date 15/12/25
 */
public class MemoryCache implements ImageCache {

    private LruCache<String, Bitmap> mMemeryCache;

    public MemoryCache() {

    }

    @Override
    public Bitmap get(String url) {
        return mMemeryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bmp) {
        mMemeryCache.put(url, bmp);
    }
}
