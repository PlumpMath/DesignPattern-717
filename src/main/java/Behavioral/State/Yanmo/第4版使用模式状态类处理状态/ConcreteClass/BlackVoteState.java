package Behavioral.State.Yanmo.第4版使用模式状态类处理状态.ConcreteClass;


import Behavioral.State.Yanmo.第4版使用模式状态类处理状态.BaseClass.VoteState;
import Behavioral.State.Yanmo.第4版使用模式状态类处理状态.VoteManager;

/**
 * Created by sahoo on 17/3/8.
 * 黑名单状态
 */
public class BlackVoteState implements VoteState {
    public void vote(String user, String voteItem, VoteManager voteManager) {

        //黑名单
        //记入黑名单，禁止登录系统了
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}
