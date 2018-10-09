package lab5.model;

/**
 * PACKAGE NAME: lab5.model
 * CREATED BY: *JAVAнутые*
 * PROJECT NAME: NaGugl
 * VERSION: 1.0.0
 */
public class Hero extends Person {
    public void healing(double potion) {
        setHp(getHp() + potion);
    }

    @Override
    public double bump() {
        return super.bump() ;
    }

    @Override
    public String toString() {
        return "(-_-)\n" + super.toString();
    }
}
