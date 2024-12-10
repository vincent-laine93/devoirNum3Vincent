import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int choix;
        Scanner scanner = new Scanner(System.in);
        do {
            do {
                System.out.println("1 - Exercice 1");
                System.out.println("2 - Exercice 2");
                System.out.println("0 - Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
            } while (choix > 4);

            switch (choix) {
                case 0:
                    System.out.println("Fin du programme");
                    break;
                case 1:

                    int[] paquet = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                    int[] paquetJoueur1 = new int[5];
                    int[] paquetJoueur2 = new int[5];

                    melangerTableau(paquet);
                    System.out.println("Voici le paquet mélanger : ");
                    afficherTableau(paquet);
                    dispatcherTableaux(paquetJoueur1, paquetJoueur2, paquet);
//                    afficherTableau(paquetJoueur1);
//                    afficherTableau(paquetJoueur2);
                    deroulerPartie(paquetJoueur1, paquetJoueur2);


                    break;
                case 2:
                    String[][] genres = new String[5][2];
                    String[][] films = new String[5][4];
                    int[][] notes = new int[5][7];

                    remplirTableauxExo2(films, genres, notes);
                    int choixMenuExo2;
                    do {
                        do {
                            System.out.println("1 - Afficher informations");
                            System.out.println("2 - Noter un film");
                            System.out.println("0 - Menu principal");
                            System.out.print("Votre choix : ");
                            choixMenuExo2 = scanner.nextInt();
                        } while (choixMenuExo2 > 2);
                        switch (choixMenuExo2) {
                            case 0:
                                break;
                            case 1:
                                afficherInfoFilms(genres, films, notes);
                                break;
                            case 2:

                                // A vous de jouer

                                break;
                        }
                    } while (choixMenuExo2 != 0);
                    break;
            }
        } while (choix != 0);
    }

    public static void remplirTableauxExo2(String[][] genres, String[][] films, int[][] notes) {
        genres[0] = new String[]{"1", "Genre A"};
        genres[1] = new String[]{"2", "Genre B"};
        genres[2] = new String[]{"3", "Genre C"};
        genres[3] = new String[]{"4", "Genre D"};
        genres[4] = new String[]{"5", "Genre E"};

        films[0] = new String[]{"1", "Film A", "1", "21"};
        films[1] = new String[]{"2", "Film B", "2", "19"};
        films[2] = new String[]{"3", "Film C", "3", "24"};
        films[3] = new String[]{"4", "Film D", "4", "20"};
        films[4] = new String[]{"5", "Film E", "5", "14"};

        notes[0] = new int[]{5, 4, 5, 4, 3, 0, 0};
        notes[1] = new int[]{3, 4, 4, 5, 3, 0, 0};
        notes[2] = new int[]{5, 5, 5, 4, 5, 0, 0};
        notes[3] = new int[]{4, 4, 3, 4, 5, 0, 0};
        notes[4] = new int[]{3, 2, 3, 2, 4, 0, 0};
    }

    public static int[] melangerTableau(int unTableau[]) {

        int nbAleatoire1;
        int nbAleatoire2;
        int vide; //permet lechange entre les valeur du tableau
        Random random = new Random();

        for (int i = 0; i < unTableau.length; i++) {
            nbAleatoire1 = random.nextInt(unTableau.length);
            nbAleatoire2 = random.nextInt(unTableau.length);
            vide = unTableau[nbAleatoire1];
            unTableau[nbAleatoire1] = unTableau[nbAleatoire2];
            unTableau[nbAleatoire2] = vide;
        }

        return unTableau;
    }

    public static void afficherTableau(int[] unTableau) {
        for (int i = 0; i < unTableau.length; i++) {
            System.out.print(unTableau[i] + " - ");
        }
        System.out.println();
    }

    public static void dispatcherTableaux(int[] tabJoueur1, int[] tabJoueur2, int[] tabPaquet) {
        for (int i = 0; i < tabPaquet.length; i++) {
            if (i % 2 == 0) {
                tabJoueur1[i / 2] = tabPaquet[i];
            } else {
                tabJoueur2[i / 2] = tabPaquet[i];
            }
        }


    }

    public static void deroulerPartie(int[] tabJoueur1, int[] tabJoueur2) {
        int numPli = 1;
        int scoreJoueur1 = 0;
        int scoreJoueur2 = 0;
        int resultat; //prend la valeur 1 si le joueur 1 a gagner et 2 si c'est le joueur 2
        System.out.println("Pli\t\tJoueur 1\tJoueur 2\tScore");
        for (int i = 0; i < tabJoueur1.length; i++) {
            if (tabJoueur1[i] > tabJoueur2[i]) {
                scoreJoueur1 += 1;
                resultat = 1;
            } else {
                scoreJoueur2 += 1;
                resultat = 2;
            }
            System.out.println("N°" + numPli + "\t\t" + tabJoueur1[i] + "\t\t\t" + tabJoueur2[i] + "\t\t\tJoueur " + resultat + " gagne");
            numPli += 1;
        }
        System.out.println("Score final ==> Joueur 1 =" + scoreJoueur1 + " : Joueur 2 = " + scoreJoueur2);
    }

    public static void afficherInfoFilms(String[][] tabFilms, String[][] tabGenre, int[][] tabNote) {

        // Parcours de tous les films
        for (int i = 0; i < 5; i++) {
            // Récupération des informations du film
            String idFilm = tabFilms[i][0];
            String nomFilm = tabFilms[i][1];
            String genreFilm = tabGenre[i][0];
            String totalNote = tabFilms[i][3];


//             Construction de la chaîne de notes
            String notesFilm = "";
            for (int j = 0; j < nombreDeNotes; j++) {
                notesFilm += tabNote[i][j] + " ";
            }

            // Affichage des informations du film
            System.out.println(idFilm + "\t" + nomFilm + "\t" + genreFilm + "\t\t");
        }
    }
}
