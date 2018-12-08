<div class="ui grid stackable">
    <div class="fifteen wide column clinica">
        <button class="ui right floated blue basic button sair marginTop">
            <a href="${pageContext.request.contextPath}/logout">
                SAIR
            </a>
        </button>
        <h2 class="ui left floated medium icon header welcome">
            <i class="circular tiny heartbeat icon red animated infinite pulse delay-215s"></i>
            Bem-vindo(a), ${userSession.user}.
        </h2>
        <div class="ui divider"></div>
    </div>
    <div class="fifteen wide column">
        <div class="ui divider"></div>
    </div>
</div>