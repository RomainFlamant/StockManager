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
    <c:if test="${ResultForm == valeur}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Ajout réussi</strong>
        </div>
    </c:if>
    <form:form cssClass="form-horizontal" action="" method="post" modelAttribute="commandes">
        <div class="control-group">
        <form:label cssClass="control-label" path="customer.nameCustomer">Client :</form:label>
            <div class="controls">
        <form:select items="${lCustomer}" itemLabel="nameCustomer" itemValue="idCustomer" path="customer.idCustomer"/>
                    </div>
                </div>
        <div class="control-group">
        <form:label cssClass="control-label" path="product.nameProduct">Produit :</form:label>
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
            <button type="submit" class="btn btn-primary">Enregistrer</button>
            <button type="reset" class="btn">Anuler</button>
        </div>
    </form:form>
</div>

<%@include file="includes/footer.jsp" %>