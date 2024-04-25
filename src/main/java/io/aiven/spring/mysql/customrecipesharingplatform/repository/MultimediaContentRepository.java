package io.aiven.spring.mysql.customrecipesharingplatform.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.aiven.spring.mysql.customrecipesharingplatform.entity.MultimediaContent;

@Repository
public interface MultimediaContentRepository extends JpaRepository<MultimediaContent, Long> {
}
