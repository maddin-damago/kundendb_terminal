import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// test github
public class KundenApp {

    static Scanner scanner = new Scanner(System.in);
    static String menu = "1";
    static ArrayList<Kunde> kunden = KundenListe.getKunden();

    static void main(String[] args) {

        do {
            switch (menu) {
                case "2" -> kundeAnlegen();
                case "3" -> kundenAnzeigen();
                case "4" -> kundeAnzeigen();
                case null, default -> startmenu();
            }
        } while (!Objects.equals(menu, "0"));
    }

    static void useMenu() {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Auswahl: ");
                String inputLine = scanner.nextLine();

                if (Objects.equals(inputLine, "0")
                        || Objects.equals(inputLine, "1")
                        || Objects.equals(inputLine, "2")
                        || Objects.equals(inputLine, "3")
                        || Objects.equals(inputLine, "4")) {
                    menu = inputLine;
                    isValid = true;
                } else {
                    System.out.println("Fehler: Bitte nur Zahlen von 0 bis 4 eingeben.");
                }
            } catch (Exception e) {
                System.out.println("Fehler: Ungültige Eingabe (keine Zahl).");

            }
        }
    }

    static void startmenu() {
        System.out.println("1 - Startmenü");
        System.out.println("2 - Neuen Kunden anlegen");
        System.out.println("3 - Alle Kunden anzeigen");
        System.out.println("4 - Kunde anzeigen/bearbeiten");
        System.out.println("0 - Programm beenden");
        useMenu();

    }

    static void kundeAnlegen() {
        System.out.println("Neuen Kunden anlegen: ");
        System.out.print("Kunde Vorname: ");
        String vorname = scanner.nextLine();
        System.out.print("Kunde Nachname: ");
        String nachname = scanner.nextLine();
        System.out.print("Kunde Straße: ");
        String strasse = scanner.nextLine();
        System.out.print("Kunde Hausnummer: ");
        String hausnummer = scanner.nextLine();
        System.out.print("Kunde PLZ: ");
        String plz = scanner.nextLine();
        System.out.print("Kunde Ort: ");
        String ort = scanner.nextLine();
        Kunde kunde = new Kunde(Kunde.getKundenAnzahl(), vorname, nachname, new Adresse(strasse, hausnummer, plz, ort));
        System.out.println("\nNeuer Kunde angelegt:");
        formatierteKundenAusgabe(kunde);

        kunden.add(kunde);

        System.out.println();
        startmenu();
    }

    static void formatierteKundenAusgabe(Kunde kunde) {
        System.out.println();
        System.out.println("Vorname: " + kunde.getVorname());
        System.out.println("Nachname: " + kunde.getNachname());
        System.out.println("Straße/Nr: " + kunde.getAdresse().getStrasse() + " " + kunde.getAdresse().getHausnummer());
        System.out.println("PLZ: " + kunde.getAdresse().getPlz());
        System.out.println("Ort: " + kunde.getAdresse().getOrt());
    }

    static void kundenAnzeigen() {
        for (Kunde kunde : kunden) {
            formatierteKundenAusgabe(kunde);
        }
        System.out.println();
        startmenu();
    }

    static void kundeAnzeigen() {
        System.out.print("Vorname: ");
        String vorname = scanner.nextLine();
        System.out.print("Nachname: ");
        String nachname = scanner.nextLine();
        Kunde kunde = KundenListe.getKundeByName(vorname, nachname);
        formatierteKundenAusgabe(kunde);
        System.out.println();
        editKunde(kunde);
        startmenu();
    }

    static void editKunde(Kunde kunde) {
        System.out.println("Zum bearbeiten: \n(v)orname, (n)achname, (s)traße, \n(h)ausnummer, (p)lz, (o)rt");
        System.out.println("1 - Zurück zum Startmenü");
        System.out.print("Auswahl: ");
        String edit = scanner.nextLine();

        switch (edit) {
            case "v" -> editVorname(kunde);
            case "n" -> editNachname(kunde);
            case "s" -> editStrasse(kunde);
            case "h" -> editHausnummer(kunde);
            case "p" -> editPlz(kunde);
            case "o" -> editOrt(kunde);
            case "1" -> startmenu();
            case null, default -> editKunde(kunde);
        }
    }

    static void editVorname(Kunde kunde) {
        System.out.println("Vorname aktuell: " + kunde.getVorname());
        System.out.print("Vorname neu: ");
        String vornameNeu = scanner.nextLine();
        kunde.setVorname(vornameNeu);
        formatierteKundenAusgabe(kunde);
        editKunde(kunde);
    }

    static void editNachname(Kunde kunde) {
        System.out.println("Nachname aktuell: " + kunde.getNachname());
        System.out.print("Nachname neu: ");
        String nachnameNeu = scanner.nextLine();
        kunde.setNachname(nachnameNeu);
        formatierteKundenAusgabe(kunde);
        editKunde(kunde);
    }

    static void editStrasse(Kunde kunde) {
        System.out.println("Straße aktuell: " + kunde.getAdresse().getStrasse());
        System.out.print("Straße neu: ");
        String strasseNeu = scanner.nextLine();
        kunde.getAdresse().setStrasse(strasseNeu);
        formatierteKundenAusgabe(kunde);
        editKunde(kunde);
    }

    static void editHausnummer(Kunde kunde) {
        System.out.println("Hausnummer aktuell: " + kunde.getAdresse().getHausnummer());
        System.out.print("Hausnummer neu: ");
        String hausnummerNeu = scanner.nextLine();
        kunde.getAdresse().setHausnummer(hausnummerNeu);
        formatierteKundenAusgabe(kunde);
        editKunde(kunde);
    }

    static void editPlz(Kunde kunde) {
        System.out.println("PLZ aktuell: " + kunde.getAdresse().getPlz());
        System.out.print("PLZ neu: ");
        String plzNeu = scanner.nextLine();
        kunde.getAdresse().setPlz(plzNeu);
        formatierteKundenAusgabe(kunde);
        editKunde(kunde);
    }

    static void editOrt(Kunde kunde) {
        System.out.println("Ort aktuell: " + kunde.getAdresse().getOrt());
        System.out.print("Ort neu: ");
        String ortNeu = scanner.nextLine();
        kunde.getAdresse().setOrt(ortNeu);
        formatierteKundenAusgabe(kunde);
        editKunde(kunde);
    }
}
