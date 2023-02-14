package com.lmt.fabricanteback.utils.audit;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditDocument {

	@CreatedDate
	private LocalDateTime createDate;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

}
