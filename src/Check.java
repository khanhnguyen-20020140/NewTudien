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
    private JEditorPane editorPane1;
    private JTextField textField2;
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
        //dict.insertFromFile();
         dict.selectAll();


         list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int number=list1.getSelectedIndex();
                if(number>=0){
                    editorPane1.setContentType("text/html");
                    editorPane1.setText(dict.dictionary.getList(number).getWord_explain());
                }
            }
        });

//         button1.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 String searched=textField1.getText();
//                 long start = System.currentTimeMillis();
//                 for(int i=0;i<dict.dictionary.getSize();i++){
//                     if(searched.equals(dict.dictionary.getList(i).getWord_target())){
//                         editorPane1.setContentType("text/html");
//                         editorPane1.setText(dict.dictionary.getList(i).getWord_explain());
//                         break;
//                     }
//                 }
//                 long end = System.currentTimeMillis();
//                 System.out.println("Thoi gian chay la: " + (end-start));
//             }
//         });
//
//         button1.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 String newWord=textField1.getText();
//                 String Explain=textField2.getText();
//                 dict.insert(newWord,Explain);
//                 System.out.println("add success");
//             }
//         });


         button1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String deleteWord=textField1.getText();
                 dict.delete(deleteWord);
             }
         });
     }

    public static void displaySce() throws IOException {
        DictionaryManagement dic=new DictionaryManagement();
        //dic.insertFromFile();
        dic.selectAll();
        for(int i=0;i<dic.dictionary.getSize();i++) {
            listDictionary.addElement(dic.dictionary.getList(i).getWord_target());
        }//in vao list1
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

