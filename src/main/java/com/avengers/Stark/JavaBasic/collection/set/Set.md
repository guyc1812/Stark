# Set


### Construction

* HashSet based on HashMap
* TreeSet based on TreeMap

### HashSet vs. TreeSet

* HashSet
    Class offers constant time performance for the basic operations (add, remove, contains and size).<br>
    It does not guarantee that the order of elements will remain constant over time.<br>
    Iteration performance depends on the initial capacity and the load factor of the HashSet.
    
* TreeSet
    Guarantees log(n) time cost for the basic operations (add, remove and contains).<br>
    Guarantees that elements of set will be sorted (ascending-natural, or the one specified by you via its constructor).<br>
    Offers a few handy methods to deal with the ordered set like first(), last(), headSet(), and tailSet() etc.

* Important points:
    Both guarantee duplicate-free collection of elements.<br>
    None of these implementation are synchronized. <br>
    It is generally faster to add elements to the HashSet and then convert the collection to a TreeSet.<br>
    ```java
    SortedSet<String> s = new TreeSet<String>(hashSet);
    ```