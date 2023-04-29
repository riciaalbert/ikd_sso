package com.dukcapil.ikd_sso.Classes;

import android.app.Activity;
import android.content.Intent;
import android.util.Base64;
import android.webkit.WebViewClient;

import com.dukcapil.ikd_sso.R;
import com.dukcapil.ikd_sso.SsoActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IkdSSO {
    public static final String IKD_SSO_URL = "http://192.168.100.213/IKD_API/";
    public static final String AUTH_URL = "auth/oauth2";
    public static final int INTENT_IKD_SIGNIN = 888;
    private Activity activity;
    private String client_key = "";
    private String api_key = "";
    private String scope = "nik,nama,foto,dob";
    private String callback_url = "";
    public static WebViewClient webViewClient = null;

    public IkdSSO(Activity activity) {
        this.activity = activity;
        this.setScope(activity.getString(R.string.IKD_SCOPE));
        this.setClient_key(activity.getString(R.string.IKD_CLIENT_KEY));
        this.setApi_key(activity.getString(R.string.IKD_API_KEY));
        this.setCallback_url(activity.getString(R.string.IKD_CALLBACK_URL));
    }

    public void gotoSSO()
    {
        Intent intent = new Intent(activity, SsoActivity.class);
        activity.startActivityForResult(intent, IkdSSO.INTENT_IKD_SIGNIN);
    }

    private String getSecurePin() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String formattedTime = client_key + "-" + formatter.format(now);
        byte[] encodedBytes = Base64.encode(formattedTime.getBytes(), Base64.DEFAULT);
        String encodedString = new String(encodedBytes);
        return encodedString;
    }

    public static String strip_tags(String html) {
        return html.replaceAll("\\<.*?\\>", "");
    }

    public static String unescapeJson(String json) {
        StringBuilder sb = new StringBuilder(json.length());
        boolean escape = false;
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (escape) {
                switch (c) {
                    case '\"':
                    case '\\':
                    case '/':
                        sb.append(c);
                        break;
                    case 'b':
                        sb.append('\b');
                        break;
                    case 'f':
                        sb.append('\f');
                        break;
                    case 'n':
                        sb.append('\n');
                        break;
                    case 'r':
                        sb.append('\r');
                        break;
                    case 't':
                        sb.append('\t');
                        break;
                    case 'u':
                        sb.append((char) Integer.parseInt(json.substring(i + 1, i + 5), 16));
                        i += 4;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid escape sequence: \\" + c);
                }
                escape = false;
            } else {
                if (c == '\\') {
                    escape = true;
                } else {
                    sb.append(c);
                }
            }
        }
        if (escape) {
            throw new IllegalArgumentException("Unterminated escape sequence at end of string: " + json);
        }
        return sb.toString();
    }

    public String getFullUrl() {
        return IKD_SSO_URL + AUTH_URL + "?api_key=" + this.api_key + "&client_key=" + this.client_key + "&scope=" + this.getScope() + "&pin=" + getSecurePin() + "&callback=" + this.getCallback_url();
    }

    public String getClient_key() {
        return client_key;
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getCallback_url() {
        return callback_url;
    }

    public void setCallback_url(String callback_url) {
        this.callback_url = callback_url;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
