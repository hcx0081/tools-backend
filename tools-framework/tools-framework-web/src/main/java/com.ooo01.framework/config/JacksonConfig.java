package com.ooo01.framework.config;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * {@code @description:} Jackson序列化和反序列化配置类
 */
@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> builder
                .serializerByType(LocalDateTime.class,
                        new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN)))
                .serializerByType(LocalDate.class,
                        new LocalDateSerializer(DateTimeFormatter.ofPattern(DatePattern.NORM_DATE_PATTERN)))
                .serializerByType(LocalTime.class,
                        new LocalTimeSerializer(DateTimeFormatter.ofPattern(DatePattern.NORM_TIME_PATTERN)))
                .deserializerByType(LocalDateTime.class,
                        new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN)))
                .deserializerByType(LocalDate.class,
                        new LocalDateDeserializer(DateTimeFormatter.ofPattern(DatePattern.NORM_DATE_PATTERN)))
                .deserializerByType(LocalTime.class,
                        new LocalDateDeserializer(DateTimeFormatter.ofPattern(DatePattern.NORM_TIME_PATTERN)));
    }
}
