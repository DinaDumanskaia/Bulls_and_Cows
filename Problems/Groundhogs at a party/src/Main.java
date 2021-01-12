import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int reese = Integer.parseInt(input[0]);
        String weekend = input[1];

        if ("true".equals(weekend) && reese >= 15 && reese <= 25) {
            System.out.println(true);
        } else if ("false".equals(weekend) && reese >= 10 && reese <= 20) {
            System.out.println(true);
        } else System.out.println(false);
    }
}