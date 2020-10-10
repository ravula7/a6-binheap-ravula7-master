package hospital;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    //1a) Fill in the dequeue method to find the patient with the smallest priority using
   // a For-each loop. Return that patient and remove them from the list.
//_head.get(0).getValue()
    //

//constructor
    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    // TODO: dequeue
    public Patient dequeue() {

        //result is whatever is at index 0 which is guaranteed to be the smallest item
        Patient min = patients.remove(0);

        //move item at end of list to index 0 - list becomes one smaller
        int lastIndex = (patients.size())-1;
        Patient lastItem = patients.get(lastIndex);
        patients.add(0,lastItem);
        patients.remove(lastIndex);

        //bubble down
        //set current index to 0
        int currentIndex = 0;

       //while current index is not a leaf
       







        return min;
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}
