package com.miti99.taskbus.bus;

import com.miti99.taskbus.task.Task;

public interface Bus {

  void submit(Task task);
}
