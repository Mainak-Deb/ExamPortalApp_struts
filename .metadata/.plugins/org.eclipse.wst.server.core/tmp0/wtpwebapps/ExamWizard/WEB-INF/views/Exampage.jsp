<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content=" initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="public/styles/Exampage.css" />
  </head>
  <body>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div id="header"> ${ename} </div>
    <div id="time-section">Time left: <span id="timer">00:00</span></div>
    <div id="main-section">
      <form id="problem-section" action="EvaluateExam.do">
      <input type="text" name="eid" value="${eid}"  style="display: none;">
      <input type="text" name="uid" value="${uid}"  style="display: none;">
        <c:forEach var="question" varStatus="qi" items="${qsSet}">
        <div id="problem-${qi.index+1}" class="box-of-questions"  style="display: none;" >
        <h3>Question ${qi.index+1} </h3>
	        <div class="question">
	            <p class="qtext"> ${question.getQtext()}  </p>
	            <label>
	            <input type="radio" name="${question.getQid()}" onchange="handleRadioChange(${qi.index+1})" value="${question.getOptions().get(0).getOid()}"  disable />
	            <span>${question.getOptions().get(0).getOtext() } </span>
	            </label>
	            <label>
	            <input type="radio" name="${question.getQid()}" onchange="handleRadioChange(${qi.index+1})"  value="${question.getOptions().get(1).getOid()}"   disable />
	            <span>${question.getOptions().get(1).getOtext() } </span>
	            </label>
	            <label>
	            <input type="radio" name="${question.getQid()}" onchange="handleRadioChange(${qi.index+1})"  value="${question.getOptions().get(2).getOid()}"   disable />
	            <span>${question.getOptions().get(2).getOtext() } </span>
	            </label>
	            <label>
	            <input type="radio" name="${question.getQid()}" onchange="handleRadioChange(${qi.index+1})"  value="${question.getOptions().get(3).getOid()}"   disable />
	            <span>${question.getOptions().get(3).getOtext() } </span>
	            </label>
	        </div>
	        <div class="button-section">
	        <button type="button" class="change-button" onclick="goPrevQs()">Previous</button>
        	<button type="button" class="change-button" onclick="goNextQs()">Next</button>
	        
	      </div>
	      <hr />
	      <hr/><input type="submit" class="change-button2" />
	      </div>
	      
	    </c:forEach>
      </form>
      
      <div id="navigator">
        <div id="personal-info">
          <h2>${uname}</h2>
          <h4>${uroll}</h4>
          <hr />
        </div>
        <div id="nav-buttons">
        <c:forEach var="question" varStatus="qi" items="${qsSet}">
          <button class="roundbutton"  id="probbutt-${qi.index+1}" onclick="changeSection(${qi.index+1})">${qi.index+1}</button>
         </c:forEach>
        </div>
      </div>
    </div>
    <script src="public/js/Exampage.js"></script>
    <script type="text/javascript">
    	// On page load
    	window.onload = function () {
    	  var thirtyMinutes = 60 * ${eduration} ,
    	    display = document.querySelector("#timer");
    	  startCountdown(thirtyMinutes, display);
    	};
    	
    	var qslength=${qsSet.size()};
    	var questionstate_global=1;
    	var checked_global = [];
    	for(let i=0;i<qslength;i++){
    	    checked_global.push(false);
    	}
    	changeSection(questionstate_global)
				
		function goPrevQs(){
		    if(questionstate_global>1){
		        changeSection(questionstate_global-1);
		    }
		}
		
		function goNextQs(){
		    if(questionstate_global<qslength){
		        changeSection(questionstate_global+1);
		    }
		}

    </script>
  </body>
</html>
