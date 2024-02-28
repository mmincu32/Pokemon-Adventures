import java.io.IOException;

public class BatalieIntrePokemoni {

    public static void vsPokemon(Pokemon p1, Pokemon p2) throws IOException, InterruptedException {
        Arena.setHP1(p1.getHP());
        Arena.setHP2(p2.getHP());

        MyLogger.mylog("\n" + p1.getNume() + " se va duela cu " + p2.getNume() + ".\n");
        StuffPokemoni.afiseazaCaracteristici(p1);
        StuffPokemoni.afiseazaCaracteristici(p2);
        MyLogger.mylog("\n");
        MyLogger.mylog("Initial " + p1.getNume() + " are " + Arena.getHP1() + " HP, iar "
                + p2.getNume() + " are " + Arena.getHP2() + " HP.\n");
        Thread.sleep(100);
        Thread t1 = new Thread(new AsaltAntrenor1(p1, p2));
        t1.start();
        Thread t2 = new Thread(new AsaltAntrenor2(p1, p2));
        t2.start();
        t1.join();
        t2.join();
        Arena.stabilesteCastigator(p1, p2);
        Arena.resetForNextBattle();
    }
}
