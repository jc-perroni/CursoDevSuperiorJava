package entities;

public class Champion {

    private String name;
    private int life;
    private int attack;
    private int armor;

    public Champion(String name, int life, int attack, int armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void takeDamage(int attackOtherChampion) {
        if ((attackOtherChampion - this.armor) <= 0) {
            this.life -= 1;
        }
        else {
            this.life -= (attackOtherChampion - this.armor);
        }
    }

    public String status() {
        if (this.life <= 0) {
            return String.format("""
                    %s: 0 de vida (morreu)
                    """, this.name, this.life);
        } else {
            return String.format("""
                    %s: %d de vida
                    """, this.name, this.life);
        }
    }
}