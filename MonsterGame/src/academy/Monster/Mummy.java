package academy.Monster;

public class Mummy extends Monster {

    private static final int CERTAIN_AMOUNT_OF_HEALTH = 10;
    private int consecutivesAttacksCounter;

    public Mummy(int attackDamage, MonsterType type) {
        super(attackDamage, type);
        this.consecutivesAttacksCounter = 0;
    }

    @Override
    public int attack() {
        if (consecutivesAttacksCounter == 2) {
            failUnrolls();
            System.out.printf("%s: I failed and unroll and lost 10 of health I have now %d. %n", getType(), getHealth());
            consecutivesAttacksCounter = 0;
            return 0;
        }
        consecutivesAttacksCounter++;
        return super.attack();
    }

    @Override
    public void loseHealth(int attackDamage) {
        consecutivesAttacksCounter = 0;
        super.loseHealth(attackDamage);

    }

    private void failUnrolls() {
        if (CERTAIN_AMOUNT_OF_HEALTH >= getHealth()) {
            super.die();
            return;
        }
        super.loseHealth(CERTAIN_AMOUNT_OF_HEALTH);


    }
}



