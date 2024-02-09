package it.epicode.w5d5.service;

import it.epicode.w5d5.Postazione;
import it.epicode.w5d5.Prenotazione;
import it.epicode.w5d5.Tipo;
import it.epicode.w5d5.Utente;
import it.epicode.w5d5.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione postazione){
        Tipo tipo = postazione.getTipo();
        String citta = postazione.getEdificio().getCitta();
        List<Postazione> lista = postazioneRepository.cercaPerTipoECitta(tipo,citta);
        if (lista.size()>0) {
            postazioneRepository.save(postazione);
        }
    }
    
    public void aggiornaPostazione(Postazione postazione){
        Postazione x = postazioneRepository.findById(postazione.getId()).get();
        x.setDescrizione(postazione.getDescrizione());
        x.setTipo(postazione.getTipo());
        x.setEdificio(postazione.getEdificio());
        x.setPrenotazioni(postazione.getPrenotazioni());
        x.setMassimoPartecipanti(postazione.getMassimoPartecipanti());
        postazioneRepository.save(postazione);
    }
    
    public Postazione cercaById(int id){
        return postazioneRepository.findById(id).get();
    }
    
    public void cancellaPostazione(int id){
        postazioneRepository.deleteById(id);
    }




    
    
}
