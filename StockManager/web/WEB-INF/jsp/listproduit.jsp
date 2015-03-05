<%-- 
    Document   : listEmployee
    Created on : 3 mars 2015, 11:17:32
    Author     : Romain
--%>

<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
        <li><a href="#">Liste des Produits</a></li>
    </ul>
    <a class="quick-button span2" href="AddProduit.stk">
        <i class="icon-group"></i>
        <p>Ajout d'un produit</p>
    </a><br/><br/><br/><br/><br/><br/>

    <div class="row-fluid sortable">
        <table  id="example" class="table table-striped table-bordered bootstrap-datatable datatable">
            <thead>
                <tr>
                    <th>Categorie</th>
                    <th>Id Produit</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Prix</th>
                    <th>Maximum en stock</th>
                    <th>Minimum en stock</th>
                    <th>en Stock</th>
                    <th>Action</th>
                </tr>
            </thead>   
            <tbody>
                <c:forEach items="${myList}" var="element"> 
                    <tr>
                        <td>${element.category.nameCategory}</td>
                        <td>${element.idProduct}</td>
                        <td class="center">${element.nameProduct}</td>
                        <td class="center">${element.descriptifProduct}</td>
                        <td class="center">${element.priceProduct} €</td>
                        <td class="center">${element.maxStockProduct}</td>
                        <td class="center">${element.minStockProduct}</td>
                        <td class="center">${element.stockProduct}</td>
                        <td class="center">
                            <a class="btn btn-info" href="ModifProduit.stk?id=${element.idProduct}">
                                <i class="halflings-icon white edit"></i>  
                            </a>
                            <a class="btn btn-danger" href="SupProduit.stk?id=${element.idProduct}">
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