package ru.itis.xokken.myanimesity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.xokken.myanimesity.models.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into accounts_persons (account_id, person_id) values (:userId, :personId)")
    void addPersonToUser(Long userId, Long personId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from accounts_persons where (account_id=?) and (person_id=?)")
    void deletePersonToUser(Long userId,Long personId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update accounts set img=:img where id=:userId")
    void updateImg(Long userId,String img);
}
