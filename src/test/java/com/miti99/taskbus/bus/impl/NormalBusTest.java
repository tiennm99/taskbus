package com.miti99.taskbus.bus.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalBusTest extends BusTest {

  public NormalBusTest() {
    super(new NormalBus());
  }

  @Test
  void runTest() {
    submitTasks();
  }
}
