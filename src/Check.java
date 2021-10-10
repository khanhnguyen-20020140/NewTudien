import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Check extends JFrame {

    private JPanel newDic;
    private JTextField textField1;
    private JButton button1;
    private JList list1;
    private JTextArea textArea1;
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

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int number=list1.getSelectedIndex();
//                String a="22111";
//                System.out.println(a);
                if(number>=0){
                    textArea1.setText(dict.dictionary.getList(number).getWord_explain());
                    //System.out.println(k);
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

