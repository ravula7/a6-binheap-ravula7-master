package hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
    public V dequeue() {
        if (_heap.size() == 0) {
            return null;
        }
        else if (_heap.size() != 0) {
            V dequeuedValue = (V) _heap.get(0);
            _heap.remove(0);

            if (_heap.size() == 0) {
                return dequeuedValue;
            }

            else if (_heap.size() != 0) {
                int lastIndex = (_heap.size()) - 1;
                Patient replaceItem = (Patient) _heap.get(lastIndex);
                _heap.add(0, replaceItem);
                _heap.remove(lastIndex);

                int currentIndex = 0;
                int leftIndex = (2 * currentIndex) + 1;
                int rightIndex = (2 * currentIndex) + 2;
               // Patient leftChild = (Patient) _heap.get(leftIndex);
                //Patient rightChild = (Patient) _heap.get(rightIndex);

                while (_heap.get(leftIndex)!= null || _heap.get(rightIndex) != null) {
                    leftIndex = (2 * currentIndex) + 1;
                    rightIndex = (2 * currentIndex) + 2;
                    if (_heap.get(leftIndex) != null && _heap.get(rightIndex) != null) {
                        //left child is less than right
                        if (_heap.get(leftIndex).getPriority().compareTo(_heap.get(rightIndex).getPriority()) < 0) { //left is smaller than right
                            if (_heap.get(leftIndex).getPriority().compareTo(_heap.get(0).getPriority()) < 0) { //left is smaller than current
                                //swap
                                Patient tmp = (Patient) _heap.get(currentIndex);
                                _heap.set(currentIndex, _heap.get(leftIndex));
                                _heap.set(leftIndex,tmp);
                                currentIndex = leftIndex;
                            } else {
                                break;
                            }
                        }
                        //right child is less than left
                        else if (_heap.get(rightIndex).getPriority().compareTo(_heap.get(leftIndex).getPriority()) < 0) { //right is smaller than left
                            if (_heap.get(rightIndex).getPriority().compareTo(_heap.get(0).getPriority()) < 0) { //right is smaller than current
                                //swap rightChild and replaceItem
                                Patient tmp = (Patient) _heap.get(currentIndex);
                                _heap.set(currentIndex, _heap.get(rightIndex));
                                _heap.set(rightIndex,tmp);
                                currentIndex = rightIndex;
                            } else {
                                break;
                            }
                        }
                    } else if (_heap.get(leftIndex) != null && _heap.get(rightIndex) == null) {
                        if (_heap.get(leftIndex).getPriority().compareTo(_heap.get(0).getPriority()) < 0) { //left is smaller than current
                            //swap leftChild and replaceItem
                            Patient tmp = (Patient) _heap.get(currentIndex);
                            _heap.set(currentIndex, _heap.get(leftIndex));
                            _heap.set(leftIndex,tmp);
                            currentIndex = leftIndex;
                        } else {
                            break;
                        }
                    }
                }
                return dequeuedValue;
            }
        } return null;
    }


    // TODO: getMin
    @Override
    public V getMin() {
        return _heap.get(0).getValue();
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V, P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }


}
