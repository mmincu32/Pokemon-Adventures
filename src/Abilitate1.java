import java.io.IOException;
import java.util.ArrayList;

public class Abilitate1 extends Comanda {
    @Override
    public ArrayList<Integer> executa(Pokemon p1, Pokemon p2) throws IOException {
        MyLogger.mylog(p1.getNume() + " abilitate 1.");
        ArrayList<Integer> informatiiAtac = new ArrayList<>();
        Abilitate ab1 = p1.getAbilitati().get(0);
        informatiiAtac.add(ab1.getDamage());
        informatiiAtac.add(RandomMethods.booleanToInt(ab1.isStun()));
        informatiiAtac.add(RandomMethods.booleanToInt(ab1.isDodge()));
        informatiiAtac.add(1);
        informatiiAtac.add(ab1.getCooldown());
        return informatiiAtac;

    }
}
