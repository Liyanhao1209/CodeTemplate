package util.List;

import java.util.ArrayList;

public class SortedList <T extends Comparable<T>>{
    private final ArrayList<T> list;

    public SortedList(){
        list = new ArrayList<>();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public T get(int index){
        return list.get(index);
    }

    public T remove(int index){
        return list.remove(index);
    }

    public boolean remove(T element) {
        int left = 0;
        int right = list.size() - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = list.get(mid).compareTo(element);
            if (comparison == 0) {
                // 找到元素，记录索引
                index = mid;
                break;
            } else if (comparison < 0) {
                // 如果mid位置的元素小于目标元素，搜索右半部分
                left = mid + 1;
            } else {
                // 如果mid位置的元素大于目标元素，搜索左半部分
                right = mid - 1;
            }
        }

        // 如果找到了元素，则删除它并返回true
        if (index != -1) {
            list.remove(index);
            return true;
        }

        // 如果没有找到元素，返回false
        return false;
    }

    public void insert(T element) {
        int index = findInsertionIndex(element);
        list.add(index, element);
    }

    private int findInsertionIndex(T element) {
        int left = 0;
        int right = list.size() - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).compareTo(element) < 0) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index + 1;
    }
}
