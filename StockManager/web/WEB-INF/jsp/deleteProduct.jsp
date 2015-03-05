<%-- 
    Document   : deleteEmployee
    Created on : 4 mars 2015, 16:18:04
    Author     : mou_h00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/menu.jsp" %>

<div id="content" class="span10">		
    <ul class="breadcrumb">
        <li>
            <i class="icon-home"></i>
            <a href="index.stk">Site</a> 
            <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">Suppression d'un produit</a></li>
    </ul>   
    <c:set var="valeur" scope="session" value="success"/>
    <c:if test="${ResultForm == valeur}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Ajout réussi</strong>
        </div>
    </c:if>
    <form:form cssClass="form-horizontal"  method="post" modelAttribute="product">
        <div class="form-actions warning" style="margin-bottom: 20px;">
            <h1>Êtes-vous sûr de vouloir le supprimer ?</h1>
        </div>
        <div class="control-group hidden">
            <form:label cssClass="control-label" path="category">Categorie :</form:label>
                <div class="controls">
                <form:select items="${lCateg}" itemLabel="nameCategory" itemValue="idCategory" path="category.idCategory"/>
                <a href="AddCategori.stk" class="btn btn-primary">Ajouter une categorie</a>
            </div>
        </div>
        <div class="control-group hidden">
            <form:label cssClass="control-label" path="idProduct">id :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="idProduct"/>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-danger">Supprimer</button>
            <a href="AllProduct.stk" class="btn">Anuler</a>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>