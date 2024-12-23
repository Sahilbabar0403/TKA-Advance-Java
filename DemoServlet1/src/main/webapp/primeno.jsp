<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prime Numbers</title>
</head>
<body>
<h1>Prime Numbers</h1> 
<% 
    for (int i = 2; i <= 100; i++) {
        boolean isPrime = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
%>
        <p><%= "Prime number: " + i %></p>
<% 
        }
    }
%>


</body>
</html>