import  java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> list;

    Dictionary(){
        list=new ArrayList<Word>();
    }

    void setList(Word word){
        list.add(word);
    }
    void setList(Word word, int index){
        list.add(index,word);
    }
    Word getList(int index){
        return list.get(index);
    }
    int getSize(){
        return list.size();
    }

    void remove(int index){
        list.remove(index);
    }
}