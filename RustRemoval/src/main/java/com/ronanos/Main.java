package com.ronanos;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

        Main app = new Main();
        app.testArray();
        app.testLargest();

    }


    /*
Given an array of integers, return the first value
that appears more than once.

Return -1 if every value is unique.

Examples:

{2, 1, 3, 5, 3, 2} -> 3
{1, 2, 3, 4}       -> -1
{7, 7}             -> 7
*/
    int firstDuplicate(int[] numbers) {
        Set<Integer> seen = new HashSet<>();

        for (int number: numbers) {
            if (seen.contains(number)) {
                return number;
            }
            seen.add(number);
        }
        return -1;
    }

    int oldFirstDuplicate(int[] numbers) {
        int retVal = -1;
        int yPos = -1;
        for (int x = 0; x < numbers.length; x++)
        {
            for (int y = x+1; y < numbers.length; y++)
            {
                if ((numbers[y]==numbers[x])) {
                    System.out.println("x is: " + x + " and y is:" + y);
                    System.out.println("numbers[x]: " + numbers[x] + " numbers[y]:"  + y);
                    if (retVal == -1 ) {
                        retVal = numbers[y];
                        yPos = y;
                    }  else if (y < yPos) {
                        retVal = numbers [y];
                        yPos = y;
                    }
                }
            }
        }
        return retVal;
        // your code
    }

    void testArray() {
        int myArray[] = {2, 1, 3, 5, 3, 2};
        int mySecondArray[] = {1, 2, 3, 4};
        int myThirdArray[] ={7, 7};

        int retFirstVal = firstDuplicate(myArray);
        int retSecondVal = firstDuplicate(mySecondArray);
        int retThirdVal = firstDuplicate(myThirdArray);

        System.out.println("Return Value is:" + retFirstVal + " Second: " + retSecondVal + " Third: " + retThirdVal);
    }


    /*
Given an array of integers, return the second largest DISTINCT value.

Return -1 if there is no second distinct largest value.

Examples:

{4, 1, 7, 3, 7} -> 4
{5, 5, 5}       -> -1
{2, 9}          -> 2
{10, 3, 8, 8}   -> 8
*/
    int secondLargest(int[] numbers) {
        // your code
        Set<Integer> seenAlready = new HashSet<>();
        Set<Integer> distinctValues = new HashSet<>();

        for (int number: numbers) {

            if ( !seenAlready.contains(number)) {
                distinctValues.add(number);
            }
            seenAlready.add(number);
        }

        List<Integer> values = new ArrayList<>(distinctValues);
        Collections.sort(values);

        if (values.size() > 1) {
            return values.get(values.size() - 2);
        } else {
            return -1;
        }
    }

    void testLargest() {
        int firstArray[] = {4, 1, 7, 3, 7};// -> 4
        int secondArray[] = {5, 5, 5};//       -> -1
        int thirdArray[] = {2, 9};//          -> 2
        int fourthArray[] = {10, 3, 8, 8};//   -> 8

        System.out.println("First Array is: " + Arrays.toString(firstArray) + " value is: " + secondLargest(firstArray));
        System.out.println("Second Array is: " + Arrays.toString(secondArray)+ " value is: " + secondLargest(secondArray));
        System.out.println("Third Array is: " + Arrays.toString(thirdArray)+ " value is: " + secondLargest(thirdArray));
        System.out.println("Fourth Array is: " + Arrays.toString(fourthArray)+ " value is: " + secondLargest(fourthArray));
    }



}