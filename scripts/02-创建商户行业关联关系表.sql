CREATE TABLE `third_party_brands_industry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '修改人',
  `del_flag` tinyint(2) NOT NULL DEFAULT 1 COMMENT '删除标识，0：删除，1：未删除',
  `brand_industry` tinyint(2) NOT NULL COMMENT '所属行业',
	`brand_id` bigint(20) NOT NULL COMMIT '商户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COMMENT='第三方商户所属行业表'