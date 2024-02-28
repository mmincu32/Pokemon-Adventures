public class Battle {
    public static void startBattle(Antrenor a1, Antrenor a2) throws Exception {
        for (int i = 0; i < 3; ++i)
            goBattle(a1.getPokemons().get(i), a2.getPokemons().get(i));
        Pokemon best1 = PregatireAntrenor.getBestPokemon(a1);
        Pokemon best2 = PregatireAntrenor.getBestPokemon(a2);
        goBattle(best1, best2);
        Thread.sleep(2000);
        Arena.felicitaAntrenorCastigator();
        Thread.sleep(2000);

    }

    public static void goBattle(Pokemon p1, Pokemon p2) throws Exception {
        do {
            Arena.setTipBatalie();
            if (Arena.getTipBatalie() == 0) {
                Arena.setFighting1(Arena.getAntrenor1());
                Arena.setFighting2(new Antrenor("Neutru1", 35));
                BatalieCuNeutrel.vsNeutrel(p1, 1);
                Arena.setFighting1(Arena.getAntrenor2());
                Arena.setFighting2(new Antrenor("Neutru1", 35));
                BatalieCuNeutrel.vsNeutrel(p2, 1);
            } else if (Arena.getTipBatalie() == 1) {
                Arena.setFighting1(Arena.getAntrenor1());
                Arena.setFighting2(new Antrenor("Neutru2", 26));
                BatalieCuNeutrel.vsNeutrel(p1, 2);
                Arena.setFighting1(Arena.getAntrenor2());
                Arena.setFighting2(new Antrenor("Neutru2", 26));
                BatalieCuNeutrel.vsNeutrel(p2, 2);
            } else {
                Arena.setFighting1(Arena.getAntrenor1());
                Arena.setFighting2(Arena.getAntrenor2());
                BatalieIntrePokemoni.vsPokemon(p1, p2);
            }
        } while (Arena.getTipBatalie() != 2);
    }
}

