package example;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:postgresql://192.168.110.48:5432/plf_training";
    private static final String USERNAME = "plf_training_admin";
    private static final String PASSWORD = "pff123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Employee> employees = (List<Employee>) session.getAttribute("employees");
        int currentIndex = (int) session.getAttribute("currentIndex");

        String action = request.getParameter("action");
        if (action != null && employees != null) {
            if ("first".equals(action)) {
                currentIndex = 0;
            } else if ("prev".equals(action)) {
                if (currentIndex > 0) {
                    currentIndex--;
                }
            } else if ("next".equals(action)) {
                if (currentIndex < employees.size() - 1) {
                    currentIndex++;
                }
            } else if ("last".equals(action)) {
                currentIndex = employees.size() - 1;
            } else if ("add".equals(action)) {
                // Clear fields
                currentIndex = -1;
            } else if ("edit".equals(action)) {
                // Enable editing of fields
            } else if ("save".equals(action)) {
                String empnoStr = request.getParameter("empno");
                int empno = Integer.parseInt(empnoStr);
                String name = request.getParameter("name");
                String job = request.getParameter("job");
                double salary = Double.parseDouble(request.getParameter("salary"));

                Employee employee = new Employee(empno, name, job, salary);
                if (currentIndex == -1) {
                    addEmployee(employee);
                    employees.add(employee);
                } else {
                    updateEmployee(employee);
                    employees.set(currentIndex, employee);
                }
            } else if ("delete".equals(action)) {
                if (currentIndex >= 0 && currentIndex < employees.size()) {
                    deleteEmployee(employees.get(currentIndex).getEmpno());
                    employees.remove(currentIndex);
                    currentIndex = 0;
                }
            } else if ("clear".equals(action)) {
                // Clear fields
                currentIndex = -1;
            } else if ("exit".equals(action)) {
                response.sendRedirect("exit.html");
                return;
            }
        } else {
            // Initialize employees list and currentIndex
            employees = getAllEmployees();
            currentIndex = 0;
        }

        // Update session attributes
        session.setAttribute("employees", employees);
        session.setAttribute("currentIndex", currentIndex);

        // Forward back to Employee.jsp
        request.getRequestDispatcher("Employee.jsp").forward(request, response);
    }

    // EmployeeDAO methods

    private List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM employees";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int empno = resultSet.getInt("empno");
                String name = resultSet.getString("name");
                String job = resultSet.getString("job");
                double salary = resultSet.getDouble("salary");
                employees.add(new Employee(empno, name, job, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private void addEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO employees (empno, name, job, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employee.getEmpno());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getJob());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "UPDATE employees SET name=?, job=?, salary=? WHERE empno=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getJob());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getEmpno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(int empno) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM employees WHERE empno=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, empno);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
======================================================================================================================================


  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "example.Employee" %>


<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
</head>
<body>
    <h2>Employee Management System</h2>
    <form action="EmployeeController" method="post">
        <label for="empno">Employee Number:</label>
        <input type="text" id="empno" name="empno" readonly><br><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br><br>
        <label for="job">Job:</label>
        <input type="text" id="job" name="job"><br><br>
        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary"><br><br>
        <button type="submit" name="action" value="first">First</button>
        <button type="submit" name="action" value="prev">Prev</button>
        <button type="submit" name="action" value="next">Next</button>
        <button type="submit" name="action" value="last">Last</button>
        <button type="submit" name="action" value="add">Add</button>
        <button type="submit" name="action" value="edit">Edit</button>
        <button type="submit" name="action" value="save">Save</button>
        <button type="submit" name="action" value="delete">Delete</button>
        <button type="submit" name="action" value="clear">Clear</button>
        <button type="submit" name="action" value="exit">Exit</button>
    </form>
    <%
        List<Employee> employees = (List<Employee>) session.getAttribute("employees");
        if (employees != null && !employees.isEmpty()) {
            int currentIndex = (Integer) session.getAttribute("currentIndex");
            Employee currentEmployee = employees.get(currentIndex);
    %>
    <script>
        var salaryInput = document.getElementById("salary");
        salaryInput.value = <%= currentEmployee.getSalary() %>;
        // Escaping the employee name to handle potential special characters
        var nameInput = document.getElementById("name");
        nameInput.value = '<%= currentEmployee.getName().replace("'", "\\'") %>';
        // Escaping the job to handle potential special characters
        var jobInput = document.getElementById("job");
        jobInput.value = '<%= currentEmployee.getJob().replace("'", "\\'") %>';
    </script>
    <%
        }
    %>
</body>
</html>
================================================================================================================================================
          package example;

public class Employee {
    private int empno;
    private String name;
    private String job;
    private double salary;

    public Employee(int empno, String name, String job, double salary) {
        this.empno = empno;
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public int getEmpno() {
        return empno;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }
}
