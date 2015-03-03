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
        <li><a href="#">Ajout d'un employé</a></li>
    </ul>   
    <c:set var="valeur" scope="session" value="success"/>
    <c:if test="${ResultForm == valeur}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Ajout réussi</strong> L'employé peut dès à présent se connecter.
        </div>
    </c:if>
    <form:form cssClass="form-horizontal" action="" method="post" modelAttribute="employee">
        <div class="form-actions" style="margin-bottom: 20px;">
            <h1>Merci de rentrer toutes les informations suivante.</h1>
        </div>
            <div class="control-group">
                <form:label cssClass="control-label" path="nameEmployee">Nom :</form:label>
                <div class="controls">
                    <form:input cssClass="span6 typeahead"  path="nameEmployee"/>
                </div>
            </div>
            <div class="control-group">
                <form:label cssClass="control-label" path="firstNameEmployee">Prénom :</form:label>
                <div class="controls">
                    <form:input cssClass="span6 typeahead"  path="firstNameEmployee"/>
                </div>
            </div>
            <div class="control-group">
                <form:label cssClass="control-label" path="emailEmployee">Email :</form:label>
                <div class="controls">
                    <form:input cssClass="span6 typeahead"  path="emailEmployee"/>
                </div>
            </div>
            <div class="control-group">
                <form:label cssClass="control-label" path="mdpEmployee">Mot de passe :</form:label>
                <div class="controls">
                <form:password cssClass="span6 typeahead"  path="mdpEmployee"/>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <button type="reset" class="btn">Anuler</button>
            </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>