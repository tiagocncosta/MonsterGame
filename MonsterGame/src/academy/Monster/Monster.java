package academy.Monster;

public abstract class Monster {


    private int health;
    private int attackDamage;
    private MonsterType type;
    private boolean isAlive;

    protected Monster(int attackDamage, MonsterType type) {
        this.health = 100;
        this.attackDamage = attackDamage;
        this.type = type;
        this.isAlive = true;
    }

    public int attack() {
        return attackDamage;
   /*     if (!victim.isAlive) {


            System.out.println("I'm already dead!");

            return;
        }

        victim.loseHealth(attackDamage);


        System.out.printf("%s attacked %s, the %s has now %d health points.%n", type, victim.type, victim.type, victim.getHealth());*/
    }

    public void loseHealth(int attackDamage) {

        if (attackDamage >= health) {
            health = 0;
            die();
            return;
        }
        health -= attackDamage;

    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public MonsterType getType() {
        return type;
    }

    protected void die() {
        isAlive = false;
        System.out.println("I can't resist no more... you have to go without me.. *dying* ");
    }

    protected void increaseHealth(int amount) {
        if (amount > 0) {
            health += amount;
        }
        health = Math.min(health, 100);
    }
}