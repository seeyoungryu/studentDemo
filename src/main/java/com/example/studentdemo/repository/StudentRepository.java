package com.example.studentdemo.repository;

//StudentRepository -> 데이터베이스와 상호작용하는 레파지토리 객체임
//데이터 접근 및 조작을 담당합니다.
//이는 데이터베이스와의 통신을 캡슐화하여 비즈니스 로직이 데이터 접근 코드를 직접 다루지 않도록 합니다.

import com.example.studentdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//스프링 데이터 JPA에서 제공하는 기본 CRUD 및 페이징 기능을 갖춘 레포지토리 인터페이스입니다.

public interface StudentRepository extends JpaRepository<Student, Long> {
}

/*
인터페이스로 사용하는 이유
추상화:
레포지토리를 인터페이스로 정의함으로써 데이터 접근 로직을 추상화할 수 있습니다.
이는 *데이터 접근 로직과 비즈니스 로직을 분리*하여 유지보수성을 높이고, 코드의 응집도를 높이는 데 도움이 됩니다.

스프링 데이터 JPA의 자동 구현:
스프링 데이터 JPA는 런타임에 JpaRepository 인터페이스를 자동으로 구현하여,
개발자가 별도로 구현 클래스를 작성할 필요 없이 기본적인 CRUD 메서드를 사용할 수 있도록 합니다.

유연성:
인터페이스를 사용하면 필요에 따라 추가적인 메서드를 정의하고 구현할 수 있습니다.
또한, 인터페이스를 통해 여러 구현체를 쉽게 교체할 수 있습니다.
 */



/* JPA 기본 제공 메서드
JpaRepository 인터페이스는 다양한 CRUD 및 페이징 메서드를 제공합니다.

save(S entity): 엔티티를 저장하거나 업데이트합니다.
findById(ID id): ID로 엔티티를 조회합니다.
findAll(): 모든 엔티티를 조회합니다.
deleteById(ID id): ID로 엔티티를 삭제합니다.
existsById(ID id): 해당 ID의 엔티티가 존재하는지 확인합니다.
 */
