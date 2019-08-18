package bibliotheque;

import java.util.Scanner;
import java.util.ArrayList;

public class TestBibliotheque {
    
    public static void main(String[] args) {
        
        //créer un catalogue de documents
        CatalogueBibliotheque catalogue = new CatalogueBibliotheque(); //création du catalogue
        catalogue.ajouterDoc(new DocBibliotheque("004. 178 K20PM",
                "Introduction à Java", "J. Leblanc", 2015));
        catalogue.ajouterDoc(new DocBibliotheque("967. 498 T24AN",
                "Structures de Données", "M. Machin", 2017));
        catalogue.ajouterDoc(new DocBibliotheque("890. 471 T24AN",
                "Doc 3", "M. Machin 2", 1999));
        catalogue.ajouterDoc(new DocBibliotheque("657. 572 T24AN",
                "Doc 4", "M. Machin 3", 2002));
        catalogue.ajouterDoc(new DocBibliotheque("345. 663 T24AN",
                "Doc 5", "M. Machin 4", 2008));
        catalogue.ajouterDoc(new DocBibliotheque("123. 754 T24AN",
                "Doc 6", "M. Machin 5", 1995));
        catalogue.ajouterDoc(new DocBibliotheque("368. 845 T24AN",
                "Doc 7", "M. Machin 6", 1993));
        catalogue.ajouterDoc(new DocBibliotheque("973. 936 T24AN",
                "Doc 8", "M. Machin 7", 2009));
        catalogue.ajouterDoc(new DocBibliotheque("347. 027 T24AN",
                "Doc 9", "M. Machin 8", 2013));
        catalogue.ajouterDoc(new DocBibliotheque("642. 108 T24AN",
                "Doc 10", "M. Machin 9", 2011));
        
        //créer une liste de membres
        ListeMembres membres = new ListeMembres(); //création de la liste
        membres.ajouterMembre(new MembreEtudiant("Bernard", "Alfred",
                "06 74 38 27 49", "6 rue des Fleures")); //ajout de Membre1
        membres.ajouterMembre(new MembrePersonnel("Lambert", "Paul",
                "07 41 68 75 78", "6 rue des Fleures")); //ajout de Membre2
        
        boolean menu = true;
        Scanner entree = new Scanner(System.in);
        Scanner entree2 = new Scanner(System.in);
        
        MembreBibliotheque membre;
        DocBibliotheque doc;
        String nom, prenom, tel, adresse, code, titre, auteur, newTxt, nomEditeur, ISBN, artiste, URL, description;
        int choix, annee, nbPage, i;
        ArrayList<String> morceaux = new ArrayList<>();
        
        while (menu) {
            affichageMenu();
            choix = entree.nextInt();
            
            switch(choix) {
                
                case 0: //Quitter
                    menu = false;
                    break;
                    
                case 1: //Ajouter un nouveau membre
                    nettoyerAffichage();
                    
                    System.out.print("1 : Membre étudiant\n2 : Membre personnel\n\nEntrer le type du nouveau membre : ");
                    choix = entree.nextInt();
                    nettoyerAffichage();
                    
                    if (choix == 1 || choix == 2) {
                        System.out.print("Entrer le nom du nouveau membre : ");
                        nom = entree2.nextLine();
                        nettoyerAffichage();

                        System.out.print("Entrer le prénom du nouveau membre : ");
                        prenom = entree2.nextLine();
                        nettoyerAffichage();

                        System.out.print("Entrer le numéro de téléphone du nouveau membre : ");
                        tel = entree2.nextLine();
                        nettoyerAffichage();

                        System.out.print("Entrer l'adresse du nouveau membre : ");
                        adresse = entree2.nextLine();
                        nettoyerAffichage();
                        
                        switch(choix) {
                            
                            case 1:
                                if (membres.ajouterMembre(new MembreEtudiant(nom, prenom, tel, adresse))) {
                                    System.out.println("Membre ajouté");
                                }
                                else {
                                    System.out.println("Erreur de saisi");
                                }
                                break;
                                
                            case 2:
                                if (membres.ajouterMembre(new MembrePersonnel(nom, prenom, tel, adresse))) {
                                    System.out.println("Membre ajouté");
                                }
                                else {
                                    System.out.println("Erreur de saisi");
                                }
                                break;
                        }
                            
                    } //fin if (choix == 1 || choix == 2)
                    else {
                        System.out.println("Erreur de saisi");
                    }
                    
                    finCase(entree2);
                    break;
                    
                case 2: //Afficher les informations d'un membre
                    membre = selectMembre(membres);
                    
                    if (membre != null) { //s'il n'y a pas eu d'erreur
                        System.out.println(membre.toString());
                    }
                    
                    finCase(entree2);
                    break;
                    
                case 3: //Modifier les informations d'un membre
                    membre = selectMembre(membres);
                    
                    if (membre != null) { //s'il n'y a pas eu d'erreur
                        System.out.println("1 : Modifier le nom du membre\n"
                            + "2 : Modifier le prénom du membre\n"
                            + "3 : Modifier le numéro de téléphone du membre\n"
                            + "4 : Modifier l'adresse du membre\n");
                    
                        System.out.print("\nChoisissez l'élément que vous souhaitez modifier : ");
                        choix = entree.nextInt();

                        nettoyerAffichage();
                        
                        if (choix > 0 && choix <= 4) { //s'il n'y a pas eu d'erreur
                        
                            System.out.print("\nChoisissez sa nouvelle valeur : ");
                            newTxt = entree2.nextLine();

                            nettoyerAffichage();

                            switch(choix) {
                                    
                                case 1:
                                    if (membre.setNom(newTxt)) {
                                        System.out.println("Le nom du membre a bien été changé");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;

                                case 2:
                                    if (membre.setPrenom(newTxt)) {
                                        System.out.println("Le prénom du membre a bien été changé");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;

                                case 3:
                                    if (membre.setTel(newTxt)) {
                                        System.out.println("Le numéro de téléphone du membre a bien été changé");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;

                                case 4:
                                    if (membre.setAdresse(newTxt)) {
                                        System.out.println("L'adresse du membre a bien été changé");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;

                                default :
                                    System.out.print("Erreur de saisi");
                                    break;
                            } //fin switch
                            
                        } //fin if (choix == OK)
                        else {
                                System.out.println("Erreur de saisi");
                            }
                    } //fin if (membre != null)
                    
                    finCase(entree2);
                    break;
                    
                case 4: //Ajouter un nouveau document
                    nettoyerAffichage();
                    
                    System.out.println("1 : Livre\n2 : CD\n3 : DocURL\n");
                    System.out.print("\nEntrer le type du nouveau document : ");
                    choix = entree.nextInt();
                    nettoyerAffichage();
                    
                    switch(choix) {
                        
                        case 1: //livre
                            System.out.print("\nEntrer le code du nouveau livre : ");
                            code = entree2.nextLine();
                            nettoyerAffichage();

                            System.out.print("\nEntrer le titre du nouveau livre : ");
                            titre = entree2.nextLine();
                            nettoyerAffichage();

                            System.out.print("\nEntrer l'auteur du nouveau livre : ");
                            auteur = entree2.nextLine();
                            nettoyerAffichage();

                            System.out.print("\nEntrer l'année de publication du nouveau livre : ");
                            annee = entree.nextInt();
                            nettoyerAffichage();
                            
                            System.out.print("\nEntrer le nom de l'éditeur du nouveau livre : ");
                            nomEditeur = entree2.nextLine();
                            nettoyerAffichage();
                            
                            System.out.print("\nEntrer le nombre de pages du nouveau livre : ");
                            nbPage = entree.nextInt();
                            nettoyerAffichage();
                            
                            System.out.print("\nEntrer l'ISBN du nouveau livre : ");
                            ISBN = entree2.nextLine();
                            nettoyerAffichage();
                            
                            if (!code.equals("") && !titre.equals("") && !auteur.equals("")
                                    && !nomEditeur.equals("") && !ISBN.equals("")
                                    && catalogue.ajouterDoc(new Livre(code, titre, auteur, annee, nomEditeur, nbPage, ISBN))) {
                            System.out.println("Livre ajouté");
                            }
                            else {
                                System.out.println("Erreur de saisi");
                            }
                            break;
                            
                        case 2: //CD
                            System.out.print("\nEntrer le code du nouveau CD : ");
                            code = entree2.nextLine();
                            nettoyerAffichage();

                            System.out.print("\nEntrer le titre du nouveau CD : ");
                            titre = entree2.nextLine();
                            nettoyerAffichage();

                            System.out.print("\nEntrer l'artiste du nouveau CD : ");
                            artiste = entree2.nextLine();
                            nettoyerAffichage();

                            System.out.print("\nEntrer l'année de publication du nouveau CD : ");
                            annee = entree.nextInt();
                            nettoyerAffichage();
                            
                            System.out.print("\nEntrer le nombre de morceaux du nouveau CD : ");
                            choix = entree.nextInt();
                            morceaux.clear();
                            for (i = 1; i <= choix; i++) {
                                nettoyerAffichage();
                                System.out.print("\nEntrer le nom du morceau n°" + i + " : ");
                                String test = entree2.nextLine();
                                morceaux.add(test);
                            }
                            nettoyerAffichage();
                            
                            if (!code.equals("") && !code.equals("") && !code.equals("") && !code.equals("") && valide(morceaux)
                                    && catalogue.ajouterDoc(new CD(code, titre, artiste, annee, morceaux))) {
                                System.out.println("CD ajouté");
                            }
                            else {
                                System.out.println("Erreur de saisi");
                            }
                            break;
                            
                        case 3: //docURL
                            System.out.print("\nEntrer le code du nouveau document : ");
                            code = entree2.nextLine();
                            nettoyerAffichage();
                            
                            System.out.print("\nEntrer l'auteur ou l'entreprise ayant publié le nouveau document : ");
                            auteur = entree2.nextLine();
                            nettoyerAffichage();
                            
                            System.out.print("\nEntrer l'URL du nouveau document : ");
                            URL = entree2.nextLine();
                            nettoyerAffichage();
                            
                            System.out.print("\nEntrer la description du nouveau document : ");
                            description = entree2.nextLine();
                            nettoyerAffichage();
                            
                            if (!code.equals("") && !auteur.equals("") && !URL.equals("") && !description.equals("")
                                    && catalogue.ajouterDoc(new DocURL(code, auteur, URL, description))) {
                                System.out.println("Document ajouté");
                            }
                            else {
                                System.out.println("Erreur de saisi");
                            }
                            break;
                        
                        default:
                            System.out.println("Erreur de saisi");
                            break;
                    } //fin switch

                    finCase(entree2);
                    break;
                    
                case 5: //Supprimer un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        if (catalogue.enleverDoc(doc)) {
                            System.out.println("Document supprimé");
                        }
                        else {
                            System.out.println("Erreur de saisi");
                        }
                    }
                    finCase(entree2);
                    break;
                
                case 6: //Afficher les informations d'un document
                    doc = selectDoc(catalogue);
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        System.out.println(doc.toString());
                    }
                    
                    finCase(entree2);
                    break;
                    
                case 7: //Modifier les informations d'un document
                    //ne prend pas en compte les differents types de documents
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        
                        switch(doc.getTypeDoc()) {
                            
                            case 0: //DocBibliotheque normal
                                System.out.println("1 : Modifier le code du document\n"
                                    + "2 : Modifier le titre du document\n"
                                    + "3 : Modifier l'auteur du document\n"
                                    + "4 : Modifier l'année de publication du document\n");

                                System.out.print("\nChoisissez l'élément que vous souhaitez modifier : ");
                                choix = entree.nextInt();
                                nettoyerAffichage();

                                if (choix == 4) { //seul cas où l'entrée est un int
                                        System.out.print("Entrer la nouvelle année de publication du document : ");
                                            annee = entree.nextInt();
                                            nettoyerAffichage();

                                            if (annee != 0) { //s'il n'y a pas eu d'erreur
                                                doc.setAnnee(annee);
                                                System.out.println("Année modifiée");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;
                                    }
                                    else {
                                        System.out.print("Entrer la nouvelle valeur de cet élément : ");
                                        newTxt = entree2.nextLine();
                                        nettoyerAffichage();

                                        switch(choix) {

                                            case 1:
                                                if (doc.setCode(newTxt)) {
                                                    System.out.println("Code modifié");
                                                }
                                                else {
                                                    System.out.println("Erreur de saisi");
                                                }
                                                break;

                                            case 2:
                                                if (doc.setTitre(newTxt)) {
                                                    System.out.println("Titre modifié");
                                                }
                                                else {
                                                    System.out.println("Erreur de saisi");
                                                }
                                                break;

                                            case 3:
                                                if (doc.setAuteur(newTxt)) {
                                                    System.out.println("Auteur modifié");
                                                }
                                                else {
                                                    System.out.println("Erreur de saisi");
                                                }
                                                break;

                                            default:
                                                System.out.println("Erreur de saisi");
                                        } //fin switch

                                    } //fin else
                                break;
                                
                            case 1: //CD
                                System.out.println("1 : Modifier le code du CD\n"
                                    + "2 : Modifier le titre du CD\n"
                                    + "3 : Modifier l'artiste du CD\n"
                                    + "4 : Modifier l'année de publication du CD\n"
                                    + "5 : Modifier les morceaux du CD");

                                System.out.print("\nChoisissez l'élément que vous souhaitez modifier : ");
                                choix = entree.nextInt();
                                nettoyerAffichage();

                                if (choix == 4 || choix == 5) { //cas particuliers
                                    if (choix == 4) { //seul cas avec un int
                                        System.out.print("Entrer la nouvelle année de publication du CD : ");
                                            annee = entree.nextInt();
                                            nettoyerAffichage();

                                            if (annee != 0) { //s'il n'y a pas eu d'erreur
                                                doc.setAnnee(annee);
                                                System.out.println("Année modifiée");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;
                                    }
                                    else { //cas de la liste de String
                                        System.out.print("\nEntrer le nombre de morceaux du nouveau CD : ");
                                        choix = entree.nextInt();
                                        morceaux.clear();
                                        for (i = 1; i <= choix; i++) {
                                            nettoyerAffichage();
                                            System.out.print("\nEntrer le nom du morceau n°" + i + " : ");
                                            String test = entree2.nextLine();
                                            morceaux.add(test);
                                        }
                                        nettoyerAffichage();
                                        if (doc.setMorceaux(morceaux)) {
                                            System.out.println("Morceaux modifiés");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                    }
                                }
                                else { //cas avec un String simple
                                    System.out.print("Entrer la nouvelle valeur de cet élément : ");
                                    newTxt = entree2.nextLine();
                                    nettoyerAffichage();

                                    switch(choix) {

                                        case 1:
                                            if (doc.setCode(newTxt)) {
                                                System.out.println("Code modifié");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;

                                        case 2:
                                            if (doc.setTitre(newTxt)) {
                                                System.out.println("Titre modifié");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;

                                        case 3:
                                            if (doc.setAuteur(newTxt)) {
                                                System.out.println("Artiste modifié");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;

                                        default:
                                            System.out.println("Erreur de saisi");
                                    } //fin switch

                                } //fin else
                                break;
                                
                            case 2: //DocURL
                                System.out.println("1 : Modifier le code du document\n"
                                    + "2 : Modifier l'auteur ou entreprise ayant publié le document\n"
                                    + "3 : Modifier l'URL du document\n"
                                    + "4 : Modifier la description du document\n");

                                System.out.print("\nChoisissez l'élément que vous souhaitez modifier : ");
                                choix = entree.nextInt();
                                nettoyerAffichage();

                                System.out.print("Entrer la nouvelle valeur de cet élément : ");
                                newTxt = entree2.nextLine();
                                nettoyerAffichage();

                                switch(choix) {

                                    case 1:
                                        if (doc.setCode(newTxt)) {
                                            System.out.println("Code modifié");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;

                                    case 2:
                                        if (doc.setAuteur(newTxt)) {
                                            System.out.println("Auteur ou entreprise modifié");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;

                                    case 3:
                                        if (doc.setURL(newTxt)) {
                                            System.out.println("URL modifié");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;

                                    case 4:
                                        if (doc.setDescription(newTxt)) {
                                            System.out.println("Description modifiée");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;

                                    default:
                                        System.out.println("Erreur de saisi");
                                } //fin switch
                                break;
                                
                            case 3: //Livre
                                System.out.println("1 : Modifier le code du Livre\n"
                                    + "2 : Modifier le titre du Livre\n"
                                    + "3 : Modifier l'auteur du Livre\n"
                                    + "4 : Modifier l'année de publication du Livre\n"
                                    + "5 : Modifier le nom de l'éditeur du Livre\n"
                                    + "6 : Modifier le nombre de pages du livre\n"
                                    + "7 : Modifier l'ISBN du livre\n");

                                System.out.print("\nChoisissez l'élément que vous souhaitez modifier : ");
                                choix = entree.nextInt();
                                nettoyerAffichage();

                                if (choix == 4 || choix == 6) { //seuls cas où l'entrée est un int
                                    if (choix == 4) {
                                        System.out.print("Entrer la nouvelle année de publication du Livre : ");
                                        annee = entree.nextInt();
                                        nettoyerAffichage();

                                        if (annee != 0) { //s'il n'y a pas eu d'erreur
                                            doc.setAnnee(annee);
                                            System.out.println("Année modifiée");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;
                                    }
                                    else { //choix == 6
                                        System.out.print("Entrer le nouveau nombre de pages du Livre : ");
                                        nbPage = entree.nextInt();
                                        nettoyerAffichage();

                                        if (nbPage != 0) { //s'il n'y a pas eu d'erreur
                                            doc.setNbPage(nbPage);
                                            System.out.println("Nombre de pages modifiée");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;
                                    }
                                }
                                else {
                                    System.out.print("Entrer la nouvelle valeur de cet élément : ");
                                    newTxt = entree2.nextLine();
                                    nettoyerAffichage();

                                    switch(choix) {

                                        case 1:
                                            if (doc.setCode(newTxt)) {
                                                System.out.println("Code modifié");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;

                                        case 2:
                                            if (doc.setTitre(newTxt)) {
                                                System.out.println("Titre modifié");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;

                                        case 3:
                                            if (doc.setAuteur(newTxt)) {
                                                System.out.println("Auteur modifié");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;
                                            
                                        case 5:
                                            if (doc.setNomEditeur(newTxt)) {
                                                System.out.println("Nom de l'éditeur modifié");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;
                                            
                                        case 7:
                                            if (doc.setISBN(newTxt)) {
                                                System.out.println("ISBN modifié");
                                            }
                                            else {
                                                System.out.println("Erreur de saisi");
                                            }
                                            break;

                                        default:
                                            System.out.println("Erreur de saisi");
                                    } //fin switch

                                } //fin else
                                break;
                        
                        }//fin du switch
                        
                    } //fin if (doc != null)
                    
                    finCase(entree2);
                    break;
                
                case 8: //Afficher l’état d’un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        System.out.print("Le document est ");
                        
                        switch(doc.getEtatDoc()) {
                            
                            case 0:
                                System.out.println("sur les étagères.");
                                break;

                            case 1:
                                System.out.println("sur la pile des retours.");
                                break;

                            case 2:
                                System.out.println("sur la section réservations.");
                                break;

                            case 3:
                                System.out.println("emprunté.");
                                break;
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 9: //Emprunter un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        membre = selectMembre(membres);
                        
                        if (membre != null) { //s'il n'y a pas eu d'erreur
                            if (doc.emprunterDoc(membre)) {
                                System.out.println("Le document est maintenant emprunté");
                            }
                            else {
                                System.out.println("Opération impossible");
                            }
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 10: //Rendre un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        if (doc.retournerDoc()) {
                            System.out.println("Document rendu");
                        }
                        else {
                            System.out.println("Opération impossible");
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 11: //Ranger un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        if (doc.rangerDoc()) {
                            System.out.println("Document rangé");
                        }
                        else {
                            System.out.println("Opération impossible");
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 12: //Faire une réservation
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        membre = selectMembre(membres);
                        
                        if (membre != null) { //s'il n'y a pas eu d'erreur
                            if (doc.reserverDoc(membre)) {
                                System.out.println("Le document est maintenant réservé");
                            }
                            else {
                                System.out.println("Opération impossible");
                            }
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 13: //Annuler une réservation
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        membre = selectMembre(membres);
                        
                        if (membre != null) { //s'il n'y a pas eu d'erreur
                            if (doc.annulerReservation(membre)) {
                                System.out.println("La réservation du document est annulée");
                            }
                            else {
                                System.out.println("Opération impossible");
                            }
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 14: //Afficher le nombre de documents empruntés
                    nettoyerAffichage();
                    System.out.println("Il y a " + DocBibliotheque.getNbDocEmprunte()
                            + " document(s) emprunté(s)");
                    
                    finCase(entree2);
                    break;
                
                case 15: //Afficher le nombre de documents sur la pile des retours
                    nettoyerAffichage();
                    System.out.println("Il y a " + DocBibliotheque.getNbDocPile()
                            + " document(s) sur la pile des retours");
                    
                    finCase(entree2);
                    break;
                
                case 16: //Afficher le nombre de documents dans la section spéciale réservations
                    nettoyerAffichage();
                    System.out.println("Il y a " + DocBibliotheque.getNbDocSectionReservation()
                            + " document(s) sur la section réservation");
                    
                    finCase(entree2);
                    break;
                    
                case 17: //Afficher le nombre de livres dans la bibliothèque
                    nettoyerAffichage();
                    System.out.println("Il y a " + catalogue.compteLivres()
                            + " livre(s) dans la bibliothèque");
                    
                    finCase(entree2);
                    break;
                    
                case 18: //Afficher le nombre de CDs dans la bibliothèque
                    nettoyerAffichage();
                    System.out.println("Il y a " + catalogue.compteCDs()
                            + " CD(s) dans la bibliothèque");
                    
                    finCase(entree2);
                    break;
                    
                default :
                    System.out.println("Erreur de saisi");
                    break;
                
            } //fin du switch
            
        } //fin du while
        

        
    } //fin du main
    
    public static void affichageMenu() {
        nettoyerAffichage();
        System.out.println(
                  "1  : Ajouter un nouveau membre\n"
                + "2  : Afficher les informations d'un membre\n"
                + "3  : Modifier les informations d'un membre\n"
                + "4  : Ajouter un nouveau document\n"
                + "5  : Supprimer un document\n"
                + "6  : Afficher les informations d'un document\n"
                + "7  : Modifier les informations d'un document\n"
                + "8  : Afficher l’état d’un document\n"
                + "9  : Emprunter un document\n"
                + "10 : Rendre un document\n"
                + "11 : Ranger un document\n"
                + "12 : Faire une réservation\n"
                + "13 : Annuler une réservation\n"
                + "14 : Afficher le nombre de documents empruntés\n"
                + "15 : Afficher le nombre de documents sur la pile des retours\n"
                + "16 : Afficher le nombre de documents dans la section réservations\n"
                + "17 : Afficher le nombre de livres dans la bibliothèque\n"
                + "18 : Afficher le nombre de CDs dans la bibliothèque\n"
                + "\n0  : Quitter\n");
        System.out.print("Entrer votre choix : ");
    }
    
    private static void finCase(Scanner entree2) {
        System.out.print("\nAppuyer sur une touche pour continuer");
        String pause;
        pause = entree2.nextLine();
        pause += "";
        nettoyerAffichage();
    }
    
    private static DocBibliotheque selectDoc(CatalogueBibliotheque catalogue) {
        int choix;
        Scanner entree = new Scanner(System.in);
        
        nettoyerAffichage();
                    
        //affichage de la liste des documents
        System.out.println(catalogue.toString());

        System.out.print("\nChoisissez le numéro d'un document : ");
        choix = entree.nextInt();
        nettoyerAffichage();

        if (choix > 0 && choix <= catalogue.getDernier()) {
            return catalogue.getDoc(choix);
        }
        else {
            System.out.println("Erreur de saisi");
            return null;
        }
    }
    
    private static MembreBibliotheque selectMembre(ListeMembres membres) {
        int choix;
        Scanner entree = new Scanner(System.in);
        
        nettoyerAffichage();
                    
        //affichage de la liste des membres
        System.out.println(membres.toString());

        System.out.print("\nChoisissez le numéro d'abonné d'un membre : ");
        choix = entree.nextInt();
        nettoyerAffichage();

        if (choix > 0 && choix <= membres.getDernier()) { //si le membre existe
            return membres.liste.get(choix);
        }
        else {
            System.out.println("Erreur de saisi");
            return null;
        }
    }
    
    private static void nettoyerAffichage() {
        for (int i = 0; i < 20; i++) System.out.println("\n");
    }
    
    public static boolean valide(ArrayList<String> liste) {
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).equals("")) {
                return false;
            }
        }
        return !liste.isEmpty();
    }
    
}