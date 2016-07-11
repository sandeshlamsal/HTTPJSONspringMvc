package com.example;

	import org.apache.http.client.methods.CloseableHttpResponse;
    import org.apache.http.client.methods.HttpGet;
    import org.apache.http.impl.client.CloseableHttpClient;
    import org.apache.http.impl.client.HttpClients;
    import org.apache.http.util.EntityUtils;
    import org.springframework.beans.factory.annotation.Value;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

	@RestController
	public class HomeController {
		@Value("${json.url}")
		private String jsonUrl;

		@RequestMapping( value="/")
		public String index(){
		   // @Value("${user.name}")
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
	        HttpGet httpGet;
	        try{
	            //using GET method for http
	        	//it is a http response, not in json format response will give if sucess
		        //HttpResponseProxy{HTTP/1.1 200 OK [Access-Control-Allow-Origin: *, Content-Type: application/json; charset=ISO-8859-1, 
		        //Date: Mon, 11 Jul 2016 18:57:35 GMT, Server: Google Frontend, Content-Length: 230, Age: 0,
		        //Via: 1.1 localhost.localdomain] ResponseEntityProxy{[Content-Type: application/json; charset=ISO-8859-1,Content-Length: 230,Chunked: false]}}

	        httpGet=new HttpGet(jsonUrl);
	        //CloseableHttpResonse is a interface  HttpResponse, Closeable
	        CloseableHttpResponse response = httpClient.execute(httpGet);
	        System.out.println(response);
	        
	        int responseCode=response.getStatusLine().getStatusCode();
	        System.out.println(responseCode);		
	        
	        //if http request is replied with ok response then take the json
	        if(responseCode==200){
	        	//getting the response message to string
	        	String jsonMsg=EntityUtils.toString(response.getEntity());
	        	System.out.println("String Json Message :" + jsonMsg);
	        	
	        	
	        	//Now mapping the url to jsonObject for conversion
	        	ObjectMapper mapper = new ObjectMapper();
	        	jsonTest objJT=mapper.readValue(jsonMsg,jsonTest.class);
	        	System.out.println("Object Json Message :" + objJT); //com.example.jsonTest@1d1eebb will be printed as it is object
	        	//to format it and see it better
	        	 
	        	
	        	//this will print individual values of the object
	        	System.out.println("Date is"+ objJT.getDate());  //07-11-2016
	        	
	        	//to print the object as format use, all will be closed by ""
	        	String prettyUser = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objJT);
				System.out.println("Formated Json User" + prettyUser);
	        	
	        }
	        
	        }
	        catch(Exception e){
	        	
	        }
	        
			return "HTTP RESPONSE and JSON FORMATTING";
			
		}
		
}
