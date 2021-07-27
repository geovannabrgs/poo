package br.upis;

	public class Horario {
		private int second;
		public Horario(int second) {
			setSecond(0);	
		}
		public Horario(int second) {
			setSecond(second);
		}
		public int getHour() {
			return ((second / 3600) % 24);
		}
		public void setHour(int hour) {
			if(hour >= 0 && hour <=23) {
				this.second = ((hour / 3600) % 24);
			}
		}
		public int getMinute() {
			return ((second / 60) % 60);
		}
		public void setMinute(int minute) {
			if(minute >= 0 && minute <= 59) {
				second = (minute / 60);
			}
		}
		public int getSecond() {
			return second % 60;
		}
		public void setSecond(int second) {
			if(second >= 0 && second <= 59) {
				this.second = second;
			}
		}
		public void addSecond() {
			if(second < 86400) {
				second = second + 1;
			}else {
				addMinute(second / 60);
			}
		}
		public void addMinute(int second) {
			if(second < 1440) {
				second = second + 60;
			}else {
				addHour(second / 3600);
			}
		}
		public void addHour(int second) {
			if(second < 24) {
				second = second + 3600;
			}
		}
		public String toString() {
			return getHour() + " : " + getMinute() + " : " + getSecond();
		}
	}
			