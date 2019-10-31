package com.ml.model;

public  class Planet {

	private String name;
	private Position position;
	private  RotationalSpeed rotationalSpeed;
	
	public Planet(String name, Integer distanceToSun, int angularSpeedPeerDay, boolean counterclockwise) {
		this.setName(name);
		//Todos los planetas comienzan alineados en 0 grados
		Position position = new Position(distanceToSun, distanceToSun.intValue() , 0);
		this.position = position;
		RotationalSpeed rotationalSpeed = new RotationalSpeed();
		rotationalSpeed.setAngularSpeedPeerDay(angularSpeedPeerDay);
		rotationalSpeed.setCounterclockwise(counterclockwise);
		this.rotationalSpeed = rotationalSpeed;
	}

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

	public void moveOneDay() {
		/*La posicion para las coordenada X,Y en un dia de avance sera
		 * X = X' + W.cos(O)
		 * Y = Y'+W.sen(O)
		 * donde X',Y' son las posiciones iniciales, W la velocidad angular y O el angulo actual respecto al sol
		 * expresado en radianes
		 * */
		
		// Si llega a los 360 vuelve a 0 grados porque dio la vuelta completa
	    if(this.position.getCurrentAngleToSun()>=360) {
	    	this.position.setCurrentAngleToSun(0);
	    }
	    int nextDegree = -1;
	    //Si el planeta gira sentido horario 
	    if (this.getRotationalSpeed().isCounterclockwise()) {
	    	nextDegree = 1;
	    }
	    
	    //Actualizo el angulo del planeta respecto al sol
		this.position.setCurrentAngleToSun(this.position.getCurrentAngleToSun()+nextDegree);
		double nexX = this.position.getCoordinateX() + this.rotationalSpeed.getAngularSpeedPeerDay()*Math.cos(Math.toRadians(this.position.getCurrentAngleToSun()));
		double nexY = this.position.getCoordinateY() + this.rotationalSpeed.getAngularSpeedPeerDay()*Math.sin(Math.toRadians(this.position.getCurrentAngleToSun()));
		this.position.setCoordinateX(nexX);
		this.position.setCoordinateY(nexY);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
