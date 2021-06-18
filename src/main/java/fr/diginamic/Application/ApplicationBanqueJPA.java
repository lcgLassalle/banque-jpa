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


        // Operations pour le TP04
//        /**
//         * Création d'un compte associé à un client
//         */
//        Compte compte1 = new Compte();
//        compte1.setNumCompte("03ABC25");
//        compte1.setSolde(204.55);
//        compte1.setClientMultiple(client1);
//        em.persist(compte1);
//
//        /**
//         * Création d'une opération sur un compte
//         */
//        Operation virement = new Operation();
//        virement.setCompte(compte1);
//        virement.setDate(LocalDate.of(2021, Month.JUNE,18));
//        virement.setMontant(130.6);
//        virement.setMotif("Don du temple");
//        em.persist(virement);

        // Opertations TP05
        /**
         * Création d'un deuxième client
         */

        Client client2 = new Client();
        client2.setNom("Owlus");
        client2.setPrenom("Athena");
        client2.setDateNaissance(LocalDate.of(1991, Month.DECEMBER,25));
        Adresse adresse2 = new Adresse("152", "Avenue du Parthénon", "12500", "OLYMPUS");
        client2.setAdresse(adresse2);
        client2.setBanque(banque1);
        em.persist(client2);

        /**
         * Création d'un compte associé à deux clients
         */
        Compte compte1 = new Compte();
        compte1.setNumCompte("03ABC25");
        compte1.setSolde(2004.55);
        compte1.setClientMultiple(client1);
        compte1.setClientMultiple(client2);
        em.persist(compte1);

        /**
         * Création d'une nouvelle banque
         */
        Banque banque2 = new Banque();
        banque2.setNom("Erebus bank");
        em.persist(banque2);

        /**
         * Création d'un troisieme client
         */
        Client client3 = new Client();
        client3.setNom("Primus Tempus");
        client3.setPrenom("Perséphone");
        client3.setDateNaissance(LocalDate.of(1998,Month.MARCH,21));
        client3.setBanque(banque2);
        Adresse adresse3 = new Adresse("666", "Allee du Styx", "37189", "SIXFEET");
        client3.setAdresse(adresse3);

        em.persist(client3);

        /**
         * Création d'une assurance vie pour le client3
         */
        AssuranceVie assur1 = new AssuranceVie();
        assur1.setTaux(1.4);
        assur1.setSolde(8000.00);
        assur1.setNumCompte("HELL0348ASSUR");
        assur1.setDateFin(LocalDate.of(2030, Month.DECEMBER,21));
        assur1.setClientMultiple(client3);

        em.persist(assur1);

        /**
         * Creation d'un livret A pour le client3
         */
        LivretA livret1 = new LivretA();
        livret1.setTaux(0.7);
        livret1.setSolde(500.5);
        livret1.setNumCompte("HELL0598LIVA");
        livret1.setClientMultiple(client3);

        em.persist(livret1);

        /**
         * Virement du compte de Zeus vers le livret A de Perséphone
         */
        Virement virement1 = new Virement();
        virement1.setCompte(livret1);
        virement1.setBeneficiaire(client1.getNom());
        virement1.setDate(LocalDate.of(2021, Month.JUNE,18));
        virement1.setMontant(205.00, livret1, compte1);
        virement1.setMotif("Pardon");

        em.persist(virement1);

        /**
         * Virement d'Athéna vers l'assurance vie de Perséphone
         */
        Virement virement2 = new Virement();
        virement2.setBeneficiaire(client1.getNom());
        virement2.setDate(LocalDate.of(2021, Month.JUNE,16));
        virement2.setMontant(50.50,assur1, compte1);
        virement2.setMotif("Argent de poche");
        virement2.setCompte(assur1);

        em.persist(virement2);

        /**
         * Virement d'Athéna vers l'assurance vie de Perséphone
         */
        Operation operation1 = new Operation();
        operation1.setDate(LocalDate.of(2021, Month.JUNE,16));
        operation1.setMontant(150.00,livret1, assur1);
        operation1.setMotif("epargne pour l'hiver");
        operation1.setCompte(assur1);

        em.persist(operation1);

        et.commit();
        em.close();
    }
}
