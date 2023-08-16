import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class EventPlannerGUI {

    // Dimensions
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int FRAME_WIDTH = SCREEN_SIZE.width / 2;
    public static final int FRAME_HEIGHT = SCREEN_SIZE.height / 2;
    public static final int PANEL_BORDER_WIDTH = FRAME_WIDTH / 160;
    public static final int PANEL_BORDER_HEIGHT = FRAME_HEIGHT / 90;

    private static final Border mainBorder = BorderFactory.createEmptyBorder(PANEL_BORDER_HEIGHT, PANEL_BORDER_WIDTH,
            PANEL_BORDER_HEIGHT, PANEL_BORDER_WIDTH);

    // PlannedEvent ArrayList
    private HashMap<PlannedEvent, JButton> events = new HashMap<>();

    private JFrame frameMain;
    private JPanel panelMain;
    private JPanel panelLeft, panelRight;

    // panelEventMaker
    private JPanel panelEventMaker;
    private JLabel labelEventName,labelEventDescription;
    private JTextField textFieldEventName, textFieldEventDescription;
    private JLabel labelEventStartDate, labelEventEndDate;
    private JPanel panelEventStartDate;
    private JTextField textFieldEventStartYear, textFieldEventStartMonth, textFieldEventStartDay,
            textFieldEventStartHour, textFieldEventStartMinute;
    private JPanel panelEventEndDate;
    private JTextField textFieldEventEndYear, textFieldEventEndMonth, textFieldEventEndDay,
            textFieldEventEndHour, textFieldEventEndMinute;
    private JLabel labelCreatePlannedEvent;
    private JButton buttonCreatePlannedEvent;

    // panelEventData
    private JPanel panelEventData;
    private JLabel labelEventNameData,labelEventDescriptionData;
    private JLabel labelEventStartDateData, labelEventEndDateData;
    private JLabel labelDeletePlannedEvent;
    JButton buttonDeletePlannedEvent;

    public EventPlannerGUI() {

        frameMain = new JFrame();
        panelMain = new JPanel();
        setPanelSettings(panelMain, 1, 2, mainBorder);

        panelLeft = new JPanel();
        setPanelSettings(panelLeft, 0, 1);
        panelRight = new JPanel();
        setPanelSettings(panelRight, 2, 1);

        // panelEventMaker setup
        makePanelEventMaker();

        // panelEventData setup


        // panelRight setup
        panelRight.add(panelEventMaker);

        // panelMain setup
        panelMain.add(panelLeft);
        panelMain.add(panelRight);

        // frameMain setup
        frameMain.add(panelMain, BorderLayout.CENTER);

        frameMain.setTitle("Dani Event Planner");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//        frameMain.setResizable(false);

        frameMain.setVisible(true);
    }

    private void makePanelEventMaker() {
        panelEventMaker = new JPanel();
        setPanelSettings(panelEventMaker, 5, 2, mainBorder);

        labelEventName = new JLabel("Event Name:");
        textFieldEventName = new JTextField();
        labelEventDescription = new JLabel("Event Description:");
        textFieldEventDescription = new JTextField();

        labelEventStartDate = new JLabel("Start Date:");
        panelEventStartDate = new JPanel();
        setPanelSettings(panelEventStartDate, 1, 9);
        textFieldEventStartYear = new JTextField();
        textFieldEventStartMonth = new JTextField();
        textFieldEventStartDay = new JTextField();
        textFieldEventStartHour = new JTextField();
        textFieldEventStartMinute = new JTextField();
        {
            JComponent[] tempArray = {textFieldEventStartYear, new JLabel(":"),
                    textFieldEventStartMonth, new JLabel(":"), textFieldEventStartDay,
                    new JLabel(":"), textFieldEventStartHour, new JLabel(":"), textFieldEventStartMinute};
            addAll(panelEventStartDate, tempArray);
        }

        labelEventEndDate = new JLabel("End Date:");
        panelEventEndDate = new JPanel();
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

        labelCreatePlannedEvent = new JLabel("Create!");
        buttonCreatePlannedEvent = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // gets data from all JTextFields
                String eventName = textFieldEventName.getText();
                String eventDescription = textFieldEventDescription.getText();
                Calendar startDate = PlannedEvent.makeDate(toIntFromTextField(textFieldEventStartYear),
                        toIntFromTextField(textFieldEventStartMonth), toIntFromTextField(textFieldEventStartDay),
                        toIntFromTextField(textFieldEventStartHour), toIntFromTextField(textFieldEventStartMinute), 0);
                Calendar endDate = PlannedEvent.makeDate(toIntFromTextField(textFieldEventEndYear),
                        toIntFromTextField(textFieldEventEndMonth), toIntFromTextField(textFieldEventEndDay),
                        toIntFromTextField(textFieldEventEndHour), toIntFromTextField(textFieldEventEndMinute), 0);
                PlannedEvent tempPlannedEvent = new PlannedEvent(eventName, eventDescription, startDate, endDate);
                JButton buttonPanelEventData = new JButton(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        makePanelEventData(tempPlannedEvent);
                    }
                });
                events.put(tempPlannedEvent, buttonPanelEventData);

                panelLeft.add(buttonPanelEventData);
                SwingUtilities.updateComponentTreeUI(frameMain);
            }
        });

        {
            JComponent[] tempArray = new JComponent[]{labelEventName, textFieldEventName, labelEventDescription,
                    textFieldEventDescription, labelEventStartDate, panelEventStartDate, labelEventEndDate,
                    panelEventEndDate, labelCreatePlannedEvent, buttonCreatePlannedEvent};
            addAll(panelEventMaker, tempArray);
        }
    }

    private void makePanelEventData(PlannedEvent event) {
//        JPanel panelNewEventData = new JPanel();
//        events.put(event, panelNewEventData);
//        setPanelSettings(panelNewEventData, 5, 2, mainBorder);
        panelEventData = new JPanel();
//        events.put(event, panelEventData);
        setPanelSettings(panelEventData, 5, 2, mainBorder);

        labelEventNameData = new JLabel(event.getEventName());
        labelEventDescriptionData = new JLabel(event.getEventDescription());
        labelEventStartDateData = new JLabel(event.getEventStartDateString());
        labelEventEndDateData = new JLabel(event.getEventEndDateString());
        labelDeletePlannedEvent = new JLabel("Delete!");
        buttonDeletePlannedEvent = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeft.remove(events.get(event));
                panelRight.remove(panelEventData);
//                panelRight.remove(panelNewEventData);
//                events.remove(event);
                SwingUtilities.updateComponentTreeUI(frameMain);
            }
        });

        {
            JComponent[] tempArray = new JComponent[]{new JLabel("Event Name:"), labelEventNameData,
                    new JLabel("Event Description:"), labelEventDescriptionData,
                    new JLabel("Start Date:"), labelEventStartDateData, new JLabel("End Date:"),
                    labelEventEndDateData, labelDeletePlannedEvent, buttonDeletePlannedEvent};
            addAll(panelEventData, tempArray);
        }

//        panelEventData = panelNewEventData;
//        SwingUtilities.updateComponentTreeUI(frameMain);
        try{
            panelRight.remove(1);
        } finally {
            panelRight.add(panelEventData);
            SwingUtilities.updateComponentTreeUI(frameMain);
        }
    }

    /**
     * Sets a panel to a grid layout.
     * @param panel
     * @param rows
     * @param cols
     */
    private static void setPanelSettings(JPanel panel, int rows, int cols) {
        panel.setLayout(new GridLayout(rows, cols));
    }

    /**
     * Sets a panel to a grid layout with a border.
     * @param panel
     * @param rows
     * @param cols
     * @param border
     */
    private static void setPanelSettings(JPanel panel, int rows, int cols, Border border) {
        panel.setBorder(border);
        panel.setLayout(new GridLayout(rows, cols));
    }

    /**
     * Adds all items from a JCompenent array to a JPanel.
     * @param panel
     * @param components
     */
    private static void addAll(JPanel panel, JComponent[] components) {
        for (JComponent component : components) {
            panel.add(component);
        }
    }

    /**
     * Parses String to int in JTextField
     * @param textField
     * @return int
     */
    private static int toIntFromTextField(JTextField textField) {
        return Integer.parseInt(textField.getText());
    }
}
