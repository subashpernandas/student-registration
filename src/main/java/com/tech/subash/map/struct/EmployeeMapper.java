package com.tech.subash.map.struct;

import com.tech.subash.enums.EmployeeTypeEnum;
import com.tech.subash.dto.EmployeeDto;
import com.tech.subash.entity.EmployeeEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {

    @Mappings
            ({@Mapping(source = "dept.deptName", target = "dept"),
                    @Mapping(source = "employeeType", target = "employeeType", qualifiedByName = "stringToEnum")})
    EmployeeEntity convertFromDTO(EmployeeDto employeeDto);

    @Named("stringToEnum")
    default EmployeeTypeEnum mapStringToEnum(String type) {
        if (type == null) return null;
        return switch (type.toLowerCase()) {
            case "temporary" -> EmployeeTypeEnum.TEMPORARY;
            case "permanent" -> EmployeeTypeEnum.PERMANENT;
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
