import java.util.*;
import java.util.stream.Collectors;

public class Guesser {
    int guessnum;
    int numfromuser;

    public int guessNumber() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game.");
        System.out.println("Kindly Guess the Number. Between  1 to 10 ");
        guessnum = scanner.nextInt();
        if (guessnum <= 10) {
            return guessnum;
        } else {
            System.out.println("Kindly Guess the Number. Between 1 to 10 ");
            guessnum = scanner.nextInt();
            return guessnum;
        }
        //return 0;

    }


}

class Player {
    int pguessingNum;

    public int pguessingNumber(int playerNo) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Player Kindly Guess the Number..");
        System.out.printf("Player %d kindly guess the number...\n", playerNo);
        pguessingNum = scanner.nextInt();
        return pguessingNum;
    }
}

class Umpire {
    int numFromguesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;
    Map<Integer, Integer> results = new HashMap<>();

    void collectFromGuesser() {
        Guesser guesser = new Guesser();
        numFromguesser = guesser.guessNumber();

    }


    void collectFromPlayer() {
        System.out.println("How many players ?");
        Scanner scanner = new Scanner(System.in);
        int noOfPlayers = scanner.nextInt();
        for (int i = 0; i < noOfPlayers; i++) {
            Player player = new Player();
            int guess = player.pguessingNumber(i + 1);
            results.put(i + 1, guess);
        }

    }

    void compare() {
        Map<Integer, Integer> wonPlayers = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            if (numFromguesser == entry.getValue()) {
                wonPlayers.put(entry.getKey(), entry.getValue());
            }
        }

        if (results.size() == wonPlayers.size()) {
            System.out.println("Match tied");
        } else {
            System.out.printf("Won players : %s\n", wonPlayers.keySet().stream().map(k -> "Player" + k).toList());
        }

    }
}

class Demo {
    public static void main(String[] args) {
        Umpire umpire = new Umpire();
        umpire.collectFromGuesser();
        umpire.collectFromPlayer();
        umpire.compare();
    }
}