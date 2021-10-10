import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine {
    private DictionaryManagement dictionaryManagement;
    Dictionary dictionary;
    DictionaryCommandLine(){
        dictionaryManagement=new DictionaryManagement();
    }

    void showAllWords(){
        for(int i=0;i<dictionaryManagement.dictionary.getSize();++i){
            System.out.println(dictionaryManagement.dictionary.getList(i).getWord_target()+": "
                    +dictionaryManagement.dictionary.getList(i).getWord_explain());
        }
    }

    List<Word> dictionarySearcher(String word){
        List<Word> searcherList=new ArrayList<Word>();
        for(int i=0;i<dictionaryManagement.dictionary.getSize();++i){
            if(dictionaryManagement.dictionary.getList(i).equalAPart(word)){
                searcherList.add(dictionaryManagement.dictionary.getList(i));
                //System.out.print(dictionaryManagement.dictionary.getList(i).getWord_target()+" ");
            }
        }

        return  searcherList;
    }

    void dictionaryBasic(){
        dictionaryManagement.insertFromCommnandLine();
        showAllWords();
    }

    void dictionaryAdvanced(int option) throws IOException {
        Scanner sc=new Scanner(System.in);
        switch (option){
            case -1:{
                dictionaryManagement.insertFromFile();

                break;
            }
            case -2:{
                dictionaryManagement.dictionaryExportToFile();
            }
            case 0: break;
            case 1:{      // look up
                System.out.print("type a word: ");
                String engWord=sc.next();
                dictionaryManagement.dictionaryLookUp(engWord);
                break;
            }
            case 2:{    //searched
                System.out.print("type characters: ");
                String characters=sc.next();
                List<Word> list=new ArrayList<>();
                list=dictionarySearcher(characters);
                for(Word i: list){
                    System.out.print(i.getWord_target()+" ");
                }
                System.out.println();
                break;
            }
            case 3:{    // insert from commandline
                dictionaryManagement.insertFromCommnandLine();
                break;
            }
            case 4:{    //change
                System.out.print("type a word that you want to change: ");
                String changedWord=sc.next();
                dictionaryManagement.change(changedWord);

                break;
            }
            case 5:{    //remove
                System.out.print("type a word that you want to remove: ");
                String removedWord=sc.next();
                dictionaryManagement.remove(removedWord);
                break;
            }
            case 6:{    //show all words
                showAllWords();
                break;
            }
            default: System.out.println("Invalid!!");
        }

    }


}