import java.util.ArrayList;

public abstract class Pokemon implements Comparable<Pokemon>{
    String nume;
    int HP;
    int attack;
    int specialAttack;
    int defense;
    int specialDefense;
    ArrayList<Abilitate> abilitati = new ArrayList<>();


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public boolean isNormal() { return (this.attack != 0); }

    public boolean isSpecial() { return (this.specialAttack != 0); }


    public ArrayList<Abilitate> getAbilitati() {
        return abilitati;
    }

    public void setAbilitati(ArrayList<Abilitate> abilitati) {
        this.abilitati = abilitati;
    }

    public void adaugaAbilitate(Abilitate abilitate) {
        this.abilitati.add(abilitate);
    }

    @Override
    public int compareTo(Pokemon o) {
        int thisSum = this.HP + this.attack + this.specialAttack + this.defense + this.specialDefense;
        int oSum = o.getHP() + o.getAttack() + o.getSpecialAttack() + o.getDefense() + o.getSpecialDefense();
        if (thisSum < oSum)
            return -1;
        if (thisSum > oSum)
            return 1;
        return Integer.compare(this.nume.compareTo(o.getNume()), 0);
    }
}


