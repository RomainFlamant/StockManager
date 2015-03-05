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
    <a class="quick-button span2" href="addSupplier.stk">
        <i class="icon-group"></i>
        <p>Ajout d'un fournisseur</p>
    </a><br/><br/><br/><br/><br/><br/>
    <div class="row-fluid sortable">		

        <table class="table table-striped table-bordered bootstrap-datatable datatable">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Siret</th>
                    <th>Adresse</th>
                    <th>Actions</th>
                    
                </tr>
            </thead>   
            <tbody>
                <c:forEach items="${myList}" var="element"> 
                    <tr>
                        <td>${element.idSupplier}</td>
                        <td>${element.nameSupplier}</td>
                        <td class="center">${element.siretSupplier}</td>
                        <td class="center">
                            ${element.addressSupplier} ${element.cpsupplier} ${element.villeSupplier} 
                        </td>
                        <td class="center">
                            <a class="btn btn-info" href="upSupplier.stk?id=${element.idSupplier}">
                                <i class="halflings-icon white edit"></i>  
                            </a>
                            <a class="btn btn-danger" href="deleteSupplier.stk?id=${element.idSupplier}">
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

