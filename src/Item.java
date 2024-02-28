public class Item {
    String nume;
    int HPBonus = 0;
    int attackBonus = 0;
    int specialAttackBonus = 0;
    int defenseBonus = 0;
    int specialDefenseBonus = 0;


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getHPBonus() {
        return HPBonus;
    }

    public void setHPBonus(int HPBonus) {
        this.HPBonus = HPBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getSpecialAttackBonus() {
        return specialAttackBonus;
    }

    public void setSpecialAttackBonus(int specialAttackBonus) {
        this.specialAttackBonus = specialAttackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public int getSpecialDefenseBonus() {
        return specialDefenseBonus;
    }

    public void setSpecialDefenseBonus(int specialDefenseBonus) {
        this.specialDefenseBonus = specialDefenseBonus;
    }


    public Item(String nume) {
        this.nume = nume;
        switch (nume) {
            case "Scut" -> {
                this.setDefenseBonus(2);
                this.setSpecialDefenseBonus(2);
            }
            case "Vesta" -> this.setHPBonus(10);
            case "Sabiuta" -> this.setAttackBonus(3);
            case "Bagheta magica" -> this.setSpecialAttackBonus(3);
            case "Vitamine" -> {
                this.setHPBonus(2);
                this.setAttackBonus(2);
                this.setSpecialAttackBonus(2);
            }
            case "Brad de Craciun" -> {
                this.setAttackBonus(3);
                this.setDefenseBonus(1);
            }
            case "Pelerina" -> this.setSpecialDefenseBonus(3);
            default -> {
            }
        }
    }
}
