package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Signos;
import com.mitocode.service.impl.SignosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/signos")
public class SignosController {
    @Autowired
    SignosServiceImpl service;



    @GetMapping
    public ResponseEntity<List<Signos>> listar(){
        List<Signos> lista = service.listar();
        return new ResponseEntity<List<Signos>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signos> listarPorId(@PathVariable("id") Integer id){
        Signos obj = service.leerPorId(id);
        if(obj.getIdSignos() == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Signos>(obj, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Signos signos) {
        Signos obj = service.registrar(signos);
        //medicos/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSignos()).toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping
    public ResponseEntity<Signos> modificar(@Valid @RequestBody Signos signos) {
        Signos obj = service.modificar(signos);
        return new ResponseEntity<Signos>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Signos obj = service.leerPorId(id);
        if(obj.getIdSignos() == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }


}
