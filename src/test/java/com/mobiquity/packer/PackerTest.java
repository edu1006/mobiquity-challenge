package com.mobiquity.packer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mobiquity.exception.APIException;

public class PackerTest {

  private PackerTest() {
  }

  @Test
  public void shouldSuccessPack() throws APIException {
    String response = Packer.pack(
        "/home/eduardo/Downloads/Backend code assignment - Mobiquity 2021 (1)/src/main/resources/inputproblem.txt");

    assertEquals("4\n" + "-\n" + "8,9\n" + "2,7", response);
  }

  @Test
  public void shouldNotFindFile() {
    try {
      Packer.pack("");
      throw new IllegalArgumentException("this test should be failed");

    } catch (APIException e) {
      assertTrue(e.getMessage().equals("File not found"));
    }

  }

  @Test
  public void shouldValidateWeightConstraint() {
    try {
      Packer.pack(
          "/home/eduardo/Downloads/Backend code assignment - Mobiquity 2021 (1)/src/main/resources/input_with_weight_constraint.txt");
      throw new IllegalArgumentException("this test should be failed");
    } catch (APIException e) {
      assertEquals("the max weight allowed is 100, please, check the constraints", e.getMessage());
    }
  }

  @Test
  public void shouldValidateMaxItemConstraint() {
    try {
      Packer.pack(
          "/home/eduardo/Downloads/Backend code assignment - Mobiquity 2021 (1)/src/main/resources/input_with_max_item_constraint.txt");
      throw new IllegalArgumentException("this test should be failed");
    } catch (APIException e) {
      assertEquals("check max item allowed", e.getMessage());
    }
  }


  @Test
  public void shouldValidateMaxCoastAndWeightOfItem() {
    try {
      Packer.pack(
          "/home/eduardo/Downloads/Backend code assignment - Mobiquity 2021 (1)/src/main/resources/input_with_coast_contraints.txt");
      throw new IllegalArgumentException("this test should be failed");
    } catch (APIException e) {
      assertEquals("check the max weight or max coast.", e.getMessage());
    }
  }

}
