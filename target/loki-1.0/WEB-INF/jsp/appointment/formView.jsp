<%-- 
    Document   : formView
    Created on : 28/11/2018, 14:53:09
    Author     : Emilly Oliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agendar</title>
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
                        <h2 class="ui header center aligned">Agendamento</h2>
                        <form action="${pageContext.request.contextPath}/appointment/save" method="post" class="ui form">
                            <div class="field">
                                <div class="fields">
                                    <div class="eight wide field">
                                        <label>Status</label>
                                        <select type="text" class="ui fluid search dropdown" name="appointment.status" value="${appointment.status}" required>
                                            <option value="agendado">Agendado</option>
                                            <option value="realizado">Realizado</option>
                                        </select>
                                    </div>
                                    <div class="eight wide field">
                                        <label>Data do agendamento</label>
                                        <input type="datetime-local" name="appointment.appointmentDate" value="${appointment.appointmentDate}" required>
                                    </div>
                                </div>
                            </div>
                            <div class="field">
                                <div class="fields">
                                    <div class="eight wide field">
                                        <label>Código do Paciente</label>
                                        <input type="number" name="appointment.patient" value="${appointment.patient}" placeholder="Ex: 123" required>
                                    </div>
                                    <div class="eight wide field">
                                        <label>Código do Médico</label>
                                        <input type="number" name="appointment.doctor" value="${appointment.doctor}" placeholder=" Ex: 123" required>
                                    </div>
                                </div>
                            </div>
                            <div class="field">
                                <div class="fields">
                                    <div class="sixteen wide field">
                                        <label>Código do Funcionário</label>
                                        <input type="number" name="appointment.employee" value="${appointment.employee}" placeholder="Ex: 123" required>
                                    </div>
                                </div>
                            </div>
                            <h4 class="ui dividing left aligned header info">Informações do Pagamento</h4>
                            <div class="field">
                                <div class="fields">
                                    <div class="eight wide field">
                                        <select type="text" class="ui fluid search dropdown" name="appointment.paymentForm" value="${appointment.paymentForm}" required>
                                            <option value="À vista">À Vista</option>
                                            <option value="Cartão">Cartão</option>
                                            <option value="Boleto">Boleto</option>
                                        </select>
                                    </div>
                                    <div class="eight wide field">
                                        <select type="text" class="ui fluid search dropdown" name="appointment.paymentStatus" value="${appointment.paymentStatus}" required>
                                            <option value="No prazo">No prazo</option>
                                            <option value="Pago">Pago</option>
                                            <option value="Vencido">Vencido</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="sixteen wide column right aligned">
                                <div class="ui buttons">
                                    <button class="ui button"><a href="${pageContext.request.contextPath}/">Cancelar</a></button>
                                    <div class="or" data-text="ou"></div>
                                    <button type="submit" class="ui positive button">Salvar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../home/footer.jsp" %>
    </body>
</html>