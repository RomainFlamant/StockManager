<%-- 
    Document   : listCommandes
    Created on : 5 mars 2015, 09:57:11
    Author     : mou_h_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/menu.jsp" %>
<div id="content" class="span10">


    <ul class="breadcrumb">
        <li>
            <i class="icon-home"></i>
            <a href="index.stk">Site</a> 
            <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">Liste des Commandes</a></li>
    </ul>
    <div class="row-fluid sortable">		

        <table class="table table-striped table-bordered bootstrap-datatable datatable">
            <thead>
                <tr>
                    
                    <th>Quantité</th>
                    <th>Date Commande</th>
                    <th>Actions</th>
                </tr>
            </thead>   
            <tbody>
                <c:if test="${myList.isEmpty()}">
                    <tr>
                        <td colspan="5">Aucun resultat trouvé</td>
                    </tr>
                </c:if>
                <c:forEach items="${myList}" var="element"> 
                    <tr>
                        
                        <td class="center">${element.quantityOrder}</td>
                        <td class="center">${element.dateOrders}</td>
                        <td class="center">
                                <a class="btn btn-success" href="#">
                                        <i class="halflings-icon white zoom-in"></i>  
                                </a>
                                <a class="btn btn-info" href="#">
                                        <i class="halflings-icon white edit"></i>  
                                </a>
                                <a class="btn btn-danger" href="#">
                                        <i class="halflings-icon white trash"></i> 
                                </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>            		
    </div><!--/row-->

</div>
<%@include file="includes/footer.jsp" %>

