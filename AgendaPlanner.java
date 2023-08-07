import java.util.Calendar;

import Event.Event;

public class AgendaPlanner {
    public static void main(String[] args) {

        Calendar bob = makeDate(2024, 7, 29, 0, 0);
        Calendar andrew = makeDate(2024, 7, 29, 23, 59);

        System.out.println(bob.getTime());

        Event birthday = new Event("Dani's Birthday!!", "Read Title :3", bob, andrew);

    }

    public static Calendar makeDate(int year, int month, int day, int hour, int minute) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, day, hour, minute);
        return date;
    }
}