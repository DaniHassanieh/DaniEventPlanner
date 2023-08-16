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

    public String getEventStartDateString() {
        return String.format("%s/%s/%s/%s/%s", eventStartDate.get(Calendar.YEAR), eventStartDate.get(Calendar.MONTH),
                eventStartDate.get(Calendar.DAY_OF_MONTH), eventStartDate.get(Calendar.HOUR),
                eventStartDate.get(Calendar.MINUTE));
    }

    public String getEventEndDateString() {
        return String.format("%s/%s/%s/%s/%s", eventEndDate.get(Calendar.YEAR), eventEndDate.get(Calendar.MONTH),
                eventEndDate.get(Calendar.DAY_OF_MONTH), eventEndDate.get(Calendar.HOUR),
                eventEndDate.get(Calendar.MINUTE));
    }


    public static Calendar makeDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, day, hour, minute, second);
        return date;
    }


    @Override
    public String toString() {
        return "Event [eventName=" + eventName + ", eventDescription=" + eventDescription + ", startDate="
                + eventStartDate.getTime() + ", endDate=" + eventEndDate.getTime() + "]";
    }
}
