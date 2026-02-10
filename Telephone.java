public class Telephone {
    public static final String[] TYPES_TEL = {"DOMICILE", "TRAVAIL", "CELLULAIRE", "AUTRE"};

    private String nom;
    private String prenom;
    private String numero;
    private int type;

    public Telephone(String nom, String prenom, String numero, int type) throws TelephoneInvalideException {
        if (numero == null || !(numero.length() == 7 || numero.length() == 10 || numero.length() == 11)) {
            throw new TelephoneInvalideException("Numéro invalide");
        }
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.type = type;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) throws TelephoneInvalideException {
        if (numero == null || !(numero.length() == 7 || numero.length() == 10 || numero.length() == 11)) {
            throw new TelephoneInvalideException("Numéro invalide");
        }
        this.numero = numero;
    }

    public int getType() { return type; }
    public void setType(int type) { this.type = type; }

    public String toString() {
        return prenom + " " + nom + " : " + numero + " [" + TYPES_TEL[type] + "]";
    }
}