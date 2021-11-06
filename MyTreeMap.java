package Liang.chpt25;

/**
 * A composite class to implement a RBTree based Ordered Map.  The map is sorted according to the natural
 * ordering of its keys.
 *
 * CSC161
 * @author Robert Gilanyi
 */


import java.util.*;

public class MyTreeMap<K extends Comparable<K>,V> implements MyOrderedMap<K, V>{

    // RBTree used to store each <key, value> entry
    RBTreeMap mapTree;

    //constructors
    public MyTreeMap(){
        mapTree = new RBTreeMap();
    }
    /** Remove all of the entries from this map */
    public void clear(){
        mapTree.clear();
        return;
    }

    /** Return true if the specified key is in the map */
    public boolean containsKey(K key){
        return mapTree.searchKey(key);
    }

    /** Return true if this map contains the specified value */
    public boolean containsValue(V value){
        return mapTree.searchValue(value);
    }

    /** Return a set of entries in the map */
    public java.util.Set<Entry<K, V>> entrySet(){
        return(java.util.Set<Entry<K, V>>) mapTree.entrySet();
    }

    /** Return the value that matches the specified key */
    @Override
    public V get(K key){
        Entry<K,V> e = mapTree.getentry(key);
        return e.getValue();
    }

    /** Return true if this map contains no entries */
    public boolean isEmpty(){
        return mapTree.getSize() == 0;
    }

    /** Return a set consisting of the keys in this map */
    public java.util.Set<K> keySet(){
        Entry e = null;
        java.util.HashSet<K> keyset = new java.util.HashSet<>();
        Iterator iter = mapTree.iterator();
        while(iter.hasNext())
            keyset.add(((Entry<K,V>)iter.next()).getKey());

        return keyset;
    }

    /** Remove the entries for the specified key */
    @Override
    public void remove(K key){
        mapTree.deleteKey(key);
    }

    /** Add an entry (key, value) into the map */
    public V put(K key, V value){
        mapTree.insert(key, value);
        return value;
    }


    /** Return the number of mappings in this map */
    public int size(){
        return mapTree.getSize();
    }

    /** Return a set consisting of the values in this map */
    public java.util.Set<V> values(){

        java.util.Set<V> set = new java.util.HashSet<V>();
        Iterator<V> iter = mapTree.valueSet();

        while(iter.hasNext())
            set.add(iter.next());

        return set;
    }

    @Override
    public String toString(){
        String s = "";
        Entry e = null;
        Iterator<Entry<K,V>> iter = mapTree.iterator();
        while(iter.hasNext()){
            e = (Entry<K,V>)iter.next();
            s += e.toString() + " ";
        }
        return s+"\n";
    }


    // interface MyOrderedMap methods for Ordered Maps
    @Override
    public Entry<K,V> firstEntry(){


        Entry<K,V> min = null;
        for (Entry<K,V> entry : mapTree.entrySet()){
            if (min == null || min.compareTo(entry) < 0){
                min = entry;
            }
        }



        return min;
    }

    static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }



    @Override
    public Entry<K,V> lastEntry(){
        // Left as an exercise
        if(true) throw new UnsupportedOperationException("unimplemented method ");
        return new MyOrderedMap.Entry<K,V>(null,null);
    }

    @Override
    public Entry<K,V> ceilingEntry(K key) {
        // Left as an exercise
        if(true) throw new UnsupportedOperationException("unimplemented method ");
        return new MyOrderedMap.Entry<K,V>(null,null);
    }

    @Override
    public Entry<K,V> floorEntry(K key){
        // Left as an exercise
        if(true) throw new UnsupportedOperationException("unimplemented method ");
        return new MyOrderedMap.Entry<K,V>(null,null);
    }

    @Override
    public Entry<K,V> lowerEntry(K key){
        // Left as an exercise
        if(true) throw new UnsupportedOperationException("unimplemented method ");
        return new MyOrderedMap.Entry<K,V>(null,null);
    }

    @Override
    public Entry<K,V> higherEntry(K key){
        // Left as an exercise
        if(true) throw new UnsupportedOperationException("unimplemented method ");
        return new MyOrderedMap.Entry<K,V>(null,null);
    }

    class RBTreeMap extends RBTree<Entry<K,V>> {
        private MyOrderedMap.Entry<K,V> newEntry;

        public RBTreeMap(){
            super();
        }

        public int getSize(){
            return size;
        }

        public Entry getentry(K key){
            for(Entry p : mapTree.entrySet()){
                if(p.getKey().equals(key))
                    return p;
            }
            return null;
        }

        public Entry getentry(V value){
            for(Entry p : mapTree.entrySet()){
                if(p.getValue().equals(value))
                    return p;
            }
            return null;
        }

        public boolean insert(K k, V v){
            //      create Entry object and insert it into tree
            if(super.insert(new MyOrderedMap.Entry(k,v))){
                return true;
            } else {
                return false;
            }
        }

        public boolean deleteKey(K key){
            Entry<K,V> entry = mapTree.getentry(key);
            return super.delete(entry);
        }

        public boolean searchKey(K key){
            Entry<K,V> entry = mapTree.getentry(key);
            if (entry != null)
                return true;
            else
                return false;
        }

        public boolean searchValue(V value){
            Entry<K,V> entry = mapTree.getentry(value);
            if (entry != null)
                return true;
            else
                return false;
        }

        // Support for iteration
        /**
         * Returns an iterable collection of all key-value entries of the map.
         *
         * @return iterable collection of the map's entries
         */
        public Iterable<Entry<K,V>> entrySet() {
            java.util.Set<Entry<K, V>> buffer = new java.util.HashSet<>();
            Entry<K,V> p;
            Iterator iter = mapTree.iterator();
            while(iter.hasNext()){
                p = (Entry<K,V>)iter.next();
                buffer.add(p);
            }
            return buffer;
        }

        /**
         * Returns an iterable collection of the items contained in the map.
         *
         * @return iterable collection of the map's keys
         */
        public Iterator<K> keySet() {
            return new KeyIterator();
        }

        /**
         * @return iterable collection of the map's values
         */
        public Iterator<V> valueSet(){
            return new ValueIterator();
        }

        // Override createNewNode() to create a MyTreeMapNode
        //    @Override
        //    protected RBTreeMapNode<K,V> createNewNode(K k){
        //        return new RBTreeMapNode(k,newEntry.value);
        //    }

        public Iterator iterator(){
            return new RBTreeMapIterator<K,V>();
        }

        class RBTreeMapIterator<K extends Comparable<K>,V> implements Iterator{
            // Store the elements in a list
            private java.util.ArrayList<Entry<K,V>> elist = new java.util.ArrayList<>();
            private int current = 0; // Point to the current element in list

            public RBTreeMapIterator() {
                inorder(); // Traverse binary tree and store elements in list
            }

            /** Inorder traversal from the root*/
            private void inorder() {
                inorder((TreeNode<K>)root);
            }

            /** Inorder traversal from a subtree */
            private void inorder(TreeNode<K> root) {
                if (root == null)
                    return;
                inorder(root.left);
                elist.add((Entry<K,V>)(root.element));
                inorder(root.right);
            }

            @Override /** More elements for traversing? */
            public boolean hasNext() {
                if (current < elist.size())
                    return true;

                return false;
            }

            @Override /** Get the current element and move to the next */
            public Entry<K,V> next() {
                return elist.get(current++);
            }

            public void remove() {
                throw new UnsupportedOperationException("remove not supported");
            }
        }

        //---------------- nested KeyIterator class ----------------
        protected class KeyIterator implements Iterator<K> {
            private Iterator<Entry<K,V>> entries = entrySet().iterator();   // reuse entrySet

            public boolean hasNext() {
                return entries.hasNext();
            }
            public K next() {
                return entries.next().getKey();
            }              // return key!
            public void remove() {
                throw new UnsupportedOperationException("remove not supported"); }
        } //----------- end of nested KeyIterator class -----------

        //---------------- nested ValueIterator class ----------------
        private class ValueIterator implements Iterator<V> {
            private Iterator<Entry<K,V>> entries = entrySet().iterator();   // reuse entrySet

            public boolean hasNext() {
                return entries.hasNext();
            }
            public V next(){
                return entries.next().getValue(); // return value!
            }

            public void remove() {
                throw new UnsupportedOperationException("remove not supported");
            }
        } //----------- end of nested ValueIterator class -----------

    }
}
