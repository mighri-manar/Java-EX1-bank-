public class Banque {
    private Compte[] comptes;
    private int nbComptes;
    private final int TAILLE = 100;
    private String name;

    public Banque(String nom) {
        comptes = new Compte[TAILLE];
        nbComptes = 0;
        name = nom;
    }

    public void ajouterCompte(Compte c) {
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].equals(c)) {
                return;
            }
        }
        if (nbComptes < TAILLE) {
            comptes[nbComptes] = c;
            nbComptes++;
        }
    }

    public Compte getCompte(int numCompte) {
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getNumCompte() == numCompte) {
                return comptes[i];
            }
        }
        return null;
    }

    public void deposer(int numCompte, double montant) {
        Compte c = getCompte(numCompte);
        if (c != null) {
            c.deposer(montant);
        }
    }

    public void retrait(int numCompte, double montant) {
        Compte c = getCompte(numCompte);
        if (c != null) {
            c.retirer(montant);
        }
    }

    public int generateAccountNumber() {
        int i = 0, num = (int) (Math.random() * 1000);
        if (nbComptes == 0) {
            return num;
        } else
        {
            while ((i < nbComptes) && (comptes[i].getNumCompte() != num)) {
                i++;
            }
            if (i < nbComptes) {
                generateAccountNumber();
            }
        }
        return num;
    }

    public void fermerCompte(int numCompte){
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getNumCompte() == numCompte) {
                comptes[i] = comptes[nbComptes - 1];
                comptes[nbComptes - 1] = null;
                nbComptes--;
                break;
            }
        }
    }
    




}
