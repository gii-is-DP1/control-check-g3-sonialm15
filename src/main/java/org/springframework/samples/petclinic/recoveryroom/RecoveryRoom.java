package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_rooms")
public class RecoveryRoom extends BaseEntity{
	
	@Column(name = "name")
	@NotNull
	@Size(min=3, max=50)
    String name;
	
	@Column(name="size")
	@NotNull
	@Min(0)
    double size;
	
	@Column(name="secure")
	@NotNull
    boolean secure;
	
    @ManyToOne(optional=false)
    @NotNull
	@JoinColumn(name = "recovery_room_type")
	private RecoveryRoomType roomType;
}
