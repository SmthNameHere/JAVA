package lab5.model;

import java.util.Objects;
import java.util.Random;


/**
 * PACKAGE NAME: lab5
 * CREATED BY: *JAVAнутые*
 * PROJECT NAME: NaGugl
 * VERSION: 1.0.0
 */
public class Person {
    private double maxHp;
    private double hp;
    private int defence;
    private double damage;
    private double chanceOfCriticalDamage;

    public Person() {
        maxHp = 0;
        hp = 0;
        defence = 0;
        damage = 0.0;
        chanceOfCriticalDamage = 0.0;
    }

    public Person(double hp, int defence, double damage, double chanceOfCriticalDamage, double maxHp) {
        this.hp = hp;
        this.defence = defence;
        this.damage = damage;
        this.chanceOfCriticalDamage = chanceOfCriticalDamage;
    }

    public Person(Person person) {
        maxHp = person.maxHp;
        hp = person.hp;
        defence = person.defence;
        damage = person.damage;
        chanceOfCriticalDamage = person.chanceOfCriticalDamage;
    }

    public double bump() {
        double tempDamage = damage;
        Random random = new Random();
        double temp = random.nextDouble();
        if (temp < chanceOfCriticalDamage) {
            tempDamage += tempDamage * 0.5;
        }
        return tempDamage;
    }

    public double hit(double damage) {
        double tempHit = damage - defence;
        hp -= tempHit;
        if (hp < 0) {
            tempHit = -hp + tempHit;
            hp = 0;
        }
        return tempHit;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        if(hp <= maxHp && hp > 0) {
            this.hp = hp;
        } else if (hp > maxHp) {
            this.hp = maxHp;
        }
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getChanceOfCriticalDamage() {
        return chanceOfCriticalDamage;
    }

    public void setChanceOfCriticalDamage(double chanceOfCriticalDamage) {
        if (chanceOfCriticalDamage <= 1 & chanceOfCriticalDamage > 0) {
            this.chanceOfCriticalDamage = chanceOfCriticalDamage;
        }
    }

    @Override
    public String toString() {
        return String.format("Current hp: %.0f" +
                "\nDamage: %f" +
                "\nDefence: %d" +
                "\nChance of Critical damage: %f" , hp, damage, defence, chanceOfCriticalDamage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        if (hp != person.hp) return false;
        if (defence != person.defence) return false;
        if (Double.compare(person.damage, damage) != 0) return false;
        return Double.compare(person.chanceOfCriticalDamage, chanceOfCriticalDamage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, damage, defence, chanceOfCriticalDamage);
    }

//    public static void main(String[] args) {
//        Person person = new Person(100,23,10, 0.3 );
//        for (int i=0;i<10;i++){
//            Output.println(person.bump());
//        }
//    }
}
