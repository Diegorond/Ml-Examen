package com.ml.model;

public  class Planet {

	private String name;
	private Position position;
	private  RotationalSpeed rotationalSpeed;
	
	public Planet(String name, Integer distanceToSun, int angularSpeedPeerDay, boolean counterclockwise) {
		this.name=name;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void moveOneDay() {
		/*La posicion para las coordenada X,Y en un dia de avance sera
		 * X = r.cos(O)
		 * Y = r.sen(O)
		 * donde "r" es el radio y "O" el angulo actual respecto al sol
		 * expresado en radianes
		 * */
		// Si llega a los 360 vuelve a 0 grados porque dio la vuelta completa
		if(this.getRotationalSpeed().isCounterclockwise()) {
			if(this.position.getCurrentAngleToSun()<=0) {
		    	this.position.setCurrentAngleToSun(360);
		    }
			this.position.setCurrentAngleToSun(this.position.getCurrentAngleToSun()-this.rotationalSpeed.getAngularSpeedPeerDay());

		}else {
			if(this.position.getCurrentAngleToSun()>=360) {
		    	this.position.setCurrentAngleToSun(0);
		    }
			this.position.setCurrentAngleToSun(this.position.getCurrentAngleToSun()+this.rotationalSpeed.getAngularSpeedPeerDay());
		}
		


	    
	    //Actualizo el angulo del planeta respecto al sol
//		this.position.setCurrentAngleToSun(this.position.getCurrentAngleToSun()+this.rotationalSpeed.getAngularSpeedPeerDay());
		double nexX = this.position.getDistanceToSun()*Math.cos(Math.toRadians(roundCosDegrees(this.position.getCurrentAngleToSun())));
		double nexY = this.position.getDistanceToSun()*Math.sin(Math.toRadians(roundSinDegrees(this.position.getCurrentAngleToSun())));
		this.position.setCoordinateX(nexX);
		this.position.setCoordinateY(nexY);
	}

	//Con estos angulos (angulos notables) no devuelve el valor correspondiente por lo que los ejes no se coinciden y por lo tanto los planetas nunca se alinean
	private int roundCosDegrees(int degrees){
		if(degrees == 270 || degrees == 90) {
			return 0;
		}else if(degrees == 360 || degrees == 0){
			return 1;
		}else if(degrees == 180) {
			return -1;
		}
		return degrees;
	}
	
	private int roundSinDegrees(int degrees) {
		if(degrees == 180 || degrees == 360 || degrees == 0) {
			return 0;
		}else if(degrees == 90){
			return 1;
		}else if(degrees == 270) {
			return -1;
		}
		return degrees;
	}
	
}
