import java.util.Calendar;
import Event.PlannedEvent;

public class EventPlanner {
    public static void main(String[] args) {

        Calendar startDate = makeDate(2024, 6, 29, 0, 0, 0);
        Calendar endDate = makeDate(2024, 6, 29, 23, 59, 59);

        PlannedEvent birthday = new PlannedEvent("Dani's Birthday!!", "Read Title :3", startDate, endDate);

        System.out.println(birthday);

    }

    public static Calendar makeDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, day, hour, minute, second);
        return date;
    }
}