# Java Conceptions


### Main 3 OOP concepts

1. Encapsulation

    Encapsulation is a mechanism by which developer could hide implementation behind an interface.<br>
    
    Encapsulated code has two features:<br>
    Instance variables are kept protected (usually with the private modifier).<br>
    Getter and setter methods provide access to instance variables.<br>
    Kindly take a look at tutorial: Complete End to End working Encapsulation example<br>
    The public setName() and getName() methods are the access points of the instance variables.

2. Inheritance

    Inheritance allows a class to be a subclass of a superclass, <br>
    and thereby inherit public and protected variables and methods of the superclass.<br>
    Inheritance is a key concept that underlies polymorphism, overriding, overloading and casting.

3. Polymorphism

    Polymorphism means “many forms.”<br>
    A reference variable is always of a single, unchangeable type, but it can refer to a subtype object.<br>
    A single object can be referred to by reference variables of many different types —as long as they are the same type or a supertype of the object.<br>
    Polymorphic method invocations apply only to overridden instance methods.


### Java classpath

The classpath is an environment variable. <br>
It is used to let the compiler know where the class files are available for import.


### Platform Independent Programming Language
 
Platform independence means that execution of your program does not dependent on type of operating system. <br>
So compile code only once and run it on any System (In C/C++, we need to compile the code for every machine on which we run it). 

Java is both compiler(javac) and interpreter(jvm) based language. <br>
Your java source code is first compiled into byte code using javac compiler. <br>
This byte code can be easily converted to equivalent machine code using JVM. 

JVM(Java Virtual Machine) is available in all operating systems we install. <br>
Hence, byte code generated by javac is universal and can be converted to machine code on any operating system, <br>
this is the reason why java is platform independent.


### Overloading and Overriding
    
* Method Overloading :

    In Method Overloading, <br>
    Methods of the same class shares the same name but each method must have different number of parameters or parameters having different types and order.<br>
    Method Overloading is to "add" or "extend" more to method’s behavior.<br>
    It is a compile time polymorphism.<br>
    The methods must have different signature.<br>
    It may or may not need inheritance in Method Overloading.<br>
    Let’s take a look at the example below to understand it better.<br>
    ```
    class Adder {
        Static int add(int a, int b) {
            return a+b;
        }
        Static double add( double a, double b) {
            return a+b;
        }
        public static void main(String args[]) {
            System.out.println(Adder.add(11,11));
            System.out.println(Adder.add(12.3,12.6));
        }
    }
    ```
    
* Method Overriding:  

    In Method Overriding, <br>
    sub class have the same method with same name and exactly the same number and type of parameters and same return type as a super class.<br>
    Method Overriding is to "Change" existing behavior of method.<br>
    It is a run time polymorphism.<br>
    The methods must have same signature.<br>
    It always requires inheritance in Method Overriding.<br>
    Let’s take a look at the example below to understand it better.<br>
    ```
    class Car {
    
        void run(){
            System.out.println(“car is running”); 
        }
    
        Class Audi extends Car{
            void run(){
                System.out.prinltn(“Audi is running safely with 100km”);
            }
        }
    
        public static void main( String args[]){
            Car b=new Audi();
            b.run();
        }
    }
    ```


### Immutable object

Immutable classes are Java classes whose objects can not be modified once created. <br>
Any modification in Immutable object result in new object. 

For example is String is immutable. <br>
Mostly Immutable are also final in Java, in order to prevent sub class from overriding.


### ThreadLocal class

A single ThreadLocal instance can store different values for each thread independently. <br>
Each thread that accesses the get() or set() method of a ThreadLocal instance is accessing its own, <br>
independently initialized copy of the variable. <br>
ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or transaction ID). <br>
The example below, from the ThreadLocal Javadoc, generates unique identifiers local to each thread. <br>
A thread’s id is assigned the first time it invokes ThreadId.get() and remains unchanged on subsequent calls.

```
public class ThreadId {
    // Next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
        new ThreadLocal<Integer>() {
            @Override protected Integer initialValue() {
                return nextId.getAndIncrement();
        }
    };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }
}
```

Each thread holds an implicit reference to its copy of a thread-local variable <br>
as long as the thread is alive and the ThreadLocal instance is accessible; <br>
after a thread goes away, <br>
all of its copies of thread-local instances are subject to garbage collection (unless other references to these copies exist).

 
### Keyword Final
 
Final keyword in java is used to restrict usage of variable, class and method.
 
* Variable: Value of Final variable is constant, you can not change it.
* Method: you can’t override a Final method.
* Class: you can’t inherit from Final class.


### Keyword super

The super keyword in java is a reference variable that is used to refer parent class objects. 
The keyword “super” came into the picture with the concept of Inheritance. 
Whenever you create the instance of subclass, an instance of parent class is created implicitly 
i.e. referred by super reference variable.
Various scenarios of using java super Keyword:

super is used to refer immediate parent instance variable
super is used to call parent class method
super() is used to call immediate parent constructor


### Keyword transient

During serialization process, transient variable states will not be serialized. 
State of the value will be always defaulted after deserialization.

 