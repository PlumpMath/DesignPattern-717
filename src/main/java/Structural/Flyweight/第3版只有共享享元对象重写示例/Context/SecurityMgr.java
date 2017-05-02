package Structural.Flyweight.第3版只有共享享元对象重写示例.Context;

import Structural.Flyweight.第3版只有共享享元对象重写示例.BaseClass.Flyweight;
import Structural.Flyweight.第3版只有共享享元对象重写示例.Data.TestDB;
import Structural.Flyweight.第3版只有共享享元对象重写示例.Factory.FlyweightFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sahoo on 17/3/15.
 * <p>
 * 安全管理，实现成单例
 */
public class SecurityMgr {
    private static SecurityMgr securityMgr = new SecurityMgr();

    private SecurityMgr() {
    }

    public static SecurityMgr getSecurityMgr() {
        return securityMgr;
    }

    /**
     * 在运行期间，用来存放登录人员对应的权限
     * 在Ｗeb应用中，这些数据通常会存放到 session 中
     */
    private Map<String, Collection<Flyweight>> map = new HashMap<String, Collection<Flyweight>>();

    /**
     * 模拟登录的功能
     * 登录的时候，把用户所拥有的权限创建为享元对象列表。
     * 创建过程：
     *      1 在创建享元对象时，先通过 key 从工厂里获取享元对象，
     *      2 如果不存在则创建一个享元对象，并存放到工厂中，就像存入缓存中一样。
     *      3 然后返回创建的享元对象。
     *      4 把返回的享元对象再存放在用户的享元对象列表
     *      5 最后以用户为 key 把刚创建的享元列表存入一个 键/值对象集合中。
     * @param user 登录的用户
     */
    public void login(String user) {

//        登录时就需要把该用户所拥有的权限，从数据库中取出来，放到缓存中去
        Collection<Flyweight> col = queryByUser(user);
        map.put(user, col);
    }


    /**
     * 从数据库中获取某人所扔拥有的权限
     *
     * @param user 需要获取所拥有的权限的人员
     * @return 某人所拥有的权限
     */
    private Collection<Flyweight> queryByUser(String user) {

        Collection<Flyweight> col = new ArrayList<Flyweight>();

        for (String s : TestDB.colDB) {
            String ss[] = s.split(",");
            if (ss[0].equals(user)) {
                Flyweight fm = FlyweightFactory.getInstance().getFlyweight(ss[1] + "," + ss[2]);
                col.add(fm);
            }
        }
        return col;

    }

    /**
     * 判断某用户对某个安全实体是否拥有某种权限
     *
     * @param user           被检测权限的用户
     * @param securityEntity 安全实体
     * @param permit         权限
     * @return true 表示拥有相应的权限 false 表示没有相应权限
     */
    public boolean hasPermit(String user, String securityEntity, String permit) {
        Collection<Flyweight> col = map.get(user);
        if (col == null || col.size() == 0) {
            System.out.println(user + "没有登录或是没有被分配任何权限");
            return false;
        }
        for (Flyweight fm : col) {
//            输出当前实例，看看是否同一个实例对象
            System.out.println("fm = " + fm);
            if (fm.match(securityEntity, permit)) {
                return true;
            }
        }
        return false;
    }


}
