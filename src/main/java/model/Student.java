package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

}

/*
<생성자 관련 어노테이션>
@NoArgsConstructor: 파라미터가 없는 기본 생성자를 생성합니다.
@AllArgsConstructor: 모든 필드를 파라미터로 받는 생성자를 생성합니다.
@RequiredArgsConstructor: final 또는 @NonNull 필드를 파라미터로 받는 생성자를 생성합니다.
 */


/*
<JPA의 기본 키 생성 전략>
Java와 JPA: @GeneratedValue(strategy = GenerationType.IDENTITY) 어노테이션을 사용하여 엔티티의 기본 키 생성을 자동화
자동 증가: 새로운 행이 삽입될 때마다 값이 자동으로 증가
*/


//... getter, setter