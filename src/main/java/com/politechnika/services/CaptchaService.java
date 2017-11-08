package com.politechnika.services;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CaptchaService {

	private static final Logger logger = Logger.getLogger(CaptchaService.class);
	
	private static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
	private static final String SECRET_KEY = "6LedvzcUAAAAAKbThY7f-wuksEgJS2eUqB7zv_6v";
	//private static final String SITE_KEY = "6LedvzcUAAAAAAmGg7uoftMqfP4M50UCNTg9ndTG";
	
	public boolean verifyCaptcha(String gRecaptchaResponse) {
		if(gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
			logger.debug("Google Recaptcha response is null or empty.");
			return false;
		}
		
		try {
			URL verifyUrl = new URL(SITE_VERIFY_URL);
			HttpsURLConnection connection = (HttpsURLConnection)verifyUrl.openConnection();
			
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			StringBuilder postPramBuilder = new StringBuilder();
			postPramBuilder
				.append("secret=")
				.append(SECRET_KEY)
				.append("&response=")
				.append(gRecaptchaResponse);
			
			OutputStream outStream = connection.getOutputStream();
			outStream.write(postPramBuilder.toString().getBytes());
			
			outStream.flush();
			outStream.close();
			
			int responseCode = connection.getResponseCode();
			
			logger.debug("Google Recaptcha response code" + responseCode);
			
			InputStream inputStream = connection.getInputStream();
			
			JsonReader jsonReader = Json.createReader(inputStream);
			JsonObject jsonObject = jsonReader.readObject();
			jsonReader.close();
			
			return jsonObject.getBoolean("success");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
