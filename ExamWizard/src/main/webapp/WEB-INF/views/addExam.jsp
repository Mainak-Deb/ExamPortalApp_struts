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
              <input type="datetime-local" id="eid-st" class="starttime" name="estart" value="2000-01-01T05:40:00" />
            </div>
            <div class="exam-card-body-item">
              <h5>Closing Time</h5>
              <input type="datetime-local" id="eid-et" class="endtime" name="eend" value="2000-01-01T05:40:00" />
            </div>
          </div>
          <div class="duration">
            <h3>Exam Duration(Min)</h3>
            <input type="text" name="eduration" id="eid-dur" value="30" />
          </div>
        </div>
        <input type="submit" class="create-button" />
      </form>
    </div>
    <div class="card-holder">
      <div class="exam-card">

        <div class="exam-card-header">
          <h2>DBMS</h2>
          <input type="text" class="eid" value="eid" style="display: none" />
        </div>
        <div class="exam-card-body">
          <div class="body-time">
            <div class="exam-card-body-item" style="border-right: 2px solid rgba(0, 0, 0, 0.472)">
              <h5>Opening time</h5>
              <input type="datetime-local" id="eid-st" class="starttime" name="starttime" value="2000-01-01T05:40:00"
                disabled />
            </div>
            <div class="exam-card-body-item">
              <h5>Closing Time</h5>
              <input type="datetime-local" id="eid-et" class="endtime" name="endtime" value="2000-01-01T05:40:00"
                disabled />
            </div>
          </div>
          <div class="duration">
            <h3>Exam Duration(Min)</h3>
            <input type="text" id="eid-dur" value="30" disabled />
          </div>
          <div class="button-area">
            <div class="top-button">
              <button class="exambutton" style="background-color: rgba(255, 78, 13, 0.911)">
                Add Student
              </button>
              <button class="exambutton" style="background-color: rgba(13, 134, 255, 0.911)">
                Add Question
              </button>
            </div>
            <div class="bottom-button">
              <button class="exambutton" id="eid-but" style="background-color: rgba(255, 39, 39, 0.911)"
                onclick="changeExamCard('eid')">
                Edit Exam
              </button>
            </div>
          </div>
        </div>
      </div>

      <div class="exam-card">
        <div class="exam-card-header">
          <h2>DSA</h2>
          <input type="text" class="eid" value="eid2" style="display: none" />
        </div>
        <div class="exam-card-body">
          <div class="body-time">
            <div class="exam-card-body-item" style="border-right: 2px solid rgba(0, 0, 0, 0.472)">
              <h5>Opening time</h5>
              <input type="datetime-local" id="eid2-st" class="starttime" name="starttime" value="2000-01-01T05:40:00"
                disabled />
            </div>
            <div class="exam-card-body-item">
              <h5>Closing Time</h5>
              <input type="datetime-local" id="eid2-et" class="endtime" name="endtime" value="2000-01-01T05:40:00"
                disabled />
            </div>
          </div>
          <div class="duration">
            <h3>Exam Duration(Min)</h3>
            <input type="text" id="eid2-dur" value="30" disabled />
          </div>
          <div class="button-area">
            <div class="top-button">
              <button class="exambutton" style="background-color: rgba(255, 78, 13, 0.911)">
                Add Student
              </button>
              <button class="exambutton" style="background-color: rgba(13, 134, 255, 0.911)">
                Add Question
              </button>
            </div>
            <div class="bottom-button">
              <button class="exambutton" id="eid2-but" style="background-color: rgba(255, 39, 39, 0.911)"
                onclick="changeExamCard('eid2')">
                Edit Exam
              </button>
            </div>
          </div>
        </div>
      </div>
      <div class="exam-card"></div>
      <div class="exam-card"></div>
      <div class="exam-card"></div>
      <div class="exam-card"></div>
      <div class="exam-card"></div>
      <div class="exam-card"></div>
    </div>
  </main>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="public/js/addExam.js"></script>
</body>

</html>