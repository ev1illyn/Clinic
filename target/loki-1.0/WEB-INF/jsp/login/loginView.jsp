<%-- 
    Document   : loginView
    Created on : 28/11/2018, 01:46:50
    Author     : Emilly Oliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logar</title>
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
            .container > .icon > .login{
                margin: 20px 0;
            }
        </style>
    </head>
    <body>
        <div class="ui text center aligned container">
            <div class="ui left icon h1">
                <h1 class="ui header login grey"><i class="heartbeat icon red"></i>
                    Login
                </h1>
            </div>
        </div>
        <div class="ui center aligned container">
            <div class="ui two column centered grid">
                <div class="column">
                    <form action="signin" method="post" class="ui large form">
                        <div class="ui stacked segment">
                            <div class="field">
                                <div class="ui left icon input">
                                    <i class="user icon"></i>
                                    <input type="text" name="user" placeholder="Usuário">
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui left icon input">
                                    <i class="lock icon"></i>
                                    <input type="password" name="password" placeholder="Senha">
                                </div>
                            </div>
                            <button class="ui fluid large red submit button" type="submit">Entrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>