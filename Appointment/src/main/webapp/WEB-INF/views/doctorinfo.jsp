<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="appointmnet.*" %>
<% Doctors doc = (Doctors) request.getAttribute("doctorinfo"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Doctor Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <style>
        /* Container styles */
        .container {
            margin-top: 50px;
        }

        /* Image styles */
        .doctor-image {
            width: 100%;
            max-width: 400px;
            height: auto;
            display: block;
            margin: 0 auto;
            border-radius: 10px;
        }

        /* Card styles */
        .doctor-card {
            padding: 20px;
            background-color: #f8f9fa;
            border: 1px solid #007bff;
            border-radius: 10px;
        }

        /* Title styles */
        h1 {
            font-size: 28px;
            font-weight: bold;
            color: #007bff;
            margin-bottom: 20px;
        }

        /* Heading styles */
        .section-heading {
            font-size: 24px;
            font-weight: bold;
            margin: 20px 0;
            color: #007bff; /* Blue color */
        }

        /* Content styles */
        .section-content {
            font-size: 20px;
            font-weight: normal;
            margin: 10px 0;
            color: #333; /* Dark gray color */
        }
         .doctor-card {
            padding: 10px; /* Reduce padding */
            background-color: #f8f9fa;
            border: 1px solid #007bff;
            border-radius: 10px;
           
        }
        
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6">

            <img class="doctor-image" alt="Doctor Image" style="height:500px; width:600px" src="<%= doc.getPhoto() %>"><br><br>
            <form action="http://localhost:9010/Appointment/slots" method="get">
            <div class="text-center">
            <button class="btn btn-success" style="align:center;">Check availability</button>
            <input type="hidden" name="doctorid" value="<%= doc.getDoctorId() %>">
            </form></div>
        </div>
        <div class="col-md-6">
            
           
            <div class="card doctor-card">
                <h3 class="section-heading">Doctor ID:</h3>
                <p class="section-content"><%= doc.getDoctorId() %></p>

                <h3 class="section-heading">Doctor Name:</h3>
                <p class="section-content"><%= doc.getFullName() %></p>

                <h3 class="section-heading">Doctor Qualification:</h3>
                <p class="section-content"><%= doc.getQualification() %></p>

                <h3 class="section-heading">Doctor Designation:</h3>
                <p class="section-content"><%= doc.getDesignation() %></p>

                <h3 class="section-heading">Experience in years:</h3>
                <p class="section-content"><%= doc.getExperiance() %></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
