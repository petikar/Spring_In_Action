package petikar.factory_of_houses.domain;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import petikar.factory_of_houses.domain.udt.HouseUDTUtils;
import petikar.factory_of_houses.domain.udt.PartUDT;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("houses")
public class House {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private UUID id = Uuids.timeBased();

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Date createdAt = new Date();

    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Column("parts")
    @Size(min = 6, max = 6, message = "You must choose each part once")
    private List<PartUDT> parts = new ArrayList<>();

    public void addPart(Part part) {
        this.parts.add(HouseUDTUtils.toPartUDT(part));
    }
}
