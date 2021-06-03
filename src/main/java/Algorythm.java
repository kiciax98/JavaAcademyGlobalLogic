import java.util.*;

public class Algorythm {
    private char[] searchedChars = {'l', 'o', 'g', 'i', 'c'};
    private String inputLine;
    private int totalChars;
    private List<Word> words;
    private int totalSearchedChars;

    public Algorythm() {
        this.words = new ArrayList<>();
    }

    public void run(){
        getInput();
        removeSpecialChars();
        splitWords();
        countSearchedChars();
        viewResults();
    }

    private void getInput(){
        System.out.println("add input");
        Scanner scanner = new Scanner(System.in);
        inputLine = scanner.nextLine();
    }

    private void removeSpecialChars(){
        inputLine = inputLine.replaceAll("[^a-zA-Z ]", "");
        inputLine = inputLine.toLowerCase();
        totalChars = inputLine.replaceAll(" ", "").length();
    }

    private void splitWords(){
        String[] split = inputLine.split(" ");
        for(String s : split){
            countChars(s);
        }
    }

    private void countChars(String givenWord){
        List<Character> lettersInWord = new ArrayList<>();
        int counter = 0;
        for(char c : searchedChars) {
            for(int i = 0; i < givenWord.length(); i++) {
                if(givenWord.charAt(i) == c){
                    if(!lettersInWord.contains(c)) lettersInWord.add(c);
                    counter++;
                }
            }
        }
        Word word = new Word(lettersInWord, counter, givenWord.length());
        addWord(word);
    }

    private void addWord(Word word) {
        if(words.isEmpty()){
            words.add(word);
        } else {
            boolean contains = false;
            for (Word w : words) {
                if (w.getLettersInWord().equals(word.getLettersInWord()) && w.getWordlength() == word.getWordlength()) {
                    w.setCount(w.getCount() + word.getCount());
                    contains = true;
                }
            }
            if (!contains) {
                words.add(word);
            }
        }
    }

    private void viewResults(){
        Collections.sort(words, new WordCharsComparator());
        for(Word w : words) {
            System.out.println(w + "= " + (Math.round((w.getCount() * 1.0 / totalSearchedChars) * 100.0)/ 100.0) + " (" + w.getCount() + "/" + totalSearchedChars + ")");
        }
        System.out.println("TOTAL  Frequency: " + (Math.round((totalSearchedChars * 1.0 / totalChars) * 100.0)/ 100.0) + " (" + totalSearchedChars + "/" + totalChars + ")");
    }

    private void countSearchedChars(){
        for(Word w : words) {
            totalSearchedChars += w.getCount();
        }
    }
}
