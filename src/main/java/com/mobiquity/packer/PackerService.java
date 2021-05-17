package com.mobiquity.packer;

import com.mobiquity.exception.APIException;

/**
 * Default contract for Packer Service
 *
 */
public interface PackerService extends AutoCloseable {
  public String pack(String filePath) throws APIException ; 
}
