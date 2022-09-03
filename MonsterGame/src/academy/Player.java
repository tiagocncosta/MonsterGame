package academy;

import academy.Monster.Monster;
import academy.Monster.MonsterFactory;

import static academy.Util.randomNumber;

public class Player {
    private String name;
    private Monster[] monsters;

    private int numberOfMonstersAlive;

    public Player(String name) {
        this.name = name;
    }

    public void pickMonsters(int numberOfMonsters) {
        monsters = MonsterFactory.createMonsters(numberOfMonsters);
        numberOfMonstersAlive = monsters.length;
    }

    public int attack() {
        Monster attacker = chooseMonster();
        if (attacker != null) {
            return chooseMonster().attack();
        }
        return 0;
    }

    public void defend(int attackPower) {

        Monster defender = chooseMonster();
        if (defender == null) {
            return;
        }
        defender.loseHealth(attackPower);
        if (!defender.isAlive()) {
            numberOfMonstersAlive--;
        }
        System.out.printf("%s was attacked, he now has %d health points. %n", defender.getType(), defender.getHealth());
    }

    public Monster chooseMonster() {
        Monster randomMonster = monsters[randomNumber(0, monsters.length - 1)];
        if (numberOfMonstersAlive == 0) {
            return null;
        }

        if (!randomMonster.isAlive() && numberOfMonstersAlive > 0) {
            chooseMonster();
        }
        return randomMonster;
    }

    public String getName() {
        return name;
    }

    private void decreaseMonstersAlive() {
        numberOfMonstersAlive--;
    }

    public boolean canPlay() {
        return numberOfMonstersAlive > 0;
    }

    public int getNumberOfMonstersAlive() {
        return numberOfMonstersAlive;
    }

    private Monster[] getMonsters() {
        return monsters;
    }


}
