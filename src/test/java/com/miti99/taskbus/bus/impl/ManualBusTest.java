package com.miti99.taskbus.bus.impl;

import org.junit.jupiter.api.Test;

class ManualBusTest extends BusTest {

  public ManualBusTest() {
    super(new ManualBus());
  }

  @Test
  void runTest() {
    submitTasks();
  }
}
