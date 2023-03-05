/***
 * @author Helen Gao
 * @version 0.1
 * Date of creation: Feb. 8 2023
 * Last date modified: March 1, 2023
 */

public class InvalidDateTimeException extends Exception{
    public InvalidDateTimeException(){
        super("Invalid Date and/or Time");
    }
    public InvalidDateTimeException(String e){
        super(e);
    }
}
 