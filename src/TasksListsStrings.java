import kuzLib.kuz;

import java.lang.reflect.Parameter;
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

*/
    public void task9(){
        List<Integer> nums = createNumberList();
        nums.sort(Integer::compare);
        List<Character> letters = createCharList();
        letters.sort(Character::compare);
        List<Object> result = new ArrayList<>();

        for(int i = 0; i < nums.size(); i++)
        {
            result.add(nums.get(i));
            result.add(letters.get(i));
        }
        System.out.println(result);
    }



    private List<Integer> createNumberList()
    {
        Integer[] intNumbers = new Integer[10];
        for(int i =0; i < intNumbers.length;i++)
        {
            intNumbers[i] = kuz.getRandomIntInRange(0,100);
        }
        return new ArrayList<>(List.of(intNumbers));
    }

    private List<Character> createCharList()
    {
        Character [] charArray = new Character[10];

        for(int i=0; i < charArray.length;i++)
        {
            char a = (char)kuz.getRandomIntInRange(97,122);
            charArray[i] = a;
        }
        return new ArrayList<>(List.of(charArray));
    }


    private boolean isAPerfectSquare(Integer num) {

        for(int i = 1; i * i <= num; i++) {
            if (num.equals(i*i))
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
