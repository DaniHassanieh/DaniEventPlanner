import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Event.PlannedEvent;

public class EventPlannerGUI {

    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;

    private ArrayList<PlannedEvent> events;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public EventPlannerGUI() {

        frame = new JFrame();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        label = new JLabel("Number of clicks: 0");

        JButton button = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
//        panel.setLayout(new GridLayout(0,1));

        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Dani Event Planner");
        frame.pack();

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new EventPlannerGUI();
    }
}
