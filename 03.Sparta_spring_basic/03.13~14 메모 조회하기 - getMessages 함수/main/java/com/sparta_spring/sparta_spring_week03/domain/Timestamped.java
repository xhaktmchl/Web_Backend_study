package com.sparta_spring.sparta_spring_week03.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter // getter
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
public abstract class Timestamped {//abstract 추상형: new로 생성 못함

    @CreatedDate // 생성날짜
    private LocalDateTime createdAt;

    @LastModifiedDate// 마지막 수정낳=ㄹ짜
    private LocalDateTime modifiedAt;

}
