package Event;

import java.util.Calendar;

public class Event {
    
    private String eventName;
    private String eventDescription;
    private Calendar startDate;
    private Calendar endDate;

    public Event(String eventName, String eventDescription, Calendar startDate, Calendar endDate) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }


    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }


    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return "Event [eventName=" + eventName + ", eventDescription=" + eventDescription + ", startDate="
                + startDate.getTime() + ", endDate=" + endDate.getTime() + "]";
    }
}
