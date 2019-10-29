package com.ml.model;

public class Position {
	
	private double coordinateX;
	private double coordinateY;
	private Integer distanceToSun;
	private int currentAngleToSun;
	
	
	public Position(Integer distanceToSun, int x, int y){
		this.distanceToSun=distanceToSun;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public double getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}
	public double getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}
	public int getDistanceToSun() {
		return distanceToSun;
	}
	public void setDistanceToSun(int distanceToSun) {
		this.distanceToSun = distanceToSun;
	}

	public int getCurrentAngleToSun() {
		return currentAngleToSun;
	}

	public void setCurrentAngleToSun(int currentAngleToSun) {
		this.currentAngleToSun = currentAngleToSun;
	}

}
