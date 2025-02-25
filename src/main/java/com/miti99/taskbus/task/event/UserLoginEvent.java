package com.miti99.taskbus.task.event;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record UserLoginEvent(int userId) implements Event {

  @Override
  public void execute() {
    log.info("User {} logged in", userId);
  }
}
