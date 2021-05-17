package com.mobiquity.packer;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.mobiquity.exception.APIException;


public class Packer {

  private Packer() {
  }

  /**
   * As a port of entrance of this API, this method should inject {@link PackerServiceFactory} 
   * and run to Impl of {@link PackerService}
   * @param filePath
   * @return
   * @throws APIException
   */
  public static String pack(String filePath) throws APIException {

    Iterator<PackerServiceFactory> factories = ServiceLoader.load(PackerServiceFactory.class).iterator();
    if (!factories.hasNext()) {
      throw new IllegalStateException("No Events found");
    }
    try (PackerServiceFactory factory = factories.next(); PackerService packerService = factory.createPackerService()) {
      return packerService.pack(filePath); 
    } catch (Exception e) {
      throw new APIException(e.getMessage(), e); 
    }

  }


}
