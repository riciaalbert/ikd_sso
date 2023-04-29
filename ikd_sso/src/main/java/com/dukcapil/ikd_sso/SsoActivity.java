package com.dukcapil.ikd_sso;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dukcapil.ikd_sso.Classes.IkdSSO;
import com.dukcapil.ikd_sso.Classes.Profil;
import com.google.gson.Gson;


public class SsoActivity extends AppCompatActivity {

    private Context context;
    private ActionBar actionBar;
    private WebView webView;
    private IkdSSO ikdSSO;
    private boolean flag = true;
    private Handler handler;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Code to be executed periodically
            webView.evaluateJavascript("(function() { return document.getElementById('div_profil').innerHTML; })();",
                    new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String html) {
                            // Do something with the HTML content
                            Log.d("DEBUG", "Url : " + webView.getUrl());

                            if (webView.getUrl().toLowerCase().trim().contains("auth/callback")) {
                                html = IkdSSO.unescapeJson(html.substring(1,html.length() - 1));
//                                Toast.makeText(context, html, Toast.LENGTH_LONG).show();
                                Gson gson = new Gson();
                                Profil profil = null;
                                try {
                                    profil = gson.fromJson(IkdSSO.strip_tags(html), Profil.class);
                                } catch (Exception e) {
                                    profil = null;
                                }
                                if (profil != null) {
                                    flag = false;
                                    Log.d("DEBUG", "Profil : " + profil.getNik() + "," + profil.getNama() + "," + profil.getFoto() + "," + profil.getTglLahir());
                                    Intent intent = new Intent();
                                    intent.putExtra("nik", (profil.getNik() != null) ? profil.getNik() : "");
                                    intent.putExtra("nama", (profil.getNama() != null) ? profil.getNama() : "");
                                    intent.putExtra("foto", (profil.getFoto() != null) ? profil.getFoto() : "");
                                    intent.putExtra("tgl_lahir", (profil.getTglLahir() != null) ? profil.getTglLahir() : "");
                                    intent.putExtra("birthplace", (profil.getTempatLahir() != null) ? profil.getTempatLahir() : "");
                                    intent.putExtra("kk", (profil.getKk() != null) ? profil.getKk() : "");
                                    intent.putExtra("rt", (profil.getRt() != null) ? profil.getRt() : "");
                                    intent.putExtra("rw", (profil.getRw() != null) ? profil.getRw() : "");
                                    intent.putExtra("kelurahan", (profil.getKelurahan() != null) ? profil.getKelurahan() : "");
                                    intent.putExtra("kecamatan", (profil.getKecamatan() != null) ? profil.getKecamatan() : "");
                                    intent.putExtra("kabupaten", (profil.getKabupaten() != null) ? profil.getKabupaten() : "");
                                    intent.putExtra("provinsi", (profil.getProvinsi() != null) ? profil.getProvinsi() : "");
                                    intent.putExtra("kode_pos", (profil.getKode_pos() != null) ? profil.getKode_pos() : "");
                                    intent.putExtra("golongan_darah", (profil.getGolongan_darah() != null) ? profil.getGolongan_darah() : "");
                                    intent.putExtra("status_pernikahan", (profil.getStatus_pernikahan() != null) ? profil.getStatus_pernikahan() : "");
                                    intent.putExtra("pekerjaan", (profil.getPekerjaan() != null) ? profil.getPekerjaan() : "");
                                    intent.putExtra("agama", (profil.getAgama() != null) ? profil.getAgama() : "");
                                    intent.putExtra("jenis_kelamin", (profil.getJenis_kelamin() != null) ? profil.getJenis_kelamin() : "");
                                    intent.putExtra("hub_keluarga", (profil.getHub_keluarga() != null) ? profil.getHub_keluarga() : "");
                                    intent.putExtra("nama_ibu", (profil.getNama_ibu() != null) ? profil.getNama_ibu() : "");
                                    intent.putExtra("nik_ibu", (profil.getNik_ibu() != null) ? profil.getNik_ibu() : "");
                                    intent.putExtra("nama_ayah", (profil.getNama_ayah() != null) ? profil.getNama_ayah() : "");
                                    intent.putExtra("nik_ayah", (profil.getNik_ayah() != null) ? profil.getNik_ayah() : "");
                                    setResult(IkdSSO.INTENT_IKD_SIGNIN, intent);
                                    finish();
                                }
                            }
                        }
                    });
            Log.d("DEBUG", "Html masuk");

            // System.out.println("Hello, world!");
            if (flag)
                handler.postDelayed(runnable, interval);
        }
    };
    private int interval = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sso);
        context = getApplicationContext();
        ikdSSO = new IkdSSO(this);

        // Set Action Bar
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        // actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorDarkOrange)));
        actionBar.setTitle("SSO Identitas Kependudukan Dukcapil");

        // Set Component
        webView = (WebView) findViewById(R.id.webView);
        if (IkdSSO.webViewClient == null)
            IkdSSO.webViewClient = new WebViewClient();
        webView.setWebViewClient(IkdSSO.webViewClient);
        webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.loadUrl(ikdSSO.getFullUrl());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("Confirm")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.confirm();
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.cancel();
                            }
                        })
                        .create()
                        .show();
                return true;
            }
        });


        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(runnable, 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}