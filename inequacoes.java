package br.upis;

	public class Horario implements IHorario{
		private int second;
		public Horario(IHorario hms) {
			this(hms.getSecond(), hms.getHour(), hms.getMinute());
		}
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
@Override
public int getHour() {
	return ((second / 3600) % 24);
}
@Override
public void setHour(int hour) {
	if(hour >= 0 && hour <=23) {
		this.second = ((hour / 3600) % 24);
	}
}
@Override
public int getMinute() {
	return ((second / 60) % 60);
}
@Override
public void setMinute(int minute) { 
	if(minute >= 0 && minute <= 59) {
		second = (minute / 60);
	}
}
@Override
public int getSecond() {
	return second % 60;
}
@Override
public void setSecond(int second) {
	if(second >= 0 && second <= 59) {
		this.second = second;
	}
}
@Override
public void addSecond() {
	if(second < 86400) {
		second = second + 1;
	}else {
		addMinute(second / 60);
	}
}
@Override
public void addMinute(int second) {
	if(second < 1440) {
		second = second + 60;
	}else {
		addHour(second / 3600);
	}
}
@Override
public void addHour(int second) {
	if(second < 24) {
		second = second + 3600;
	}
}
@Override
public void addMoreSecond(int qSecond) {
	for(int i = 0; i < qSecond; i++) {
		addSecond();
	}
}
@Override
public void addMoreMinute(int qMinute) {
	for(int i = 0; i < (qMinute * 60); i++) {
		addSecond();
	}
}
@Override
public void addMoreHours(int qHours) {
	for(int i = 0; i < (qHours * 3600); i++) {
		addSecond();
	}
}
@Override
	public boolean isLastHorario() {
		return second == 86399;
}
@Override
public boolean isFirstHorario() {
	return second == 0;
}
@Override
public String toString() {
	return getHour() + " : " + getMinute() + " : " + getSecond();
}
private boolean equalsHour(IHorario hr) {
	return this.getHour() == hr.getHour();
}
private boolean equalsMinuto(IHorario hr) {
	return this.getMinute() == hr.getMinute();
}
private boolean equalsSegundo(IHorario hr) {
	return this.getSecond() == hr.getSecond();
}
public boolean equals(Object obj) {
	if(this == obj) {
		return true;
}
if(obj == null || obj.getClass()!=this.getClass()) {
	return false;
}
Horario h = (Horario) obj;
	return equalsHour(h) && equalsMinuto(h) && equalsSegundo(h);
}
public boolean less(IHorario hr) {
	if(this.getHour() < hr.getHour()) {
		return true;
}
if(equalsHour(hr) && this.getMinute() < hr.getMinute()) {
	return true;
}
if(equalsHour(hr) && equalsMinuto(hr) && this.getSecond() < hr.getSecond()) {
		return true;
		}
	return false;
}
public boolean greater(IHorario hr) {
	if(less(hr) == false) {
		return true;
}
	return false;
}
public boolean lessEquals(IHorario hr, Object obj) {
	if(less(hr) == true || equals(obj) == true) {
		return true;
}
	return false;
}
public boolean greaterEquals(IHorario hr, Object obj) {
	if(greater(hr) == true || equals(obj) == true) {
		return true;
	}
	return false;
	}
}
	public interface IHorario {
		int getSecond();
		void setSecond(int second);
		int getMinute();
		void setMinute(int second);
		int getHour();
		void setHour(int second);
		void addSecond();
		void addMinute(int second);
		void addHour(int second);
		void addMoreSecond(int qSecond);
		void addMoreMinute(int qMinute);
		void addMoreHours(int qHours);
		boolean isLastHorario();
		boolean isFirstHorario();
		String toString();
		boolean equals(Object obj);
		boolean less(IHorario hr);
		boolean greater(IHorario hr);
		boolean lessEquals(IHorario hr, Object obj);
		boolean greaterEquals(IHorario hr, Object obj);
	}
	public class HorarioNG implements IHorario {
@Override
public int getSecond() {
	return 0;
}
@Override
public void setSecond(int second) {
}
@Override
public int getMinute() {
	return 0;
}
@Override
public void setMinute(int second) {
}
@Override
public int getHour() {
	return 0;
}
@Override
public void setHour(int second) {
}
@Override
public void addSecond() {
}
@Override
public void addMinute(int second) {
}
@Override
public void addHour(int second) {
}
@Override
public void addMoreSecond(int qSecond) {
}
@Override
public void addMoreMinute(int qMinute) {
}
@Override
public void addMoreHours(int qHours) {
}
@Override
public boolean isLastHorario() {
	return false;
}
@Override
public boolean isFirstHorario() {
	return false;
}
@Override
public boolean equals(Object obj) {
	return false;
}
@Override
public boolean less(IHorario hr) {
	return false;
}
@Override
public boolean greater(IHorario hr) {
	return false;
}
@Override
public boolean lessEquals(IHorario hr, Object obj) {
	return false;
}
@Override
public boolean greaterEquals(IHorario hr, Object obj) {
	return false;
	}
}
	public class Data {
		private int day;
		private boolean isLeap(int day) {
			return(day % 146100 == 0 || ((day % 36525 == 0) && (day % 1461 != 0)));
		}
		private byte getLastDay(int day) {
			byte ud[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			int m = searchMonth(day);
			if(m == 2 && isLeap(day)) {
				return 29;
			}
			return ud[m];
		}
		public byte searchDay(int day) {
			byte ud[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			for(int m = 0;day > ud[m]; m++) {
				day = day - ud[m];
			}
			return (byte)day;
		}
		public byte searchMonth(int day) {
			byte ud[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			int m;
			for(m = 0 ;day > ud[m]; m++) {
				day = day - ud[m];
			}
			return (byte)m;
		}
		public Data() {
			setDay((byte)1);
		}
		public Data(byte day, byte month, short year) {
			this();
			setDay(day);
		}
		public Data(int day, int month, int year) {
			this((byte)day, (byte)month, (short)year);
		}
		public int getDay() {
			return searchDay(day);
		}
		public void setDay(int day) {
			int lastDay = getLastDay(day);
			if(day >= 1 && day <= lastDay) {
				this.day = day;
			}
		}
		public int getMonth() {
			return searchMonth(day % 12);
		}
		public void setMonth(int day) {
			int month = searchMonth(day);
			if(month >= 1 && month <= 12) {
				day = month;
			}
		}
		public int getYear() {
			return day % 365;
		}
		public void setYear(int day) {
			int year = 0;
			if(searchMonth(day) > 12) {
				year++;
			}
			if(year >= 1 && year <= 9999) {
				day = year;
			}
		}
		public void addDay() {
			int d = (day + 1);
			if(d > getLastDay(day)) {
				day = 1;
				addMonth();
			}else {
				setDay(day);
			}
		}
		public void addMonth() {
			int month = searchMonth(day);
			if(month > 12) {
				month = 1;
				addYear();
			}else {
				setMonth(month);
			}
		}
		public void addYear() {
			int year = 1;
			if(searchMonth(day) > 12) {
				year++;
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
		private boolean equalsYear(Data dt) {
			return this.getYear() == dt.getYear();
		}
		private boolean equalsMonth(Data dt) {
			return this.getMonth() == dt.getMonth();
		}
		private boolean equalsDay(Data dt) {
			return this.getDay() == dt.getDay();
		}
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj == null || obj.getClass() != this.getClass()) {
				return false;
			}
			Data d = (Data) obj;
			return equalsYear(d) && equalsMonth(d) && equalsDay(d);
		}
		public boolean less(Data dt) {
			if(this.getYear() < dt.getYear()) {
				return true;
			}
			if(equalsYear(dt) && this.getMonth() < dt.getMonth()) {
				return true;
			}
			if(equalsYear(dt) && equalsMonth(dt) && this.getDay() < dt.getDay()) {
				return true;
			}
			return false;
		}
		public boolean greater(Data dt) {
			if(less(dt) == false) {
				return true;
			}
			return false;
		}
		public boolean lessEquals(Data dt, Object obj) {
			if(less(dt) == true || equals(obj) == true) {
				return true;
			}
			return false;
		}
		public boolean greaterEquals(Data dt, Object obj) {
			if(greater(dt) == true || equals(obj) == true) {
				return true;
			}
			return false;
		}
}
	public interface IData {
		boolean isLeap(int day);
		byte getLastDay(int day);
		int searchDay(int day);
		int searchMonth(int day);
		byte getDay();
		void setDay(int day);
		byte getMonth();
		void setMonth(int month);
		byte getYear();
		void setYear(int year);
		void addDay();
		void addMonth();
		void addYear();
		void addMoreDay(int qDays);
		void addMoreMonth(int qMonth);
		void addMoreYears(int qYears);
		String toString();
		boolean equals(Object obj);
		boolean less(Data dt);
		boolean greater(Data dt);
		boolean lessEquals(Data dt, Object obj);
		boolean greaterEquals(Data dt, Object obj);
	}
	public class DataNG implements IData {
@Override
public boolean isLeap(int year) {
	return false;
}
@Override
public byte getLastDay(int day) {
	return 0;
}
@Override
public int searchDay(int day) {
	return 0;
}
@Override
public int searchMonth(int day) {
	return 0;
}
@Override
public byte getDay() {
	return 0;
}
@Override
public void setDay(int day) {
}
@Override
public byte getMonth() {
	return 0;
}
@Override
public void setMonth(int month) {
}
@Override
public byte getYear() {
	return 0;
}
@Override
public void setYear(int year) {
}
@Override
public void addDay() {
}
@Override
public void addMonth() {
}
@Override
public void addYear() {
}
@Override
public void addMoreDay(int qDays) {
}
@Override
public void addMoreMonth(int qMonth) {
}
@Override
public void addMoreYears(int qYears) {
}
@Override
public boolean equals(Object obj) {
	return false;
}
@Override
public boolean less(Data dt) {
	return false;
}
@Override
public boolean greater(Data dt) {
	return false;
}
@Override
public boolean lessEquals(Data dt, Object obj) {
	return false;
}
@Override
public boolean greaterEquals(Data dt, Object obj) {
	return false;
	}
}
	public class Relogio {
		private IHorario hms;
		private Data dma;
		public Relogio(IHorario hms, Data dma) {
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
public boolean equals(Object obj) {
	if(this == obj) {
		return true;
}
if(obj == null || obj.getClass() != this.getClass()) {
	return false;
}
	Relogio r = (Relogio) obj;
		return dma.equals(r) && hms.equals(r);
}
public boolean less(Relogio re) {
	if(re.dma.less(dma) && re.hms.less(hms)) {
		return true;
}
	return false;
}
public boolean greater(Relogio re) {
	if(re.dma.greater(dma) && re.hms.greater(hms)) {
		return true;
	}
	return false;
}
public boolean lessEquals(Relogio re, Object obj) {
	if(less(re) == true || equals(obj) == true) {
		return true;
	}
	return false;
}
public boolean greaterEquals(Relogio re, Object obj) {
	if(greater(re) == true || equals(obj) == true) {
		return true;
	}
	return false;
	}
}
