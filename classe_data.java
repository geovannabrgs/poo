package br.upis;

	public class Horario implements IHorario{
		private int second;
		public Horario(int i, int j, int k) {
			setSecond(0);
		}
		public Horario(int second) {
			setSecond(0);
		}
		public Horario(int second) {
			setSecond(second);
		}
		public Horario(Horario horario) {
			this(horario.getHour(), horario.getMinute(), horario.getSecond());
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
		public void addMoreSecond(int qSecond) {
			for(int i = 0; i < qSecond; i++) {
				addSecond();
			}
		}
		public void addMoreMonth(int qMinute) {
			for(int i = 0; i < (qMinute * 60); i++) {
				addSecond();
			}
		}
		public void addMoreYears(int qHours) {
			for(int i = 0; i < (qHours * 3600); i++) {
				addSecond();
			}
		}
		public boolean isLastHorario() {
			return second == 86399;
		}
		public boolean isFirstHorario() {
			return second == 0;
		}
		public String toString() {
			return getHour() + " : " + getMinute() + " : " + getSecond();
			}
		}
		public class Data {
			private byte day;
			private byte month;
			private short year;
			private boolean isLeap(int year) {
				return(year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0)));
			}
			private byte getLastDay(int month, int year) {
				byte ud[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
				if(month == 2 && isLeap(year)) {
					return 29;
				}
				return ud[month];
			}
			public Data() {
				setYear((byte)1);
				setMonth((byte)1);
				setDay((byte)1);
			}
			public Data(byte day, byte month, short year) {
				this();
				setYear(year);
				setMonth(month);
				setDay(day);
			}
			public Data(int day, int month, int year) {
				this((byte)day, (byte)month, (short)year);
			}
			public byte getDay() {
				return day;
			}
			public void setDay(byte day) {
				int lastDay = getLastDay(month, year);
				if(day >= 1 && day <= lastDay) {
					this.day = day;
				}
			}
			public byte getMonth() {
				return month;
			}
			public void setMonth(byte month) {
				if(month >= 1 && month <= 12) {
					this.month = month;
				}
			}
			public short getYear() {
				return year;
			}
			public void setYear(short year) {
				if(year >= 1 && year <= 9999) {
					this.year = year;
				}
			}
			public void addDay() {
				byte d = (byte)(day + 1);
				if(d > getLastDay(month, year)) {
						day = 1;
						addMonth();
				}else {
					setDay(day);
				}
			}
			public void addMonth() {
				byte m = (byte)(month + 1);
				if(m > 12) {
					month = 1;
					addYear();
				}else {
					setMonth(month);
				}
			}
			public void addYear() {
				short y = (short)(year + 1);
				if(y > 9999) {
					year = 1;
				}else {
					setYear(year);
				}
			}
			public void addMoreDays(int qDays) {
				for(int i = 0; i < qDays; i++) {
					addDay();
				}
			}
			public void addMoreMonth(int qMonth) {
				for(int i = 0; i < qMonth; i++) {
					addMonth();
				}
			}
			public void addMoreYears(int qYears) {
				for(int i = 0; i < qYears; i++) {
					addYear();
				}
			}
			public String toString() {
				return getDay() + "/ " + getMonth() + "/ " + getYear();
			}
		}
		public class Relogio {
			private Horario hms;
			private Data dma;
			public Relogio(Horario hms, Data dma) {
				this.hms = new Horario(hms);
				this.dma = dma;
			}
			public void tictac() {
				hms.addSecond();
				if(hms.isFirstHorario()) {
					dma.addDay();
				}
			}
@Override
	public String toString() {
	return dma + " " + hms;
	}
}
