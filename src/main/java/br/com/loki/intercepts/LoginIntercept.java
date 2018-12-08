/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loki.intercepts;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.loki.annotations.Public;
import br.com.loki.components.EmployeeSession;
import br.com.loki.controllers.LoginController;
import javax.inject.Inject;

/**
 *
 * @author Emilly Oliveira
 */
// INTERCEPTA REQUISIÇÃO DO USUÁRIO
@Intercepts
public class LoginIntercept implements Interceptor {

    @Inject
    private EmployeeSession userSession;
    @Inject
    private Result result;

    @Override
    public void intercept(InterceptorStack stack, ControllerMethod method, Object controllerInstance)
            throws InterceptionException { // verifica se o usuário está logado para ir pra home, se nao estiver
        // é redirecionado para a página de login
        if (userSession.isLogged()) {
            stack.next(method, controllerInstance);
        } else {
            result.redirectTo(LoginController.class).loginView();
        }
    }

    @Override // method => Representa o método associado com a URL ( Rota )
    // retorna true/false se o método não tiver a anotação @Public
    public boolean accepts(ControllerMethod method) {
        return !method.containsAnnotation(Public.class);
    }

}
