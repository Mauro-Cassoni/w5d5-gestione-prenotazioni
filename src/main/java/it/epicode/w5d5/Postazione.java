package it.epicode.w5d5;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;


@Entity
@Component
@Data
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String descrizione;
    @Enumerated
    private Tipo tipo;
    private int massimoPartecipanti;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;


    @Override
    public String toString() {
        return
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", massimoPartecipanti=" + massimoPartecipanti +
                ", edificio=" + edificio;
    }
}
