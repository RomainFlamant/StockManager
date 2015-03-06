<%-- 
    Document   : listEmployee
    Created on : 3 mars 2015, 11:17:32
    Author     : Romain
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
        <li><a href="#">Liste des clients</a></li>
    </ul>
    <a class="quick-button span2" href="AddClients.stk">
        <i class="icon-group"></i>
        <p>Ajout d'un client</p>
    </a><br/><br/><br/><br/><br/><br/>
    <div class="row-fluid sortable">		

        <table class="table table-striped table-bordered bootstrap-datatable datatable">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Siret</th>
                    <th>Type</th>
                    <th>Adresse</th>
                    <th>Actions</th>
                </tr>
            </thead>   
            <tbody>
                <c:forEach items="${myList}" var="element"> 
                    <tr>
                        <td>${element.idCustomer}</td>
                        <td>${element.nameCustomer}</td>
                        <td class="center">${element.siretCustomer}</td>
                        <td class="center">${element.typeCustomer}</td>
                        <td class="center">
                            ${element.adressCustomer} ${element.cpcustomer} ${element.villeCustomer} 
                        </td>
                        <td class="center">
                            <a class="btn btn-info" href="ModifClient.stk?id=${element.idCustomer}">
                                <i class="halflings-icon white edit"></i>  
                            </a>
                            <a class="btn btn-danger" href="SupClient.stk?id=${element.idCustomer}">
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
