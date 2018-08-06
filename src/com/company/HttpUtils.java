package com.company;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpUtils {

    static public Document getReq(String id, Date date_begin, Date date_end, String proxyhost, String proxyport, String proxyuser, String proxypassword){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            DefaultHttpClient  httpclient = new DefaultHttpClient();

            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(proxyhost, Integer.parseInt(proxyport)),
                    new UsernamePasswordCredentials(proxyuser, proxypassword));

            HttpHost proxy = new HttpHost(proxyhost, Integer.parseInt(proxyport));
            httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

           /* HttpPost http_2ip = new HttpPost("https://2ip.ru/");
            HttpResponse resp_2ip = httpclient.execute(http_2ip);
            HttpEntity ent_2ip = resp_2ip.getEntity();
            System.out.println(IOUtils.toString(ent_2ip.getContent(), "UTF-8"));*/
           HttpPost httppost = new HttpPost("https://ru.investing.com/instruments/HistoricalDataAjax/");
        //Заголовки
        httppost.addHeader("User-Agent", "Mozilla/5.0");
        httppost.addHeader("referer", "https://ru.investing.com/commodities/us-cotton-no.2-historical-data");
        httppost.addHeader("host", "ru.investing.com");
        httppost.addHeader("X-Requested-With", "XMLHttpRequest");
        httppost.addHeader("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");
        httppost.addHeader("Origin", "https://ru.investing.com");
        //Параметры
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("action", "historical_data"));
        params.add(new BasicNameValuePair("curr_id", id));
        params.add(new BasicNameValuePair("st_date", sdf.format(date_begin)/*"01/01/2018"*/));
        params.add(new BasicNameValuePair("end_date",sdf.format(date_end)));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpclient.execute(httppost);

        // System.out.println(response.toString());
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                //Переложили в Stting
                String req = IOUtils.toString(instream, "UTF-8");
                //В Jsoup
                final Document page = Jsoup.parse(req);
                instream.close();
                return page;
                }
            finally {
                instream.close();
            }
        }}
        catch (Exception ex){
           System.out.println(ex.toString());
        }
        return null;
    }

}
