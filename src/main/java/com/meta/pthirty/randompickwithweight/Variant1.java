package com.meta.pthirty.randompickwithweight;

import java.util.ArrayList;
import java.util.List;
public class Variant1 {

    private final List<String> cities;
    private final int[] prefixSums;
    private int totalPopulation;

    public Variant1(List<Pair<String,Integer>> cityPopulations){
        this.totalPopulation = 0;
        this.cities = new ArrayList<>();
        this.prefixSums = new int[cityPopulations.size()];

        for(int i=0; i<cityPopulations.size(); i++){
            Pair<String,Integer> entry = cityPopulations.get(i);
            cities.add(entry.getKey());
            totalPopulation += entry.getValue();
            prefixSums[i] = totalPopulation;
        }
    }

    public String pickCity(){
        double target = Math.random()*totalPopulation;
        int left = 0, right = prefixSums.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(prefixSums[mid] < target){
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return cities.get(left);
    }

    public static class Pair<K,V> {
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}
