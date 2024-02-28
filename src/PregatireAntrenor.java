import java.io.*;

public class PregatireAntrenor {

    public static void prepareCoaches(File adventure) {
        try (BufferedReader br = new BufferedReader(new FileReader(adventure))) {
            for (int count = 0; count < 2; ++count) {
                String nume = br.readLine();
                int varsta = Integer.parseInt(br.readLine());
                Antrenor antrenor = new Antrenor(nume, varsta);
                MyLogger.mylog("\nIntra in arena antrenorul " + antrenor.getNume() + " de " +
                        antrenor.getVarsta() + " ani!\n");
                Thread.sleep(100);
                for (int i = 0; i < 3; ++i) {
                    String pokemonInformations = br.readLine();
                    addPokemonForCoach(antrenor, pokemonInformations);
                }
                if (count == 0) {
                    br.readLine();
                    Arena.setAntrenor1(antrenor);
                }
                else
                    Arena.setAntrenor2(antrenor);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addPokemonForCoach(Antrenor antrenor, String pokemonInformations) throws Exception {
        String[] str = pokemonInformations.split(": ");
        String nume = str[0];
        if (nume.endsWith(":"))
            nume = nume.substring(0, nume.length() - 1);    // fix :
        MyLogger.mylog("\nIata pokemonul " + nume + " al antrenorului " + antrenor.getNume() + "!\n");
        Pokemon p = PokemonFactory.getFactory().createPokemon(nume);
        if (str.length == 2) {
            String[] itemList = str[1].split(", ");
            for (String itemName : itemList) {
                if (itemName != null)
                    AddItem.addItem(p, new Item(itemName));
            }
        }
        antrenor.getPokemons().add(p);
    }

    public static Pokemon getBestPokemon(Antrenor a) throws IOException {
        Pokemon best = a.getPokemons().get(0);
        for (int i = 1; i < a.getPokemons().size(); ++i) {
            Pokemon current = a.getPokemons().get(i);
            if (current.compareTo(best) > 0)
                best = current;
        }
        MyLogger.mylog("\n Cel mai bun pokemon al antrenorului " + a.getNume() + " este " + best.getNume());
        return best;
    }
}
