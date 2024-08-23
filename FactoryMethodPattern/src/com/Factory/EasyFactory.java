package com.Factory;

public class EasyFactory extends AbstractFactory{

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new EasyWeapon();
	}

	@Override
	public PowerUp createPowerUp() {
		// TODO Auto-generated method stub
		return new EasyPowerUp();
	}

}
