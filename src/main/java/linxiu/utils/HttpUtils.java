package linxiu.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * http请求工具�?
 * Created by wangfan on 2018-12-14 上午 8:38.
 */
public class HttpUtils {

    /**
     * get请求
     *
     * @param url
     * @param params 请求参数
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        return get(url, params, null);
    }

    /**
     * get请求
     *
     * @param url
     * @param params  请求参数
     * @param headers 请求�?
     * @return
     */
    public static String get(String url, Map<String, String> params, Map<String, String> headers) {
        return request(mapToString(url, params, "?"), null, headers, "GET");
    }

    /**
     * 异步get请求
     *
     * @param url
     * @param params       请求参数
     * @param onHttpResult 请求回调
     * @return
     */
    public static void getAsyn(String url, Map<String, String> params, OnHttpResult onHttpResult) {
        getAsyn(url, params, null, onHttpResult);
    }

    /**
     * 异步get请求
     *
     * @param url
     * @param params       请求参数
     * @param headers      请求�?
     * @param onHttpResult 请求回调
     * @return
     */
    public static void getAsyn(String url, Map<String, String> params, Map<String, String> headers, OnHttpResult onHttpResult) {
        requestAsyn(mapToString(url, params, "?"), null, headers, "GET", onHttpResult);
    }

    /**
     * post请求
     *
     * @param url
     * @param params 请求参数
     * @return
     */
    public static String post(String url, Map<String, String> params) {
        return post(url, params, null);
    }

    /**
     * post请求
     *
     * @param url
     * @param params  请求参数
     * @param headers 请求�?
     * @return
     */
    public static String post(String url, Map<String, String> params, Map<String, String> headers) {
        return request(url, mapToString(null, params, null), headers, "POST");
    }

    /**
     * 异步post请求
     *
     * @param url
     * @param params 请求参数
     * @return
     */
    public static void postAsyn(String url, Map<String, String> params, OnHttpResult onHttpResult) {
        postAsyn(url, params, null, onHttpResult);
    }

    /**
     * 异步post请求
     *
     * @param url
     * @param params  请求参数
     * @param headers 请求�?
     * @return
     */
    public static void postAsyn(String url, Map<String, String> params, Map<String, String> headers, OnHttpResult onHttpResult) {
        requestAsyn(url, mapToString(null, params, null), headers, "POST", onHttpResult);
    }

    /**
     * put请求
     *
     * @param url
     * @param params 请求参数
     * @return
     */
    public static String put(String url, Map<String, String> params) {
        return put(url, params, null);
    }

    /**
     * put请求
     *
     * @param url
     * @param params  请求参数
     * @param headers 请求�?
     * @return
     */
    public static String put(String url, Map<String, String> params, Map<String, String> headers) {
        return request(url, mapToString(null, params, null), headers, "PUT");
    }

    /**
     * 异步put请求
     *
     * @param url
     * @param params 请求参数
     * @return
     */
    public static void putAsyn(String url, Map<String, String> params, OnHttpResult onHttpResult) {
        putAsyn(url, params, null, onHttpResult);
    }

    /**
     * 异步put请求
     *
     * @param url
     * @param params  请求参数
     * @param headers 请求�?
     * @return
     */
    public static void putAsyn(String url, Map<String, String> params, Map<String, String> headers, OnHttpResult onHttpResult) {
        requestAsyn(url, mapToString(null, params, null), headers, "PUT", onHttpResult);
    }

    /**
     * delete请求
     *
     * @param url
     * @param params 请求参数
     * @return
     */
    public static String delete(String url, Map<String, String> params) {
        return delete(url, params, null);
    }

    /**
     * delete请求
     *
     * @param url
     * @param params  请求参数
     * @param headers 请求�?
     * @return
     */
    public static String delete(String url, Map<String, String> params, Map<String, String> headers) {
        return request(mapToString(url, params, "?"), null, headers, "DELETE");
    }

    /**
     * 异步delete请求
     *
     * @param url
     * @param params 请求参数
     * @return
     */
    public static void deleteAsyn(String url, Map<String, String> params, OnHttpResult onHttpResult) {
        deleteAsyn(url, params, null, onHttpResult);
    }

    /**
     * 异步delete请求
     *
     * @param url
     * @param params  请求参数
     * @param headers 请求�?
     * @return
     */
    public static void deleteAsyn(String url, Map<String, String> params, Map<String, String> headers, OnHttpResult onHttpResult) {
        requestAsyn(mapToString(url, params, "?"), null, headers, "DELETE", onHttpResult);
    }

    /**
     * 表单请求
     *
     * @param url
     * @param params  请求参数
     * @param headers 请求�?
     * @param method  请求方式
     * @return
     */
    public static String request(String url, String params, Map<String, String> headers, String method) {
        return request(url, params, headers, method, "application/x-www-form-urlencoded");
    }

    /**
     * http请求
     *
     * @param url
     * @param params    请求参数
     * @param headers   请求�?
     * @param method    请求方式
     * @param mediaType 参数类型,application/json,application/x-www-form-urlencoded
     * @return
     */
    public static String request(String url, String params, Map<String, String> headers, String method, String mediaType) {
        String result = null;
        if (url == null || url.trim().isEmpty()) {
            return null;
        }
        method = method.toUpperCase();
        OutputStreamWriter writer = null;
        BufferedReader in = null;
        ByteArrayOutputStream resOut = null;
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            if (method.equals("POST") || method.equals("PUT")) {
                conn.setDoOutput(true);
                conn.setUseCaches(false);
            }
            conn.setReadTimeout(8000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod(method);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type", mediaType);
            // 添加请求�?
            if (headers != null) {
                Iterator<String> iterator = headers.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    conn.setRequestProperty(key, headers.get(key));
                }
            }
            // 添加参数
            if (params != null) {
                conn.setRequestProperty("Content-Length", String.valueOf(params.length()));
                writer = new OutputStreamWriter(conn.getOutputStream());
                writer.write(params);
                writer.flush();
            }
            // 判断连接状�??
            if (conn.getResponseCode() >= 300) {
                throw new RuntimeException("HTTP Request is not success, Response code is " + conn.getResponseCode());
            }
            // 获取返回数据
            StringBuffer sb = new StringBuffer("");  
            InputStream input = conn.getInputStream();
            in = new BufferedReader(new InputStreamReader(input, "utf-8"));  
            String line = "";  
            while ((line = in.readLine()) != null){  
            	sb.append(line+System.lineSeparator());  
            }  
            result = sb.toString();
            // 断开连接
            conn.disconnect();
            in.close();
            input.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (resOut != null) {
                try {
                    resOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 异步表单请求
     *
     * @param url
     * @param params       请求参数
     * @param headers      请求�?
     * @param method       请求方式
     * @param onHttpResult 请求回调
     * @return
     */
    public static void requestAsyn(String url, String params, Map<String, String> headers, String method, OnHttpResult onHttpResult) {
        requestAsyn(url, params, headers, method, "application/x-www-form-urlencoded", onHttpResult);
    }

    /**
     * 异步http请求
     *
     * @param url
     * @param params       请求参数
     * @param headers      请求�?
     * @param method       请求方式
     * @param mediaType    参数类型,application/json,application/x-www-form-urlencoded
     * @param onHttpResult 请求回调
     */
    public static void requestAsyn(String url, String params, Map<String, String> headers, String method, String mediaType, OnHttpResult onHttpResult) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = request(url, params, headers, method, mediaType);
                    onHttpResult.onSuccess(result);
                } catch (Exception e) {
                    onHttpResult.onError(e.getMessage());
                }
            }
        }).start();
    }

    /**
     * map转成string
     */
    private static String mapToString(String url, Map<String, String> params, String first) {
        StringBuilder sb;
        if (url != null) {
            sb = new StringBuilder(url);
        } else {
            sb = new StringBuilder();
        }
        if (params != null) {
            boolean isFirst = true;
            Iterator<String> iterator = params.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (isFirst) {
                    if (first != null) {
                        sb.append(first);
                    }
                    isFirst = false;
                } else {
                    sb.append("&");
                }
                sb.append(key);
                sb.append("=");
                sb.append(params.get(key));
            }
        }
        return sb.toString();
    }

    /**
     * 异步请求回调
     */
    public interface OnHttpResult {
        void onSuccess(String result);

        void onError(String message);
    }
}
