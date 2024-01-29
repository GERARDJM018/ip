import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{

    private static DateTimeFormatter dFormatInp = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm");
    private static DateTimeFormatter dFormatOut = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
    private LocalDateTime from;
    private LocalDateTime to;
    private static final String symbol = "E";

    public Event(String des, LocalDateTime f, LocalDateTime t){
        super(des);
        from = f;
        to = t;
    }

    public Event(String st, String des, LocalDateTime f, LocalDateTime t){
        super(des);
        from = f;
        to = t;
        if (st.equals("true")){
            mark();
        } else {
            unMark();
        }
    }

    public String getSymbol() { //method to get symbol
        return symbol;
    }

    @Override
    public String toString() { //method to get the string representation of Event
        String s = "[" + this.getSymbol() + "][" + this.getStatusIcon() + "] " + this.description
                + " (from: " + this.from.format(dFormatOut) + " to: " + this.to.format(dFormatOut) + ")";
        return s;
    }

    public String toWrite() { //method to get the string representation of Event
        String s = this.getSymbol() + "/" + this.isDone + "/" + this.description
                + "/" + this.from.format(dFormatInp) + "/" + this.to.format(dFormatInp);
        return s;
    }
    public static String getFormat(){
        return "event Description /from " + "yyyy-MM-dd HH:mm" + " /to " + "yyyy-MM-dd HH:mm";
    }
}
