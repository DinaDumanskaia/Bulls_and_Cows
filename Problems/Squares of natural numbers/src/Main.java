import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        List<Integer> list = composeThelist(input);
        printList(list);
    }

    private static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static List<Integer> composeThelist(int input) {
        List<Integer> list = new ArrayList<>();
        int theNumber;
        if (input > 0) {
            for (int i = 1; i <= input; i ++) {
                theNumber = i * i;
                if (theNumber <= input) {
                    list.add(theNumber);
                } else {
                    break;
                }
            }
        }
        return list;
    }
}