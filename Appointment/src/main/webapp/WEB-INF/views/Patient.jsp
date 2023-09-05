<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient Details</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="font-family:times-roman">
    <div class="container mt-5">
        <h1>Patient Details</h1>
        <!-- Bootstrap Form -->
        <form>
            <!-- Patient ID -->
            <div class="mb-3">
                <label for="patientId" class="form-label">Patient ID</label>
                <input type="text" class="form-control" id="patientId" name="patientId" required>
            </div>
            
            <!-- Name -->
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            
            <!-- Age -->
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="number" class="form-control" id="age" name="age" required>
            </div>
            
            <!-- Gender -->
            <div class="mb-3">
                <label class="form-label">Gender</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="male" value="Male" required>
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="Female" required>
                    <label class="form-check-label" for="female">Female</label>
                </div>
            </div>
            
            <!-- Weight -->
            <div class="mb-3">
                <label for="weight" class="form-label">Weight (in kg)</label>
                <input type="number" class="form-control" id="weight" name="weight" required>
            </div>
            
            <!-- Date of Birth -->
            <div class="mb-3">
                <label for="dob" class="form-label">Date of Birth</label>
                <input type="date" class="form-control" id="dob" name="dob" required>
            </div>
            
            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    
    <!-- Include Bootstrap JS and jQuery (if needed) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
