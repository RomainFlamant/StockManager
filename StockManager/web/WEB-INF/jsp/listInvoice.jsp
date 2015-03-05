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
        <li><a href="#">Liste des facture</a></li>
    </ul>
    <a class="quick-button span2" href="addInvoice.stk">
        <i class="icon-group"></i>
        <p>Ajout d'une facture</p>
    </a><br/><br/><br/><br/><br/><br/>
    <div class="row-fluid sortable">		

        <table class="table table-striped table-bordered bootstrap-datatable datatable">
            <thead>
                <tr>
                    <th>Num</th>
                    <th>Produit</th>
                    <th>Fournisseur</th>
                    <th>Quantité</th>
                    <th>Date</th>
                    
                </tr>
            </thead>   
            <tbody>
                <c:forEach items="${myList}" var="element"> 
                    <tr>
                        <td>${element.numInvoice}</td>
                        <td class="center">${element.product.nameProduct}</td>
                        <td class="center">${element.supplier.nameSupplier}</td>
                        <td class="center">${element.quantityInvoice}</td>
                        <td class="center">${element.dateInvoice}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>            		
    </div><!--/row-->

</div>
<%@include file="includes/footer.jsp" %>

