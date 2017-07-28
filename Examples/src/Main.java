import java.util.Comparator;
import java.util.TreeMap;

public class Main {
    /* **The classic way to create Comparer**
     static class CompThenByFirstName implements Comparator<String>{
     public int compare(String aStr, String bStr) { return aStr.compareToIgnoreCase(bStr); }
     }

     static class CompLastName implements Comparator<String>{
     public int compare(String aStr, String bStr) {
     return aStr.substring(aStr.lastIndexOf(' ')).compareToIgnoreCase(bStr.substring(bStr.lastIndexOf(' '))); }
     }
     */

    public static void main(String[] args){
        Comparator<String> sort;    //  = new CompLastName().thenComparing(new CompThenByFirstName());
        sort = (aStr, bStr) -> aStr.substring( aStr.lastIndexOf(' ') ).compareToIgnoreCase(bStr.substring(bStr.lastIndexOf(' ')));
        sort = sort.thenComparing(String::compareToIgnoreCase);

        TreeMap<String,Double> tm = new TreeMap<>(sort);
        tm.put("Джон Доу",3434.34);
        tm.put("Toм Смит",123.22);
        tm.put("Джейн Бейкер",1378.00);
        tm.put("Toд Халл",99.22);
        tm.put("Ральф Смит",-19.08);

        tm.forEach((k,v) -> System.out.println(k + ": " + v));

        double balance = tm.get("Джон Доу");
        tm.put("Джон Доу",balance+1000);
        System.out.println("Счет Джона Доу: " + tm.get("Джон Доу"));
    }
}