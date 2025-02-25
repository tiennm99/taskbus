package com.miti99.taskbus.task.request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record SendMessageRequest(int userId, String message) implements Request {

  @Override
  public void execute() {
    log.info("User {} sent message: {}", userId, message);
  }
}
