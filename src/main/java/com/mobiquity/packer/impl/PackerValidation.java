package com.mobiquity.packer.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mobiquity.exception.ConstraintsValidationException;

final class PackerValidation {

  private static final Integer MAX_WEIGHT = 100;
  private static final Integer MAX_ITEMS = 15;
  private static final double MAX_COST = 100;

  private PackerValidation() {
  }


  private static void validateConstraints(Map<Integer, List<Item>> packs) throws ConstraintsValidationException {
    for (Entry<Integer, List<Item>> pack : packs.entrySet()) {
      validateMaxWeight(pack);
      validateMaxItems(pack);
      validateMaxWeightAndCoastOfItem(pack);
    }
  }

  private static void validateMaxWeightAndCoastOfItem(Entry<Integer, List<Item>> pack) throws ConstraintsValidationException {
    for (Item item : pack.getValue()) {
      if (item.getCost() > MAX_COST || item.getWeight() > MAX_WEIGHT) {
        throw new ConstraintsValidationException("check the max weight or max coast.");
      }
    }
  }

  private static void validateMaxItems(Entry<Integer, List<Item>> pack) throws ConstraintsValidationException {
    if (pack.getValue().size() > MAX_ITEMS) {
      throw new ConstraintsValidationException("check max item allowed");
    }
  }

  private static void validateMaxWeight(Entry<Integer, List<Item>> pack) throws ConstraintsValidationException {
    if (pack.getKey() > MAX_WEIGHT) {
      throw new ConstraintsValidationException("the max weight allowed is 100, please, check the constraints");
    }
  }

  public static void validatePacks(Map<Integer, List<Item>> packs) throws ConstraintsValidationException {
    validateConstraints(packs);
  }
}
