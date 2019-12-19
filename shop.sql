-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Дек 12 2019 г., 11:13
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `shop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `category`) VALUES
(1, 'cognac'),
(2, 'cigars'),
(3, 'whisky');

-- --------------------------------------------------------

--
-- Структура таблицы `images`
--

CREATE TABLE IF NOT EXISTS `images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Дамп данных таблицы `images`
--

INSERT INTO `images` (`id`, `image`) VALUES
(1, 'remy-vsop.jpg'),
(2, 'remy-xo.jpg'),
(3, 'macanudo.jpg'),
(4, 'remyvs.jpg'),
(5, 'camacho.jpg'),
(6, 'davidoff.jpg'),
(7, 'glenfiddich18.jpg'),
(8, 'balvenie.jpg');

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Структура таблицы `prodcat`
--

CREATE TABLE IF NOT EXISTS `prodcat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Дамп данных таблицы `prodcat`
--

INSERT INTO `prodcat` (`id`, `product_id`, `category_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 2),
(5, 5, 2),
(6, 6, 2),
(7, 7, 3),
(8, 8, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `productimage`
--

CREATE TABLE IF NOT EXISTS `productimage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `image_id` (`image_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Дамп данных таблицы `productimage`
--

INSERT INTO `productimage` (`id`, `product_id`, `image_id`) VALUES
(1, 1, 1),
(2, 3, 2),
(3, 2, 4),
(4, 5, 5),
(5, 6, 6),
(6, 7, 7),
(7, 8, 8),
(8, 4, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Дамп данных таблицы `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `price`) VALUES
(1, 'Remy Martin VSOP', 'cognac 2', 2000),
(2, 'Remy Martin VS', 'cognac 1', 1000),
(3, 'Remy Martin XO', 'cognac 3', 3000),
(4, 'Macanudo Maduro', 'cigar 1', 300),
(5, 'Camacho Connecticut', 'cigar 2', 500),
(6, 'Davidoff Churchill', 'cigar 3', 800),
(7, 'GlenFiddich 18', 'Whiskey 1', 2500),
(8, 'Balvenie Tripple Cask', 'Whiskey 2', 2100),
(9, 'Zacapa 23', 'Rum 1', 1800);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `location` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `location`, `gender`, `comment`) VALUES
(14, 'com4.app.main@gmail.com', '-509e2330cff459af2572de9b2f817b8e', 'aaaaaaa', 'aaaaaaaa', 'my comment is simple'),
(16, 'admin', '-74cac2a33f81eca889f78ee0b9fd0349', 'aaaaaaa', 'aaaaaaaa', 'nothing'),
(17, 'user1', '-12d4e0b973a06ea0c0e308a28f974552', 'kiev', 'male', 'nice site'),
(18, 'com5.app@gmail.com', '-509e2330cff459af2572de9b2f817b8e', 'dnr', 'male', 'sadasdasdsad'),
(19, 'com6.app@gmail.com', '-509e2330cff459af2572de9b2f817b8e', 'lnr', 'male', 'sadsadasd'),
(20, 'com7.app@gmail.com', '-509e2330cff459af2572de9b2f817b8e', 'dnr', 'male', 'sasadsadasdsadsadasd');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Ограничения внешнего ключа таблицы `prodcat`
--
ALTER TABLE `prodcat`
  ADD CONSTRAINT `prodcat_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `prodcat_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Ограничения внешнего ключа таблицы `productimage`
--
ALTER TABLE `productimage`
  ADD CONSTRAINT `productimage_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `productimage_ibfk_2` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
