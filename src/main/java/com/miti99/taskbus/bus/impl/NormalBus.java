package com.miti99.taskbus.bus.impl;

import com.miti99.taskbus.bus.Bus;
import com.miti99.taskbus.task.Task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NormalBus implements Bus {
  private final ExecutorService executors =
      Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

  @Override
  public void submit(Task task) {
    executors.submit(task::execute);
  }
}
