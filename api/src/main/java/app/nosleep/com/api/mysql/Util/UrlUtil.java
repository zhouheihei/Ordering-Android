package app.nosleep.com.api.mysql.Util;

import android.util.Log;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by nosleep on 16-8-11.
 */

public  class UrlUtil {

    public static String getUrl(Map map){
        String url="?";
        if(map==null){
            return url;
        }
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry=(Map.Entry)iter.next();
            url+=""+entry.getKey()+"=";
            url+=""+entry.getValue()+"&";
        }
        Log.v("URlUTIL","url");
        return url;
    }

}
