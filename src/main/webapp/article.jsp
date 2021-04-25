    <%@ page import="models.Article" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="language" value="${not empty param.language ? param.language :not empty language ? language : pageContext.request.locale  }" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:bundle basename="messages.messages"  >
<html>
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>index</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
               
        		<h2>Détail de l'article </h2>
        		
        		 <div class="container"> 
              <% Article article= (Article) request.getAttribute("article");%>
              <div class="row" > 
                    <div class="col">
                        <figure><img src="<%= article.getPhoto() %>" style="width:150px; height:150px;" /></figure>
                       
                    </div>

                    <div class="col">
                            
       

      <h4>Designation :</h4>
<p style="color:#7b777d";><%= article.getDesignation() %></p>
 <h4>Categorie :</h4>
<p style="color:#7b777d";><%= article.getCategorie() %></p>
 <h4>Stock :</h4>
<p style="color:#7b777d";><%= article.getStock() %></p>
 <h4>Prix :</h4>
<p style="color:#7b777d";><fmt:formatNumber value="<%= article.getPrix() %>" type="currency"/></p>
 <a href="CategorieServlet" >retour</a>             
                </div>
                </div>
                </div>
            </div>
        </div>
    </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body>
</fmt:bundle>
</html>