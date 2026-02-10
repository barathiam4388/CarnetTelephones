import java.util.ArrayList;

public class CarnetTelephones {
    public static final int LNG_INIT_TAB = 2;

    private Telephone[] lesTelephones;
    private int nbrTelephones;

    public CarnetTelephones() {
        lesTelephones = new Telephone[LNG_INIT_TAB];
        nbrTelephones = 0;
    }

    public int obtenirTailleCarnet() {
        return nbrTelephones;
    }

    public boolean ajouterTelephone(Telephone tel) {
        if (tel == null) return false;

        if (nbrTelephones == lesTelephones.length) {
            Telephone[] temp = new Telephone[lesTelephones.length * 2];
            for (int i = 0; i < lesTelephones.length; i++) {
                temp[i] = lesTelephones[i];
            }
            lesTelephones = temp;
        }

        for (int i = 0; i < lesTelephones.length; i++) {
            if (lesTelephones[i] == null) {
                lesTelephones[i] = tel;
                nbrTelephones++;
                return true;
            }
        }
        return false;
    }

    public boolean supprimerTelephone(int ieme) {
        int index = getIndice(ieme);
        if (index == -1) return false;
        lesTelephones[index] = null;
        nbrTelephones--;
        return true;
    }

    public boolean modifierNomTelephone(int ieme, String nouveauNom) {
        int index = getIndice(ieme);
        if (index == -1 || nouveauNom == null || nouveauNom.trim().length() == 0) return false;
        lesTelephones[index].setNom(nouveauNom);
        return true;
    }

    public boolean modifierPrenomTelephone(int ieme, String nouveauPrenom) {
        int index = getIndice(ieme);
        if (index == -1 || nouveauPrenom == null || nouveauPrenom.trim().length() == 0) return false;
        lesTelephones[index].setPrenom(nouveauPrenom);
        return true;
    }

    public boolean modifierTypeTelephone(int ieme, int nouveauType) {
        int index = getIndice(ieme);
        if (index == -1 || nouveauType < 0 || nouveauType >= Telephone.TYPES_TEL.length) return false;
        lesTelephones[index].setType(nouveauType);
        return true;
    }

    public boolean modifierNoTelephone(int ieme, String nouveauNumero) {
        int index = getIndice(ieme);
        if (index == -1) return false;
        try {
            lesTelephones[index].setNumero(nouveauNumero);
            return true;
        } catch (TelephoneInvalideException e) {
            return false;
        }
    }

    public Telephone[] rechercherTelephones(String motif) {
        if (motif == null || motif.trim().length() == 0) return new Telephone[0];

        ArrayList<Telephone> resultats = new ArrayList<>();
        for (Telephone tel : lesTelephones) {
            if (tel != null) {
                if (tel.getNom().toLowerCase().contains(motif.toLowerCase()) ||
                    tel.getPrenom().toLowerCase().contains(motif.toLowerCase())) {
                    resultats.add(tel);
                }
            }
        }
        return resultats.toArray(new Telephone[0]);
    }

    public Telephone obtenirTelephone(int ieme) {
        int index = getIndice(ieme);
        return (index != -1) ? lesTelephones[index] : null;
    }

    public void viderCarnet() {
        for (int i = 0; i < lesTelephones.length; i++) {
            lesTelephones[i] = null;
        }
        nbrTelephones = 0;
    }

    public void fusionnerCarnets(CarnetTelephones autreCarnet) {
        if (autreCarnet == null) return;
        for (int i = 1; i <= autreCarnet.obtenirTailleCarnet(); i++) {
            Telephone tel = autreCarnet.obtenirTelephone(i);
            this.ajouterTelephone(tel);
        }
    }

    private int getIndice(int ieme) {
        if (ieme < 1 || ieme > nbrTelephones) return -1;
        int compteur = 0;
        for (int i = 0; i < lesTelephones.length; i++) {
            if (lesTelephones[i] != null) {
                compteur++;
                if (compteur == ieme) return i;
            }
        }
        return -1;
    }
}
