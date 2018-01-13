
public class Clock {

	private int totalSeconds;
	private static int numClocks = 0;
	public final int ID;

public static boolean use24HourFormat = false;


public Clock(int hours, int minutes, int seconds) {
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
		numClocks++;
		ID = numClocks;
		}

public Clock(int hours, int minutes) {
	this(hours, minutes, 0);
	}

public Clock(int hours) {
	this(hours, 0);
	}	

public Clock() {
	this(0);
	}

public int getHours() {
	return totalSeconds/3600;
	}

public int getMinutes() {
	return (totalSeconds/60) % 60;
	}

public int getSeconds() {
	return totalSeconds % 60;	
	}

public void setHours(int hours) {
	if (hours > 23)
		hours = 23; ;
	if (hours < 0)
		hours = 0;
	totalSeconds = hours*3600 + getMinutes()*60 + getSeconds();
	}

void setMinutes(int minutes) {
	if (minutes> 59)	
		minutes = 59;
	if (minutes < 0)
		minutes = 0;
	totalSeconds = getHours()*3600 + minutes*60 + getSeconds() ;
	}
void setSeconds(int seconds) {	
	if (seconds > 59)
		seconds = 59;
	if (seconds < 0)
		seconds = 0;
	totalSeconds = getHours()*3600 + getMinutes()*60 + seconds;
	}

void incrementHours() {
	if (getHours() == 23)
		setHours(0);
	else setHours(getHours()+1);
	}

void incrementMinutes() {
	if (getMinutes() == 59) {
		setMinutes(0);
		incrementHours();
		}
	else setMinutes(getMinutes()+1);
}

public void incrementSeconds() {
	if (getSeconds() == 59) {
		setSeconds(0);
		incrementMinutes();
	}
	else setSeconds(getSeconds()+1);
}

public String toString() {
	boolean am = false;
	
	String minuteString = "" + getMinutes();
	if (getMinutes() < 10)
		minuteString = "0" + minuteString;
	String secondString = "" + getSeconds();
	if (getSeconds() < 10)
		secondString = "0" + secondString;
	String hoursString = null;

	if (use24HourFormat) {
		if (getHours() <= 11) {
			hoursString = "" + getHours();
			am = true;
		}
		else if (getHours() == 12) {
			hoursString = "" + getHours();
		}
	else {
		setHours(getHours()- 12);
		hoursString = "" + getHours();
		}

		return getHours() + ":" +
				minuteString + ":"
				+ secondString +
				(am ? " AM" : " PM");	
		}
  
	return getHours() + ":" + minuteString + ":"+ secondString;
}

  

public void setToCurrentTime() {
	totalSeconds = (int)System.currentTimeMillis()/(1000 % (24*3600) );
	}
}
