package academy.Monster;

public class Vampire extends Monster {

    public Vampire(int attackDamage, MonsterType type) {
        super(attackDamage, type);
    }

    @Override
    public int attack() {
        int random = (int) ((Math.random() * 6) + 1);

        if (random == 3) {
            super.increaseHealth(10);
            System.out.printf("Take a bite motherfucker! My health is now: %d.%n", getHealth());
        }
        return super.attack();
    }

}
