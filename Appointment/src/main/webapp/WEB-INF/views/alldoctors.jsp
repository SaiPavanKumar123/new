<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="appointmnet.*,java.util.*" %>
    <%List<Doctors> doctor=(List<Doctors>) request.getAttribute("alldoctors"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctors List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<h1 align="center">Doctors List</h1>
	<div class="container mt-5">
        <div class="row justify-content-center">
            <% if (doctor != null && !doctor.isEmpty()) { %>
                <% for (int i = 0; i < doctor.size(); i++) { %>
                    <div class="col-md-3 mb-3">
                       <div class="card" >
                            
                                
                                    <img class="card-img-top mx-auto" style="height:250px; width:250px;" class="card-img-top" src="<%=doctor.get(i).getPhoto() %>" alt="Doctor's Photo">
                               
                         		 <div class="card-body">
                                <h3 style="font-weight: bold;"><%=doctor.get(i).getFullName()%></h3>
                                <p  style="font-weight: bold; align:left;"><%=doctor.get(i).getDesignation() %></p>
                               <input type="hidden" name="doctorid" value="<%= doctor.get(i).getDoctorId() %>">
                              <form action="http://localhost:9010/Appointment/doctorinfo" method="get">
    <input type="hidden" name="doctorid" value="<%= doctor.get(i).getDoctorId() %>">
    <button class="btn btn-primary">Get Information</button>
</form>

                            </div>
                        </div>
                    </div>
                <% } %>
            <% }  %>
               
        </div>
    </div>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>