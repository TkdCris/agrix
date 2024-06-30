package com.betrybe.agrix.services.exceptions;

/**
 * The type Crop not found exception.
 */
public class CropNotFoundException extends NotFoundException {

  /**
   * Instantiates a new Crop not found exception.
   */
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
