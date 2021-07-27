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
				this.hour = hour;
			}
			public Byte getMinute() {
				return minute;
			}
			public void setMinute(Byte minute) {
				this.minute = minute;
			}
			public Byte getSecond() {
				return second;
			}
			public void setSecond(Byte second) {
				this.second = second;
			}
	}	