package com.sharlton.examen2.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharlton.examen2.models.Futbolista;
import com.sharlton.examen2.repositories.FutbolistaRepository;
import com.sharlton.examen2.services.IFutbolistaService;

@Service
public class FutbolistaServiceImpl implements IFutbolistaService {
    @Autowired
    FutbolistaRepository repository;

    @Override
    public void crear(Futbolista futbolista) {
        guardar(futbolista);
    }

    @Override
    public void actualizar(Futbolista futbolista) {
        Optional<Futbolista> optFutbolista = repository.findById(futbolista.getId());
        if(optFutbolista.isEmpty()) return;
        Futbolista actFutbolista  = optFutbolista.get();
        BeanUtils.copyProperties(futbolista, actFutbolista);
        guardar(actFutbolista);
    }

    @Override
    public Optional<Futbolista> buscar(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Futbolista> buscar() {
        return repository.findAll();
    }

    @Override
    public List<Futbolista> buscar(Futbolista futbolista) {
        if(futbolista.getNombre() == null || futbolista.getNombre().equals("")) futbolista.setNombre("__");
        if(futbolista.getApellido1() == null || futbolista.getApellido1().equals("")) futbolista.setApellido1("__");
        return repository.findByNombreContainingIgnoreCaseOrApellido1ContainingIgnoreCase(futbolista.getNombre(), futbolista.getApellido1());
    }

    @Override
    public void guardar(Futbolista futbolista) {
        repository.save(futbolista);
    }
}
