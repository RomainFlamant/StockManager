<%-- 
    Document   : addEmployee
    Created on : 3 mars 2015, 15:22:26
    Author     : Romain
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
        <li><a href="#">Ajout d'une facture</a></li>
    </ul>   
    <form:form cssClass="form-horizontal" action="" method="post" modelAttribute="invoice">
        <div class="form-actions" style="margin-bottom: 20px;">
            <h1>Ajout facture.<br><br>Merci de rentrer toutes les informations suivantes.</h1>
        </div>
       <div class="control-group">
            <form:label cssClass="control-label" path="supplier.nameSupplier">Fournisseur :</form:label>
                <div class="controls">
                <form:select items="${lSupplier}" itemLabel="nameSupplier" itemValue="idSupplier" path="supplier.idSupplier"/>
                <a href="addSupplier.stk?history=AddProduit&history2=&history3=" class="btn btn-primary">Ajouter un fournisseur</a>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="product.nameProduct">Produit :</form:label>
                <div class="controls">
                <form:select items="${lProduct}" itemLabel="nameProduct" itemValue="idProduct" path="product.idProduct"/>
                <a href="AddProduit.stk?history=AddProduit&history2=&history3=" class="btn btn-primary">Ajouter un Produit</a>
            </div>
        </div> 
        <div class="control-group">
            <form:label cssClass="control-label" path="quantityInvoice">Quantité :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="quantityInvoice"/>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
           <a href="AllSupplier.stk" class="btn">Anuler</a>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>