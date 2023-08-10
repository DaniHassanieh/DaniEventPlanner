import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Event.PlannedEvent;

public class EventPlannerGUI {

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int FRAME_WIDTH = SCREEN_SIZE.width / 2;
    public static final int FRAME_HEIGHT = SCREEN_SIZE.height / 2;
    public static final int PANEL_BORDER_WIDTH = FRAME_WIDTH / 80;
    public static final int PANEL_BORDER_HEIGHT = FRAME_HEIGHT / 45;

    private ArrayList<PlannedEvent> events;
//    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    private JLabel eventNameLabel;
    private JTextField eventNameText;
    private JLabel eventDescriptionLabel;
    private JTextField eventDescriptionText;
    private JLabel eventStartDateLabel;
    private JTextField eventStartDateText;
    private JLabel eventEndDateLabel;
    private JTextField eventEndDateText;

    public EventPlannerGUI() {

        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(PANEL_BORDER_HEIGHT, PANEL_BORDER_WIDTH, PANEL_BORDER_HEIGHT,
                PANEL_BORDER_WIDTH));
        panel.setLayout(null);

        JButton buttonCreateNewEvent = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        buttonCreateNewEvent.setBounds(FRAME_WIDTH / 6 * 5 + FRAME_WIDTH / 16, FRAME_HEIGHT / 6 * 5, FRAME_WIDTH / 16, FRAME_HEIGHT / 16);

        panel.add(buttonCreateNewEvent);

        frame.add(panel, BorderLayout.CENTER);


        frame.setTitle("Dani Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new EventPlannerGUI();
    }
}
