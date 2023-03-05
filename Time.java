/***
 * @author Helen Gao
 * @version 0.1
 * Date of creation: Feb. 8 2023
 * Last date modified: March 1, 2023
 */
public class Time implements Comparable<Time>{
    private int hours;
    private int minutes;

    public Time(){
        hours = 0;
        minutes = 0;
    }

    public Time(String time) throws InvalidDateTimeException{//question: on parameter not the same as uml
            if(time.matches("\\d{2}:\\d{2}")){
            String [] items = time.split(":");//split the string using slash : first month, day, year
            hours = Integer.parseInt(items[0]);//converts string to num
            minutes = Integer.parseInt(items[1]);
            if(hours < 0 || hours > 23){
                throw new InvalidDateTimeException("Invalid hours");
            }
            if(minutes < 0 || minutes > 59){
                throw new InvalidDateTimeException("Invalid minutes");

            }
        }else{
           throw new InvalidDateTimeException("Invalid time format"); 
        }
    }

    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes;
    }

    public void setHours(int h) throws InvalidDateTimeException{
        hours = h;
    }
    
    public void setMinutes(int m) throws InvalidDateTimeException{
        minutes = m;
    }

    @Override 
    public String toString(){
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
    public int compareTo(Time t) {
        if(this.getHours() == t.getHours()){
            return this.getMinutes() - t.getMinutes();
        }
        else{
            return this.getHours() - t.getHours();
        }
    }
}


