import java.io.IOException;
import java.util.ArrayList;

public class Arena {

    static Pokemon pokemon1;
    static Pokemon pokemon2;
    static int HP1;
    static int HP2;
    static int damageTo2 = 0;
    static int damageTo1 = 0;
    static boolean p1Dodge = false;
    static boolean p2Dodge = false;
    static boolean p1WillBeStunned = false;
    static boolean p2WillBeStunned = false;
    static boolean p1Stun = false;
    static boolean p2Stun = false;
    static int ability1P1Waiter = 0;
    static int ability2P2Waiter = 0;
    static int ability2P1Waiter = 0;
    static int ability1P2Waiter = 0;
    static Antrenor antrenor1;
    static Antrenor antrenor2;
    static Antrenor fighting1;
    static Antrenor fighting2;
    static boolean effectsManaged = false;
    static int numarAtacuri = 0;
    static int numarMaximAtacuri = 50;
    static int tipBatalie;
    static String castigator;

    public static Antrenor getFighting1() {
        return fighting1;
    }

    public static void setFighting1(Antrenor fighting1) {
        Arena.fighting1 = fighting1;
    }

    public static Antrenor getFighting2() {
        return fighting2;
    }

    public static void setFighting2(Antrenor fighting2) {
        Arena.fighting2 = fighting2;
    }

    public static int getTipBatalie() {
        return tipBatalie;
    }

    public static void setTipBatalie() {
        tipBatalie = (int) (Math.random() * 3);
    }

    public static int getNumarMaximAtacuri() {
        return numarMaximAtacuri;
    }

    public static void setNumarMaximAtacuri(int numarMaximAtacuri) {
        Arena.numarMaximAtacuri = numarMaximAtacuri;
    }

    public static int getNumarAtacuri() {
        return numarAtacuri;
    }

    public static void setNumarAtacuri(int numarAtacuri) {
        Arena.numarAtacuri = numarAtacuri;
    }

    public static void resetForNextBattle() {
        damageTo2 = damageTo1 = 0;
        p1Dodge = p2Dodge = false;
        p1WillBeStunned = p2WillBeStunned = false;
        p1Stun = p2Stun = false;
        ability1P1Waiter = ability2P1Waiter = 0;
        ability1P2Waiter = ability2P2Waiter = 0;
        numarAtacuri = 0;
    }


    public static boolean P1WillBeStunned() {
        return p1WillBeStunned;
    }

    public static void setP1WillBeStunned(boolean p1WillBeStunned) {
        Arena.p1WillBeStunned = p1WillBeStunned;
    }

    public static boolean P2WillBeStunned() {
        return p2WillBeStunned;
    }

    public static void setP2WillBeStunned(boolean p2WillBeStunned) {
        Arena.p2WillBeStunned = p2WillBeStunned;
    }

    public static Antrenor getAntrenor1() {
        return antrenor1;
    }

    public static void setAntrenor1(Antrenor antrenor1) {
        Arena.antrenor1 = antrenor1;
    }

    public static Antrenor getAntrenor2() {
        return antrenor2;
    }

    public static void setAntrenor2(Antrenor antrenor2) {
        Arena.antrenor2 = antrenor2;
    }

    public static synchronized void setStuns(Pokemon p1, Pokemon p2) {
        if (p1Dodge)
            p1Stun = false;
        else
            p1Stun = p1WillBeStunned;
        if (p2Dodge)
            p2Stun = false;
        else
            p2Stun = p2WillBeStunned;
        p1WillBeStunned = p2WillBeStunned = false;
    }

    public static synchronized void calculateDamage(Pokemon p1, Pokemon p2) throws IOException {
        if (!isP1Dodge()) {
            if (HP1 > damageTo1)
                HP1 -= damageTo1;
            else
                HP1 = 0;
            MyLogger.mylog(p1.getNume() + " a ramas cu " + HP1 + " HP.");
        } else
            MyLogger.mylog(p1.getNume() + " a dat dodge, asa ca a ramas cu " + HP1 + " HP.");
        if (!isP2Dodge()) {

            if (HP2 > damageTo2)
                HP2 -= damageTo2;
            else
                HP2 = 0;
            MyLogger.mylog(p2.getNume() + " a ramas cu " + HP2 + " HP.");
        } else
            MyLogger.mylog(p2.getNume() + " a dat dodge, asa ca a ramas cu " + HP2 + " HP.");

        damageTo1 = damageTo2 = 0;

    }

    public static synchronized void resetDodge(Pokemon p1, Pokemon p2) {
        p1Dodge = false;
        p2Dodge = false;
    }

    public static synchronized void manageCooldown(Pokemon p1, Pokemon p2) throws IOException {
        if (ability1P1Waiter > 0)
            ability1P1Waiter--;
        if (ability1P1Waiter == 0) {
            MyLogger.mylog(p1.getNume() + " nu are abilitatea 1 in cooldown.");
        } else {
            MyLogger.mylog(p1.getNume() + " are abilitatea 1 in cooldown " +
                    (ability1P1Waiter + "."));

        }

        if (ability2P1Waiter > 0)
            ability2P1Waiter--;
        if (ability2P1Waiter == 0) {
            MyLogger.mylog(p1.getNume() + " nu are abilitatea 2 in cooldown.");
        } else {
            MyLogger.mylog(p1.getNume() + " are abilitatea 2 in cooldown " +
                    ability2P1Waiter + ".");
        }
        if (p2.getAbilitati() != null) {
            if (ability1P2Waiter > 0)
                ability1P2Waiter--;
            if (ability1P2Waiter == 0) {
                MyLogger.mylog(p2.getNume() + " nu are abilitatea 1 in cooldown.");
            } else {
                MyLogger.mylog(p2.getNume() + " are abilitatea 1 in cooldown " +
                        (ability1P2Waiter + "."));
            }

            if (ability2P2Waiter > 0)
                ability2P2Waiter--;
            if (ability2P2Waiter == 0) {
                MyLogger.mylog(p2.getNume() + " nu are abilitatea 2 in cooldown.");
            } else {
                MyLogger.mylog(p2.getNume() + " are abilitatea 2 in cooldown " +
                        (ability2P2Waiter + "."));
            }
        }
    }

    public static void setEffectsP1(ArrayList<Integer> informatiiAtac) {
        damageTo2 = informatiiAtac.get(0);
        if (informatiiAtac.size() == 1)
            return;
        p2WillBeStunned = RandomMethods.intToBoolean(informatiiAtac.get(1));
        p1Dodge = RandomMethods.intToBoolean(informatiiAtac.get(2));
        int abilityType = informatiiAtac.get(3);
        if (abilityType == 1)
            ability1P1Waiter = informatiiAtac.get(4) + 1;
        else
            ability2P1Waiter = informatiiAtac.get(4) + 1;
    }

    public static void setEffectsP2(ArrayList<Integer> informatiiAtac) {
        damageTo1 = informatiiAtac.get(0);
        if (informatiiAtac.size() == 1)
            return;
        p1WillBeStunned = RandomMethods.intToBoolean(informatiiAtac.get(1));
        p2Dodge = RandomMethods.intToBoolean(informatiiAtac.get(2));
        int abilityType = informatiiAtac.get(3);
        if (abilityType == 1)
            ability1P2Waiter = informatiiAtac.get(4) + 1;
        else
            ability2P2Waiter = informatiiAtac.get(4) + 1;
    }

    public static void stabilesteCastigator(Pokemon p1, Pokemon p2) throws IOException {
        if (numarAtacuri == numarMaximAtacuri && HP1 != 0 && HP2 != 0) {
            castigator = null;
            MyLogger.mylog("\nDeja s-a atacat de numarul maxim de ori (" + numarMaximAtacuri + "), deci egalitate.");

        } else if (HP1 == 0 && HP2 == 0) {
            castigator = null;
            MyLogger.mylog("\nEgalitate.\n");

        } else if (Arena.getHP1() == 0) {
            castigator = fighting2.getNume();
            MyLogger.mylog("\nCastigatorul este " + fighting2.getNume() + " cu pokemonul " + p2.getNume() + ".\n");
            StuffPokemoni.premiazaPokemonCastigator(p2);
        } else {
            castigator = fighting1.getNume();
            MyLogger.mylog("\nCastigatorul este " + fighting1.getNume() + " cu pokemonul " + p1.getNume() + ".\n");
            StuffPokemoni.premiazaPokemonCastigator(p1);
        }
    }

    public static void felicitaAntrenorCastigator() throws IOException {
        if (castigator == null) {
            MyLogger.mylog("\nCat de stransa a putut fi lupta finala! Ambii antrenori au dat totul si" +
                    "niciunul nu a iesit victorios! Felicitari celor 2 antrenori, " + antrenor1.getNume() +
                    " si " + antrenor2.getNume() + "! Speram ca v-ati distrat cu noi in aventura "
                    + AdventureMethods.getAdventurecounter() + "! Zi faina!\n");
        } else {
            MyLogger.mylog("\n" + castigator + " castiga aventura " + AdventureMethods.getAdventurecounter()
                    + "! Ce prestatie impecabila din partea sa! Sper ca v-ati distrat cu noi si zi faina!\n");
        }
    }

    public static synchronized void manageEffectsSynchronized(Pokemon p1, Pokemon p2) throws IOException {
        if (effectsManaged) {
            effectsManaged = false;
            return;
        }
        numarAtacuri++;
        MyLogger.mylog("\nRunda " + numarAtacuri + ":");
        manageEffects(p1, p2);
        effectsManaged = true;

    }

    public static void manageEffects(Pokemon p1, Pokemon p2) throws IOException {
        calculateDamage(p1, p2);
        manageCooldown(p1, p2);
        setStuns(p1, p2);
        resetDodge(p1, p2);
    }


    public static boolean is1Alive() {
        return (HP1 != 0);
    }

    public static boolean is2Alive() {
        return (HP2 != 0);
    }


    public static Pokemon getPokemon1() {
        return pokemon1;
    }

    public static void setPokemon1(Pokemon pokemon1) {
        Arena.pokemon1 = pokemon1;
    }

    public static Pokemon getPokemon2() {
        return pokemon2;
    }

    public static void setPokemon2(Pokemon pokemon2) {
        Arena.pokemon2 = pokemon2;
    }

    public static int getHP1() {
        return HP1;
    }

    public static void setHP1(int HP1) {
        Arena.HP1 = HP1;
    }

    public static int getHP2() {
        return HP2;
    }

    public static void setHP2(int HP2) {
        Arena.HP2 = HP2;
    }

    public static int getDamageTo2() {
        return damageTo2;
    }

    public static void setDamageTo2(int damageTo2) {
        Arena.damageTo2 = damageTo2;
    }

    public static int getDamageTo1() {
        return damageTo1;
    }

    public static void setDamageTo1(int damageTo1) {
        Arena.damageTo1 = damageTo1;
    }


    public static boolean isP1Dodge() {
        return p1Dodge;
    }

    public static void setP1Dodge(boolean p1Dodge) {
        Arena.p1Dodge = p1Dodge;
    }

    public static boolean isP2Dodge() {
        return p2Dodge;
    }

    public static void setP2Dodge(boolean p2Dodge) {
        Arena.p2Dodge = p2Dodge;
    }

    public static boolean isP1Stun() {
        return p1Stun;
    }

    public static void setP1Stun(boolean p1Stun) {
        Arena.p1Stun = p1Stun;
    }

    public static boolean isP2Stun() {
        return p2Stun;
    }

    public static void setP2Stun(boolean p2Stun) {
        Arena.p2Stun = p2Stun;
    }


    public static int getAbility1P1Waiter() {
        return ability1P1Waiter;
    }

    public static void setAbility1P1Waiter(int ability1P1Waiter) {
        Arena.ability1P1Waiter = ability1P1Waiter;
    }

    public static int getAbility2P2Waiter() {
        return ability2P2Waiter;
    }

    public static void setAbility2P2Waiter(int ability2P2Waiter) {
        Arena.ability2P2Waiter = ability2P2Waiter;
    }

    public static int getAbility2P1Waiter() {
        return ability2P1Waiter;
    }

    public static void setAbility2P1Waiter(int ability2P1Waiter) {
        Arena.ability2P1Waiter = ability2P1Waiter;
    }

    public static int getAbility1P2Waiter() {
        return ability1P2Waiter;
    }

    public static void setAbility1P2Waiter(int ability1P2Waiter) {
        Arena.ability1P2Waiter = ability1P2Waiter;
    }
}
