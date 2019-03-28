drop table IF EXISTS `t_product_category`;
drop table IF EXISTS `t_product_info`;
drop table IF EXISTS `t_order`;
drop table IF EXISTS `t_order_detail`;

create table t_product_category(
 `category_id` int not null primary key auto_increment comment '类目ID',
 `category_name` varchar(32) not null comment '类名名称',
 `create_time` timestamp not null comment '创建时间',
 `update_time` timestamp comment '修改时间'
) comment '商品类目表';

create table t_product_info(
  `product_id` int not null primary key auto_increment comment '商品ID',
  `product_name` varchar(32) not null comment '商品名称',
  `product_stock` int not null comment '商品库存',
  `product_desc` varchar(64) comment '商品描述',
  `product_price` decimal (10,2) not null comment '商品价格',
  `product_pic` varchar(64) not null comment '商品图片',
  `category_id` int not null comment '类目ID',
  `create_time` timestamp not null comment '创建时间',
  `update_time` timestamp  comment '修改时间'
) comment '商品表';

create table t_order(
  `order_id` varchar(32) not null primary key comment '订单ID',
  `user_id` varchar(32) not null comment '用户ID',
  `buyer_name` varchar(32) not null  comment '收件人',
  `buyer_phone` varchar(32) not null  comment '收件人电话',
  `buyer_address` varchar(128) not null  comment '收件地址',
  `order_amount` decimal (10,2) not null comment '订单金额',
  `order_status` varchar(2) not null  comment '订单状态',
  `pay_status` varchar(2) not null  comment '付款状态',
  `create_time` timestamp not null comment '创建时间',
  `update_time` timestamp comment '修改时间'
) comment '订单主表';

create table t_order_detail(
  `order_detail_id` varchar (32) not null primary key comment '订单详情ID',
  `order_id` varchar(32) not null comment '订单ID',
  `product_id` int not null comment '商品ID',
  `product_price` decimal (10,2) not null comment '商品价格',
  `product_pic` varchar(64) not null comment '商品图片',
  `product_name` varchar(32) not null comment '商品名称',
  `product_quantity` int (3) not null comment '商品数量',
  `create_time` timestamp not null comment '创建时间',
  `update_time` timestamp  comment '修改时间'
) comment '订单子表'