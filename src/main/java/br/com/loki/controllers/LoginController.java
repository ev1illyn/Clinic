package br.com.loki.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.loki.annotations.Public;
import br.com.loki.components.EmployeeSession;
import br.com.loki.repositories.EmployeeRepository;
import javax.inject.Inject;

/**
 *
 * @author Emilly Oliveira
 */
@Controller
public class LoginController {

    @Inject
    private Result result;
    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private EmployeeSession employeeSession;

    @Public
    @Get("login")
    public void loginView() {
    }

    @Public
    @Post("signin")
    public void authenticate(String user, String password) {
            employeeSession.setLogged(true);
            employeeSession.setUser(user);
            result.redirectTo(HomeController.class).home();
    }

    @Get("logout")
    public void logout() {
        employeeSession.setLogged(false);
        result.redirectTo(this).loginView();
    }
}
