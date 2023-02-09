import kuzLib.kuz;

import java.lang.reflect.Parameter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TasksListsStrings {

    /*
        Lists, Strings
    1. Write a function that returns the largest element in a list.
    2. Write function that reverses a list, preferably in place.
    3. Write a function that checks whether an element occurs in a list.
    4. Write a function that returns the elements on odd positions in a list.
    5. Write a function that computes the running total of a list.
    6. Write a function that tests whether a string is a palindrome.
    7. Write three functions that compute the sum of the numbers in a list: using a for-loop, a while-loop and recursion.
        (Subject to availability of these constructs in your language of choice.)
    8. Write a function on_all that applies a function to every element of a list.
        Use it to print the first twenty perfect squares.
        The perfect squares can be found by multiplying each natural number with itself.
        The first few perfect squares are 1*1= 1, 2*2=4, 3*3=9, 4*4=16.
        Twelve for example is not a perfect square because there is no natural number m so that m*m=12.
        (This question is tricky if your programming language makes it difficult to pass functions as arguments.)
    9. Write a function that concatenates two lists. [a,b,c], [1,2,3] → [a,b,c,1,2,3]
   10. Write a function that combines two lists by alternatingly taking elements, e.g. [a,b,c], [1,2,3] → [a,1,b,2,c,3].
   11. Write a function that merges two sorted lists into a new sorted list. [1,4,6],[2,3,5] → [1,2,3,4,5,6].
        You can do this quicker than concatenating them followed by a sort.
   12. Write a function that rotates a list by k elements.
        For example [1,2,3,4,5,6] rotated by two becomes [3,4,5,6,1,2].
        Try solving this without creating a copy of the list. How many swap or move operations do you need?
   13. Write a function that computes the list of the first 100 Fibonacci numbers.
        The first two Fibonacci numbers are 1 and 1.
        The n+1-st Fibonacci number can be computed by adding the n-th and the n-1-th Fibonacci number.
        The first few are therefore 1, 1, 1+1=2, 1+2=3, 2+3=5, 3+5=8.
   14. Write a function that takes a number and returns a list of its digits. So for 2342 it should return [2,3,4,2].
   15. Write functions that add, subtract, and multiply two numbers in their digit-list representation
        (and return a new digit list). If you’re ambitious you can implement Karatsuba multiplication.
        Try different bases. What is the best base if you care about speed?
        If you couldn’t completely solve the prime number exercise above due to the lack of
        large numbers in your language, you can now use your own library for this task.
   16. Write a function that takes a list of numbers, a starting base b1 and a target base b2
        and interprets the list as a number in base b1 and converts it into a number in base b2
        (in the form of a list-of-digits). So for example [2,1,0] in base 3 gets converted to base 10 as [2,1].
   17. Implement the following sorting algorithms: Selection sort, Insertion sort, Merge sort, Quick sort, Stooge Sort.
        Check Wikipedia for descriptions.
   18. Implement binary search.
   19. Write a function that takes a list of strings an prints them, one per line, in a rectangular frame.
        For example the list ["Hello", "World", "in", "a", "frame"] gets printed as:

            *********
            * Hello *
            * World *
            * in    *
            * a     *
            * frame *
            *********
   20. Write function that translates a text to Pig Latin and back.
        English is translated to Pig Latin by taking the first letter of every word,
        moving it to the end of the word and adding ‘ay’. “The quick brown fox” becomes “Hetay uickqay rownbay oxfay”.

*/

    private final int SIZE = 10000;
    private final int MIN = 0;
    private final int MAX = 10000;
    private final List<Integer> nums = Arrays.stream(new Random()
            .ints(SIZE, MIN, MAX)
            .toArray()).boxed().collect(Collectors.toList());

/*

     int[] nus = {1,25,16,3, 133,121,144,561,617,36343,62234,62345,2341263,1234277,234236,262331,100,144,1516,3234};
 private final List<Integer> nums = Arrays.stream(nus).boxed().collect(Collectors.toList());
*/


    /*
        public void task1() {
            Optional optionalInteger = nums.stream().max(Integer::compare);

            if (optionalInteger.isPresent())
                System.out.println("Returned " + optionalInteger.get());
            else
                System.out.println("no such");
        }


        public void task2() {
            nums.stream();
        }

        public void task3() {
            System.out.println("Enter a number to check if it is present in an array of "
                    + SIZE + " elements. Ranging from " + MIN + " to " + MAX);

            int num = kuz.inputCheckNumberInRange(MIN, MAX);

            if (nums.stream().anyMatch(n -> n == num))
                System.out.println("It is there");
            else
                System.out.println("It is not there");
        }

        public void task4() {
            for (int i = 1; i < nums.size(); i += 2) {
                System.out.print(nums.get(i) + " ");
            }
        }

        public void task5() {
            System.out.println("Sum of list with stream");
            int sum = 0;
            long start =  System.nanoTime();
            sum = nums.stream().mapToInt(n -> n.intValue()).sum();
            long stop = System.nanoTime();

            System.out.println("Sum is: " + sum + " time took - " + (stop-start));
        }


        public void task6(){
            System.out.println("Enter a string to check if it is a palindrome");
            Scanner input = new Scanner(System.in);
            if(input.hasNextLine())
            {
                String inputLine = input.nextLine();
                StringBuilder sb = new StringBuilder(inputLine);
                if(sb.reverse().toString().equalsIgnoreCase(inputLine))
                    System.out.println("it is a palindrome");
                else
                    System.out.println("it is not a palindrome");
            }
            else
                System.out.println("Input was wrong");
        }



        public void task7(){
            System.out.println("Sum of list with for loop");
            long start = System.nanoTime();
            int sum= 0;
            for(int i : nums)
            {
                sum += i;
            }
            long stop = System.nanoTime();
            System.out.println("Sum is: " + sum + " time took - " + (stop-start));

            System.out.println("Sum of list with while loop");
            start = System.nanoTime();
            sum= 0;
            int i = 0;
            while (i < nums.size())
            {
                sum += nums.get(i++);
            }
            stop = System.nanoTime();
            System.out.println("Sum is: " + sum + " time took - " + (stop-start));

            System.out.println("Sum of list with recursion");
            start = System.nanoTime();

            sum = intSum(nums, nums.size());

            stop = System.nanoTime();
            System.out.println("Sum is: " + sum + " time took - " + (stop-start));

        }



        public void task8() {
            System.out.println("Finding prefect first 20 perfect squares in the list");

            List<Integer> result = new ArrayList<>();
            int i = 0;
            int counter = 0;
            while (counter < 20 && i < nums.size()) {
                if (isAPerfectSquare(nums.get(i))) {
                    result.add(nums.get(i));
                    counter++;
                }
                i++;
            }
            System.out.println(result);
        }

    public void task9() {

        System.out.println("concatenates two lists");
        List<Integer> nums = createNumberList(10);
        List<Character> letters = createCharList(10);
        List<Object> result = new ArrayList<>();

        result.addAll(nums);
        result.addAll(letters);

        System.out.println(result);
    }

    public void task10() {

        System.out.println("combines two lists by alternatingly taking elements");
        List<Integer> intList = createNumberList(10);
        List<Character> letters = createCharList(10);
        List<Object> result = new ArrayList<>();
        int size = intList.size() <= letters.size() ? intList.size() : letters.size();
        int i = 0;
        for (; i < size; i++) {
            result.add(intList.get(i));
            result.add(letters.get(i));
        }

       if (intList.size() != letters.size()) {
            if (size == intList.size())
                result.addAll(i * 2, letters.subList(i, letters.size()));
            else
                result.addAll(i * 2, intList.subList(i, intList.size()));
        }
        System.out.println(result);
    }

    public void task11()
    {
        System.out.println("merges two sorted lists into a new sorted list");
        List<Integer> nums1 = createNumberList(10);
        nums1.sort(Integer::compare);
        List<Integer> nums2 = createNumberList(20);
        nums2.sort(Integer::compare);

        List<Object> result = new ArrayList<>();

        int size = nums1.size() <= nums1.size() ? nums1.size() : nums2.size();

        int i = 0;
        int j = 0;
        while ((nums1.size() <= nums1.size() ? i : j) < size ) {
            if(nums1.get(i) <= nums2.get(j) && i < nums1.size()) {
                result.add(nums1.get(i));
                i++;
            }
            else {
                result.add(nums2.get(j));
                j++;
            }
        }

        System.out.println(result);
    }

    public void task12()
    {
        System.out.println("rotates a list by k elements");
        List<Integer> newNums = createNumberList(20);
        newNums.sort(Integer::compare);
        List<Integer> newNums2 = new ArrayList<>(newNums);
        System.out.println("Before rotating \n" + newNums);
        int n = kuz.getRandomIntInRange(1,6);
        System.out.println("Number by which we rotate " + n);

        for(int k = 0; k < n; k++)
        {
            int tmp = newNums.get(0);
            int i = 0;
            for(; i < newNums.size()-1; i++)
            {
                newNums.set(i, newNums.get(i+1));
            }
            newNums.set(i, tmp);
        }

        System.out.println("After rotating \n" + newNums);


        System.out.println("Rotating bt collections method");
        System.out.println("Before rotating\n" + newNums2);
        System.out.println("Number by which we rotate " + n);
        Collections.rotate(newNums2,n);
        System.out.println();
        System.out.println("After rotating \n" + newNums2);
        System.out.println("As we can see rotation from collections is in the opposite direction");

        Collections.rotate(newNums2, -2*n);
        System.out.println("After opposite rotating with collections \n" + newNums2);

    }


    public void task13() {
        System.out.println("computes the list of the first 100 Fibonacci numbers");

        BigInteger[] fib = new BigInteger[100];
        fib[0] = BigInteger.valueOf(1);
        fib[1] = BigInteger.valueOf(1);
        for(int i=2; i < fib.length; i++)
        {
            fib[i] = fib[i-1].add(fib[i-2]);
        }
        System.out.println(Arrays.toString(fib));
    }


    public void task14() {
        System.out.println("takes a number and returns a list of its digits");
        int n = kuz.getRandomIntInRange(0, 10000);
        int n2 = n;
        System.out.println("Number is " + n);

        char[] charArr = String.valueOf(n).toCharArray(); //LOL way

        System.out.println("With char array " + Arrays.toString(charArr));

        List<Integer> numsList = new ArrayList<>();
        while (n > 0) {
            numsList.add(n % 10);   //Norm way
            n /= 10;
        }
        Collections.reverse(numsList);
        System.out.println("With list and reverse " +numsList);

        int[] numsArr = new int[getNumberOfDigitsInInt(n2)];
        for(int i = numsArr.length-1; i >= 0; i--)
        {
            numsArr[i]=n2 % 10;    //PogU way
            n2 /= 10;
        }

        System.out.println("With calc of digits and a primitive array " + Arrays.toString(numsArr));
    }
*/

    public void task15() {
        int a = kuz.getRandomIntInRange(0, 10000);
        int b = kuz.getRandomIntInRange(0, 10000);


    }



    private int addByKarasuba(int a, int b){
        return 0;
    }

    private int subtractByKarasuba(int a, int b){
        return 0;
    }
    private int multiplyByKarasuba(int a, int b){
        return 0;
    }



    private int getNumberOfDigitsInInt(int number) {

        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }

    }

    private List<Integer> createNumberList(int num) {
        Integer[] intNumbers = new Integer[num];
        for (int i = 0; i < intNumbers.length; i++) {
            intNumbers[i] = kuz.getRandomIntInRange(0, 100);
        }
        return new ArrayList<>(List.of(intNumbers));
    }

    private List<Character> createCharList(int num) {
        Character[] charArray = new Character[num];

        for (int i = 0; i < charArray.length; i++) {
            char a = (char) kuz.getRandomIntInRange(97, 122);
            charArray[i] = a;
        }
        return new ArrayList<>(List.of(charArray));
    }


    private boolean isAPerfectSquare(Integer num) {

        for (int i = 1; i * i <= num; i++) {
            if (num.equals(i * i))
                return true;
        }
        return false;
    }


    private int intSum(List<Integer> nums, int n) {
        if (n <= 0) {
            return 0;
        }

        return intSum(nums, n - 1) + nums.get(n - 1);

    }
}
