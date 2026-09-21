import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        
        /*2.3 */
        /* Parc monParc = new Parc("RT");

        Materiel m1 = new Materiel("SNOO1", "Dell");
        Materiel m2= new Materiel("SNO02","Apple");

        monParc.ajouterMateriel(m1);
        monParc.ajouterMateriel(m2);

        monParc.afficherParc();

        monParc.supprimerMateriel("SNOO1");
        System.out.println("Après suppression : ");
        monParc.afficherParc(); */
        

        Parc monParc = new Parc("RT");

        Materiel m1 = new Switch("SN001", "Cisco", 40);
        Materiel m2 = new OrdinateurFixe("SN002", "Dell", 10, "Nvidia", 10);
        Materiel m3 = new OrdinateurPortable("SN003", "Apple", 40, "Apple", 30, 99);

        monParc.ajouterMateriel(m1);
        monParc.ajouterMateriel(m2);
        monParc.ajouterMateriel(m3);

        monParc.afficherParc();

    
        Scanner sc = new Scanner(System.in);

        boolean continuer = true;
        while (continuer) {
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Ajouter un materiel");
            System.out.println("2. Afficher le parc");
            System.out.println("3. Rechercher un materiel par son nb de serie");
            System.out.println("4. Rechercher un materiel par son type");
            System.out.println("5. Quitter");
            int choix = sc.nextInt();

            if (choix == 1 ) {
                System.out.println("Quel type de materiel?");
                System.out.println("1. Switch");
                System.out.println("2. Ordinateur fixe");
                System.out.println("3. Ordinateur portable");
                int type = sc.nextInt();

                System.out.println("N° de serie : ");
                String numeroSerie = sc.next();

                System.out.println("Marque : ");
                String marque = sc.next();

                if (type == 1) {
                    System.out.println("Nb de ports : ");
                    int nbPorts= sc.nextInt();
                    monParc.ajouterMateriel(new Switch(numeroSerie, marque, nbPorts));
                }

                else if (type == 2) {
                    System.out.println("RAM : ");
                    int ram = sc.nextInt();
                    System.out.println("CPU : ");
                    String  cpu = sc.next();
                    System.out.println("Memoire de masse: ");
                    int memoireMasse = sc.nextInt();
                    monParc.ajouterMateriel(new OrdinateurFixe(numeroSerie, marque, ram, cpu, memoireMasse));
                }

                else if (type == 3) {
                    System.out.println("RAM : ");
                    int ram = sc.nextInt();
                    System.out.println("CPU : ");
                    String  cpu = sc.next();
                    System.out.println("Memoire de masse: ");
                    int memoireMasse = sc.nextInt();
                    System.out.println("Batterie : ");
                    int batterie= sc.nextInt();
                    monParc.ajouterMateriel(new OrdinateurPortable(numeroSerie, marque, ram, cpu, memoireMasse, batterie));

                }
            }

            else if (choix == 2) {
                monParc.afficherParc();
            }

            else if (choix == 3) {
                System.out.println("N° de serie : ");
                String numeroSerie = sc.next();
                monParc.rechercherMaterielNbSerie(numeroSerie);


            }

            else if (choix == 4) {
                System.out.println("Type : ");
                String type = sc.next();
                for (Materiel m : monParc.rechercherMaterielType(type)) {
                    m.afficher();
                }
            }
            
            else if (choix == 5) {
                continuer = false;
            }
        }

        sc.close();




    }
}
