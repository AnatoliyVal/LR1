import java.util.Scanner;

/**
 * Клас, що представляє число Люка.
 */
class LucasNumber {
    private int index;
    private long value;

    public LucasNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public long getValue() {
        return value;
    }

    public boolean isPerfectSquare() {
        long sqrt = (long) Math.sqrt(value);
        return sqrt * sqrt == value;
    }
}

/**
 * Головний клас програми.
 */
public class Main {

    // Класичне обчислення числа Люка
    public static long lucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        long a = 2, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        int N;
        if (args.length > 0) {
            N = Integer.parseInt(args[0]);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введіть N: ");
            N = sc.nextInt();
        }

        LucasNumber[] numbers = new LucasNumber[N];

        // Заповнення масиву
        for (int i = 0; i < N; i++) {
            numbers[i] = new LucasNumber(i, lucas(i));
        }

        // Вивід усіх чисел
        System.out.println("Перші " + N + " чисел Люка (2, 1, 3, 4, 7...):");
        for (LucasNumber num : numbers) {
            String squareInfo = num.isPerfectSquare() ? " (квадрат)" : "";
            System.out.println("L_" + num.getIndex() + " = " + num.getValue() + squareInfo);
        }

        // Вивід лише квадратів
        System.out.println("\nЧисла Люка, якi є квадратами:");
        boolean found = false;
        for (LucasNumber num : numbers) {
            if (num.isPerfectSquare()) {
                System.out.println("L_" + num.getIndex() + " = " + num.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Серед перших " + N + " чисел квадратів немає.");
        }
    }
}