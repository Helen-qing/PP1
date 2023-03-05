/***
 * @author Helen Gao
 * @version 0.1
 * Date of creation: Feb. 8 2023 
 * Last date modified: March 1 2023
 */

 public class Appointment extends Event{
    private String contact;
    /***
	 * Default constructor
	 * No parameters
	 * Initializes contact and calls data members using super() from Event class
	 */
    public Appointment(){
        super();
        contact = "none"; 
    }
     /***
	 * Constructor with eight parameters
	 * @param	dcpn for the description of an event
	 * @param	l for the location of an event
	 * @param	d for the date of an event
	 * @param	t for the time of an event
     * @param   c for contact of the event
	 */
    public Appointment(String dcpn, String l, String d, String t, String c) throws InvalidDateTimeException{
        super(dcpn, l, d, t);
        contact = c;
    }
      /***
	 * Getter for the contact of event
	 * @param	no parameters
	 * @return	the value of the contact
	 */
    public String getContact(){
        return contact;
    }
     /***
	 * setter for the contact of an event
	 * @param	int parameter
	 * @return	no return value
	 */
    public void setContact(String contact){
        this.contact = contact;
    }
     /*** 
	 * Method to get the Appointment information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    @Override
    public String toString(){
        String out;
        String type = "Appointment";
        out = String.format("%-25s%s%-25s", type, 
                            super.toString(), contact);
        return out;
    }
}
