import java.util.Calendar;

import Event.Event;

public class AgendaPlanner {
    public static void main(String[] args) {

        Calendar bob = makeDate(2024, 6, 29, 0, 0, 0);
        Calendar andrew = makeDate(2024, 6, 29, 23, 59, 59);

        System.out.println(bob.getTime());

        Event birthday = new Event("Dani's Birthday!!", "Read Title :3", bob, andrew);

        System.out.println(birthday);

    }

    public static Calendar makeDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, day, hour, minute, second);
        return date;
    }
}