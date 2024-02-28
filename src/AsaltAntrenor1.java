import java.io.IOException;
import java.util.ArrayList;

public class AsaltAntrenor1 implements Runnable {
    Pokemon p1;
    Pokemon p2;

    public AsaltAntrenor1(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void atacAntrenor1(Pokemon p1, Pokemon p2) throws IOException, InterruptedException {
        while (Arena.is1Alive() && Arena.is2Alive() && Arena.getNumarAtacuri() < Arena.getNumarMaximAtacuri()) {
            Arena.manageEffectsSynchronized(p1, p2);
            if (Arena.is1Alive() && Arena.is2Alive() && Arena.getNumarAtacuri() < Arena.getNumarMaximAtacuri()) {
                if (!Arena.isP1Stun()) {
                    ArrayList<Integer> informatiiAtac = AlegereAtac.atacaP1(p1, p2);
                    Arena.setEffectsP1(informatiiAtac);
                } else
                    MyLogger.mylog(p1.getNume() + " e blocat, deci nimic.");
            }
            Thread.sleep(100);
        }

    }

    @Override
    public void run() {
        try {
            atacAntrenor1(p1, p2);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
