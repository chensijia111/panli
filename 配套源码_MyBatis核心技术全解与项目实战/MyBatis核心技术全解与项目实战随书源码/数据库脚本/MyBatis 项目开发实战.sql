

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` int(10) NULL DEFAULT NULL COMMENT '代码',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别',
  `description` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES (1, 1, '客户等级', '至尊客户');
INSERT INTO `dictionary` VALUES (2, 1, '客户等级', '重要客户');
INSERT INTO `dictionary` VALUES (3, 1, '客户等级', '普通客户');
INSERT INTO `dictionary` VALUES (4, 2, '投资领域', '金融');
INSERT INTO `dictionary` VALUES (5, 2, '投资领域', '能源');
INSERT INTO `dictionary` VALUES (6, 2, '投资领域', '基建');
INSERT INTO `dictionary` VALUES (7, 2, '投资领域', '教育');
INSERT INTO `dictionary` VALUES (8, 2, '投资领域', '科技');
INSERT INTO `dictionary` VALUES (9, 3, '投资意向', '高');
INSERT INTO `dictionary` VALUES (10, 3, '投资意向', '中');
INSERT INTO `dictionary` VALUES (11, 3, '投资意向', '低');
INSERT INTO `dictionary` VALUES (12, 4, '员工角色', '普通员工');
INSERT INTO `dictionary` VALUES (13, 4, '员工角色', '管理人员');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工昵称',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工密码',
  `role` int(10) NULL DEFAULT NULL COMMENT '员工角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'admin', '管理员', 'admin', 13);
INSERT INTO `employee` VALUES (2, 'zxc', '周星驰', '123456', 12);
INSERT INTO `employee` VALUES (3, 'wmd', '吴孟达', '123456', 12);
INSERT INTO `employee` VALUES (8, 'yzq', '杨紫琼', '123456', 12);
INSERT INTO `employee` VALUES (9, 'qff', '乔菲菲', '123321', 12);
INSERT INTO `employee` VALUES (10, 'zdh', '张德华', '123654', 12);
INSERT INTO `employee` VALUES (11, 'lfc', '李福成', '123789', 12);
INSERT INTO `employee` VALUES (12, 'ldd', '刘丹丹', '456321', 12);
INSERT INTO `employee` VALUES (13, 'lpp', '李盼盼', '987123', 12);

-- ----------------------------
-- Table structure for investor
-- ----------------------------
DROP TABLE IF EXISTS `investor`;
CREATE TABLE `investor`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '投资者编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '投资者姓名',
  `level` int(10) NULL DEFAULT NULL COMMENT '客户等级',
  `amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '投资金额',
  `field` int(10) NULL DEFAULT NULL COMMENT '投资领域',
  `intent` int(10) NULL DEFAULT NULL COMMENT '投资意向',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '居住城市',
  `number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `note` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `level`(`level`) USING BTREE,
  INDEX `field`(`field`) USING BTREE,
  INDEX `intent`(`intent`) USING BTREE,
  CONSTRAINT `investor_ibfk_1` FOREIGN KEY (`level`) REFERENCES `dictionary` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `investor_ibfk_2` FOREIGN KEY (`field`) REFERENCES `dictionary` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `investor_ibfk_3` FOREIGN KEY (`intent`) REFERENCES `dictionary` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of investor
-- ----------------------------
INSERT INTO `investor` VALUES (1, '李天天', 1, '200W', 4, 9, '北京', '15011006877', '喜欢打高尔夫', '2023-06-05 17:22:49');
INSERT INTO `investor` VALUES (2, '杨倩倩', 2, '300W', 7, 9, '上海', '13011006866', '经常关注美股市场', '2023-06-05 17:24:10');
INSERT INTO `investor` VALUES (6, '王思思', 3, '100W', 5, 10, '成都', '15211006866', '博士学历', '2023-06-08 16:38:35');
INSERT INTO `investor` VALUES (7, '王晓光', 2, '200W', 4, 10, '天津', '14711006866', '健身达人', '2023-06-08 16:39:45');
INSERT INTO `investor` VALUES (8, '陈读西', 2, '100W', 4, 9, '深圳', '18011006866', '艺术家', '2023-06-08 16:40:45');
INSERT INTO `investor` VALUES (9, '钱名思', 1, '100W', 5, 9, '保定', '13011006877', '大学退休教师', '2023-06-08 16:41:49');
INSERT INTO `investor` VALUES (10, '邵刚易', 2, '200W', 7, 10, '重庆', '15011006866', '上市公司高管', '2023-06-08 16:43:03');
INSERT INTO `investor` VALUES (11, '蒋思琪', 3, '200W', 7, 10, '北京', '17022006866', '销售经理', '2023-06-08 16:45:09');
INSERT INTO `investor` VALUES (12, '张晓梅', 3, '100W', 5, 10, '上海', '19011006866', '探险爱好者', '2023-06-08 16:46:41');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '新闻编号',
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '新闻标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '新闻内容',
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '新闻配图',
  `publisher` int(10) NULL DEFAULT NULL COMMENT '发布新闻的员工的编号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '新闻发布时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `publisher`(`publisher`) USING BTREE,
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`publisher`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (5, '新员工入职欢迎仪式', '<p>尊敬的各位领导，亲爱的同事们：</p><p>大家好！</p><p>今天是我们公司的特殊日子——新同事入职的日子。在这个美好的时刻，我代表公司全体员工向大家表示热烈的欢迎和诚挚的祝贺！</p><p>入职是一个新的开始，更是一个全新的挑战。我相信所有新同事都有着优秀的专业能力和出色的工作潜质，而我们也将为你们提供最好的发展平台和最完善的培训计划，为您的未来职业生涯提供强有力的支持。</p><p>我希望大家能够以开放的心态融入公司文化，积极融入团队，与大家一起共同成长、共同进步。同时，我们也期待您带来新的思想、新的理念和新的能量，为公司的发展贡献自己的力量。</p><p>最后，再次热烈欢迎新同事加入我们大家庭！让我们一起努力，共同书写公司美好的明天！</p><p>谢谢大家！</p>', '/static/upload\\1700484642714.jpg', 1, '2023-06-08 15:59:05');
INSERT INTO `news` VALUES (6, '月度工作总结会议', '<p>全体员工请注意，明天将举行公司的月度会议。这次会议的时间是2023年11月9日上午10点，地点位于公司会议室。该次会议的议程如下：上月工作总结和本月工作计划；营销部门关于新产品发布的计划汇报；人力资源部门有关员工培训的提案；客服部门就客户反馈的问题进行讨论；请各位参会人员在会议前认真准备相关材料，并按时参加会议。如有无法参加会议的情况，请提前向上级汇报并请假。</p>', '/static/upload\\1700483601859.jpg', 1, '2023-11-20 20:33:26');

SET FOREIGN_KEY_CHECKS = 1;
