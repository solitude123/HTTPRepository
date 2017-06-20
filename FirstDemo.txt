package edu.sjtu.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HTTPURLConnectionClient {
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HTTPURLConnectionClient http = new HTTPURLConnectionClient();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		/*System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();*/

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		double X = 10.08;
		double Y = 10.09;
		double Z = 10.10;
		double Alpha = 10.11;
		double Beta = 10.12;
		double Gamma = 10.13;
		double J1_Tor = 10.14;
		double J2_Tor = 10.15;
		double J3_Tor = 10.16;
		double J4_Tor = 10.17;
		double J5_Tor = 10.18;
		double J6_Tor = 10.19;
		double J7_Tor = 10.20;
		
		String url = "http://localhost:8080/ServletTest/RegisterServlet?" +
				"X=" + String.valueOf(X) + "&" +
				"Y=" + String.valueOf(Y) + "&" +
				"Z=" + String.valueOf(Z) + "&" +
				"Alpha=" + String.valueOf(Alpha) + "&" +
				"Beta=" + String.valueOf(Beta) + "&" +
				"Gamma="+ String.valueOf(Gamma) + "&" +
				"J1_Tor=" + String.valueOf(J1_Tor) + "&" +
				"J2_Tor=" + String.valueOf(J2_Tor) + "&" +
				"J3_Tor=" + String.valueOf(J3_Tor) + "&" +
				"J4_Tor=" + String.valueOf(J4_Tor) + "&" +
				"J5_Tor=" + String.valueOf(J5_Tor) + "&" +
				"J6_Tor=" + String.valueOf(J6_Tor) + "&" +
				"J7_Tor=" + String.valueOf(J7_Tor);
		
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}

	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
}
