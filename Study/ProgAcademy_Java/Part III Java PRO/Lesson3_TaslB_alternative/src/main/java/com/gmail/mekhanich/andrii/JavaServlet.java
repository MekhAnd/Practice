package com.gmail.mekhanich.andrii;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet (name = "javaServlet", urlPatterns = "/java.do")
public class JavaServlet {

	private static final JavaServlet msgList = new JavaServlet();
    private static final int LIMIT = 100;

    private final Gson gson;
    private final List<Message> list = new LinkedList<Message>();

    public static JavaServlet getInstance() {
        return msgList;
    }

    private JavaServlet() {
        gson = new GsonBuilder().create();
    }

    public synchronized void add(Message m) {
        if (list.size() + 1 == LIMIT) {
            list.remove(0);
        }
        list.add(m);
    }

    public synchronized String toJSON(int n) {
        if (n == list.size()) return null;
        return gson.toJson(new JsonMessages(list, n));
    }
    

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        byte[] buf = requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Message msg = Message.fromJSON(bufStr);
        if (msg != null)
            msgList.add(msg);
        else
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    private byte[] requestBodyToArray(HttpServletRequest req) throws IOException {
        InputStream is = req.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;

        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);

        return bos.toByteArray();
    }
}
