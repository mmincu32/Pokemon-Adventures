import java.util.ArrayList;

public class BatalieCuNeutrel {


    public static void vsNeutrel(Pokemon p, int tipNeutrel) throws Exception {
        Pokemon neutrel;
        if (tipNeutrel != 1 && tipNeutrel != 2)
            throw new IllegalArgumentException("Nu exista decat neutrel 1 si 2!");
        else {
            if (tipNeutrel == 1)
                neutrel = PokemonFactory.getFactory().createPokemon("Neutrel1");
            else
                neutrel = PokemonFactory.getFactory().createPokemon("Neutrel2");
        }
        Arena.setHP1(p.getHP());
        Arena.setHP2(neutrel.getHP());

        MyLogger.mylog("\n" + p.getNume() + " se va duela cu " + neutrel.getNume() + ".\n");
        StuffPokemoni.afiseazaCaracteristici(p);
        StuffPokemoni.afiseazaCaracteristici(neutrel);
        MyLogger.mylog("\n");
        MyLogger.mylog("Initial " + p.getNume() + " are " + Arena.getHP1() + " HP, iar "
                + neutrel.getNume() + " are " + Arena.getHP2() + " HP.\n");
        Thread.sleep(100);

        while (Arena.is1Alive() && Arena.is2Alive() && Arena.getNumarAtacuri() < Arena.getNumarMaximAtacuri()) {
            Arena.setNumarAtacuri(Arena.getNumarAtacuri() + 1);
            MyLogger.mylog("\nRunda " + Arena.getNumarAtacuri() + ":");
            ArrayList<Integer> informatiiAtacPokemon = AlegereAtac.atacaP1(p, neutrel);
            Arena.setEffectsP1(informatiiAtacPokemon);
            if (!Arena.isP2Stun()) {
                ArrayList<Integer> informatiiAtacNeutrel = new AtacNormal().executa(neutrel, p);
                Arena.setEffectsP2(informatiiAtacNeutrel);
            } else {
                MyLogger.mylog(neutrel.getNume() + " e blocat, deci nimic.");
                Arena.setP2Stun(false);
            }
            Thread.sleep(100);
            Arena.manageEffects(p, neutrel);
            Thread.sleep(100);


        }
        Arena.stabilesteCastigator(p, neutrel);
        Arena.resetForNextBattle();


    }


}
