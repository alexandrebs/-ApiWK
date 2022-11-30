package br.com.brazuca.brazucaapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ScrapingUtil {


	public static void main(String[] args) throws IOException {
	}
		

	public static String requestDoadores() throws IOException {

		URL url = new URL("https://s3.amazonaws.com/gupy5/production/companies/52441/emails/1669646172212/e8330670-6f23-11ed-91a8-05f5cf6759fb/data_1.json");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
		
		
		return response;
	}



}

