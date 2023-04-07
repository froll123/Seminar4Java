/*Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.*/

import java.util.LinkedList;

public class prog1 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        System.out.println("Исходный список: " + list);
        LinkedList<String> reversedList = reverseLinkedList(list);
        System.out.println("Перевернутый список: " + reversedList);
    }

    public static LinkedList<String> reverseLinkedList(LinkedList<String> list) {
        LinkedList<String> reversedList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            String element = list.get(i);
            reversedList.add(element);
        }
        return reversedList;
    }
}