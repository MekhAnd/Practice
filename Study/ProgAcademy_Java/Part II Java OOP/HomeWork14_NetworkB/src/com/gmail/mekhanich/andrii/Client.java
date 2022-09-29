package com.gmail.mekhanich.andrii;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Client implements Runnable {
	private Socket socket;
	private String answer;
	private int requestNumber=0;
	private Thread tr;

	public Client(Socket socket) {
		super();
		this.socket = socket;
		this.answer = getAnswer();
		this.tr = new Thread(this);
		tr.start();
	}
	
	public String getAnswer () {
		String tmp = "" + System.getenv();
		
		Function<String, String> keyMapper = z -> z.replaceAll("=.*", "");
		Function<String, String> valueMapper = z -> z.replaceAll(".*=", "");

		Map<String, String> res = Arrays.stream(tmp.split(",")).collect(Collectors.toMap(keyMapper, valueMapper));

		Set<String> keySet = res.keySet();

		
		String answer = ""
				+ "<html><head><title>System</title> <meta charset='utf-8'></head><body><p><b>Current System Information<i> - request number " + getRequestNumber() +"</p><br>";
		answer += "<table border='2' cellpadding='5' ><tr><th>Key</th><th>Value</th></tr>";
		for (String key : keySet) {
			answer += "<tr>";
			answer += "<td>" + key + "</td>";
			answer += "<td>" + res.get(key) + "</td>";
		}
		answer += "</table></body></html>";
		
		return answer;
	}
	
	public int getRequestNumber() {
		this.requestNumber+=1;
		return this.requestNumber;
	}
	
//	public int getNumber() {
//		return this.requestNumber;
//	}
	
	public void run() {
		try (InputStream is = socket.getInputStream(); OutputStream os = socket.getOutputStream();PrintWriter pw = new PrintWriter(os)){
			byte[] record = new byte [is.available()];
			is.read(record);
			String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type: text/html\r\n" + "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
			pw.println(response + answer);
			//getRequestNumber();
			System.out.println(this.requestNumber);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	}
