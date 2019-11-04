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
		
		// Si llega a los 360 vuelve a 0 grados porque dio la vuelta completa
//	    if(this.position.getCurrentAngleToSun()>=360) {
//	    	this.position.setCurrentAngleToSun(0);
//	    }
//
//	    //Actualizo el angulo del planeta respecto al sol
//	    //Si el planeta gira sentido antihorario 
//	    if (this.getRotationalSpeed().isCounterclockwise()) {
//	    	int currentDegreeCounterClock = (360 - this.position.getCurrentAngleToSun());
//			this.position.setCurrentAngleToSun(currentDegreeCounterClock-this.rotationalSpeed.getAngularSpeedPeerDay());
//	    }else {
//			this.position.setCurrentAngleToSun(this.position.getCurrentAngleToSun()+this.rotationalSpeed.getAngularSpeedPeerDay());
//
//	    }
	    
	    //Actualizo el angulo del planeta respecto al sol
//		this.position.setCurrentAngleToSun(this.position.getCurrentAngleToSun()+this.rotationalSpeed.getAngularSpeedPeerDay());
		double nexX = this.rotationalSpeed.getAngularSpeedPeerDay()*getCos(this.position.getCurrentAngleToSun());
		double nexY = this.rotationalSpeed.getAngularSpeedPeerDay()*getSin(this.position.getCurrentAngleToSun());
		this.position.setCoordinateX(nexX);
		this.position.setCoordinateY(nexY);
	}

	private int getSin(int currentAngleToSun) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getCos(int currentAngleToSun) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
