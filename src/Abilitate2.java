import java.io.IOException;
import java.util.ArrayList;

public class Abilitate2 extends Comanda {
    @Override
    public ArrayList<Integer> executa(Pokemon p1, Pokemon p2) throws IOException {
        MyLogger.mylog(p1.getNume() + " abilitate 2.");
        ArrayList<Integer> informatiiAtac = new ArrayList<>();
        Abilitate ab2 = p1.getAbilitati().get(1);
        informatiiAtac.add(ab2.getDamage());
        informatiiAtac.add(RandomMethods.booleanToInt(ab2.isStun()));
        informatiiAtac.add(RandomMethods.booleanToInt(ab2.isDodge()));
        informatiiAtac.add(2);
        informatiiAtac.add(ab2.getCooldown());
        return informatiiAtac;
    }
}
