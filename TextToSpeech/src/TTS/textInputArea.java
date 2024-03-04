package TTS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class textInputArea extends JFrame{
	public textInputArea() {
        // Set frame properties
        setTitle("Text To Speech");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Making components
        JTextField txtField = new JTextField(20);
        JButton button = new JButton("Submit");
        
        // Adding components
        JPanel panel = new JPanel();
        panel.add(txtField);
        panel.add(button);
        
        add(panel);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speechUtils.speak(txtField.getText());
            }
        });
        
        setVisible(true);
        
        
    }
}
