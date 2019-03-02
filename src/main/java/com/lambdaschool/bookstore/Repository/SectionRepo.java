package com.lambdaschool.bookstore.Repository;

import com.lambdaschool.bookstore.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepo extends JpaRepository<Section, Long>
{
}
