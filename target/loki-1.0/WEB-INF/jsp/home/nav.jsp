<div class="four wide column center aligned">
    <div class="ui huge vertical menu">
        <div class="item" style="font-weight:bolder;color:red;">
            CADASTRAR
            <div class="menu">
                <a href="${pageContext.request.contextPath}/patient/new" class="item">Pacientes</a>
                <a href="${pageContext.request.contextPath}/doctor/new" class="item">Médicos</a>
                <a href="${pageContext.request.contextPath}/employee/new" class="item">Funcionários</a>
            </div>
        </div>
        <div class="item" style="font-weight:bolder;color:red">
            <a href="${pageContext.request.contextPath}/appointment/new">AGENDAR</a>
        </div>
        <div class="item" style="font-weight:bolder;color:red;">
            LISTAR
            <div class="menu">
                <a href="${pageContext.request.contextPath}/appointment/list" class="item">Agendamentos</a>
                <a href="${pageContext.request.contextPath}/patient/list" class="item">Pacientes</a>
                <a href="${pageContext.request.contextPath}/doctor/list" class="item">Médicos</a>
                <a href="${pageContext.request.contextPath}/employee/list" class="item">Funcionários</a>
            </div>
        </div>
    </div>
</div>