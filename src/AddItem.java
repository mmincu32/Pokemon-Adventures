import java.io.IOException;

public class AddItem {

    public static void addItem(Pokemon p, Item item) throws IOException {
        if (p.getAttack() != 0)
            p.setAttack(p.getAttack() + item.getAttackBonus());
        if (p.getSpecialAttack() != 0)
            p.setSpecialAttack(p.getSpecialAttack() + item.getSpecialAttackBonus());
        p.setHP(p.getHP() + item.getHPBonus());
        p.setDefense(p.getDefense() + item.getDefenseBonus());
        p.setSpecialDefense(p.getSpecialDefense() + item.getSpecialDefenseBonus());
        MyLogger.mylog("Pokemonul " + p.getNume() + " s-a echipat cu item-ul " + item.getNume() + ".");

    }
}
