import java.io.File;

public class AdventureMethods {

    static int adventurecounter = 0;

    public static int getAdventurecounter() {
        return adventurecounter;
    }

    public static void setAdventurecounter(int adventurecounter) {
        AdventureMethods.adventurecounter = adventurecounter;
    }

    public static void runAdventure(File adventure, int option) throws Exception {
        if (option > 1)
            throw new IllegalArgumentException("Optiune invalida.");
        adventurecounter++;
        MyLogger.setF(new File("Rezultate\\Aventura" + adventurecounter + ".txt"));
        MyLogger.initFileWriter();
        MyLogger.setOption(option);
        MyLogger.mylog("Sa inceapa aventura " + adventurecounter + "!");
        Thread.sleep(100);
        PregatireAntrenor.prepareCoaches(adventure);
        Battle.startBattle(Arena.getAntrenor1(), Arena.getAntrenor2());
        MyLogger.closeFileWriter();
    }
}
