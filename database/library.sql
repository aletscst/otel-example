CREATE DATABASE IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `library`;

-- Dumping structure for table library.books
CREATE TABLE IF NOT EXISTS `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(500) NOT NULL DEFAULT '0',
  `title` varchar(255) NOT NULL DEFAULT '0',
  `author` varchar(255) NOT NULL DEFAULT '0',
  `edition` varchar(50) NOT NULL DEFAULT '0',
  `description` longtext NOT NULL,
  `image` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library.books: ~6 rows (approximately)
DELETE FROM `books`;
INSERT INTO `books` (`id`, `code`, `title`, `author`, `edition`, `description`, `image`) VALUES
	(1, '1234', 'Juego de tronos', 'George R. R. Martin', '1ra edicion', 'Juego de tronos es la primera entrega de Canción de hielo y fuego, la serie que ha roto con todos los tópicos de la fantasía moderna. George R.R. Martin abraza con maestría y sin complejos un género dominado por los clichés y las fórmulas, lo adereza con técnicas depuradas en su etapa televisiva y, haciendo a un lado cualquier tipo de expectativas regala a sus lectores una experiencia memorable.', 'https://pendulo.com/imagenes_grandes/9786073/978607311311.GIF'),
	(5, '6073108', 'Choque de reyes', 'George R. R. Martin', '2da', 'Choque de reyes es el segundo volumen de Canción de hielo y fuego, la monumental saga de fantasía épica del escritor George R. R. Martin que ha vendido más de 20 millones de ejemplares en todo el mundo.\n\nDe la saga que inspiró la filmación de la aclamada serie televisiva de HBO: Game of Thrones', 'https://images-na.ssl-images-amazon.com/images/I/81XB79z0QmL.jpg'),
	(6, '978607', 'TORMENTA DE ESPADAS', 'George R. R. Martin', '1ra', 'Las tropas de los inconstantes reyes de poniente arrasan con todo a su paso, empobreciendo aún más su entorno. El destino es titubeante, en cuanto surge un pacto el tiempo parece apresurarse para disolver los enlaces y, así. Los involucrados quedan una vez más con decisiones totalmente vagas. En las ciudades libres, Daenerys Targaryen intenta formar un ejército con el cual desembarcar en su tierra. Mientras la guardia de la noche, a pesar de sus escrupulosos métodos, se ve desbordada por los salvajes. Tormenta de espadas despunta como una historia de fantasía épica, brutal y poética. Conmovedora y cruel con apenas una pincelada cautiva al lector y consigue que el asombro ceda paso a la más profunda admiración por la serie.', 'https://cdn.gandhi.com.mx/media/catalog/product/i/m/image_1165_1_57024.jpg'),
	(7, '978607', 'Festín De Cuervos', 'George R. R. Martin', '3ra', 'Cuando se apaga el clamor de las espadas, solamente queda carroña para los cuervos". Luego de siglos de guerras descarnadas, los siete poderes que dividen la tierra se han diezmado unos a otros hasta alcanzar una difícil tregua. Muy pocos reclamos legítimos existen ya por el Trono de Hierro, y la guerra que ha convertido al mundo en poco más que un desierto al fin ha terminado. O eso parece. Pero no pasa mucho tiempo antes de que los sobrevivientes, los proscritos, los renegados y los carroñeros de los Siete Reinos se reúnan. Ahora, como cuervos humanos que acechan un banquete de cenizas, nuevas intrigas y peligrosas alianzas se forman, a la vez que rostros sorprendentes algunos familiares, otros desconocidos emergen de un siniestro crepúsculo de caos y luchas pasadas para asumir los desafíos de los terribles tiempos que se avecinan. Nobles y plebeyos, soldados y hechiceros, asesinos y sabios se unen para hacer valer su vida y sus fortunas. Porque en un festín de cuervos, muchos son los invitados pero sólo unos pocos logran sobrevivir.', 'https://www.elsotano.com/imagenes_grandes/9786073/978607310996.JPG'),
	(8, 'asdfdghg', 'Danza de dragones', 'George R. R. Martin', '2da', 'Después de una colosal batalla, el futuro de los Siete Reinos pende de un hilo, acuciado por nuevas amenazas que emergen de todos los rincones y en todas direcciones. En el este, Daenerys Targaryen, el último eslabón de la Casa Targaryen, gobierna con sus tres dragones como la reina de una ciudad construida sobre polvo y muerte. Pero Daenerys tiene miles de enemigos, y muchos se han propuesto dar con ella. A medida que ellos la buscan, un joven emprende su propio camino hacia la reina, con un objetivo diametralmente distinto... Tyrion Lannister también se dirige hacia Daenerys mientras escapa de Poniente, donde le han puesto precio a su cabeza. Sus nuevos aliados en esta huida, no obstante, no son los malhechores que aparentan ser, y entre ellos se encuentra aquel que podría impedir que Daenerys se haga del control de Poniente para siempre.', 'https://images-na.ssl-images-amazon.com/images/I/91ODtj0QgxL.jpg'),
	(9, '453456765', 'Fuego y Sangre', 'George R. R. Martin', '1ra', 'Siglos antes de que tuvieran lugar los acontecimientos que se relatan en "Canción de hielo y fuego", la casa Targaryen, la única dinastía de señores dragón que sobrevivió a la Maldición de Valyria, se asentó en la isla de Rocadragón.\n\nAquí tenemos el primero de los dos volúmenes en el que el autor de Juego de tronos nos cuenta, con todo lujo de detalles, la historia de tan fascinante familia: empezando por Aegon I Targaryen, creador del icónico Trono de Hierro, y seguido por el resto de las generaciones de Targaryens que lucharon con fiereza por conservar el poder, y el trono, hasta la llegada de la guerra civil que casi acaba con ellos.', 'https://m.media-amazon.com/images/I/51J0H8PbNGL.jpg');


-- Dumping structure for table library.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '0',
  `last_name` varchar(255) NOT NULL DEFAULT '0',
  `email` varchar(255) NOT NULL DEFAULT '0',
  `password` varchar(255) NOT NULL DEFAULT '0',
  `type` varchar(50) NOT NULL DEFAULT 'LECTOR',
  `address` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library.users: ~4 rows (approximately)
DELETE FROM `users`;
INSERT INTO `users` (`id`, `name`, `last_name`, `email`, `password`, `type`, `address`) VALUES
	(8, 'admin', 'administrador', 'admin@gmail.com', '$2a$05$Y0gH8AtdnPOXPCQ5UcYBF.v.JEkzVfrGTPxth90oHuzTe5Ya8mZJy', 'ADMIN', 'administrador de la pagina'),
	(10, 'biblio', 'bibliotecatio', 'bibliotecario@gmail.com', '$2a$05$h.XWxylCVcQd286uRWe8KeNOB70Pm6jHTJhSf2cd0aRW8GovrrBh.', 'LIBRARIAN', 'lygkjhg'),
	(11, 'lector', 'lector', 'lector@gmail.com', '$2a$05$t6FnxbWfPzRE5k5CzZLM3elA4JxSpUyNiDENA4AR69m9.I045BVcK', 'LECTOR', 'lee en casa'),
	(12, 'lector2', 'Lector No 2', 'lector2@gmail.com', '$2a$05$xMtpDXAUfltYAwA7KD.cCuxzp71j3IHJbmJlL8IShIRr.a3RewRwm', 'LECTOR', 'lee en casa');

-- Dumping structure for table library.loan_applications
CREATE TABLE IF NOT EXISTS `loan_applications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL DEFAULT '0',
  `id_book` int NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'EN PROCESO',
  `created_at` timestamp NOT NULL DEFAULT (now()),
  `updated_at` timestamp NOT NULL DEFAULT (now()) ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_book` (`id_book`),
  CONSTRAINT `ID_BOOK` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`),
  CONSTRAINT `ID_USER` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library.loan_applications: ~6 rows (approximately)
DELETE FROM `loan_applications`;
INSERT INTO `loan_applications` (`id`, `id_user`, `id_book`, `status`, `created_at`, `updated_at`) VALUES
	(9, 12, 1, 'ACEPTADA', '2021-02-23 22:40:29', '2021-02-23 22:41:17'),
	(10, 12, 9, 'RECHAZADA', '2021-02-23 22:40:35', '2021-02-23 22:41:19'),
	(11, 11, 5, 'RECHAZADA', '2021-02-23 22:40:50', '2021-02-23 22:41:31'),
	(12, 11, 6, 'ACEPTADA', '2021-02-23 22:40:56', '2021-02-23 22:41:26'),
	(13, 11, 7, 'ACEPTADA', '2021-02-23 22:41:02', '2021-02-23 22:41:32'),
	(14, 12, 5, 'EN PROCESO', '2021-02-23 22:42:05', '2021-02-23 22:42:05');

-- Dumping structure for table library.loan_history
CREATE TABLE IF NOT EXISTS `loan_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL DEFAULT '0',
  `id_book` int NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'SIN ENTREGAR',
  `loan_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_book` (`id_book`),
  CONSTRAINT `ID_BOOK_H` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`),
  CONSTRAINT `ID_USER_H` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library.loan_history: ~3 rows (approximately)
DELETE FROM `loan_history`;
INSERT INTO `loan_history` (`id`, `id_user`, `id_book`, `status`, `loan_date`, `update_date`) VALUES
	(4, 12, 1, 'SIN ENTREGAR', '2021-02-23 22:41:17', '2021-02-23 22:41:17'),
	(5, 11, 6, 'ENTREGADO', '2021-02-23 22:41:26', '2021-02-23 22:41:44'),
	(6, 11, 7, 'SIN ENTREGAR', '2021-02-23 22:41:32', '2021-02-23 22:41:32');

