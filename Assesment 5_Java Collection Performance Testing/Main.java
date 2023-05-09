import java.util.List;
import java.util.ArrayList;
public class PerformanceTest {
public static void main(String[] args) {
// Create a collection of SomeObject
List<SomeObject> list = new ArrayList<SomeObject>();
int size = 10000;
for (int i = 0; i < size; i++) {
list.add(new SomeObject(i, "some string"));
}
Runtime runtime = Runtime.getRuntime();
runtime.gc();
long memory = runtime.totalMemory() - runtime.freeMemory();
long objSize = getObjectSize(list.get(0));
long collectionSize = objSize * size;
System.out.println("Size of the stored object: " + objSize + " bytes");
System.out.println("Size of the stored collection: " + collectionSize + " bytes");
System.out.println("Used memory: " + memory + " bytes");
System.out.println("Memory overhead: " + (memory-collectionSize) + " bytes");
}
public static long getObjectSize(Object obj) {
Runtime runtime = Runtime.getRuntime();
runtime.gc();
long size = runtime.totalMemory() - runtime.freeMemory();
return size;
}
}
class SomeObject {
private int value;
private String text;
public SomeObject(int value, String text) {
this.value = value;
this.text = text;
}
}
