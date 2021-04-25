<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ page import="java.util.List" %>
  <%@ page import="java.util.ArrayList" %>
<%@ page import="models.Article" %>
<%@ page import="dao.*" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="language" value="${not empty param.language ? param.language :not empty language ? language : pageContext.request.locale  }" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:bundle basename="messages.messages"  >
<html>
    <!-- Required meta tags-->
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- Title Page-->
    <title>index</title>

    <!-- Icons font CSS-->
  

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 >BlaBlaBla-shop</h2>
                    	<h3>Catégorie : <%= request.getAttribute("cat") %></h3>
                    	
	<form method="post" action="CategorieServlet">
		<select name="categorie">
			<option value="1" >1</option>
			<option value="2" >2</option>
		</select>
		<div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Choisir Categorie</button>
      </div>
	</form>
                   
    <div align="center">
        <table  border="1"   >
            <tr>
              <th>Code Article</th>
                <th>Prix</th>
                <th>Stock</th>
                <th>Categorie</th>
                 <th>Image</th>
                <th>Ajouter au panier</th>
        </tr>
        <%List<Article> articles=(ArrayList<Article>)request.getAttribute("articles");
		for(Article article:articles){

        
          %>
          
        <tr>
            <td>
            <a href="ArticleServlet?id=<%= article.getCodearticle() %>"> <%= article.getCodearticle() %></a>
            </td>
            <td>  <fmt:formatNumber value="<%= article.getPrix() %>" type="currency"/>
            </td>
            <td> <%= article.getStock() %> </td>
            <td> <%= article.getCategorie() %> </td>
             <td><img   style="width:50pt; height:80pt;" src="<%= article.getPhoto() %>" /> </td>
           <td><a href=# >add article </a></td>
              <%
        }
        %>
    </table>

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