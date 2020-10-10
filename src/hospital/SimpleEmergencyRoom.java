package hospital;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients; // V and int


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
        int minIndex = 0;
        Patient minPriorityValue = patients.get(minIndex);

        for(int i=1;i<patients.size();i++) {
          if(patients.get(i).getPriority().compareTo(minPriorityValue.getPriority())<0) {
                minIndex = i;
                minPriorityValue = patients.get(i);
            }
        }

         Patient dequeuedValue = patients.get(minIndex);
         patients.remove(minIndex);




        /* Psuedocode
            1) set the minimum priority value to whatever is at index 0 for now
            2) at each index, check if the priority value there is less than the minimum priority value
                if it is, set that as the new minPriorityValue
                if not, nothing happens - move on to next index
                by the end of this, the minimum value of the list will be stored as minPriorityValue
         */



        return dequeuedValue;
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
