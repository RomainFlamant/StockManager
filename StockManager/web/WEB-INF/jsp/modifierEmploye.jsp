<%-- 
    Document   : modifierProfile
    Created on : 3 mars 2015, 15:22:26
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
        <li><a href="#">Modification de l'empoyé</a></li>
    </ul>   
    <c:set var="valeur" scope="session" value="success"/>
    <c:if test="${ResultForm == valeur}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Modification réussie</strong> Vous pouvez vous connecter avec votre nouveau mot de passe.
        </div>
    </c:if>
    
     <c:set var="valeurError" scope="session" value="error"/>
    <c:if test="${ResultFormError == valeurError}">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong> Echec Modification </strong> Le nouveau de mot de passe et sa confirmation doit correspondre.
        </div>
    </c:if>
    <form cssClass="form-horizontal" action="" method="post">
        <div class="form-actions" style="margin-bottom: 20px;">
            <h1>Merci de rentrer toutes les informations suivantes.</h1>
        </div>
            <div class="control-group">
                <label cssClass="control-label" >Ancien mot de passe :<label>
                <div class="controls">
                <input cssClass="span6 typeahead" name="ancienmdp"  type="password" required/>
                </div>
            </div>
             <div class="control-group">
                <label cssClass="control-label" >Nouveau mot de passe :<label>
                <div class="controls">
                <input cssClass="span6 typeahead" name="nouveaumdp"  type="password"  required/>
                </div>
            </div>
         <div class="control-group">
                <label cssClass="control-label" >Confirmation mot de passe :<label>
                <div class="controls">
                <input cssClass="span6 typeahead" name="confirmationmdp"  type="password"  required/>
                </div>
            </div>
                
               
            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <button type="reset" class="btn">Anuler</button>
            </div>
    </form>
</div>

<%@include file="includes/footer.jsp" %>
