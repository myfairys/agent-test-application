package com.test.consumer.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZooKeeperConnection {

   // 定义zookeeper的对象
   private ZooKeeper zoo;
   final CountDownLatch connectedSignal = new CountDownLatch(1);
   // 连接的方法
   public ZooKeeper connect(String host) throws IOException,InterruptedException {
      zoo = new ZooKeeper("localhost:2181",5000,new Watcher() {//这个是先连接验证的zookeeper的IP:端口
         public void process(WatchedEvent we) {
            if (we.getState() == Event.KeeperState.SyncConnected) {//判定是否连接成功，执行完就会被删除，
            //还有很多其他getState(),下面表格有几种
               connectedSignal.countDown();//解锁
            }
         }
      });		
      connectedSignal.await();//等待连接成功解锁
      return zoo;
   }
   //关闭连接的方法
   public void close() throws InterruptedException {
      zoo.close();
   }
}