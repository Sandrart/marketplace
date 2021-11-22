package edu.es.eoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.service.ArticuloService;

@RestController
@RequestMapping(value = "/articulos")
public class ArticuloController {

	@Autowired
	ArticuloService service;
	
	
}
