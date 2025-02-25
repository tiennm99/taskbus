package com.miti99.taskbus.bus.impl;

import com.miti99.taskbus.bus.Bus;
import com.miti99.taskbus.task.Task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskBus implements Bus {
  private final ExecutorService[] executors;
  private final int poolSize;

  public TaskBus(int poolSize) {
    this.poolSize = poolSize;
    executors = new ExecutorService[poolSize];
    for (int i = 0; i < poolSize; i++) {
      executors[i] = Executors.newSingleThreadExecutor();
    }
  }

  public TaskBus() {
    this(Runtime.getRuntime().availableProcessors());
  }

  @Override
  public void submit(Task task) {
    int executorId = task.hash() % poolSize;
    executors[executorId].submit(task::execute);
  }
}
