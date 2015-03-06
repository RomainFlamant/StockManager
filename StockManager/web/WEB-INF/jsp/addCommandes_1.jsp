<%-- 
    Document   : addCommandes
    Created on : 5 mars 2015, 10:38:17
    Author     : mou_h_000
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/menu.jsp" %>

<div id="content" class="span10">		
    <ul class="breadcrumb">
        <li>
            <i class="icon-home"></i>
            <a href="index.stk">Site</a> 
            <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">Ajout Commande</a></li>
    </ul>   
    <form:form cssClass="form-horizontal" action="addProducttoCmd.stk" method="post" modelAttribute="ordp">
        <div class="control-group hidden">
            <form:label cssClass="control-label" path="orders.numOrder">commande :</form:label>
                <div class="controls">
                <form:select items="${lOrder}" itemLabel="numOrder" itemValue="numOrder" path="orders.numOrder"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="product.idProduct">Produit :</form:label>
                <div class="controls">
                <form:select items="${lProduct}" itemLabel="nameProduct" itemValue="idProduct" path="product.idProduct"/>
            </div>
        </div> 
        <div class="control-group">
            <form:label cssClass="control-label" path="quantityOrder">Quantité :</form:label>
                <div class="controls">
                <form:input cssClass="span6 typeahead"  path="quantityOrder"/>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Ajouter le produit à la commande et cloturé</button>
            <button type="submit" class="btn btn-primary">Continué</button>
            <button type="reset" class="btn">Anuler</button>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>