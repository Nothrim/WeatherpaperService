package com.nothrim.database.repositories.images;

import com.nothrim.database.models.images.ApiCall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface APICallRepository extends JpaRepository<ApiCall, Long> {
    ApiCall findFirstByCall(String call);

    ApiCall findByLastCallAfter(Date lastCall);

    ApiCall findByLastCallBefore(Date lastCall);
}