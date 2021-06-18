package fr.diginamic.Application;

import fr.diginamic.entites.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;

public class ApplicationBanqueJPA {
    public static void  main(String[] args){
        EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("banque");
        EntityManager em = entitymanagerfactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();


        /**
         * Création d'une banque
         */

        Banque banque1 = new Banque();
        banque1.setNom("Banque des licornes");
        em.persist(banque1);

        /**
         * Création d'un client dans la table de donnée banque-jpa
         */
        Client client1 = new Client();
        client1.setNom("Grecos");
        client1.setPrenom("Zeus");
        client1.setDateNaissance(LocalDate.of(1988, Month.FEBRUARY,18));
        Adresse adresse1 = new Adresse("9", "rue des lyres", "12500", "OLYMPUS");
        client1.setAdresse(adresse1);
        client1.setBanque(banque1);
        em.persist(client1);

        /**
         * Création d'un compte associé à une banque et un client
         */
        Compte compte1 = new Compte();
        compte1.setNumCompte("03ABC25");
        compte1.setSolde(204.55);
        compte1.setClientMultiple(client1);
        em.persist(compte1);

        /**
         * Création d'une opération sur un compte
         */
        Operation virement = new Operation();
        virement.setCompte(compte1);
        virement.setDate(LocalDate.of(2021, Month.JUNE,18));
        virement.setMontant(130.6);
        virement.setMotif("Don du temple");
        em.persist(virement);

        et.commit();
        em.close();
    }
}
