package com.jh.hotelbookingmanagement.configuration;

import java.util.HashSet;

import com.jh.hotelbookingmanagement.constant.PredefinedPictureCategory;
import com.jh.hotelbookingmanagement.entity.Picture;
import com.jh.hotelbookingmanagement.entity.PictureCategory;
import com.jh.hotelbookingmanagement.repository.*;
import com.jh.hotelbookingmanagement.service.SqlFileExecutorService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jh.hotelbookingmanagement.constant.PredefinedRole;
import com.jh.hotelbookingmanagement.entity.Role;
import com.jh.hotelbookingmanagement.entity.User;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    SqlFileExecutorService sqlFileExecutorService;
    PasswordEncoder passwordEncoder;

    @NonFinal
    static final String ADMIN_USER_NAME = "admin";

    @NonFinal
    static final String ADMIN_PASSWORD = "admin";

    @Bean
    @ConditionalOnProperty(
            prefix = "spring",
            value = "datasource.driverClassName",
            havingValue = "com.mysql.cj.jdbc.Driver")
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository, PictureCategoryRepository pictureCategoryRepository, BookingMethodRepository bookingMethodRepository,
                                        BookingStatusRepository bookingStatusRepository,
                                        PaymentTypeRepository paymentTypeRepository) {
        log.info("Initializing application.....");
        return args -> {
            if (userRepository.findByUsername(ADMIN_USER_NAME).isEmpty()) {
                roleRepository.save(Role.builder()
                        .name(PredefinedRole.USER_ROLE)
                        .description("User role")
                        .build());

                Role adminRole = roleRepository.save(Role.builder()
                        .name(PredefinedRole.ADMIN_ROLE)
                        .description("Admin role")
                        .build());

                var roles = new HashSet<Role>();
                roles.add(adminRole);

                User user = User.builder()
                        .username(ADMIN_USER_NAME)
                        .password(passwordEncoder.encode(ADMIN_PASSWORD))
                        .roles(roles)
                        .build();

                userRepository.save(user);
                log.warn("admin user has been created with default password: admin, please change it");
            }
            if(pictureCategoryRepository.findAll().isEmpty()){
                pictureCategoryRepository.save(PictureCategory.builder()
                        .categoryName(PredefinedPictureCategory.ROOM)
                        .description("Room Picture")
                        .build());
                log.warn("ROOM and BRANCH have been initial added into picture category");

                pictureCategoryRepository.save(PictureCategory.builder()
                        .categoryName(PredefinedPictureCategory.BRANCH)
                        .description("Branch Picture")
                        .build());
                log.warn("ROOM and BRANCH have been initial added into picture category");
            }
            if(bookingMethodRepository.findAll().isEmpty()){
                sqlFileExecutorService.executeSqlFile("InsertBookingMethod.sql");
                log.warn("Initialize Booking Method");
            }

            if(bookingStatusRepository.findAll().isEmpty()){
                sqlFileExecutorService.executeSqlFile("InsertBookingStatuses.sql");
                log.warn("Initialize Booking Status");
            }

            if(paymentTypeRepository.findAll().isEmpty()){
                sqlFileExecutorService.executeSqlFile("InsertPaymentType.sql");
                log.warn("Initialize Payment Type");
            }
            log.info("Application initialization completed .....");
            
        };
    }
}
