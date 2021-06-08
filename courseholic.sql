-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2021 at 05:29 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `courseholic`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `image` varchar(255) COLLATE utf32_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `image`) VALUES
(1, 'IT & Software', 'http://localhost:8080/img/category-it.jpg'),
(2, 'Marketing', 'http://localhost:8080/img/category-marketing.jpg'),
(3, 'Health', 'http://localhost:8080/img/category-health.jpg'),
(4, 'Design', 'http://localhost:8080/img/category-design.jpg'),
(5, 'Business', 'http://localhost:8080/img/category-business.jpg'),
(6, 'Music', 'http://localhost:8080/img/category-music.jpg'),
(7, 'Photography & Video', 'http://localhost:8080/img/category-photography.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` bigint(20) NOT NULL,
  `description` varchar(1000) COLLATE utf32_bin DEFAULT NULL,
  `is_public` bit(1) DEFAULT NULL,
  `last_updated` date DEFAULT NULL,
  `name` varchar(150) COLLATE utf32_bin DEFAULT NULL,
  `picture` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `video` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `category_id` bigint(20) NOT NULL,
  `language_id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf32_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `description`, `is_public`, `last_updated`, `name`, `picture`, `price`, `video`, `category_id`, `language_id`, `username`) VALUES
(4, 'Maecenas quam erat, imperdiet quis nulla fringilla, ultrices semper purus. Nulla dignissim leo vitae fermentum dignissim. Curabitur vestibulum, urna in luctus blandit, metus libero convallis nulla, eu efficitur tellus purus at justo. Sed vitae aliquam augue, tincidunt feugiat lacus. Pellentesque lacus orci, blandit ac iaculis non, lacinia vitae sapien. Vestibulum porta blandit arcu, ac mollis mauris suscipit sed. Curabitur lacinia hendrerit accumsan. In eleifend porta est, in pretium sapien luctus ac. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec vel massa et nisl luctus interdum ac nec tortor.\r\n\r\nFusce in egestas lectus, at lobortis turpis. Nullam nec efficitur nunc. Aliquam rutrum, mi eu bibendum mollis, nulla felis gravida lectus, ut iaculis dolor est sed lorem. Etiam bibendum sed elit a aliquet. Mauris semper facilisis consequat. Vestibulum vol', b'1', '2021-05-28', 'C++ Beginners Course', 'http://localhost:8080/img/course-cpp.jpg', 9.99, 'public/video/video2.mp4', 1, 1, 'mark00'),
(5, 'Description lorem ipsum bla bla', b'1', '2021-05-28', 'C# - From Zero to Hero', 'http://localhost:8080/img/course-csharp.jpg', 11.99, 'public/video/video3.mp4', 1, 1, 'mark00'),
(6, 'Aenean venenatis ut enim vel egestas. Pellentesque consequat orci maximus faucibus interdum. Mauris quis sapien lectus. Sed eu nulla id quam commodo euismod et sit amet felis. Cras luctus, sapien vitae blandit elementum, diam tellus finibus dolor, ut aliquet ipsum tortor ut eros. Donec facilisis sapien eget viverra malesuada. Nullam dolor justo, convallis eget quam sed, tempus molestie est. Donec in accumsan diam. Nulla ac nulla vehicula, pellentesque augue id, vehicula tellus. Sed tincidunt tristique tortor, eget dictum neque maximus non. Quisque malesuada nibh et dolor pretium, sit amet condimentum urna lobortis. Etiam aliquam maximus magna non tincidunt. Fusce rhoncus velit mauris, et volutpat ante blandit a.', b'1', '2021-06-06', 'Advanced JavaScript', 'http://localhost:8080/img/course-js.jpg', 17.99, NULL, 1, 1, 'jennifer1'),
(7, 'Donec bibendum, urna vitae euismod maximus, lectus turpis accumsan ante, vitae consequat urna ex a odio. Quisque molestie placerat risus finibus luctus. Curabitur ac lectus tristique, sagittis felis ac, laoreet erat. Vestibulum at enim vitae dolor auctor aliquet eu efficitur eros. Morbi commodo mollis mauris, a egestas diam sagittis a. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce pretium, odio a consequat ultricies, nibh erat aliquam tellus, eu fermentum enim augue id arcu. Ut turpis lorem, iaculis quis neque fermentum, sollicitudin commodo massa. Suspendisse pretium turpis ac rhoncus fringilla. Nullam neque mauris, interdum fringilla dictum nec, accumsan at diam.', b'1', '2021-06-08', 'JavaScript for Beginners', 'http://localhost:8080/img/course-javascript.jpg', 14.99, 'video1', 1, 1, 'donald12');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf32_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`id`, `name`) VALUES
(1, 'English'),
(2, 'Serbian');

-- --------------------------------------------------------

--
-- Table structure for table `lection`
--

CREATE TABLE `lection` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `video` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `section_id` bigint(20) NOT NULL,
  `length` varchar(255) COLLATE utf32_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `lection`
--

INSERT INTO `lection` (`id`, `description`, `name`, `video`, `section_id`, `length`) VALUES
(1, 'Lorem ipsum', 'Lection 1', 'public/video/lection1.mp4', 2, '03:55'),
(2, 'Lorem ipsum dolor', 'Lection 2', 'public/video/lection2.mp4', 2, '07:12'),
(3, 'Lorem ipsum dolor', 'Lection 3', 'public/video/lection3.mp4', 2, '05:24'),
(5, 'Lorem Ipsum', 'Lection 4', 'video', 3, '01:49'),
(6, 'Lorem ispum dolor', 'Lection 5', 'video', 3, '09:35');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_record`
--

CREATE TABLE `purchase_record` (
  `id` bigint(20) NOT NULL,
  `date_created` date DEFAULT NULL,
  `course_id` bigint(20) NOT NULL,
  `username` varchar(255) COLLATE utf32_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `purchase_record`
--

INSERT INTO `purchase_record` (`id`, `date_created`, `course_id`, `username`) VALUES
(1, '2021-05-10', 4, 'andra1233'),
(2, '2021-05-19', 4, 'john11'),
(3, '2021-05-30', 5, 'john11'),
(4, '2021-06-07', 4, 'madelyn12'),
(5, '2021-06-07', 5, 'madelyn12'),
(9, '2021-06-08', 6, 'madelyn12'),
(11, '2021-06-08', 6, 'mikki01'),
(12, '2021-06-08', 5, 'mikki01'),
(13, '2021-06-08', 4, 'pera332'),
(14, '2021-06-08', 5, 'pera332'),
(15, '2021-06-08', 7, 'nikola443'),
(16, '2021-06-07', 4, 'nikola443'),
(17, '2021-06-03', 5, 'nikola443'),
(18, '2021-06-07', 4, 'jeff_b12'),
(19, '2021-06-07', 6, 'jeff_b12'),
(20, '2021-06-06', 5, 'jeff_b12'),
(21, '2021-06-08', 7, 'jeff_b12');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` bigint(20) NOT NULL,
  `comment` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `course_id` bigint(20) NOT NULL,
  `username` varchar(255) COLLATE utf32_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `comment`, `date_created`, `rating`, `course_id`, `username`) VALUES
(1, 'Great course!', '2021-05-28', 5, 4, 'john11'),
(2, 'Bla bla', '2021-05-28', 4, 4, 'andra1233'),
(6, 'It is ok course.', '2021-05-30', 4, 5, 'john11'),
(7, 'Bla bla', '2021-06-05', 4, 4, 'jennifer1'),
(9, 'Lorem ipsum', '2021-06-07', 4, 5, 'madelyn12'),
(10, 'Lorem ipsum dolor', '2021-06-08', 5, 4, 'madelyn12'),
(11, 'Such a great course!', '2021-06-08', 5, 6, 'madelyn12'),
(12, 'It is ok course.', '2021-06-08', 4, 6, 'mikki01'),
(18, 'Great course!', '2021-06-08', 4, 5, 'mikki01');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf32_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'STUDENT'),
(2, 'AUTHOR'),
(3, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

CREATE TABLE `section` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `course_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`id`, `name`, `course_id`) VALUES
(2, 'Section 1', 4),
(3, 'Section 2', 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(255) COLLATE utf32_bin NOT NULL,
  `avatar` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf32_bin DEFAULT NULL,
  `password` varchar(64) COLLATE utf32_bin DEFAULT NULL,
  `description` varchar(1000) COLLATE utf32_bin DEFAULT NULL,
  `profession` varchar(255) COLLATE utf32_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `avatar`, `date_created`, `email`, `enabled`, `first_name`, `last_name`, `password`, `description`, `profession`) VALUES
('andra1233', 'http://localhost:8080/img/author-4.jpg', '2021-05-26', 'andra.bg@gmail.com', b'1', 'Andrej', 'Andrejevic', 'blabla123', NULL, NULL),
('donald12', 'http://localhost:8080/img/author-4.jpg', '2021-05-30', 'donald.smith@gmail.com', b'1', 'Donald', 'Smith', '$2a$10$T3hD.ZBlK.MDpAvJ34lhR.YQUfudjLCihueMo5tBkKCNBIcW2jBgu', 'Suspendisse at pharetra lacus. Suspendisse lorem mauris, lobortis sed sem quis, fringilla elementum augue. Donec turpis massa, sagittis in malesuada quis, tempus vitae turpis. Proin a congue purus. Integer eget ornare metus, et porttitor mauris. Pellentesque varius neque odio, at aliquam augue efficitur eget. Vivamus eget justo vitae metus egestas placerat eu non enim. Praesent euismod interdum ultrices. Nullam congue tristique mi eget interdum. Nullam laoreet leo sit amet ultricies luctus. Curabitur ornare aliquam neque vitae viverra. Praesent congue ultrices augue, ornare tristique est eleifend at. Quisque velit ante, placerat nec volutpat id, suscipit quis enim. Praesent euismod odio ut purus bibendum, nec suscipit nisi accumsan. Sed quis eros posuere, lacinia purus nec, interdum nisi. Integer sit amet sapien magna.', 'Front end Developer'),
('jeff_b12', 'http://localhost:8080/img/user.png', '2021-06-07', 'jeff@gmail.com', b'1', 'Jeff', 'Bezos', '$2a$10$T7NJ0TLaxNMoM2L6Ay5O.e.2730oC4nSrS/8Wlw0T1N2iBwrPcHzK', NULL, NULL),
('jennifer1', 'http://localhost:8080/img/author-1.jpg', '2021-06-04', 'jenny@gmail.com', b'1', 'Jennifer', 'Aniston', '$2a$10$wnGANMW1OaI749rCfXYLXujn4O9PDYrIQdoF3Z/hO44OuwhRLOaiy', 'Donec lobortis molestie felis. Nunc luctus euismod neque, at vehicula nibh venenatis sed. Nullam nisi nibh, maximus eu rhoncus eu, ultrices a velit. Praesent rhoncus mauris eget aliquet viverra. Nullam efficitur neque tempus, placerat tellus quis, venenatis urna. Pellentesque eu libero sit amet enim rutrum euismod. Integer sollicitudin nibh nec posuere rutrum. Maecenas eget maximus arcu, sollicitudin rutrum turpis. Vivamus blandit nisl nibh, in finibus tortor pharetra vestibulum. Morbi hendrerit placerat lacinia. Nam ornare, enim in posuere luctus, urna massa dictum metus, eu consectetur enim sapien pulvinar elit. Sed porttitor efficitur orci, id tincidunt tellus fermentum eget. Donec vel commodo mi. Nulla turpis felis, suscipit sed neque sagittis, dignissim auctor sapien. Vestibulum mattis ligula id purus ornare, id sodales est pellentesque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Professional Web Developer and Instructor'),
('john11', 'http://localhost:8080/img/user.png', '2021-05-28', 'john.smith@gmail.com', b'1', 'John', 'Smith', '$2a$10$Ufc7hwrbGD7Mi0.rBKyE/OHee1ZKtfjWZ.z0QnKvvN7o..izvT6py', NULL, NULL),
('madelyn12', 'http://localhost:8080/download/madelyn.jpg', '2021-06-07', 'madelyn@gmail.com', b'1', 'Madelyn', 'Jackson', '$2a$10$EIkM6111aQ99j7YnO06fcujs3ZX03lqAeVBAXLEKCr5cMxfWpw5qS', NULL, 'Student'),
('mark00', 'http://localhost:8080/img/author-3.jpg\r\n', '2021-05-28', 'mark.doe@gmail.com', b'1', 'Mark', 'Doe', '$2a$10$ppb7URRHEMDyqQzX.tjYpenZ127Fcqp9M4lbno2TcwQpf0DyTJyFO', 'Morbi eu cursus lectus. Nam posuere consectetur diam, a imperdiet urna sollicitudin vitae. Sed et lacinia enim. Fusce malesuada felis at mauris feugiat pellentesque. Aenean non felis vel risus hendrerit aliquet. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nam tincidunt aliquam est non pharetra. Nam facilisis maximus purus a mollis. Praesent vehicula enim a enim luctus, ut consectetur urna semper. Maecenas tincidunt, tellus vel malesuada scelerisque, arcu sapien ultricies justo, et ultrices mauris turpis non turpis. Aenean fermentum accumsan leo in iaculis. Fusce mollis odio ut pulvinar bibendum. Quisque faucibus vitae ante id commodo.\r\n\r\nVivamus dapibus, felis quis interdum posuere, nunc urna ullamcorper dolor, in luctus eros lorem eget lorem. Integer elit nunc, placerat cursus placerat molestie, rhoncus ac felis. Fusce efficitur consectetur erat. Maecenas a ex fermentum metus porta vulputate nec sed massa. Donec pharetra aliquam finibus. Int', 'Software Engineer'),
('mikki01', 'http://localhost:8080/download/mikki.jpg', '2021-06-08', 'mick@gmail.com', b'1', 'Mick', 'Fauchi', '$2a$10$9JjcukVlOqzIpF5Z2tKPwObIz9d02xrJ1XHYVko7xD99CUw..mULq', NULL, NULL),
('nikola443', 'http://localhost:8080/img/user.png', '2021-06-07', 'nikola@gmail.com', b'1', 'Nikola', 'Nikolic', '$2a$10$CaosR648NVw5nl7HmezaxeH8ZuP/2wWEg96HJ17OkuGkuy1upkNYi', NULL, NULL),
('pera332', 'http://localhost:8080/img/user.png', '2021-06-07', 'pera12@gmail.com', b'1', 'Petar', 'Petrovic', '$2a$10$V6PXIuWWh5MFHdLWYLYxeOlkola6Sg2R27GNuO6wYX8gtdaIKlNPm', NULL, NULL),
('sergej99', 'http://localhost:8080/img/user.png', '2021-06-08', 'sergej.kubat18@gmail.com', b'1', 'Sergej', 'Kubat', '$2a$10$4qt619Q.QlGlHJ7SIgv7qu8oQb5WlUIICMbJnHGdpmbaKauv2kB6e', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `username` varchar(255) COLLATE utf32_bin NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`username`, `role_id`) VALUES
('andra1233', 1),
('donald12', 1),
('donald12', 2),
('jeff_b12', 1),
('jennifer1', 1),
('jennifer1', 2),
('john11', 1),
('madelyn12', 1),
('mark00', 2),
('mikki01', 1),
('nikola443', 1),
('pera332', 1),
('sergej99', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_4xqvdpkafb91tt3hsb67ga3fj` (`name`),
  ADD KEY `FKkyes7515s3ypoovxrput029bh` (`category_id`),
  ADD KEY `FKfkhqlhm1awgxvson7yy8ldh16` (`language_id`),
  ADD KEY `FK82mten29t8qrqqc5ai324e147` (`username`);

--
-- Indexes for table `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lection`
--
ALTER TABLE `lection`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKraawwdfxbh5p8ve89cvbom56l` (`section_id`);

--
-- Indexes for table `purchase_record`
--
ALTER TABLE `purchase_record`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK404txd7aunf9el3my413mb5f6` (`course_id`),
  ADD KEY `FK5ajmgtoyq0shfx1nupjinfeu7` (`username`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKprox8elgnr8u5wrq1983degk` (`course_id`),
  ADD KEY `FK117o6riye2xefmyeaanbvdx1i` (`username`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoy8uc0ftpivwopwf5ptwdtar0` (`course_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`username`,`role_id`),
  ADD KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `language`
--
ALTER TABLE `language`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lection`
--
ALTER TABLE `lection`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `purchase_record`
--
ALTER TABLE `purchase_record`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `section`
--
ALTER TABLE `section`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FK82mten29t8qrqqc5ai324e147` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FKfkhqlhm1awgxvson7yy8ldh16` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`),
  ADD CONSTRAINT `FKkyes7515s3ypoovxrput029bh` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `lection`
--
ALTER TABLE `lection`
  ADD CONSTRAINT `FKraawwdfxbh5p8ve89cvbom56l` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`);

--
-- Constraints for table `purchase_record`
--
ALTER TABLE `purchase_record`
  ADD CONSTRAINT `FK404txd7aunf9el3my413mb5f6` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `FK5ajmgtoyq0shfx1nupjinfeu7` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK117o6riye2xefmyeaanbvdx1i` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FKprox8elgnr8u5wrq1983degk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

--
-- Constraints for table `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `FKoy8uc0ftpivwopwf5ptwdtar0` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKo2j0svxgcf9yhw4j1iboj61yq` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
