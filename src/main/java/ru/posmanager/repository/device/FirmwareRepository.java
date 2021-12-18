package ru.posmanager.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.posmanager.model.device.Firmware;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface FirmwareRepository extends JpaRepository<Firmware, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Firmware f WHERE f.id = :id")
    int delete(@Param("id") int id);

    @Query("SELECT f FROM Firmware f ORDER BY f.vendor.name, f.version")
    List<Firmware> getAll();

    @Query("SELECT f FROM Firmware f WHERE f.vendor.id = :vendor_id AND f.version = :version")
    Firmware getByVendorAndVersion(@Param("vendor_id") int vendorId, @Param("version") String version);
}