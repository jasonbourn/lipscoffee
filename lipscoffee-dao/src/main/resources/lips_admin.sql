/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : lips_admin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-25 16:37:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `permission_name` varchar(100) DEFAULT NULL COMMENT '资源名称',
  `permission_type` int(10) DEFAULT NULL COMMENT '资源类型（菜单:1，按钮:2）',
  `permission_key` varchar(100) DEFAULT NULL COMMENT '资源key(唯一值)',
  `permission_url` varchar(255) DEFAULT NULL COMMENT '资源url',
  `permission_icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `weight` int(10) DEFAULT '1' COMMENT '权重',
  `sidebar` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示（1:显示 0：不显示）',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `display` tinyint(1) DEFAULT '1' COMMENT '医院是否显示 0：不显示 1：显示',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permissionkey` (`permission_key`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '首页', '1', 'index', null, 'fa-sliders', '1', '0', null, '1');
INSERT INTO `sys_permission` VALUES ('2', '权限配置', '1', 'permission', '', ' fa-sliders', '1', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('3', '用户组管理', '1', 'permission.group', '/sysUser/roleList.do', 'fa-users', '2', '1', null, '0');
INSERT INTO `sys_permission` VALUES ('4', '用户管理', '1', 'permission.user', '/sysUser/userList.do', 'fa-user', '1', '1', null, '0');
INSERT INTO `sys_permission` VALUES ('5', '文章管理', '1', 'article', null, 'fa-clipboard', '2', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('6', '文章列表', '1', 'article.allList', '/article/allList.do', ' fa-file', '1', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('7', '推首文章', '1', 'article.firstList', '/article/firstList.do', 'fa-file-text-o', '2', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('8', '置顶文章', '1', 'article.topList', '/article/topList.do', 'fa-dot-circle-o', '3', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('9', '推荐文章', '1', 'article.pushList', '/article/pushList.do', 'fa-eraser', '4', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('10', '最热文章', '1', 'article.hotList', '/article/hotList.do', 'fa-certificate', '5', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('11', '\r\n\r\n推广文章\r\n', '1', 'article.popList', '/article/popList.do', 'fa-external-link', '6', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('12', '推送历史', '1', 'article.historyList', '/article/historyList.do', 'fa-list-alt', '7', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('13', '分类管理', '1', 'category', '/category/list.do', 'fa-arrows-alt', '3', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('14', '基因订单', '1', 'orderManage', null, 'fa-recycle', '4', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('15', '待发货', '1', 'orderManage.waitSendList', '/orderManage/waitSendList.do', 'fa-truck', '1', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('16', '退款列表', '1', 'orderManage.refundList', '/orderManage/refundList.do', 'fa-cubes', '2', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('17', '全部订单', '1', 'orderManage.orderList', '/orderManage/orderList.do', 'fa-bank ', '3', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('18', '线上外租', '1', 'serviceManage', '', 'fa-desktop', '5', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('19', '发放设备', '1', 'serviceManage.selfOrderList', '/serviceManage/selfOrderList.do', 'fa-bicycle', '1', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('20', '邮寄订单', '1', 'serviceManage.sendOrderList', '/serviceManage/sendOrderList.do', 'fa-plane', '2', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('21', '退款订单', '1', 'serviceManage.refundOrderList', '/serviceManage/refundOrderList.do', 'fa-cubes', '3', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('22', '退款服务', '1', 'serviceManage.refundServiceList', '/serviceManage/refundServiceList.do', 'fa-phone', '4', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('23', '归还审核', '1', 'refundCheck', '/serviceManage/refundCheckList.do', 'fa-toggle-on', '6', '1', null, '1');
INSERT INTO `sys_permission` VALUES ('24', '医院管理', '1', 'serviceManage.hospital', '/hospital/list.do', ' fa-sliders', '5', '1', '', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(100) NOT NULL COMMENT '角色名',
  `hospital_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '医院id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `rolename` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '0');
INSERT INTO `sys_role` VALUES ('14', '编辑', '0');
INSERT INTO `sys_role` VALUES ('15', '基因后台', '0');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源id',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源映射表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('1', '4');
INSERT INTO `sys_role_permission` VALUES ('1', '5');
INSERT INTO `sys_role_permission` VALUES ('1', '6');
INSERT INTO `sys_role_permission` VALUES ('1', '7');
INSERT INTO `sys_role_permission` VALUES ('1', '8');
INSERT INTO `sys_role_permission` VALUES ('1', '9');
INSERT INTO `sys_role_permission` VALUES ('1', '10');
INSERT INTO `sys_role_permission` VALUES ('1', '11');
INSERT INTO `sys_role_permission` VALUES ('1', '12');
INSERT INTO `sys_role_permission` VALUES ('1', '13');
INSERT INTO `sys_role_permission` VALUES ('1', '14');
INSERT INTO `sys_role_permission` VALUES ('1', '15');
INSERT INTO `sys_role_permission` VALUES ('1', '16');
INSERT INTO `sys_role_permission` VALUES ('1', '17');
INSERT INTO `sys_role_permission` VALUES ('1', '18');
INSERT INTO `sys_role_permission` VALUES ('1', '19');
INSERT INTO `sys_role_permission` VALUES ('1', '20');
INSERT INTO `sys_role_permission` VALUES ('1', '21');
INSERT INTO `sys_role_permission` VALUES ('1', '22');
INSERT INTO `sys_role_permission` VALUES ('1', '23');
INSERT INTO `sys_role_permission` VALUES ('1', '24');
INSERT INTO `sys_role_permission` VALUES ('14', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '5');
INSERT INTO `sys_role_permission` VALUES ('14', '6');
INSERT INTO `sys_role_permission` VALUES ('14', '7');
INSERT INTO `sys_role_permission` VALUES ('14', '8');
INSERT INTO `sys_role_permission` VALUES ('14', '9');
INSERT INTO `sys_role_permission` VALUES ('14', '10');
INSERT INTO `sys_role_permission` VALUES ('14', '11');
INSERT INTO `sys_role_permission` VALUES ('14', '12');
INSERT INTO `sys_role_permission` VALUES ('14', '13');
INSERT INTO `sys_role_permission` VALUES ('15', '1');
INSERT INTO `sys_role_permission` VALUES ('15', '14');
INSERT INTO `sys_role_permission` VALUES ('15', '15');
INSERT INTO `sys_role_permission` VALUES ('15', '16');
INSERT INTO `sys_role_permission` VALUES ('15', '17');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `isAdmin` int(11) DEFAULT NULL,
  `disabled` int(1) DEFAULT NULL COMMENT '是否禁用 0 显示 1 禁用',
  `password` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `loginName` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '2016-05-08 18:09:55', 'wangzihao@ihbaby.com', '0', '0', 'D76F8F2AE5D01D8162F45CED516B2CB3BFA29861', 'admin', 'admin', '2016-08-02 16:47:10');
INSERT INTO `sys_user` VALUES ('2', '2016-06-24 16:31:19', '635480802@qq.com', '0', '0', '094B93C3AFBF7C50264796C145D144AC15638471', '王春玺', '15522571815', '2016-08-02 13:58:40');
INSERT INTO `sys_user` VALUES ('4', '2016-07-22 09:58:18', '', '0', '1', '6D0E8E2E1A860A537B58EA7A3EB2EA099A5D573E', '流星', '15522571816', null);
INSERT INTO `sys_user` VALUES ('5', '2016-08-02 11:12:14', 'heyinxuan@ihbaby.com', '0', '0', '0FF63ECC6472A2A342DF7F10AF28EFC22E8EDB50', '何音璇', '18310138069', null);
INSERT INTO `sys_user` VALUES ('6', '2016-08-02 11:12:56', 'maligai@ihbaby.com', '0', '0', '8F1E52AB521CDF07B65AE75B6E7B023EEE19CAAC', '马立改', '18801496199', null);
INSERT INTO `sys_user` VALUES ('7', '2016-08-02 11:13:28', 'liwenyu@ihbaby.com', '0', '0', 'A0FF76D2102AE8C6889399B1A6FC1FBC3D5FB263', '李文宇', '18601296524', '2016-08-03 11:49:05');
INSERT INTO `sys_user` VALUES ('8', '2016-08-02 16:46:05', 'wangzihao@ihbaby.com', '0', '0', 'B32010F99EC14AFC42EC00901464D723FC27B252', '王子豪', '18600005672', '2016-08-03 11:49:00');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '15');
INSERT INTO `sys_user_role` VALUES ('5', '14');
INSERT INTO `sys_user_role` VALUES ('6', '14');
INSERT INTO `sys_user_role` VALUES ('7', '14');
INSERT INTO `sys_user_role` VALUES ('8', '1');
