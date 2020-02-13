INSERT INTO `person`(`id`, `drivingLicenseNumber`, `drivingLicenseValidTo`) VALUES (1, 'AB123', '2020-12-31');
INSERT INTO `person`(`id`, `drivingLicenseNumber`, `drivingLicenseValidTo`) VALUES (2, 'AB124', '2021-01-25');
INSERT INTO `person`(`id`, `drivingLicenseNumber`, `drivingLicenseValidTo`) VALUES (3, 'AB155', '2021-01-25');

INSERT INTO `creditcard`(`id`, `person_id`) VALUES (1, 1);
INSERT INTO `creditcard`(`id`, `person_id`) VALUES (2, 1);
INSERT INTO `creditcard`(`id`, `person_id`) VALUES (3, 2);
INSERT INTO `creditcard`(`id`, `person_id`) VALUES (4, 3);
INSERT INTO `creditcard`(`id`, `person_id`) VALUES (5, 1);
INSERT INTO `creditcard`(`id`, `person_id`) VALUES (6, 2);

INSERT INTO `car`(`id`, `car_type`, `brand`, `model`, `state`, `image`) VALUES (1, 'DEFAULT', 'BMW', 'i3', 'FREE', 'bmwi3.jpg');
INSERT INTO `car`(`id`, `car_type`, `brand`, `model`, `state`, `image`) VALUES (2, 'SPORT', 'BMW', 'i8', 'RENTED', 'bmwi8.jpg');
INSERT INTO `car`(`id`, `car_type`, `brand`, `model`, `state`, `image`) VALUES (3, 'SPORT', 'TESLA', 'MODEL S', 'RENTED', 'teslamodels.jpg');
INSERT INTO `car`(`id`, `car_type`, `brand`, `model`, `state`, `image`) VALUES (4, 'DEFAULT', 'SKODA', 'CITIGOe iV', 'FREE', 'skodacitigoeiv.jpg');
INSERT INTO `car`(`id`, `car_type`, `brand`, `model`, `state`, `image`) VALUES (5, 'DEFAULT', 'AUDI', 'E-TRON', 'FREE', 'audietron.jpg');

INSERT INTO `insurance`(`id`, `insuranceFrom`, `insuranceTo`, `car_id`) VALUES (1, '2018-01-01', '2018-12-31', 1);
INSERT INTO `insurance`(`id`, `insuranceFrom`, `insuranceTo`, `car_id`) VALUES (2, '2019-01-01', '2019-12-31', 1);
INSERT INTO `insurance`(`id`, `insuranceFrom`, `insuranceTo`, `car_id`) VALUES (3, '2020-01-01', '2020-12-31', 1);
INSERT INTO `insurance`(`id`, `insuranceFrom`, `insuranceTo`, `car_id`) VALUES (4, '2020-01-01', '2020-12-31', 2);
INSERT INTO `insurance`(`id`, `insuranceFrom`, `insuranceTo`, `car_id`) VALUES (5, '2020-01-01', '2020-12-31', 3);
INSERT INTO `insurance`(`id`, `insuranceFrom`, `insuranceTo`, `car_id`) VALUES (6, '2020-01-01', '2020-12-31', 4);
INSERT INTO `insurance`(`id`, `insuranceFrom`, `insuranceTo`, `car_id`) VALUES (7, '2020-01-01', '2020-12-31', 5);

INSERT INTO `hire`(`id`, `start`, `finish`, `car_id`, `person_id`) VALUES (1, '2020-01-01T11:00:00.00Z', '2020-01-01T11:30:00.00Z', 1, 1);
INSERT INTO `hire`(`id`, `start`, `finish`, `car_id`, `person_id`) VALUES (2, '2020-01-02T09:25:00.00Z', '2020-01-05T12:50:00.00Z', 2, 1);
INSERT INTO `hire`(`id`, `start`, `finish`, `car_id`, `person_id`) VALUES (3, '2020-01-03T09:25:00.00Z', NULL, 2, 1);
INSERT INTO `hire`(`id`, `start`, `finish`, `car_id`, `person_id`) VALUES (4, '2020-02-01T09:25:00.00Z', NULL, 3, 3);
INSERT INTO `hire`(`id`, `start`, `finish`, `car_id`, `person_id`) VALUES (5, '2020-02-05T06:55:00.00Z', '2020-02-05T07:20:00.00Z', 4, 2);
INSERT INTO `hire`(`id`, `start`, `finish`, `car_id`, `person_id`) VALUES (6, '2020-02-05T09:55:00.00Z', '2020-02-07T09:55:00.00Z', 5, 2);