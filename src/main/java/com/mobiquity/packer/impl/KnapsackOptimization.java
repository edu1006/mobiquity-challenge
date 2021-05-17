package com.mobiquity.packer.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

class KnapsackOptimization {

  private KnapsackOptimization() { 
    
  }
  
  public static List<Integer> getIndexOptimizedFromPack(Entry<Integer, List<Item>> pack) {
    if (pack.getValue().isEmpty()) {
      return Collections.emptyList(); 
    }
 
    List<Integer> indexes = new ArrayList<>();
    
    double maxCost = 0;
    String s = "";
    for (int i = 1; i <= pack.getValue().size(); i++) {
      String resultat = getOptimumFor(pack.getValue(), i, pack.getKey());

      String[] sub4 = resultat.split(",");
      var cost = Double.parseDouble(sub4[sub4.length - 2]);
      if (cost > maxCost) {
        maxCost = cost;
        s = resultat;
      }
    }
    String[] sub5 = s.split(",");
    for (int i = 0; i < sub5.length - 2; i++) {
      indexes.add(pack.getValue().get(Integer.parseInt(sub5[i])).getId()); 
    }

    return indexes  ;
  }

  private static String getOptimumFor(List<Item> things, int r, int maxWt) {
    int indexSolution = 0;
    String returnData = "";
    double maxWeight = 0;
    double maxCost = 0;
    int[] data = new int[r];
    List<Integer> res = new ArrayList<Integer>();
    int[] arr = new int[things.size()];
    for (int i = 0; i < things.size(); i++) {
      arr[i] = i;
    }
    getCombination(arr, data, res, 0, 0);

    for (int i = 0; i <= res.size() - r; i += r) {
      double someWeight = 0;
      double someCost = 0;
      for (int j = 0; j < r; j++) {
        someWeight += things.get(res.get(i + j)).getWeight();
        someCost += things.get(res.get(i + j)).getCost();
      }
      if (someWeight <= maxWt && (someCost > maxCost) || ((someCost == maxCost) && (someWeight <= maxWeight))) {
          indexSolution = i;
          maxWeight = someWeight;
          maxCost = someCost;
      }
    }
    for (int k = indexSolution; k < r + indexSolution; k++) {
      returnData += res.get(k) + ",";
    }
    return returnData + maxCost + "," + maxWeight;
  }

  private static void getCombination(int[] arr, int[] data, List<Integer> res, int start, int index) {
    if (index == data.length) {
      for (int j = 0; j < data.length; j++) {
        res.add(data[j]);
      }
      return;
    }
    for (int i = start; i < arr.length && arr.length - i >= data.length - index; i++) {
      data[index] = arr[i];
      getCombination(arr, data, res, i + 1, index + 1);
    }
  }

}
