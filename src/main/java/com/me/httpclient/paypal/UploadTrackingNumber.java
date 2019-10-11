package com.me.httpclient.paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 * Hello world!
 *
 */
public class UploadTrackingNumber {
	
    private static String getAuthorizationHeader() {
         return "Bearer A21AAG_RI-1rIKoHsiHXw6aLmE0nASMjSDHBYqbvU2_YqALLV2MH07E_27StH4KvIU_V8csALbe0dbTMOsc0QXB0VoSmyGjZQ";
    }
    
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "https://api.sandbox.paypal.com/v1/shipping/trackers-batch";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		
		// add header
		post.addHeader("Content-Type", "application/json");
		post.addHeader("Authorization", getAuthorizationHeader());
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("trackers", 
				trackingnumber()));

		StringEntity s = new StringEntity(trackingnumber());
		s.setContentEncoding("UTF-8");
		post.setEntity(s);
		
		System.err.println(trackingnumber());

		HttpResponse response = client.execute(post);
		System.out.println("Response Code : "
		                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		System.out.println(result);
		JSONObject jobObject = JSONObject.fromObject(URLDecoder.decode(result.toString()));
		System.out.println(jobObject.get("message"));
		
	}

	protected static String trackingnumber() {
		return "{\"trackers\":[ " + 
        "{\"transaction_id\": \"8MC585209K746392H\", "
       +  " \"tracking_number\": \"443844607820\",  " 
       + " \"status\": \"SHIPPED\",  " + 
       " \"carrier\": \"FEDEX\"}]} "; 
	}
}
