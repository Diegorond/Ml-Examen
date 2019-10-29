package com.ml.model;

public enum DayWhetherType {

	DROUGHT {

		public String getDescription() {
			return"Sequia";
		}
	},
	RAIN {

		public String getDescription() {
			return"Lluvia";
		}
	},
	OPTIMAL {

	public String getDescription() {
			return "Clima optimo";
		}
	}
	,UNDEFINED{
		public String getDescription() {
			return "Sin registro, los planetas se encuentran desalineados fuera del sol";
		}

	};

	public abstract String getDescription();

}
