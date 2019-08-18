public class Proprietaire {
    private String nomProprietaire = "Pas encore de nom";
    private String adresseProprietaire = "Pas encore d'adresse";
    private double montantTaxeFonciere = 0.0;
    private double montantTaxeHabitation = 0.0;
    
    public Proprietaire(String newNomProprietaire,
                     String newAdresseProprietaire,
                     double newMontantTaxeFonciere,
                     double newMontantTaxeHabitation) {
            nomProprietaire = newNomProprietaire;
            adresseProprietaire = newAdresseProprietaire;
            montantTaxeFonciere = newMontantTaxeFonciere;
            montantTaxeHabitation = newMontantTaxeHabitation;
    }
    
    public String toString() {
        return ("Nom proprietaire : " + nomProprietaire +
                "\nAdresse proprietaire : " + adresseProprietaire +
                "\nMontant taxe fonciere : " + montantTaxeFonciere +
                "\nMontant taxe d'habitation : " + montantTaxeHabitation);
    }
}