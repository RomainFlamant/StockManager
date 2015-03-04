<%-- 
    Document   : listEmployee
    Created on : 3 mars 2015, 11:17:32
    Author     : Romain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/menu.jsp" %>
<div id="content" class="span10">


    <ul class="breadcrumb">
        <li>
            <i class="icon-home"></i>
            <a href="index.stk">Site</a> 
            <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">Liste des Employés</a></li>
    </ul>
    <div class="row-fluid sortable">		

        <table class="table table-striped table-bordered bootstrap-datatable datatable">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>email</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>   
            <tbody>
                <c:if test="${myList.isEmpty()}">
                    <tr>
                        <td colspan="5">Aucun resultat trouvé</td>
                    </tr>
                </c:if>
                <c:forEach items="${myList}" var="element"> 
                    <tr>
                        <td>${element.idEmployee}</td>
                        <td>${element.nameEmployee}</td>
                        <td class="center">${element.firstNameEmployee}</td>
                        <td class="center">${element.emailEmployee}</td>
                        <td class="center">
                            <c:if test="${element.isActive == 1}" >
                                <span class="label label-success">Actif</span>
                            </c:if>
                            <c:if test="${element.isActive == 0}">
                                <span class="label label-warning">Désactive</span>
                            </c:if>    
                        </td>
                        <td class="center">
                                <a class="btn btn-success" href="#">
                                        <i class="halflings-icon white zoom-in"></i>  
                                </a>
                                <a class="btn btn-info" href="modifierEmploye.stk?id=${element.idEmployee}">
                                        <i class="halflings-icon white edit"></i>  
                                </a>
                                <a class="btn btn-danger" href="SupEmployee.stk?id=${element.idEmployee}">
                                        <i class="halflings-icon white trash"></i> 
                                </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>            		
    </div><!--/row-->

</div>
<%@include file="includes/footer.jsp" %>
