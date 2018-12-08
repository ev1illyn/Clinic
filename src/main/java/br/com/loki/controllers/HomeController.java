/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loki.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

/**
 *
 * @author emilly oliveira
 */
@Controller
public class HomeController {
    
    @Get("/")
    public void home(){
    }
}
