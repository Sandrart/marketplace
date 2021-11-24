USE marcketplace;

-- INSERCIÓN DE LOS ARTICULOS DE LA BD
INSERT INTO `articulo` (`nombre`, `precio`, `stock`) VALUES ('TV', '500', '20');
INSERT INTO `articulo` (`nombre`, `precio`, `stock`) VALUES ('PORTATIL', '300', '10');
INSERT INTO `articulo` (`nombre`, `precio`, `stock`) VALUES ('ORDENADOR', '1500', '5');
INSERT INTO `articulo` (`nombre`, `precio`, `stock`) VALUES ('ALTAVOCES', '80', '30');
INSERT INTO `articulo` (`nombre`, `precio`, `stock`) VALUES ('AIRPODS', '200', '15');
INSERT INTO `articulo` (`nombre`, `precio`, `stock`) VALUES ('WEBCAM', '25', '20');

-- INSERCIÓN DE LOS USUARIOS
INSERT INTO `usuario` (`nombre`, `password`) VALUES ('JJ', '1234');
INSERT INTO `usuario` (`nombre`, `password`) VALUES ('marcos', '1234');
INSERT INTO `usuario` (`nombre`, `password`) VALUES ('juan', '1234');
INSERT INTO `usuario` (`nombre`, `password`) VALUES ('javier', '1234');

-- INSERTAR DATOS PEDIDO
INSERT INTO `pedido` (`fecha`,`nombre`, `usuario_id`) VALUES(curdate(),'PEIDDO USER 1', 1);
INSERT INTO `pedido` (`fecha`,`nombre`, `usuario_id`) VALUES(curdate(),'PEDIDO USER 2', 2);
INSERT INTO `pedido` (`fecha`,`nombre`, `usuario_id`) VALUES(curdate(),'PEDIDO USER 3', 3);

-- INSERT PEDIDO USUARIO 1
INSERT INTO `usuario_pedidos` (`usuario_id`, `pedidos_id`) VALUES ('1', '1');

-- INSERTS PEDIDOS ARTICULOS
INSERT INTO `pedidos_articulos` (`cantidad`, `articulo_id`, `pedido_id`) VALUES ('2', '1', '1');
INSERT INTO `pedidos_articulos` (`cantidad`, `articulo_id`, `pedido_id`) VALUES ('3', '2', '1');
INSERT INTO `pedidos_articulos` (`cantidad`, `articulo_id`, `pedido_id`) VALUES ('1', '3', '1');

-- INSERTS DE ARTICULOS EN PEDIDO
INSERT INTO `pedido_pedidos_articulos` (`pedido_id`, `pedidos_articulos_id`) VALUES ('1', '1');
INSERT INTO `pedido_pedidos_articulos` (`pedido_id`, `pedidos_articulos_id`) VALUES ('1', '2');
INSERT INTO `pedido_pedidos_articulos` (`pedido_id`, `pedidos_articulos_id`) VALUES ('1', '3');



