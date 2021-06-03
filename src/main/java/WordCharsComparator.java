import java.util.Comparator;

class WordCharsComparator implements Comparator<Word> {

    public int compare(Word word1, Word word2){
        if(word1.getCount() == word2.getCount()){
            return word1.getWordlength() - word2.getWordlength();
        }
        return word1.getCount() - word2.getCount();
    }

}
