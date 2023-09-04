<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.SimpleDateFormat, appointment.SlotCalendar" %>
<% 
    List<SlotCalendar> data = (List<SlotCalendar>) request.getAttribute("slots");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Today's Calendar</title>
    <!-- Use Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        /* Additional Custom CSS (if needed) */
        .calendar {
            margin-top: 20px;
        }
        /* Add a cursor pointer style to indicate clickable cells */
        td.clickable {
            cursor: pointer;
        }
        .today {
            background-color: yellow;
        }
        .disabled {
            pointer-events: none;
            background-color: lightgray;
        }
        .btn-day {
            width: 60%;
            margin: 5px;
        }
        .btn-available {
            background-color: green;
            color: white;
        }
        .btn-unavailable {
            background-color: grey;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mt-4 mb-4">Today's Calendar</h1>
        <div class="calendar table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Sun</th>
                        <th>Mon</th>
                        <th>Tue</th>
                        <th>Wed</th>
                        <th>Thu</th>
                        <th>Fri</th>
                        <th>Sat</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        java.util.Calendar today = java.util.Calendar.getInstance();
                        today.set(java.util.Calendar.HOUR_OF_DAY, 0);
                        today.set(java.util.Calendar.MINUTE, 0);
                        today.set(java.util.Calendar.SECOND, 0);
                        today.set(java.util.Calendar.MILLISECOND, 0);
                        today.set(java.util.Calendar.DAY_OF_MONTH, 1); // Set to the first day of the current month
                        int firstDayOfWeek = today.get(java.util.Calendar.DAY_OF_WEEK);

                        int daysInMonth = today.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

                        // Fill in the empty cells for the days before the first day of the month
                        for (int i = java.util.Calendar.SUNDAY; i < firstDayOfWeek; i++) {
                    %>
                        <td></td>
                    <%
                        }

                        for (int day = 1; day <= daysInMonth; day++) {
                            String myDate = dateFormat.format(today.getTime());
                            String servletURL = "http://localhost:8080/DoctorAppointment/doctor?day=" + myDate;
                            boolean isToday = (day == today.get(java.util.Calendar.DAY_OF_MONTH));
                            boolean isDisabled = (today.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SATURDAY || today.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SUNDAY); // Disable weekends
                            String tdClass = isToday ? "today" : isDisabled ? "disabled" : "clickable";
                            
                            // Check if the date exists in the data list
                            boolean isDataAvailable = false;
                            for (SlotCalendar slot : data) {
                                if (myDate.equals(dateFormat.format(slot.getSlotdate()))) {
                                    isDataAvailable = true;
                                    break;
                                }
                            }
                            
                            // Set the btnClass based on availability
                            String btnClass;
                            if (isDataAvailable) {
                                btnClass = "btn btn-available btn-day";
                            } else {
                                btnClass = "btn btn-unavailable btn-day";
                            }
                    %>
                            <td class="<%= tdClass %>">
                                <button class="<%= btnClass %>" onclick="<%= isDataAvailable ? "handleSlotClick('" + servletURL + "')" : "showPopup()" %>"><%= day %></button>
                            </td>
                    <%
                            if (today.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SATURDAY) {
                    %>
                        </tr><tr>
                    <%
                            }
                            today.add(java.util.Calendar.DAY_OF_MONTH, 1);
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Add Bootstrap JS and jQuery (if needed) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MoGn538z5U7b+OrCXmKA6Q5/Um5z9zNfzbsC6JZs5r5jft02a5r5jft02+aR5a6E" crossorigin="anonymous"></script>

    <script>
        function handleSlotClick(url) {
            if (!https://github.com/) {
                return; 
            }
            
            window.location.href = https://github.com/; // Redirect to the URL
        }
        
        function showPopup() {
            alert("Slot is unavailable.");
        }
    </script>
</body>
</html>
