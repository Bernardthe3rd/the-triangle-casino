package novi.hangman;

public class DuplicateLetterException extends RuntimeException {
    public DuplicateLetterException(String letter) {
        super(String.format("You already tried the letter %s", letter));
    }
}
