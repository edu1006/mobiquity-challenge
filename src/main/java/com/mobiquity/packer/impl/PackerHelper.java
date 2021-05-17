package com.mobiquity.packer.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mobiquity.packer.utils.StringUtils;

final class PackerHelper {

  private PackerHelper() {

  }

  public static Map<Integer, List<Item>> extractPacksFromLines(List<String> lines) {
    Map<Integer, List<Item>> packs = new HashMap<>();
    for (String linePack : lines) {
      String[] linePackSplited = StringUtils.splitStringByParam(linePack, ":");
      Integer weight = Integer.valueOf(linePackSplited[0].trim());
      packs.put(weight, extractPackFromLinePack(linePackSplited[1], weight));
    }
    return packs;
  }

  private static List<Item>extractPackFromLinePack(String linePack, double maxWeight) {
    List<Item> items = new ArrayList<>();
    String[] packsUnformmatedArry = StringUtils.splitStringByParam(linePack, " ");
    for (String packsUnformmated : packsUnformmatedArry) {
      if (!StringUtils.isEmpty(packsUnformmated)) {
        String packFormated = StringUtils.removeCharactersFromString(packsUnformmated, "(", ")");
        String[] sub3 = StringUtils.splitStringByParam(packFormated, ",");
        int id = Integer.parseInt(sub3[0]);
        double weight = Double.parseDouble(sub3[1]);
        double cost = Double.parseDouble(sub3[2].substring(1, sub3[2].length()));
        if (weight <= maxWeight) {
          items.add(new Item(id, weight, cost));
        }

      }
    }
    return items ;
  }

}
