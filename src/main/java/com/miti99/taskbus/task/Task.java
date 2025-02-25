package com.miti99.taskbus.task;

public interface Task {

  /**
   * Dùng để xác định task này sẽ được thực thi trên thread nào. VD dùng công thức hash % poolSize
   *
   * @return hash
   */
  int hash();

  /** Thực thi task */
  void execute();
}
