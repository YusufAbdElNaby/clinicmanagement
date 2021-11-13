package com.stc.clinicmanagement.enitities.converter;



import java.util.Objects;

import javax.persistence.AttributeConverter;

import org.springframework.util.StringUtils;

import com.stc.clinicmanagement.dto.CancellationReason;

public class CancellationReasonConverter implements AttributeConverter<CancellationReason, String> {
    @Override
    public String convertToDatabaseColumn(CancellationReason meetingPointStatus) {
        if (Objects.nonNull(meetingPointStatus)) {
            return meetingPointStatus.getDatabaseValue();
        }
        return null;
    }

    @Override
    public CancellationReason convertToEntityAttribute(String databaseValue) {
        if (StringUtils.isEmpty(databaseValue)) {
            return CancellationReason.of(databaseValue);
        }
        return null;
    }
}
