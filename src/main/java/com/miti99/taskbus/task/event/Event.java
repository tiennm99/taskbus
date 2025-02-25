package com.miti99.taskbus.task.event;

import com.miti99.taskbus.task.Task;

public interface Event extends Task {
  int userId();

  @Override
  default int hash() {
    return userId();
  }
}
