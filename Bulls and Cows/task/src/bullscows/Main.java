package bullscows;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int secretCodeLength;
        int lettersAmount;
        String secretCode = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        //считываем ввод пользователя, длину числа
        String numberLength = scanner.nextLine();
        try {
            secretCodeLength = Integer.parseInt(numberLength);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + numberLength + "\" isn't a valid number.");
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        String lettersLength = scanner.nextLine();
        try {
            lettersAmount = Integer.parseInt(lettersLength);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + lettersLength + "\" isn't a valid number.");
            return;
        }

        if (lettersAmount < secretCodeLength) {
            System.out.println("Error: it's not possible to generate a code with a length of " + secretCodeLength + " with "
                    + lettersAmount + " unique symbols.");
        } else if (lettersAmount > 36 || secretCodeLength == 0) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        } else {
            secretCode = createTheSecretCode(secretCodeLength, lettersAmount);/*createSecretCode(secretCodeLength);composeTheRandomNumber(secretCodeLength);*/
        }

        //создаем рандомное число с заданными условиями
        //считаем коров и быков
        if (secretCode != null) {
            int turn = 1;
            String playerInput = null;
            while (!secretCode.equals(playerInput)) {
                System.out.println("Turn " + turn + ":");
                playerInput = scanner.nextLine();
                countBullsAndCows(secretCode, playerInput);
                turn++;
            }
            System.out.println("Congratulations! You guessed the secret code.");
        }
    }

    private static String createTheSecretCode(int secretCodeLength, int symbolAmount) {
        StringBuilder line = new StringBuilder();
        Set<Character> checkTheUniqueness = new HashSet<>();
        Random generator = new Random();
        char symbolToPutInSecretCode;
        int i = 0;
        while (i < secretCodeLength) {
            int random = generator.nextInt(symbolAmount);
            if (random < 10) {
                symbolToPutInSecretCode = (char) ('0' + random);
            } else {
                int letterNumber = random - 10;
                symbolToPutInSecretCode = (char) ('a' + letterNumber);
            }

            if (checkTheUniqueness.add(symbolToPutInSecretCode)) {
                line.append(symbolToPutInSecretCode);
                i++;
            }
        }
        String secretLine = line.toString();
        createTheOutput(secretCodeLength, symbolAmount);
        return secretLine;
    }

    private static void createTheOutput(int secretCodeLength, int symbolAmount) {
        String stars = "";
        for (int i = 0; i < secretCodeLength; i++) {
            stars += "*";
        }
        char end = (char) ('a' + symbolAmount - 10 - 1);
        System.out.println("The secret is prepared: " + stars + " (0-9, a-" + end + ").");
        System.out.println("Okay, let's start a game!");
    }


    private static int createSecretCode(int secretCodeLength) {
        Random generator = new Random();
        int b = (int) (Math.pow(10, secretCodeLength) - 1);
        int a = (int) Math.pow(10, secretCodeLength - 1);
        int random = 0;
        boolean isNumberCorrect = false;
        while (!isNumberCorrect) {

            random = generator.nextInt(b - a + 1) + a;
            String[] number = Integer.toString(random).split("");

            if (number.length == 1) {
                isNumberCorrect = true;
                break;
            } else {
                isNumberCorrect = checkContainsUniqueNumbers(number);
            }
        }
        return random;
    }

    private static boolean checkContainsUniqueNumbers(String[] numbers) {
        int u;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (u = i + 1; u < numbers.length; u++) {
                if (numbers[i].equals(numbers[u])) {
                    return false;
                }
            }
        }
        return true;
    }

//    private static int composeTheRandomNumber(int usersInput) {
//        List<Integer> number = new ArrayList<>();
//        List<Integer> ten = new ArrayList<>();
//        ten.add(0);
//        ten.add(1);
//        ten.add(2);
//        ten.add(3);
//        ten.add(4);
//        ten.add(5);
//        ten.add(6);
//        ten.add(7);
//        ten.add(8);
//        ten.add(9);
//
//        if (usersInput > 10 || usersInput == 0) {
//            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
//            return 0;
//        } else {
//            while(number.size() < usersInput) {
//                long pseudoRandomNumber = System.nanoTime();
//                int ind = Math.abs((int)pseudoRandomNumber % ten.size());
//                int randomNumber = ten.get(ind);
//                if (!(number.isEmpty() && randomNumber == 0)) {
//                    number.add(randomNumber);
//                    ten.remove(ind);
//                }
//            }
//        }
//        return makeIntFromList(number);
//    }

    private static int makeIntFromList(List<Integer> number) {
        StringBuilder sb = new StringBuilder();
        for (int i : number) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    private static void countBullsAndCows(String secretCode, String playerInput) {
        //создаем каунтеры, которые будем увеличивать
        int bulls = 0;
        int cows = 0;

        //разбиваем числа на элементы для сравнения
        String[] secCode = secretCode.split("");
        String[] input = playerInput.split("");
        //считаем быков и коров
        for (int code = 0; code < secCode.length; code++) {
            for (int in = 0; in < secCode.length; in++) {
                if (code == in && input[in].equals(secCode[code])) {
                    bulls++;
                } else if (code != in && input[in].equals(secCode[code])) {
                    cows++;
                }
            }
        }
        //прописываем результат согласно подсчетам
        if (bulls != 0 && cows != 0) {
            if (bulls == 1 && cows == 1) {
                System.out.println("Grade: " + bulls + " bull and " + cows + " cow");
            } else if (bulls == 1) {
                System.out.println("Grade: " + bulls + " bull and " + cows + " cows");
            } else if (cows == 1) {
                System.out.println("Grade: " + bulls + " bulls and " + cows + " cow");
            } else {
                System.out.println("Grade: " + bulls + " bulls and " + cows + " cows");
            }
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None");
        } else if (bulls == 0) {
            if (cows == 1) {
                System.out.println("Grade: " + cows + " cow");
            } else {
                System.out.println("Grade: " + cows + " cows");
            }
        } else {
            if (bulls == 1) {
                System.out.println("Grade: " + bulls + " bull.");
            } else {
                System.out.println("Grade: " + bulls + " bulls");
            }
        }

    }
}
