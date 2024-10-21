<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp" %>
      <div class="container p-3">
      	<div class="row">
      		<div class="col-md-6 offset-md-3">
      			<div class="card text-center ">
        <div class="card-header"><h2>Add New Student</h2></div>
        <div class="card-body">
          <form action="addStudent" method="post">
          	<p class="text-success"><b>${msg}</b></p>
            <div class="form-floating">
              <input type="text" name="fname" class="form-control" placeholder="first name" required />
              <label>First Name</label>
            </div>
            <div class="form-floating mt-3">
                <input type="text" name="lname" class="form-control" placeholder="last name" required />
                <label>Last Name</label>
            </div>
            <div class="form-floating mt-3">
                <input type="email" name="email" class="form-control" placeholder="emailid" required />
                <label>Email Id</label>
            </div>
            <div class="form-floating mt-3">
                <input type="date" name="dob" class="form-control" placeholder="emailid" required />
                <label>Date Of birth</label>
            </div>
            <div class="form-floating my-3">
                <select class="form-select" id="floatingSelect" name="course">
                  <option value="">--select--</option>
                  <option value="c">C</option>
                  <option value="c++">C++</option>
                  <option value="java">Java</option>
                  <option value="python">Python</option>
                </select>
                <label for="floatingSelect">Course</label>
              </div>
            <button type="submit" class="btn btn-outline-primary w-50">Add Student</button>
          </form>
        </div>
      </div>
      		</div>
      	</div>
      </div>
</body>
</html>