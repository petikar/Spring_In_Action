package petikar.factory_of_houses.domain.udt;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import petikar.factory_of_houses.domain.Part;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@UserDefinedType("part")

public class PartUDT {

    private final String name;
    private final Part.Type type;
}
