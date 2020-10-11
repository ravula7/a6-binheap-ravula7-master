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
        _heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        if (_heap == null) {
            int currentIndex = 0;
            _heap.add(currentIndex, new Patient<>(value, priority));
        }
        else {
            int currentIndex = _heap.size() - 1; //wherever the new object was just added, this is the current index (last index)
            //adding the new object (patient) (value and priority added to respective lists) to the end of the list
            _heap.add(currentIndex, new Patient<>(value, priority));

            //bubble up (if needed)
            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2; //find parent of current

                Patient<V, P> current = (Patient<V, P>) _heap.get(currentIndex); //current patient stored in case swap is necessary
                Patient<V, P> parent = (Patient<V, P>) _heap.get(parentIndex); //parent patient stored in case swap is necessary

                if (_heap.get(currentIndex).getPriority().compareTo(_heap.get(parentIndex).getPriority()) < 0) { //current priority is smaller than parent priority - need to swap!
                    //perform swap
                    //tmp stores the value at current index so that it doesn't get overridden when you set parent value at current index in the next step
                    Patient<V, P> tmp = current;
                    current = parent;
                    parent = tmp;

                    // Patient <V,P> tmp = (Patient<V, P>) _heap.get(currentIndex);
                    //_heap.set(currentIndex,(Patient<V, P>) _heap.get(parentIndex));
                    // _heap.set(parentIndex,tmp);

                    currentIndex = parentIndex; //while loop exits once the parent index is 0 OR
                }//when the current value isn't less than the root
                else {
                    break;
                }
            }
        }
    }

    // TODO: enqueue
    public void enqueue(V value) {
        if (_heap == null) {
            int currentIndex = 0;
            _heap.add(currentIndex, new Patient<>(value));
        }
        else {
            int currentIndex = _heap.size() - 1;
            _heap.add(currentIndex, new Patient<>(value));

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1 / 2);
                Patient current = (Patient) _heap.get(currentIndex);
                Patient parent = (Patient) _heap.get(parentIndex);
                if (_heap.get(currentIndex).getPriority().compareTo(_heap.get(parentIndex).getPriority()) < 0) {
                    Patient tmp = current;
                    current = parent;
                    parent = tmp;
                } else {
                    break;
                }
                currentIndex = parentIndex;

            }
        }

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
     //  return _heap.get(0).getValue();
        return null;
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }






}
