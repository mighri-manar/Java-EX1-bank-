import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create an account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. See account info");
            System.out.println("5. Modify account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("Enter account holder's name: ");
                    String nom = scanner.next();
                    System.out.print("Enter account holder's prenom: ");
                    String prenom = scanner.next();
                    System.out.print("Enter account holder's cin: ");
                    int cin = scanner.nextInt();
                    Personne titulaire = new Personne(nom, prenom, cin);
                    int numCompte= banque.generateAccountNumber();
                    System.out.println("Here's your account number, don't lose it!\n " + numCompte);
                    System.out.print("How much do you want to deposit? ");
                    double solde = scanner.nextDouble();
                    if (solde < 0) {
                        System.out.println("Invalid amount. Please enter a positive number.");
                        break;
                    }
                    else if (solde == 0) {
                        Compte compte = new Compte(numCompte, titulaire);
                        banque.ajouterCompte(compte);
                        break;
                    }
                    else if (solde > 0) {
                        Compte compte = new Compte(numCompte, solde, titulaire);
                        banque.ajouterCompte(compte);
                    }

                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    numCompte = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double montant = scanner.nextDouble();
                    banque.deposer(numCompte, montant);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    numCompte = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    montant = scanner.nextDouble();
                    banque.retrait(numCompte, montant);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    numCompte = scanner.nextInt();
                    Compte c = banque.getCompte(numCompte);
                    if (c != null) {
                        System.out.println("Account Number: " + c.getNumCompte());
                        System.out.println("Account Balance: " + c.getSolde());
                        System.out.println("Account Holder: " + c.getTitulaire().getNom() + " " + c.getTitulaire().getPrenom());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;


                case 5 :
                    System.out.println("1. Modify name");
                    System.out.println("2. Modify surname");
                    System.out.println("3. Modify cin");
                    System.out.print("Enter your choice: ");
                    int choice2 = scanner.nextInt();
                    System.out.print("Enter account number: ");
                    numCompte = scanner.nextInt();
                    c = banque.getCompte(numCompte);
                    switch (choice2) {
                        case 1:
                            System.out.print("Enter new name: ");
                            nom = scanner.next();
                            c.getTitulaire().setNom(nom);
                            break;
                        case 2:
                            System.out.print("Enter new surname: ");
                            prenom = scanner.next();
                            c.getTitulaire().setPrenom(prenom);
                            break;
                        case 3:
                            System.out.print("Enter new cin: ");
                            cin = scanner.nextInt();
                            c.getTitulaire().setCin(cin);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    }
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}