package com.ml.model;

public abstract class Planet {

	protected String name;
	public Position position;
	public RotationalSpeed rotationalSpeed;
	
	public abstract String getName();

	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public RotationalSpeed getRotationalSpeed() {
		return rotationalSpeed;
	}
	public void setRotationalSpeed(RotationalSpeed rotationalSpeed) {
		this.rotationalSpeed = rotationalSpeed;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
