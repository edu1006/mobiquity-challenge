package com.mobiquity.packer.utils;

public final class StringUtils {
  private StringUtils() {

  }

  public static String[] splitStringByParam(String value, String param) {
    return value.split(param);
  }

  public static String removeCharactersFromString(String value, String... params) {
    for (String param : params) {
      value = value.replace(param, "");
    }
    return value;
  }

  public static boolean isEmpty(String packsUnformmated) {
    if ("".equals(packsUnformmated)) {
      return true;
    }
    return false;
  }
}
