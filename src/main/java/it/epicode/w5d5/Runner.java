package it.epicode.w5d5;

import it.epicode.w5d5.service.EdificioService;
import it.epicode.w5d5.service.PostazioneService;
import it.epicode.w5d5.service.PrenotazioneService;
import it.epicode.w5d5.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private UtenteService utenteService;

    private Logger logger = LoggerFactory.getLogger("logger");
    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d5Application.class);

        try {

            Edificio edificio1 = ctx.getBean(Edificio.class);
            edificio1.setNome("Edificio1");
            edificio1.setCitta("Roma");
            edificio1.setCitta("Roma");
            edificioService.salvaEdificio(edificio1);

            Postazione postazione1 = ctx.getBean(Postazione.class);
            postazione1.setTipo(Tipo.OPENSPACE);
            postazione1.setEdificio(edificio1);
            postazione1.setDescrizione("Descrizione");
            postazione1.setMassimoPartecipanti(55);
            postazioneService.salvaPostazione(postazione1);

            Utente utente1 = ctx.getBean(Utente.class);
            utente1.setNome("Mario");
            utente1.setCognome("Rossi");
            utente1.setEmail("mario@rossi.it");
            utente1.setUsername("MarioRossi");
            utenteService.salvaUtente(utente1);

            Prenotazione prenotazione1 = ctx.getBean(Prenotazione.class);
            prenotazione1.setDataPrenotazione(LocalDate.now());
            prenotazione1.setPostazione(postazioneService.cercaById(52));
            prenotazione1.setUtente(utente1);
            prenotazioneService.salvaPrenotazione(prenotazione1);


        }
        catch (IllegalStateException e){
            logger.error(e.getMessage());
        }


        postazioneService.cercaPerTipologiaECitta(Tipo.OPENSPACE,"Roma").forEach(System.out::println);

    }
}
