CREATE TABLE `third_party_brands` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '修改人',
  `del_flag` tinyint(2) NOT NULL DEFAULT 1 COMMENT '删除标识，0：删除，1：未删除',
  `brand_name` varchar(50) NOT NULL COMMENT '商户名称',
  `brand_industry` tinyint(2) NOT NULL COMMENT '所属行业',
  `contact` varchar(50) NOT NULL COMMENT '联系人',
  `contact_phone` varchar(20) NOT NULL COMMENT '联系电话',
  `contact_email` varchar(255) DEFAULT NULL COMMENT '联系邮箱',
  `brand_username` varchar(255) NOT NULL COMMENT '商户账号',
  `brand_password` varchar(255) NOT NULL COMMENT '账户密码',
  `expire_date` datetime NOT NULL COMMENT '有效期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COMMENT='第三方商户'