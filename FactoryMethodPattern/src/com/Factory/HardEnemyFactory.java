package com.Factory;

public class HardEnemyFactory extends EnemyFactory{

	@Override
	public Enemy createEnemy() {
		// TODO Auto-generated method stub
		return new HardEnemy();
	}

}
