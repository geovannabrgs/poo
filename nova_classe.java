package br.upis;

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
		public String toString() {
			return getDay() + "/ " + getMonth() + "/ " + getYear();
		}
}
			
