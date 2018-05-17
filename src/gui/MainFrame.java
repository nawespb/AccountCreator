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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class MainFrame extends JFrame{
    
    SymbolSet complexity;
    int lengthPass;
    
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
        rButton1.setSelected(true);
        bg.add(rButton1);
        bg.add(rButton2);
        box.add(rButton1);
        box.add(rButton2);
        box.setSize(100, 50);
        box.setLocation(250, 20);
        panel.add(box);
        
        //Text fields
        
        JTextField tField = new JTextField();
        tField.setSize(200, 40);
        tField.setLocation(25, 20);
        panel.add(tField);
        JTextField tField2 = new JTextField("8");
        tField2.setSize(20, 20);
        tField2.setLocation(125, 65);
        panel.add(tField2);
        
        //Labels
        
        JLabel label = new JLabel("Длина пароля:");
        label.setSize(100, 20);
        label.setLocation(25, 65);
        panel.add(label);
        //TextAreas
        
        JTextArea area = new JTextArea();
        area.setSize(300,60 );
        area.setLocation(50, 125);
        panel.add(area);
        
        //ActionListeners
        
        gen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rButton1.isSelected()) {
                    complexity = SymbolSet.SIMPLE;
                } else complexity = SymbolSet.HARD;
                
                try {
                    lengthPass = Integer.parseInt(tField2.getText());
                } catch (NumberFormatException er){
                    JOptionPane.showMessageDialog(rootPane, "В поле \"Длина пароля\" необходимо ввести число!");
                }
        
                String str = (new Transliteration().translit(tField.getText()))+"\n"+(new PassGen().parse(lengthPass, complexity));
                area.setText(str);
                area.setEditable(false);
            }
        });
        
        setContentPane(panel);
        setSize(400, 300);
    }
}
