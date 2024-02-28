public class PokemonBuilder {
    private final Pokemon pokemon = new BuildablePokemon();

    public PokemonBuilder cuNumele(String nume) {
        pokemon.setNume(nume);
        return this;
    }

    public PokemonBuilder cuHP(int HP) {
        pokemon.setHP(HP);
        return this;
    }

    public PokemonBuilder cuNormalAttack(int attack) {
        pokemon.setAttack(attack);
        return this;
    }

    public PokemonBuilder faraNormalAttack() {
        pokemon.setAttack(0);
        return this;
    }

    public PokemonBuilder cuSpecialAttack(int specialAttack) {
        pokemon.setSpecialAttack(specialAttack);
        return this;
    }

    public PokemonBuilder faraSpecialAttack() {
        pokemon.setSpecialAttack(0);
        return this;
    }

    public PokemonBuilder cuDefense(int defense) {
        pokemon.setDefense(defense);
        return this;
    }

    public PokemonBuilder cuSpecialDefense(int specialDefense) {
        pokemon.setSpecialDefense(specialDefense);
        return this;
    }

    public PokemonBuilder faraAbilitati() {
        pokemon.setAbilitati(null);
        return this;
    }

    public PokemonBuilder cuAbilitatea1(Abilitate ab1) throws Exception {
        if (pokemon.abilitati.size() == 0) {
            pokemon.adaugaAbilitate(ab1);
            return this;
        } else {
            throw new Exception("Nu se poate adauga abilitatea 1.");
        }
    }

    public PokemonBuilder cuAbilitatea2(Abilitate ab2) throws Exception {
        if (pokemon.abilitati.size() == 1) {
            pokemon.adaugaAbilitate(ab2);
            return this;
        } else {
            throw new Exception("Nu se poate adauga abilitatea 2.");
        }
    }

    public Pokemon build() {
        return pokemon;
    }

}
