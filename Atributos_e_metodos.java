package br.upis;

	public class Horario {
		private byte hora;
		private byte minuto;
		private byte segundo;
		
		public Horario () {}
		public Horario(byte hora, byte minuto, byte segundo) {
			setHora(hora);
			setMinuto(minuto);
			setSegundo(segundo);
		}
		public Byte getHour() {
			return hour;
			}
			public void setHour(Byte hour) {
			if(hour >= 0 && hour <=23) {
				this.hour = hour;
			}
			}
			public Byte getMinute() {
				return minute;
			}
			public void setMinute(Byte minute) {
				if(minute >= 0 && minute <= 59) {
					this.minute = minute;
				}
			}
			public Byte getSecond() {
				return second;
			}
			public void setSecond(Byte second) {
				if(second >= 0 && second <= 59) {
					this.second = second; 
				}
			}
			public void addSecond() {
				Byte s = (byte) (second + 1);
				if(s == 60) {
					second = 0;
						addMinute();
					}else {
						second = s;
				}
			}
			public void addMinute() {
				Byte m = (byte) (minute + 1);
				if(m == 60) {
					minute = 0;
					addHour();
					}else {
						minute = m;
				}
			}
			public void addHour() {
				Byte h = (byte) (hour + 1);
				if(h == 24) {
					hour = 0;
				}else {
					hour = h;
				}
			}
