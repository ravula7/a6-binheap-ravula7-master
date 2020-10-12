package hospital;

public class Main {

    public static void main(String[] args) {
        MinBinHeapER heap = new MinBinHeapER();
        heap.enqueue("hi",3);
        //heap.enqueue("bye",5);
        heap.dequeue();




        /*
        Part 1
        Find the average amount of time it takes to do 1 dequeue, in nanoseconds (hint: use a for loop).
        Record your average time in data.txt.
         */
       /* SimpleEmergencyRoom myEmergencyRoom = new SimpleEmergencyRoom();
        fillER(myEmergencyRoom);
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();
        myEmergencyRoom.dequeue();

        */






       /*
        Part 2
         */





        /*
        Part 3
         */
        MinBinHeapER transfer = new MinBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }

    }

    public static void fillER(MinBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }



}



