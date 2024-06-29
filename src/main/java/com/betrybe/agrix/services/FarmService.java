package com.betrybe.agrix.services;

import com.betrybe.agrix.entities.Farm;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.repositories.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {

  /**
   * The Farm repository.
   */
  FarmRepository farmRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Create farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Farm> getAll() {
    return farmRepository.findAll();
  }

  /**
   * Gets by id.
   *
   * @param farmId the farm id
   * @return the by id
   */
  public Farm getById(Long farmId) {
    return farmRepository.findById(farmId).orElseThrow(FarmNotFoundException::new);
  }
}
