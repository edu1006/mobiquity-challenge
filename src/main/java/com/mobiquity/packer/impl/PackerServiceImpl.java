package com.mobiquity.packer.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mobiquity.exception.APIException;
import com.mobiquity.packer.PackerService;

class PackerServiceImpl implements PackerService {

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub

  }

  
  @Override
  public String pack(String filePath) throws APIException {
    List<String> lines = FileUtils.extractLinesFromFilePath(filePath);
    Map<Integer, List<Item>> packs = PackerHelper.extractPacksFromLines(lines);
    PackerValidation.validatePacks(packs); 
    StringBuilder response = new StringBuilder();
    for (Entry<Integer, List<Item>> pack : packs.entrySet()) {
      response.append(KnapsackOptimization.getIndexOptimizedFromPack(pack));
    }
    return response.toString().trim();
  }

}
