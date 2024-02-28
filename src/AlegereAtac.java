import java.io.IOException;
import java.util.ArrayList;

public class AlegereAtac {
    public static String[] tipuriAtac = {"Atac normal", "Atac special", "Abilitate 1", "Abilitate 2"};

    public static ArrayList<Integer> atacaP1(Pokemon p1, Pokemon p2) throws IOException {

        ArrayList<Integer> availableAttacks = new ArrayList<>();
        ArrayList<Integer> informatiiAtac = new ArrayList<>();
        if (p1.isNormal())
            availableAttacks.add(1);
        if (p1.isSpecial())
            availableAttacks.add(2);
        if (Arena.getAbility1P1Waiter() == 0)
            availableAttacks.add(3);
        if (Arena.getAbility2P1Waiter() == 0)
            availableAttacks.add(4);

        int attackIndex = (int) (Math.random() * availableAttacks.size());
        String tipAtac = tipuriAtac[availableAttacks.get(attackIndex) - 1];
        switch (tipAtac) {
            case "Atac normal" -> informatiiAtac = new AtacNormal().executa(p1, p2);
            case "Atac special" -> informatiiAtac = new AtacSpecial().executa(p1, p2);
            case "Abilitate 1" -> informatiiAtac = new Abilitate1().executa(p1, p2);
            case "Abilitate 2" -> informatiiAtac = new Abilitate2().executa(p1, p2);
        }
        return informatiiAtac;
    }

    public static ArrayList<Integer> atacaP2(Pokemon p1, Pokemon p2) throws IOException {

        ArrayList<Integer> availableAttacks = new ArrayList<>();
        ArrayList<Integer> informatiiAtac = new ArrayList<>();
        if (p1.isNormal())
            availableAttacks.add(1);
        if (p1.isSpecial())
            availableAttacks.add(2);
        if (Arena.getAbility1P2Waiter() == 0)
            availableAttacks.add(3);
        if (Arena.getAbility2P2Waiter() == 0)
            availableAttacks.add(4);

        int attackIndex = (int) (Math.random() * availableAttacks.size());
        String tipAtac = tipuriAtac[availableAttacks.get(attackIndex) - 1];
        switch (tipAtac) {
            case "Atac normal" -> informatiiAtac = new AtacNormal().executa(p1, p2);
            case "Atac special" -> informatiiAtac = new AtacSpecial().executa(p1, p2);
            case "Abilitate 1" -> informatiiAtac = new Abilitate1().executa(p1, p2);
            case "Abilitate 2" -> informatiiAtac = new Abilitate2().executa(p1, p2);
        }
        return informatiiAtac;
    }
}
