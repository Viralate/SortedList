import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI {
    private SortedList sortedList = new SortedList();

    public SortedListGUI() {
        JFrame frame = new JFrame("Sorted List GUI");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField inputField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                if (!text.isEmpty()) {
                    sortedList.add(text);
                    textArea.setText(sortedList.getList().toString());
                    inputField.setText("");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                if (!text.isEmpty()) {
                    int index = sortedList.binarySearch(text);
                    if (index >= 0) {
                        textArea.setText("Found: " + text + " at index " + index);
                    } else {
                        textArea.setText("Not found. Would be at index: " + (-index - 1));
                    }
                    inputField.setText("");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SortedListGUI();
    }
}
