/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webpagereader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Justin
 */
public class Reader{
    
    public static String getText(String key)
    {
        URL url;
        String result = "";
        String parsed = "";
        final String URL_NO_KEY="http://give-me-coins.com/pool/api-ltc?api_key=";
        try
        {
                url = new URL(URL_NO_KEY+key);
                //connect to the url
                 HttpURLConnection connect =(HttpURLConnection)url.openConnection();
                 connect.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.2; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
                //create buffered reader
                  InputStreamReader stream=new InputStreamReader(connect.getInputStream());
                 BufferedReader bufferedReader =new BufferedReader(stream);
                //get json text from webpage
                String line = null;
                result="";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                connect.disconnect();
                stream.close();
                bufferedReader.close();
                parsed=parseResult(result);
        }
        catch (Exception ex) {System.out.println(ex);}
        return parsed;
    }
    private static String parseResult(String json) throws JSONException{
        JSONObject hash = new JSONObject(json);
        String username="username";
        String re=hash.getString(username);
        re=re+" "+Integer.toString(hash.getInt("total_hashrate"));
        return re;
    }
}
