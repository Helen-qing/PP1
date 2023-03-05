/***
 * @author Helen Gao
 * @version 0.1
 * Date of creation: Feb. 8 2023
 * Last date modified: March 1 2023
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class CalendarManager {
    public static void main(String[] args) {
        Calendar calendar = new Calendar("events.txt");
        Event[] events = new Event[6];
        Scanner scnr = new Scanner(System.in);
        boolean menuNum = true;
        while(menuNum){
            System.out.println("Select an operation: ");
            System.out.println("1: view all events");
            System.out.println("2: search events by description");
            System.out.println("3: search events by date");
            System.out.println("4: add a new event");
            System.out.println("5: remove an existing event");
            System.out.println("6: sort events by date and time ");
            System.out.println("7: Exit");

            int num = scnr.nextInt();
            if(num == 1){
                calendar.viewEvents();
            }else if (num == 2){
            
                 
                System.out.println("Enter a description: ");
                String description = scnr.nextLine();
                calendar.findEvent(description);
                for(int i = 0; i < events.length; i++){
                    if(description.equals(events[i].getDescription())){ // changed getDescription to static
                        System.out.println("Event found: " + calendar.findEvent(description));
                    }else{
                        System.out.println("Event not found");
                    }

                }
                

            }else if (num == 3){
                String date = scnr.next();
                calendar.findEvents(date);
            }else if (num == 4){
                // Event e = new Event();
                //  if(calendar.addEvent(null))
                //  calendar.addEvent(null);
               
            }else if (num == 5){
                /*System.out.println("Enter a description");
                String description = scnr.next();// ask for input
                if(description.equals((Calendar)(calendar.findEvent(description)))){
                    calendar.removeEvent(description);
                }else{
                    System.out.println("Event not found.");
                }
                */
            }else if (num == 6){
                calendar.sortEvents();
                calendar.viewEvents();
            }else if (num == 7){
                // calendar.saveEvents("events.txt");
                menuNum = false;
            }
        }

    }
}
