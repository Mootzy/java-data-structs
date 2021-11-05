package Liang.chpt25;

/** A SortedMap extended with navigation methods returning the closest matches
 * for given search targets. Methods lowerEntry, floorEntry, ceilingEntry, and higherEntry
 * return Map.Entry objects associated with keys respectively less than, less than or
 * equal, greater than or equal, and greater than a given key, returning null if there is no
 * such key. Similarly, methods lowerKey, floorKey, ceilingKey, and higherKey return only
 * the associated keys. All of these methods are designed for locating, not traversing entries.
 * Added Comparable attribute for class Entry
 *
 * CSC161
 * @author Robert Gilanyi
 */


public interface MyOrderedMap<K extends Comparable<K>, V> {
    /** Remove all of the entries from this map */
    public void clear();

    /** Return true if the specified key is in the map */
    public boolean containsKey(K key);

    /** Return true if this map contains the specified value */
    public boolean containsValue(V value);

    /** Return a set of entries in the map */
    public java.util.Set<Entry<K, V>> entrySet();

    /** Return the first value that matches the specified key */
    public V get(K key);

    /** Return true if this map contains no entries */
    public boolean isEmpty();

    /** Return a set consisting of the keys in this map */
    public java.util.Set<K> keySet();

    /** Add an entry (key, value) into the map */
    public V put(K key, V value);

    /** Remove the entries for the specified key */
    public void remove(K key);

    /** Return the number of mappings in this map */
    public int size();

    /** Return a set consisting of the values in this map */
    public java.util.Set<V> values();

    /** Returns the entry with the smallest key value; if the map is empty, then it returns null.
     *
     */
    public Entry<K,V> firstEntry();

    /** Returns the entry with the largest key value; if the map is empty, then it returns null.
     *
     */
    public Entry<K,V> lastEntry();

    /** Returns the entry with the least key value greater than or equal to key;  if there is no such entry
     * then it return null.
     */
    public Entry<K,V> ceilingEntry(K key) ;

    /** Returns the entry with the greatest key value less than or equal to key; if there is no such entry, then
     * it returns null.
     */
    public Entry<K,V> floorEntry(K key) ;

    /** Returns the entry with the greatest key value strictly less than key; if there is no such entry, then
     * it returns null.
     */
    public Entry<K,V> lowerEntry(K key);

    /** Returns the entry with the least key value strictly greater than key; if there is no such entry, then
     * it returns null.
     */
    public Entry<K,V> higherEntry(K key);

    /** Define inner class for Entry */
    public static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K,V>> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }

        @Override
        public int compareTo(Entry<K,V> o){
            return (this.key).compareTo(o.key);
        }
    }
}
