public class AbilityBuilder {
    private final Abilitate abilitate = new Abilitate();

    public AbilityBuilder cuDamage(int damage) {
        abilitate.setDamage(damage);
        return this;
    }

    public AbilityBuilder blocheazaAdversarul() {
        abilitate.setStun(true);
        return this;
    }

    public AbilityBuilder nuBlocheazaAdversarul() {
        abilitate.setStun(false);
        return this;
    }

    public AbilityBuilder seVaFeriDeAbilitateaUrmatoare() {
        abilitate.setDodge(true);
        return this;
    }

    public AbilityBuilder nuSeVaFeriDeAbilitateaUrmatoare() {
        abilitate.setDodge(false);
        return this;
    }

    public AbilityBuilder cuCooldown(int cooldown) {
        abilitate.setCooldown(cooldown);
        return this;
    }

    public Abilitate build() {
        return abilitate;
    }


}
