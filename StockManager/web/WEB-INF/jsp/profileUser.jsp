<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/menu.jsp" %>

<!-- start: Content -->
<div id="content" class="span10">		

    <ul class="breadcrumb">
        <li>
            <i class="icon-home"></i>
            <a href="index.stk">Site</a> 
            <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">Paramétres du compte</a></li>
    </ul>

    <div id="ParametresCompte">

        <h4 style="text-align:center"><span id="Main_LabelCreationUtilisateur">Les paramétres de votre compte</span></h4>
        <hr>
        <h5>Nom</h5><span id="Main_NomUtilisateur">${sessionScope.userConnecte.nameEmployee}</span>
        <hr>
        <h5>Prénom</h5><span id="Main_Identifiant">${sessionScope.userConnecte.firstNameEmployee}</span>
        <hr>
        <h5>Adresse électronique</h5><span id="Main_AdresseElectronique">${sessionScope.userConnecte.emailEmployee}</span>
        <hr>
        <span id="Main_MotDePAsse" class="alert alert-info">******* Mot de passe valide</span> &nbsp;<a href="modifierProfile.stk"><img src="img/Modify.png" alt="" title="Changer votre mot de passe"></a>
        <hr>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
