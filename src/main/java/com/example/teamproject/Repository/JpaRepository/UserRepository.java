package com.example.teamproject.Repository.JpaRepository;

import com.example.teamproject.JpaClass.UserTable.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public Optional<UserEntity> findByUserId(String userId);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.rankScore = u.rankScore + 1 where u.userId = :userId")
    void updateUserRank(@Param("userId") String userId);
}
