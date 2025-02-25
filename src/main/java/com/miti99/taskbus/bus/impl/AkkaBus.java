package com.miti99.taskbus.bus.impl;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.ConsistentHashingPool;
import akka.routing.ConsistentHashingRouter.ConsistentHashMapper;
import com.miti99.taskbus.bus.Bus;
import com.miti99.taskbus.task.Task;
import java.io.Closeable;

public class AkkaBus implements Bus, Closeable {
  private static final int POOL_SIZE = Runtime.getRuntime().availableProcessors();
  private final ActorSystem system = ActorSystem.create("AkkaBus");
  private final ActorRef router;

  public AkkaBus() {
    router =
        system.actorOf(
            new ConsistentHashingPool(POOL_SIZE)
                .withHashMapper(new TaskHashMapper())
                .props(Props.create(TaskWorker.class)));
  }

  @Override
  public void submit(Task task) {
    router.tell(task, ActorRef.noSender());
  }

  @Override
  public void close() {
    system.terminate();
  }

  public static class TaskHashMapper implements ConsistentHashMapper {
    @Override
    public Object hashKey(Object message) {
      if (message instanceof Task task) {
        return task.hash() % POOL_SIZE;
      } else {
        return null;
      }
    }
  }

  public static class TaskWorker extends AbstractActor {
    @Override
    public Receive createReceive() {
      return receiveBuilder().match(Task.class, Task::execute).build();
    }
  }
}
