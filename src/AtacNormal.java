import java.io.IOException;
import java.util.ArrayList;

public class AtacNormal extends Comanda {
    @Override
    public ArrayList<Integer> executa(Pokemon p1, Pokemon p2) throws IOException {
        ArrayList<Integer> informatiiAtac = new ArrayList<>();
        MyLogger.mylog(p1.getNume() + " atac normal.");
        if (p1.getAttack() > p2.getDefense())
            informatiiAtac.add(p1.getAttack() - p2.getDefense());
        else
            informatiiAtac.add(0);
        return informatiiAtac;
    }
}
