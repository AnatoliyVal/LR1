import java.util.Scanner;

/**
 * Клас, що представляє число Люка (варіант з початком 1, 3, 4, 7, 11...).
 */
class LucasNumber {
    private int index;
    private long value;

    /**
     * Конструктор для створення числа Люка.
     * @param index порядковий номер числа (починаючи з 1)
     * @param value значення числа Люка
     */
    public LucasNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /** @return порядковий номер числа */
    public int getIndex() {
        return index;
    }

    /** @return значення числа Люка */
    public long getValue() {
        return value;
    }

    /**
     * Перевіряє, чи є число ідеальним квадратом.
     * @return true, якщо число є квадратом
     */
    public boolean isPerfectSquare() {
        long sqrt = (long) Math.sqrt(value);
        return sqrt * sqrt == value;
    }
}

/**
 * Головний клас програми для обчислення чисел Люка
 * та визначення, які з них є квадратами.
 */
public class Main {
    /**
     * Обчислює n-те число Люка (початок 1, 3, 4, 7, 11...).
     * @param n порядковий номер (починаючи з 1)
     * @return значення числа Люка
     */
    public static long lucasCustom(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;
        long a = 1, b = 3, c = 0;
        for (int i = 3; i <= n; i++) {
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

        // Заповнення масиву об'єктів
        for (int i = 1; i <= N; i++) {
            numbers[i - 1] = new LucasNumber(i, lucasCustom(i));
        }

        // Вивід результатів
        System.out.println("Перші " + N + " чисел Люка (1, 3, 4, 7, 11...):");
        for (LucasNumber num : numbers) {
            String squareInfo = num.isPerfectSquare() ? " (квадрат)" : "";
            System.out.println("L_" + num.getIndex() + " = " + num.getValue() + squareInfo);
        }
    }
}