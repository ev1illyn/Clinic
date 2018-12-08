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
import br.com.loki.model.Doctor;
import br.com.loki.repositories.DoctorRepository;
import javax.inject.Inject;

import java.util.List;

/**
 *
 * @author Emilly Oliveira
 */
@Controller
@Path("doctor")
public class DoctorController {

    @Inject
    private Result result;
    @Inject
    private DoctorRepository doctorRepository;

    @Get("new")
    public void formView() {
    }

    @Post("save")
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
        result.redirectTo(this).listView();
    }

    @Get("remove/{cpf}")
    public void delete(String cpf) {
        doctorRepository.remove(cpf);
        result.redirectTo(this).listView();
    }

    @Post("update")
    public void update(Doctor doctor) {
        doctorRepository.update(doctor);
        result.redirectTo(this).listView();
    }

    @Get("list")
    public void listView() {
        result.include("doctorList", doctorRepository.list());
    }

    @Get("detail/{id}")
    public void listOneByCode(Integer id) {
        Doctor doctor = doctorRepository.searchById(id);
        result.include("doctor", doctor);
        result.redirectTo(this).updateView();

    }

    public void updateView() {

    }

    @Get("search")
    public void searchByLicenseNumberOrSpecialization(String search) {
        List<Doctor> doctorList = doctorRepository.searchByLicenseNumberOrSpecialization(search);
        result.include("doctorList", doctorList);
        result.of(this).listView();
    }

}
