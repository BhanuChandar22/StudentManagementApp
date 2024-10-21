<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management Application</title>
</head>
<body class="bg-light" >
	<%@include file="navbar.jsp" %>
<%-- 	<% request.getRequestDispatcher("/getStudents").forward(request, response); %> --%>
	<div class="container p-3">
      <div class="card">
        <div class="card-body">
          <p class="text-center fs-1">All Student Details</p>
          <p class="text-success"><b>${msg}</b></p>
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th scope="col">Sno</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email Id</th>
                <th scope="col">Date Of Birth</th>
                <th scope="col">Course</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach items="${students}" var="student">
             	<tr>
             		 <td>${student.id}</td>
			        <td>${student.fname}</td>
			        <td>${student.lname}</td>
			        <td>${student.email}</td>
			        <td>${student.dob}</td>
			        <td>${student.course}</td>
             		<td>
                  		<a href="editStudent?id=${student.id}" class="btn btn-sm btn-success rounded">Edit</a>
                  		<a href="deleteStudent?id=${student.id}" class="btn btn-sm btn-danger rounded">Delete</a>
                	</td>
             	</tr>
             </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
</body>
</html>