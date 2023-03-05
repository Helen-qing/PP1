/***
 * @author Helen Gao
 * @version 0.1
 * Date of creation: Feb. 8 2023
 * Last date modified: March 1, 2023
 */
public class Date implements Comparable<Date>{
    private int month;
    private int day;
    private int year;
     /***
	 * Default constructor
	 * No parameters
	 * Initializes month, day, and year to respective values 
	 */
    public Date(){
        month = 1;
        day = 1;
        year = 1970;
    }
      /***
	 * constructor that checks if user input right format of the dates
	 * @param	date for the date of the date
	 */
    public Date(String date) throws InvalidDateTimeException{
        //The class Date and Time one-arg constructors should use regular expressions to validate and parse the date and time strings.
        try{
        if(date.matches("\\d{2}/\\d{2}/\\d{4}")){
            String [] items = date.split("/");//split the string using slash : first month, day, year
            month = Integer.parseInt(items[0]);//converts string to num
            day = Integer.parseInt(items[1]);
            year = Integer.parseInt(items[2]);
            if(month < 1 || month > 12){
                throw new InvalidDateTimeException("Invalid month. Month should be from 1 - 12.");
            }
            if(day < 1 || day > 31){
                throw new InvalidDateTimeException("Invalid day. Day should be from 1-31");

            }
            if(year < 1970 || year > 2030){
                throw new InvalidDateTimeException("Invalid year. Year should be from 1970 to 2030.");
            }
        }else{
           throw new InvalidDateTimeException("Invalid date (should be mm/dd/yyyy)"); 
        }
        }
        catch(InvalidDateTimeException e){
            System.out.println(e);
        }

    
    }
      /***
	 * Getter for the contact of event
	 * @param	no parameters
	 * @return	the value of the contact
	 */
    public int getMonth(){
        return month; 
    }
      /***
	 * Getter for the contact of event
	 * @param	no parameters
	 * @return	the value of the contact
	 */
    public int getDay(){
        return day;
    }
      /***
	 * Getter for the contact of event
	 * @param	no parameters
	 * @return	the value of the contact
	 */
    public int getYear(){
        return year;
    }
    /***
	 * setter for the contact of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setMonth(int m) throws InvalidDateTimeException{
        month = m;
    }
    /***
	 * setter for the contact of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setDay(int day) throws InvalidDateTimeException{
        this.day = day;
    }
    /***
	 * setter for the contact of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setYear(int year) throws InvalidDateTimeException{
        this.year = year;
    }

    @Override
    public String toString(){
        return  String.format("%02d/%02d/%04d", month, day, year);
    }

    @Override
    public int compareTo(Date d) {
        if(this.getYear() == d.getYear()){ // the year entered is in events
            if(this.getMonth() == d.getMonth()){ // the month entered is in events
                return this.getDay() - d.getDay(); // compares the date using the day; if day is negative, the day is before the actual day
            }else{
                return this.getMonth() - d.getMonth(); //compares the date using month
            }
        }else{
            return this.getYear() - d.getYear(); // compares the date using year
        }
        
    }
    
}

