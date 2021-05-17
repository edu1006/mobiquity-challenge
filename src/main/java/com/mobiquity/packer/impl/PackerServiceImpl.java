package com.mobiquity.packer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.mobiquity.exception.APIException;
import com.mobiquity.packer.PackerService;
import com.mobiquity.packer.formatter.FormatterResponsePacker;

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
    List<List<Integer>> indexes = new ArrayList<>();
    for (Entry<Integer, List<Item>> pack : packs.entrySet()) {
      indexes.add(KnapsackOptimization.getIndexOptimizedFromPack(pack));
    }
    return formatterResponseFromIndex(indexes);
  }

  private String formatterResponseFromIndex(List<List<Integer>> indexes) {
    return indexes.stream().map(FormatterResponsePacker::toStrings).collect(Collectors.joining("\n"));
  }

}
