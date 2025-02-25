package com.miti99.taskbus.bus.impl;

import com.miti99.taskbus.bus.Bus;
import com.miti99.taskbus.task.event.UserLoginEvent;
import com.miti99.taskbus.task.request.SendMessageRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BusTest {
  private final Bus bus;

  void submitTasks() {
    bus.submit(new UserLoginEvent(1));
    bus.submit(new SendMessageRequest(1, "msg1"));
    bus.submit(new SendMessageRequest(1, "msg2"));
    bus.submit(new UserLoginEvent(2));
    bus.submit(new SendMessageRequest(2, "msg1"));
    bus.submit(new SendMessageRequest(2, "msg2"));
    bus.submit(new SendMessageRequest(1, "msg3"));
    bus.submit(new SendMessageRequest(1, "msg4"));
    bus.submit(new SendMessageRequest(2, "msg3"));
    bus.submit(new SendMessageRequest(2, "msg4"));
  }
}
