package com.test.consumer.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZKCreate {
   // 创建zookeeper对象
   private static ZooKeeper zk;
   // 创建连接对象
   private static ZooKeeperConnection conn;
   // 创建节点的方法
   public static void create(String path, byte[] data) throws
           KeeperException,InterruptedException {
      //参数为地址，数据，ACL:访问控制列表，节点类型:临时顺序或两者。后两个可以参考下面的表格
      zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
      CreateMode.PERSISTENT);
   }
   // 节点信息插入方法
   public static void update(String path, byte[] data) throws
           KeeperException,InterruptedException {
      zk.setData(path, data, zk.exists(path,true).getVersion());//插入信息:路径，数据，版本
      //这里的版本也可以是-1；它是递增的，不过如果你要是想模仿原子操作，就需要判定版本问题了，否则-1就可以
   }
   public static void main(String[] args) {
      // 节点的路径
      String path = "/sentinel_rule_config/dubbo-web-consumer/flow";
      // 数据转成byte数组

      byte[] data = "[{\"app\":\"dubbo-web-consumer\",\"clusterConfig\":{\"fallbackToLocalWhenFail\":true,\"sampleCount\":10,\"strategy\":0,\"thresholdType\":0,\"windowIntervalMs\":1000},\"clusterMode\":false,\"controlBehavior\":0,\"count\":1.0,\"gmtCreate\":1596522835709,\"gmtModified\":1596523064444,\"grade\":1,\"id\":1,\"ip\":\"127.0.0.1\",\"limitApp\":\"default\",\"port\":8721,\"resource\":\"com.test.consumer.controller.DemoController:selectById(Integer)\",\"strategy\":0}]".getBytes();
      try {
         conn = new ZooKeeperConnection();
         zk = conn.connect("localhost");//在连接中想往哪个zookeeper的IP添加，
         //不要以为工具类里写了这里就不用写，如果不写是不行的
         update(path, data); // 根据指定节点创建节点，填充数据
         conn.close();  //关闭连接
      } catch (Exception e) {
         System.out.println(e.getMessage()); //Catch error message
      }
   }
}