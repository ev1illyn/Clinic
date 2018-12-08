/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loki.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.loki.repositories.EmployeeRepository;
import br.com.loki.model.Employee;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Emilly Oliveira
 */
@Controller
@Path("employee")
public class EmployeeController {

    @Inject
    private Result result;

    @Inject
    private EmployeeRepository employeeRepository;

    @Get("new")
    public void formView() {
    }

    @Post("save")
    public void save(Employee employee) {
        employeeRepository.save(employee);
        result.redirectTo(this).listView();
    }

    @Get("remove/{cpf}")
    public void delete(String cpf) {
        employeeRepository.remove(cpf);
        result.redirectTo(this).listView();
    }

    @Post("update")
    public void update(Employee employee) {
        employeeRepository.update(employee);
        result.redirectTo(this).listView();
    }

    @Get("list")
    public void listView() {
        result.include("employeeList", employeeRepository.list());
    }

    @Get("detail/{id}")
    public void searchById(Integer id) {
        Employee employee = employeeRepository.searchById(id);
        result.include("employee", employee);
        result.redirectTo(this).updateView();
    }

    private void updateView() {

    }

    @Get("search")
    public void searchByPostOrCpf(String search) {
        List<Employee> employeeList = employeeRepository.searchByPostOrCpf(search);
        System.out.println(employeeList);
        System.out.println(employeeList.toString());
        result.include("employeeList", employeeList);
        result.redirectTo(this).listView();
    }

}
