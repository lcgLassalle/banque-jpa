package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ASSURANCEVIE")
public class AssuranceVie extends Compte {
    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    @Column(name = "TAUX")
    private double taux;

    public AssuranceVie(){}

    public AssuranceVie(String numCompte, Double solde, LocalDate dateFin, double taux) {
        super(numCompte, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
