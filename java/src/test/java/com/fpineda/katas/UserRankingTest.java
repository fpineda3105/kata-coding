package com.fpineda.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class UserRankingTest {
    
    @Test
    void newUser_ShouldHave_InitialValues() {
        var user = new UserRanking();
        assertEquals(-8, user.rank);
        assertEquals(0, user.progress);
    }

    @Test
    void newUser_ShouldUpgrade_1_Rank_And_60_Progress() {
        var user = new UserRanking();
        user.incProgress(-4);
        assertEquals(-7, user.rank);
        assertEquals(60, user.progress);
    }

    @Test
    void user_ShouldUpgrade_1_Rank_And_61_Progress() {
        var user = new UserRanking();
        user.incProgress(-4);
        user.incProgress(-8);
        assertEquals(-7, user.rank);
        assertEquals(61, user.progress);
    }

    @Test
    void shouldThrow_InvalidArgumentException() {
        var user = new UserRanking();
        assertThrows(Exception.class, () -> user.incProgress(0));        
    }

    @Test
    void user_ShouldUpgrade_1_Rank_And_63_Progress() {
        var user = new UserRanking();
        user.incProgress(-4);
        user.incProgress(-7);
        assertEquals(-7, user.rank);
        assertEquals(63, user.progress);
    }

    @Test
    void userReachMaxRank_ShouldNot_Do_AnyProgress() {
        var user = new UserRanking();
        IntStream.range(0,100).forEach(i -> user.incProgress(8));
        
        assertEquals(8, user.getRank());
        assertEquals(0, user.getProgress());
        
    }

}
