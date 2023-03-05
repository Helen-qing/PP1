
/***
 * @author Helen Gao
 * @version 0.1
 * Date of creation: Feb. 8 2023
 * Last date modified: March 4, 2023
 */

 public abstract class Event implements Comparable<Event>{
    // data members
    private static String description; // changed to static
    private String location;
    private Date date;
    private Time time;
    /***
	 * Default constructor
	 * No parameters
	 * Initializes description, locaton, date, and time to the string "none"
	 */
    public Event(){ 
        description = "none";
        location = "none";
        date = null;
        time = null;
    
    }
    /***
	 * Constructor with eight parameters
	 * @param	dcpn for the description of an event
	 * @param	l for the location of an event
	 * @param	d for the date of an event
	 * @param	t for the time of an event
	 */
    public Event(String dcpn, String l, String d, String t) throws InvalidDateTimeException{
        description = dcpn;
        location = l;
        this.date = new Date(d);
        this.time = new Time(t);
    }
      /***
	 * Getter for the description of an event
	 * @param	no parameters
	 * @return	the value of the data member description
	 */
    public String getDescription(){
        return description;
    }
      /***
	 * Getter for the location of an event
	 * @param	no parameters
	 * @return	the value of the data member location
	 */
    public String getLocation(){
        return location;
    }
      /***
	 * Getter for the date of an event
	 * @param	no parameters
	 * @return	the value of the data member date
	 */
    public Date getDate(){
        return date;
    }
      /***
	 * Getter for the time of an event
	 * @param	no parameters
	 * @return	the value of the data member time
	 */
    public Time getTime(){
        return time;
    }
     /***
	 * setter for the description of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setDescription(String d){
        d = description;
    }
    /*** 
	 * setter for the location of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setLocation(String l){
        l = location;
    }
     /***
	 * setter for the date of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setDate(String d) throws InvalidDateTimeException{
        date = new Date(d);
    }
     /***
	 * setter for the time of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setTime(String t) throws InvalidDateTimeException{
        time = new Time(t);
    }
     /*** 
	 * Method to get the Event information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    @Override
    public String toString(){
        String out;
        out = String.format("%-25s%-25s%-25s%-18s",
                                description, location, date, time);
        return out;
    }
    /*** 
	 * Method to compare the events; first by date, then time
	 * @param Event parameter
	 * @return an integer that shows if the time inputted by user happened before or after actual event
	 */
    @Override
    public int compareTo(Event e){ // user is e
        //order event by date, then time
        if(this.getDate().compareTo(e.getDate()) == 0){//can  use the object: ex: date.compareto(e.Date)
            return this.getTime().compareTo(e.getTime()); 
        }else{
           return this.getDate().compareTo(e.getDate());
            
        }
       
        
    }
  
}
