package com.citcon.unop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;


/**
 * @author Jed
 * 
 * Mimic the payment request
 *
 */
public class CitconUnionPayClient {
   
   public static final String CHOP_TOKEN_DEV = "E92DD4FAA25C4450B31FBE14AE404EDE";
   public static final Charset URI_CHARSET = Charset.forName("UTF-8");
   
   public static void main(String[] args) {
	   CitconUnionPayClient client = new CitconUnionPayClient();
	   client.excute();
   }
   
   public void  excute(){
         
      CloseableHttpClient client = null;
      CloseableHttpResponse response = null;
      BufferedReader rd = null;
      try {

//       client = HttpClients.createDefault();
         
         client = HttpClients.custom().
                    setHostnameVerifier(new AllowAllHostnameVerifier()).
                    setSslcontext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
                    {
                        public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
                        {
                            return true;
                        }
                    }).build()).build();
         
         HttpPost post = new HttpPost("https://uat.citconpay.com/chop/chop");
         
         post.setHeader("Authorization", CHOP_TOKEN_DEV);
         
         List<NameValuePair> requestBody = new ArrayList<NameValuePair>();
         requestBody.add(new BasicNameValuePair("amount", "100"));
         requestBody.add(new BasicNameValuePair("currency", "USD"));
         requestBody.add(new BasicNameValuePair("reference", "testing")); 
         requestBody.add(new BasicNameValuePair("payment_method", "upop")); 
         
         
         UrlEncodedFormEntity entity = new UrlEncodedFormEntity(requestBody, URI_CHARSET);
         post.setEntity(entity);         
      
         response = client.execute(post);

         System.out.println("Invoking api [" 
                 + "] returns the response code "
                 + response.getStatusLine().getStatusCode());

         rd = new BufferedReader(new InputStreamReader(response.getEntity()
                .getContent()));
         StringBuffer result = new StringBuffer();
         String line;
         while ((line = rd.readLine()) != null) {
            result.append(line);
         }
         
         System.out.println("Result: " + result);
				
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
         
         if (rd != null) {
            try {
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
         }

         if (response != null) {
            try {
                response.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
         }
         
         if (client != null) {
            try {
                client.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
         }
      }     
   }
   
  
}
