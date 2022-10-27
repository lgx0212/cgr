/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : cgr

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 13/05/2021 23:38:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', 'lgx');

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention`  (
  `user_id` int(11) NOT NULL,
  `attention_user_id` int(11) NOT NULL,
  `attention_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`attention_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attention
-- ----------------------------
INSERT INTO `attention` VALUES (12, 11, 3);
INSERT INTO `attention` VALUES (11, 12, 7);

-- ----------------------------
-- Table structure for baby
-- ----------------------------
DROP TABLE IF EXISTS `baby`;
CREATE TABLE `baby`  (
  `user_id` int(11) NOT NULL,
  `baby_id` int(11) NOT NULL AUTO_INCREMENT,
  `baby_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `baby_sex` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `baby_img` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `baby_brith` date NOT NULL,
  `baby_checked` int(11) NULL DEFAULT NULL,
  `baby_backimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`baby_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of baby
-- ----------------------------
INSERT INTO `baby` VALUES (11, 31, '赵一鸣', '男', '/upfile/fe4f1737-0d12-4043-9765-53459b58d350-03252bb103e9c08ca8dc54fc5ce82486_G9lHsqI1TlJ0qx8IymmDqaoAytRnH942OhGYFLXJR9I2Y1493185042258compressflag.jpg', '2020-01-07', 1, '/upfile/9275b7ae-a857-41ca-87a8-63454fa1840a-732f69e0e39914e6c460d8bca5072496_t01cec55ca37797bd74.jpg');
INSERT INTO `baby` VALUES (12, 32, '朵朵', '女', '/upfile/b7a1c105-1264-44e2-b150-d1955adf2449-f7759b65bdb7ddc58310df49ea7e5ff1_photograph_innocence_baby_photography_9709_3.jpg', '2018-02-07', 1, '/upfile/79e11b94-0b64-4cda-a163-2a3aef5bd8a9-background.jpg');
INSERT INTO `baby` VALUES (11, 34, '赵茂山', '男', '/upfile/df969046-403d-4318-9c39-b81f83b8d5a0-5aa8662eb9a0191a57aa2fcbb43ac217_eb5545ace72342cc87bcf55c52bdd29a.jpeg', '2021-05-11', 0, NULL);

-- ----------------------------
-- Table structure for bignew
-- ----------------------------
DROP TABLE IF EXISTS `bignew`;
CREATE TABLE `bignew`  (
  `user_id` int(11) NOT NULL,
  `baby_id` int(11) NOT NULL,
  `bignew_content` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bignew_date` date NOT NULL,
  `bignew_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bignew_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bignew
-- ----------------------------
INSERT INTO `bignew` VALUES (11, 31, '第一次叫爸爸', '2021-04-10', 3);
INSERT INTO `bignew` VALUES (11, 31, '第一次叫妈妈', '2021-05-13', 4);

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `user_id` int(11) NOT NULL,
  `mynew_id` int(11) NOT NULL,
  `collection_user_id` int(11) NULL DEFAULT NULL,
  `collection_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (12, 25, 11, 11);
INSERT INTO `collection` VALUES (11, 36, 12, 12);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `mynew_id` int(11) NOT NULL,
  `comment_user_id` int(11) NOT NULL,
  `comment_content` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_date` datetime(0) NOT NULL,
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (26, 11, 'i like', '2021-05-10 20:48:04', 18);
INSERT INTO `comment` VALUES (26, 11, '好美啊!!', '2021-05-10 20:48:25', 19);
INSERT INTO `comment` VALUES (36, 11, '这是哪，好喜欢', '2021-05-13 20:35:51', 20);

-- ----------------------------
-- Table structure for comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `comment_reply`;
CREATE TABLE `comment_reply`  (
  `comment_reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_reply_comment_id` int(11) NULL DEFAULT NULL,
  `comment_reply_sanduser_id` int(11) NULL DEFAULT NULL,
  `comment_reply_receiveuser_id` int(11) NULL DEFAULT NULL,
  `comment_reply_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_reply_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_reply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_reply
-- ----------------------------
INSERT INTO `comment_reply` VALUES (3, 19, 12, 11, '你好', '2021-05-10 20:13:04');
INSERT INTO `comment_reply` VALUES (4, 19, 12, 11, '真好', '2021-05-10 20:20:41');
INSERT INTO `comment_reply` VALUES (17, 18, 11, 12, '你好', '2021-05-10 21:57:05');
INSERT INTO `comment_reply` VALUES (18, 19, 11, 12, 'hello', '2021-05-10 21:57:16');
INSERT INTO `comment_reply` VALUES (19, 18, 11, 12, 'hi', '2021-05-10 21:59:25');
INSERT INTO `comment_reply` VALUES (20, 19, 11, 12, 'hi', '2021-05-10 21:59:44');

-- ----------------------------
-- Table structure for growth
-- ----------------------------
DROP TABLE IF EXISTS `growth`;
CREATE TABLE `growth`  (
  `user_id` int(11) NOT NULL,
  `baby_id` int(11) NOT NULL,
  `growth_id` int(11) NOT NULL AUTO_INCREMENT,
  `growth_height` double NOT NULL,
  `growth_weight` double NOT NULL,
  `growth_date` date NOT NULL,
  PRIMARY KEY (`growth_id`, `baby_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of growth
-- ----------------------------
INSERT INTO `growth` VALUES (11, 31, 23, 50, 13, '2021-04-28');
INSERT INTO `growth` VALUES (11, 31, 24, 60, 15, '2021-04-30');
INSERT INTO `growth` VALUES (11, 31, 25, 65, 20, '2021-04-30');
INSERT INTO `growth` VALUES (11, 31, 26, 112, 77, '2021-05-03');
INSERT INTO `growth` VALUES (12, 32, 28, 150, 30, '2021-05-13');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_sand_user_id` int(11) NOT NULL,
  `message_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message_receive_user_id` int(11) NULL DEFAULT NULL,
  `message_num` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`message_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (11, '11and12', 12, 3);
INSERT INTO `message` VALUES (12, '11and12', 11, 4);

-- ----------------------------
-- Table structure for message_c
-- ----------------------------
DROP TABLE IF EXISTS `message_c`;
CREATE TABLE `message_c`  (
  `message_c_sand_user_id` int(11) NULL DEFAULT NULL,
  `message_c_receive_user_id` int(11) NULL DEFAULT NULL,
  `message_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message_c_num` int(11) NULL DEFAULT NULL,
  `message_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message_c_date` datetime(0) NULL DEFAULT NULL,
  `message_c_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_c_state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`message_c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 212 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_c
-- ----------------------------
INSERT INTO `message_c` VALUES (12, 11, '11and12', 3, '你好', '2021-05-04 19:32:28', 157, 1);
INSERT INTO `message_c` VALUES (12, 11, '11and12', 4, '你好', '2021-05-04 19:32:28', 158, 1);
INSERT INTO `message_c` VALUES (11, 12, '11and12', 3, 'hi', '2021-05-13 21:29:49', 206, 1);
INSERT INTO `message_c` VALUES (11, 12, '11and12', 4, 'hi', '2021-05-13 21:29:49', 207, 1);
INSERT INTO `message_c` VALUES (12, 11, '11and12', 4, '请问你的孩子几岁了啊', '2021-05-13 21:30:10', 208, 1);
INSERT INTO `message_c` VALUES (12, 11, '11and12', 3, '请问你的孩子几岁了啊', '2021-05-13 21:30:10', 209, 1);
INSERT INTO `message_c` VALUES (11, 12, '11and12', 3, '八岁了', '2021-05-13 21:30:16', 210, 1);
INSERT INTO `message_c` VALUES (11, 12, '11and12', 4, '八岁了', '2021-05-13 21:30:16', 211, 1);

-- ----------------------------
-- Table structure for mynew
-- ----------------------------
DROP TABLE IF EXISTS `mynew`;
CREATE TABLE `mynew`  (
  `user_id` int(11) NOT NULL,
  `baby_id` int(11) NOT NULL,
  `mynew_id` int(11) NOT NULL AUTO_INCREMENT,
  `mynew_date` datetime(0) NOT NULL,
  `mynew_content` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mynew_support` int(11) NOT NULL,
  `mynew_collect` int(11) NOT NULL,
  `mynew_open` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`mynew_id`, `baby_id`, `user_id`) USING BTREE,
  INDEX `mynew_id`(`mynew_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mynew
-- ----------------------------
INSERT INTO `mynew` VALUES (11, 31, 25, '2021-04-29 00:00:00', '景色好美！！', 0, 0, 0);
INSERT INTO `mynew` VALUES (11, 31, 26, '2021-04-30 00:00:00', '美景', 0, 0, 1);
INSERT INTO `mynew` VALUES (12, 32, 36, '2021-04-30 00:00:00', '美景！！', 0, 0, 1);
INSERT INTO `mynew` VALUES (12, 32, 37, '2021-04-30 00:00:00', '好看', 0, 0, 0);
INSERT INTO `mynew` VALUES (11, 31, 40, '2021-05-12 14:20:28', '宝宝一百天了', 0, 0, 1);

-- ----------------------------
-- Table structure for mynew_p
-- ----------------------------
DROP TABLE IF EXISTS `mynew_p`;
CREATE TABLE `mynew_p`  (
  `user_id` int(11) NOT NULL,
  `baby_id` int(11) NOT NULL,
  `mynew_id` int(11) NOT NULL,
  `mynew_p_img` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mynew_p_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`mynew_p_id`) USING BTREE,
  INDEX `mynew_id`(`mynew_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mynew_p
-- ----------------------------
INSERT INTO `mynew_p` VALUES (11, 31, 25, '/upfile/2fa6efa3-212a-48ae-a841-0b105872ab13-d33ffdf6145223092e30487b00345b58_4-1F2061H438.jpg', 27);
INSERT INTO `mynew_p` VALUES (11, 31, 26, '/upfile/b443bc29-aa43-4762-954a-fafc793a0e29-0d3c10ba3420a3e4b6a3d01810a3f31a_3a3555786020n2888374799t15.jpg', 28);
INSERT INTO `mynew_p` VALUES (11, 31, 26, '/upfile/9a76afb1-9814-4f5d-aad1-10562f82cb2c-2e4dca56cf53fb25b9c122f76be41b1f_1a4115818388n3573393081t26.jpg', 29);
INSERT INTO `mynew_p` VALUES (12, 32, 36, '/upfile/8dcf46ca-f221-4672-8d99-69b750b951c1-abdc3091709ce19d7ebda186a99c111111111111111111111111111111111111111111111111.jpeg', 32);
INSERT INTO `mynew_p` VALUES (12, 32, 37, '/upfile/9a9ab5ab-c6b5-4b7e-aee3-8fdc5e163e14-2e4dca56cf53fb25b9c122f76be41b1f_1a4115818388n3573393081t26.jpg', 33);

-- ----------------------------
-- Table structure for support
-- ----------------------------
DROP TABLE IF EXISTS `support`;
CREATE TABLE `support`  (
  `user_id` int(11) NOT NULL,
  `mynew_id` int(11) NULL DEFAULT NULL,
  `support_user_id` int(11) NULL DEFAULT NULL,
  `support_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`support_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of support
-- ----------------------------
INSERT INTO `support` VALUES (11, 25, 11, 18);
INSERT INTO `support` VALUES (12, 25, 11, 19);
INSERT INTO `support` VALUES (11, 26, 11, 20);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_img` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_brith` date NULL DEFAULT NULL,
  `user_myspaceimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (11, '李文亮', '女', 'text1', '1234', '/upfile/e2634500-6b62-4d68-a6f8-537f37169ba9-caae745e557589eb02d170f85a32d623_4a2cb58683ba4cb1a676047241b06523.jpeg', '1990-03-10', NULL);
INSERT INTO `user` VALUES (12, '李爱莲', '女', 'text2', '1234', '/upfile/4603ccdb-980d-4756-bd60-220202953f65-355614082f5675b55da3fdbc081b7523_3a1029543083n253158058t15.jpg', '1991-06-11', NULL);
INSERT INTO `user` VALUES (13, '李曙光', '男', 'text3', '1234', '/upfile/c057cf8f-e8fd-4073-b8d0-083e5c402230-355614082f5675b55da3fdbc081b7523_3a1029543083n253158058t15.jpg', '1990-06-12', NULL);
INSERT INTO `user` VALUES (14, '张淑琴', '女', 'text4', '1234', NULL, '1989-05-08', NULL);
INSERT INTO `user` VALUES (15, '王丽珍', '女', 'text5', '1234', NULL, '1989-05-18', NULL);
INSERT INTO `user` VALUES (16, '张丽莎', '女', 'text6', '1234', NULL, '1990-11-29', NULL);
INSERT INTO `user` VALUES (17, '赵子龙', '男', 'text7', '1234', NULL, '1995-07-13', NULL);
INSERT INTO `user` VALUES (18, '赵国生', '男', 'text8', '1234', NULL, '2000-02-15', NULL);
INSERT INTO `user` VALUES (19, '孙金龙', '男', 'text9', '1234', NULL, '1993-05-11', NULL);

SET FOREIGN_KEY_CHECKS = 1;
