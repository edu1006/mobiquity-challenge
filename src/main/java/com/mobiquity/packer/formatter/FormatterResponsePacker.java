package com.mobiquity.packer.formatter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * This class provided API pattern formatter response basic
 *  
 */
public final class FormatterResponsePacker {

  private FormatterResponsePacker() {
  }

  public static String toStrings(final List<Integer> indexes) {
    return indexes.isEmpty() ? "-"  : indexes.stream().map(integer -> String.valueOf(integer)).collect(Collectors.joining(","));
  }
}
