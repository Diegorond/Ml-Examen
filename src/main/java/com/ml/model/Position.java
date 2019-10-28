package com.ml.model;

public class Position {
	
	private int coordinateX;
	private int coordinateY;
	private Integer distanceToSun;
	private int currentAngleToSun;
	
	
	public Position(Integer distanceToSun, int x, int y){
		this.distanceToSun=distanceToSun;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public int getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	public int getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(int coordinateY) {
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
