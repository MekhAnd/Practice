package com.gmail.mekhanich.andrii;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




public class Message {
	
	private String message;
	private User user;
	private String room;
	private String to;
	private Date date = new Date ();
	
	
	public Message(String message, User user, String room) {
		super();
		this.message = message;
		this.user = user;
		this.room = room;
	}
	
	public String toJSON() {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(this);
	}
	
	public static Message fromJSON(String s) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, Message.class);
    }


	public String getMessage() {
		return message;
	}

	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}


	@Override
	public String toString() {
		return "User=" + user + "message=" + message + ", room=" + room + "]";
	}
	

    public int send(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream();){
            String json = toJSON();
            os.write(json.getBytes(StandardCharsets.UTF_8));
            return conn.getResponseCode();
        } 
    }
	
}
