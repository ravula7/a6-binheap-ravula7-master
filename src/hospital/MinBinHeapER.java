package hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MinBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO: overloaded constructor
    public MinBinHeapER(Prioritized<V, P>[] initialEntries ) {

    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {

    }

    // TODO: enqueue
    public void enqueue(V value) {
    }

    // TODO: dequeue
    @Override
    public V dequeue() {
        //result is whatever is at index 0 which is guaranteed to be the smallest item


        //move item at end of list to index 0 - list becomes one smaller
        // int lastIndex = (patients.size())-1;
        //Patient lastItem = patients.get(lastIndex);
        //patients.add(0,lastItem);
        //patients.remove(lastIndex);

        //bubble down
        //set current index to 0
        //  int currentIndex = 0;

        //while current index is not a leaf
        return null;
    }

    // TODO: getMin
    @Override
    public V getMin() {
       return null;
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }






}
