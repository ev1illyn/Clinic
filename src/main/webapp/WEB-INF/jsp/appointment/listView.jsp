<%-- 
    Document   : listView
    Created on : 28/11/2018, 16:13:15
    Author     : Emilly Oliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listar Agendamentos</title>
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
                        <h2 class="ui header center aligned">Lista de Agendamentos</h2>
                        <div class="ui divider"></div>
                        <form action="${pageContext.request.contextPath}/appointment/search" class="ui form">
                            <div class="ui action fluid input">
                                <input type="text" placeholder="Buscar por CRM do Médico ou CPF do Paciente...">
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
                                            <th>Status</th>
                                            <th>Data</th>
                                            <th>Paciente</th>
                                            <th>Médico</th>
                                            <th>Pagamento</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${appointmentList}" var="appointment">
                                            <tr>			    
                                                <td>${appointment.status}</td>
                                                <td>${appointment.appointmentDate}</td>
                                                <td>${appointment.patient.name}</td>
                                                <td>${appointment.doctor.name}</td>
                                                <td>${appointment.employee.name}</td>
                                                <td>${appointment.paymentStatus}</td>
                                                <td class="right aligned">
                                                    <div class="ui red horizontal label">
                                                        <a href="appointment/remove/${appointment.id}">Excluir</a>
                                                    </div>
                                                    <div class="ui blue horizontal label">
                                                        <a a href="appointment/update/${appointment.id}">Editar</a>
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
