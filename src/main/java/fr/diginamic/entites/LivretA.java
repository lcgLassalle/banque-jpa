package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRETA")
public class LivretA extends Compte{
    @Column(name = "TAUX")
    private Double taux;

    public LivretA(){}

    public LivretA(String numCompte, Double solde, Double taux) {
        super(numCompte, solde);
        this.taux = taux;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
