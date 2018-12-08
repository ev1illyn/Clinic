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
import br.com.loki.model.Appointment;
import br.com.loki.repositories.AppointmentRepository;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Emilly Oliveira
 */
@Controller
@Path("appointment")
public class AppointmentController {
    
    @Inject
    private Result result;
    @Inject
    private AppointmentRepository appointmentRepository;
    
    @Get("new")
    public void formView(){
        System.out.println(appointmentRepository.list());
    }  
    
    @Post("save")
    public void save(Appointment appointment){
        appointmentRepository.save(appointment);
        result.redirectTo(this).listView();
    }
    
    @Post("update")
    public void update(Appointment appointment) {
        appointmentRepository.update(appointment);
        result.redirectTo(this).listView();
    }
    
    @Get("remove/{id}")
    public void delete(Integer id) {
       appointmentRepository.remove(id);
       result.redirectTo(this).listView();
       
    }
    
    @Get("list")
    public void listView() {
        result.include("appointmentList", appointmentRepository.list());
    }
    
    @Get("detail/{id}")
    public void searchById(Integer id) {
       Appointment appointment = appointmentRepository.searchById(id);
       result.include("appointment", appointment);
       result.redirectTo(this).updateView();
              
    } 

    public void updateView() {
    }
    
    @Get("search")
    public void searchByPostOrCpf(String search) {
        List<Appointment> appointmentList = appointmentRepository.searchByDoctorOrPatient(search);
        result.include("employeeList", appointmentList);
        result.redirectTo(this).listView();
    }
    
}
