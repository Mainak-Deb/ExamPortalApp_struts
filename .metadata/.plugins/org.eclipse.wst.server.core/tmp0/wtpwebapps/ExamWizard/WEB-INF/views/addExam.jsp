<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add exam</title>
 <link rel="stylesheet" href="public/styles/addExam.css" />
  <link rel="stylesheet" href="public/styles/adminHome.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    />
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
   // Retrieve a session attribute
   String username = (String) session.getAttribute("username");
%>
  <nav class="sidebar">
    <a href="#" class="logo">
      <i class="fa-solid fa-gauge fa-spin"></i>
      Dashboard
    </a>

    <div class="menu-content">
      <ul class="menu-items">
        <li class="item">
          <a href="profile.do">
            <i class="fa-solid fa-address-card"></i>
            Profile</a>
        </li>

        <li class="item">
          <a href="studentPage.do">
            <i class="fa-solid fa-users"></i>
            Student Informations</a>
        </li>

        <li class="item selected-item">
          <a href="addExamPage.do">
            <i class="fa-solid fa-book-open"></i>
            Examination</a>
        </li>
		<li class="item">
            <a href="notificationPage.do">
              <i class="fa-solid fa-bell"></i>
              Notification</a>
          </li>
        <li class="item">
          <a href="logout.do">
            <i class="fa-solid fa-right-from-bracket"></i>
            Logout</a>
        </li>
      </ul>
    </div>
  </nav>

  <nav class="navbar">
    <i class="fa-solid fa-bars" id="sidebar-close"></i>
    <div class="hellotext">Hello <%= username %>
    </div>
  </nav>

  <main class="main">
    <h1>Exam panel</h1>
    <div class="exam-input">
      <form action="addExam.do">
        <h2>Create Exam</h2>
         <input type="text" name="eid" value="5" style="display:none;" />
        <div class="exam-card-header">
          <input type="text" name="etitle" class="exam-title-input" placeholder="Exam title" />
        </div>
        <div class="exam-card-body">
          <div class="body-time">
            <div class="exam-card-body-item" style="border-right: 2px solid rgba(0, 0, 0, 0.472)">
              <h5>Opening time</h5>
              <input type="datetime-local"  class="starttime" name="estart" value="2000-01-01T05:40:00" />
            </div>
            <div class="exam-card-body-item">
              <h5>Closing Time</h5>
              <input type="datetime-local"  class="endtime" name="eend" value="2000-01-01T05:40:00" />
            </div>
          </div>
          <div class="duration">
            <h3>Exam Duration(Min)</h3>
            <input type="text" name="eduration"  value="30" />
          </div>
        </div>
        <input type="submit" class="create-button" />
      </form>
    </div>
    <div class="card-holder">
     <c:forEach var="exam" items="${examList}">
     <div class="exam-card">

        <div class="exam-card-header">
          <h2> ${exam.etitle}</h2>
          <input type="text" class="eid"  id="${exam.eid}-id" name="eid" value="${exam.eid}" style="display: none" />
        </div>
        <div class="exam-card-body">
          <div class="body-time">
            <div class="exam-card-body-item" style="border-right: 2px solid rgba(0, 0, 0, 0.472)">
              <h5>Opening time</h5>
              <input type="datetime-local" id="${exam.eid}-st" class="starttime" name="estart" value="${exam.estart}"
                disabled />
            </div>
            <div class="exam-card-body-item">
              <h5>Closing Time</h5>
              <input type="datetime-local" id="${exam.eid}-et" class="endtime" name="eend" value="${exam.eend}"
                disabled />
            </div>
          </div>
          <div class="duration">
            <h3>Exam Duration(Min)</h3>
            <input type="text" name="eduration"  id="${exam.eid}-dur" value="${exam.eduration}" disabled />
          </div>
          <div class="button-area">
            <div class="top-button">
              <button class="exambutton" style="background-color: rgba(255, 78, 13, 0.911)"
               onclick="window.location.replace('studentForExam.do?eid=${exam.eid}')"
              >
                Add Student
              </button>
              <button class="exambutton" style="background-color: rgba(13, 134, 255, 0.911)" 
               onclick="window.location.replace('addNewQuestionsPage.do?eid=${exam.eid}')"
              >
                Add Question
              </button>
            </div>
            <div class="bottom-button">
              <button class="exambutton" id="${exam.eid}-but" style="background-color: rgba(255, 39, 39, 0.911)"
                onclick="changeExamCard('${exam.eid}')">
                Edit Exam
              </button>
            </div>
            <div class="bottom-button"  style="border-top: 2px solid  rgba(0, 0, 0, 0.412);">
              <button class="exambutton" id="${exam.eid}-but" style="background-color: rgb(193 50 207 / 91%);"
                onclick="window.location.replace('examResult.do?eid=${exam.eid}')">
                Exam Result
              </button>
            </div>
          </div>
        </div>
      </div>
     
      </c:forEach>

      
    </div>
  </main>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="public/js/addExam.js"></script>
</body>

</html>