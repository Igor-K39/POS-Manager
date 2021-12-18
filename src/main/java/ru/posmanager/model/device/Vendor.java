package ru.posmanager.model.device;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.posmanager.model.NamedEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "vendor")
@Access(AccessType.FIELD)
public class Vendor extends NamedEntity {

    public Vendor(Vendor vendor) {
        this(vendor.id, vendor.name);
    }

    public Vendor(String name) {
        this(null, name);
    }

    public Vendor(Integer id, String name) {
        super(id, name);
    }
}
