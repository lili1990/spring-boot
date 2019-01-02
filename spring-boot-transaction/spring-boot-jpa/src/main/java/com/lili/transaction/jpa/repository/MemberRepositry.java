package com.lili.transaction.jpa.repository;

import com.lili.transaction.jpa.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by lili19289 on 2016/12/27.
 */
public interface MemberRepositry extends JpaRepository<Member, Long> {

    Member findByusername(String name);

    @Query("select m from Member m where m.username=:username and m.isDeleted=false")
    Member findMember(@Param("username") String username);

}
