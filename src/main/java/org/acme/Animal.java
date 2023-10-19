package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal extends PanacheEntityBase {
  @Id
  @SequenceGenerator(
      name = "animalSequence",
      sequenceName = "animal_id_seq",
      allocationSize = 1
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animalSequence")
  public Integer id;

  @Column(length = 75, unique = true, nullable = false)
  public String name;

  public static Uni<Animal> findByName(String name) {
    return find("name", name).firstResult();
  }
}
