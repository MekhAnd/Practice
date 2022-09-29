<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room choosing</title>
	<style>
	@import url('https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200&display=swap');
	* {
   		margin: 0px 0px 0px 0px;
    	padding: 0px;
	    background-color: #7882A4;
	    font-family: 'Source Sans Pro', sans-serif;
	}

	header{
    	width: 100%;
    	height: 100px;
	}
	
	.body_top{
		height: 150px;
	}

	.body_form{
    	width: 35%;
    	height: 800px;
	    margin: 0 auto;
	    background-color: #ffffff;
	    box-shadow: -3px 6px 32px -10px #000000;;
    	border-radius: 50px 50px 50px 50px;
	}

	.body_form__top{
		padding-top: 10%;
		padding-bottom: 3%;
        /*margin: 0 auto;*/
	    background-color: #ffffff;
	    display: flex;
    	flex-wrap: wrap;
	    justify-content: center;
	    font-size: 3.5em;
    	font-weight: 600;
    	transform: translate(0%, -10%);
	    border-radius: 50px 50px 0px 0px;
	}

	.body_form__form{
    	height: 370px;
	    padding-top: 15%;
    	margin: 0 auto;
	    background-color: #ffffff;
	    display: flex;
    	flex-flow: column;
	    justify-content: center;
	    font-size: 1.5em;
    	font-weight: 600;
	}

	[class*="body_form__form-"]{
    	width: 70%;
    	height: 50px;
	    column-gap: 10px;
	    margin: 0 auto;
    	background-color: #ffffff;
    	display: block;
	    border-style: none;
	}

	.body_form__form-login{
    	margin-top: 10px;
	    color:#7882A4;
    	font-size: 0.95em;
	    border-bottom: 1px solid #7882A4 ;}

	.body_form__form-password{
    	margin-top: 10px;
        color:#7882A4;
    	font-size: 0.95em;
        border-bottom: 1px solid #7882A4;}

	.body_form__form-button{
    	width:250px;
    	margin-top: 30px;
	    font-size: 1.05em;
	    background-color: #D1D1D1;
	    border-radius: 100px 100px 100px 100px;
    	border: 1px solid #7882A4;
	    cursor: pointer;
	}

	button:hover{
    	font-weight: 800;
	}

	.body_form__bottom {
		
		
    	background-color: #ffffff;
        color:#7882A4;
	    transform: translate(0%, 105%);
	    text-align: center;
	    border-radius: 50px 50px 50px 50px;    
	}

	a{
    	background-color: #ffffff;
        color:#7882A4;
	    text-align: center;}

    </style>
</head>
<body>
 		<div class="body">
 			<div class="body_top"></div>
        	<div class="body_left-part"></div>
        	<div class="body_form">
 				<div class="body_form__top">Выбери комнату:</div>
   				<form class="body_form__form" action="/roomSelector.do" method="POST">
					 <button class="body_form__form-button" name= "room" value="java">JAVA</button>
					 <button class="body_form__form-button" name= "room" value="python">PYTHON</button>
					 <button class="body_form__form-button" name= "room" value="javaScript">JAVASCRIPT</button>
					 <button class="body_form__form-button" name= "room" value="css">HTML&CSS</button>
					 <button class="body_form__form-button" name= "room" value="qaAuto">QA Automation</button>
					 <button class="body_form__form-button" name= "room" value="qaManual">QA Manual</button>
					 <button class="body_form__form-button" name= "room" value="projects">Проекты</button>
					 <button class="body_form__form-button" name= "room" value="flow">Болталка</button>
				</form>
		 	</div>
		 	<div class ="body_form__bottom"></div>
    		<div class="body_right-part"></div>
    	</div>
</body>
</html>