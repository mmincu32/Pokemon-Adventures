import java.io.IOException;
import java.util.ArrayList;

public class AsaltAntrenor2 implements Runnable {
    Pokemon p1;
    Pokemon p2;

    public AsaltAntrenor2(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void atacAntrenor2(Pokemon p1, Pokemon p2) throws IOException, InterruptedException {
        while (Arena.is1Alive() && Arena.is2Alive() && Arena.getNumarAtacuri() < Arena.getNumarMaximAtacuri()) {
            Arena.manageEffectsSynchronized(p1, p2);
            if (Arena.is1Alive() && Arena.is2Alive() && Arena.getNumarAtacuri() < Arena.getNumarMaximAtacuri()) {
                if (!Arena.isP2Stun()) {
                    ArrayList<Integer> informatiiAtac = AlegereAtac.atacaP2(p2, p1);
                    Arena.setEffectsP2(informatiiAtac);
                } else
                    MyLogger.mylog(p2.getNume() + " e blocat, deci nimic.");
            }
            Thread.sleep(100);
        }
    }

    @Override
    public void run() {
        try {
            atacAntrenor2(p1, p2);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
