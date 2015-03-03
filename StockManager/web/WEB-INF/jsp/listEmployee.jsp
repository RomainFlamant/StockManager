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
            <a href="index.html">Site</a> 
            <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">Liste des Employés</a></li>
    </ul>
<div class="row-fluid sortable">		

    <table class="table table-striped table-bordered bootstrap-datatable datatable">
              <thead>
                      <tr>
                              <th>Username</th>
                              <th>Date registered</th>
                              <th>Role</th>
                              <th>Status</th>
                              <th>Actions</th>
                      </tr>
              </thead>   
              <tbody>
                  <c:forEach items="${myList}" var="element"> 
                    <tr>
                    <td>${element.nameEmployee}</td>
                        <td class="center">${element.nameEmployee}</td>
                        <td class="center">${element.nameEmployee}</td>
                        <td class="center">
                                <span class="label label-success">${element.nameEmployee}</span>
                        </td>
                        <td class="center">
                                <a class="btn btn-success" href="#">
                                        <i class="halflings-icon white zoom-in"></i>  
                                </a>
                                <a class="btn btn-info" href="#">
                                        <i class="halflings-icon white edit"></i>  
                                </a>
                                <a class="btn btn-danger" href="#">
                                        <i class="halflings-icon white trash"></i> 
                                </a>
                        </td>
                    </tr>
                  </c:forEach>
                    <tr>
                            <td>Dennis Ji</td>
                            <td class="center">2012/01/01</td>
                            <td class="center">Member</td>
                            <td class="center">
                                    <span class="label label-success">Active</span>
                            </td>
                            <td class="center">
                                    <a class="btn btn-success" href="#">
                                            <i class="halflings-icon white zoom-in"></i>  
                                    </a>
                                    <a class="btn btn-info" href="#">
                                            <i class="halflings-icon white edit"></i>  
                                    </a>
                                    <a class="btn btn-danger" href="#">
                                            <i class="halflings-icon white trash"></i> 
                                    </a>
                            </td>
                    </tr>
              </tbody>
      </table>            		
</div><!--/row-->

</div>
<%@include file="includes/footer.jsp" %>
