package info.startupbuilder.backendstarterpack.infrastructure;

import info.startupbuilder.backendstarterpack.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
}
