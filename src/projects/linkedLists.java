package projects;

import java.util.Iterator;
import java.util.LinkedList;

public class linkedLists {

    /*
    You will be given two linked lists in “reverse-digit” format. For example, the number 123 would be represented
    in a linked list like this: 3 → 2 → 1 You should return the sum of these two numbers in the same “reverse-digit”
    format. For 123 + 456, this should return 579, in the form of a linked list like this: 9 → 7 → 5.
     */

    public static LinkedList addLinkedLists (LinkedList firstLL, LinkedList secondLL) {

        Iterator<Integer> firstIterator = firstLL.descendingIterator();

        int firstLLInt = 0;
        int unit = 1;
        while (firstIterator.hasNext()) {
            firstLLInt += unit * firstIterator.next();
            unit *= 10;
        }

        Iterator<Integer> secondIterator = secondLL.descendingIterator();

        int secondLLInt = 0;
        while (secondIterator.hasNext()) {
            secondLLInt += unit * secondIterator.next();
            unit *= 10;
        }

        int sum = firstLLInt + secondLLInt;

        String s = String.valueOf(sum);

        LinkedList<Integer> summedLL = new LinkedList<>();

        for (int i = 0; i < s.length(); i += 1) {
            summedLL.add(Character.getNumericValue(s.charAt(i)));
        }
        return summedLL;
    }

//    public static void main(String[] args) {
//        LinkedList ll1 = new LinkedList();
//        LinkedList ll2 = new LinkedList();
//
//        ll1.add(3);
//        ll1.add(2);
//        ll1.add(1);
//
//        ll2.add(6);
//        ll2.add(5);
//        ll2.add(4);
//
//        System.out.println(addLinkedLists(ll1, ll2));
//    }

}
