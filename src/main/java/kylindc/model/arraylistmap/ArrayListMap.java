package main.java.kylindc.model.arraylistmap;

import java.io.Serializable;
import java.util.*;

public class ArrayListMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static class Node<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry<K, V> entry = (Map.Entry) obj;
                if (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    List<Node> nodeList = new ArrayList<>();

    public ArrayListMap() {
        super();
    }

    @Override
    public boolean remove(Object key, Object value) {
        if (containsKey(key) && get(key).equals(value)) {
            return true;
        }
        return false;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        if (containsKey(key)) {
            return get(key);
        } else {
            put(key, value);
        }
        return value;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if (containsKey(key) && get(key).equals(oldValue)) {
            put(key, newValue);
        }
        return false;
    }

    @Override
    public V replace(K key, V value) {
        if (this.containsKey(key)) {
            return this.put(key, value);
        } else {
            return null;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayListMap) {
            ArrayListMap arrayListMap = (ArrayListMap) obj;
            if (this.size() == arrayListMap.size()
                    && this.entrySet().equals(arrayListMap.entrySet())) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ArrayListMap<K, V> result = null;
        try {
            result = (ArrayListMap<K, V>) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int size() {
        return nodeList.size();
    }

    @Override
    public boolean isEmpty() {
        return nodeList.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        for (Node node : nodeList) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node node : nodeList) {
            if (node.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (Node node : nodeList) {
            if (node.getKey().equals(key)) {
                return (V) node.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V returnValue = null;
        for (Node node : nodeList) {
            if (node.getKey().equals(key)) {
                returnValue = (V) node.getValue();
                node.setValue(value);
                return returnValue;
            }
        }
        Node node = new Node(key, value);
        nodeList.add(node);
        returnValue = value;
        return returnValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry entry : m.entrySet()) {
            put((K) entry.getKey(), (V) entry.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        if (containsKey(key)) {
            nodeList.remove(get(key));
        }
        return null;
    }

    @Override
    public void clear() {
        nodeList.clear();
    }

    @Override
    public Set<K> keySet() {
        if (!isEmpty()) {
            Set<K> keys = new HashSet<>();
            for (Node node : nodeList) {
                keys.add((K) node.getKey());
            }
            return keys;
        }
        return null;
    }

    @Override
    public Collection<V> values() {
        if (!isEmpty()) {
            Collection<V> values = new ArrayList<>();
            for (Node node : nodeList) {
                values.add((V) node.getValue());
            }
            return values;
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        if (!isEmpty()) {
            Set<Map.Entry<K, V>> entrySet = new HashSet<>();
            for (Node node : nodeList) {
                entrySet.add(node);
            }
            return entrySet;
        }
        return null;
    }
}
