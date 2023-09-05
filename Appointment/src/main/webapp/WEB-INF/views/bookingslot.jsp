<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List, java.text.SimpleDateFormat, appointmnet.*" %>
<%
    // Retrieve the selected date and doctor ID from query parameters
    SlotCalendar sc=(SlotCalendar)request.getAttribute("selectedDate");
	List<SlotCalendar> list=(List<SlotCalendar>)request.getAttribute("selectedDate");
    

    // Fetch the slot timings for the selected date and doctor ID
    
%>

<!DOCTYPE html>
<html>
<head>
    <!-- Your HTML head content here -->
</head>
<body>
    <!-- Your HTML body content here -->
    <h1>Slot Timings for <%= sc.getSlotdate() %></h1>
    <table>
        <thead>
            <tr>
                <th>Slot ID</th>
                <th>Slot From</th>
                <th>Slot To</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Loop through the slot timings and display them
                for (SlotCalendar slot :list ) {
            %>
                <tr>
                    <td><%= slot.getSlotId() %></td>
                    <td><%= slot.getSlotfrom() %></td>
                    <td><%= slot.getSlotto() %></td>
                    <td><%= slot.getSlotstatus() %></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
