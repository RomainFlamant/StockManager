<%-- 
    Document   : upCustomer
    Created on : 4 mars 2015, 11:14:04
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
        <li><a href="#">Modification employé</a></li>
    </ul>   
    <form:form cssClass="form-horizontal" action="" method="post" modelAttribute="employe">
        <div class="form-actions" style="margin-bottom: 20px;">
            <h1>Modification employé.<br><br>Merci de rentrer toutes les informations suivantes.</h1>
        </div>
        <div class="control-group hidden">
            <form:label cssClass="control-label" path="idEmployee">Id :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="idEmployee"/>
            </div>
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
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
          <a href="AllEmployee.stk" class="btn">Anuler</a>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>