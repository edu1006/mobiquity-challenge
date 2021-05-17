package com.mobiquity.packer.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mobiquity.exception.APIException;

public class FileUtils {

  public static List<String> extractLinesFromFilePath(String filePath) throws APIException {
    File file = new File(filePath);
    BufferedReader in = null;
    List<String> lines = new ArrayList<>(); 
    try {
      in = new BufferedReader(new FileReader(file));
      String line = null; 
      while ((line = in.readLine()) != null) {
        lines.add(line);
        
      }
    } catch (IOException e) {
      throw new APIException("File not found", e); 
    }
    return lines;
  }

}
