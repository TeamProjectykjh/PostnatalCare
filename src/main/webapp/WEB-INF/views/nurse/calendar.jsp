<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='utf-8' />
    <link href='fullcalendar-5.11.0/lib/main.css' rel='stylesheet' />
    <script src='fullcalendar-5.11.0/lib/main.js'></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
        });
        calendar.render();
      });

    </script>
  </head>
  <body>
    <div id='calendar'></div>
  </body>
</html>
<!--  
    let calendar = new Calendar(calendarEl, {
    	  plugins: [ googleCalendarPlugin ],
    	  googleCalendarApiKey: 'AIzaSyDvC92CXktCkohXLjCzktb-UTYvKjXhB4M',
    	  events: {
    	    googleCalendarId: 'u231lugs8ls1hjsvs45nu8ugc4@group.calendar.google.com',
    	    className: 'gcal-event' // an option!
    	  }
    	});  
        calendar.render();
     -->
