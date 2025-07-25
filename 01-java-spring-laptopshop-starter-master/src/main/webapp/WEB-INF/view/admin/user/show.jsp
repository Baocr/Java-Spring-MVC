<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Detail ${id}</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"> </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"> </script>

    <!-- <link rel="stylesheet" href="/css/demo.css"> -->
</head>

<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-12 mx-auto">
                <div class="d-flex justify-content-between">
                    <h3>User details with id = ${id}</h3>
                </div>
                <hr />
                <div class="card" style="width: 60%;">
                <div class="card-header">
                User Information 
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Id: ${id}</li>
                    <li class="list-group-item">Email: ${email}</li>
                    <li class="list-group-item">Name: ${name}</li>
                    <li class="list-group-item">Address: ${address}</li>
                </ul>
                </div>
                
    </div>
</body>