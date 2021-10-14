import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JScrollPane.*;

public class Check extends JFrame {

    private JPanel newDic;
    private JTextField textField1;
    private JButton button1;
    private JList list1;
    private JTextArea textArea1;
    private JPanel jp;
    private static DefaultListModel listDictionary;
    //private static DictionaryManagement dictionaryManagement;

     Check(String title) throws IOException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(newDic);
        this.pack();
        listDictionary=new DefaultListModel();
        list1.setModel(listDictionary);

        DictionaryManagement dict=new DictionaryManagement();
        dict.insertFromFile();
        //JScrollPane scroll=new JScrollPane(list1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

         list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int number=list1.getSelectedIndex();
                if(number>=0){
                    textArea1.setText(dict.dictionary.getList(number).getWord_explain());
                }
            }
        });

         button1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String searched=textField1.getText();

                 for(int i=0;i<dict.dictionary.getSize();i++){
                     if(searched.equals(dict.dictionary.getList(i).getWord_target())){
                         textArea1.setText(dict.dictionary.getList(i).getWord_explain());
                         System.out.println("find");
                         break;
                     }
                 }
             }
         });
     }

    public static void displaySce() throws IOException {
        DictionaryManagement dic=new DictionaryManagement();
        dic.insertFromFile();
        for(int i=0;i<dic.dictionary.getSize();i++) {
            listDictionary.addElement(dic.dictionary.getList(i).getWord_target());
        }
    }

    public static void main(String[] args) throws IOException {
        JFrame frame=new Check("My Dictionary");

        displaySce();
        frame.setVisible(true);
//        DictionaryCommandLine dictionary=new DictionaryCommandLine();
//        dictionary.dictionaryAdvanced(-1); // update word from file to list
//        dictionary.dictionaryAdvanced(6);


    }



}

