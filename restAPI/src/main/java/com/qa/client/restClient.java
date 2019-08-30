package com.qa.client;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
public class restClient {

	//1.Get method
	public CloseableHttpResponse get(String url) throws Throwable {
	CloseableHttpClient httpclientobj =	HttpClients.createDefault();
	HttpGet httpgetobj = new HttpGet(url);
	CloseableHttpResponse response = httpclientobj.execute(httpgetobj);
	return response;
	}
}
