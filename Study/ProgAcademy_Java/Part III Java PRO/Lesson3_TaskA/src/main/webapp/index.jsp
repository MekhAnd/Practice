<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Анкета</title>
</head>
<body style="background-color: antiquewhite; font-family: Arial, Helvetica, sans-serif; font-size: medium;">
    <form action="/question" method="Get">
        <table>
            <tr>
                <td><b>General Information</b></td>
            </tr>
            <tr>
                <td>Your name:</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Your nickname:</td>
                <td><input type="text" name="nickname"/></td> 
            </tr>
        <tr>
            <td><b>Your gender:</b></td>
        </tr> 
        <tr>
            <td>Male</td>
            <td><input type="radio" name="gender" value="male"/></td>
        </tr>
        <tr>
            <td>Female</td>
            <td><input type="radio" name="gender" value="female"/> </td>
        </tr>
        <tr>
            <td> <b> What is your occupation?:</b></td>
        </tr> 
        <tr>
            <td>Student</td>
            <td><input type="radio" name="occupation" value="student"/> </td>
        </tr>
        <tr>
            <td>Work and Study</td>
            <td><input type="radio" name="occupation" value="ws"/>  </td>
        </tr>
        <tr>
            <td>Work</td>
            <td><input type="radio" name="occupation" value="worker"/></td>
        </tr>
       <tr>
           <td><b>How old are you?:</b></td>
        </tr>  
        
        <tr>
            <td>15-25 years old</td>
            <td><input type="radio" name = "age" value = "25"/></td>
        </tr>
        <tr>
            <td>25-35 years old</td>
            <td><input type="radio" name = "age" value = "35"/></td>
        </tr>
        <tr>
            <td>35-45 years old</td>
            <td><input type="radio" name = "age" value = "45"/></td>
        </tr>
        <tr>
            <td>45-55 years old</td>
            <td><input type="radio" name = "age" value = "55"/></td>
        </tr>
        <tr>
            <td>more than 55 y old</td>
            <td><input type="radio" name = "age" value = "95"/></td>
        </tr>
        </table>
        <br/> <input type="Submit" style="font-family: Arial, Helvetica, sans-serif; font-size: medium;">

    </form>
</body>
</html>