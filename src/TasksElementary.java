import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kuzLib.*;


public class TasksElementary {

    /*    Elementary
        1. Write a program that prints ‘Hello World’ to the screen.
        2. Write a program that asks the user for their name and greets them with their name.
        3. Modify the previous program such that only the users Alice and Bob are greeted with their names.
        4. Write a program that asks the user for a number n and prints the sum of the numbers 1 to n
        5. Modify the previous program such that only multiples of three or five are considered in the sum, e.g. 3, 5, 6, 9, 10, 12, 15 for n=17
        6. Write a program that asks the user for a number n and gives them the possibility to choose between computing the sum and computing the product of 1,…,n.
        7. Write a program that prints a multiplication table for numbers up to 12.
        8. Write a program that prints all prime numbers. (Note: if your programming language does not support arbitrary size numbers, printing all primes up to the largest number you can easily represent is fine too.)
        9. Write a guessing game where the user has to guess a secret number. After every guess the program tells the user whether their number was too large or too small. At the end the number of tries needed should be printed. It counts only as one try if they input the same number multiple times consecutively.
        10. Write a program that prints the next 20 leap years.

    */

    public void task0() {
        System.out.println("Hello world");
    }

    public void task1() {
        System.out.println("Type in your name");

        Scanner input = new Scanner(System.in);

        if (input.hasNextLine())
            System.out.println("Hello " + input.nextLine());
        else
            System.out.println("Wrong input");
    }

    public void task2() {
        System.out.println("Type in your name, only Alice or Bob are greeted");

        String[] strings = {"Alice", "Bob"};


        System.out.println("Hello, " + kuz.inputCheckString(strings));
    }


    public void task4() {
        System.out.println("Enter N to get sum of the numbers 1 to N");

        int n = kuz.inputCheckNumberInRange(1, Integer.MAX_VALUE);
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        System.out.println("Sum is " + sum);
    }

    public void task5() {
        System.out.println("Enter N to get sum of the numbers 1 to N, but only numbers divided by 3 or 5 are taken");

        int n = kuz.inputCheckNumberInRange(1, Integer.MAX_VALUE);
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        System.out.println(sum);
    }


    public void task7() {

        System.out.println("12*12 multiplying table");
        String[][] matrix = new String[13][13];
        for (int i = 0; i < matrix.length; i++) {
            matrix[0][i] = getFormattedStringForMatrix(String.valueOf(i));
        }


        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = getFormattedStringForMatrix(String.valueOf(i));
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = getFormattedStringForMatrix(String.valueOf(i * j));
            }
        }
        printMatrix(matrix);
    }


    public void task8() {
        System.out.println("All prime numbers from 0 to 230(to fit in 1 line)");
        System.out.println(IntStream.rangeClosed(2, 230)
                .filter(this::isPrime).boxed()
                .collect(Collectors.toList()));

    }


    public void task9() {
        System.out.println("IT'S A GUESSING GAME!!! GUESS THE NUMBER FROM 0 TO 100!!!!");

        int result = kuz.getRandomIntInRange(0, 100);
        int guess;
        do {
            guess = kuz.inputCheckNumberInRange(0, 100);
            if (guess < result)
                System.out.println("The number is larger then that!");
            else if (guess > result)
                System.out.println("The number is smaller then that!");
        }
        while (guess != result);

        System.out.println("Yes!!! The number was " + result);
    }


    public void task10() {
        System.out.println("Next leap years are: ");
        int currentYear = Year.now().getValue();
        for (int i = currentYear; i < currentYear + 20; i++) {
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0))
                System.out.print(" " + i);
        }

    }

    public void task11(){
        System.out.println("sum of an alternating series where each element of the series is an expression of the form " +
                "((-2)^(k+1))/(2*k-1)" +
                " from 1 to a million, multiplied by 4.");

        double sum=0;
        for(int i = 1; i <= 1000000; i++)
        {
            sum += doMath(i);
        }
        System.out.println(4*sum);
    }


    private double doMath(int k) {


       return Math.pow(-1,(k++))/(2*k-1);
    }

    private boolean isPrime(int num) {

        return IntStream.rangeClosed(2, (int) (Math.sqrt(num))).allMatch(n -> num % n != 0);
    }

    private String getFormattedStringForMatrix(String string) {
        switch (string.length()) {
            case 1:
                string = "  " + string;
                break;
            case 2:
                string = " " + string;
                break;
            case 3:
                string = "" + string;
                break;
        }
        return string;
    }

    private void printMatrix(Object[][] matrix) {
        for (Object[] objects : matrix) {
            System.out.println(Arrays.toString(objects));
        }
    }


    private void task5_1() {
        System.out.println("Enter N to get sum of the numbers 1 to N");

        int n = kuz.inputCheckNumberInRange(1, Integer.MAX_VALUE);

        long start = System.nanoTime();
        int sum = IntStream.rangeClosed(1, n - 1).filter(num -> num % 3 == 0 | num % 5 == 0).sum();
        long stop = System.nanoTime();
        System.out.printf("Stream time %d%n", (stop - start));
        System.out.println(sum);
    }

}






