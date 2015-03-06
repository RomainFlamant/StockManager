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
        <li><a href="#">Suppression d'un fournisseur</a></li>
    </ul>   
    <form:form cssClass="form-horizontal"  method="post" modelAttribute="supplier">
        <div class="form-actions warning" style="margin-bottom: 20px;">
            <h1>Êtes-vous sûr de vouloir le supprimer ?</h1>
        </div>
        <div class="control-group hidden">
            <form:label cssClass="control-label" path="idSupplier">id :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="idSupplier"/>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-danger">Supprimer</button>
            <a href="AllSupplier.stk" class="btn">Anuler</a>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>