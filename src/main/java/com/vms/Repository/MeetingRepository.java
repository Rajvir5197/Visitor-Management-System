package com.vms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.Model.MeetingBooking;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingBooking, Integer>{

}
