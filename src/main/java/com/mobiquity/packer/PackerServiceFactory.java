package com.mobiquity.packer;

/**
 * This interface provide a contract for factories of this API. 
 * 
 * Every service should be created from here. 
 *
 */
public interface PackerServiceFactory  extends AutoCloseable{

  public PackerService createPackerService ();  
}
