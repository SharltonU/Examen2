package com.sharlton.examen2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharlton.examen2.models.Futbolista;
import com.sharlton.examen2.models.IMC;
import com.sharlton.examen2.repositories.IMCRepository;
import com.sharlton.examen2.services.IIMCService;

@Service
public class IMCServiceImpl implements IIMCService {
    @Autowired
    IMCRepository repository;

    @Override
    public void registrarImc(Futbolista futbolista) {
        IMC imc = new IMC(futbolista);
        guardar(imc);
    }

    @Override
    public void guardar(IMC imc) {
        repository.save(imc);
    }
}
