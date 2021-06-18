package fr.diginamic.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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


    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "COMPTETOCLIENT",
            joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"))
    private Set<Client> clientMultiple = new HashSet<>();

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

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Operation operations) {
        this.operations.add(operations);
    }

    public Set<Client> getClientMultiple() {
        return clientMultiple;
    }

    public void setClientMultiple(Client client) {
        this.clientMultiple.add(client);
    }

    @Override
    public String toString() {
        return "Compte n°" + numCompte +
                ", solde:" + solde + "euros";
    }
}
