package com.sve.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;



/**
 *  发送验证码
 *  @作者 soft01
 *  2018年6月26日下午3:32:00
 */
public class GetMessageCode {

	public static final String QUERY_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	/**
	 * 开发者注册后系统自动生成的账号，可在官网登录后查看
	 */
	public static final String ACCOUNT_SID = "ede70add60fd4c88923e9792ef6a4c32";
	/**
	 * 开发者注册后系统自动生成的TOKEN，可在官网登录后查看
	 */
	public static final String AUTH_TOKEN = "8e958f24db5541d3b1f1fcce20285d9a";
	
	
	/**
	 * 根据手机号码获取验证码
	 * @param phone
	 * @return
	 */
	public static String getCode(String phone) {
		String rod = smsCode();
		String timestemp = getTimeStamp();
		String sig = getMD5(ACCOUNT_SID, AUTH_TOKEN, timestemp);
		String tamp = "【7天科技】您的验证码为"+rod+"，如非本人操作，请忽略此短信。";
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		StringBuilder builder = new StringBuilder();
		
		try {
			URL url = new URL(QUERY_URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true); //设置是否允许数据写入
			connection.setDoOutput(true);//设置是否允许参数数据输出
			connection.setReadTimeout(5000); //设置链接响应时间
			connection.setReadTimeout(10000);//设置参数读取时间
			connection.setRequestProperty("Content-type","application/x-www-form-urlencoded");
			osw=new OutputStreamWriter(connection.getOutputStream(),"UTF-8");//提交请求
			String args=getQueryArgs(ACCOUNT_SID, tamp, phone, timestemp, sig, "JSON");
			osw.write(args);
			osw.flush();
			br=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String temp = "";
			while((temp=br.readLine())!=null){
				builder.append(temp);
			}
			
			JSONObject json = new JSONObject(builder.toString());
			String respCode = json.getString("respCode");
			String defaultRespCode="00000";
			if(defaultRespCode.equals(respCode)) {
				return rod;
			}else {
				return defaultRespCode;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 定义请求参数拼接方法
	 * @param accountSid
	 * @param smsContent
	 * @param to
	 * @param timestamp
	 * @param sig
	 * @param respDataType
	 * @return
	 */
	public static String getQueryArgs(String accountSid,String smsContent,String to,String timestamp,String sig,String respDataType) {
		return "accountSid="+accountSid+"&smsContent="+smsContent+"&to="+to+"&timestamp="+timestamp+"&sig="+sig+"&respDataType="+respDataType;
	}
	
	/**
	 * sing签名
	 * @param sid
	 * @param token
	 * @param timestamp
	 * @return
	 */
	public static String getMD5(String sid,String token,String timestamp){
	    StringBuilder result=new StringBuilder();
	    String source=sid+token+timestamp;
	    //获取某个类的实例
	    try {                  
	    	MessageDigest digest=MessageDigest.getInstance("MD5");
	        //要进行加密的东西
	        byte[] bytes=digest.digest(source.getBytes());
	        for(byte b:bytes){
	        	String hex=Integer.toHexString(b&0xff);

	            if(hex.length()==1){
	            	result.append("0"+hex);
	            }else{
	            	result.append(hex);
	            }
	        }
	     } catch (NoSuchAlgorithmException e) {
	    	 e.printStackTrace();
	     }

	     return result.toString();
	}

	
	/**
	 * 获取时间戳
	 * @return
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 生成短信验证码
	 * @return
	 */
	public static String smsCode() {
		String random = (int)((Math.random()*9+1)*100000)+"";
		return random;
		
	}
	
}
