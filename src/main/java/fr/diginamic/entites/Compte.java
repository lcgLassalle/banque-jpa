package fr.diginamic.entites;

import javax.persistence.*;

@Entity
@Table(name = "COMPTE")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NUMERO_COMPTE")
    private String numCompte;

    @Column(name = "SOLDE")
    private Double solde;

    public Compte(){}

    public Compte(String numCompte, Double solde) {
        this.numCompte = numCompte;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte n°" + numCompte +
                ", solde:" + solde + "euros";
    }
}
