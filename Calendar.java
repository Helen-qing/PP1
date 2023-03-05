import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/***
 * @author Helen Gao
 * @version 0.1
 * Date of creation: Feb. 8 2023
 * Last date modified: March 1 2023
 */
 
public class Calendar {

    private Event[] events;
    private int count;

    public Calendar(){
        events = new Event[50];
        count = 0;
    }

    public Calendar(String filename){
       events = new Event[50];
       count = 0;
       readEvents(filename);// pass filename to readevenets
       
    }
  
    
     /* 
     private void readEvents(String filename){
         File file = new File(filename);
         String description;
         String location;
         String date;
         String time;
         String contactOrHost;
         int guest;

         try{
             Scanner readFile = new Scanner(file);//throws an exception
             while (readFile.hasNext()) {//read lline by line
                String type = readFile.nextLine();
                if(type.equals("meeting")){
                    // System.out.println(description);
                    description = readFile.nextLine();
                    location = readFile.nextLine();
                    date = readFile.nextLine();
                    time = readFile.nextLine();
                    contactOrHost = readFile.nextLine();
                    guest = Integer.parseInt(readFile.nextLine());//read as String and converts to int

                    Meeting m = new Meeting(description, location, date, time, contactOrHost, guest);
                    System.out.println(m);
                    events[count] = m;//storing object m at index array list
                    // System.out.println(events[count]);
                    count++;
                }else{ // it is an apointment
                    // System.out.println(description);
                    description = readFile.nextLine();
                    location = readFile.nextLine();
                    date = readFile.nextLine();
                    time = readFile.nextLine();
                    contactOrHost = readFile.nextLine();
                    Appointment a = new Appointment(description, location, date, time, contactOrHost);
                    System.out.println(a);
                    events[count] = a;
                    // System.out.println(events[count]);
                    count++;
                }
            }

            readFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(InvalidDateTimeException e){
            System.out.println(e.getMessage());
        }
    }
    */

    private void readEvents(String filename){

        //initializing 
        String eventType;
        String description;
        String location;
        String date;
        String time;
        String contact;
        String host;
        int guest;
        
  
        File f = new File(filename);
  
        try{
  
            Scanner fScan = new Scanner(f);
  
            while(fScan.hasNext()){
  
  
                eventType = fScan.nextLine(); // we're going to use this to check line by line, specifically for what type of event it is
  
                switch(eventType){
  
                    case "appointment":
                        description = fScan.nextLine();
                        location = fScan.nextLine();
                        date = fScan.nextLine();
                        time = fScan.nextLine();
                        contact = fScan.nextLine();
                        events[count++] = new Appointment(description,location,date,time,contact);
                        break;
  
  
                    case "meeting":
                        description = fScan.nextLine();
                        location = fScan.nextLine();
                        date = fScan.nextLine();
                        time = fScan.nextLine();
                        host = fScan.nextLine();
                        guest = fScan.nextInt();
                        events[count++] = new Meeting(description, location, date, time, host, guest);
                        break;
  
                    default:
  
                }
  
            }
            fScan.close();
            
  
        }catch(FileNotFoundException fnf){
  
            System.out.println(fnf.getMessage());
  
  
        } catch(InvalidDateTimeException e){
  
            System.out.println(e.getMessage());
  
        }
  
  
      }


    // public void saveEvents(String filename){//save list of file from String filename
    //     try{File file = new File(filename);
    //     PrintWriter write = new PrintWriter(file);
    //     for(int i = 0; i < count; i++){
    //         if (events[i] instanceof Meeting){
    //             write.println("meeting");
    //             write.println(events[i].getDescription());
    //             write.println(events[i].getLocation());
    //             write.println(events[i].getDate());
    //             write.println(events[i].getTime());
    //             write.println(((Meeting)events[i]).getHost());
    //             write.println(((Meeting)events[i]).getGuests());
    //         }
    //         else if(events[i] instanceof Appointment){
    //             write.println("appointment");
    //             write.println(events[i].getDescription());
    //             write.println(events[i].getLocation());
    //             write.println(events[i].getDate());
    //             write.println(events[i].getTime());
    //             write.println(((Appointment)events[i]).getContact());
    //         }
    //     }
    //     write.close();}
    //     catch (FileNotFoundException e){
    //         System.out.println("File not found.");
    //     }
    // }

    public void saveEvents(String filename){// save the list of events into a file respectively.
          try{
            File file = new File(filename);
            PrintWriter writeFile = new PrintWriter(file);
            for(int i = 0; i < count; i++){
                if(events[i] instanceof Appointment){
                    writeFile.println("appointment");
                    writeFile.println(events[i].getDescription());
                    writeFile.println(events[i].getLocation());
                    writeFile.println(events[i].getDate());
                    writeFile.println(events[i].getTime());
                    writeFile.println(((Appointment)events[i]).getContact()); //casting


                }else if(events[i] instanceof Meeting){// it is meeting
                    writeFile.println("meeting");
                    writeFile.println(events[i].getDescription());
                    writeFile.println(events[i].getLocation());
                    writeFile.println(events[i].getDate());
                    writeFile.println(events[i].getTime());
                    writeFile.println(((Meeting)events[i]).getHost());
                    writeFile.println(((Meeting)events[i]).getGuests());
                }
            }
            writeFile.close();
        }catch(FileNotFoundException e){
            System.out.println("Cannot write to " + filename);
        }
    }

    public Event findEvent(String description){// takes a description as a parameter and returns a shallow copy of the found event or null if no event is found. 
        for(int i = 0; i < count; i++){
            if(events[i].getDescription().equals(description)){
                //return shalow copy
                return events[i];
            }
        }
        return null;

    }

    public Event[] findEvents(String date){
        Event[] list = new Event[50];
        int index = 0;
        for(int i = 0; i < count; i++){
            if(events[i].getDate().toString().equals(date)){
                list[index] = events[i]; // shallow copy
                index++;
            }
        }
        if(index == 0){// didnt find any event
            return null;
        }else{
            Event[] findInList = new Event[index];
            for(int i = 0; i < index; i++){
                findInList[i] = list[i];
            }
            return findInList;
        }
    }

    public boolean addEvent(Event e){
        for(int i = 0; i < count; i++){
            if(events[i] == null){ // events at i has nothing in it
                events[i] = e; // events at i becomes e
                count++; // increments the number of events
                return true;
            }
        }
        return false;
    }

    public boolean removeEvent(String description){ // testing: 1 2 3 
        for(int i = 0; i < count; i++){ // loops through the whole array to find description
            if(events[i].getDescription().equals(description)){
                for(int j = i; j < count - 1; j++){ // starts at index to finish list; j is index 
                    events[j] = events[j+1]; // the last index has no value b/c u took the the number out
                    
                }
                count--;
                return true; // match was found; still in if statement
            }
        }

        return false;
    }
    

    public void viewEvents(){
        for(int i = 0; i < count; i++){
            System.out.println(events[i]);
        }
    }

    public void sortEvents(){
        java.util.Arrays.sort(events, 0, count);
    }

}
