package Behavioral.State.Yanmo.第3版使用模式上下文中处理状态.ConcreteClass;

import Behavioral.State.Yanmo.第3版使用模式上下文中处理状态.BaseClass.VoteState;
import Behavioral.State.Yanmo.第3版使用模式上下文中处理状态.VoteManager;

/**
 * Created by sahoo on 17/3/2.
 */
public class RepeatVoteState implements VoteState {
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // 重复投票
        // 暂不做处理
        System.out.println("请不要重复投票");
    }
}
