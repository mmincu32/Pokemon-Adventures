import java.io.IOException;
import java.util.ArrayList;

public class AtacSpecial extends Comanda {
    @Override
    public ArrayList<Integer> executa(Pokemon p1, Pokemon p2) throws IOException {
        MyLogger.mylog(p1.getNume() + " atac special.");
        ArrayList<Integer> informatiiAtac = new ArrayList<>();
        if (p1.getSpecialAttack() > p2.getSpecialDefense())
            informatiiAtac.add(p1.getSpecialAttack() - p2.getSpecialDefense());
        else
            informatiiAtac.add(0);
        return informatiiAtac;
    }
}
