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
        <li><a href="#">Modification d'un fournisseur</a></li>
    </ul>   
    <form:form cssClass="form-horizontal" action="" method="post" modelAttribute="supplier">
        <div class="form-actions" style="margin-bottom: 20px;">
            <h1>Modification fournisseur.<br><br>Merci de rentrer toutes les informations suivantes.</h1>
        </div>
        <div class="control-group hidden">
            <form:label cssClass="control-label" path="idSupplier">Id :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="idSupplier"/>
            </div>
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
          <a href="AllSupplier.stk" class="btn">Anuler</a>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>