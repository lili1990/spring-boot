package com.lili.repository;

import com.lili.models.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lili19289 on 2016/12/27.
 */
public interface MemberRepositry extends JpaRepository<Member, Long> {

    Member findByusername(String name);

    @Query("select m from Member m where m.username=:username and m.isDeleted=false")
    Member findMember(@Param("username") String username);

}
