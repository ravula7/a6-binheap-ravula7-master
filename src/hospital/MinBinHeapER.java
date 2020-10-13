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
    //are left and right valid indexes?
    public V dequeue() {
        if (_heap.size() == 0) {
            return null;
        }
        if (_heap.size() == 1) {
            V dequeuedValue = (V) _heap.get(0);//size is 1
            _heap.remove(0); //size is 0 (has decremented by 1)
            return dequeuedValue;
        }
        if (_heap.size() == 2) {
            V dequeuedValue = (V) _heap.get(0); //size is 2
            _heap.remove(0); //now size is 1
            _heap.add(0, _heap.get(1)); //replace - size is 2
            _heap.remove(1); //size back to 1 (has decremented by 1)
            return dequeuedValue;
        }
        if (_heap.size() > 2) {
            V dequeuedValue = (V) _heap.get(0); //original size = n
            //fix the invariants
            _heap.remove(0); //size-1=n-1
            _heap.add(0, _heap.get(size())); //replace - size is n
            _heap.remove(size()); //size back to n-1 (has decremented by 1)

            int currentIndex = 0;
            int leftIndex = (currentIndex * 2) + 1;
            int rightIndex = (currentIndex * 2) + 2;

            //while not a leaf
            while (_heap.get(leftIndex) != null || _heap.get(rightIndex) != null) {
                //left and right child
                if (_heap.get(leftIndex) != null && _heap.get(rightIndex) != null) {
                    //when left is smaller than current
                    if (_heap.get(leftIndex).getPriority().compareTo(_heap.get(rightIndex).getPriority()) < 0) {
                        if (_heap.get(leftIndex).getPriority().compareTo(_heap.get(currentIndex).getPriority()) < 0) {
                            //swap left and current value
                            Patient<V, P> tmp = (Patient) _heap.get(leftIndex);
                            _heap.set(leftIndex, _heap.get(currentIndex));
                            _heap.set(currentIndex, tmp);
                            //update indexes
                            currentIndex = leftIndex;
                            leftIndex = (currentIndex * 2) + 1;
                            rightIndex = (currentIndex * 2) + 2;
                        } else {
                            break;
                        } //while loop will end once children are not less than current
                    }
                    //when right is smaller than current
                    if (_heap.get(rightIndex).getPriority().compareTo(_heap.get(leftIndex).getPriority()) < 0) {
                        if (_heap.get(rightIndex).getPriority().compareTo(_heap.get(currentIndex).getPriority()) < 0) {
                            //swap right and current value
                            Patient<V, P> tmp = (Patient) _heap.get(rightIndex);
                            _heap.set(rightIndex, _heap.get(currentIndex));
                            _heap.set(currentIndex, tmp);
                            //update indexes
                            currentIndex = rightIndex;
                            leftIndex = (currentIndex * 2) + 1;
                            rightIndex = (currentIndex * 2) + 2;
                        } else {
                            break;
                        } //while loop will end once children are not less than current
                    }
                }
                //left child
                if (_heap.get(leftIndex) != null && _heap.get(rightIndex) == null) {
                    //when left is smaller than current
                    if (_heap.get(leftIndex).getPriority().compareTo(_heap.get(currentIndex).getPriority()) < 0) {
                        //swap left and current value
                        Patient<V, P> tmp = (Patient) _heap.get(leftIndex);
                        _heap.set(leftIndex, _heap.get(currentIndex));
                        _heap.set(currentIndex, tmp);
                        //update indexes
                        currentIndex = leftIndex;
                        leftIndex = (currentIndex * 2) + 1;
                        rightIndex = (currentIndex * 2) + 2;
                    } else {
                        break;
                    } //while loop will end once children are not less than current or when there is no left or right child
                }
            } //while loop will end once leaf
            return dequeuedValue;
        }
        return null;
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
