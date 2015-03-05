<%-- 
    Document   : upSupplier
    Created on : 4 mars 2015, 19:48:41
    Author     : mou_h_000
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
        <li><a href="#">Modification d'un produit</a></li>
    </ul>   
    <form:form cssClass="form-horizontal" action="" method="post" modelAttribute="product">
        <div class="form-actions" style="margin-bottom: 20px;">
            <h1>Modification produit.<br><br>Merci de rentrer toutes les informations suivantes.</h1>
        </div>
        <div class="control-group hidden">
            <form:label cssClass="control-label" path="idProduct">Id :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="idProduct"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="category">Categorie :</form:label>
                <div class="controls">
                <form:select items="${lCateg}" itemLabel="nameCategory" itemValue="idCategory" path="category.idCategory"/>
                <a href="AddCategori.stk" class="btn btn-primary">Ajouter une categorie</a>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="nameProduct">Nom :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="nameProduct"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="descriptifProduct">Description :</form:label>
                <div class="controls">
                <form:textarea cssClass="span6 typeahead"  path="descriptifProduct"/>
            </div>
        </div>
            <div class="control-group">
            <form:label cssClass="control-label" path="priceProduct">Prix :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="priceProduct"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="maxStockProduct">Maximum en stock :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="maxStockProduct"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="minStockProduct">Minimum en stock :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="minStockProduct"/>
            </div>
        </div>
         <div class="control-group">
            <form:label cssClass="control-label" path="stockProduct">Stock initial :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="stockProduct"/>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
          <a href="AllProduct.stk" class="btn">Anuler</a>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>