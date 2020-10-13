package hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class MinBinHeapER<V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V, P>> _heap;

    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MinBinHeapER() {
        _heap = new ArrayList<Prioritized<V, P>>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO: overloaded constructor
    public MinBinHeapER(Prioritized<V, P>[] initialEntries) {
        _heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        if (_heap.size() == 0) {
            _heap.add(new Patient<>(value, priority));
        } else {
            _heap.add(new Patient<>(value, priority));
            int currentIndex = _heap.size() - 1;
            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                Patient<V, P> current = (Patient<V, P>) _heap.get(currentIndex);
                Patient<V, P> parent = (Patient<V, P>) _heap.get(parentIndex);

                if (current.getPriority().compareTo(parent.getPriority()) < 0) {
                    Patient<V, P> tmp = current;
                    _heap.set(currentIndex, parent);
                    _heap.set(parentIndex, tmp);
                    currentIndex = parentIndex;
                } else if (current.getPriority().compareTo(parent.getPriority()) > 0) {
                    break;
                }
            }
        }
    }

    // TODO: enqueue
    public void enqueue(V value) {
        if (_heap.size() == 0) {
            _heap.add(new Patient<>(value));
        } else {
            _heap.add(new Patient<>(value));
            int currentIndex = _heap.size() - 1;

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1 / 2);
                Patient current = (Patient) _heap.get(currentIndex);
                Patient parent = (Patient) _heap.get(parentIndex);

                if (current.getPriority().compareTo(parent.getPriority()) < 0) {
                    Patient tmp = current;
                    _heap.set(currentIndex, parent);
                    _heap.set(parentIndex, tmp);
                    currentIndex = parentIndex;
                } else if (current.getPriority().compareTo(parent.getPriority()) > 0)
                    break;
            }
        }
    }


    // TODO: dequeue
    @Override
    //are left and right valid indexes?
    public V dequeue() {
        if (_heap.size() == 0) {
            return null;
        }
        //when heap isn't empty
        //get value at 0, set value at 0 to last item, remove last item so no repeats
        V dequeuedValue = _heap.get(0).getValue();
        _heap.set(0,_heap.get(size()-1));
        _heap.remove(_heap.size()-1); //size is now decremented by 1

        //calculate indexes to check what can replace the value at currentIndex if needed through swap
        int currentIndex = 0;
       // int leftIndex = (currentIndex*2)+1;
        //int rightIndex = (currentIndex*2)+2;

        //while leaf --> left index isn't valid (which means there is no left leaf, so why would there be a right leaf)
        while(!((currentIndex*2)+1 >= size()-1)){
            //only left child
            if(((currentIndex*2)+1 == size()-1)){ //if left index is at the end
                //if left child is less than current child, swap
                if(_heap.get((currentIndex*2)+1).getPriority().compareTo(_heap.get(currentIndex).getPriority())<0){
                    Collections.swap(_heap, currentIndex, (currentIndex*2)+1);
                    currentIndex = (currentIndex*2)+1;
                }
                //if that's not the case, then break -- invariants have been fixed
                else{
                    break;
                }
            }
            //both left and right children
            else {
                //if left value is less than right value and current value, then swap. else break
                if(_heap.get((currentIndex*2)+1).getPriority().compareTo(_heap.get((currentIndex*2)+2).getPriority())<0){
                    if(_heap.get((currentIndex*2)+1).getPriority().compareTo(_heap.get(currentIndex).getPriority())<0){
                        Collections.swap(_heap,currentIndex,(currentIndex*2)+1);
                        currentIndex = (currentIndex*2)+1;
                    }
                    else{
                       break;
                    }
                }
                //otherwise, right value is less than left value
                else {
                    //if right value is less than current value, then swap. else break
                    if(_heap.get((currentIndex*2)+2).getPriority().compareTo(_heap.get(currentIndex).getPriority()) <0){
                        Collections.swap(_heap, currentIndex,(currentIndex*2)+2);
                        currentIndex = (currentIndex*2)+2;
                    }
                    else {
                       break;
                    }
                }
            }
        }
        //return the dequeued value now that all of the invariants are fixed
        return dequeuedValue;
    }


    // TODO: getMin
    @Override
    public V getMin() {
        if (_heap.size() == 0) {
            return null;
        }
        return _heap.get(0).getValue();
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V, P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }


}
