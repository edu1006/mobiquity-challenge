package com.mobiquity.packer;

public interface PackerServiceFactory  extends AutoCloseable{

  public PackerService createPackerService ();  
}
