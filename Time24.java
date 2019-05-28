package java_Abgabeuebungen;
import utilities.TastaturEingabe;
public class Time24  {
	private int hour, minute;
	
	//allgemeiner Konstruktor
	public Time24(int hour, int minute) {
		this.hour			= hour;
		this.minute			= minute;
	}
	//Standardkonstruktor
	 public Time24 (){
		 this(0,0);
	 }
	 //Kopierkonstruktor
	 public Time24 (Time24 obj) {
		 obj 					= new Time24(hour, minute);
	 }
	 
	 public void readTime() {
		 if ( hour >= 0 && hour <= 23 && minute >=0 && minute <=59) {
		 hour					= TastaturEingabe.readInt("Bitte geben Sie die aktuelle Stunde ein: ");
		 minute					= TastaturEingabe.readInt("Bitte geben Sie di aktuelle Minute ein: ");
		 } 
		 else {
			 hour				= 0;
			 minute				= 0;
		 }
			 
	 }
	 
	 public void writeTime() {
		 nomarlizeTime();
		 System.out.println(hour + ":"  +minute);
	 }
	 
	 public void addTime(int plus) {
		 if (plus >=0) {
		 this.minute			+= plus;
		 }
		 else
			 plus				= 0;
	 }
	 int getHour() {
		 return hour;
	 }
	 void setHour(int hour) {
		 this.hour				= hour;
	 }
	 int getMinute() {
		 return minute;
	 }
	 void setMinute(int minute) {
		 this.minute			= minute;
	 }
	 public String toString() {
		 return hour + ":" + minute;
	 }
	 private void nomarlizeTime() {
		 if (this.minute > 59) {
			 hour 				= hour + minute/60;
			 minute				= minute%60;
		 }
		 if (hour > 23) {
			 hour 				= hour%24;
		 }
		 
		
	 }
	 public static void main(String[] args) {
		Time24		uhrzeitsf	= new Sanfrancisco(12,43);
		uhrzeitsf.readTime();
		uhrzeitsf.writeTime();
	
		Time24		uhrzeitff		=  new Frankfurt(uhrzeitsf.hour, uhrzeitsf.minute);
		uhrzeitff.writeTime();
		
		Time24		uhrzeitmb		= new Melbourne(uhrzeitsf.hour, uhrzeitsf.minute );
		uhrzeitmb.writeTime();
		
		
	}
}
class Sanfrancisco extends Time24{
	int shour,sminute;
	Sanfrancisco(int shour, int sminute){
		super (shour , sminute);	
	}
	Sanfrancisco(){
		this(0,0);
	}
	 public void readTime() {
		 if ( shour >= 0 && shour <= 23 && sminute >=0 && sminute <=59) {
		 shour				= TastaturEingabe.readInt("Bitte geben Sie die aktuelle Stunde in San Francisco ein: ");
		 sminute			= TastaturEingabe.readInt("Bitte geben Sie di aktuelle Minute in San Francisco ein: ");
		 }
		 else {
			 shour			= 0;
			 sminute		= 0;
		 }
		 super.setHour(shour);
		 super.setMinute(sminute);
		
	 }
	   
	public void writeTime() {
		System.out.print("Uhrzeit in San Francisco: " );
		super.writeTime();
	}
	
}

class  Frankfurt extends Time24 {
	Frankfurt(){
		
	}
	Frankfurt(int fhour, int fminute){
	super (fhour + 9 , fminute);
	}
	
	public void writeTime() {
		System.out.print("Uhrzeit in Frankfurt: " );
		super.writeTime();
	}
	
	
}
class Melbourne extends Time24{
	Melbourne(){
		
	}
	Melbourne(int mhour, int mminute){
		super(mhour +  17, mminute);
			
	}
	
	public void writeTime() {
		System.out.print("Uhrzeit in Melbourne: " );
		super.writeTime();
	}
}
