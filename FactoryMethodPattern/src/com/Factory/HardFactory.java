package com.Factory;

public class HardFactory extends AbstractFactory{

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new HardWeapon();
	}

	@Override
	public PowerUp createPowerUp() {
		// TODO Auto-generated method stub
		return new HardPowerUp();
	}

}
