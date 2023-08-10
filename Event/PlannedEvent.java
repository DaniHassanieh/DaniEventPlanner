package Event;

import java.util.Calendar;

public class PlannedEvent {
    
    private String eventName;
    private String eventDescription;
    private Calendar eventStartDate;
    private Calendar eventEndDate;

    public PlannedEvent(String eventName, String eventDescription, Calendar eventStartDate, Calendar eventEndDate) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
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


    public Calendar getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Calendar eventStartDate) {
        this.eventStartDate = eventStartDate;
    }


    public Calendar getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Calendar eventEndDate) {
        this.eventEndDate = eventEndDate;
    }


    @Override
    public String toString() {
        return "Event [eventName=" + eventName + ", eventDescription=" + eventDescription + ", startDate="
                + eventStartDate.getTime() + ", endDate=" + eventEndDate.getTime() + "]";
    }
}
