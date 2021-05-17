package com.mobiquity.packer.impl;

import com.mobiquity.packer.PackerService;
import com.mobiquity.packer.PackerServiceFactory;
import com.google.auto.service.AutoService;

@AutoService(PackerServiceFactory.class)
public final class PackerServiceFactoryImpl implements PackerServiceFactory {

  @Override
  public PackerService createPackerService() {
    return  new PackerServiceImpl();
  }

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub
    
  }
}
