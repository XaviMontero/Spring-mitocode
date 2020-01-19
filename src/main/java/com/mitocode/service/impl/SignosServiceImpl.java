package com.mitocode.service.impl;

import com.mitocode.model.Signos;
import com.mitocode.repo.ISignosRepo;
import com.mitocode.service.ISignosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignosServiceImpl implements ISignosService {

    @Autowired
    private ISignosRepo service;
    @Override
    public Signos registrar(Signos obj) {
        return service.save(obj);
    }

    @Override
    public Signos modificar(Signos obj) {
        return service.save(obj);
    }

    @Override
    public List<Signos> listar() {
        return service.findAll();
    }

    @Override
    public Signos leerPorId(Integer id) {
        return service.getOne(id);
    }

    @Override
    public boolean eliminar(Integer id) {
        service.deleteById(id);
        return true;
    }
}
