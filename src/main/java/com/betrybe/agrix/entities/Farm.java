package com.betrybe.agrix.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * The type Farm.
 */
@Entity
@Table(name = "farm")
public class Farm {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * The Name.
   */
  private String name;
  /**
   * The Size.
   */
  private Double size;

  @OneToMany(mappedBy = "farm")
  private List<Crop> crops;

  /**
   * Instantiates a new Farm.
   */
  public Farm() {
  }

  /**
   * Instantiates a new Farm.
   *
   * @param name the name
   * @param size the size
   */
  public Farm(String name, Double size) {
    this.name = name;
    this.size = size;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  public Double getSize() {
    return size;
  }

  /**
   * Sets size.
   *
   * @param size the size
   */
  public void setSize(Double size) {
    this.size = size;
  }

  /**
   * Gets crops.
   *
   * @return the crops
   */
  public List<Crop> getCrops() {
    return crops;
  }

  /**
   * Sets crops.
   *
   * @param crops the crops
   */
  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }
}
