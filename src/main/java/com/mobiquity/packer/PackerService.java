package com.mobiquity.packer;

import com.mobiquity.exception.APIException;

public interface PackerService extends AutoCloseable {
  public String pack(String filePath) throws APIException ; 
}
