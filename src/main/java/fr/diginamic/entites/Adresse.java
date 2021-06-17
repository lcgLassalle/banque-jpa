package fr.diginamic.entites;

import javax.persistence.*;

@Embeddable
public class Adresse {

    @Column(name = "NUMERO")
    private String num;

    @Column(name = "RUE")
    private String rue;

    @Column(name = "CODEPOSTAL")
    private String codePostal;

    @Column(name = "VILLE")
    private String ville;

    public Adresse(){}

    public Adresse(String num, String rue, String codePostal, String ville) {
        this.num = num;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return  num + " " + rue + '\n' +
                codePostal + " " + ville;
    }
}
