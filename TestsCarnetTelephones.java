public class TestsCarnetTelephones {
    public static void main(String[] args) {
        try {
            CarnetTelephones carnet = new CarnetTelephones();
            Telephone t1 = new Telephone("Thiam", "Bara", "2347676", 0);
            Telephone t2 = new Telephone("Thiam", "Jules", "1237853", 3);
            Telephone t3 = new Telephone("Thiam", "Moses", "6549898", 2);

            carnet.ajouterTelephone(t1);
            carnet.ajouterTelephone(t2);
            carnet.ajouterTelephone(t3);

            Telephone[] resultat = carnet.rechercherTelephones("bert");
            for (Telephone t : resultat) {
                System.out.println(t);
            }

            carnet.modifierNomTelephone(2, "Thiam");
            carnet.modifierNoTelephone(1, "5554444");
            System.out.println("Après modification :");
            System.out.println(carnet.obtenirTelephone(1));

        } catch (TelephoneInvalideException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
