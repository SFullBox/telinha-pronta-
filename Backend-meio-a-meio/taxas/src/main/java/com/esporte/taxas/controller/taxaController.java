package com.esporte.taxas.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esporte.taxas.DAO.UITeste;
import com.esporte.taxas.model.TaxaModel;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("taxas") // 
public class taxaController{

	    @Autowired
	    private UITeste dao;

	    @GetMapping
	    public List<TaxaModel> ListaUsuarios () {
	    	return (List<TaxaModel>) dao.findAll();	    	
	    }
	    @PostMapping
	    public TaxaModel CriarUsuarios(@RequestBody TaxaModel round) {
	    	TaxaModel roundNova = dao.save(round);
	    	return roundNova;
	    }
	    
	    @PutMapping
	    public TaxaModel AlterarUsuarios(@RequestBody TaxaModel round) {
	    	TaxaModel roundNova = dao.save(round);
	    	return roundNova;
	    }
	    @DeleteMapping("/{Id}")
	    @Transactional
	    public Optional<TaxaModel> ExcluirPartida(@PathVariable Long Id) {
	    	Optional<TaxaModel> roundE = dao.findById(Id);
	    	dao.deleteById(Id);
	    	return roundE;
	  }
	}