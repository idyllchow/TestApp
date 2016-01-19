package com.idyll.testapp.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shibo
 * @packageName com.idyll.testapp.cacah
 * @description
 * @date 15/12/24
 */
public class ImageLoader {
    //图片缓存
    ImageCache mImageCache = new MemoryCache();
    //线程池,线程数量为cpu数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    //注入缓存实现
    public void setImageCache(ImageCache cache) {
        mImageCache = cache;
    }

    //加载图片
    public void displayImage(final String imageUrl, final ImageView imageView) {
        Bitmap bitmap = mImageCache.get(imageUrl);
//        if (bitmap != null) {
//            imageView.setImageBitmap(bitmap);
//            return;
//        }
//        //如果没缓存,提交到线程池下载
//        submitLoadRequest(imageUrl, imageView);

        if (bitmap == null) {
            //异步下载图片
            //downloadImageAsync(imageUrl, imageView);
            submitLoadRequest(imageUrl, imageView);
        } else {
            imageView.setImageBitmap(bitmap);
        }
    }

    private void submitLoadRequest(final String imageUrl, final ImageView imageView) {
        imageView.setTag(imageUrl);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(imageUrl);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(imageUrl)) {
                    imageView.setImageBitmap(bitmap);
                }
                mImageCache.put(imageUrl, bitmap);
            }
        });
    }

    public Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
