# Enum

1. Basic Enum

    UserStatus.java
    ```java
    public enum UserStatus {
        PENDING,
        ACTIVE,
        INACTIVE,
        DELETED;
    }
    ```
    
    Test.java
    ```java
    public class Test {
    
        public static void main(String[] args) {
    
            //ACTIVE
            System.out.println(UserStatus.ACTIVE);
    
        }
    
    }
    ```
 
2. Enum + Instance field

    ```java
    //WhoisRIR.java
    public enum WhoisRIR {
    
        ARIN("whois.arin.net"),
        RIPE("whois.ripe.net"),
        APNIC("whois.apnic.net"),
        AFRINIC("whois.afrinic.net"),
        LACNIC("whois.lacnic.net"),
        JPNIC("whois.nic.ad.jp"),
        KRNIC("whois.nic.or.kr"),
        CNNIC("ipwhois.cnnic.cn"),
        UNKNOWN("");
    
        private String url;
    
        WhoisRIR(String url) {
            this.url = url;
        }
    
        public String url() {
            return url;
        }
    }
    
    //Test.java
    public class Test {
        public static void main(String[] args) {
            //whois.arin.net
            System.out.println(WhoisRIR.ARIN.url());
        }
    }
    ```
 
3. Enum + Method + Some logic

    ```java
    //Operation.java
    public enum Operation {
    
        PLUS,
        MINUS,
        TIMES,
        DIVIDE;
    
        double calculate(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
                default:
                    throw new AssertionError("Unknown operations " + this);
            }
        }
    
    }
    //Test.java
    public class Test {
        public static void main(String[] args) {
            double result = Operation.PLUS.calculate(1, 2);
            System.out.println(result); //3.0
        }
    }
    ```

4. How to use Enum

* To loop a Enum object.

    ```java
    public class Test {
        public static void main(String[] args) {
            for (UserStatus status : UserStatus.values()) {
                System.out.println(status);
            }
        }
    }
    ```
    
    Output:
    ```bash
    PENDING
    ACTIVE
    INACTIVE
    DELETED
    ```

* To compare the Enum values, use == operator.

    ```java
    public class Test {

        public static void main(String[] args) {

            WhoisRIR rir = WhoisRIR.APNIC;

            if(rir == WhoisRIR.APNIC) {
                System.out.println("This is APNIC : " + rir.url());
            }

        }

    }
    ```
    
    Output:
    ```bash
    This is APNIC : whois.apnic.net
    ```

* Switch case.

    ```java
    public class Test {

        public static void main(String[] args) {

            WhoisRIR rir = WhoisRIR.RIPE;

            switch (rir) {
                case ARIN:
                    System.out.println("This is ARIN");
                    break;
                case APNIC:
                    System.out.println("This is APNIC");
                    break;
                case RIPE:
                    System.out.println("This is RIPE");
                    break;
                default:
                    throw new AssertionError("Unknown RIR " + rir);

            }

        }
    }
    ```

    Output
    ```bash
    This is RIPE
    ```

* Convert a String to Enum object.

    ```java
    public class Test {
        public static void main(String[] args) {
            //enum valueOf + uppercase
            Operation op = Operation.valueOf("times".toUpperCase());
            System.out.println(op.calculate(10, 3));
        }
    }
    ```
    
    Output:
    ```bash
    30.0
    ```
    
    
[CODE](https://github.com/guyc1812/Tony/blob/master/src/main/java/com/avengers/tony/JavaBasic/enums/code)
