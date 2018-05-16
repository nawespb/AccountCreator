package gui;

import features.PassGen;
import features.SymbolSet;
import features.Transliteration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public final class MainFrame extends JFrame{

    public MainFrame() {
        
        super("Account Creater");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Buttons
        
        JButton gen = new JButton("Gen Account");
        gen.setSize(200, 40);
        gen.setLocation(100, 200);
        panel.add(gen);
        
        //Box with radiobuttons
        
        Box box = Box.createVerticalBox();
        JRadioButton rButton1 = new JRadioButton("Simple pass");
        JRadioButton rButton2 = new JRadioButton("Hard pass");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rButton1);
        bg.add(rButton2);
        box.add(rButton1);
        box.add(rButton2);
        box.setSize(100, 50);
        box.setLocation(250, 20);
        panel.add(box);
        
        //Text field
        
        JTextField tField = new JTextField();
        tField.setSize(200, 50);
        tField.setLocation(25, 20);
        panel.add(tField);
        
        //Labels
        
        JLabel label1 = new JLabel("");
        label1.setSize(300,20 );
        label1.setLocation(50, 100);
        panel.add(label1);
        JLabel label2 = new JLabel("");
        label2.setSize(300,20 );
        label2.setLocation(50, 130);
        panel.add(label2);
        
        //ActionListeners
        
        gen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText(new Transliteration().translit(tField.getText()));
                label2.setText(new PassGen().parse(8, SymbolSet.SIMPLE));
            }
        });
        
        setContentPane(panel);
        setSize(400, 300);
        
    }
    
}
