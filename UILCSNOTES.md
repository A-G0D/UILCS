1. [Example](#OOP)

---
### Order Of Operations (Greater = First, Associativity = Direction) <a name="OOP"></a>
| Level | Operator                                                                 | Description                       | Associativity   |
|-------|--------------------------------------------------------------------------|-----------------------------------|-----------------|
| 16    | `()` `[]` `new` `.` `::`                                                   | parentheses, array access, object creation, member access, method reference | left-to-right   |
| 15    | `++` `--`                                                                | unary post-increment, unary post-decrement | left-to-right   |
| 14    | `+` `-` `!` `~` `++` `--`                                                | unary plus, unary minus, unary logical NOT, unary bitwise NOT, unary pre-increment, unary pre-decrement | right-to-left   |
| 13    | `()` (cast)                                                              | cast                              | right-to-left   |
| 12    | `*` `/` `%`                                                              | multiplicative                    | left-to-right   |
| 11    | `+` `-` `+` (string concatenation)                                        | additive, string concatenation    | left-to-right   |
| 10    | `<<` `>>` `>>>`                                                          | shift                             | left-to-right   |
| 9     | `<` `<=` `>` `>=` `instanceof`                                            | relational                        | left-to-right   |
| 8     | `==` `!=`                                                                | equality                          | left-to-right   |
| 7     | `&`                                                                      | bitwise AND                       | left-to-right   |
| 6     | `^`                                                                      | bitwise XOR                       | left-to-right   |
| 5     | `\|`                                                                      | bitwise OR                        | left-to-right   |
| 4     | `&&`                                                                     | logical AND                       | left-to-right   |
| 3     | `\| \|`                                                                     | logical OR                        | left-to-right   |
| 2     | `?:`                                                                     | ternary                           | right-to-left   |
| 1     | `=` `+=` `-=` `*=` `/=` `%=` `&=` `^=` `\| =` `<<=` `>>=` `>>>=`           | assignment                        | right-to-left   |
| 0     | `->`                                                                     | lambda expression, switch expression | right-to-left   |
---

### 1. **Bubble Sort**
- **Time Complexity**:  
  - Fastest: \(O(n)\) (if already sorted)  
  - Average: \(O(n^2)\)  
  - Slowest: \(O(n^2)\)  
- **Explanation**: Repeatedly swaps adjacent elements if they are in the wrong order.
- **Code**:
```java
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

---

### 2. **Selection Sort**
- **Time Complexity**:  
  - Fastest: \(O(n^2)\)  
  - Average: \(O(n^2)\)  
  - Slowest: \(O(n^2)\)  
- **Explanation**: Finds the smallest element and places it at the beginning of the unsorted array.
- **Code**:
```java
public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
}
```

---

### 3. **Insertion Sort**
- **Time Complexity**:  
  - Fastest: \(O(n)\) (if already sorted)  
  - Average: \(O(n^2)\)  
  - Slowest: \(O(n^2)\)  
- **Explanation**: Builds the sorted array one element at a time by inserting elements into their correct positions.
- **Code**:
```java
public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

---

### 4. **Merge Sort**
- **Time Complexity**:  
  - Fastest: \(O(n \log n)\)  
  - Average: \(O(n \log n)\)  
  - Slowest: \(O(n \log n)\)  
- **Explanation**: Divides the array into halves, recursively sorts them, and then merges them back together.
- **Code**:
```java
public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
private static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];
    System.arraycopy(arr, left, L, 0, n1);
    System.arraycopy(arr, mid + 1, R, 0, n2);
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k++] = L[i++];
        } else {
            arr[k++] = R[j++];
        }
    }
    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}
```

---

### 5. **Quick Sort**
- **Time Complexity**:  
  - Fastest: \(O(n \log n)\)  
  - Average: \(O(n \log n)\)  
  - Slowest: \(O(n^2)\) (worst pivot choice)  
- **Explanation**: Partitions the array into two parts based on a pivot and recursively sorts them.
- **Code**:
```java
public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}
```

---

### 6. **Heap Sort**
- **Time Complexity**:  
  - Fastest: \(O(n \log n)\)  
  - Average: \(O(n \log n)\)  
  - Slowest: \(O(n \log n)\)  
- **Explanation**: Converts the array into a heap and repeatedly extracts the maximum element.
- **Code**:
```java
public static void heapSort(int[] arr) {
    int n = arr.length;
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }
}
private static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest]) largest = left;
    if (right < n && arr[right] > arr[largest]) largest = right;
    if (largest != i) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;
        heapify(arr, n, largest);
    }
}
```

---

### 7. **Counting Sort**
- **Time Complexity**:  
  - Fastest: \(O(n+k)\)  
  - Average: \(O(n+k)\)  
  - Slowest: \(O(n+k)\)  
- **Explanation**: Counts the frequency of each element and arranges them accordingly.
- **Code**:
```java
public static void countingSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    int[] count = new int[max + 1];
    for (int num : arr) count[num]++;
    int idx = 0;
    for (int i = 0; i < count.length; i++) {
        while (count[i]-- > 0) {
            arr[idx++] = i;
        }
    }
}
```

---

### 8. **Radix Sort**
- **Time Complexity**:  
  - Fastest: \(O(nk)\)  
  - Average: \(O(nk)\)  
  - Slowest: \(O(nk)\)  
- **Explanation**: Sorts based on individual digits, starting from the least significant to the most significant.
- **Code**:
```java
public static void radixSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    for (int exp = 1; max / exp > 0; exp *= 10)
        countingSortByDigit(arr, exp);
}
private static void countingSortByDigit(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10];
    for (int i : arr) count[(i / exp) % 10]++;
    for (int i = 1; i < 10; i++) count[i] += count[i - 1];
    for (int i = n - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }
    System.arraycopy(output, 0, arr, 0, n);
}
```

---

### 9. **Bucket Sort**
- **Time Complexity**:  
  - Fastest: \(O(n + k)\)  
  - Average: \(O(n + k)\)  
  - Slowest: \(O(n^2)\) (if buckets aren't distributed well)  
- **Explanation**: Distributes elements into buckets, sorts each bucket, and merges them.
- **Code**:
```java
public static void bucketSort(float[] arr) {
    int n = arr.length;
    List<Float>[] buckets = new List[n];
    for (int i = 0; i < n; i++) buckets[i] = new ArrayList<>();
    for (float num : arr) buckets[(int) (n * num)].add(num);
    for (List<Float> bucket : buckets) Collections.sort(bucket);
    int idx = 0;
    for (List<Float> bucket : buckets) {
        for (float num : bucket) arr[idx++] = num;
    }
}
```

---

### 10. **Tim Sort (Java’s Default Sort in Arrays.sort())**
- **Time Complexity**:  
  - Fastest: \(O(n)\)  
  - Average: \(O(n \log n)\)  
  - Slowest: \(O(n \log n)\)  
- **Explanation**: Hybrid sort combining Merge Sort and Insertion Sort.
- **Code**:
```java
Arrays.sort(arr); // Java's built-in TimSort implementation
```

---

### **Primitive Data Types in Java**

| **Data Type** | **Size**         | **Default Value**       | **Range** (Methods to Get Max/Min) |
|---------------|------------------|-------------------------|-------------------------------------|
| `byte`        | 1 byte (8 bits)  | `0`                     | \(-128\) to \(127\) (`Byte.MIN_VALUE` / `Byte.MAX_VALUE`) |
| `short`       | 2 bytes (16 bits)| `0`                     | \(-32,768\) to \(32,767\) (`Short.MIN_VALUE` / `Short.MAX_VALUE`) |
| `int`         | 4 bytes (32 bits)| `0`                     | \(-2^{31}\) to \(2^{31} - 1\) (`Integer.MIN_VALUE` / `Integer.MAX_VALUE`) |
| `long`        | 8 bytes (64 bits)| `0L`                    | \(-2^{63}\) to \(2^{63} - 1\) (`Long.MIN_VALUE` / `Long.MAX_VALUE`) |
| `float`       | 4 bytes (32 bits)| `0.0f`                  | ~\(-3.4E38\) to \(3.4E38\) (`Float.MIN_VALUE` for smallest positive non-zero, `-Float.MAX_VALUE` to `Float.MAX_VALUE` for range) |
| `double`      | 8 bytes (64 bits)| `0.0d`                  | ~\(-1.7E308\) to \(1.7E308\) (`Double.MIN_VALUE`, `Double.MAX_VALUE`) |
| `char`        | 2 bytes (16 bits)| `\u0000` (null char)    | `0` to `65,535` (`Character.MIN_VALUE` / `Character.MAX_VALUE`) |
| `boolean`     | 1 bit            | `false`                 | `true` or `false` (no `MAX_VALUE` / `MIN_VALUE`) |

---

### **Important Methods for Primitives**
The wrapper classes (e.g., `Integer`, `Double`) provide useful methods to work with primitive types. Below are some of the key methods:

#### **Max/Min Values**
- `Integer.MAX_VALUE` / `Integer.MIN_VALUE`  
  Returns the maximum and minimum values of an `int`.

#### **Size in Bits**
- `Integer.SIZE`  
  Returns the size in bits of the primitive type. Example:
  ```java
  System.out.println(Integer.SIZE); // Outputs 32
  ```

#### **Parsing and Conversion**
- `Integer.parseInt(String s)`  
  Converts a string to an `int`.
- `Integer.valueOf(String s)`  
  Returns an `Integer` object for the given string.

#### **Binary, Octal, and Hexadecimal Conversions**
- `Integer.toBinaryString(int i)`  
  Converts an `int` to its binary string representation.
- `Integer.toHexString(int i)`  
  Converts an `int` to its hexadecimal string representation.
- `Integer.toOctalString(int i)`  
  Converts an `int` to its octal string representation.

#### **Checking Properties**
- `Character.isDigit(char c)`  
  Checks if a character is a digit.
- `Character.isLetter(char c)`  
  Checks if a character is a letter.

#### **Type Conversion**
- `Double.valueOf(String s)`  
  Converts a string to a `Double` object.
- `Double.parseDouble(String s)`  
  Converts a string to a primitive `double`.

#### **Math Utilities**
These methods are often used to manipulate primitive data types:
- `Math.max(a, b)`  
  Returns the maximum of two values.
- `Math.min(a, b)`  
  Returns the minimum of two values.
- `Math.abs(a)`  
  Returns the absolute value.
- `Math.pow(a, b)`  
  Returns \(a^b\) as a `double`.
- `Math.sqrt(a)`  
  Returns the square root of \(a\).
- `Math.random()`  
  Returns a random `double` between 0.0 (inclusive) and 1.0 (exclusive).

---


### **1. Java Regex (Regular Expressions)**

Java’s regex functionality is provided through the `java.util.regex` package, which includes:
- **`Pattern`**: Compiles a regular expression.
- **`Matcher`**: Matches the compiled pattern against an input string.

---

#### **Key Regex Symbols and Their Usage**
| **Symbol** | **Meaning**                                  | **Example**                          |
|------------|----------------------------------------------|---------------------------------------|
| `.`        | Matches any character (except newline)       | `a.b` matches `acb`, `a1b`, but not `ab`. |
| `*`        | Matches 0 or more of the preceding element   | `a*` matches `a`, `aaa`, or empty.    |
| `+`        | Matches 1 or more of the preceding element   | `a+` matches `a`, `aaa`, but not empty. |
| `?`        | Matches 0 or 1 of the preceding element      | `a?` matches `a` or empty.            |
| `[abc]`    | Matches any character in the set             | `[abc]` matches `a`, `b`, or `c`.     |
| `[^abc]`   | Matches any character *not* in the set       | `[^abc]` matches `d`, `e`, etc.       |
| `[a-z]`    | Matches any character in the range           | `[a-z]` matches `a`, `b`, ..., `z`.   |
| `\d`       | Matches a digit (equivalent to `[0-9]`)      | `\d` matches `3`, `9`, etc.           |
| `\D`       | Matches a non-digit                         | `\D` matches `a`, `!`, etc.           |
| `\s`       | Matches a whitespace                        | `\s` matches space, tab, newline.     |
| `\S`       | Matches a non-whitespace                    | `\S` matches `a`, `3`, etc.           |
| `^`        | Matches the start of a string               | `^a` matches `apple` but not `banana`.|
| `$`        | Matches the end of a string                 | `a$` matches `banana` but not `apple`.|
| `|`        | Matches either expression                   | `a|b` matches `a` or `b`.             |

---

#### **Common Regex Use Cases**
- **Validate Email**:  
  ```java
  String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
  ```
- **Check if String is Numeric**:  
  ```java
  String numRegex = "\\d+";
  ```
- **Split a String by Delimiters**:  
  ```java
  String text = "apple,orange;banana";
  String[] fruits = text.split("[,;]");
  ```

---

#### **Using `Pattern` and `Matcher`**
```java
import java.util.regex.*;

public class RegexExample {
    public static void main(String[] args) {
        String text = "apple123banana456";
        String regex = "\\d+"; // Match sequences of digits

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Find matches
        while (matcher.find()) {
            System.out.println("Matched: " + matcher.group());
        }
    }
}
```

---

### **2. Java `printf`**

Java’s `printf` is a method in `PrintStream` that formats and outputs text. It's similar to `printf` in C/C++.

#### **Syntax**
```java
System.out.printf(String format, Object... args);
```
- `format`: A format string specifying the structure.
- `args`: Arguments to be formatted and displayed.

---

#### **Common Format Specifiers**
| **Specifier** | **Description**                                  | **Example**                     |
|---------------|--------------------------------------------------|----------------------------------|
| `%d`          | Decimal integer                                 | `System.out.printf("%d", 42);`  |
| `%f`          | Floating-point number                          | `System.out.printf("%.2f", 3.14);` |
| `%s`          | String                                         | `System.out.printf("%s", "text");` |
| `%c`          | Character                                      | `System.out.printf("%c", 'A');` |
| `%n`          | Newline (platform-independent)                 | `System.out.printf("%n");`      |
| `%x` / `%X`   | Hexadecimal (lowercase/uppercase)              | `System.out.printf("%x", 255);` |
| `%e`          | Scientific notation (lowercase)               | `System.out.printf("%e", 0.0003);` |
| `%g`          | Shortest of `%e` or `%f`                      | -                                |

---

#### **Formatting Flags**
| **Flag**      | **Meaning**                                    | **Example**                     |
|---------------|------------------------------------------------|----------------------------------|
| `-`           | Left-justify the output                       | `%10d` vs `%-10d`               |
| `+`           | Include a `+` sign for positive numbers       | `%+d` -> `+42`, `-42`           |
| `0`           | Pad numbers with leading zeros                | `%05d` -> `00042`               |
| `,`           | Include commas in numbers                     | `%,d` -> `1,000`                |
| `( )`         | Enclose negative numbers in parentheses       | `%(d` -> `(42)`                 |

---

#### **Examples of `printf` Usage**
```java
public class PrintfExample {
    public static void main(String[] args) {
        int num = 42;
        double pi = 3.14159;

        // Integer formatting
        System.out.printf("Number: %d%n", num);         // Number: 42
        System.out.printf("Left-justified: %-5d%n", num); // Left-justified: 42   

        // Floating-point formatting
        System.out.printf("Pi: %.2f%n", pi);            // Pi: 3.14
        System.out.printf("Scientific: %e%n", pi);      // Scientific: 3.141590e+00

        // String formatting
        String name = "Java";
        System.out.printf("Hello, %s!%n", name);        // Hello, Java!

        // Combined formatting
        System.out.printf("Pi: %.2f | Number: %05d%n", pi, num);
    }
}
```

---

#### **Advanced Example: Table Formatting**
```java
public class TableExample {
    public static void main(String[] args) {
        System.out.printf("%-10s %-10s %-10s%n", "Name", "Age", "Score");
        System.out.printf("%-10s %-10d %-10.2f%n", "Alice", 25, 95.5);
        System.out.printf("%-10s %-10d %-10.2f%n", "Bob", 30, 89.0);
    }
}
```
**Output**:
```
Name       Age       Score     
Alice      25        95.50     
Bob        30        89.00     
```

---
