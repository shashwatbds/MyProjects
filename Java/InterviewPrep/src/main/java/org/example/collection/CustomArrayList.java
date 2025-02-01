package org.example.collection;

import java.util.*;

public class CustomArrayList<E> {

    private Object[] data;
    private int size;
    private int modCount;
    private int capacity;

    //constructor
    public CustomArrayList() {
        data = new Object[10];
        size = 0;
        capacity = 10;
    }

    public CustomArrayList(int initialCapacity) throws IllegalArgumentException {
        if(initialCapacity > 0) {
            data = new Object[initialCapacity];
            size = 0;
            capacity = 10;
        } else if(initialCapacity == 0){
            data = new Object[10];
            size = 0;
            capacity = 10;
        } else {
            throw new IllegalArgumentException("Initial Capacity can not be less than 0");
        }
    }

    public CustomArrayList(Collection<? extends E> input) throws IllegalArgumentException {
        if(Objects.nonNull(input)) {
            Object[] arr = input.toArray();
            if((size = arr.length) != 0) {
                if(Objects.equals(input.getClass(), ArrayList.class)) {
                    this.data = arr;
                    capacity = 10;
                } else {
                    this.data = Arrays.copyOf(arr, capacity, Object[].class);
                }
            }
        } else {
            throw new IllegalArgumentException("Collection passed can not be null");
        }
    }

    //add - at the end
    public boolean add(E e) {
        modCount ++;
        if(this.size == this.data.length) {
            grow();
        }
        this.data[size] = e;
        size++;
        return true;
    }

    private Object[] grow() {
        int oldCapacity = this.data.length;
        if(oldCapacity > 0) {
            int newCapacity = oldCapacity << 1;
            capacity = newCapacity;
            return this.data = Arrays.copyOf(this.data, newCapacity);
        } else {
            return this.data = new Object[10];
        }
    }

    //remove - at the end
    public E remove(int index) {

        if(index < 0 || index > size()) {
            throw new IllegalArgumentException("");
        }
        E oldValue = (E) this.data[index];
        modCount++;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return oldValue;
    }

    //get
    public E get(int index) {
        if(index < 0 || index > size()) {
            throw new IllegalArgumentException("");
        }
        return (E) this.data[index];
    }
    //size
    public int size() {
        return this.size;
    }

    //isEmpty
    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> list1 = new CustomArrayList<>();
        System.out.println(list1.size());

        CustomArrayList<Integer> list2 = new CustomArrayList<>(5);
        System.out.println(list2.size());

        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        CustomArrayList<Integer> list3 = new CustomArrayList<>(list);
        System.out.println(list3.size());

        list3.add(5);
        System.out.println(list3.size());

        CustomArrayList<String> strings = new CustomArrayList<>();
        strings.add("Hello");
        System.out.println(strings.size());
        list3.remove(2);
        System.out.println(list3.size());

        System.out.println(strings.get(0));
    }
}
