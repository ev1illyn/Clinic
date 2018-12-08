

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Funcionário</title>
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
                        <h2 class="ui header center aligned">Cadastrar Funcionário</h2>
                        <form action="${pageContext.request.contextPath}/employee/save" method="post" class="ui form">
                            <h4 class="ui dividing left aligned header info">Informações Pessoais</h4>
                            <div class="field">
                                <div class="fields">
                                    <div class="nine wide field">
                                        <label>Nome</label>
                                        <input type="text" name="employee.name" value="${employee.name}" value="${employee.name}" maxlength="255" placeholder="Ex: Evillyn da Silva Oliveira" required>
                                    </div>
                                    <div class="three wide field">
                                        <label>Gênero</label>
                                        <select type="text" class="ui fluid search dropdown" name="employee.gender" value="${employee.gender}">
                                            <option value="feminino">Feminino</option>
                                            <option value="masculino">Masculino</option>
                                            <option value="nao_binario">Não-Binário</option>
                                        </select>
                                    </div>
                                    <div class="five wide field">
                                        <label>CPF</label>
                                        <input type="text" name="employee.cpf" value="${employee.cpf}" placeholder="Ex: 999-999-999-09"  pattern="[0-9]{11}" title="digite um cpf válido" required>
                                    </div>
                                </div>
                            </div>		
                            <h4 class="ui dividing left aligned header info">Informações de Contato</h4>
                            <div class="fields">
                                <div class="eight wide field">
                                    <label>Email</label>
                                    <input type="text" name="employee.contact.email" value="${employee.contact.email}" placeholder="Ex: evillyndsoliveiras@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
                                </div>
                                <div class="eight wide field">
                                    <label>Telefone</label>
                                    <input type="number" name="employee.contact.phone" value="${employee.contact.phone}" placeholder="Ex: 988776655" required>
                                </div>
                            </div>
                            <h4 class="ui dividing left aligned header info">Informações de Endereço</h4>
                            <div class="fields">
                                <div class="ten wide field">
                                    <label>Rua</label>
                                    <input type="text" name="employee.address.street" value="${employee.address.street}" placeholder="Ex: Coronel Antônio Fernandes" required>
                                </div>
                                <div class="three wide field">
                                    <label>Número</label>
                                    <input type="text" name="employee.address.streetNumber" value="${employee.address.streetNumber}" placeholder="Ex: 111A" required>
                                </div>
                                <div class="five wide field">
                                    <label>CEP</label>
                                    <input type="text" name="employee.address.zipCode" value="${employee.address.zipCode}" placeholder="Ex: 63000-00" required>
                                </div>
                            </div>
                            <h4 class="ui dividing left aligned header info">Informações do Profissional</h4>
                            <div class="field">
                                <div class="fields">
                                    <div class="eight wide field">
                                        <label>Cargo</label>
                                        <input type="text" name="employee.post" value="${employee.post}" placeholder="Ex: Atendente" required>
                                    </div>
                                    <div class="eight wide field">
                                        <label>Salário</label>
                                        <input type="text" name="employee.salary" value="${employee.salary}" placeholder="Ex: 2.000" required>
                                    </div>
                                </div>
                            </div>
                            <h4 class="ui dividing left aligned header info">Informações de Login</h4>
                            <div class="two fields">
                                <div class="field">
                                    <label>User</label>
                                    <input type="text" name="employee.userName" value="${employee.userName}" placeholder="Nome de usuário para logar" required>
                                </div>
                                <div class="field">
                                    <label>Senha</label>
                                    <input type="password" name="employee.password" value="${employee.password}" placeholder="Senha de usuário para logar" required>
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
