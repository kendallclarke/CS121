import javax.swing.*;
import java.awt.*;


public class Details extends JFrame {
    public Details(String breakdown) {
        setTitle("Expense Breakdown");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea(breakdown);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
