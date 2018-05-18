package gui;

import features.PassGen;
import features.SaveInTheFile;
import features.SymbolSet;
import features.Transliteration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
        gen.setSize(180, 40);
        gen.setLocation(40, 200);
        panel.add(gen);
        JButton save = new JButton("Save");
        save.setSize(70, 40);
        save.setLocation(230, 200);
        panel.add(save);
        JButton config = new JButton("c");
        config.setSize(50, 40);
        config.setLocation(305, 200);
        panel.add(config);
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
        box.setLocation(260, 20);
        panel.add(box);
        
        //Text fields
        
        JTextField tField = new JTextField();
        tField.setSize(200, 40);
        tField.setLocation(35, 20);
        panel.add(tField);
        JTextField tField2 = new JTextField("8");
        tField2.setSize(20, 20);
        tField2.setLocation(135, 65);
        panel.add(tField2);
        
        //Labels
        
        JLabel label = new JLabel("Длина пароля:");
        label.setSize(100, 20);
        label.setLocation(35, 65);
        panel.add(label);
        
        //TextAreas
        
        JTextArea area = new JTextArea();
        area.setSize(300,60 );
        area.setLocation(50, 105);
        area.setEditable(false);
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
                    JOptionPane.showMessageDialog(rootPane, "В поле \"Длина пароля\" необходимо ввести целое число. Длина пароля должна быть не менее 3 символов");
                }
                
                if (lengthPass>3) {
                    String str = "";
                    str = (new Transliteration().translit(tField.getText()))+System.lineSeparator()+(new PassGen().parse(lengthPass, complexity));
                    area.setText(str);
                } else JOptionPane.showMessageDialog(rootPane, "В поле \"Длина пароля\" необходимо ввести целое число. Длина пароля должна быть не менее 3 символов");
            }
        });
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!area.getText().isEmpty()) {
                    String saveText = area.getText();
                    new SaveInTheFile().saver(saveText, new Transliteration().translit(tField.getText()));
                } else JOptionPane.showMessageDialog(rootPane, "Перед сохранением необходимо сгенерировать пароль и ввести Имя");
            }
        });
        
        config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String result = JOptionPane.showInputDialog(rootPane, "ВВедите путь");
//                result.replace("\\", "\\\\");
                try {
                    new SaveInTheFile().setConfig(result);
                } catch (IOException ex) {
                    System.out.println("Файл не сохранен");
                    ex.printStackTrace();
                }
            }
        });
        
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(panel);
        setSize(400, 300);
    }
}
