package com.qa.tests;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.restClient;
public class GetAPITest extends TestBase{
	TestBase testBase;
	restClient restclient;
	String Baseurl;
	String Serviceurl;
	String APIEndpoint;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setup() throws Throwable{
		 testBase = new TestBase();
		 Baseurl =  prop.getProperty("URL");
		 Serviceurl =  prop.getProperty("ServiceURL");
		 APIEndpoint = Baseurl+Serviceurl;
	}
	@Test
	public void getAPITest() throws Throwable{
	restclient = new restClient();
    response = restclient.get(APIEndpoint);
	//1. Status code
	 int statusCode = response.getStatusLine().getStatusCode();
	System.out.println("statusCode is "+statusCode);
	Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_SUCCESS,"Status code is not 200 test case fail");
	//2. Json string
	String prettyResponse = EntityUtils.toString(response.getEntity(),"UTF-8");
	JSONObject jsonObj = new JSONObject(prettyResponse);
	System.out.println("Response Json from API"+jsonObj);
	//3. All headers 	
	Header[] allHeader = response.getAllHeaders();
	HashMap<String,String> headermap = new HashMap<String,String>();
	for(Header header:allHeader ){
	headermap.put(header.getName(), header.getValue());
	}
	
	System.out.println("All headers arrary:"+headermap);
  }

}
