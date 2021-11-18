
//PABLO GARCIA CELADILLA

package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public int getDay() {
		return this.day;
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear (int year) throws DateException{
		if(year < 0) {
			throw new DateException("Date error: Year " + year + " not valid");
		}
		this.year = year;
	}

//comprueba dia mes correcto
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4: //next
		case 6: //next
		case 9: //next
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
//Mismo dia	
	public boolean isSameDay(int day) {		
		if(this.day == day) {
			return true;
		}
		else {
			return false;
		}
		
	}
//Mismo mes	
	public boolean isSameMonth(int month) {
		if(this.month == month) {
			return true;
		}
		else {
			return false;
		}
	}
//Mismo anio	
	public boolean isSameYear(int year) {
		if(this.year == year) {
			return true;
		}
		else {
			return false;
		}
	}
//Misma fecha
	public boolean isSame(int day, int month, int year) {		
		if((this.day == day) && (this.month == month) && (this.year == year)) {
			return true;
		}else {
			return false;
		}
	}
	
	
//sin if
	public boolean isSameDaySinIF(int day) {
		return (this.day == day);
	}
	
	public boolean isSameMonthSinIf(int month) {
		return (this.month == month);
	}
	
	public boolean isSameYearSinIf(int year) {
		return (this.year == year);
	}
	
	public boolean isSameSinIf(int day, int month, int year) {
		return this.isSameDay(day)  && this.isSameMonth(month)  &&  this.isSameYear(year);
	}
	
	
//estacion
	
	public String seasonMonth(int day, int month) {
		
		String season=null;
		
		switch(this.month) {
		
		case 1: //next
		case 2: //next
		case 3: 
			season="INVIERNO";
			break;
		case 4: //next
		case 5: //next
		case 6: 
			season="PRIMAVERA";
			break;
		case 7: //next
		case 8: //next
		case 9:
			season="VERANO";
			break;
		case 10: //next
		case 11: //next
		case 12:
			season="OTOÑO";
			break;
			
		
		
		}
		return season;
		
	}
//Nombre del mes	
	public String getMonthName(int month) {
		
		String monthName= null;
		
		switch(this.month) {
		
		case 1:
			monthName = "Enero";
			break;
		case 2:
			monthName = "Febrero";
			break;
		case 3:
			monthName = "Marzo";
			break;
		case 4:
			monthName = "Abril";
			break;
		case 5:
			monthName = "Mayo";
			break;
		case 6:
			monthName = "Junio";
			break;
		case 7:
			monthName = "Julio";
			break;
		case 8:
			monthName = "Agosto";
			break;
		case 9:
			monthName = "Septiembre";
			break;
		case 10:
			monthName = "Octubre";
			break;
		case 11:
			monthName = "Noviembre";
			break;
		case 12:
			monthName = "Diciembre";
			break;
		
		}
		return monthName;
		
	}
	



//meses que quedan hasta final de año
	
	public int mesesHastaFinalDeAnio(int month){
		int i,aux=0;
			for(i=month; i<=12; i++){
				aux++;
			}
	return aux;
	}
	
	
//Dias transcurridos desde el primer dia de año
		public int diasTranscurridosAnio(int Date ){
			int diasTotales = 0;

			switch(Date){

				case 1:diasTotales=0;
					break;
				case 2:diasTotales=31;
					break;
				case 3:diasTotales=59;
					break;
				case 4:diasTotales=90;
					break;
				case 5:diasTotales=120;
					break;
				case 6:diasTotales=151;
					break;
				case 7:diasTotales=181;
					break;
				case 8:diasTotales=212;
					break;
				case 9:diasTotales=243;
					break;
				case 10:diasTotales=273;
					break;
				case 11:diasTotales=304;
					break;
				case 12:diasTotales=334;
					break;
			
			
			}
			diasTotales=Date+this.day;
			
			return diasTotales;
		}

		
//INTENTO PARA GENERAR FECHA ALEATORIA IGUAL A FECHA while
		public int intentosAcertarFechaWhile() {
			
			int intentos=0;
			
			boolean caso=false;
			
			int d,m;
			
			while(caso==false){
				
				m=(int)(Math.random()*12)+1;
				
				if(m==4 || m==6 || m==9 || m==11){
					d=(int)(Math.random()*30)+1;

				}
				else if(m==2){
					d=(int)(Math.random()*28)+1;
				}
				else{
					d=(int)(Math.random()*31)+1;
				}
					intentos++;
					
				if(m==this.month && d==this.day){
					caso=true;
				}
				
			}
				
				return intentos;
		}

		
//INTENTO PARA GENERAR FECHA ALEATORIA IGUAL A FECHA do-while
				public int intentosAcertarFechaDoWhile() {
					
					int intentos=0;
					
					boolean caso=false;
					
					int d,m;
					
					
					do {
						m=(int)(Math.random()*12)+1;
						
						if(m==4 || m==6 || m==9 || m==11){
							d=(int)(Math.random()*30)+1;

						}
						else if(m==2){
							d=(int)(Math.random()*28)+1;
						}
						else{
							d=(int)(Math.random()*31)+1;
						}
							intentos++;
							
						if(m==this.month && d==this.day){
							caso=true;
						}
						
					}while(caso==false);
						
						return intentos;
				}


//Dia de la semana
		public String diaSemana(int day, int month){
			
			int a=0,num=0;
			String _dia="";

			for(int i=1;i<=num;i++){
				a++;
			}
			switch(a) {
				
				case 1:  _dia="LUNES";
					break;
				case 2: _dia="MARTES";
					break;
				case 3:  _dia="MIERCOLES";
					break;
				case 4:  _dia="JUEVES";
					break;
				case 5:  _dia="VIERNES";
					break;
				case 6: _dia="SABADO";
					break;
				case 7:  _dia="DOMINGO";
					break;
			}		

		return _dia;
		}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}

