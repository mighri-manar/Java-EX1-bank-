public class Compte {
    private int numCompte;
    private double solde;
    private Personne titulaire;

    public Compte(int numCompte, double solde, Personne titulaire) {
        this.numCompte = numCompte;
        this.solde = solde;
    }

    public Compte(int numCompte, Personne titulaire){
        this.numCompte=numCompte;
        this.titulaire=titulaire;
    }

    public void deposer(double montant){
        this.solde+=montant;
    }
    public void retirer(double montant){

        if(this.solde>=montant){
            this.solde-=montant;
        }
        else{
            System.out.println("Sorry, you don't have enough money in your account.");
        }
    }


    public int getNumCompte() {
        return numCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

}
