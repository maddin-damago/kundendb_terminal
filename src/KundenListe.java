import java.util.ArrayList;
import java.util.Objects;

public class KundenListe {
    public static ArrayList<Kunde> kunden = new ArrayList<>(20);

    public static Kunde getKundeById(int id) {
        return kunden.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public static Kunde getKundeByName(String vorname, String nachname) {
        return kunden.stream()
                .filter(i -> Objects.equals(i.getVorname().toLowerCase(), vorname.toLowerCase())
                        && Objects.equals(i.getNachname().toLowerCase(), nachname.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public static void deleteKunde(Kunde kunde) {
        kunden.remove(kunde);

    }

    public static ArrayList<Kunde> getKunden() {
        return kunden;
    }
}
