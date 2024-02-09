package it.epicode.w5d5.service;

import it.epicode.w5d5.Edificio;
import it.epicode.w5d5.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio edificio){
        edificioRepository.save(edificio);
    }

    public void aggiornaEdificio(Edificio edificio){
        Edificio x = edificioRepository.findById(edificio.getId()).get();
        x.setCitta(edificio.getCitta());
        x.setNome(edificio.getNome());
        x.setIndirizzo(edificio.getIndirizzo());
        x.setPostazioni(edificio.getPostazioni());
        edificioRepository.save(edificio);
    }

    public Edificio cercaById(int id){
        return edificioRepository.findById(id).get();
    }

    public void cancellaEdificio(int id){
        edificioRepository.deleteById(id);
    }

//    public List<Edificio> cercaPizzaPerNome(String nome){
//        return edificioRepository.findByNome(nome);
//    }

//    public List<Edificio> mostraTutteLePizze(){
//        return edificioRepository.findAll();
//    }





}
