package word.Counts.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wordCount extends JFrame implements ActionListener {

    int totalwords=0;
    JLabel toWords;
    JButton wordCounts,exit,reset;
    JTextArea writewords;
    JComboBox<Integer> fontSize;

    wordCount(){

        JLabel wordCount = new JLabel("WORD COUNTER");
        wordCount.setBounds(400,20,500,60);
        wordCount.setFont(new Font("Helvetica",Font.BOLD,40));
        add(wordCount);

        writewords = new JTextArea();
        writewords.setLineWrap(true);
        writewords.setWrapStyleWord(true);
        add(writewords);

        JScrollPane writescroll = new JScrollPane(writewords);
        writescroll.setBounds(170,100,770,300);
        add(writescroll);

        toWords = new JLabel(totalwords + " WORDS");
        toWords.setBounds(515,450,150,30);
        toWords.setFont(new Font("Arial",Font.BOLD,20));
        add(toWords);

        wordCounts = new JButton("word Count");
        wordCounts.setBounds(500,500,150,30);
        wordCounts.setBackground(Color.black);
        wordCounts.setForeground(Color.WHITE);
        wordCounts.addActionListener(this);
        add(wordCounts);

        Integer[] fontsizes = {10,20,30,40};
        fontSize = new JComboBox<>(fontsizes);
        fontSize.setBounds(500,400,70,30);
        fontSize.addActionListener(this);
        add(fontSize);

        exit = new JButton("EXIT");
        exit.setBounds(500,550,150,30);
        exit.setBackground(Color.black);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        reset = new JButton("Reset");
        reset.setBounds(700,525,100,30);
        reset.setBackground(Color.RED);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);

        setSize(1170,650);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        totalwords=0;
        if(e.getSource()==fontSize && e.getActionCommand().equals("comboBoxChanged")){
            int fs=(int)fontSize.getSelectedItem();
            writewords.setFont(new Font("Arial",Font.BOLD,fs));
        }

        else if(e.getSource()==wordCounts){
            String data = writewords.getText();
            for (int i=0;i<data.length()-1;i++){
                if(data.charAt(i)==' ' && data.charAt(i+1)!=' '){
                      totalwords++;
                }
                else if (totalwords==0 && data.charAt(0)!=' ') totalwords=1;
                else if (data.length()==0) totalwords=0;
                toWords.setText(totalwords + " WORDS");

            }
        }
        else if (e.getSource()==reset){
            writewords.setText(" ");
            totalwords=0;
            toWords.setText(totalwords + " WORDS");
        }
        else {
            System.exit(90);
        }

    }

    public static void main(String[] args) {

        new wordCount();
    }
}
