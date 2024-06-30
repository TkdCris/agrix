package com.betrybe.agrix.services.exceptions;

/**
 * The type Farm not found exception.
 */
public class FarmNotFoundException extends NotFoundException {

  /**
   * Instantiates a new Farm not found exception.
   */
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
