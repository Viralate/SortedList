import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String element) {
        int position = binarySearchForInsert(element);
        list.add(position, element);
    }

    public int binarySearchForInsert(String element) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).compareTo(element) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int binarySearch(String element) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = list.get(mid).compareTo(element);
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -low - 1; // Negative indicates the index for insertion
    }

    public ArrayList<String> getList() {
        return list;
    }
}
