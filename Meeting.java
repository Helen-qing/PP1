/***
 * @author Helen Gao
 * @version 0.1
 * Date of creation: Feb. 8 2023
 * Last date modified: March 1, 2023
 */

 public class Meeting extends Event{
    private String host;
    private int guests;

     /*** 
	 * Default constructor
	 * No parameters
	 * Initializes host, guests, phone and calls Event default using super()
	 */
    public Meeting(){ 
        super();
        host = "none";
        guests = 0;
    }
     /*** 
	 * Constructor with eight parameters
	 * @param	dcpn for the description of an event
	 * @param	l for the location of an event
	 * @param	d for the date of an event
	 * @param	t for the time of an event
     * @param   h for the host of the event
     * @param   g for the guests of the event
	 */
    public Meeting(String dcpn, String l, String d, String t, String h, int g) throws InvalidDateTimeException{
        super(dcpn, l, d, t);
        host = h;
        guests = g;
    }
      /***
	 * Getter for the host of an event
	 * @param	no parameters
	 * @return	the value of the host
	 */
    public String getHost(){
        return host;
    }
      /***
	 * Getter for the guests of an event
	 * @param	no parameters
	 * @return	the value of the guests
	 */
    public int getGuests(){
        return guests;
    }
     /***
	 * setter for the host of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setHost(String h){
        h = host;
    }
     /***
	 * setter for the guests of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setGuests(int g){
        g = guests;
    }
     /*** 
	 * Method to get the Meeting information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    @Override
    public String toString(){
        String out;
        String type = "Meeting";
        out = String.format("%-25s%s%-25s%-25d", 
                            type, super.toString(), host, guests);
        return out;
    }
}
