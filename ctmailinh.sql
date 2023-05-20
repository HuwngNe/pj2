-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 20, 2023 lúc 05:15 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ctmailinh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` int(10) UNSIGNED NOT NULL,
  `employee_id` int(10) UNSIGNED DEFAULT NULL,
  `customer_id` int(10) UNSIGNED DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `permission_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `employee_id`, `customer_id`, `username`, `password`, `permission_id`) VALUES
(5, NULL, 6, 'tin123', '25d55ad283aa400af464c76d713c07ad', 1),
(6, NULL, NULL, 'admin', '25f9e794323b453885f5181f1b624d0b', 2),
(7, 5, NULL, 'abc123', '25f9e794323b453885f5181f1b624d0b', 3),
(8, NULL, 7, 'hung123', '25d55ad283aa400af464c76d713c07ad', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bonus`
--

CREATE TABLE `bonus` (
  `id` int(11) UNSIGNED NOT NULL,
  `id_salary` int(11) UNSIGNED NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pay` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bonus`
--

INSERT INTO `bonus` (`id`, `id_salary`, `name`, `pay`) VALUES
(2, 1, 'Thưởng tích cực', '5000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(11) UNSIGNED NOT NULL,
  `ID_card` varchar(100) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `birthday` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `ID_card`, `fullname`, `gender`, `birthday`, `address`, `phone`) VALUES
(6, 'Hà Nội', 'tin ab', 'male', '05-04-2000', 'Hà Nội', '0987667654'),
(7, NULL, 'hung', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `id` int(11) UNSIGNED NOT NULL,
  `ID_card` varchar(100) DEFAULT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `birthday` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `salary` varchar(200) NOT NULL,
  `status_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`id`, `ID_card`, `fullname`, `gender`, `birthday`, `address`, `phone`, `salary`, `status_id`) VALUES
(1, '123123123', 'hung', 'male', '30-08-1998', 'Hà Nội', '9686786776', '20000000', 1),
(2, '923423412123', 'Nguyễn Văn A', 'male', '25-03-1991', 'Hà Nam', '056762341265', '12000000', 1),
(3, '923423412233', 'Nguyễn Văn B', 'male', '28-06-1993', 'Nam ĐỊnh', '056762341989', '12000000', 1),
(4, '92342341979', 'Nguyễn thị F', 'female', '24-08-1994', 'Hà Nội', '05676235213', '14000000', 1),
(5, '12312312100', 'Trần thị C', 'female', '05-04-1994', 'Hà Nội', '0567412121', '14000000', 1),
(6, '91232098789', 'Lương Quy Trường', 'male', '04-01-1996', 'Hà Nội', '0981231234', '17000000', 1),
(7, '91232098098', 'Lương thị Chi', 'female', '04-01-1996', 'Hà Nội', '0981235321', '15000000', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hire`
--

CREATE TABLE `hire` (
  `id` int(11) UNSIGNED NOT NULL,
  `vehice_id` int(11) UNSIGNED DEFAULT NULL,
  `employee_id` int(11) UNSIGNED DEFAULT NULL,
  `customer_id` int(11) UNSIGNED DEFAULT NULL,
  `total_price` varchar(100) DEFAULT NULL,
  `status_hire_id` int(10) UNSIGNED DEFAULT NULL,
  `status_correct_id` int(10) UNSIGNED DEFAULT NULL,
  `status_payment_id` int(10) UNSIGNED DEFAULT NULL,
  `account_correct_id` int(10) UNSIGNED DEFAULT NULL,
  `start_date` varchar(100) DEFAULT NULL,
  `end_date` varchar(100) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hire`
--

INSERT INTO `hire` (`id`, `vehice_id`, `employee_id`, `customer_id`, `total_price`, `status_hire_id`, `status_correct_id`, `status_payment_id`, `account_correct_id`, `start_date`, `end_date`, `created_at`) VALUES
(2, 6, 3, 6, '20000000', 2, 2, 2, 6, '05-07-2023 22:00', '09-07-2023 22:00', '2023-05-19 01:10:02'),
(4, 2, 6, 7, '28000000', 2, 2, 2, 6, '05-07-2023 22:00', '09-07-2023 22:00', '2023-05-19 02:46:48'),
(5, 6, 2, 6, '6000000', 2, 2, 2, 6, '09-07-2023 22:00', '13-07-2023 22:00', '2023-05-20 03:07:52');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `info_company`
--

CREATE TABLE `info_company` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` longtext NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `info_company`
--

INSERT INTO `info_company` (`id`, `name`, `email`, `address`, `phone`) VALUES
(1, 'CÔNG TY MAI LINH', 'mailinh@gmail.com', 'Số 7 Đường BSA, DB, DB', '0988123231');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `office`
--

CREATE TABLE `office` (
  `id` int(11) UNSIGNED NOT NULL,
  `id_employee` int(11) UNSIGNED DEFAULT NULL,
  `position_id` int(10) UNSIGNED DEFAULT NULL,
  `start` varchar(100) DEFAULT NULL,
  `end` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `office`
--

INSERT INTO `office` (`id`, `id_employee`, `position_id`, `start`, `end`) VALUES
(1, 1, 1, '03-04-2020', '17-06-2022'),
(2, 2, 4, '04-06-2015', NULL),
(3, 3, 4, '04-06-2016', NULL),
(4, 4, 2, '04-06-2015', NULL),
(5, 5, 3, '06-06-2017', NULL),
(6, 6, 3, '06-06-2018', NULL),
(7, 7, 4, '06-06-2018', NULL),
(13, 1, 2, '03-08-2022', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `permission`
--

CREATE TABLE `permission` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `permission`
--

INSERT INTO `permission` (`id`, `name`) VALUES
(1, 'Người dùng'),
(2, 'Quản trị'),
(3, 'Nhân viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `position`
--

CREATE TABLE `position` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `position`
--

INSERT INTO `position` (`id`, `name`) VALUES
(1, 'Giám đốc bộ phận'),
(2, 'Quản lý'),
(3, 'Nhân viên chăm sóc khách hàng'),
(4, 'Lái xe');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `salary`
--

CREATE TABLE `salary` (
  `id` int(11) UNSIGNED NOT NULL,
  `id_employee` int(11) UNSIGNED DEFAULT NULL,
  `overtime` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `total_salary` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `salary`
--

INSERT INTO `salary` (`id`, `id_employee`, `overtime`, `date`, `total_salary`) VALUES
(1, 1, '10000', '13-02-2000', '25010000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sales_report`
--

CREATE TABLE `sales_report` (
  `id` int(11) UNSIGNED NOT NULL,
  `date` varchar(100) DEFAULT NULL,
  `total_price` varchar(100) DEFAULT NULL,
  `total_hire` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sales_report`
--

INSERT INTO `sales_report` (`id`, `date`, `total_price`, `total_hire`, `created_at`) VALUES
(6, '2023-05-19', '48000000', 2, '2023-05-20 03:05:42');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status`
--

CREATE TABLE `status` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `status`
--

INSERT INTO `status` (`id`, `name`) VALUES
(1, 'Chưa thuê'),
(2, 'Đã thuê');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status_correct`
--

CREATE TABLE `status_correct` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `status_correct`
--

INSERT INTO `status_correct` (`id`, `name`) VALUES
(1, 'Đang chờ xác nhận'),
(2, 'Đã xác nhận');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status_hire`
--

CREATE TABLE `status_hire` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `status_hire`
--

INSERT INTO `status_hire` (`id`, `name`) VALUES
(1, 'Đang thuê'),
(2, 'Đã trả'),
(3, 'Chưa lấy xe');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status_payment`
--

CREATE TABLE `status_payment` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `status_payment`
--

INSERT INTO `status_payment` (`id`, `name`) VALUES
(1, 'Chưa thanh toán'),
(2, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vehice`
--

CREATE TABLE `vehice` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `testing_date` varchar(100) DEFAULT NULL,
  `number_of_seats` int(11) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `license_plates` varchar(100) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `status` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `vehice`
--

INSERT INTO `vehice` (`id`, `name`, `testing_date`, `number_of_seats`, `color`, `license_plates`, `price`, `status`) VALUES
(1, 'abcd', '03-04-2018', 4, 'đỏ', '29H-12334', '4000000', 1),
(2, 'abcádrt', '07-03-2021', 16, 'xanh', '29H-624234', '7000000', 1),
(3, 'abcádrt', '15-02-2022', 16, 'xanh', '30H-92341', '7000000', 1),
(4, 'abcádrt', '15-02-2022', 16, 'đỏ', '30H-51217', '7000000', 1),
(5, 'tầhưẻ', '15-02-2022', 8, 'đỏ', '30H-91822', '6000000', 1),
(6, 'Mer', '15-02-2022', 4, 'đen', '30H-11111', '12000000', 1),
(7, 'Mer', '15-02-2022', 4, 'xám', '30H-11112', '12000000', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `employee_id` (`employee_id`),
  ADD KEY `permission_id` (`permission_id`);

--
-- Chỉ mục cho bảng `bonus`
--
ALTER TABLE `bonus`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `id_salary` (`id_salary`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status_id` (`status_id`);

--
-- Chỉ mục cho bảng `hire`
--
ALTER TABLE `hire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `employee_id` (`employee_id`),
  ADD KEY `vehice_id` (`vehice_id`),
  ADD KEY `status_correct_id` (`status_correct_id`),
  ADD KEY `status_hire_id` (`status_hire_id`),
  ADD KEY `status_payment_id` (`status_payment_id`),
  ADD KEY `account_correct_id` (`account_correct_id`);

--
-- Chỉ mục cho bảng `info_company`
--
ALTER TABLE `info_company`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `office`
--
ALTER TABLE `office`
  ADD PRIMARY KEY (`id`),
  ADD KEY `position_workday_ibfk_1` (`id_employee`),
  ADD KEY `position_id` (`position_id`);

--
-- Chỉ mục cho bảng `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_employee` (`id_employee`);

--
-- Chỉ mục cho bảng `sales_report`
--
ALTER TABLE `sales_report`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `status_correct`
--
ALTER TABLE `status_correct`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `status_hire`
--
ALTER TABLE `status_hire`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `status_payment`
--
ALTER TABLE `status_payment`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `vehice`
--
ALTER TABLE `vehice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status` (`status`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `bonus`
--
ALTER TABLE `bonus`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `hire`
--
ALTER TABLE `hire`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `info_company`
--
ALTER TABLE `info_company`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `office`
--
ALTER TABLE `office`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `permission`
--
ALTER TABLE `permission`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `position`
--
ALTER TABLE `position`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `salary`
--
ALTER TABLE `salary`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sales_report`
--
ALTER TABLE `sales_report`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `status`
--
ALTER TABLE `status`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `status_correct`
--
ALTER TABLE `status_correct`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `status_hire`
--
ALTER TABLE `status_hire`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `status_payment`
--
ALTER TABLE `status_payment`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `vehice`
--
ALTER TABLE `vehice`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `account_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `account_ibfk_3` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`);

--
-- Các ràng buộc cho bảng `bonus`
--
ALTER TABLE `bonus`
  ADD CONSTRAINT `bonus_ibfk_1` FOREIGN KEY (`id_salary`) REFERENCES `salary` (`id`);

--
-- Các ràng buộc cho bảng `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

--
-- Các ràng buộc cho bảng `hire`
--
ALTER TABLE `hire`
  ADD CONSTRAINT `hire_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `hire_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `hire_ibfk_3` FOREIGN KEY (`vehice_id`) REFERENCES `vehice` (`id`),
  ADD CONSTRAINT `hire_ibfk_4` FOREIGN KEY (`status_correct_id`) REFERENCES `status_correct` (`id`),
  ADD CONSTRAINT `hire_ibfk_5` FOREIGN KEY (`status_hire_id`) REFERENCES `status_hire` (`id`),
  ADD CONSTRAINT `hire_ibfk_6` FOREIGN KEY (`status_payment_id`) REFERENCES `status_payment` (`id`),
  ADD CONSTRAINT `hire_ibfk_7` FOREIGN KEY (`account_correct_id`) REFERENCES `account` (`id`);

--
-- Các ràng buộc cho bảng `office`
--
ALTER TABLE `office`
  ADD CONSTRAINT `office_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `office_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`);

--
-- Các ràng buộc cho bảng `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`);

--
-- Các ràng buộc cho bảng `vehice`
--
ALTER TABLE `vehice`
  ADD CONSTRAINT `vehice_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
