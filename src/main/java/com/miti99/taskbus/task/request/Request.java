package com.miti99.taskbus.task.request;

import com.miti99.taskbus.task.Task;

public interface Request extends Task {
  int userId();

  @Override
  default int hash() {
    return userId();
  }
}
