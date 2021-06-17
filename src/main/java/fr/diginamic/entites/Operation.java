package fr.diginamic.entites;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OPERATION")
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

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "Operation n°" + id +
                ", effectuée le " + date +
                ", montant: " + montant + "euros" +
                ", motif: " + motif ;
    }
}
