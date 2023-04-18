import interfaces.ListInterface;
import lists.LinkedList;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        testList(new LinkedList());
    }

    public static void testList(ListInterface list) {
        int N = 50;
        Random random = new Random();
        double number;
        Integer value = null;
        int index;

        for (int i = 0; i < N; i++) {
            number = random.nextDouble();
            if (number < 0.4) {
                value = random.nextInt(100);
                if (number < 0.2) {
                    list.add(value);
                    System.out.println("Dodano na końcu: " + value);
                } else {
                    index = random.nextInt(list.size() + 2) - 1;
                    try {
                        list.add(value, index);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e);
                    }
                    System.out.println("Dodano na pozycji: " + index + " wartość: " + value);
                }
            } else if (number < 0.8) {
                try {
                    index = random.nextInt(list.size() + 2) - 1;
                    System.out.println("Element usunięty z pozycji " + index + " to " + list.remove(index));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    index = random.nextInt(list.size() + 2) - 1;
                    System.out.println("Element na pozycji " + index + " to " + list.get(index));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e);
                }
            }
            if (number < 0.1) {
                System.out.println("Wyczyszczono listę");
                list.clear();
            }
            System.out.println(list);
        }
    }
}

