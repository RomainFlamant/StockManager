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
        <li><a href="index.stk">Accueil</a></li>
    </ul>
    <div class="row-fluid">	

        <a href="AllCustomers.stk" class="quick-button metro yellow span2">
            <i class="icon-credit-card"></i>
            <p>Clients</p>
            <span class="badge">${clientNbr}</span>
        </a>
        <a href="AllInvoice.stk" class="quick-button metro red span2">
            <i class="icon-truck"></i>
            <p>Facture ce mois</p>
            <span class="badge">${facturemonthNbr}</span>
        </a>
        <a href="listCommandes.stk" class="quick-button metro blue span2">
            <i class="icon-shopping-cart"></i>
            <p>Commande ce mois</p>
            <span class="badge">${commandemonthNbr}</span>
        </a>
        <a class="quick-button metro green span2">
            <i class="icon-retweet"></i>
            <p>Produit hors stock</p>
            <span class="badge">${produitHSNbr}</span>
        </a>
        <a class="quick-button metro pink span2">
            <i class="icon-eye-close"></i>
            <p>Produit en surplu</p>
            <span class="badge">${produitSSNbr}</span>
        </a>
        <a class="quick-button metro black span2">
            <i class="icon-money"></i>
            <p>Chiffre d'affaire</p>
            <span class="badge">14 M€</span>
        </a>

        <div class="clearfix"></div>

    </div><!--/row-->
    <br>




</div><!--/.fluid-container-->

<!-- end: Content -->
</div><!--/#content.span10-->
</div><!--/fluid-row-->

<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <p>Here settings can be configured...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>

<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <ul class="list-inline item-details">
            <li><a href="http://themifycloud.com">Admin templates</a></li>
            <li><a href="http://themescloud.org">Bootstrap themes</a></li>
        </ul>
    </div>
</div>

<%@include file="includes/footer.jsp" %>