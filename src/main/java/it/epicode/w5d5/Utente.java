package it.epicode.w5d5;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Data
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'';
    }
}
