package com.example.demo.practise;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class LearningStream {

    // Question 1

    public static void questionFirst(){
        // Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        System.out.println("Question First");
        myList.stream().map( chracter -> chracter + "")
                .filter(chracter -> chracter.startsWith("1")).forEach(System.out::println);

    }

    public static void questionSecond(){
        // Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        System.out.println("Question Second");
        list.stream().filter( e -> e%2 == 0).forEach(System.out::println);

    }

    public static void questionThird(){
         //  How to find duplicate elements in a given integers list in java using Stream functions?

        System.out.println("Question Third");

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> mySet = new HashSet<>();

        myList.stream().filter( e -> !mySet.add(e)).forEach(System.out::println);

    }

    public static void questionFourth(){

        //  Given the list of integers, find the first element of the list using Stream functions?
        System.out.println("Question Fourth");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream().findFirst().ifPresent(System.out::println);

    }

    public static void questionFifth(){
        // Given a list of integers, find the total number of elements present in the list using Stream functions?
        System.out.println("Question Fifth");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        Long count = myList.stream().count();
        System.out.println(count);

    }

    public static void questionSixth(){

        // Given a list of integers, find the maximum value element present in it using Stream functions?

        System.out.println("Question Sixth");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        int max = myList.stream().max(Integer::compare).get();
        System.out.println(max);

    }

    public static void questionSeventh(){

        //  Given a String, find the first non-repeated character in it using Stream functions?
        System.out.println("Question Seventh");
        String input = "Java articles are Awesome";

        Optional<Character> result = input.chars() // Stream of String
                .mapToObj(c -> Character.toLowerCase((char) c)) // Convert to Character object and lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst();

        // Handle the absence of a result
        System.out.println(result.orElse(null));


    }

    public static void questionEighth(){
        // Given a String, find the first repeated character in it using Stream functions?
        System.out.println("Question Eightth");
        String input = "Java articles are Awesome";

        Optional<Character> firstReaptingCharacter = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst();

        System.out.println(firstReaptingCharacter.orElse(null));
    }

    public static void questionNinth(){
        // Given a list of integers, sort all the values present in it using Stream functions?

        System.out.println("Question Ninth");

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static void questionTenth(){

        // Given a list of integers, sort all the values present in it in descending order using Stream functions?
        System.out.println("Question Tenth");

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

    }

    public static void questionEleventh(){

        //Given an integer array nums, return true if any value appears at least twice in the array,
        // and return false if every element is distinct.

        System.out.println("Question Eleventh");

        int nums[] = {1,2,3,1};

        List<Integer> list = Arrays.stream(nums)
                .boxed().collect(Collectors.toList());

        Set<Integer> set = new HashSet<>(list);
        if (set.size() == nums.length) {
            System.out.println(false);
        }else System.out.println(true);


        Set<Integer> setData = new HashSet<>();
        System.out.println( Arrays.stream(nums)
                .anyMatch(num -> !setData.add(num)));


    }



    public static void main(String[] args) {

        questionFirst();
        questionSecond();
        questionThird();
        questionFourth();
        questionFifth();
        questionSixth();
        questionSeventh();
        questionEighth();
        questionNinth();
        questionTenth();
        questionEleventh();

        System.out.println("Main method started");

        List<Integer>  xList = List.of(4,5,6,7,8,9);


        // this is how stream work
        Stream<Integer> data = xList.stream();
        Stream<Integer> mappedDAta = data.map(x -> x * 2);
        mappedDAta.forEach(System.out::println);

        // wer can map this in a single line


        System.out.println("Created My Function");

        Function<Integer , Integer> xx = e-> e*2;
        xList.stream()
                .map(xx)
                .forEach(System.out::print);

        // lets filter the data

        System.out.println("Created My Function");

        xList.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .forEach(System.out::println);


        Stream<Integer> xStream = xList.stream();

        xStream.forEach(System.out::println);
        //       xStream.forEach(System.out::println);

        // Again using the stream will give the error,
        // Because stream can only be use once

        int[] arr = {4,3,6,3,5,6,4,6,8,6};

        LongStream arrStream = Arrays.stream(arr).asLongStream();
        System.out.println(Arrays.toString(arrStream.toArray()));







        List<String> name = List.of("Mayank" , "Sonu" ,"Tarun" , "Verma" , "Chahar" , "Suri");
        List<String> newNames = name.stream().filter(e -> e.startsWith("M")).collect(Collectors.toList());
        newNames.forEach(e -> System.out.println(e));


        List<Integer> number = List.of(2 ,4 ,6 ,7 ,9 ,0);
        List<Integer > newList = number.stream().map(integer -> integer * 10).collect(Collectors.toList());
        number.stream().map(integer -> integer * 10).forEach(System.out::println);
        newList.forEach(System.out::println);

        // Sort Function

        number.stream().sorted().forEach(System.out::println);

        Integer intn = number.stream().min((x,y) -> x.compareTo(y)).get();
        System.out.println("min " + intn);

        Integer intMax = number.stream().max((x,y) -> x.compareTo(y)).get();
        System.out.println("max " + intMax);
    }
}
