package it.epicode.w5d5;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Entity
@Component
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;


}
