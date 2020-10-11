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
         int currentIndex = _heap.size()-1; //wherever the new object was just added, this is the current index
         _heap.add(currentIndex, new Prioritized<V, P>() { //adding the new object (value and priority added to respective lists)
             @Override
             public V getValue() {
                 return null;
             }

             @Override
             public P getPriority() {
                 return null;
             }
         });

         while(currentIndex>0){
            int parentIndex = (currentIndex-1)/2;
         if(_heap.get(currentIndex).getPriority().compareTo(_heap.get(parentIndex).getPriority())<0){
             Prioritized<V,P> tmp = _heap.get(currentIndex);
             _heap.add(currentIndex,_heap.get(parentIndex));
             _heap.add(parentIndex,tmp);

            // tmp = _heap.get(parentIndex);
            // V parentValue = _heap.get(parentIndex).getValue();
            // Prioritized<V,P> tmp = (Prioritized<V, P>) currentValue;



            // _heap.get(currentIndex).getValue() = _heap.get(parentIndex).getValue();
            // _heap.get(parentIndex).getValue() = tmp;

            //at current index, set parent value
            //at parent index, set current value




            // Prioritized<V,P> tmp = (Prioritized<V, P>) value;
            // value = _root_value;
            // _root_value = tmp;
             //Prioritized<V,P> tmp = _heap.get(currentIndex);
           //  _heap.remove(currentIndex);
           //  _heap.add(currentIndex,_heap.get(parentIndex));
           //  _heap.add(parentIndex,_heap.get(currentIndex));


           //  tmp = _heap.get(parentIndex);

             currentIndex=parentIndex; //while loop exits once the parent index is 0 OR
         }                              //when the current value isn't less than the root
         else{
             break;
         }

        }
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
