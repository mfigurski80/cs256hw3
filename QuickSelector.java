import java.util.ArrayList;
import java.util.Collections;

public class QuickSelector<T extends Comparable<? super T>> {
    public T quickSelect(ArrayList<T> array, int index){
        if (array.size() == 1) {
            return array.get(0);
        }

        T median = medianOfMedians(array);
        ArrayList<T> left = new ArrayList<T>();
        ArrayList<T> right = new ArrayList<T>();
        for (T el : array) {
            if (el.compareTo(median) >= 0) {
                right.add(el);
            } else if (el.compareTo(median) < 0) {
                left.add(el);
            }
        }
        System.out.print(median);
        System.out.print(left);
        System.out.println(right);

        if (left.size() == index) {
            return median;
        } else if (left.size() > index) {
            return quickSelect(left, index);
        }
        return quickSelect(right, index - left.size());
    }

    public T medianOfMedians(ArrayList<T> array){
        if (array.size() <= 5) {
            return findMedian(array);
        }

        ArrayList<T> medians = new ArrayList<T>();
        for (int i = 0; i < array.size() - 5; i += 5) {
            ArrayList<T> sublist;
            if (i - array.size() >= 5) {
                sublist = new ArrayList<T>(array.subList(i, i + 5));
            } else {
                sublist = new ArrayList<T>(array.subList(i, array.size()));
            }
            medians.add(findMedian(sublist));
        }
        return medianOfMedians(medians);
    }

    private T findMedian(ArrayList<T> array) {
        Collections.sort(array);
        return array.get(array.size() / 2);
    }

    public static void main(String[] args) {
        QuickSelector<Integer> a = new QuickSelector<Integer>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(6);
        array.add(2);
        array.add(3);
        array.add(8);
        array.add(6);

        array.add(0);
        array.add(4);
        array.add(7);
        array.add(7);
        array.add(8);

        System.out.println(a.quickSelect(array, 8));
    }
}
