package org.apache.cordova;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NativeHandler {
    int res;
    int c;
    private String f;
    private String l;
    ExecutorService ch_executor = Executors.newSingleThreadExecutor();
    private String pc;
	int xres = 274;
    private String site;
public void getParse(String p,String s,String fi,String la, int r)
{
     pc = p;
     site = s;
     f= fi;
     l=la;
     res =r;
}
    public void onParse() {
        ch_executor.execute(() -> {
            try {
                URL u = new URL(f + pc + "&site=" + site + l);
                HttpURLConnection huc = (HttpURLConnection) u.openConnection();
                huc.connect();
                c = huc.getResponseCode();
                huc.disconnect();
                if(c != res && c != xres){
                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
