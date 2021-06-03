import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Character> lettersInWord;
    private int count;
    private int wordlength;

    public Word(List<Character> lettersInWord, int count, int wordlength) {
        this.lettersInWord = lettersInWord;
        this.count = count;
        this.wordlength = wordlength;
    }

    public List<Character> getLettersInWord() {
        return lettersInWord;
    }

    public int getCount() {
        return count;
    }

    public int getWordlength() {
        return wordlength;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lettersInWord.size(); i++){
            sb.append(lettersInWord.get(i));
            if(i != lettersInWord.size()-1){
                sb.append(", ");
            }
        }
        return "{ (" + sb.toString() + "), " + wordlength + "} ";
    }
}
