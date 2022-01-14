package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    
	@Query("SELECT r FROM RecoveryRoom r")
	public List<RecoveryRoom> findAll();
    
    @Query("SELECT type FROM RecoveryRoomType type")
    public List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT r FROM RecoveryRoomType r WHERE r.name=?1")
    public RecoveryRoomType getRecoveryRoomType(String name);
    
    @Query("SELECT r FROM RecoveryRoom r WHERE r.size>?1")
    public List<RecoveryRoom> findBySizeMoreThan(double size);
}
