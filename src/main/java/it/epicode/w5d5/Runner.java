package it.epicode.w5d5;

import it.epicode.w5d5.service.EdificioService;
import it.epicode.w5d5.service.PostazioneService;
import it.epicode.w5d5.service.PrenotazioneService;
import it.epicode.w5d5.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d5Application.class);

//       Edificio edificio1 = ctx.getBean(Edificio.class);
//       edificio1.setNome("Edificio1");
//       edificio1.setCitta("Roma");
////        edificio1.setCitta("Roma");
////        edificio1.setNome("B&B");
//        Postazione postazione1 = ctx.getBean(Postazione.class);
//        Prenotazione prenotazione1 = ctx.getBean(Prenotazione.class);
//        Utente utente1 = ctx.getBean(Utente.class);

//        Edificio edificio1 = new Edificio();
//        Postazione postazione1 = new Postazione();
//        Prenotazione prenotazione1 = new Prenotazione();
//        Utente utente1 = new Utente();

//        edificioService.salvaEdificio(edificio1);
//        postazioneService.salvaPostazione(postazione1);
//        prenotazioneService.salvaPrenotazione(prenotazione1);
//        utenteService.salvaUtente(utente1);


    }
}
