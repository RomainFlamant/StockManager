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
    <a class="quick-button span2" href="addCommandes.stk">
        <i class="icon-group"></i>
        <p>Ajout d'une commande</p>
    </a><br/><br/><br/><br/><br/><br/>
    <div class="row-fluid sortable">		

        <table class="table table-striped table-bordered bootstrap-datatable datatable">
            <thead>
                <tr>
                    <th>Num Commande</th>
                    <th>Client</th>
                    <th>Produit Id</th>
                    <th>Produit</th>
                    <th>Quantité</th>
                    <th>Date Commande</th>
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
                        <td class="center">${element.numOrder}</td>
                        <td class="center">${element.customer.idCustomer} : ${element.customer.nameCustomer}</td>
                        <td class="center">${element.product.idProduct}</td>
                        <td class="center">${element.product.nameProduct}</td>
                        <td class="center">${element.quantityOrder}</td>
                        <td class="center">${element.dateOrders}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>            		
    </div><!--/row-->

</div>
<%@include file="includes/footer.jsp" %>

