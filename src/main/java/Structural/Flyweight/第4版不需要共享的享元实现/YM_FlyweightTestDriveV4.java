package Structural.Flyweight.第4版不需要共享的享元实现;

import Structural.Flyweight.第4版不需要共享的享元实现.Context.SecurityMgr;

/**
 * Created by sahoo on 17/3/18.
 */
public class YM_FlyweightTestDriveV4 {

    public static void start() {
//        需要先登录，然后再判断是否有权限
        SecurityMgr mgr = SecurityMgr.getSecurityMgr();

        mgr.login("张三");
        mgr.login("李四");

        boolean f1 = mgr.hasPermit("张三", "薪资数据", "查看");
        boolean f2 = mgr.hasPermit("李四", "薪资数据", "查看");
        boolean f3 = mgr.hasPermit("李四", "薪资数据", "修改");

        System.out.println("f1 == " + f1);
        System.out.println("f2 == " + f2);
        System.out.println("f3 == " + f3);

        for (int i = 0; i < 3; i++) {
            mgr.login("张三" + i);
            mgr.hasPermit("张三" + i, "薪资数据", "查看");
        }
    }
}
