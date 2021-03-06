<%-- 
    Document   : header
    Created on : 3 mars 2015, 09:06:13
    Author     : Romain
--%>

<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- start: Meta -->
        <meta charset="utf-8">
        <title>StockManager</title>
        <meta name="description" content="Gère votre stock">
        <meta name="author" content="Flamant Romain">
        <meta name="keyword" content="Stock, Manager, Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <!-- end: Meta -->

        <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- end: Mobile Specific -->

        <!-- start: CSS -->
        <link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
        <!-- end: CSS -->


        <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
                <link id="ie-style" href="css/ie.css" rel="stylesheet">
        <![endif]-->

        <!--[if IE 9]>
                <link id="ie9style" href="css/ie9.css" rel="stylesheet">
        <![endif]-->

        <!-- start: Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- end: Favicon -->




    </head>

    <body>
        <c:if test="${sessionScope.userConnecte == null}">
            <c:redirect url="login.stk"></c:redirect>
        </c:if>
        <!-- start: Header -->
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="index.html"><span>StockManager</span></a>

                    <!-- start: Header Menu -->
                    <div class="nav-no-collapse header-nav">
                        <ul class="nav pull-right">
                            <li class="dropdown hidden-phone">
                                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="icon-bell"></i>
                                    <span class="badge red">
                                        ${nbProduitHorsStock} </span>
                                </a>
                                <ul class="dropdown-menu notifications">
                                    <li class="dropdown-menu-title">
                                        <span>Vous avez ${nbProduitHorsStock} alerte de stock</span>
                                        <a href="#refresh"><i class="icon-repeat"></i></a>
                                    </li>
                                    <c:forEach items="${lProduitHorsStock}" var="element">
                                        <li class="warning">
                                            <a href="#">
                                                <span class="icon red"><i class="icon-shopping-cart"></i></span>
                                                <span class="message">Hors stock : ${element.nameProduct}</span>

                                            </a>
                                        </li>
                                    </c:forEach>
                                    <c:forEach items="${lProduitSurStock}" var="element">
                                        <li class="info">
                                            <a href="#">
                                                <span class="icon blue"><i class="icon-shopping-cart"></i></span>
                                                <span class="message">Surplus : ${element.nameProduct}</span>

                                            </a>
                                        </li>
                                    </c:forEach>

                                    	
                                </ul>
                            </li>


                            <!-- start: User Dropdown -->
                            <li class="dropdown">
                                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="halflings-icon white user"></i>${sessionScope.userConnecte.firstNameEmployee}
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="dropdown-menu-title">
                                        <span>Paramètre Compte</span>
                                    </li>
                                    <li><a href="profileUser.stk"><i class="halflings-icon user"></i> Profile</a></li>
                                    <li><a href="deconection.stk"><i class="halflings-icon off"></i> Deconnection</a></li>
                                </ul>
                            </li>
                            <!-- end: User Dropdown -->
                        </ul>
                    </div>
                    <!-- end: Header Menu -->

                </div>
            </div>
        </div>
