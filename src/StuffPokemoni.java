import java.io.IOException;

public class StuffPokemoni {

    public static void afiseazaCaracteristici(Pokemon p) throws IOException {
        String attack;
        String specialAttack;
        if (p.getAttack() == 0)
            attack = "fara atac normal";
        else
            attack = "atac normal " + p.getAttack();
        if (p.getSpecialAttack() == 0)
            specialAttack = "fara atac special";
        else
            specialAttack = "atac special " + p.getSpecialAttack();

        MyLogger.mylog("Pokemonul " + p.getNume() + " are caracteristicile: " + p.getHP() + " HP, " +
                attack + ", " + specialAttack + ", defense " + p.getDefense() + ", special defense "
                + p.getSpecialDefense() + ".");
    }

    public static void premiazaPokemonCastigator(Pokemon p) throws IOException {
        p.setHP(p.getHP() + 1);
        if (p.getAttack() > 0)
            p.setAttack(p.getAttack() + 1);
        if (p.getSpecialAttack() > 0)
            p.setSpecialAttack(p.getSpecialAttack() + 1);
        p.setDefense(p.getDefense() + 1);
        p.setSpecialDefense(p.getSpecialDefense() + 1);
        MyLogger.mylog("Caracteristici noi " + p.getNume() + ":");
        afiseazaCaracteristici(p);

    }


}
