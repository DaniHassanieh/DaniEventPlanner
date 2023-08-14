import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

public class EventPlannerGUI {

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int FRAME_WIDTH = SCREEN_SIZE.width / 2;
    public static final int FRAME_HEIGHT = SCREEN_SIZE.height / 2;
    public static final int PANEL_BORDER_WIDTH = FRAME_WIDTH / 80;
    public static final int PANEL_BORDER_HEIGHT = FRAME_HEIGHT / 45;

    private ArrayList<PlannedEvent> events = new ArrayList<PlannedEvent>();

    private JFrame frameMain;
    private JPanel panelMain;

    private JLabel labelEventName,labelEventDescription;
    private JTextField textFieldEventName, textFieldEventDescription;

    private JLabel labelEventStartDate;
    private JLabel labelEventEndDate;

    private JTextField textFieldEventStartYear, textFieldEventStartMonth, textFieldEventStartDay,
        textFieldEventStartHour, textFieldEventStartMinute;

    private JTextField textFieldEventEndYear, textFieldEventEndMonth, textFieldEventEndDay,
        textFieldEventEndHour, textFieldEventEndMinute;

    public EventPlannerGUI() {

        frameMain = new JFrame();
        panelMain = new JPanel();
        setPanelSettings(panelMain, 1, 2, BorderFactory.createEmptyBorder(PANEL_BORDER_HEIGHT,
                PANEL_BORDER_WIDTH, PANEL_BORDER_HEIGHT, PANEL_BORDER_WIDTH));

        JPanel panelLeft = new JPanel();
        setPanelSettings(panelLeft, 0, 1);
        JPanel panelRight = new JPanel();
        setPanelSettings(panelRight, 2, 1);
        JPanel panelEventData = new JPanel();
        setPanelSettings(panelEventData, 5, 2);
        JPanel panelEventMaker = new JPanel();
        setPanelSettings(panelEventMaker, 5, 2);

        labelEventName = new JLabel("Event Name:");
        textFieldEventName = new JTextField();
        labelEventDescription = new JLabel("Event Description:");
        textFieldEventDescription = new JTextField();

        labelEventStartDate = new JLabel("Start Date:");
        JPanel panelEventStartDate = new JPanel();
        setPanelSettings(panelEventStartDate, 1, 9);
        textFieldEventStartYear = new JTextField();
        textFieldEventStartMonth = new JTextField();
        textFieldEventStartDay = new JTextField();
        textFieldEventStartHour = new JTextField();
        textFieldEventStartMinute = new JTextField();
        {
            JComponent[] tempArray = new JComponent[]{textFieldEventStartYear, new JLabel(":"),
                    textFieldEventStartMonth, new JLabel(":"), textFieldEventStartDay,
                    new JLabel(":"), textFieldEventStartHour, new JLabel(":"), textFieldEventStartMinute};
            addAll(panelEventStartDate, tempArray);
        }

        labelEventEndDate = new JLabel("End Date:");
        JPanel panelEventEndDate = new JPanel();
        setPanelSettings(panelEventEndDate, 1, 9);
        textFieldEventEndYear = new JTextField();
        textFieldEventEndMonth = new JTextField();
        textFieldEventEndDay = new JTextField();
        textFieldEventEndHour = new JTextField();
        textFieldEventEndMinute = new JTextField();
        {
            JComponent[] tempArray = new JComponent[]{textFieldEventEndYear, new JLabel(":"),
                    textFieldEventEndMonth, new JLabel(":"), textFieldEventEndDay,
                    new JLabel(":"), textFieldEventEndHour, new JLabel(":"), textFieldEventEndMinute};
            addAll(panelEventEndDate, tempArray);
        }

        JLabel labelCreateNewEvent = new JLabel("Create!");
        JButton buttonCreateNewEvent = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eventName = textFieldEventName.getText();
                String eventDescription = textFieldEventDescription.getText();
                Calendar startDate = PlannedEvent.makeDate(toIntFromTextField(textFieldEventStartYear),
                        toIntFromTextField(textFieldEventStartMonth), toIntFromTextField(textFieldEventStartDay),
                        toIntFromTextField(textFieldEventStartHour), toIntFromTextField(textFieldEventStartMinute), 0);
                Calendar endDate = PlannedEvent.makeDate(toIntFromTextField(textFieldEventEndYear),
                        toIntFromTextField(textFieldEventEndMonth), toIntFromTextField(textFieldEventEndDay),
                        toIntFromTextField(textFieldEventEndHour), toIntFromTextField(textFieldEventEndMinute), 0);
                PlannedEvent tempPlannedEvent = new PlannedEvent(eventName, eventDescription, startDate, endDate);
                events.add(tempPlannedEvent);
                panelLeft.add(new JLabel(tempPlannedEvent.toString()));
                SwingUtilities.updateComponentTreeUI(frameMain);
            }
        });

        {
            JComponent[] tempArray = new JComponent[]{labelEventName, textFieldEventName, labelEventDescription,
                    textFieldEventDescription, labelEventStartDate, panelEventStartDate, labelEventEndDate,
                    panelEventEndDate, labelCreateNewEvent, buttonCreateNewEvent};
            addAll(panelEventMaker, tempArray);
        }

        panelRight.add(panelEventData);
        panelRight.add(panelEventMaker);

        panelMain.add(panelLeft);
        panelMain.add(panelRight);

        frameMain.add(panelMain, BorderLayout.CENTER);

        frameMain.setTitle("Dani Event Planner");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//        frameMain.setResizable(false);

        frameMain.setVisible(true);

    }

    private static void setPanelSettings(JPanel panel, int rows, int cols) {
        panel.setLayout(new GridLayout(rows, cols));
    }

    private static void setPanelSettings(JPanel panel, int rows, int cols, Border border) {
        panel.setBorder(border);
        panel.setLayout(new GridLayout(rows, cols));
    }



    private static void addAll(JPanel panel, JComponent[] components) {
        for (JComponent component : components) {
            panel.add(component);
        }
    }

    private static int toIntFromTextField(JTextField textField) {
        return Integer.parseInt(textField.getText());
    }
}
