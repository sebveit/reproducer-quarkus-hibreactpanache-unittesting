package org.acme;

import io.quarkus.test.hibernate.reactive.panache.TransactionalUniAsserter;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.vertx.RunOnVertxContext;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class AnimalEntityTest {
  @Test
  @RunOnVertxContext
  public void persistAndDelete(final TransactionalUniAsserter asserter) {
    final Animal animal = new Animal();
    animal.name = "danger noodle";
    asserter.execute(() -> animal.persist());
    asserter.assertEquals(() -> Animal.count(), 2L); // Should already fail here!
    asserter.execute(() -> Animal.deleteAll());
    asserter.fail(); // Must definitely fail here!
  }
}
