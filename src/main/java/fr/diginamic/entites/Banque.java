package fr.diginamic.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BANQUE")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM")
    private String nom;

    @OneToMany(mappedBy = "banque")
    Set<Client> clients;

    public Banque(){}

    public Banque(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Banque n°" + id +
                ", nom: " + nom;
    }
}
