package com.glsic.cabinetmedical.repositories;

import com.glsic.cabinetmedical.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Long> {

}
