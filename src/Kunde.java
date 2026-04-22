public class Kunde {
    private int id;
    private String vorname;
    private String nachname;
    private Adresse adresse;

    public static int getKundenAnzahl() {
        return kundenAnzahl;
    }

    static int kundenAnzahl = 0;

    public Kunde(int id, String vorname, String nachname, Adresse adresse) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;

        kundenAnzahl++;
    }

    public int getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", adresse=" + adresse +
                '}';
    }
}
