package com.gmail.mekhanich.andrii;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;


@WebServlet (name = "formServlet", value = "/question")
public class FormServlet extends HttpServlet {

    private final ConcurrentHashMap<String, Integer> applicationForm = new ConcurrentHashMap<String, Integer>();
    private String res;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pwr = resp.getWriter();

        String name = req.getParameter("name");
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        String occupation = req.getParameter("occupation");
        String age = req.getParameter("age");

        String [] array = new String [5];
        array[0] = name;
        array[1] = nickname;
        array[2] = gender;
        array[3] = occupation;
        array[4] = age;

        if (check(array)){
            if(applicationForm.isEmpty()){
                fill();
                formRes(array);
            } else{
                formRes(array);
            }
            pwr.println(httpOk());
        } else {
            pwr.println(httpFail());
        }
        log("msg:"+res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        String occupation = req.getParameter("occupation");
        String age = req.getParameter("age");

        resp.getWriter().println(this.res);
        }

    public ConcurrentHashMap<String, Integer> formRes ( String [] array){
        if(array[2].equals("male")){
            int tmp = applicationForm.get("male");
                tmp+=1;
                applicationForm.put("male", tmp);
            } else {
                int tmp = applicationForm.get("female");
                tmp+=1;
                applicationForm.put("female", tmp);
            }
        if(array[3].equals("student")){
                int tmp = applicationForm.get("student");
                tmp+=1;
                applicationForm.put("student", tmp);
            } else if (array[3].equals("ws")) {
                int tmp = applicationForm.get("ws");
                tmp+=1;
                applicationForm.put("ws", tmp);
            } else{
                int tmp = applicationForm.get("worker");
                tmp+=1;
                applicationForm.put("worker", tmp);
            }
        if(array[4].equals("25")){
                int tmp = applicationForm.get("25");
                tmp+=1;
                applicationForm.put("25", tmp);
            } else if (array[4].equals("35")) {
                int tmp = applicationForm.get("35");
                tmp+=1;
                applicationForm.put("35", tmp);
            } else if (array[4].equals("45")){
                int tmp = applicationForm.get("45");
                tmp+=1;
                applicationForm.put("45", tmp);
            } else if (array[4].equals("55")){
                int tmp = applicationForm.get("55");
                tmp+=1;
                applicationForm.put("55", tmp);
            } else {
                int tmp = applicationForm.get("95");
                tmp+=1;
                applicationForm.put("95", tmp);
            }
        this.applicationForm.put("totalRespondents",applicationForm.get("male")+applicationForm.get("female"));
        return applicationForm;
    }

    public boolean check (String [] array){
        boolean checker = false;
        if(Arrays.toString(array).indexOf("null")>-1){
            checker = false;
        } else {
            checker = true;
        }
        return checker;
    }

    public ConcurrentHashMap<String,Integer> fill(){
        applicationForm.put("male",0);
        applicationForm.put("female",0);
        applicationForm.put("student",0);
        applicationForm.put("ws",0);
        applicationForm.put("worker",0);
        applicationForm.put("25",0);
        applicationForm.put("35",0);
        applicationForm.put("45",0);
        applicationForm.put("55",0);
        applicationForm.put("95",0);
        return applicationForm;
    }

    public String httpOk(){
        this.res = "<!DOCTYPE html>\n <html lang=\"en\">\n <head>\n  <meta charset=\"UTF-8\">\n <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n <title>Aplication Form</title></html>" + "<body style=\"background-color: antiquewhite; font-family: Arial, Helvetica, sans-serif; font-size: medium;\">";

        this.res += "<h2>THIS IS THE RESULT LIST OF APPLICATION FORM</h2>"+"<table>"+
                "<tr><td><b>Total answers</b></td>" + "\n"+"<td>"+applicationForm.get("totalRespondents")+ "</td> </tr>" +
                "<tr><td> <b>Respondents by gender</b> </td> </tr>" +
                "<tr><td>Male</td>" +"<td>"+ applicationForm.get("male")+ "</td></tr>" +
                "<tr><td>Female</td>" + "<td>" + applicationForm.get("female")+ "</td></tr>" +
                "<tr><td><b> Respondents by occupation</b></td></tr>" + "<tr><td>Student<</td>>" + "<td>"+applicationForm.get("student")+ "</td></tr>" +
                "<tr><td>Work and Study</td>" +"<td>"+ applicationForm.get("ws")+ "</td></tr>" + "<tr><td>Work</td>" + "<td>"+applicationForm.get("worker")+ "</td></tr>" +
                "<tr><td><b>Respondents by age</b></td></tr>" + "<tr><td>15-25 </td>" + "<td>"+applicationForm.get("25")+ "</td></tr>" +
                "<tr><td>25-35</td>" +"<td>"+ applicationForm.get("35")+ "</td></tr>" + "<tr><td>35-45</td>" + "<td>"+applicationForm.get("45")+ "</td></tr>" + "<tr><td>45-55 </td>>" +"<td>"+ applicationForm.get("55")+ "</td></tr>" + "<tr><td>More than 55</td>" +"<td>"+ applicationForm.get("95")+ "</td></tr>" + "</body>";

        return this.res;
    }

    public String httpFail(){
        this.res = "<!DOCTYPE html>\n <html lang=\"en\">\n <head>\n  <meta charset=\"UTF-8\">\n <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n <title>Aplication Form</title></html>" + "<body style=\"background-color: antiquewhite; font-family: Arial, Helvetica, sans-serif; font-size: medium;\">";

        this.res += "Unfortunately we cannot accept your form because some fields are empty";

        return this.res;
    }

}
