package academy;

public final class Util {

    public static int randomNumber(int min, int max) {
        
        return (int) (Math.random() * max - min + 1) + min;
    }

    private Util() {
    }
}
