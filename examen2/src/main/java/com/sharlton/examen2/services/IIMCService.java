package com.sharlton.examen2.services;

import com.sharlton.examen2.models.Futbolista;
import com.sharlton.examen2.models.IMC;

public interface IIMCService {
    void registrarImc(Futbolista imc);
    public void guardar(IMC imc);
}
