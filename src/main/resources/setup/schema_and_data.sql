CREATE DATABASE  IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bookstore`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `description` varchar(4096) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `last_update` datetime(6) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `quantity` int NOT NULL,
  `category_id` bigint DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `s3_cover_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiiwykcagtwambys3onu6e5ft5` (`category_id`),
  CONSTRAINT `FKiiwykcagtwambys3onu6e5ft5` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Joshua Bloch','Written for the working Java developer, Joshua Blochs Effective Java Programming Language Guide provides a truly useful set of over 50 best practices and tips for writing better Java code. With plenty of advice from an indisputable expert in the field, this title is sure to be an indispensable resource for anyone who wants to get more out of their code.As a veteran developer at Sun, the author shares his considerable insight into the design choices made over the years in Suns own Java libraries (which the author acknowledges havent always been perfect). Based on his experience working with Suns best minds, the author provides a compilation of 57 tips for better Java code organized by category. Many of these ideas will let you write more robust classes that better cooperate with built-in Java APIs. Many of the tips make use of software patterns and demonstrate an up-to-the-minute sense of what works best in todays design. Each tip is clearly introduced and explained with code snippets used to demonstrate each programming principle.Early sections on creating and destroying objects show you ways to make better use of resources, including how to avoid duplicate objects. Next comes an absolutely indispensable guide to implementing \"required\" methods for custom classes. This material will help you write new classes that cooperate with old ones (with advice on implementing essential requirements like the equals() and hashCode() methods).The author has a lot to say about class design, whether using inheritance or composition. Tips on designing methods show you how to create understandable, maintainable, and robust classes that can be easily reused by others on your team. Sections on mapping C code (like structures, unions, and enumerated types) onto Java will help C programmers bring their existing skills to Suns new language. Later sections delve into some general programming tips, like using exceptions effectively. The book closes with advice on using threads and synchronization techniques, plus some worthwhile advice on object serialization.Whatever your level of Java knowledge, this title can make you a more effective programmer. Wisely written, yet never pompous or doctrinaire, the author has succeeded in packaging some really valuable nuggets of advice into a concise and very accessible guidebook that arguably deserves a place on most any developers bookshelf. Richard Dragan Topics covered: Best practices and tips for Java Creating and destroying objects (static factory methods, singletons, avoiding duplicate objects and finalizers) Required methods for custom classes (overriding equals(), hashCode(), toString(), clone(), and compareTo() properly) Hints for class and interface design (minimizing class and member accessibility, immutability, composition versus inheritance, interfaces versus abstract classes, preventing subclassing, static versus nonstatic classes) C constructs in Java (structures, unions, enumerated types, and function pointers in Java) Tips for designing methods (parameter validation, defensive copies, method signatures, method overloading, zero-length arrays, hints for Javadoc comments) General programming advice (local variable scope, using Java API libraries, avoiding float and double for exact comparisons, when to avoid strings, string concatenation, interfaces and reflection, avoid native methods, optimizing hints, naming conventions) Programming with exceptions (checked versus run-time exceptions, standard exceptions, documenting exceptions, failure-capture information, failure atomicity) Threading and multitasking (synchronization and scheduling hints, thread safety, avoiding thread groups) Serialization (when to implement Serializable, the readObject(), and readResolve() methods)','0321356683',NULL,16.50,5,2,'Effective Java','cover/86c3f719-ad99-4d85-b918-35feb35fed04.jfif'),(2,'Brian W. Kernighan','Just about every C programmer I respect learned C from this book. Unlike many of the 1,000 page doorstops stuffed with CD-ROMs that have become popular, this volume is concise and powerful (if somewhat dangerous)  like C itself. And it was written by Kernighan himself. Need we say more?','0131103628',NULL,67.00,12,2,'The C Programming Language','cover/71faa047-cc4c-4446-a8c6-19aef2dcef34.jfif'),(3,'Mark Lutz','The authors of Learning Python show you enough essentials of the Python scripting language to enable you to begin solving problems right away, then reveal more powerful aspects of the language one at a time. This approach is sure to appeal to programmers and system administrators who have urgent problems and a preference for learning by semi-guided experimentation. First off, Learning Python shows the relationships among Python scripts and their interpreter (in a mostly platform-neutral way). Then, the authors address the mechanics of the language itself, providing illustrations of how Python conceives of numbers, strings, and other objects as well as the operators you use to work with them. Dictionaries, lists, tuples, and other data structures specific to Python receive plenty of attention including complete examples. Authors Mark Lutz and David Ascher build on that fundamental information in their discussions of functions and modules, which evolve into coverage of namespaces, classes, and the object-oriented aspects of Python programming. Theres also information on creating graphical user interfaces (GUIs) for Python applications with Tkinter. In addition to its careful expository prose, Learning Python includes exercises that both test your Python skills and help reveal more elusive truths about the language.','1565924649',NULL,30.59,8,2,'Learning Python (Help for Programmers)','cover/147dd421-5c45-403c-a3ca-7ac45f018b1d.jfif'),(4,'David Flanagan','Since 1996, JavaScript: The Definitive Guide has been the bible for JavaScript programmers—a programmers guide and comprehensive reference to the core language and to the client-side JavaScript APIs defined by web browsers.The 6th edition covers HTML5 and ECMAScript 5. Many chapters have been completely rewritten to bring them in line with todays best web development practices. New chapters in this edition document jQuery and server side JavaScript. Its recommended for experienced programmers who want to learn the programming language of the Web, and for current JavaScript programmers who want to master it.\"A must-have reference for expert JavaScript programmers...well-organized and detailed.\"Brendan Eich, creator of JavaScript, CTO of Mozilla\"I made a career of what I learned from JavaScript: The Definitive Guide.\"  Andrew Hedges, Tapulous','0596805527',NULL,49.99,14,2,'JavaScript: The Definitive Guide','cover/50eb8845-6833-4a19-8d44-5f832bc229f5.jfif'),(5,'Bill Rosenblatt','OReillys bestselling book on Linuxs bash shell is at it again. Now that Linux is an established player both as a server and on the desktop Learning the bash Shell has been updated and refreshed to account for all the latest changes. Indeed, this third edition serves as the most valuable guide yet to the bash shell. As any good programmer knows, the first thing users of the Linux operating system come face to face with is the shell the Unix term for a user interface to the system. In other words, its what lets you communicate with the computer via the keyboard and display. Mastering the bash shell might sound fairly simple but it isnt. In truth, there are many complexities that need careful explanation, which is just what Learning the bash Shell provides. If you are new to shell programming, the book provides an excellent introduction, covering everything from the most basic to the most advanced features. And if youve been writing shell scripts for years, it offers a great way to find out what the new shell offers. Learning the bash Shell is also full of practical examples of shell commands and programs that will make everyday use of Linux that much easier. With this book, programmers will learn: How to install bash as your login shell The basics of interactive shell use, including Unix file and directory structures, standard I/O, and background jobs Command line editing, history substitution, and key bindings How to customize your shell environment without programming The nuts and bolts of basic shell programming, flow control structures, command-line options and typed variables Process handling, from job control to processes, coroutines and subshells Debugging techniques, such as trace and verbose modes Techniques for implementing system-wide shell customization and features related to system security','0596009658',NULL,34.95,3,2,'Learning the bash Shell: Unix Shell Programming','cover/3f1f7e86-979d-4869-afd2-0701f9d1c01e.jfif'),(6,'Jerry Peek','Part basic primer, part reference guide, this slim volume will make your life with UNIX much simpler. This book is specifically designed for those who are new to UNIX and contains neither introductory-level condescension nor advanced-level gibberish. Well-indexed and clearly mapped, Learning the UNIX Operating System will show you how to use and manage files and get your e-mail as well as how to perform more advanced tasks, such as redirecting standard input/output and multitasking your processes. Those new to the UNIX world will appreciate its concise presentation, and those reasonably familiar with UNIX will learn many new shortcuts, tricks, and tools. Jennifer Buckendorff','0596002610',NULL,29.99,5,2,'Learning the UNIX Operating System','cover/cd2ac880-6340-41d9-9b46-fae89293e62b.jfif'),(7,'Elliotte Rusty Harold','Does this sound familiar? You know Java well enough to write standalone applets and applications, even multithreaded ones, but you know next to nothing about the languages networking capabilities. And guess whatyour next job is to write a network-centric Java program. Java Network Programming serves as an excellent introduction to network communications generally and in Java. The book opens with information on network architectures and protocols and the security restrictions placed on applets. Quickly, the author gets to the meat of networked Java with a complete elucidation of the InetAddress class, the URL-related classes, applet-specific networking methods, and sockets. The author also covers packets, Remote Method Invocation (RMI), and servlets. The one serious shortcoming of this book is that it does not include a companion disk, which is the case with most OReilly books. Youll have to visit the publishers FTP site for the code if you dislike typing the examples manually. On the whole, though, this is an excellent tutorial that will guide you through the world of Java networking as smoothly as possible.','1565928709',NULL,37.59,7,2,'Java Network Programming','cover/f4f66f6e-fa70-4095-9435-773b0851a39c.jfif'),(8,'Eric A. Meyer','CSS The Definitive Guide, 3rd Edition, provides you with a comprehensive guide to CSS implementation, along with a thorough review of all aspects of CSS 2.1. Updated to cover Internet Explorer 7, Microsofts vastly improved browser, this new edition includes content on positioning, lists and generated content, table layout, user interface, paged media, and more. Simply put, Cascading Style Sheets (CSS) is a way to separate a documents structure from its presentation. The benefits of this can be quite profound: CSS allows a much richer document appearance than HTML and also saves timeyou can create or change the appearance of an entire document in just one place, and its compact file size makes web pages load quickly. Author Eric Meyer tackles the subject with passion, exploring in detail each individual CSS property and how it interacts with other properties. Youll not only learn how to avoid common mistakes in interpretation, you also will benefit from the depth and breadth of his experience and his clear and honest style. This is the complete sourcebook on CSS. The 3rd edition contains: Updates to reflect changes in the latest draft version of CSS 2.1 Browser notes updated to reflect changes between IE6 and IE7 Advanced selectors supported in IE7 and other major browsers included A new round of technical edits by a fresh set of editors Clarifications and corrected errata, including updated URLs of referenced online resources','0596527330',NULL,44.99,9,2,'CSS: The Definitive Guide','cover/59a8d927-a7da-4250-9cf4-72c558cfc7a7.jfif'),(9,'Craig Hunt','This book will be indispensable to Unix system administrators. It describes how to set up and administer a network of Unix systems using the TCP/IP protocols, taking a thoroughly practical approach. Topics covered include basic system configuration, routing, common network applications, and many others.','0596002971',NULL,44.95,11,2,'TCP IP Network Administration','cover/f880b4e2-1374-4672-b731-f65945ee9837.jfif'),(10,'Vadim Tkachenko','In High Performance MySQL you will learn about MySQL indexing and optimization in depth so you can make better use of these key features. You will learn practical replication, backup, and load-balancing strategies with information that goes beyond available tools to discuss their effects in real-life environments. And youll learn the supporting techniques you need to carry out these tasks, including advanced configuration, benchmarking, and investigating logs.','0596003064',NULL,25.59,17,2,'High Performance MySQL','cover/216dd61c-71de-4502-957e-644426b22250.jfif'),(11,'Ian F. Darwin','From lambda expressions and JavaFX 8 to new support for network programming and mobile development, Java 8 brings a wealth of changes. This cookbook helps you get up to speed right away with hundreds of hands-on recipes across a broad range of Java topics. You’ll learn useful techniques for everything from debugging and data structures to GUI development and functional programming.Each recipe includes self-contained code solutions that you can freely use, along with a discussion of how and why they work. If you are familiar with Java basics, this cookbook will bolster your knowledge of the language in general and Java 8’s main APIs in particular.Recipes include:Methods for compiling, running, and debuggingManipulating, comparing, and rearranging textRegular expressions for string- and pattern-matchingHandling numbers, dates, and timesStructuring data with collections, arrays, and other typesObject-oriented and functional programming techniquesDirectory and filesystem operationsWorking with graphics, audio, and videoGUI development, including JavaFX and handlersNetwork programming on both client and serverDatabase access, using JPA, Hibernate, and JDBCProcessing JSON and XML for data storageMultithreading and concurrency','1449337047',NULL,59.99,16,2,'Java Cookbook','cover/6f310cd4-712f-4bbb-8e8a-892a8f6e17d5.jfif'),(12,'Peter Laurie','Apache is far and away the most widely used web server platform in the world. This versatile server runs more than half of the worlds existing web sites. Apache is both free and rock-solid, running more than 21 million web sites ranging from huge e-commerce operations to corporate intranets and smaller hobby sites.With this new third edition of Apache: The Definitive Guide, web administrators new to Apache will come up to speed quickly, and experienced administrators will find the logically organized, concise reference sections indispensable, and system programmers interested in customizing their servers will rely on the chapters on the API and Apache modules.Updated to cover the changes in Apaches latest release, 2.0, as well as Apache 1.3, this useful guide discusses how to obtain, set up, secure, modify, and troubleshoot the Apache software on both Unix and Windows systems. Dozens of clearly written examples provide the answers to the real-world issues that Apache administrators face everyday. In addition to covering the installation and configuration of mod_perl and Tomcat, the book examines PHP, Cocoon, and other new technologies that are associated with the Apache web server. Additional coverage of security and the Apache 2.0 API make Apache: The Definitive Guide, Third Edition essential documentation for the worlds most popular web server.','0596002033',NULL,49.99,14,2,'Apache: The Definitive Guide','cover/4402b00d-da83-4d2f-9190-369e03eb4e11.jfif'),(13,'Sanjay Mishra','The vast majority of Oracle SQL books discuss some syntax, provide the barest rudiments of using Oracle SQL, and perhaps include a few simple examples. It might be enough to pass a survey course, or give you some buzz words to drop in conversation with real Oracle DBAs. But if you use Oracle SQL on a regular basis, you want much more. You want to access the full power of SQL to write queries in an Oracle environment. You want a solid understanding of whats possible with Oracle SQL, creative techniques for writing effective and accurate queries, and the practical, hands-on information that leads to true mastery of the language. Simply put, you want useful, expert best practices that can be put to work immediately, not just non-vendor specific overview or theory.Updated to cover the latest version of Oracle, Oracle 10g, this edition of the highly regarded Mastering Oracle SQL has a stronger focus on technique and on Oracles implementation of SQL than any other book on the market. It covers Oracle s vast library of built-in functions, the full range of Oracle SQL query-writing features, regular expression support, new aggregate and analytic functions, subqueries in the SELECT and WITH clauses, multiset union operators, enhanced support for hierarchical queries: leaf and loop detection, and the CONNECT_BY_ROOT operator, new partitioning methods (some introduced in Oracle9i Release 2), and the native XML datatype, XMLType.Mastering Oracle SQL, 2nd Edition fills the gap between the sometimes spotty vendor documentation, and other books on SQL that just dont explore the full depth of what is possible with Oracle-specific SQL. For those who want to harness the untapped (and often overlooked) power of Oracle SQL, this essential guide for putting Oracle SQL to work will prove invaluable.','0596006322',NULL,39.95,22,2,'Mastering Oracle SQL','cover/f31690ee-3cbc-4492-bf5d-e0601c29dc05.jfif'),(14,'Jennifer Niederst Robbins','After years of using spacer GIFs, layers of nested tables, and other improvised solutions for building your web sites, getting used to the more stringent \"standards-compliant\" design that is de rigueur among professionals today can be intimidating.With standards-driven design, keeping style separate from content is not just a possibility but a reality. You no longer use HTML and XHTML as design tools, but strictly as ways to define the meaning and structure of web content. And Cascading Style Sheets (CSS) are no longer just something interesting to tinker with, but a reliable method for handling all matters of presentation, from fonts and colors to page layout. When you follow the standards, both the sites design and underlying code are much cleaner. But how do you keep all those HTML and XHTML tags and CSS values straight? Jennifer Niederst-Robbins, the author of our definitive guide on standards-compliant design, Web Design in a Nutshell, offers you the perfect little guide when you need answers immediately: HTML and XHTML Pocket Reference. This revised and updated new edition takes the top 20% of vital reference information from her Nutshell book, augments it judiciously, cross-references everything, and organizes it according to the most common needs of web developers. The result is a handy book that offers the bare essentials on web standards in a small, concise format that you can use carry anywhere for quick reference. This guide will literally fit into your back pocket.Inside HTML and XHTML Pocket Reference, youll find instantly accessible alphabetical listings of every element and attribute in the HTML 4.01 and XHTML 1.0 Recommendations. This is an indispensable reference for any serious web designer, author, or programmer who needs a fast on-the-job resource when working with established web standards.','0596527276',NULL,37.59,21,2,'HTML and XHTML Pocket Reference','cover/e20ce497-9ee5-490c-affa-03a580a944f2.jfif'),(15,'David Chappell','The Java Message Service (JMS) provides a way for the components of a distributed application to talk asynchronously, or for welding together legacy enterprise systems. Think of it as application-to-application e-mail. Unlike COM, JMS uses one or more JMS servers to handle the messages on a store-and-forward basis, so that the loss of one or more components doesnt bring the whole distributed application to a halt. JMS consists of a set of messaging APIs that enable two types of messaging, publish-and-subscribe (one-to-many) and point-to-point (one-to-one). The highly lucid explanation of the ways in which these work makes the technical content a lot more approachable. In practice, however, Java Message Service is still a book for Java programmers who have some business programming experience. You need the background. After a simple JMS demonstration in which you create a chat application using both messaging types, the authors dissect JMS message structures, explore both types in detail, and then move on to real-world considerations. These include reliability, security, deployment, and a rundown of various JMS server providers. The appendices list and describe the JMS API, and provide message reference material. Considering the complexity and reach of the subject matter, Java Message Service does a great job of covering both theory and practice in a surprisingly efficient manner. Its easy to see why JMS has become so popular so quickly.','0596000685',NULL,24.59,19,2,'Java Message Service','cover/4f2fa6b0-0518-4925-9a97-d02c3a1660e5.jfif'),(16,'Æleen Frisch','Essential System Administration,3rd Edition is the definitive guide for Unix system administration, covering all the fundamental and essential tasks required to run such divergent Unix systems as AIX, FreeBSD, HP-UX, Linux, Solaris, Tru64 and more. Essential System Administration provides a clear, concise, practical guide to the real-world issues that anyone responsible for a Unix system faces daily.The new edition of this indispensable reference has been fully updated for all the latest operating systems. Even more importantly, it has been extensively revised and expanded to consider the current system administrative topics that administrators need most. Essential System Administration,3rd Edition covers: DHCP, USB devices, the latest automation tools, SNMP and network management, LDAP, PAM, and recent security tools and techniques.Essential System Administration is comprehensive. But what has made this book the guide system administrators turn to over and over again is not just the sheer volume of valuable information it provides, but the clear, useful way the information is presented. It discusses the underlying higher-level concepts, but it also provides the details of the procedures needed to carry them out. It is not organized around the features of the Unix operating system, but around the various facets of a system administrators job. It describes all the usual administrative tools that Unix provides, but it also shows how to use them intelligently and efficiently.Whether you use a standalone Unix system, routinely provide administrative support for a larger shared system, or just want an understanding of basic administrative functions, Essential System Administration is for you. This comprehensive and invaluable book combines the authors years of practical experience with technical expertise to help you manage Unix systems as productively and painlessly as possible.','0596003439',NULL,59.99,10,2,'Essential System Administration: Tools and Techniques for Linux and Unix Administration','cover/21e661b8-3679-4d51-96a6-a0a95e616559.jfif');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_seq`
--

DROP TABLE IF EXISTS `book_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_seq`
--

LOCK TABLES `book_seq` WRITE;
/*!40000 ALTER TABLE `book_seq` DISABLE KEYS */;
INSERT INTO `book_seq` VALUES (18);
/*!40000 ALTER TABLE `book_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Literature and Fiction'),(2,'Computers and Technology'),(3,'Mystery and Thriller'),(4,'Sci-fi and Fantasy'),(5,'Romanse');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_seq`
--

DROP TABLE IF EXISTS `category_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_seq`
--

LOCK TABLES `category_seq` WRITE;
/*!40000 ALTER TABLE `category_seq` DISABLE KEYS */;
INSERT INTO `category_seq` VALUES (6);
/*!40000 ALTER TABLE `category_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Široká 45','United States','Charlie','Pace','California','11000'),(3,'Kostelní 83','United States','Karel','Gott','California','11000'),(4,'Letohradská 18','United States','Helena','Vondráčková','California','11000'),(5,'Dušní 87','United States','Sawyer','Ford','California','11000'),(6,'Krkonošská 9','United States','Dalibor','Janda','California','11000'),(7,'Plzeňská 131','United States','Richard','Genzer','California','11000');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_order` (
  `id` bigint NOT NULL,
  `total_amount` decimal(19,2) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpit9o13j0swpa9fc63a6glf76` (`customer_id`),
  CONSTRAINT `FKpit9o13j0swpa9fc63a6glf76` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order`
--

LOCK TABLES `customer_order` WRITE;
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
INSERT INTO `customer_order` VALUES (1,16.50,'2010-05-14 18:00:11.000000',7),(2,16.11,'2010-05-14 17:56:23.000000',6),(3,26.00,'2010-05-14 17:51:37.000000',5),(4,17.63,'2010-05-14 17:47:46.000000',4),(5,17.24,'2010-05-14 17:45:21.000000',3),(6,4.49,'2010-05-14 18:04:09.000000',1);
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_order_seq`
--

DROP TABLE IF EXISTS `customer_order_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_order_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order_seq`
--

LOCK TABLES `customer_order_seq` WRITE;
/*!40000 ALTER TABLE `customer_order_seq` DISABLE KEYS */;
INSERT INTO `customer_order_seq` VALUES (7);
/*!40000 ALTER TABLE `customer_order_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_seq`
--

DROP TABLE IF EXISTS `customer_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_seq`
--

LOCK TABLES `customer_seq` WRITE;
/*!40000 ALTER TABLE `customer_seq` DISABLE KEYS */;
INSERT INTO `customer_seq` VALUES (8);
/*!40000 ALTER TABLE `customer_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_book`
--

DROP TABLE IF EXISTS `ordered_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordered_book` (
  `id` bigint NOT NULL,
  `quantity` int NOT NULL,
  `book_id` bigint NOT NULL,
  `customer_order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlkqq08043yuwpm2e9rhecln70` (`customer_order_id`),
  KEY `ordered_book_book__fk` (`book_id`),
  CONSTRAINT `FKlkqq08043yuwpm2e9rhecln70` FOREIGN KEY (`customer_order_id`) REFERENCES `customer_order` (`id`),
  CONSTRAINT `ordered_book_book__fk` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_book`
--

LOCK TABLES `ordered_book` WRITE;
/*!40000 ALTER TABLE `ordered_book` DISABLE KEYS */;
INSERT INTO `ordered_book` VALUES (4,4,5,6),(5,1,13,5),(6,1,4,5),(7,2,10,5),(8,1,16,5),(9,3,1,4),(10,4,12,4),(11,1,13,3),(12,2,2,3),(13,1,9,3),(14,2,14,3),(15,1,16,3),(16,1,10,3),(17,10,13,2),(18,5,8,1),(19,2,7,1);
/*!40000 ALTER TABLE `ordered_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_book_seq`
--

DROP TABLE IF EXISTS `ordered_book_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordered_book_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_book_seq`
--

LOCK TABLES `ordered_book_seq` WRITE;
/*!40000 ALTER TABLE `ordered_book_seq` DISABLE KEYS */;
INSERT INTO `ordered_book_seq` VALUES (20);
/*!40000 ALTER TABLE `ordered_book_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-22 13:32:49
