package com.me.httpclient.paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 * Hello world!
 *
 */
public class GetAccessToken {
	
    private static String getAuthorizationHeader() {
         final String pair = "AeiKcvZxLil8k8eol-19HETPyFQHcxxhACOYid8ImjTX910qjwx86wHIIjQ8I4e8IVseFwzsffk3oJHE:ENyIL-zreLjpChUv7BQePSM3HniOL4DkYgrvsbpePWFFF05Lq4hvL2mPV6xXWcgkZp6jp9QdIuerHLAT";
          String base64 = DatatypeConverter.printBase64Binary(pair.getBytes());
//          System.out.println(base64);
//         base64 = "QWVpS2N2WnhMaWw4azhlb2wtMTlIRVRQeUZRSGN4eGhBQ09ZaWQ4SW1qVFg5MTBxand4ODZ3SElJalE4STRlOElWc2VGd3pzZmZrM29KSEU6RU55SUwtenJlTGpwQ2hVdjdCUWVQU00zSG5pT0w0RGtZZ3J2c2JwZVBXRkZGMDVMcTRodkwybVBWNnhYV2Nna1pwNmpwOVFkSXVlckhMQVQ=";
         System.out.println(base64);
         return "Basic " + base64;
    }
    
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "https://api.sandbox.paypal.com/v1/oauth2/token";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		
		// add header
		post.addHeader("Accept-Language", "en_US");
		post.addHeader("Accept", "*/*");
		post.addHeader("Authorization", getAuthorizationHeader());
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("grant_type", 
				"client_credentials"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));

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
}
