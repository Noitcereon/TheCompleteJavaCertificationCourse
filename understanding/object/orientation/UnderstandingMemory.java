package understanding.object.orientation;

/**
 * A class made for "Lecture 12: Java Stack and Heap with Reference Variables".
 * Memory is split into two things: Stack and Heap memory. This class goes step by step through what happens with memory,when
 * reading the code comments.
 */
public class UnderstandingMemory {
    public static void main(String[] args) {
        // When running the main() function, a Frame on the Stack is created, henceforth I will refer to it as "main() Frame".
        int aNumber = 5; // aNumber (and other primitive variables) is defined inside the main() Frame.
        doWork(); // Calling another method adds a new Frame to the Stack with its associated primitive variables.
        // Since, we're out of 'doWork()', it is "popped" off the Stack.
        Car myCar; // The myCar reference variable is created in the main() Frame.
        myCar = new Car(5); // myCar references an object/instance created on the Heap by 'new Car(5);'
        myCar = new Car(2); // myCar is reassigned to reference a new object created on the __Heap__.
        // The old object/instance on the Heap waits to be cleaned up by the Garbage Collector.
        CarWithEngine myCar2 = new CarWithEngine();  // Creates myCar2 in main() Frame.
        myCar2.horsePower = 100; // Assigns the value '100' to the Instance Variable 'horsePower' to myCar2's instance (in Heap).
        CarWithEngine myCar3 = new CarWithEngine(1000); // Assigns the value '1000' to the Instance Variable 'horsePower' in the CarWithEngine object on the Heap.
        // Note: myCar2 and myCar3 reference different instances, which is why the horsePower instance variable is not the same value.
        // We still do not have an engine in the two CarWithEngine instances.
        Engine bigEngine = new Engine(); // creates bigEngine Reference Variable in the main() Frame + an instance of Engine on the Heap.
        myCar3.engine = bigEngine; // This makes the CarWithEngine object (referenced to by myCar3) reference to the Engine object on the Heap associated with bigEngine.
    }
    public static void doWork(){
        int anotherNumber = 2; // anotherNumber is inside the 'arbitrarilyNamedMethod' Frame on the Stack. (aside: Execution Context)
        // Any additional method calls in a method adds a Frame to the Stack.
    }

}
class Car{
    int horsePower;
    public Car() {
        // To have a default Car with horsepower 0.
    }
    public Car(int horsePower) {
        this.horsePower = horsePower;
    }
}
class CarWithEngine {
    public CarWithEngine() {
        // To have a default Car with horsepower 0.
    }

    public CarWithEngine(int horsePower) {
        this.horsePower = horsePower;
    }
    int horsePower;
    Engine engine;

}
class Engine{

}
