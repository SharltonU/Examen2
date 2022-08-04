package com.sharlton.examen2.services;

import java.util.List;
import java.util.Optional;

import com.sharlton.examen2.models.Futbolista;

public interface IFutbolistaService {
    void crear(Futbolista futbolista);
    void actualizar(Futbolista futbolista);    
    Optional<Futbolista> buscar(long id);
    List<Futbolista> buscar();
    public List<Futbolista> buscar(Futbolista futbolista);
    public void guardar(Futbolista futbolista);
}
