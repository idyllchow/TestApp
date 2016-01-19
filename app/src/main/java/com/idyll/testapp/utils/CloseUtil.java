package com.idyll.testapp.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author shibo
 * @packageName com.idyll.testapp.utils
 * @description
 * @date 15/12/25
 */
public class CloseUtil {

    private CloseUtil() {}

    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
