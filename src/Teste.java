import java.io.File;
import java.util.Objects;

public class Teste {
    public static void main(String[] args) throws Exception {
        Arena a = new Arena();
        File Adventures = new File("Aventuri");
        for (File adventure : Objects.requireNonNull(Adventures.listFiles())) {
            if (adventure.getName().endsWith("8.txt"))
                AdventureMethods.runAdventure(adventure, 0);

        }


    }
}
