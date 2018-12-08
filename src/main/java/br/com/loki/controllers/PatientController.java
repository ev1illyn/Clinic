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
import br.com.loki.model.Patient;
import br.com.loki.repositories.PatientRepository;
import javax.inject.Inject;

/**
 *
 * @author Emilly Oliveira
 */
@Controller
@Path("patient")
public class PatientController {
    
    @Inject
    private Result result;
    @Inject
    private PatientRepository patientRepository;
    
    @Get("new")
    public void formView(){
    }  
    
    @Post("save")
    public void save(Patient patient) {
        patientRepository.save(patient);
        result.redirectTo(this).listView();
    }
    
    @Get("remove/{cpf}")
    public void delete(String cpf) {
       patientRepository.remove(cpf);
       result.redirectTo(this).listView();
       
    }
    
    @Post("update")
    public void update(Patient patient) {
        patientRepository.update(patient);
        result.redirectTo(this).listView();
    }
    
    @Get("list")
    public void listView() {
        result.include("patientList", patientRepository.list());
    }
    
    @Get("detail/{id}")
    public void listOneByCode(Integer id) {
       Patient patient = patientRepository.searchById(id);
       result.include("patient", patient);
       result.redirectTo(this).updateView();
    }
    
    public void updateView(){
    
    }
    
    @Post("search")
    public void searchByNameOrCpf(String search) {
        Patient patient = patientRepository.searchByNameOrCpf(search);
        result.include("patientList", patient);
        result.redirectTo(this).listView();
    }
    
}
