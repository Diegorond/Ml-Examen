package com.ml.model;

public enum DayWhetherType {

	DROUGHT {

		public String getDescription() {
			return "Sequia";
		}
	},
	RAIN {

		public String getDescription() {
			return "Lluvia";
		}
	},
	MAX_RAIN {

		public String getDescription() {
			return "Lluvia maxima";
		}
	},
	OPTIMAL {

		public String getDescription() {
			return "Clima optimo";
		}

	};

	public abstract String getDescription();

}
