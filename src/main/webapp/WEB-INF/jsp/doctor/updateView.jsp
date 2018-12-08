<%-- 
    Document   : updateVIew
    Created on : 28/11/2018, 15:10:30
    Author     : Emilly Oliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Atualizar Médico</title>
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
                        <h2 class="ui header center aligned">Atualizar Médico</h2>
                        <form action="${pageContext.request.contextPath}/doctor/update" method="post" class="ui form">
                            <input type="hidden" name="doctor.id" value="${doctor.id}">
                            <h4 class="ui dividing left aligned header info">Informações Pessoais</h4>
                            <div class="field">
                                <div class="fields">
                                    <div class="nine wide field">
                                        <label>Nome</label>
                                        <input type="text" name="patient.name" value="${patient.name}" value="${patient.name}" maxlength="255" placeholder="Ex: Evillyn da Silva Oliveira" required>
                                    </div>
                                    <div class="three wide field">
                                        <label>Gênero</label>
                                        <select type="text" class="ui fluid search dropdown" name="patient.gender" value="${patient.gender}">
                                            <option value="feminino">Feminino</option>
                                            <option value="masculino">Masculino</option>
                                            <option value="nao_binario">Não-Binário</option>
                                        </select>
                                    </div>
                                    <div class="five wide field">
                                        <label>CPF</label>
                                        <input type="text" name="patient.cpf" value="${patient.cpf}" placeholder="Ex: 999-999-999-09" required>
                                    </div>
                                </div>
                            </div>		
                            <h4 class="ui dividing left aligned header info">Informações de Contato</h4>
                            <div class="fields">
                                <div class="eight wide field">
                                    <label>Email</label>
                                    <input type="text" name="patient.contact.email" value="${patient.contact.email}" placeholder="Ex: evillyndsoliveiras@gmail.com" required>
                                </div>
                                <div class="eight wide field">
                                    <label>Telefone</label>
                                    <input type="text" name="patient.contact.phone" value="${patient.contact.phone}" placeholder="Ex: 988776655" required>
                                </div>
                            </div>
                            <h4 class="ui dividing left aligned header info">Informações de Endereço</h4>
                            <div class="fields">
                                <div class="ten wide field">
                                    <label>Rua</label>
                                    <input type="text" name="patient.address.street" value="${patient.address.street}" placeholder="Ex: Coronel Antônio Fernandes" required>
                                </div>
                                <div class="three wide field">
                                    <label>Número</label>
                                    <input type="text" name="patient.address.streetNumber" value="${patient.address.streetNumber}" placeholder="Ex: 111A" required>
                                </div>
                                <div class="five wide field">
                                    <label>CEP</label>
                                    <input type="text" name="patient.address.zipCode" value="${patient.address.zipCode}" placeholder="Ex: 63000-00" required>
                                </div>
                            </div>
                            <h4 class="ui dividing left aligned header info">Informações do Profissional</h4>
                            <div class="field">
                                <div class="fields">
                                    <div class="six wide field">
                                        <label>Especialização</label>
                                        <input type="text" name="doctor.specialization" value="${doctor.specialization}" placeholder="Ex: Pediatria" required>
                                    </div>
                                    <div class="five wide field">
                                        <label>CRM</label>
                                        <input type="text" name="doctor.license_number" value="${doctor.licenseNumber}" placeholder="Ex: 81822" required>
                                    </div>
                                    <div class="five wide field">
                                        <label>Salário</label>
                                        <input type="text" name="doctor.salary" value="${doctor.license_salary}" placeholder="Ex: 2.000" required>
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
