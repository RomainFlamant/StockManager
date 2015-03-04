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
        <li><a href="#">Ajout d'un fournisseur</a></li>
    </ul>   
    <c:set var="valeur" scope="session" value="success"/>
    <c:if test="${ResultForm == valeur}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Ajout réussi</strong> L'employé peut dès à présent se connecter.
        </div>
    </c:if>
    <form:form cssClass="form-horizontal" action="" method="post" modelAttribute="supplier">
        <div class="form-actions" style="margin-bottom: 20px;">
            <h1>Ajout fournisseur.<br><br>Merci de rentrer toutes les informations suivantes.</h1>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="nameSupplier">Nom :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="nameSupplier"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="siretSupplier">Siret :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="siretSupplier"/>
            </div>
        </div>
            <div class="control-group">
            <form:label cssClass="control-label" path="addressSupplier">Adresse :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="addressSupplier"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="villeSupplier">Ville :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="villeSupplier"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="cpsupplier">Cp :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="cpsupplier"/>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
           <a href="index.stk" class="btn">Anuler</a>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>