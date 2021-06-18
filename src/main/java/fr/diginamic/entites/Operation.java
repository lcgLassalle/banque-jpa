package fr.diginamic.entites;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "MONTANT")
    private Double montant;

    @Column(name = "MOTIF")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

    public  Operation(){}

    public Operation(LocalDate date, Double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant1, Compte comptebenef, Compte compteorigine) {
        montant = (montant1);
        Double newsoldebenef = comptebenef.getSolde();
        newsoldebenef+=montant1;
        comptebenef.setSolde(newsoldebenef);

        Double newsoldeorigine = compteorigine.getSolde();
        newsoldeorigine = newsoldeorigine - montant1;
        compteorigine.setSolde(newsoldeorigine);

    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation n°" + id +
                ", effectuée le " + date +
                ", montant: " + montant + "euros" +
                ", motif: " + motif ;
    }
}
