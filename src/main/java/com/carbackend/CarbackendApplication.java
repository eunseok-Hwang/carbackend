package com.carbackend;

import com.carbackend.domain.AppUser;
import com.carbackend.domain.Car;
import com.carbackend.domain.repository.AppUserRepository;
import com.carbackend.domain.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class CarbackendApplication implements CommandLineRunner {

    private final CarRepository carRepository;
    private final AppUserRepository appUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarbackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        carRepository.save(Car.builder()
                .brand("Ford")
                .model("Mustang")
                .color("Red")
                .registrationNumber("ADF-1121")
                .modelYear(2023)
                .price(59000)
                .build());
        carRepository.save(Car.builder()
                .brand("Hyundai")
                .model("Sonata")
                .color("gray")
                .registrationNumber("DN8-3351")
                .modelYear(2023)
                .price(27880)
                .build());
        carRepository.save(Car.builder()
                .brand("Genesis")
                .model("Genesis G80")
                .color("white")
                .registrationNumber("GEN-5809")
                .modelYear(2025)
                .price(63000)
                .build());
        for(Car car : carRepository.findAll()) {
            log.info("brand: {}, model: {}", car.getBrand(), car.getModel());
        }

        //username: user, password: user
        appUserRepository.save(AppUser.builder()
                .username("user")
                .password("user")
                .role("USER")
                .build());

        // username: admin, password: admin
        appUserRepository.save(AppUser.builder()
                .username("admin")
                .password("admin")
                .role("ADMIN")
                .build());
    }
}
