package com.ogogc.app;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串工具类
 * @author nosleep
 *	1.String 转换参数 MAP<colname,value>
 */
public class StringUtil {

	/**
	 * 将字符串转换为Map类型参数
	 * @param str  需转换参数
	 * @return
	 */
	public static Map<String,String> StringToMap(String str){
		String _str="";
		try {
			_str=URLDecoder.decode(str,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("转换后："+_str);
		Map<String ,String> map = new HashMap<String, String>();
		String[] _param=_str.split("&");
		for(int i = 0;i<_param.length;i++){
			String[] _ky = _param[i].split("=");
			if(_ky.length>=2){
				map.put(_ky[0], _ky[1]);
			}
		}
		return map;
	}
	
	/**
	 * 获取文件后缀名
	 * @param name  文件名
	 * @return		后缀名
	 */
	public static String subName(String name){
		String newname= name.substring(name.indexOf("."));
		System.out.println("获取后缀名："+newname);
		return newname;
	}

	public static String getUserPicFileName(String name){
		String filename= getFileName()+subName(name);
		System.out.println("用户头像文件名："+filename);
		return filename;
	}
    /**
     * 生成一个MD5字符串
     * @return MD5字符串
     */
    public static String getFileName(){
        String filename= "";
        Date date =new Date();
        long name = date.getTime();
        filename =getMD5(name+"");
        return filename;
    }
    
    /**
     * 将字符串进行MD5操作
     * @param info  需要转化字符串
     * @return   	MD5字符串
     */
    public static String getMD5(String info)
    {
        try
        {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes("UTF-8"));
            byte[] encryption = md5.digest();

            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++)
            {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1)
                {
                    strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                }
                else
                {
                    strBuf.append(Integer.toHexString(0xff & encryption[i]));
                }
            }

            return strBuf.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            return "";
        }
        catch (UnsupportedEncodingException e)
        {
            return "";
        }
    }
}
