package com.Factory;

public class Game {
	public static void main(String[] args) {
        GameState state = GameState.getInstance();
        state.nextLevel();
        
        AbstractFactory factory;
        EnemyFactory enemyFactory;
        
        if (state.getDifficulty().equals("Easy")) {
            factory = new EasyFactory();
            enemyFactory = new EasyEnemyFactory();
        } else {
            factory = new HardFactory();
            enemyFactory = new HardEnemyFactory();
        }

        Enemy enemy = enemyFactory.createEnemy();
        Weapon weapon = factory.createWeapon();
        PowerUp powerUp = factory.createPowerUp();

        enemy.attack();
        weapon.use();
        powerUp.apply();
    }
}
