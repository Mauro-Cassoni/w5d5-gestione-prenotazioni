package it.epicode.w5d5.service;

import it.epicode.w5d5.Postazione;
import it.epicode.w5d5.Prenotazione;
import it.epicode.w5d5.Utente;
import it.epicode.w5d5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void salvaPrenotazione(Prenotazione prenotazione) throws IllegalStateException{
        LocalDate dataPrenotazione = prenotazione.getDataPrenotazione();
        Postazione postazione =  prenotazione.getPostazione();
        Utente utente = prenotazione.getUtente();
        boolean occupato = prenotazioneRepository.verPrenotazione(postazione,dataPrenotazione);
        boolean dispUtente = prenotazioneRepository.verUtente(utente,dataPrenotazione);
        if (occupato){
            throw new IllegalStateException("La postazione in quella data è occupata");
        }
        if (dispUtente){
            throw new IllegalStateException("Hai già una prenotazione attiva");

        }
        prenotazioneRepository.save(prenotazione);
    }
    
    public void aggiornaPrenotazione(Prenotazione prenotazione){
        Prenotazione x = prenotazioneRepository.findById(prenotazione.getId()).get();
        x.setUtente(prenotazione.getUtente());
        x.setPostazione(prenotazione.getPostazione());
        prenotazioneRepository.save(prenotazione);
    }
    
    public Prenotazione cercaById(int id){
        return prenotazioneRepository.findById(id).get();
    }
    
    public void cancellaPrenotazione(int id){
        prenotazioneRepository.deleteById(id);
    }

    

}
