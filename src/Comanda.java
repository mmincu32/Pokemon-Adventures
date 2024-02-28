import java.io.IOException;
import java.util.ArrayList;

public abstract class Comanda {
    //int damage;
    public abstract ArrayList<Integer> executa(Pokemon p1, Pokemon p2) throws IOException;
}
