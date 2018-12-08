<%-- 
    Document   : doctorListView
    Created on : 27/11/2018, 19:59:28
    Author     : Emilly Oliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listar Médicos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/semantic.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adjust.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sem/components/icon.min.css"/>
        <style type="text/css">
            .container > .grid > .clinica > .welcome, .clinica > .marginTop {
                margin-bottom:-10px;
                margin-top: 4%;
                margin-left: 7%;
            }
        </style>
    </head>
    <body>
        <div class="ui center aligned container">
            <%@include file="../home/header.jsp" %>
        </div>
        <div class="ui container">
            <div class="ui grid stackable">
                <%@include file="../home/nav.jsp" %>
                <div class="twelve wide column right aligned">
                    <div class="ui text container segment">
                        <h2 class="ui header center aligned">Lista de Médicos</h2>
                        <div class="ui divider"></div>
                        <form action="${pageContext.request.contextPath}/doctor/search" class="ui form">
                            <div class="ui action fluid input">
                                <input type="text" name="search" placeholder="Buscar por CRM ou CPF do Médico...">
                                <button class="ui icon button">
                                    <i class="search icon"></i>
                                </button>
                            </div>
                        </form>
                        <div class="ui divider"></div>
                        <div class="ui column grid">
                            <div class="column">
                                <table class="ui small stackable striped table">
                                    <thead>
                                        <tr>
                                            <th>Código</th>
                                            <th>Nome</th>
                                            <th>CRM</th>
                                            <th>Especialidade</th>
                                            <th>Telefone</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${doctorList}" var="doctor">
                                            <tr>			    
                                                <td>${doctor.id}</td>
                                                <td>${doctor.name}</td>
                                                <td>${doctor.licenseNumber}</td>
                                                <td>${doctor.specialization}</td>
                                                <td>${doctor.contact.phone}</td>
                                                <td class="right aligned">
                                                    <div class="ui red horizontal label">
                                                        <a href="${pageContext.request.contextPath}/doctor/remove/${doctor.cpf}"><i class="x icon"></i></a>
                                                    </div>
                                                    <div class="ui blue horizontal label">
                                                        <a a href="${pageContext.request.contextPath}/doctor/update/${doctor.id}"><i class=" info circle icon"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%@include file="../home/footer.jsp" %>
        </body>
    </html>