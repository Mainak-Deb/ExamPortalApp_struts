<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Notification</title>
    <link rel="stylesheet" href="public/styles/adminHome.css" />
    <link rel="stylesheet" href="public/styles/Notification.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
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
          <li class="item ">
            <a href="profile.do">
              <i class="fa-solid fa-address-card"></i>
              Profile</a>
          </li>

          <li class="item">
            <a href="studentPage.do">
              <i class="fa-solid fa-users"></i>
              Student Informations</a>
          </li>

          <li class="item">
            <a href="addExamPage.do">
              <i class="fa-solid fa-book-open"></i>
              Examination</a>
          </li>
          <li class="item selected-item">
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
      <div class="hellotext">Hello ${uname}</div>
    </nav>

    <main class="main">
       <div class="notification-center" id="notification-center" >
       </div>
      
    </main>
	
    <script src="public\js\adminHome.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="public\js\Notification.js"></script>
    
</body>
</html>